#include <iostream>
#include <fstream>
#include <string>

using namespace std;

void arreglarCadena(string& s)
{
    for (unsigned char i = 0; i < s.size(); i++)
    {
        if (s.at(i) == ' ')
            s.at(i) = '_';

        s.at(i) = toupper(s.at(i));
    }
}

short int metodo(string s)
{
    unsigned short int contador, cont;
    contador = cont = 0;
    bool comp = false;

    for (unsigned char i = 0; i < s.size(); i++)
    {
        if (!isalpha(s.at(i)))
        {
            comp = true;
            if (contador % 2 == 0)
            {
                cont++;
                contador = 0;
            }
        }

        contador++;
    }

    if (!comp && contador % 2 == 0)
    {
        return ++cont;
    }

    else
    {
        if (cont != 0)
            return cont + 1;

        else
            return 0;
    }
}

/*bool verificar(string s)
{
    for (unsigned char i = 0; i < s.size(); i++)
    {
        if (!isalpha(s.at(i) && (s.at(i) != '_')))
        return true;
    }

    return false;
}*/

class Archivo
{
    string cadena, nombreArchivo;

    public:
        Archivo(){}

        Archivo(string s)
        {
            nombreArchivo = s;
        }

        void leerArchivo();

        string getNombreArchivo(){return nombreArchivo;}
};

void Archivo :: leerArchivo()
{
    int cant = 0;
    ifstream archivo(nombreArchivo.c_str());

    if (!archivo)
    {
        cerr << "Error al intentar abrir el archivo. \n";
        return;
    }

    if (archivo.is_open())
    {
        while (getline (archivo, cadena))
        {
            arreglarCadena(cadena);

            /*if (verificar(cadena))
            {
                cerr << "Solo debe incluir letras, no numeros. \n";
                break;
            }*/

            cant = metodo(cadena);
        }

        cout << "Las palabras con letras pares son de " << cant;

        archivo.close();
    }
}

int main()
{
    Archivo a("Cadenas.txt");
    a.leerArchivo();

    /*ofstream cerrar(a.getNombreArchivo(), ios_base :: trunc);
    cerrar.close();*/
    return 0;
}
