#include <stdio.h>
#include <stdlib.h>
#include "utilidades.h"
int main() {
    int n=10000; //indica el tamaño de los arreglos
    int array[n];
    int contador=0; //variable para contar las operaciones realizadas en cada algoritmo

    printf("---------------EJERCICIO 3---------------\n");
    menuArray(array,n); //muestra el menu para las opciones de carga del array
    system("cls"); //limpia la pantalla de la terminal
    printf("El arreglo es: ");
    printArray(array,n); //una vez cargado el array lo imprime
    menuOrdenamiento(array,n,&contador); // menu para las opciones de ordenamiento
    printf("\nEl arreglo ordenado es: ");
    printArray(array,n); //impresion del arreglo ordenado
    printf("Numero de elementos del arreglo: %d\n",n);
    printf("El numero de operaciones es: %d",contador);
    return 0;
}
