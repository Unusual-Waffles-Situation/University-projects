#include <conio.h>
#include <iostream>
#include <string>
#include <fstream>
#include <stdlib.h>
#include <iomanip>
#include "List.h"


using namespace std;

void lectura(){
	List list;
	ifstream archivo;
	string texto, aux = " ", nombreArchivo, nombre;
	int cont = 0, cuentaSalario = 0, codigo = 0, salario = 0, recorre=0;
	bool flag = false;

	for(int x=1; x<3;x++){
		cout << "Escriba el nombre del archivo " << x << endl;
		cin >> nombreArchivo;
		archivo.open(nombreArchivo.c_str());
		if(archivo.fail()){
			cout << "No se pudo abrir el archivo";
			exit(1);
		}

		while(archivo >> texto){
			if(cont==0){
				nombre = texto + aux;
				nombre = aux + nombre;

				cont++;
			}else if(cont == 1){
				nombre = nombre + texto;

				cout << nombre << endl;

				if(recorre > 0){
					if(flag == list.buscaPorNombre(nombre)){
						cont = 0;
					}else{
						cont++;
					}
				}

				cout << cont << "++" << endl;

				codigo = sizeof(nombre);

			}else{
				salario = stoi(texto);
				list.addWorker(Worker(codigo, nombre, salario));
				cont = 0;
				cuentaSalario = salario + cuentaSalario;
				recorre++;
			}
		}
		archivo.close();
	}
	list.binary();
	list.imprimir();
}


int main(){

	lectura();
	system("pause");
	return 0;
}
