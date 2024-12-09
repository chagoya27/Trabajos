#include <stdio.h>
#include <stdlib.h>
#include "utilidades.h"

int main() {
    int array[2000];
    printf("---------------EJERCICIO 3---------------\n");
    menuArray(array,2000); //muestra el menu para las opciones de carga del array
    system("cls"); //limpia la pantalla de la terminal
    printf("El arreglo es: ");
    printArray(array,2000); //una vez cargado el array lo imprime
    menuOrdenamiento(array,2000); // menu para las opciones de ordenamiento
    printf("\nEl arreglo ordenado es: ");
    printArray(array,2000); //impresion del arreglo ordenado

    return 0;
}
