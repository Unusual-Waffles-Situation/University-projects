#include <iostream>

const int max_e = 100;

enum Excepcion
{
    Under = 0,
    Over = 1
};

using namespace std;

template <class T>

class Pila
{
    T s[max_e];
    int tope, inicio;

    public:
        Pila(){tope = inicio = 0;}

        T pop()
        {
            if (pilaVacia())
            {
                cout << "La pila esta vacia. \n";
                return Under;
            }

            else
            {
                tope--;
                return s[tope + 1];
            }
        }

        void push(int x)
        {
            if (tope == (max_e - 1))
            {
                cout << "La pila esta llena. \n";
                //return Over;
            }

            else
            {
                if (tope == -1)
                    inicio = x;

                tope++;
                s[tope] = x;
            }
        }

        bool pilaVacia()
        {
            if (tope == inicio)
                return true;

            else
                return false;
        }
};

int main()
{
    Pila <int> p;
    Pila <int> par;
    Pila <int> impar;
    char op = 0;
    int valor, aux;
    valor = aux = 0;

    do
    {
        cout << "What to do? \n1.Agregar. \n2.Ordenar. \n3.Salir. \nOpcion: ";
        cin >> op;

        switch(op)
        {
            case '1':
                cout << "Ingrese valor: ";
                cin >> valor;
                p.push(valor);
                break;

            case '2':
                aux = p.pop();
                if (aux > 0)
                    par.push(aux);

                else
                    impar.push(aux);
                break;

            case '3':
                break;

            default:
                cerr << "Opcion invalida. Intente de nuevo. \n";
        }
    } while(op != '3');

    return 0;
}
