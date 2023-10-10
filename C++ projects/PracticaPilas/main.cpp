#include <iostream>

using namespace std;

const int max_e = 100;

template <class T>

class Nodo
{
    T clave;
    Nodo <T>* proximo;
    Nodo <T>* previo;

    public:
        Nodo(){proximo = previo = nullptr;}
        void fijarClave(T x)
        {
            clave = x;
        }

        T obtenerClave(){return clave;}
        void fijarProximo(Nodo <T>* x){proximo = x;}
        Nodo <T>* obtenerProximo(){return proximo;}
        void fijarPrevio(Nodo <T>* x){previo = x;}
        Nodo <T>* obtenerPrevio(){return previo;}
};

template <class T>

class ListaDobleCircular
{
    Nodo <T>* s;

    public:
        ListaDobleCircular()
        {
            s = new Nodo <T> ();
            s->fijarProximo(s);
            s->fijarPrevio(s);
        }

        void insertar(Nodo <T>* x)
        {
            x->fijarProximo(s->obtenerProximo());
            s->obtenerProximo()->fijarPrevio(x);
            s->fijarProximo(x);
            x->fijarPrevio(s);
        }

        Nodo <T>* buscar(T x)
        {
            Nodo <T>* aux = s->obtenerProximo();

            while(aux != s && aux->obtenerClave() != x)
                aux = aux->obtenerProximo();

            return aux;
        }

        void eliminar(T x)
        {
            Nodo <T>* aux = buscar(x);

            if (aux != s)
            {
                Nodo <T>* aux2 = aux->obtenerProximo();

                aux->obtenerPrevio()->fijarProximo(aux2);
                aux2->fijarPrevio(aux->obtenerPrevio());
                cout << "Se ha eliminado el nodo. \n";
                delete aux;
            }

            else
                cout << "El nodo no se encuentra. \n";
        }
};

int main()
{
    ListaDobleCircular <int> ldc;
    char op = '0';

    do
    {
        cout << "What to do? \n1.Agregar. \n2.Eliminar. \n3.Salir, \nOpcion: ";
        cin >> op;

        switch(op)
        {
            case '1':
            {
                int aux = 0;
                cout << "Ingrese clave: ";
                cin >> aux;
                Nodo <int>* n = new Nodo <int> ();
                n->fijarClave(aux);
                ldc.insertar(n);
                break;
            }

            case '2':
            {
                int aux = 0;
                cout << "Ingrese valor a buscar: ";
                cin >> aux;
                ldc.eliminar(aux);
                break;
            }

            case '3':
                break;

            default:
                cerr << "Opcion invalida. Intente de nuevo. \n";
        }
    } while (op != '3');
    return 0;
}
