#include <iostream>
#include <fstream>

using std::cin;
using std::cout;
using std::cerr;
using std::string;
using std::endl;
using std::to_string;
using std::ifstream;

/*enum Excepcion
{
    Error = 0
};

const short int cantidadVertice = 10;
const short int cantidadArcos = 20;

//Matriz adyacencia no dirigido

class MatrizAdyacenciaNoDirigido
{
    short int Ac[cantidadVertice][cantidadArcos];
    short int n;
    string nombreArchivo;

    public:
        MatrizAdyacenciaNoDirigido(short int n)
        {
            nombreArchivo = "Archivo3.txt";
            this->n = n;

            for (short int k = 0; k < n; k++)
            {
                for (short int d = 0; d < n; d++)
                {
                    Ac[k][d] = 0;
                }
            }
        }

        void cargarGrafo();

        short int cantidadBucles();

        short int cantidadVerticesAislados();

        short int cantidadVerticesPendulo();

        void mostrar();
};

void MatrizAdyacenciaNoDirigido::cargarGrafo()
{
    ifstream archivo(nombreArchivo.c_str());

    if (!archivo)
        throw Error;

    short int d, k, i;
    d = k = i = 0;

    while (archivo >> i)
    {
        if (k == n)
        {
            k = 0;
            d++;
        }

        Ac[d][k] = i;
        k++;
    }
};

short int MatrizAdyacenciaNoDirigido::cantidadBucles()
{
    short int cantidad = 0;

    for (short int k = 0; k < n; k++)
    {
        for (short int d = 0; d < n; d++)
        {
            if (d == k)
            {
                if (Ac[k][d] == 1)
                    cantidad++;
            }
        }
    }

    return cantidad;
};

short int MatrizAdyacenciaNoDirigido::cantidadVerticesAislados()
{
    short int cantidad = 0;
    char aux = 0;

    for (short int k = 0; k < n; k++)
    {
        for (short int d = 0; d < n; d++)
        {
            if (Ac[k][d] == 1)
                aux++;
        }

        if (aux == 0)
            cantidad++;

        aux = 0;
    }

    return cantidad;
};

short int MatrizAdyacenciaNoDirigido::cantidadVerticesPendulo()
{
    short int cantidad = 0;

    char aux = 0;

    for (short int k = 0; k < n; k++)
    {
        for (short int d = 0; d < n; d++)
        {
            if (Ac[k][d] == 1)
                aux++;
        }

        if (aux == 1)
            cantidad++;

        aux = 0;
    }

    return cantidad;
};

void MatrizAdyacenciaNoDirigido::mostrar()
{
    for (short int k = 0; k < n; k++)
    {
        for (short int d = 0; d < n; d++)
        {
            cout << Ac[k][d] << " ";
        }

        cout << "\n";
    }

    cout << "\n\n";
};

int main()
{
    MatrizAdyacenciaNoDirigido mand(6);

    try
    {
        mand.cargarGrafo();
    }

    catch (const Excepcion &e)
    {
        if (e == Error)
            cerr << "Ha ocurrido un error intentando abrir el archivo. \n\n";
    }

    cout << "La cantidad de bucles es de " << mand.cantidadBucles() << endl;

    cout << "La cantidad de vertices aislados es de " << mand.cantidadVerticesAislados() << endl;

    cout << "La cantidad de vertices pendulos es de " << mand.cantidadVerticesPendulo() << endl;

    mand.mostrar();

    return 0;
}*/

//Matriz incidencia dirigido

/*class MatrizIncidenciaDirigido
{
    short int Ac[cantidadVertice][cantidadArcos];
    short int n, m;
    string nombreArchivo;

    public:
        MatrizIncidenciaDirigido(short int n, short int m)
        {
            nombreArchivo = "Archivo2.txt";
            this->n = n;
            this->m = m;

            for (short int k = 0; k < n; k++)
            {
                for (short int d = 0; d < m; d++)
                {
                    Ac[k][d] = 0;
                }
            }
        }

        void cargarGrafo();

        short int cantidadArcosParalelos();

        short int cantidadArcosContradictorios();

        short int cantidadVerticesSumideros();

        short int cantidadVerticesFuentes();

        short int cantidadVerticesAislados();

        void gradoVertices();

        void mostrar();
};

void MatrizIncidenciaDirigido::cargarGrafo()
{
    ifstream archivo(nombreArchivo.c_str());

    if (!archivo)
        throw Error;

    short int d, k, i;
    d = k = i = 0;

    while (archivo >> i)
    {
        if (k == m)
        {
            k = 0;
            d++;
        }

        Ac[d][k] = i;
        k++;
    }
};

short int MatrizIncidenciaDirigido::cantidadArcosParalelos()
{
    short int cantidad = 0;
    short int pos1, pos2;
    pos1 = pos2 = 0;

    bool comp1, comp2, compPos1Uno, compPos1MenosUno, compPos2Uno, compPos2MenosUno;
    comp1 = comp2 = compPos1MenosUno = compPos1Uno = compPos2MenosUno = compPos2Uno = false;

    for (short int k = 0; k < m; k++)
    {
        short int posAux = k;

        for (short int d = 0; d < n; d++)
        {
            if (pos1 == 0)
            {
                if ((Ac[d][k] == -1) || (Ac[d][k] == 1))
                {
                    pos1 = d;

                    if (Ac[d][k] == 1)
                        compPos1Uno = true;

                    else if (Ac[d][k] == -1)
                        compPos1MenosUno = true;
                }

            }

            else if (pos2 == 0)
            {
                if ((Ac[d][k] == -1) || (Ac[d][k] == 1))
                {
                    pos2 = d;

                    if (Ac[d][k] == 1)
                        compPos2Uno = true;

                    else if (Ac[d][k] == -1)
                        compPos2MenosUno = true;
                }

            }
        }

        for (short int aux1 = 0; aux1 < m; aux1++)
        {
            short int posAux2 = aux1;

            for (short int aux2 = 0; aux2 < n; aux2++)
            {
                if (posAux2 == posAux)
                    aux1++;

                if (aux1 == m)
                    break;

                else if (aux2 == pos1)
                {
                    if (compPos1Uno)
                    {
                        if (Ac[aux2][aux1] == 1)
                            comp1 = true;
                    }

                    else if (compPos1MenosUno)
                    {
                        if (Ac[aux2][aux1] == -1)
                            comp1 = true;
                    }

                }

                else if (aux2 == pos2)
                {
                    if (compPos2Uno)
                    {
                        if (Ac[aux2][aux1] == 1)
                            comp2 = true;
                    }

                    else if (compPos2MenosUno)
                    {
                        if (Ac[aux2][aux1] == -1)
                            comp2 = true;
                    }
                }
            }

            if (comp1 && comp2)
                cantidad++;

            comp1 = comp2 = false;
        }

        pos1 = pos2 = 0;
        compPos1MenosUno = compPos1Uno = compPos2MenosUno = compPos2Uno = false;
    }

    return cantidad;
};

//No sirve

short int MatrizIncidenciaDirigido::cantidadArcosContradictorios()
{
    short int cantidad = 0;
    short int pos1, pos2;
    pos1 = pos2 = 0;

    bool comp1, comp2, compPos1Uno, compPos1MenosUno, compPos2Uno, compPos2MenosUno;
    comp1 = comp2 = compPos1MenosUno = compPos1Uno = compPos2MenosUno = compPos2Uno = false;

    for (short int k = 0; k < m; k++)
    {
        short int posAux1 = k;

        for (short int d = 0; d < n; d++)
        {
            if (pos1 == 0)
            {
                if ((Ac[d][k] == -1) || (Ac[d][k] == 1))
                {
                    pos1 = d;

                    if (Ac[d][k] == 1)
                        compPos1Uno = true;

                    else if (Ac[d][k] == -1)
                        compPos1MenosUno = true;
                }

            }

            else if (pos2 == 0)
            {
                if ((Ac[d][k] == -1) || (Ac[d][k] == 1))
                {
                    pos2 = d;

                    if (Ac[d][k] == 1)
                        compPos2Uno = true;

                    else if (Ac[d][k] == -1)
                        compPos2MenosUno = true;
                }

            }
        }

        for (short int aux1 = 0; aux1 < m; aux1++)
        {
            short int posAux2 = aux1;

            for (short int aux2 = 0; aux2 < n; aux2++)
            {
                if (posAux2 == posAux1)
                    aux1++;

                if (aux1 == m)
                    break;

                else if (aux2 == pos1)
                {
                    if (compPos1Uno)
                    {
                        if (Ac[aux2][aux1] == -1)
                            comp1 = true;
                    }

                    else if (compPos1MenosUno)
                    {
                        if (Ac[aux2][aux1] == 1)
                            comp1 = true;
                    }
                }

                else if (aux2 == pos2)
                {
                    if (compPos2Uno)
                    {
                        if (Ac[aux2][aux1] == -1)
                            comp2 = true;
                    }

                    else if (compPos2MenosUno)
                    {
                        if (Ac[aux2][aux1] == 1)
                            comp2 = true;
                    }
                }
            }

            if (comp1 && comp2)
                cantidad++;

            comp1 = comp2 = compPos1MenosUno = compPos1Uno = compPos2MenosUno = compPos2Uno = false;
        }

        pos1 = pos2 = 0;
    }

    return cantidad;
};

short int MatrizIncidenciaDirigido::cantidadVerticesAislados()
{
    short int cantidad = 0;
    char aux = 0;

    for (short int k = 0; k < n; k++)
    {
        for (short int d = 0; d < m; d++)
        {
            if ((Ac[k][d] == -1) || (Ac[k][d] == 1))
                aux++;
        }

        if (aux == 0)
            cantidad++;

        aux = 0;
    }

    return cantidad;
};

short int MatrizIncidenciaDirigido::cantidadVerticesFuentes()
{
    short int cantidad = 0;
    char auxUno, auxMenosUno;
    auxMenosUno = auxUno = 0;

    for (short int k = 0; k < n; k++)
    {
        for (short int d = 0; d < m; d++)
        {
            if (Ac[k][d] == 1)
                auxUno++;

            else if (Ac[k][d] == -1)
                auxMenosUno++;
        }

        if (auxUno >= 2 && auxMenosUno == 0)
            cantidad++;

        auxMenosUno = auxUno = 0;
    }

    return cantidad;
};

short int MatrizIncidenciaDirigido::cantidadVerticesSumideros()
{
    short int cantidad = 0;
    char auxUno, auxMenosUno;
    auxMenosUno = auxUno = 0;

    for (short int k = 0; k < n; k++)
    {
        for (short int d = 0; d < m; d++)
        {
            if (Ac[k][d] == -1)
                auxMenosUno++;

            else if (Ac[k][d] == 1)
                auxUno++;
        }

        if (auxMenosUno >= 2 && auxUno == 0)
            cantidad++;

        auxMenosUno = auxUno = 0;
    }

    return cantidad;
};

void MatrizIncidenciaDirigido::gradoVertices()
{
    short int cantidad = 0;

    for (short int k = 0; k < n; k++)
    {
        cout << "Vertice #" << k + 1 << ": ";

        for (short int d = 0; d < m; d++)
        {
            if ((Ac[k][d] == 1) || (Ac[k][d] == -1))
                cantidad++;
        }

        cout << cantidad << "\n";

        cantidad = 0;
    }

    cout << "\n\n";
};

void MatrizIncidenciaDirigido::mostrar()
{

    for (short int k = 0; k < n; k++)
    {
        for (short int d = 0; d < m; d++)
        {
            cout << Ac[k][d] << " ";
        }

        cout << "\n";
    }

    cout << "\n\n";
};

int main()
{
    MatrizIncidenciaDirigido mid(7, 11);

    try
    {
        mid.cargarGrafo();
    }

    catch (const Excepcion &e)
    {
        if (e == Error)
            cerr << "Ha ocurrido un error intentando abrir el archivo. \n\n";
    }

    cout << "La cantidad de arcos paralelos es de " << mid.cantidadArcosParalelos() << "\n\n";

    cout << "La cantidad de arcos contradictorios es de " << mid.cantidadArcosContradictorios() << "\n\n";

    cout << "La cantidad de vertices sumideros es de " << mid.cantidadVerticesSumideros() << "\n\n";

    cout << "La cantidad de vertices fuentes es de " << mid.cantidadVerticesFuentes() << "\n\n";

    cout << "La cantidad de vertices aislados es de " << mid.cantidadVerticesAislados() << "\n\n";

    mid.mostrar();

    mid.gradoVertices();

    return 0;
}*/

//Matriz de incidencia no dirigido

/*class MatrizIncidenciaNoDirigido
{
    short int Ac[cantidadVertice][cantidadArcos];
    short int n, m;
    string nombreArchivo;

    public:
        MatrizIncidenciaNoDirigido(short int n, short int m)
        {
            nombreArchivo = "Archivo.txt";
            this->n = n;
            this->m = m;

            for (short int k = 0; k < n; k++)
            {
                for (short int d = 0; d < m; d++)
                {
                    Ac[k][d] = 0;
                }
            }
        }

        void cargarGrafo();

        short int cantidadBucles();

        short int cantidadArcosParalelos();

        short int cantidadVerticesPendulos();

        void mostrar();

        string gradoVertice();
};

void MatrizIncidenciaNoDirigido::cargarGrafo()
{
    ifstream archivo(nombreArchivo.c_str());

    if (!archivo)
        throw Error;

    short int k, d, i;
    k = d = i = 0;

    while (archivo >> i)
    {
        if (d == m)
        {
            d = 0;
            k++;
        }

        Ac[k][d] = i;
        d++;
    }
};

short int MatrizIncidenciaNoDirigido::cantidadBucles()
{
    short int cantidad = 0;
    char comp = 0;

    for (char k = 0; k < m; k++)
    {
        for (char d = 0; d < n; d++)
        {
            if (Ac[d][k] == 1)
                comp++;
        }

        if (comp == 1)
            cantidad++;

        comp = 0;
    }

    return cantidad;
};

short int MatrizIncidenciaNoDirigido::cantidadArcosParalelos()
{
    short int cantidad = 0;

    bool comp1, comp2;
    comp1 = comp2 = false;

    short int pos1, pos2;
    pos1 = pos2 = 0;

    for (short int k = 0; k < m; k++)
    {
        short int posAux1 = k;

        for (short int d = 0; d < n; d++)
        {
            if (Ac[d][k] == 1)
            {
                if (pos1 == 0)
                {
                    pos1 = d;
                }

                else if (pos2 == 0)
                {
                    pos2 = d;
                }
            }
        }

        for (short int aux1 = 0; aux1 < m; aux1++)
        {
            short int posAux = aux1;

            for (short int aux2 = 0; aux2 < n; aux2++)
            {
                if (posAux == posAux1)
                    aux1++;

                if (aux1 == m)
                    break;

                else if (aux2 == pos1)
                {
                    if (Ac[aux2][aux1] == 1)
                        comp1 = true;
                }

                else if (aux2 == pos2)
                {
                    if (Ac[aux2][aux1] == 1)
                        comp2 = true;
                }

            }

            if (comp1 && comp2)
                cantidad++;

            comp1 = comp2 = false;
        }

        pos1 = pos2 = 0;
    }

    return cantidad / 2;
};

short int MatrizIncidenciaNoDirigido::cantidadVerticesPendulos()
{
    short int cantidad = 0;

    char aux = 0;

    for (char d = 0; d < n; d++)
    {
        for (char k = 0; k < m; k++)
        {
            if (Ac[d][k] == 1)
                aux++;
        }

        if (aux == 1)
            cantidad++;

        aux = 0;
    }

    return cantidad;
};

string MatrizIncidenciaNoDirigido::gradoVertice()
{
    string cadena = "";

    for (char d = 0; d < n; d++)
    {
        cadena.append("Vertice #" + to_string(d + 1) + ": ");

        char aux = 0;

        for (char k = 0; k < m; k++)
        {
            if (Ac[d][k] == 1)
                aux++;
        }

        cadena.append(to_string(aux) + "\n\n");
    }

    return cadena;
};

void MatrizIncidenciaNoDirigido::mostrar()
{
    for (char i = 0; i < n; i++)
    {
        for (char d = 0; d < m; d++)
        {
            cout << Ac[i][d] << " ";
        }

        cout << "\n";
    }

    cout << "\n\n";
};

int main()
{
    MatrizIncidenciaNoDirigido mind(5, 7);

    try
    {
        mind.cargarGrafo();
    }

    catch (const Excepcion &e)
    {
        if (e == Error)
            cerr << "Ha ocurrido un error intentando abrir el archivo. \n\n";
    }

    mind.mostrar();

    cout << "La cantidad de bucles es de " << mind.cantidadBucles() << "\n\n";

    cout << "La cantidad de arcos paralelos es de " << mind.cantidadArcosParalelos() << "\n\n";

    cout << "La cantidad de vertices pendulo es de " << mind.cantidadVerticesPendulos() << "\n\n";

    cout << "El grado de todos los vertices: \n" << mind.gradoVertice() << endl;

    return 0;
}*/

//Lista de adyacencia

template <class T>

class Arco
{
    string nombreArco, nombreVertice;
    Arco <T>* proximoArco;

    public:
        Arco()
        {
            nombreArco = nombreVertice = "";
            proximoArco = nullptr;
        }

        void setNombreArco(string x){nombreArco = x;}
        string getNombreArco(){return nombreArco;}
        void setNombreVertice(string x){nombreVertice = x;}
        string getNombreVertice(){return nombreVertice;}
        void setProximoArco(Arco <T>* a){proximoArco = a;}
        Arco <T>* getProximoArco(){return proximoArco;}
};

template <class T>

class Vertice
{
    string nombreVertice;
    Vertice <T>* proximoVertice;
    Arco <T>* proximoArco;

    public:
        Vertice()
        {
            nombreVertice = "";
            proximoArco = nullptr;
            proximoVertice = nullptr;
        }

        void setNombreVertice(string x){nombreVertice = x;}
        string getNombreVertice(){return nombreVertice;}
        void setProximoVertice(Vertice <T>* v){proximoVertice = v;}
        Vertice <T>* getProximoVertice(){return proximoVertice;}
        void setProximoArco(Arco <T>* a){proximoArco = a;}
        Arco <T>* getProximoArco(){return proximoArco;}
};

template <class T>

class ListaDeAdyacencia
{
    Vertice <T>* inicio;

    public:
        ListaDeAdyacencia()
        {
            inicio = nullptr;
        }

        void agregarVertice(Vertice <T>* v);

        void agregarArco(Vertice <T>* verticeSalida, Vertice <T>* verticeEntrada, string nombreArco);

        Vertice <T>* buscarVertice(string nombreVertice);

        short int cantidadArcosParalelos();

        short int cantidadVerticesFuentes();

        short int cantidadVerticesSumideros();

        short int cantidadBucles();

        string mostrarGrafo();
};

template <class T>

void ListaDeAdyacencia<T>::agregarVertice(Vertice <T>* v)
{
    Vertice <T>* aux = inicio;

    if (inicio == nullptr)
        inicio = v;

    else
    {
        Vertice <T>* aux2 = aux->getProximoVertice();

        if (aux2 == nullptr)
            aux->setProximoVertice(v);

        else
        {
            while (aux2 != nullptr)
            {
                aux = aux->getProximoVertice();
                aux2 = aux2->getProximoVertice();
            }

            aux->setProximoVertice(v);
        }
    }

    cout << "Se ha agregado el vertice. \n\n";
};

template <class T>

Vertice <T>* ListaDeAdyacencia<T>::buscarVertice(string nombreVertice)
{
    Vertice <T>* aux = inicio;

    while (aux != nullptr && aux->getNombreVertice() != nombreVertice)
        aux = aux->getProximoVertice();

    return aux;
};

template <class T>

void ListaDeAdyacencia<T>::agregarArco(Vertice <T>* verticeSalida, Vertice <T>* verticeEntrada, string nombreArco)
{
    Vertice <T>* aux = buscarVertice(verticeSalida->getNombreVertice());
    Vertice <T>* aux2 = buscarVertice(verticeEntrada->getNombreVertice());

    if (aux != nullptr && aux2 != nullptr)
    {
        Arco <T>* auxA = aux->getProximoArco();

        Arco <T>* aux3 = new Arco <T> ();
        aux3->setNombreArco(nombreArco);
        aux3->setNombreVertice(verticeEntrada->getNombreVertice());

        if (auxA == nullptr)
            aux->setProximoArco(aux3);

        else
        {
            Arco <T>* aux4 = auxA->getProximoArco();

            while (aux4 != nullptr)
            {
                auxA = auxA->getProximoArco();
                aux4 = aux4->getProximoArco();
            }

            auxA->setProximoArco(aux3);
        }

        cout << "Se ha agregado el arco. \n\n";
    }

    else
        cout << "Los vertices no se encuentran. \n\n";
};

template <class T>

string ListaDeAdyacencia<T>::mostrarGrafo()
{
    string cadena = "";
    char i = 0;

    for (Vertice <T>* auxV = inicio; auxV != nullptr; auxV = auxV->getProximoVertice(), i++)
    {
        cadena.append("Vertice #" + to_string(i + 1));

        for (Arco <T>* auxA = auxV->getProximoArco(); auxA != nullptr; auxA = auxA->getProximoArco())
        {
            cadena.append(" -> | " + auxA->getNombreArco() + " | " + auxA->getNombreVertice() + " |");
        }

        cadena.append("\n");
    }

    cadena.append("\n\n");

    return cadena;
};

template <class T>

short int ListaDeAdyacencia<T>::cantidadArcosParalelos()
{
    short int cantidad = 0;

    char aux = 0;

    for (Vertice <T>* auxV = inicio; auxV != nullptr; auxV = auxV->getProximoVertice())
    {
        char d = 0;

        for (Arco <T>* auxA = auxV->getProximoArco(); auxA != nullptr; auxA = auxA->getProximoArco(), d++)
        {
            char k = 0;

            for (Arco <T>* auxA2 = auxV->getProximoArco(); auxA2 != nullptr; auxA2 = auxA2->getProximoArco(), k++)
            {
                if (k == d)
                {
                    k++;
                    auxA2 = auxA2->getProximoArco();
                }

                if (auxA2 == nullptr)
                    break;

                else if (auxA2->getNombreVertice().compare(auxA->getNombreVertice()) == 0)
                {
                    cantidad++;
                    break;
                }
            }

            aux++;
        }
    }

    if (aux >= 2 && cantidad != 0)
        cantidad--;

    return cantidad;
};

template <class T>

short int ListaDeAdyacencia<T>::cantidadVerticesSumideros()
{
    short int cantidad = 0;
    bool comp = false;
    char k = 0;
    string nombreAux = "";

    for (Vertice <T>* auxV = inicio; auxV != nullptr; auxV = auxV->getProximoVertice())
    {
        for (Arco <T>* auxA = auxV->getProximoArco(); auxA != nullptr; auxA = auxA->getProximoArco())
        {
            comp = true;
        }

        if (!comp)
        {
            nombreAux = auxV->getNombreVertice();

            for (Vertice <T>* auxV2 = inicio; auxV2 != nullptr; auxV2 = auxV2->getProximoVertice())
            {
                for (Arco <T>* auxA2 = auxV2->getProximoArco(); auxA2 != nullptr; auxA2 = auxA2->getProximoArco())
                {
                    if (auxA2->getNombreVertice().compare(nombreAux) == 0)
                        k++;
                }
            }

            if (k >= 2)
            {
                cantidad++;
                k = 0;
            }
        }
    }

    return cantidad;
};

template <class T>

short int ListaDeAdyacencia<T>::cantidadBucles()
{
    short int cantidad = 0;

    for (Vertice <T>* auxV = inicio; auxV != nullptr; auxV = auxV->getProximoVertice())
    {
        for (Arco <T>* auxA = auxV->getProximoArco(); auxA != nullptr; auxA = auxA->getProximoArco())
        {
            if (auxA->getNombreVertice().compare(auxV->getNombreVertice()) == 0)
                cantidad++;
        }
    }

    return cantidad;
};

template <class T>

short int ListaDeAdyacencia<T>::cantidadVerticesFuentes()
{
    short int cantidad = 0;
    bool compNombreEncontrado, comp, compArcoEncontrado;
    compNombreEncontrado = comp = compArcoEncontrado = false;

    for (Vertice <T>* auxV = inicio; auxV != nullptr; auxV = auxV->getProximoVertice())
    {
        compArcoEncontrado = false;

        for (Arco <T>* auxA = auxV->getProximoArco(); auxA != nullptr; auxA = auxA->getProximoArco())
        {
            compArcoEncontrado = true;

            if (auxA->getNombreVertice().compare(auxV->getNombreVertice()))
                compNombreEncontrado = true;
        }

        if (!compNombreEncontrado && compArcoEncontrado)
        {
            comp = false;

            for (Vertice <T>* auxV2 = inicio; auxV2 != nullptr; auxV2 = auxV2->getProximoVertice())
            {
                if (auxV2->getNombreVertice().compare(auxV->getNombreVertice()) == 0)
                    auxV2 = auxV2->getProximoVertice();

                if (auxV2 == nullptr)
                    break;

                else
                {
                    for (Arco <T>* auxA2 = auxV2->getProximoArco(); auxA2 != nullptr; auxA2 = auxA2->getProximoArco())
                    {
                        if (auxA2->getNombreArco().compare(auxV->getNombreVertice()) == 0)
                            comp = true;
                    }
                }
            }

            if (!comp)
                cantidad++;
        }
    }

    return cantidad;
};

int main()
{
    ListaDeAdyacencia <int> lda;
    char opc = '0';

    do
    {
        cout << "What to do? \n1.Agregar vertice. \n2.Agregar arco. \n3.Mostrar. \n4.Cantidad de arcos paralelos. \n5.Cantidad bucles. \n6.Cantidad vertices sumideros. \n7.Cantidad vertices fuentes. \n8.Salir. \nOpcion: ";
        cin >> opc;

        switch (opc)
        {
            case '1':
            {
                string nombre = "";

                cout << "Ingrese nombre del vertice: ";
                cin >> nombre;

                Vertice <int>* vertice = new Vertice <int> ();
                vertice->setNombreVertice(nombre);

                lda.agregarVertice(vertice);

                break;
            }

            case '2':
            {
                string nombreArco, nombreVerticeS, nombreVerticeE;
                nombreArco = nombreVerticeS = nombreVerticeE = "";

                cout << "Ingrese nombre del arco: ";
                cin >> nombreArco;

                cout << "Ingrese nombre del vertice de salida: ";
                cin >> nombreVerticeS;

                cout << "Ingrese nombre del vertice de entrada: ";
                cin >> nombreVerticeE;

                Vertice <int>* verticeSalida = new Vertice <int> ();
                Vertice <int>* verticeEntrada = new Vertice <int> ();

                verticeSalida->setNombreVertice(nombreVerticeS);
                verticeEntrada->setNombreVertice(nombreVerticeE);

                lda.agregarArco(verticeSalida, verticeEntrada, nombreArco);

                break;
            }

            case '3':
                cout << lda.mostrarGrafo() << endl;
                break;

            case '4':
                cout << "La cantidad de arcos paralelos es de " << lda.cantidadArcosParalelos() << endl;
                break;

            case '5':
                cout << "La cantidad de bucles es de " << lda.cantidadBucles() << endl;
                break;

            case '6':
                cout << "La cantidad de vertices sumideros es de " << lda.cantidadVerticesSumideros() << endl;
                break;

            case '7':
                cout << "La cantidad de vertices fuentes es de " << lda.cantidadVerticesFuentes() << endl;
                break;

            case '8':
                break;

            default:
                cerr << "Opcion invalida. Intente de nuevo. \n\n";
        }

    } while (opc != '8');

    return 0;
}
