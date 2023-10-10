#include "Worker.h"


Worker::Worker(int codigo, string nombre, int salario){
	this -> codigo = codigo;
	this -> nombre = nombre;
	this -> salario = salario;
}

Worker::~Worker(){
}

int Worker::getCodigo(){
	return codigo;
}
string Worker::getNombre(){
	return nombre;
}
int Worker::getSalario(){
	return salario;
}
