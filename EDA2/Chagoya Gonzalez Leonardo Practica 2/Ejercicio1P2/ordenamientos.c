#include "ordenamientos.h"
#include "utilidades.h"
#include <stdio.h>


void selectionSort(int arreglo[], int n) {


    int indiceMenor, i, j;
    int contador=0;

    for (i=0; i<n-1; i++) {
        indiceMenor=i;
        contador+=1;
        for(j = i+1; j<n; j++) {
            if(arreglo[j]<arreglo[indiceMenor]) {
                indiceMenor=j;
                contador+=1;
            }
            contador+=1; //se aumenta en uno debido a la comparacion realizada

        }

        if (i!=indiceMenor) {
            swap(&arreglo[i],&arreglo[indiceMenor]);
            contador+=3; //la funcion swap involucra un intercambio de valores haciendo 3 asignaciones
        }
        contador+=1; //se aumenta en uno debido a la comparacion realizada

        printf("\nIteracion numero %d \n",i+1);
        printArray(arreglo,n);
    }
    printf("\nEl numero de operaciones del ordenamiento es: %d",contador);

}


void insertionSort(int a[], int n) {

    int i,j;
    int aux;
    int contador=0;
    for(i=1; i<n; i++) {
        j=i;
        aux=a[i];
        contador+=2;
        while (j>0 && aux < a[j-1]) {
            a[j] = a[j-1];
            j--;
            contador+=2;
        }
        a[j]=aux;
        contador+=1;
        printf("\nIteracion numero %d \n",i);
        printArray(a,n);
    }
    printf("\nEl numero de operaciones del ordenamiento es: %d",contador);
}


void bubbleSort(int a[], int size) {
    int i,j,ordenado;
    int contador=0;

    ordenado =0; //indicara 0 si el algoritmo esta desordenado y 1 si esta ordenado
    i = size;
    contador+=2;
    while(i>0 && ordenado ==0) {
        ordenado = 1; //partimos de la premisa que el array esta ordenado
        contador+=1;
        for(j=0; j<i; j++) {
            if(a[j]>a[j+1]) {
                swap(&a[j],&a[j+1]);
                ordenado = 0;//si hace un cambio en algun punto de la iteracion el arreglo no se encontraba ordenado
                contador+=4; //las 3 operaciones de swap y la opreracion de asignacion de la linea 74
            }
            contador+=1; //suma uno por la comparacion realizada
        }
        i--;
        contador+=1;
        printf("\nIteracion numero %d\n",size-i);
        printArray(a,size);
    }
    printf("\nEl numero de operaciones es: %d",contador);
}




int heapSize;

void HeapSort(int *A, int size) {
    BuildHeap(A,size);
    int i;
    for(i=size-1; i>0; i--) {
        swap(&A[0],&A[heapSize]);
        heapSize--;
        printf("Iteracion HS: \n");
        printArray(A,size);
        Heapify(A,0,size);

    }

}


void Heapify(int *A, int i, int size) {

    int l = 2*i+1;
    int r = 2*i+2;
    int largest;

    if(l <=heapSize && A[l]>A[i]){
        largest = l;
    }

    else{
        largest = i;
    }
    if(r<=heapSize && A[r]>A[largest]){
        largest=r;
    }

    if(largest !=i) {
        swap(&A[i],&A[largest]);
        printArray(A,size);
        Heapify(A,largest,size);
    }


}

void BuildHeap(int *A, int size) {

    heapSize = size-1;
    int i;
    for(i=(size-1)/2; i>=0; i--) {
        Heapify(A,i,size);
    }
    printf("termin%c de construir el heap\n",162);
}

int partition(int arr[], int low, int high) {
    int pivot = arr[high];
    int j,i= (low-1);
    for(j=low; j<=high-1; j++) {
        if(arr[j]<=pivot) {
            i++;
            swap(&arr[i],&arr[j]);
        }
    }
    swap(&arr[i+1],&arr[high]);
    return(i+1);
}

void quickSort(int arr[], int low, int high) {
    if(low<high) {
        int pi=partition(arr,low,high);
        printSubArray(arr,low,pi-1);
        quickSort(arr,low,pi-1);
        printSubArray(arr,pi+1,high);
        quickSort(arr,pi+1,high);
    }
}




