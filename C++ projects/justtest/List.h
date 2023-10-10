#ifndef LIST_H_INCLUDED
#define LIST_H_INCLUDED

#pragma once
#include <iostream>
#include <vector>
#include <fstream>
#include "Worker.h"
#include <string>

using namespace std;

class List{
private:
		vector<Worker> worker;
public:
		List();
		~List();
		void addWorker(Worker newWorker);
		bool buscaPorNombre(string nombre);
		void imprimir();
		void salarioTotal();
		void binary();
};



#endif // LIST_H_INCLUDED
