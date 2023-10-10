#include <iostream>
#include <string>

using std::cin;
using std::cout;
using std::cerr;
using std::string;
using std::to_string;

const unsigned char max_e = 10;

enum Excepcion
{
    Error = 0
};

template <class T>

class Nodo
{
    T clave;
    Nodo <T>* previo;
    Nodo <T>* proximo;

    public:
        Nodo()
        {
            clave = 0;
            previo = proximo = nullptr;
        }

        void setClave(T x){clave = x;}
        T getClave(){return clave;}
        void setProximo(Nodo <T>* x){proximo = x;}
        Nodo <T>* getProximo(){return proximo;}
        void setPrevio(Nodo <T>* x){previo = x;}
        Nodo <T>* getPrevio(){return previo;}
};

template <class T>

class Pila
{
    Nodo <T>* p[max_e];
    T tope;

    public:
        Pila()
        {
            tope = -1;
        }

        void push(Nodo <T>* x);

        bool pilaVacia();

        Nodo <T>* pop();
};

template <class T>

void Pila <T>::push(Nodo <T>* x)
{
    p[tope++] = x;
};

template <class T>

bool Pila <T>::pilaVacia()
{
    if (tope == -1)
        return true;

    else
        return false;
};

template <class T>

Nodo <T>* Pila <T>::pop()
{
    T aux = tope;
    tope--;

    return p[aux];
};

template <class T>

class ListaDobleCircular
{
    Nodo <T>* nodoSentinela;

    public:
        ListaDobleCircular()
        {
            nodoSentinela->setPrevio(nodoSentinela);
            nodoSentinela->setProximo(nodoSentinela);
        }

        void ingresar(Nodo <T>* x);

        Nodo <T>* buscar(T k);

        bool eliminar(T k);

        string mostrar();

        void invertirLista();

        ~ListaDobleCircular();
};

template <class T>

void ListaDobleCircular <T>::ingresar(Nodo <T>* x)
{
    if (x->getClave() < nodoSentinela->getProximo()->getClave())
    {
        x->setProximo(nodoSentinela->getProximo());
        nodoSentinela->getProximo()->setPrevio(x);
        nodoSentinela->setProximo(x);
        x->setPrevio(nodoSentinela);
    }

    else
    {
        Nodo <T>* aux = nodoSentinela->getProximo();
        Nodo <T>* aux2 = aux->getProximo();

        if (aux2 == nodoSentinela)
        {
            aux->setProximo(x);
            x->setProximo(nodoSentinela);
            x->setPrevio(aux);
        }

        else
        {
            bool comp = false;

            while (aux2 != nodoSentinela)
            {
                if (x->getClave() < aux2->getClave())
                {
                    aux->setProximo(x);
                    x->setPrevio(aux);
                    x->setProximo(aux2);
                    comp = true;
                    break;
                }

                else if (aux2->getClave() == nodoSentinela->getProximo()->getClave())
                    break;

                aux = aux->getProximo();
                aux2 = aux2->getProximo();

                if (aux2 == nodoSentinela)
                    aux2 = nodoSentinela->getProximo();
            }

            if (!comp)
            {
                aux->setProximo(x);
                x->setPrevio(aux);
                x->setProximo(nodoSentinela);
            }
        }
    }

};

template <class T>

Nodo <T>* ListaDobleCircular <T>::buscar(T k)
{
    Nodo <T>* nodoAux = nodoSentinela->getProximo();

    while(nodoAux != nodoSentinela && k != nodoAux->getClave())
        nodoAux = nodoAux->getProximo();

    return nodoAux;
};

template <class T>

bool ListaDobleCircular <T>::eliminar(T k)
{
    Nodo <T>* aux = buscar(k);

    if (aux != nodoSentinela)
    {
        aux->getProximo()->setPrevio(aux->getPrevio());
        aux->getPrevio()->setProximo(aux->getProximo());
        return true;
    }

    else
        return false;
};

template <class T>

void ListaDobleCircular <T>::invertirLista()
{
    Pila <T> p;

    for (Nodo <T>* aux = nodoSentinela->getProximo(); aux != nodoSentinela; aux = aux->getProximo())
        p.push(aux);

    Nodo <T>* nodo = nodoSentinela;

    for (Nodo <T>* aux = p.pop(); ;)
    {
        if (p.pilaVacia())
            break;

        else
        {
            nodo->setProximo(aux);
            aux->setPrevio(nodo);
            nodo = nodo->getProximo();
            aux = p.pop();
        }
    }
};

template <class T>

string ListaDobleCircular <T>::mostrar()
{
    string cadena = "";

    for (Nodo <T>* aux = nodoSentinela->getProximo(); aux != nodoSentinela; aux = aux->getProximo())
        cadena.append(to_string(aux->getClave()) + "\n");

    return cadena;
};

template <class T>

ListaDobleCircular <T>::~ListaDobleCircular()
{
    for (Nodo <T>* x = nodoSentinela->getProximo(); x != nodoSentinela;)
    {
        Nodo <T>* aux = x;
        x = x->getProximo();
        aux->setPrevio(nullptr);
        aux->setProximo(nullptr);
        delete aux;
    }

    nodoSentinela->setPrevio(nullptr);
    nodoSentinela->setProximo(nullptr);

    delete nodoSentinela;
};

int main()
{
    ListaDobleCircular <int> ldc;
    char opc = '0';

    do
    {
        cout << "Que desea hacer? \n1.Agregar. \n2.Eliminar. \n3.Mostrar. \n4.Invertir lista. \n5.Salir. \nOpcion: ";
        cin >> opc;

        switch (opc)
        {
            case '1':
            {
                short int clave = 0;

                cout << "Ingrese clave: ";
                cin >> clave;

                Nodo <int>* nodo = new Nodo <int> ();
                nodo->setClave(clave);

                ldc.ingresar(nodo);

                cout << "Se ha ingresado el nodo. \n\n";

                break;
            }

            case '2':
            {
                short int clave = 0;

                cout << "Ingrese clave a eliminar: ";
                cin >> clave;

                if (ldc.eliminar(clave))
                    cout << "Se ha eliminado el nodo. \n\n";

                else
                    cout << "La clave no se encuentra. \n\n";

                break;
            }

            case '3':
                cout << ldc.mostrar() << "\n\n";
                break;

            case '4':
                ldc.invertirLista();
                cout << "Se ha invertido la lista. \n\n";
                break;

            case '5':
                break;

            default:
                cerr << "Opcion invalida. Intente de nuevo. \n\n";
        }
    } while(opc != '5');

    return 0;
}
