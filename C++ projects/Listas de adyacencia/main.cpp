#include <iostream>
#include <string>
#include <cmath>

using std :: cin;
using std :: cout;
using std :: cerr;
using std :: string;
using std :: endl;
using std :: to_string;

const short int factorCarga = 4;
const short int m = 30;

enum Excepcion
{
    Error = 0
};

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

        void setClave(T x){clave = x;}
        T getClave(){return clave;}
        void setProximo(Nodo <T>* k){proximo = k;}
        Nodo <T>* getProximo(){return proximo;}
        void setPrevio(Nodo <T>* d){previo = d;}
        Nodo <T>* getPrevio(){return previo;}
};

template <class T>

class ListaDoble
{
    Nodo <T>* inicio;

    public:
        ListaDoble()
        {
            inicio = nullptr;
        }

        Nodo <T>* buscar(T x)
        {
            Nodo <T>* aux = inicio;

            while (aux != nullptr && aux->getClave() != x)
                aux = aux->getProximo();

            return aux;
        }

        void agregar(Nodo <T>* x)
        {
            x->setProximo(inicio);

            if (inicio != nullptr)
                inicio->setPrevio(x);

            inicio = x;
            x->setPrevio(nullptr);
        }

        void eliminar(T k)
        {
            Nodo <T>* aux = buscar(k);

            if (!aux)
            {
                Nodo <T>* aux2 = aux->getPrevio();

                if (!aux2)
                    aux2->setProximo(aux->getProximo());

                else
                    inicio = aux->getProximo();

                aux2 = aux->getProximo();

                if (!aux2)
                    aux2->setPrevio(aux->getPrevio());

                aux->setProximo(nullptr);
                aux->setPrevio(nullptr);
                delete aux;
                cout << "Se ha eliminado el nodo. \n";
            }

            else
                cout << "El nodo no se encuentra. \n";
        }

        bool comp(short int cant)
        {
            Nodo <T>* aux = inicio;
            short int i = 0;

            for (; aux != nullptr; aux = aux->getProximo())
                i++;

            if (i == cant)
                return true;

            else
                return false;
        }

        Nodo <T>* getInicio(){return inicio;}

        string mostrar()
        {
            string cadena = "";

            for (Nodo <T>* aux = inicio; aux != nullptr; aux = aux->getProximo())
                cadena.append(to_string(aux->getClave()) + "\n");

            return cadena;
        }
};

template <class T>

class Tabla
{
    ListaDoble <T>* ld[m];

    public:
        Tabla(){}
        int h(int k)
        {
            return k % m;
        }

        void insertar(Nodo <T>* x)
        {
            int pos = h(x->getClave());

            if (!ld[pos]->comp(factorCarga))
                ld[pos]->agregar(x);

            else
                throw Error;
        }

        void eliminar(T x)
        {
            short int pos = h(x);

            ld[pos]->eliminar(x);
        }

        string mostrarTodo()
        {
            string cadena = "";

            for (short int i = 0; i < m; i++)
            {
                if (ld[i]->getInicio() != nullptr)
                    cadena.append("La lista en la posición " + to_string(i + 1) + ": \n" + ld[i]->mostrar());
            }

            return cadena;
        }

        void radix(string cadena)
        {
            short int cant = cadena.size();
            char op = 'a';
            short int Op = cant - 1;
            short int res = 0;

            for (short int i = 0; Op >= 0; i++, Op--)
            {
                op = cadena.at(Op);
                res += (op * pow(128, i));
            }

            Nodo <T>* aux = new Nodo <T> ();
            aux->setClave(res);
            insertar(aux);
        }
};

int main()
{
    Tabla <int> t;
    char op = '0';

    do
    {
        cout << "What to do? \n1.Agregar. \n2.Eliminar. \n3.Mostrar. \n4.Salir. \nOpcion: ";
        cin >> op;

        switch(op)
        {
            case '1':
            {
                do
                {
                    cout << "Que desea agregar? \n1.Numero. \n2.Cadena. \nOpcion: ";
                    cin >> op;

                    switch(op)
                    {
                        case '1':
                        {
                            int aux = 0;
                            cout << "Ingrese valor: ";
                            cin >> aux;
                            Nodo <int>* nodo = new Nodo <int> ();
                            nodo->setClave(aux);

                            try
                            {
                                t.insertar(nodo);
                            }

                            catch (const Excepcion& e)
                            {
                                if (e == Error)
                                    cerr << "No se puede agregar mas valores a la lista. \n";
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
                                t.radix(cadena);
                            }

                            catch (const Excepcion& e)
                            {
                                if (e == Error)
                                    cerr << "No se puede agregar mas valores a la lista. \n";
                            }

                            break;
                        }
                    }
                } while (op != '1' && op != '2');

                break;
            }

            case '2':
            {
                int aux = 0;
                cout << "Ingrese valor a eliminar: ";
                cin >> aux;
                t.eliminar(aux);
                break;
            }

            case '3':
                cout << t.mostrarTodo();
                break;

            case '4':
                break;

            default:
                cerr << "Opcion invalida. Intente de nuevo \n";

        }
    } while(op != '4');

    return 0;
}
