#include <stdio.h>
#include "utilidades.h"

void cargaArreglo(char *array, int n) {
    fflush(stdin);
    int i;
    printf("\nCarga del arreglo\n");
    for(i=0; i<n; i++) {
        printf("Ingrese un caracter: ");
        scanf("%c",&array[i]);
        fflush(stdin);

    }
    printf("Carga completada\n");

}


void imprimirArregloContador(int *array, int n) {

    int i;
    printf("a\tb\tc\td\te\tf\tg\th\ti\tj\n");
    for(i=0; i<n; i++) {
        printf("%d\t",array[i]);
    }
    printf("\n");

}

void imprimirArreglo(char *array, int n) {

    int i,k;

    for(k=0;k<n;k++){
        printf("%*d",5,k);
    }
    printf("\n");

    for(i=0; i<n; i++) {
        printf("%*c",5,array[i]);
    }
    printf("\n");
}

void ZeroArreglo(char *array, int n) {

    int i;
    for(i=0; i<n; i++) {
        array[i]=' ';
    }

}





void cargaArreglo2(int *array, int n) { //pide al usuario elementos para el arreglo

    int i;
    printf("\nCarga del arreglo\n");
    for(i=0; i<n; i++) {
        printf("Ingrese un numero max 4 digitos (digitos 1-4): ");
        scanf("%d",&array[i]);
    }
    printf("Carga completada\n");
}


void imprimirArreglo2(int *array, int n) { //imprime el arreglo

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

