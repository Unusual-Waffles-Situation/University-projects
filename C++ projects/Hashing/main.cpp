#include <iostream>
#include <cmath>
#include <fstream>
#include <sstream>

using namespace std;

enum Excepcion
{
    ListaLlena = 0,
    ErrorLista = 0
};

const int m = 30;

template <class T>

class Nodo
{
    T clave;
    Nodo <T>* proximo;
    Nodo <T>* previo;

    public:
        Nodo()
        {
            clave = 0;
            proximo = previo = nullptr;
        }

        void fijarClave(T x){clave = x;}
        T obtenerClave(){return clave;}
        void fijarProximo(Nodo <T>* k){proximo = k;}
        Nodo <T>* obtenerProximo(){return proximo;}
        void fijarPrevio(Nodo <T>* d){previo = d;}
        Nodo <T>* obtenerPrevio(){return previo;}
};

class Dato
{
    int valor = 0;

    public:
        Dato(){valor = 0;}
        void fijarValor(int x){valor = x;}
        int obtenerValor(){return valor;}
};

template <class T>

class ListaDoble
{
    public: Nodo <T>* inicio;

    public:
        ListaDoble(){inicio = nullptr;}

        void insertar(Nodo <T>* x)
        {
            x->fijarProximo(inicio);

            if (inicio != nullptr)
                inicio->fijarPrevio(x);

            inicio = x;
            x->fijarPrevio(nullptr);
        }

        Nodo <T>* buscar(T x)
        {
            Nodo <T>* aux = inicio;

            while (aux != nullptr && aux->obtenerClave() != x)
                aux = aux->obtenerProximo();

            return aux;
        }

        bool comp(short int cant)
        {
            Nodo <T>* aux = inicio;
            short int i = 0;

            for (; aux != nullptr; aux = aux->obtenerProximo())
                i++;

            if (i == cant)
                return true;

            else
                return false;

        }

        void eliminar(T x)
        {
            Nodo <T>* aux = buscar(x);

            if (aux != nullptr)
            {
                Nodo <T>* aux2 = aux->obtenerPrevio();

                if (aux2 != nullptr)
                    aux2->fijarProximo(aux->obtenerProximo());

                else
                    inicio = aux->obtenerProximo();

                aux2 = aux->obtenerProximo();

                if (aux2 != nullptr)
                    aux2->fijarPrevio(aux->obtenerPrevio());

                aux->fijarPrevio(nullptr);
                aux->fijarProximo(nullptr);
                delete aux;
                cout << "Se ha eliminado la clave. \n";
            }

            else
                cerr << "La clave no se encuentra. \n";
        }

        string mostrar()
        {
            string cadena = "";

            for (Nodo <T>* aux = inicio; aux != nullptr; aux = aux->obtenerProximo())
                cadena.append(to_string(aux->obtenerClave()) + "\n");

            return cadena;
        }

        void fijarInicio(Nodo <T>* k){inicio = k;}
        Nodo <T>* obtenerInicio(){return inicio;}
};

template <class T>

class Tabla
{
    //Nodo <T>* x[m];
    short int cantidadAlpha;
    string nombreArchivo;
    ListaDoble <T> ld[m];

    public:
        Tabla()
        {
            cantidadAlpha = 4;
            nombreArchivo = "Cadena.txt";
        }

        int h(int x)
        {
            return x % m;
        }

        void agregar(Nodo <T>* x)
        {
            ofstream archivo(nombreArchivo.c_str());

            if (!archivo)
                throw ErrorLista;

            else
            {
                archivo << x->obtenerClave() << ' ' << "\n";

                insertar(x);
            }
        }

        void agregarRadix(string cadena)
        {
            ofstream archivo(nombreArchivo.c_str());

            if (!archivo)
                throw ErrorLista;

            else
                archivo << metodoRadix(cadena) << " (Palabra original: " << cadena << ") " << "\n";
        }

        void insertar(Nodo <T>* x)
        {
            int pos = h(x->obtenerClave());

            if (ld[pos].comp(cantidadAlpha))
                throw ListaLlena;

            else
                ld[pos].insertar(x);
        }

        void eliminar(T x)
        {
            int pos = h(x);

            ld[pos].eliminar(x);
        }

        int metodoRadix(string cadena)
        {
            int cant, res, a;
            cant = cadena.size();
            res = 0;
            a = cant - 1;
            char op = 'a';

            for (int i = 0; a >= 0; a--, i++)
            {
                op = cadena.at(a);
                res += op * pow(128, i);
            }

            Nodo <T>* aux = new Nodo <T> ();
            aux->fijarClave(res);
            insertar(aux);

            return res;
        }

        void buscar(T x)
        {
            int pos = h(x);

            if (ld[pos].buscar(x))
                cout << "El numero se encuentra. \n";

            else
                cout << "El numero no se encuentra. \n";
        }

        string mostrarTodo()
        {
            string cadena = "";

            for (int i = 0; i < 30; i++)
            {
                if (ld[i].inicio != nullptr)
                {
                    cadena.append("La lista #" + to_string(i) + "\n");
                    cadena.append(ld[i].mostrar());
                }
            }

            return cadena;
        }
};

int main()
{
    Tabla <int> t;

    char op = '0';

    do
    {
        cout << "What to do? \n1.Agregar. \n2.Eliminar. \n3.Buscar. \n4.Mostrar. \n5.Salir. \nOpcion: ";
        cin >> op;

        switch(op)
        {
            case '1':
            {
                char operacion = '0';

                do
                {
                    cout << "Que desea ingresar? \n1.Numero. \n2.Cadena. \nOpcion: ";
                    cin >> operacion;

                    switch(operacion)
                    {
                        case '1':
                        {
                            int aux = 0;
                            cout << "Ingrese valor: ";
                            cin >> aux;
                            Nodo <int>* n = new Nodo <int> ();
                            n->fijarClave(aux);
                            try
                            {
                                t.agregar(n);
                            }

                            catch (const Excepcion& e)
                            {
                                if (e == ListaLlena)
                                    cerr << "No se puede agregar mas elementos a la lista. \n";

                                else if (e == ErrorLista)
                                    cerr << "Ha ocurrido un error en abrir la lista. \n";
                            }

                            break;
                        }

                        case '2':
                        {
                            string cadena = "";
                            cout << "Ingrese cadena: ";
                            cin >> cadena;

                            try
                            {
                                t.agregarRadix(cadena);
                            }

                            catch (const Excepcion& e)
                            {
                                if (e == ErrorLista)
                                    cerr << "Ha ocurrido un error en la lista. \n";

                                else if (e == ListaLlena)
                                    cerr << "La lista esta llena. \n";
                            }

                            //t.metodoRadix(cadena);

                            break;
                        }

                        default:
                            cerr << "Opcion invalida. Intente de nuevo .\n";
                    }
                } while(operacion == 1 && operacion == 2);

                break;
            }

            case '2':
            {
                int aux = 0;
                cout << "Ingrese valor que desea eliminar: ";
                cin >> aux;
                t.eliminar(aux);
                break;
            }

            case '3':
            {
                int aux = 0;
                cout << "Ingrese valor a buscar: ";
                cin >> aux;
                t.buscar(aux);
                break;
            }

            case '4':
                cout << t.mostrarTodo();
                break;

            case '5':
                break;

            default:
                cerr << "Opcion invalida. Intente de nuevo. \n";
        }
    } while(op != '5');
    return 0;
}
