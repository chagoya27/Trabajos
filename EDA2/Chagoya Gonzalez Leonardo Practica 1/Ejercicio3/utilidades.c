#include "utilidades.h"
#include "ordenamientos.h"
#include <time.h>
#include <stdio.h>
#include <stdlib.h>

void swap(int* a, int* b) { //intercambio de valores de dos enteros haciendo uso de indirecciones
    int t = *a;
    *a = *b;
    *b = t;
}

void printArray(int arr[],int size) { //impresion de un arreglo de tamaño size
    int i;
    for (i=0; i < size; i++)
        printf("%d ", arr[i]);
    printf("\n");
}

void printSubArray(int arr[],int low, int high) { //impresion de un arreglo desde su indice low hasta high
    int i;
    printf("Sub array :  ");
    for (i=low; i <= high; i++)
        printf("%d ", arr[i]);
    printf("\n");
}


void cargarArrayManual(int *array, int size) { //pide ingresar 20 numeros al usuario y los guarda en el array

    int i;
    for(i=0; i<size; i++) {
        printf("Digite el numero de la posicion %d: ",i+1);
        scanf("%d",&array[i]);
    }
}

void cargarArrayAleatorio(int *array, int size) { //genera 20 numeros aleatorios
    srand(time(NULL)); //semilla para generar los numeros
    int i;
    for(i=0; i<size; i++) {
        array[i] = rand()%1000; //genera numeros de 0-999
    }
}

void menuArray(int *array,int size) { //menu para opciones de carga del array
    int op=3;
    while(op!=1 && op!=2) {
        printf("\nCreacion de arreglo,elija una opcion\n\n");
        printf("1)Cargar numeros ingresandolos tu mismo     2)Generar numeros aleatorios   ");
        scanf("%d",&op);
        printf("\n");
        switch(op) { //opcion para elegir el metodo de carga del arreglo
        case 1:
            cargarArrayManual(array,size);
            break;

        case 2:
            cargarArrayAleatorio(array,size);
            break;

        default:
            printf("No es una opcion valida\n");
        }
    }
}

void menuOrdenamiento(int *array,int size) { //menu para opciones de eleccion de ordenamiento
    int op;
    printf("\n--------------Menu------------\n");
    printf("Elija el algortimo de ordenamiento \n");
    printf("1)InsertionSort   2)SelectionSort   3)BubbleSort   ");
    scanf("%d",&op); //opcion para elegir el ordenamiento a ocupar
    switch(op) {
    case 1:
        insertionSort(array,size); //algorimo de ordenamiento de insertion
        break;
    case 2:
        selectionSort(array,size); //algoritmo de ordenamiento de selection
        break;
    case 3:
        bubbleSort(array,size); //algoritmo de ordenamoento bubbluesort
        break;
    default:
        printf("No es una opcion valida");
    }
}
