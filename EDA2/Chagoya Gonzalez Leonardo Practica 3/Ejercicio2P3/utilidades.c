#include <stdio.h>
#include "utilidades.h"

void cargaArreglo(int *array, int n) { //pide al usuario elementos para el arreglo

    int i;
    printf("\nCarga del arreglo\n");
    for(i=0; i<n; i++) {
        printf("Ingrese un numero max 4 digitos (digitos 1-4): ");
        scanf("%d",&array[i]);
    }
    printf("Carga completada\n");
}


void imprimirArreglo(int *array, int n) { //imprime el arreglo

    int i;
    for(i=0; i<n; i++) {
        printf("%d ",array[i]);
    }
    printf("\n");
}


int unidades(int elem) { //calcula las unidades de un numero

    int u = elem%10;
    return u;

}

int decenas(int elem) { //calcula las decenas de un numero
    int u,d;

    u =unidades(elem);
    d = ((elem - u)%100)/10;
    return d;

}

int centenas(int elem) { //calcula las centenas de un numero

    int c,u,d;
    u = unidades(elem);
    d = decenas(elem);
    c = ((elem - d*10 - u)%1000 )/100;
    return c;
}

int miles(int elem) { //calcula los miles de un numero

    int u,d,c,m;
    u = unidades(elem);
    d = decenas(elem);
    c = centenas(elem);
    m = (elem - c*100 - d*10 - u)/1000;
    return m;
}
