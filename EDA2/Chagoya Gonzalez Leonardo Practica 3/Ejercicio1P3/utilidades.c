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
    printf("\n\n");

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


