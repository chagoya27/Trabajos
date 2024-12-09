#include <stdio.h>
#include <stdlib.h>
#include "utilidades.h"

int main()
{
    int n=20;
    char array[n];
    char arryOrdenado[n];
    printf("------------EJERCICIO 1--------------");
    ZeroArreglo(arryOrdenado,n); //el arreglo que servira para colocar los elementos ordenados se inicializa con ' '
    cargaArreglo(array,n); //carga del arreglo
    countingSort(array,arryOrdenado,n); //algoritmo couting sort
    printf("El arreglo ordenado es:\n");
    imprimirArreglo(arryOrdenado,n);
    return 0;
}
