#include <iostream>
#include <fstream>

using std :: cout;
using std :: cin;
using std :: string;
using std :: ifstream;
using std :: endl;
using std :: cerr;

/*class Arcos
{
    string nombreArchivo, nombreVertice;
    int peso;
    //string nombreVertice;
    Arcos *proximoArco;

    public:
        Arcos()
        {
            nombreArchivo = nombreVertice = "";
            peso = 0;
            proximoArco = nullptr;
        }

        void setNombreArchivo(string k){nombreArchivo = k;}
        string getNombreArchivo(){return nombreArchivo;}
        void setPeso(int d){peso = d;}
        int getPeso(){return peso;}
        void setNombreVertice(string x){nombreVertice = x;}
        string getNombreVertice(){return nombreVertice;}
        Arcos* getProximoArco(){return proximoArco;}
        void setProximoArco(Arcos *x){proximoArco = x;}

        ~Arcos(){}
};

class Vertices
{
    string nombreVertice;
    Vertice *proximoVertice;
    Arcos *proximoArco;

    public:
        Vertices()
        {
            nombreVertice = "";
            proximoArco = proximoVertice = nullptr;
        }

        void setNombreVertice(string k){nombreVertice = k;}
        string getNombreVertice(){return nombreVertice;}
        void setProximoArco(Arcos *d){proximoArco = d;}
        Arcos* getProximoArco(){return proximoArco;}
        void setProximoVertice(Vertices *h){proximoVertice = h;}
        Vertices* getProximoVertice(){return proximoVertice;}
        ~Vertices(){}
};

class Grafo
{
    Vertices *inicio;

    public:
        Grafo(){inicio = nullptr;}
        void agregarVertice(Vertices *x);
        Vertices* buscarVertice(string k);
        //Arcos* buscarArco(string d);
        void agregarArco(string salida, string entrada, int p, string na);
        ~Grafo(){}
};

void Grafo :: agregarVertice(Vertices *x)
{
    x->setProximoVertice(inicio);
    inicio = x;
};

Vertices* Grafo :: buscarVertice(string k)
{
    Vertices aux = inicio;

    while(aux != nullptr && aux->getNombreVertice() != k)
        aux = aux->getProximoVertice();

    return aux;
};

Arcos* Grafo :: buscarArco(string d)
{
    Arcos aux
}

void Grafo :: agregarArco(string salida, string entrada, int p, string na)
{

};*/

enum Excepcion
{
    ErrorLista = 0,
    Error = 0
};

const int max_V = 100;
const int max_A = 100;

/*class Grafo_MatrizDeAdyacencia
{
    int Ac[max_V][max_A];
    int n, m;
    string nombreArchivo;

    public:
        Grafo_MatrizDeAdyacencia(const int n, const int m)
        {
            nombreArchivo "Archivo.txt";
            this.n = n;
            this.m = m;

            for (short int d = 0; d < n; d++)
            {
                for (short int k = 0; k < m; k++)
                {
                    Ac[d][k] = 0;
                }
            }
        }

        void cargarGrafo();
        void eliminarVertice(const int v);
        void eliminarArco(const int a);
};

void Grafo_MatrizDeAdyacencia :: cargarGrafo()
{
    ifstream archivo(nombreArchivo.c_str());

    if (!archivo)
        throw ErrorLista;

    short int j, k, i;
    j = k = i = 0;

    while (archivo >> i)
    {
        if (i == m)
        {
            i = 0;
            k++;
        }

        Ac[k][i] = i;
        i++;
    }
};

void Grafo_MatrizDeAdyacencia :: eliminarVertice(const int v)
{
    if (v > n)
        throw Error;


};*/

class Grafo_MatrizDeIncidencia
{
    int Ac[max_V][max_A];
    int n, m;
    string nombreArchivo;

    public:
        Grafo_MatrizDeIncidencia(const int n, const int m)
        {
            nombreArchivo = "Archivo.txt";
            this->n = n;
            this->m = m;

            for (short int i = 0; i < n; i++)
            {
                for (short int j = 0; j < m; j++)
                {
                    Ac[i][j] = 0;
                }
            }
        }

        void cargarGrafo();
        void eliminarVertice(const int v);
        void eliminarArco(const int a);
        int cantidadVerticesAislados();
};

void Grafo_MatrizDeIncidencia :: cargarGrafo()
{
    ifstream archivo (nombreArchivo.c_str());

    if (!archivo)
        throw ErrorLista;

    short i, j, k;
    i = j = k = 0;

    while (archivo >> i)
    {
        if (k == m)
        {
            k = 0;
            j++;
        }

        Ac[j][k] = i;
        k++;
    }
};

void Grafo_MatrizDeIncidencia :: eliminarVertice(const int ve)
{
    if (ve > n)
        throw Error;

    short int v, a;
    v = a = 0;

    for (; a < m; a++)
    {
        for (; v < n; v++)
        {
            for (short int v2 = 0; v2 < n; v2++)
            {
                if ((Ac[v][a] != 0 && Ac[v2][a] != 0) && (v2 == ve - 1))
                {
                    Ac[v][a] = 0;
                    Ac[v2][a] = 0;
                }
            }
        }

        v = 0;
    }

};

void Grafo_MatrizDeIncidencia :: eliminarArco(const int a)
{
    if (a > m)
        throw Error;

    short int i = 0;

    while(i != n)
    {
        Ac[i][a] = 0;
        i++;
    }
};

int Grafo_MatrizDeIncidencia :: cantidadVerticesAislados()
{
    int cant = 0;

    for (short int i = 0; i < n; i++)
    {
        int aux = 0;

        for (short int j = 0; j < m; j++)
        {
            if (Ac[i][j] == 0)
                aux++;
        }

        if (aux == m)
            cant++;
    }

    return cant;
};

int main()
{
    Grafo_MatrizDeIncidencia mi(6, 9);
    char op = 0;

    do
    {
        cout << "What to do? \n1.Agregar. \n2.Eliminar. \n3.Mostrar cantidad de vertices aislados. \n4.Salir. \nOpcion: ";
        cin >> op;

        switch(op)
        {
            case '1':
                try
                {
                    mi.cargarGrafo();
                }

                catch (const Excepcion& e)
                {
                    if (e == ErrorLista)
                        cerr << "Ha ocurrido un error intentando abrir el archivo. \n";
                }

                break;

            case '2':
                do
                {
                    cout << "Que desea eliminar? \n1.Vertice. \n2.Arco. \n3.Salir. \nOpcion: ";
                    cin >> op;

                    switch(op)
                    {
                        case '1':
                        {
                            int aux = 0;
                            cout << "Ingrese vertice que desea elimianr: ";
                            cin >> aux;

                            try
                            {
                                mi.eliminarVertice(aux);
                            }

                            catch (const Excepcion& e)
                            {
                                if (e == Error)
                                    cerr << "El vertice no se encuentra. \n";
                            }

                            break;
                        }

                        case '2':
                        {
                            int aux = 0;
                            cout << "Ingrese arco que desea elimianr: ";
                            cin >> aux;

                            try
                            {
                                mi.eliminarArco(aux);
                            }

                            catch (const Excepcion& e)
                            {
                                if (e == Error)
                                    cerr << "El arco no se encuentra. \n";
                            }

                            break;
                        }

                        case '3':
                            break;

                        default:
                            cerr << "Opcion invalida. Intente de nuevo. \n";
                    }
                } while(op == '1' && op == '2' && op == '3');

                break;

            case '3':
                cout << "La cantidad de vertices aislados que se encuentran en el grafo son de " << mi.cantidadVerticesAislados() << endl;
                break;

            case '4':
                break;

            default:
                cerr << "Opcion invalida. Intente de nuevo. \n";

        }
    } while(op != '4');
    return 0;
}
