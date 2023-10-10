#include <iostream>

using namespace std;

const int max_e = 100;

enum Excepcion
{
    Under = 0,
    Over = 1
};

template <class T>

class Pila
{
    T s[max_e];
    int tope, inicio;

    public:
        Pila(){tope = -1; inicio = 0;}
        T pop()
        {
            if (pilaVacia())
            {
                cout << "La pila está vacia." << endl;
                return Under;
            }

            tope--;
            return s[tope + 1];
        }

        void push(T x)
        {
            if (tope == (max_e - 1))
                return;

            else
            {
                if (tope == -1)
                {
                    inicio = x;
                }

                tope++;
                s[tope] = x;
            }
            /*s[tope] = s[tope] + 1;
            s[tope[s]] = x;*/
        }

        bool pilaVacia()
        {
            if (tope == -1)
                return true;

            else
                return false;
        }

        int mostrar()
        {
            if (tope == -1)
            {
                inicio = 0;
                return inicio;
            }

            else
                return inicio;
        }
};

int main()
{
    Pila <int> p;
    char op = 0;
    int num = 0;
    do
    {
        cout << "What you want to do? \n1.Agregar. \n2.Eliminar. \n3.Mostrar. \n4.Salir. \nOpcion: ";
        cin >> op;
        switch(op)
        {
            case '1':
                cout << "Ingrese numero: ";
                cin >> num;
                p.push(num);
                break;

            case '2':
                p.pop();
                break;

            case '3':
                cout << p.mostrar() << endl;
                break;

            case '4':
                break;

            default:
                cerr << "Opcion invalida. Intente de nuevo. " << endl;
        }
    } while(op != '4');
    return 0;
}
