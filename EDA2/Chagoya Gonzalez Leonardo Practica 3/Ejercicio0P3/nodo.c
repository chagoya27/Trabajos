#include <stdlib.h>
#include <stdio.h>
#include "nodo.h"
#include <string.h>


Nodo *nuevoNodo(int n) {
    Nodo *a;
    a = malloc(sizeof(Nodo));
    if (a == NULL) { //verifica si el nodo pudo ser creado
        printf("Error al crear una estructura NODO\n");
        printf("Se terminara el programa");
        exit(-1);
    }
    a->info = n;
    a->sig = NULL;
    return a;
}

void liberaNodo(Nodo *nodo) {
    if (nodo == NULL)
        return;
    free(nodo);
}


void imprimirNodo(Nodo *nodo) {
    printf("[%d]",nodo->info);
}
