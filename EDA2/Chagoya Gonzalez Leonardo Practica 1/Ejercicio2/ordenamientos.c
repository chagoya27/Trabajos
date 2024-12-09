#include "ordenamientos.h"
#include "utilidades.h"
#include <stdio.h>


void selectionSort(int arreglo[], int n) {
    int indiceMenor, i, j;
    for (i=0; i<n-1; i++) {
        indiceMenor=i;
        for(j = i+1; j<n; j++) {
            if(arreglo[j]<arreglo[indiceMenor])
                indiceMenor=j;
        }
        if (i!=indiceMenor) {
            swap(&arreglo[i],&arreglo[indiceMenor]);
        }

        printf("\nIteracion numero %d \n",i+1);
        printArray(arreglo,n);
    }
}


void insertionSort(int a[], int n) {
    int i,j;
    int aux;

    for(i=1; i<n; i++) {
        j=i;
        aux=a[i];
        while (j>0 && aux < a[j-1]) {
            a[j] = a[j-1];
            j--;
        }
        a[j]=aux;
        printf("\nIteracion numero %d \n",i);
        printArray(a,n);
    }
}


void bubbleSort(int a[], int size) {
    int i,j,ordenado;
    ordenado =0; //indicara 0 si el algoritmo esta desordenado y 1 si esta ordenado
    i = size;
    while(i>0 && ordenado ==0) {
        ordenado = 1; //partimos de la premisa que el array esta ordenado
        for(j=0; j<i; j++) {
            if(a[j]>a[j+1]) {
                swap(&a[j],&a[j+1]);
                ordenado = 0;//si hace un cambio en algun punto de la iteracion el arreglo no se encontraba ordenado
            }
        }
        i--;
        printf("\nIteracion numero %d\n",size-i);
        printArray(a,size);
    }
}

