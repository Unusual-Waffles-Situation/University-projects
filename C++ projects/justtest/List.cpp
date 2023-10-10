#include "List.h"


List::List (){
	worker = vector<Worker>();
}

List::~List(){
}

void List::addWorker(Worker newWorker){
	worker.push_back(newWorker);

}

bool List::buscaPorNombre(string nombre){
	bool encontrado = false;
	unsigned int i=0;
	while(encontrado == false && i < worker.size()){
		if(worker[i].getNombre() == nombre){
			encontrado = true;
		}else{
			i++;
		}
	}
	return encontrado;
}

void List::imprimir(){
	int i=0;
	while(i<worker.size()){
		cout << worker[i].getCodigo() << " " << worker[i].getNombre() << " " << worker[i].getSalario() << endl;
	}
}

void List::salarioTotal(){
	int salarioT = 0;
	int i=0;
	while(i<worker.size()){
		salarioT = salarioT + worker[i].getSalario();
	}

}

void List::binary(){
	string arch;
	unsigned int i = 0;
	cout << "Escriba el nombre del archivo binario";
	cin >> arch;
	ofstream file;
	file.open(arch.c_str(),ios::app|ios::binary);
	while(i<worker.size()) {
		file.write((char*)&worker[i], sizeof(worker[i]));
	}
	file.close();


}
