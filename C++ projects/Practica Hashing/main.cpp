#include <iostream>
#include <fstream>
#include <cmath>
#include <string>

using std :: cin;
using std :: cout;
using std :: endl;
using std :: string;
using std :: to_string;
using std :: cerr;
using std :: ifstream;
using std :: getline;

const int m = 30;

enum Excepcion
{
    ErrorLista = 0,
    ListaLlena = 0
};

class Persona
{
    string nombre, apellido;
    int ci;

    public:
        Persona(string n, string a, int c)
        {
            nombre = n;
            apellido = a;
            ci = c;
        }

        Persona()
        {
            nombre = apellido = "";
            ci = 0;
        }

        void setNombre(string c){nombre = c;}
        void setApellido(string k){apellido = k;}
        void setCI(int d){ci = d;}

        int getCI(){return ci;}
        string getNombre(){return nombre;}
        string getApellido(){return apellido;}
};

template <class T>

class Nodo
{
    T clave;
    Nodo <T>* proximo;
    Nodo <T>* previo;
    Persona p;

    public:
        Nodo()
        {
            clave = 0;
            proximo = previo = nullptr;
            p = new Persona();
        }

        void fijarClave(T x){clave = x;}
        T obtenerClave(){return clave;}
        void fijarProximo(Nodo <T>* k){proximo = k;}
        Nodo <T>* obtenerProximo(){return proximo;}
        void fijarPrevio(Nodo <T>* d){previo = d;}
        Nodo <T>* obtenerPrevio(){return previo;}
        void setPersona(Persona x){p = x;}
};

template <class T>

class ListaDoble
{
    Nodo <T>* inicio;

    public:
        ListaDoble(){inicio = nullptr;}
        void agregar(Nodo <T>* x)
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

            while(aux != nullptr && aux->obtenerClave())
                aux = aux->obtenerProximo();

            return aux;
        }

        bool comp(T x)
        {
            short int cant = 0;

            for (Nodo <T>* aux = inicio; aux != nullptr; aux = aux->obtenerProximo())
                cant++;

            if (cant == x)
                return true;

            else
                return false;
        }

        void eliminar(T x)
        {
            Nodo <T>* aux = buscar(x);

            if (!aux)
            {
                Nodo <T>* aux2 = aux->obtenerPrevio();

                if (!aux2)
                    aux2->fijarProximo(aux->obtenerProximo());

                else
                    inicio = aux->obtenerProximo();

                aux2 = aux->obtenerProximo();

                if (!aux2)
                    aux2->fijarPrevio(aux->obtenerPrevio());

                aux->fijarPrevio(nullptr);
                aux->fijarProximo(nullptr);
                delete aux;

                cout << "Se eliminó el nodo. \n";
            }

            else
                cout << "No se encontró el nodo. \n";
        }

        string mostrar()
        {
            string cadena = "";

            for (Nodo <T>* aux = inicio; aux != nullptr; aux = aux->obtenerProximo())
                cadena.append(to_string(aux->obtenerClave()) + "\n");

            return cadena;
        }

        Nodo <T>* obtenerInicio(){return inicio;}
};

template <class T>

class Tabla
{
    ListaDoble <T>* ld[m];
    short int cantidadAlpha;
    string nombreArchivo;

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

        Nodo <T>* arreglarCadena(string x, T c)
        {
            short int cant = x.size();
            Nodo <T>* nodo = new Nodo <T> ();
            string nombre, apellido;
            nombre = apellido = "";
            int ci = c;

            for (short int i = 0; i < cant; i++)
            {
                if (x.at(i) == ' ')
                {
                    string cadena = "";

                    for (short int j = 0; j < i; j++)
                        cadena.append(to_string(x.at(j)));

                    if (nombre == "")
                        nombre = cadena;

                    else
                        apellido = cadena;
                }
            }

            Persona p = new Persona();
            p.setNombre(nombre);
            p.setApellido(apellido);
            p.setCI(ci);
            nodo->setPersona(p);

            nodo->fijarClave(ci);

            return nodo;
        }

        void agregar()
        {
            ifstream archivo(nombreArchivo.c_str());

            if (!archivo)
                throw ErrorLista;

            else
            {
                string nombre = "";

                T x = 0;

                while (archivo >> nombre >> x)
                {
                    Nodo <T>* nodo;

                    /*int pos = h(x);

                    Nodo <T>* nodo = new Nodo <int> ();
                    nodo->fijarClave(x);
                    ld[pos]->agregar(nodo);*/

                    getline(archivo, nombre);

                    nodo = arreglarCadena(nombre, x);

                    int pos = h(nodo->obtenerClave());

                    ld[pos]->agregar(nodo);
                }
            }
        }

        void insertar(Nodo <T>* x)
        {
            int pos = h(x->obtenerClave());

            if (ld[pos]->comp(cantidadAlpha))
                throw ListaLlena;

            else
                ld[pos]->agregar(x);
        }

        void eliminar(T x)
        {
            int pos = h(x);

            ld[pos]->eliminar(x);
        }

        bool buscar(T x)
        {
            int pos = h(x);

            if (ld[pos]->buscar(x))
                return true;

            else
                return false;
        }

        T metodoRadix(string cadena)
        {
            short int cant = cadena.size();
            char op = 'a';
            short int ind = cant - 1;
            T res = 0;

            for (int i = 0; i < cant; ind--, i++)
            {
                op = cadena.at(ind);
                res += op * pow(128, i);
            }

            Nodo <T>* aux = new Nodo <T> ();
            aux->fijarClave(res);
            h(res);
            return res;
        }

        string mostrarTodo()
        {
            string cadena = "";

            for (int i = 0; i < m; i++)
            {
                if (ld[i]->obtenerInicio() != nullptr)
                    cadena.append("La lista #" + to_string(i) + "\n" + ld[i]->mostrar());
            }

            return cadena;
        }
};

int main()
{
    Tabla <int> t;

    try
    {
        t.agregar();
    }

    catch(const Excepcion& e)
    {
        if (e == ErrorLista)
            cerr << "Ha ocurrido un error intentando abrir la lista. \n";
    }

    cout << t.mostrarTodo();
    /*char op = '0';

    do
    {
        cout << "¿Qué desea hacer? \n1.Agregar. \n2.Eliminar. \n3.Buscar. \n4.Mostrar. \n5.Salir. \nOpción: ";
        cin >> op;

        switch(op)
        {
            case '1':
            {
                do
                {
                    cout << "¿Qué desea agregar? \n1.Números. \n2.Cadena. \n3.Salir. \nOpción: ";
                    cin >> op;

                    switch(op)
                    {
                        case '1':
                        {
                            int aux = 0;
                            cout << "Ingrese valor: ";
                            cin >> aux;
                            Nodo <int>* nodo = new Nodo <int> ();
                            nodo->fijarClave(aux);

                            try
                            {
                                t.insertar(nodo);
                            }

                            catch (const Excepcion& e)
                            {
                                if (e == ListaLlena)
                                    cerr << "No se puede agregar más valores en la lista. \n";
                            }

                            cout << "Se agregó el valor. \n";
                            break;
                        }

                        case '2':
                        {
                            string cadena = "";
                            cout << "Ingrese cadena: ";
                            cin >> cadena;
                            t.metodoRadix(cadena);
                            break;
                        }

                        case '3':
                            break;

                        default:
                            cerr << "Opción invalida. Intente de nuevo. \n";
                    }
                } while(op == '1' && op == '2' && op == '3');

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
            {
                int aux = 0;
                cout << "Ingrese valor a buscar: ";
                cin >> aux;
                if (t.buscar(aux))
                    cout << "El valor se encontró. \n";

                else
                    cout << "El valor no se encontró. \n";

                break;
            }

            case '4':
                cout << t.mostrarTodo();
                break;

            case '5':
                break;

            default:
                cerr << "Opción invalida. Intente de nuevo. \n";

        }

    } while(op != '5');*/

    return 0;
}
