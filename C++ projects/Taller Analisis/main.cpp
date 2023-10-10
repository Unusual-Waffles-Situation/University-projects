#include <iostream>
#include <fstream>
#include <chrono>

using std::cin;
using std::cout;
using std::ifstream;
using std::string;
using std::endl;
using std::cerr;

const char cantidadTotal = 10;

bool archivoVacio(ifstream& ar)
{
    return ar.peek() == std::ifstream::traits_type::eof();
}

enum Excepcion
{
    ErrorLista = 0,
    Error = 0
};

class Archivo
{
    string nombreArchivo;/*, nombreArchivo2, nombreArchivo3;*/

    /*, arreglo2[cantidadTotal], arreglo3[cantidadTotal];*/

    public:

    Archivo(string na/*, string na2, string na3*/)
    {
        nombreArchivo = na;
        /*nombreArchivo2 = na2;
        nombreArchivo3 = na3;*/
    }

    int leerArchivo(int arreglo[]);
};

int Archivo::leerArchivo(int arreglo[])
{
    ifstream archivo(nombreArchivo.c_str());
    /*ifstream archivo2(nombreArchivo2.c_str());
    ifstream archivo3(nombreArchivo3.c_str());*/

    // Asegurarse que todos los árchivos estén correctos

    if (!archivo)
        throw ErrorLista;

    else if (archivoVacio(archivo))
        throw Error;

    /*if ((!archivo && !archivo2 && !archivo3) || (archivo && !archivo2 && !archivo3) || (archivo && archivo2 && !archivo3)
        || (!archivo && archivo2 && !archivo3) || (!archivo && archivo2 && archivo3) ||
        (!archivo && !archivo2 && archivo3) || (archivo && !archivo2 && archivo3))
        throw ErrorLista;

    // Asegurarse que ningún árchivo esté vacio

    else if ((archivo.is_empty() && archivo2.is_empty() && archivo3.is_empty()) || (archivo.is_empty() && !archivo2.is_empty() && !archivo3.is_empty())
             || (archivo.is_empty() && archivo2.is_empty() && !archivo3.is_empty()) || (archivo.is_empty() && !archivo2.is_empty() && archivo3.is_empty())
             || (!archivo.is_empty() && archivo2.is_empty() && !archivo3.is_empty()) || (!archivo.is_empty() && !archivo2.is_empty() && archivo3.is_empty())
             || (!archivo.is_empty() && archivo2.is_empty() && archivo3.is_empty()))
        throw Error;*/

    int variable = 0;

    short i = 0;

    // Se llena el arreglo 1

    while (archivo >> variable)
    {
        arreglo[i++] = variable;
    }

    int arregloAux[i];

    for (char k = 0; k < i; k++)
    {
        arregloAux[k] = arreglo[k];
    }

    arreglo = arregloAux;

    return i;

    // Se llena el arreglo 2

    /*variable = 0;

    i = 0;

    while (archivo2 >> variable)
    {
        arreglo2[i++] = variable;
    }

    // Se llena el arreglo 3

    variable = 0;

    i = 0;

    while (archivo3 >> variable)
    {
        arreglo3[i] = variable;
    }*/
};

// Método de inserción

void metodoOrdenarInsercion(int arreglo[], int cantidad)
{
    int j, temporal;

    for (int i = 0; i < cantidad; i++)
    {
        j = i;

        while (j > 0 && arreglo[j] < arreglo[j - 1])
        {
            temporal = arreglo[j];
            arreglo[j] = arreglo[j - 1];
            arreglo[j - 1] = temporal;
            j--;
        }
    }
}

// Funciones para el método QuickSort

void swap(int* a, int* b)
{
    int t = *a;
    *a = *b;
    *b = t;
}

int particion(int arreglo[], int low, int high)
{
    int eje = arreglo[high];
    int i = (low - 1);

    for (char j = low; j <= high - 1; j++)
    {
        if (arreglo[j] <= eje)
        {
            i++;
            swap(&arreglo[i], &arreglo[j]);
        }
    }

    swap(&arreglo[i + 1], &arreglo[high]);

    return (i + 1);
}

// Método QuickSort

void metodoQuickSort(int arreglo[], int low, int high)
{
    if (low < high)
    {
        int pi = particion(arreglo, low, high);

        metodoQuickSort(arreglo, low, pi - 1);
        metodoQuickSort(arreglo, pi + 1, high);
    }
}

int main()
{
    Archivo a("Archivo.txt");

    int arreglo[cantidadTotal];

    int cantidad = 0;

    try
    {
        cantidad = a.leerArchivo(arreglo);
    }

    catch (const Excepcion& e)
    {
        if (e == ErrorLista)
            cerr << "Ha ocurrido un error intentando abrir el árchivo. \n";

        else if (e == Error)
            cerr << "El árchivo está vacio. \n";
    }

    // Método de inserción

    auto inicio = std::chrono::system_clock::now();

    metodoOrdenarInsercion(arreglo, cantidad);

    auto fin = std::chrono::system_clock::now();

    std::chrono::duration<double> duracion = fin - inicio;

    // Método QuickSort

    cout << duracion.count() << endl;

    //metodoQuickSort(arreglo, 0, cantidad - 1);

    for (char i = 0; i < cantidad; i++)
        cout << arreglo[i] << endl;
}
