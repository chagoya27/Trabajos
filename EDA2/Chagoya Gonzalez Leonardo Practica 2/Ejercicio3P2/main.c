#include <stdio.h>
#include <stdlib.h>
#include "utilidades.h"
int main() {
    int n=20;
    int array[n];
    printf("---------------EJERCICIO 3---------------\n");
    menuArray(array,n); //muestra el menu para las opciones de carga del array
    system("cls"); //limpia la pantalla de la terminal
    printf("El arreglo es: ");
    printArray(array,n); //una vez cargado el array lo imprime
    menuOrdenamiento(array,n); // menu para las opciones de ordenamiento
    printf("\nEl arreglo ordenado es: ");
    printArray(array,n); //impresion del arreglo ordenado

    return 0;
}
