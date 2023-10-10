/*
Nombre: José Rodulfo.
C.I.: 26.237.566.
Descripción del programa: Elaborar un programa en C++, usando archivos binarios, para leer un archivo
y sustituir los 0's y 1's con caracteres dados.
*/

#include <iostream>
#include <fstream>
#include <string>
#include <sstream>
#include <bitset>

using std::cin;
using std::cout;
using std::cerr;
using std::string;
using std::ifstream;
using std::ios;
using std::to_string;
using std::endl;
using std::stringstream;

enum Excepcion
{
    ErrorLista = 0
};

struct CabeceraImagen
{
    int ancho, altura;
    unsigned char sustitucionCero, sustitucionUno;
    int cantidad;
};

class Clase
{
    bool compAncho, compAltura;
    CabeceraImagen ci;

    string nombreArchivo;

    public:
        Clase(string x, CabeceraImagen c)
        {
            nombreArchivo = x;
            compAncho = compAltura = false;
            ci = c;
        }

        void mostrar();
};

void Clase::mostrar()
{
    ifstream archivo(nombreArchivo.c_str(), ios::binary);
    int anchoAux, alturaAux, valAux, cantAux;
    anchoAux = alturaAux = valAux = cantAux = 0;
    short int contador, contadorEspacio;
    contador = contadorEspacio = 0;
    char ceroAux, unoAux;
    ceroAux = unoAux = 'a';
    bool compAncho, compAlto, compCero, compUno, comp, compCant;
    compAncho = compAlto = compCero = compUno = comp = compCant = false;

    string cadenaAux = "";

    if (!archivo)
        throw ErrorLista;

    string cadena = "";

    unsigned char numero = 0;

    archivo.seekg((long) 0, ios :: end);
    int tamanoArchivo = archivo.tellg();

    archivo.seekg(0, ios::beg);

    if (tamanoArchivo == 0)
    {
        cout << "La lista esta vacia. \n";
        return;
    }

    else
    {
        if (archivo.is_open())
        {
            while (!archivo.eof())
            {
                archivo.read(reinterpret_cast <char*>(&ci), sizeof(CabeceraImagen));

                    numero = ci.ancho;

                    if (anchoAux == 0 && !compAncho)
                    {
                        anchoAux = (int)numero;

                        compAncho = true;
                    }

                    else
                    {
                        std::bitset<8> binario (numero);

                        short int i = 0;

                        while (i < 7)
                        {
                            if (contadorEspacio == anchoAux)
                            {
                                cout << "\n";
                                contadorEspacio = 0;
                            }

                            else if (binario[i] == 0)
                            {
                                cout << ceroAux;
                                contadorEspacio++;
                                //contador++;
                            }

                            else if (binario[i] == 1)
                            {
                                cout << unoAux;
                                contadorEspacio++;
                                //contador++;
                            }

                            i++;

                        }

                        contador += 4;
                    }

                    if ((anchoAux != 0 && alturaAux != 0) && contador == (anchoAux * alturaAux))
                        break;

                    numero = ci.altura;

                    if (alturaAux == 0 && !compAlto)
                    {
                        alturaAux = (int)numero;

                        compAlto = true;
                    }

                    else
                    {
                        std::bitset<8> binario (numero);

                        short int i = 0;

                        while (i < 7)
                        {
                            if (contadorEspacio == anchoAux)
                            {
                                cout << "\n";
                                contadorEspacio = 0;
                            }

                            else if (binario[i] == 0)
                            {
                                cout << ceroAux;
                                contadorEspacio++;
                                //contador++;
                            }

                            else if (binario[i] == 1)
                            {
                                cout << unoAux;
                                contadorEspacio++;
                                //contador++;
                            }

                            i++;

                        }

                        contador += 4;
                    }

                    if ((anchoAux != 0 && alturaAux != 0) && contador == (anchoAux * alturaAux))
                        break;

                    numero = ci.sustitucionCero;

                    if (ceroAux == 'a' && !compCero)
                    {
                        valAux = 0;

                        stringstream ss, ss2;

                        ss << std::hex << (int)numero;

                        std::istringstream(ss.str()) >> std::hex >> valAux;

                        ss2 << std::dec << valAux;

                        valAux = std::stoi(ss2.str());


                        ceroAux = valAux;

                        compCero = true;
                    }

                    else
                    {
                        std::bitset<8> binario (numero);

                        short int i = 0;

                        while (i < 7)
                        {
                            if (contadorEspacio == anchoAux)
                            {
                                cout << "\n";
                                contadorEspacio = 0;
                            }

                            else if (binario[i] == 0)
                            {
                                cout << ceroAux;
                                contadorEspacio++;
                                //contador++;
                            }

                            else if (binario[i] == 1)
                            {
                                cout << unoAux;
                                contadorEspacio++;
                                //contador++;
                            }

                            i++;

                        }

                        contador += 4;
                    }

                    if ((anchoAux != 0 && alturaAux != 0) && contador == (anchoAux * alturaAux))
                        break;

                    numero = ci.sustitucionUno;

                    if (unoAux == 'a' && !compUno)
                    {
                        valAux = 0;

                        stringstream ss, ss2;

                        ss << std::hex << (int)numero;

                        std::istringstream(ss.str()) >> std::hex >> valAux;

                        ss2 << std::dec << valAux;

                        valAux = std::stoi(ss2.str());

                        unoAux = valAux;

                        compUno = true;
                    }

                    else
                    {
                        std::bitset<8> binario (numero);

                        short int i = 0;

                        while (i < 7)
                        {
                            if (contadorEspacio == anchoAux)
                            {
                                cout << "\n";
                                contadorEspacio = 0;
                            }

                            else if (binario[i] == 0)
                            {
                                cout << ceroAux;
                                contadorEspacio++;
                                //contador++;
                            }

                            else if (binario[i] == 1)
                            {
                                cout << unoAux;
                                contadorEspacio++;
                                //contador++;
                            }

                            i++;

                        }

                        contador += 4;
                    }

                    if ((anchoAux != 0 && alturaAux != 0) && contador == (anchoAux * alturaAux))
                        break;

                    numero = ci.cantidad;

                    if (cantAux == 0 && !compCant)
                    {
                        cantAux = (int)numero;

                        compCant = true;
                    }

                    else
                    {
                        std::bitset<8> binario (numero);

                        short int i = 0;

                        while (i < 7)
                        {
                            if (contadorEspacio == anchoAux)
                            {
                                cout << "\n";
                                contadorEspacio = 0;
                            }

                            else if (binario[i] == 0)
                            {
                                cout << ceroAux;
                                contadorEspacio++;
                                //contador++;
                            }

                            else if (binario[i] == 1)
                            {
                                cout << unoAux;
                                contadorEspacio++;
                                //contador++;
                            }

                            i++;

                        }

                        contador += 4;
                    }

                    if ((anchoAux != 0 && alturaAux != 0) && contador == (anchoAux * alturaAux))
                        break;
            }
        }

        archivo.close();
    }
};

int main()
{
    string nombreArchivo = "";

    CabeceraImagen ci;

    ci.cantidad = 0;

    ci.altura = 0;
    ci.ancho = 0;
    ci.sustitucionCero = 'a';
    ci.sustitucionUno = 'a';

    cout << "Ingrese nombre del archivo que desea leer: ";
    cin >> nombreArchivo;

    Clase c(nombreArchivo, ci);

    try
    {
        c.mostrar();
    }

    catch (const Excepcion &e)
    {
        if (e == ErrorLista)
            cerr << "Ha ocurrido un error intentando abrir el archivo. \n\n";

    }

    return 0;
}
