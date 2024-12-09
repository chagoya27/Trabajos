#include <stdio.h>
#include <stdlib.h>
#include "ordenamientos.h"
#include "utilidades.h"

int main()
{
    int n = 15; //numero de elementos del arreglo
    int array[n];
    printf("----------EJERCICIO 2----------");
    cargaArreglo(array,n);
    radixSort(array,n);//algortimo de radixSort
    printf("\nLa Lista ordenada es:\n");
    imprimirArreglo(array,n); //impresion del arreglo

    return 0;
}
