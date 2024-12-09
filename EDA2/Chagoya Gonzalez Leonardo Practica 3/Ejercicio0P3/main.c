#include <stdio.h>
#include <stdlib.h>
#include "utilidades.h"
#include "ordenamientos.h"

int main() {
    int op; //para eligir el algortimo
    char array[20]; //arreglo inicial para couting
    char arrayOrdenado[20]; //areglo del conteo para couting
    int array2[15]; //arreglo  para radix
    int n; //numero de elementos



    printf("----------------Menu--------------\n");
    printf("Elija una opcion\n");
    printf("1) CoutingSort    2)RadixSort    ");
    scanf("%d",&op);
    switch(op) {
    case 1:
        n=20;
        printf("Algortimo de CoutingSort\n");
        ZeroArreglo(arrayOrdenado,n); //el arreglo que servira para colocar los elementos ordenados se inicializa con ' '
        cargaArreglo(array,n); //carga del arreglo
        countingSort(array,arrayOrdenado,n); //algoritmo couting sort
        printf("el arreglo ordenado es: \n");
        imprimirArreglo(arrayOrdenado,n);
        break;

    case 2:
        n=15;
        printf("Algortimo de radixSort");
        cargaArreglo2(array2,n); //carga del arreglo con caracteres
        radixSort(array2,n); //algortimo de radixSort
        printf("El arreglo ordenado es: \n");
        imprimirArreglo2(array2,n);
        break;

    default:
        printf("Esa no es una opcion valida");
    }


}
