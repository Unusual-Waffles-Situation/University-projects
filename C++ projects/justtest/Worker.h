#ifndef WORKER_H_INCLUDED
#define WORKER_H_INCLUDED

#pragma once
#include <stdlib.h>
#include <string>
#include <conio.h>
#include <iostream>

using namespace std;

class Worker{
private:
		int codigo;
		string nombre;
		int salario;
public:
		Worker(int, string, int);
		~Worker();
		int getCodigo();
		string getNombre();
		int getSalario();
};




#endif // WORKER_H_INCLUDED
