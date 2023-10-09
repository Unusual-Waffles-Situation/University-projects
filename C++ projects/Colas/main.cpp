#include <iostream>

using namespace std;

const int max_e = 100;

enum Excepcion
{
    Over = 1,
    Under = 0
};

template <class T>

class Cola
{
    T q[max_e];
    int primero, ultimo;

    public:
        Cola(){primero = ultimo = 0;}

        int EnQueue(T x)
        {
            if (colaLlena())
                return Over;

            else
            {
                q[ultimo] = x;
                if (ultimo == (max_e - 1))
                    ultimo = 0;

                else
                    ultimo++;

                return 9;
            }
        }

        T DeQueue()
        {
            if (colaVacia())
                return Under;

            else
            {
                //T x = q[primero];
                if (primero == (max_e - 1))
                    primero = 0;

                else
                    primero++;

                return q[primero - 1];
            }
        }

        bool colaVacia()
        {
            return primero == ultimo;
        }

        bool colaLlena()
        {
            if (ultimo == (max_e))
                return true;

            else
                return false;
        }
};

int main()
{
    Cola <int> c;
    char op = 0;
    int valor = 0;

    do
    {
        cout << "What to do? \n1.Agregar. \n2.Retirar. \n3.Salir. \nOpcion: ";
        cin >> op;

        switch(op)
        {
            case '1':
                cout << "Ingrese valor: ";
                cin >> valor;
                if (c.EnQueue(valor) == 1)

                    cerr << "La cola esta llena. \n";
                break;

            case '2':
                if (c.DeQueue() == 0)
                    cerr << "La pila esta vacia. \n";

                else
                    cout << "Ha salido el valor numero '" << c.DeQueue() << "' de la cola. \n";
                break;

            case '3':
                break;

            default:
                cerr << "Opcion invalida. Intente de nuevo. \n";
        }
    } while(op != '3');
    return 0;
}
