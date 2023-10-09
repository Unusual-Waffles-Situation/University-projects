#include <iostream>
#include <fstream>
#include <string>

using std::cin;
using std::cout;
using std::cerr;
using std::string;
using std::ifstream;
using std::ios;
using std::endl;
using std::to_string;

enum Excepcion
{
    Error = 0
};

struct Valores
{
    short int cadenaAux;
};

class Operaciones
{
    unsigned char ancho, altura;
    char sustitucionCero, sustitucionUno;
    string nombreArchivo, cadena;

    public:
        Operaciones(string x)
        {
            ancho = altura = 0;
            sustitucionCero = sustitucionUno = 'a';
            nombreArchivo = x;
            cadena = "";
        }

        void leerArchivo(Valores &v)
        {
            ifstream archivo(nombreArchivo.c_str(), ios::binary | ios::app);

            if (!archivo)
                throw Error;

            short int cant = 0;

            //archivo.seekg((long) 0, ios :: end);

            if (archivo.is_open())
            {
                while(!archivo.eof())
                {
                    /*if (cant < 4)
                    {*/
                        archivo.read(reinterpret_cast <char*>(&v), sizeof(Valores));

                        cadena.append(to_string(v.cadenaAux) + "\n");

                        /*cant++;
                    }*/

                    /*else
                    {
                        for (unsigned char i = 0; i < cadena.size(); i++)
                        {
                            if (ancho == 0)
                                ancho = cadena.at(i);

                            else if (altura == 0)
                                altura = cadena.at(i);

                            else if (sustitucionCero == 'a')
                                sustitucionCero = cadena.at(i);

                            else
                                sustitucionUno = cadena.at(i);
                        }
                    }*/


                }
            }

            cout << cadena << "\n" << cant << endl;

            archivo.close();

            cout << "Ancho: " << to_string(ancho) << "\nAltura: " << to_string(altura) << "\nSustitucion de cero: " << sustitucionCero << "\nSustitucion de uno: " << sustitucionUno << endl;

            /*cadena = "";
            unsigned char cant = 0;

            if (archivo2.is_open())
            {
                while (!archivo2.eof())
                {
                    archivo2.read(reinterpret_cast <char*>(cadena), sizeof(ancho));

                    if (cant == ancho)
                    {
                        cout << "\n";
                        cant = 0;
                    }

                    else if (cadena == "0")
                        cout << sustitucionCero;

                    else if (cadena == "1")
                        cout << sustitucionUno;

                    cant++;
                }
            }*/
        }
};

int main()
{
    Operaciones o("Prueba.txt");
    Valores v;


    try
    {
        o.leerArchivo(v);
    }

    catch (const Excepcion &e)
    {
        if (e == Error)
            cerr << "Ha ocurrido un error intentando abrir el archivo. \n";
    }

    return 0;
}
