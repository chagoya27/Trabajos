#ifndef NODO_H_INCLUDED
#define NODO_H_INCLUDED
struct nodo {
    int info;
    struct nodo *sig;
};

typedef struct nodo Nodo;

Nodo *nuevoNodo(int n); //crea un nodo de manera dinamica
void liberaNodo(Nodo *nodo); //libera la memoria reservada para el nodo
void imprimirNodo(Nodo *nodo);

#endif // NODO_H_INCLUDED

