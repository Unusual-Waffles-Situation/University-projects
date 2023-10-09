#include <iostream>
#include <fstream>
#include <string>
#include <sstream>

using namespace std;

struct cad
{
    int cant;
};

class Archivo
{
    string cadena, nombreArchivo;

    public:

        Archivo(){}
        Archivo(string s)
        {
            nombreArchivo = s;
        }

        void agregar(cad c);

        string leer(cad c);

        bool eliminar(int aux);

        bool editar(int aux, int aux2);

        string getNombreArchivo(){return nombreArchivo;}
};

void Archivo :: agregar(cad c)
{
    ofstream archivo(nombreArchivo.c_str(), ios :: binary | ios :: app);

    if (!archivo)
    {
        cerr << "Error al intentar abrir el archivo. \n";
    }

    archivo.write(reinterpret_cast <char*>(&c), sizeof(c));
}

string Archivo :: leer(cad c)
{
    ifstream archivo(nombreArchivo.c_str(), ios :: binary);

    if (!archivo)
    {
        string aux = "Error al intentar abrir el archivo. \n";
        return aux;
    }

    archivo.seekg((long) 0, ios :: end);
    int tamanoArchivo = archivo.tellg() / sizeof(cad);

    archivo.seekg(0, ios :: beg);
    string numeros = "Numeros: \n";

    for (int i = 0; i < tamanoArchivo; i++)
    {
        archivo.read(reinterpret_cast <char*>(&c), sizeof(cad));
        numeros.append(to_string(c.cant) + "\n");
    }

    return numeros;
}

bool Archivo :: eliminar(int aux)
{
    stringstream ss;
    cad c;
    fstream archivo(nombreArchivo.c_str());

    if (!archivo)
    {
        cerr << "Error al intentar abrir el archivo. \n";
        return false;
    }

    archivo.seekg((long) 0, ios :: end);
    int cantidad = archivo.tellg() / sizeof(cad);

    archivo.seekg(0, ios :: beg);
    bool com = false;

    int cant = 0;

    for (int i = 0; i < cantidad; i++)
    {
        archivo.read(reinterpret_cast <char*>(&c), sizeof(cad));

        if (c.cant != aux)
            ss << c.cant << endl;

        else
            com = true;

    }

    if (com)
    {
        archivo.close();
        archivo.open(nombreArchivo.c_str(), ios :: out | ios :: binary);

        while (ss >> c.cant)
            archivo.write(reinterpret_cast <char*>(&c), sizeof(cad));

        return true;
    }

    else
        return false;
}

bool Archivo :: editar(int aux, int aux2)
{
    stringstream ss;
    cad c;
    fstream archivo(nombreArchivo.c_str());

    if (!archivo)
    {
        cerr << "Error al intentar abrir el archivo. \n";
        return false;
    }

    bool comp = false;
    int nuevoNumero = 0;

    archivo.seekg((long) 0, ios :: end);
    int cantidad = archivo.tellg() / sizeof(cad);

    archivo.seekg(0, ios :: beg);

    for (int i = 0; i < cantidad; i++)
    {
        archivo.read(reinterpret_cast <char*>(&c), sizeof(cad));

        if (c.cant != aux)
            ss << c.cant << endl;

        else
        {
            ss << aux2 << endl;
            comp = true;
        }

    }

    if (comp)
    {
        archivo.close();

        archivo.open(nombreArchivo.c_str(), ios :: out | ios :: binary);

        while (ss >> c.cant)
        {
            archivo.write(reinterpret_cast <char*>(&c), sizeof(cad));
        }
        return true;
    }


    else
        return false;


}

int main()
{
    Archivo a("Pruebas.txt");
    cad c;
    char op = 0;

    do
    {
        cout << "Que desea hacer? \n1.Agregar. \n2.Mostrar. \n3.Editar. \n4.Eliminar. \n5.Salir. \nOpcion: ";
        cin >> op;
        switch(op)
        {
            case '1':
                cout << "Ingrese cadena: ";
                cin >> c.cant;

                a.agregar(c);
                break;

            case '2':
                cout << a.leer(c) << endl;
                break;

            case '3':
            {
                int aux, aux2;
                aux = aux2 = 0;
                cout << a.leer(c) << endl << "Ingrese el numero que desea editar: ";
                cin >> aux;
                cout << "Ingerse nuevo numero: ";
                cin >> aux2;

                if (a.editar(aux, aux2))
                    cout << "Se ha editado el numero. \n";

                else
                    cout << "El numero no se encuentra. \n";

                break;
            }

            case '4':
            {
                int aux = 0;
                cout << a.leer(c) << endl << "Ingrese el numero que desea eliminar: ";
                cin >> aux;

                if (a.eliminar(aux))
                    cout << "Se ha eliminado el numero. \n";

                else
                    cout << "El numero no se encuentra. \n";

                break;
            }

            case '5':
                break;

            default:
                cerr << "Opcion invalida. \n";
        }
    } while (op != '5');

    //system("pause");

    /*ofstream cerrar (a.getNombreArchivo().c_str(), ios_base :: trunc);
    cerrar.close();*/

    return 0;
}
