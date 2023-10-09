#include <iostream>
#include <fstream>
#include <string>

using std::cin;
using std::cout;
using std::string;
using std::cerr;
using std::ifstream;
using std::ofstream;
using std::getline;
using std::to_string;
using std::endl;

const short int max_e = 200;

bool arreglarCadena(string &s)
{
    string primeraPalabra, segundaPalabra;
    primeraPalabra = segundaPalabra = "";

    bool flag, finPrimeraPalabra;
    flag = finPrimeraPalabra = false;

    for (unsigned char i = 0; i < s.size(); i++)
    {
        if (s.at(i) >= '0' && s.at(i) <= '9')
        {

            cout << "Es un numero. \n";
            i++;
        }

        else
        {
            if (s.at(i) == ' ')
                s.at(i) = 8;

            else if (s.at(i) == '<' && flag == false)
            {
                s.at(i) = 8;
                flag = true;
            }

            else if (s.at(i) == '>' && flag == true)
            {
                s.at(i) = '\n';
                flag = false;
                finPrimeraPalabra = true;
            }

            //primeraPalabra += s.at(i);

            else if (flag && !finPrimeraPalabra)
                primeraPalabra += s.at(i);

            else if (flag && finPrimeraPalabra)
            {
                segundaPalabra += s.at(i);
                cout << segundaPalabra << endl;
            }
        }
    }

    //cout << primeraPalabra << "\n" << segundaPalabra << endl;

    string palabraAux = "";
    palabraAux = "/" + primeraPalabra;

    //cout << palabraAux << endl;

    if (segundaPalabra.compare(palabraAux) == 0)
        return true;

    else
        return false;
}

bool comprobarNumeros(string &s)
{
    for (unsigned char i = 0; i < s.size(); i++)
    {
        if (s.at(i) >= '0' && s.at(i) <= '9')
            return true;
    }

    return false;
}

enum Excepcion
{
    ErrorLleno = 0,
    ErrorVacio = 0,
    ErrorLista = 0
};

class Pila
{
    string s[max_e];
    int tope;
    string inicio;

    public:
        Pila()
        {
            tope = 0;
            inicio = "";
        }

        void push(string x);
        void eliminarSeguidas(string a);
        bool pilaVacia();
};

void Pila::eliminarSeguidas(string a)
{
    if (pilaVacia())
        throw ErrorVacio;

    for (short int i = 0; i < tope; i++)
    {
        if (s[i].compare(a) == 0)
        {
            tope--;
            break;
        }
    }
};

void Pila::push(string x)
{
    if (tope == (max_e - 1))
        throw ErrorLleno;

    if (tope == 0)
    {
        inicio = x;
    }

    tope++;
    s[tope] = x;
};

bool Pila::pilaVacia()
{
    if (tope == 0)
        return true;

    else
        return false;
};

class ClaseComprobar
{
    string nombreArchivo, cadena;
    Pila p;

    public:
        ClaseComprobar()
        {
            nombreArchivo = cadena = "";
        }

        ClaseComprobar(string x)
        {
            nombreArchivo = x;
            cadena = "";
        }

        bool leerArchivo();
};

bool ClaseComprobar::leerArchivo()
{
    string arreglo[max_e];
    string palabra, palabraAux, palabraComp;
    short int cantidad = 0;
    palabra = palabraAux = palabraComp = "";
    bool comp = false;

    ifstream archivo(nombreArchivo.c_str());

    if (!archivo)
        throw ErrorLista;

    if (archivo.is_open())
    {
        while(!archivo.eof())
        {
            archivo >> cadena;

            if (!comprobarNumeros(cadena))
            {
                //cout << cadena << endl;
                palabra = cadena;
                //cout << cadena << endl;

                if (palabraAux != "")
                {
                    palabraComp = "/" + palabraAux;


                    if (palabraComp.compare(palabra) == 0)
                    {
                        cout << palabraAux << endl;
                        p.eliminarSeguidas(palabraAux);
                        comp = true;
                        cantidad--;
                    }

                    palabraComp = "";
                }

                if (!comp)
                {
                    palabraAux = palabra;
                    arreglo[cantidad++] = palabraAux;
                    p.push(cadena);
                    comp = false;
                }

                else if (comp)
                {
                    palabraAux = arreglo[cantidad];
                    //cout << palabraAux << endl;
                    comp = false;
                }
            }

        }

        archivo.close();

        cout << cantidad << endl;
    }

    if (p.pilaVacia())
            return true;

    else
        return false;
};

int main()
{
    ClaseComprobar cp("entrada.xml");
    bool comp = false;

    try
    {
        comp = cp.leerArchivo();
    }

    catch(const Excepcion &e)
    {
        if (e == ErrorLista)
            cerr << "Hubo un error intentando abrir el archivo. \n";

        else if (e == ErrorLleno)
            cerr << "La pila se encuentra llena. \n";

        else if (e == ErrorVacio)
            cerr << "La pila se encuentra vacia. \n";

    }

    if (comp)
        cout << "El archivo esta correctamente estructurado. \n";

    else
        cout << "El archivo no esta correctamente estructurado. \n";

    return 0;
}
