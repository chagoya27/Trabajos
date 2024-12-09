#include <stdio.h>
#include <stdlib.h>
#include "utilidades.h"

int main() {
    int array[20];
    printf("---------------EJERCICIO 2---------------\n");
    menuArray(array,20); //muestra el menu para las opciones de carga del array
    system("cls"); //limpia la pantalla de la terminal
    printf("El arreglo es: ");
    printArray(array,20); //una vez cargado el array lo imprime
    menuOrdenamiento(array,20); // menu para las opciones de ordenamiento
    printf("\nEl arreglo ordenado es: ");
    printArray(array,20); //impresion del arreglo ordenado

    return 0;
}
