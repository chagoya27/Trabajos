#ifndef COLA_H_INCLUDED
#define COLA_H_INCLUDED

#include "nodo.h"

struct Cola {
    Nodo *inicio;
    Nodo *fin;
};

typedef struct Cola Cola;

Cola *nuevaCola(); //reserva espacio para almacenar la direccion del primer elemento de la cola y el ultimo
int colaVacia(Cola *cola);
void liberaCola(Cola *cola);
void encolar(Cola *cola, Nodo *nodo);
void recorrer( Nodo* (*f)(Cola *cola) , Cola *cola, int *array, int*i);
Nodo *desencolar(Cola *cola);




#endif // COLA_H_INCLUDED
