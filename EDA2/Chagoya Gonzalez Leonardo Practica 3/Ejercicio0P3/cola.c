#include <stdlib.h>
#include <stdio.h>
#include "Cola.h"
#include <string.h>

Cola *nuevaCola() { //crea una la estructura de una nueva cola
    Cola *c;
    c = malloc(sizeof(Cola));
    if(c == NULL){ //verifica si se pudo almacenar memoria para una estructura cola
        printf("No se pudo crear la estructura tipo cola\n");
        printf("Terminara el programa");
        exit(-1);
    }
    c->inicio = NULL;
    c->fin = NULL;
    return c;
}

// regresa 1 si la cola está vacia
int colaVacia(Cola *cola) {
    if (cola == NULL) {
        printf("No puedo verificar que una Cola NULL sea vacia");
        exit(-2);
    }
    if (cola->inicio==NULL)
        return 1;
    return 0;
}



void encolar(Cola *cola, Nodo *nodo) { //agrega un elemento al final de la cola
    if (cola == NULL) {
        printf("No puedo encolar algo en una Cola NULL");
        exit(-2);
    }
    if (nodo == NULL) {
        printf("No puedo encolar un nodo NULL");
        exit(-3);
    }
    if (colaVacia(cola)==1) { //si la cola esta vacia
        cola->inicio = nodo;
        cola->fin = nodo;
    } else {//si no esta vacia
        cola->fin->sig = nodo;
        cola->fin = nodo;

    }
}




void recorrer( Nodo* (*f)(Cola *cola) , Cola *cola, int *array, int*i){ //recorre la lista eliminando los nodos desde el incio de la cola

    Nodo *p;

    if (colaVacia(cola)==1)
        return;


    p = cola->inicio;

    while( p!=NULL ) {
    p = f(cola);
    if(p == NULL)
        break;
    array [*i]= p->info; //coloca el elemento extraido de la cola en el arreglo
    *i+=1;
    liberaNodo(p); //libera el espacio de memoria del nodo extraido
    }

}


Nodo *desencolar(Cola *cola) { //quita el primer nodo de la cola
    Nodo *p;

    if(colaVacia(cola))
        return NULL;

    p = cola->inicio;

    if (cola->inicio == cola->fin) { //si la estructura cola solo tiene un elemento
        cola->inicio = cola->fin = NULL;
    } else { //si la estructura cola tiene almenos 2 elementos
        cola->inicio = p->sig;
        p->sig = NULL;
    }

    return p;

}



void imprimirCola(Cola *cola) {

    Nodo *p;
    if(colaVacia(cola))
        return ;
    p = cola->inicio;
    while(p!=NULL) {
        imprimirNodo(p);
        p = p->sig;
    }
    printf("\n");

}
