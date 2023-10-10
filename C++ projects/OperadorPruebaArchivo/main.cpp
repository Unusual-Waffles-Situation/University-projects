#include <iostream>
#include <string>
#include <fstream>

using namespace std;

class ClaseArchivo
{
    string cadena, nombreArchivo;

    public:
        ClaseArchivo(){}
        ClaseArchivo(string s)
        {
            nombreArchivo = s;
        }

        void agregarCadena();
        void mostrar();
};

void ClaseArchivo :: agregarCadena()
{
    ofstream archivo(nombreArchivo.c_str());

            if (!archivo)
            {
                cerr << "Error al intentar abrir el archivo. \n";
                return;
            }

            cout << "Ingrese la cadena: ";
            cin >> cadena;

            archivo << cadena;
}

void ClaseArchivo :: mostrar()
{
    ifstream archivo(nombreArchivo.c_str());

    if (!archivo)
    {
        cerr << "Error al intentar abrir el archivo. \n";
        return;
    }

    while(archivo >> cadena)
    {
        int res = 0;
        string aux, aux1;
        aux = aux1 = "";
        for (char i = 0; ; i++)
        {
            if (isdigit(cadena.at(i)))
                aux.at(i) = cadena.at(i);

            else if (!isdigit(cadena.at(i)))
            {
                while (i < cadena.at(i))
                {
                    i++;
                    if (isdigit(cadena.at(i)))
                        break;
                }

                while (i < cadena.size())
                {
                    i++;
                    aux1 = cadena.at(i);
                }
            }
        }

        int a, b;
        a = std :: stoi(aux);
        b = std :: stoi(aux1);

        for (char i = 0; i < cadena.size(); i++)
        {
            if (cadena.at(i) == '+')
                res = a + b;

            else if (cadena.at(i) == '-')
                res = a - b;

            else if (cadena.at(i) == '*')
                res = a * b;

            else if (cadena.at(i) == '/')
                res = a / b;

        }

        cout << "El resultado es " << res;
    }
}

int main()
{
    ClaseArchivo ca("Archivo.data");
    ca.agregarCadena();

    try
    {
        ca.mostrar();
    }

    catch (...)
    {
        cerr << "Ha ocurrido un error";
    }

    return 0;
}
