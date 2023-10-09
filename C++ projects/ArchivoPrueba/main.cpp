#include <iostream>
#include <fstream>
#include <string>
#include <sstream>

using namespace std;

// Cambia los espacios en pisos, ya que se puede poner necio con los espacios

void nuevaCadena(string& s)
{
    for (unsigned short int i = 0; i < s.size(); i++)
    {
        if (s.at(i) == ' ')
            s.at(i) = '_';
    }

    for (unsigned char i = 0; i < s.size(); i++)
    {
        s.at(i) = toupper(s.at(i));
    }
}

// Regresa la cantidad de comas en la oracion

char metodoCantidadDeComas(string& s)
{
    char cantidad = 0;

    for (unsigned char k = 0; k < s.size(); k++)
    {
        if (s.at(k) == ',')
            cantidad++;
    }

    return cantidad;
}

class GestorInventario
{
    float precio;
    string nombreArchivo, nombreProducto;
    int cantidad;
    short int cant;

    public:
        GestorInventario()
        {
            precio = 0;
            cant = 0;
            cantidad = 0;
            nombreArchivo = "";
        }

        GestorInventario(string s)
        {
            nombreArchivo = s;
            cant = 0;
        }

        void editar(string s, int c);

        bool comprobar(string s);

        bool eliminar(string s);

        bool compNumeros(string s);

        bool compLetras(int c, float f);

        void FijarNombreArchivo(string s)
        {
            nombreArchivo = s;
        }

        void MostrarInventario()
        {
            ifstream archivo;
            archivo.open(nombreArchivo.c_str(), ios :: in);

            if (!archivo)
            {
                cerr << "Error al intentar abrir el archivo " << nombreArchivo << endl;
                return;
            }

            while(archivo >> nombreProducto >> cantidad >> precio)
            {
                cout << "\nProducto: " << nombreProducto << endl;
                cout << "Cantidad: " << cantidad << endl;
                cout << "Precio: " << precio << endl;
            }
        }

        // Esta forma no es una forma correcta de hacer el agregar. Ni se por que lo hice de esa forma, lel

        void AgregarProducto()
        {
            bool comp, compR;
            comp = compR = false;
            fstream archivo(nombreArchivo.c_str(), ios :: out | ios :: app);

            if (!archivo)
            {
                cerr << "Error al intentar abirir el archivo " << nombreArchivo << endl;
                return;
            }

            cin.ignore();
            do
            {
                comp = false;
                cout << "Producto: ";
                getline(cin, nombreProducto);

                if (nombreProducto.empty())
                {
                    cerr << "Cadena vacia. \n";
                    comp = true;
                }

                if (compNumeros(nombreProducto))
                {
                    cout << "El nombre no deberia tener numeros. \n";
                    cin.clear();
                    cin.ignore();
                    comp = true;
                }
            } while(comp);

            nuevaCadena(nombreProducto);

            cout << "Cantidad: ";
            cin >> cantidad;

            cout << "Precio: ";
            cin >> precio;

            archivo << nombreProducto << ' ' << cantidad << ' ' << precio << endl;
            cant++;

            cout << "Se ha agregado el producto. \n";
        }

        short int getCant(){return cant;}
        string getNombreA(){return nombreArchivo;}
};

void GestorInventario :: editar(string s, int c)
{
    fstream aux(nombreArchivo.c_str());
    stringstream ss;
    string cadenaAux = "";
    int cantAux = 0;
    float floatAux = 0.0;

    while(aux >> cadenaAux >> cantAux >> floatAux)
    {
        if (cadenaAux.compare(s) == 0)
        {
            ss << cadenaAux << ' ' << c << ' ' << floatAux << endl; // El ss (stringstream) es para ir almacenando lo que esta contenido en el archivo en algo aparte
        }

        ss << cadenaAux << ' ' << cantAux << ' ' << floatAux << endl;
    }

    aux.close();
    aux.open(nombreArchivo.c_str(), ios :: out); // No es necesario que se especifique el "ios::out" aqui, pero welp
    aux << ss.str(); // El archivo original se iguala al ss y deberia quedar editado
}

// El metodo eliminar ignora la linea que se quiere eliminar

bool GestorInventario :: eliminar(string s)
{
    fstream aux(nombreArchivo.c_str());
    stringstream ss;
    bool comp = false;
    string cadenaAux = "";
    int cantAux = 0;
    float floatAux = 0;

    nuevaCadena(s);

    while(aux >> cadenaAux >> cantAux >> floatAux)
    {
        if (cadenaAux.compare(s) == 0)
        {
            comp = true;
        }

        else
            ss << cadenaAux << ' ' << cantAux << ' ' << floatAux << endl;
    }

    if (!comp)
    {
        return comp;
    }

    else
    {
        aux.close();
        aux.open(nombreArchivo.c_str(), ios :: out);
        aux << ss.str();
        return comp;
    }
}

bool GestorInventario :: compNumeros(string s)
{
    for (unsigned char i = 0; i < s.size(); i++)
    {
        if (!isalpha(s.at(i)) && s.at(i) == '_')
            return true;
    }

    return false;
}

bool GestorInventario :: compLetras(int c, float f)
{
    string aux = "";
    if (f == 0)
        aux = std :: to_string(c);

    else
        aux = std :: to_string(f);
    for (unsigned char i = 0; i < aux.size(); i++)
    {
        if (isalpha(aux.at(i)))
            return true;
    }

    return false;
}

int main()
{
    GestorInventario gi("Inventario.data");
    unsigned short int op = 0;

    do
    {
        cout << "¿Que desea hacer? \n1.Agregar un producto. \n2.Mostrar inventario. \n3.Eliminar algun producto. \n4.Editar algun producto. \n5.Salir. \nOpcion: ";
        cin >> op;
        switch(op)
        {
            case 1:
                gi.AgregarProducto();
                break;

            case 2:
                if (gi.getCant() != 0)
                    gi.MostrarInventario();

                    else
                        cerr << "Debe haber al menos un producto antes de mostrar. \n";
                break;

            case 3:
                if (gi.getCant() != 0)
                {
                    string aux = "";
                    cout << "Los productos que se encuentran son: ";
                    gi.MostrarInventario();
                    cout << "Ingrese el nombre del producto que desea eliminar: ";
                    cin >> aux;
                    if (gi.eliminar(aux))
                        cout << "Se ha eliminado el producto. \n";

                    else
                        cout << "El producto no se encuentra. \n";

                }

                else
                    cerr << "Debe haber al menos un producto antes de eliminar. \n";
                break;

            case 4:
            {
                string aux = "";
                int cantidadNueva = 0;

                cout << "Ingrese nombre del producto a editar: ";
                cin >> aux;

                cout << "Ingrese nueva cantidad: ";
                cin >> cantidadNueva;

                gi.editar(aux, cantidadNueva);
                break;
            }

            case 5:
                break;

            default:
                cerr << "Opcion invalida. Intente de nuevo. \n";
        }
    } while(op != 4);

    // Elimina el archivo al cerrar el programa

    ofstream ofile(gi.getNombreA(), ios_base :: trunc);
    ofile.close();

    return 0;
}
