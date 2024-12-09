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

void HeapSort(int *A, int size,int *contador) {
    BuildHeap(A,size,contador); //construccion de un Max-Heap
    int i;
    for(i=size-1; i>0; i--) { //Proceso de eliminacion de Raices
        swap(&A[0],&A[heapSize]);
        heapSize--;
        *contador+=4;
        //printf("Iteracion HS: \n");
        //printArray(A,size);
        Heapify(A,0,size,contador);
    }
}


void Heapify(int *A, int i, int size, int *contador) {//Proceso recursivo para verificar la estructura de un max heap

    int l = 2*i+1; //obtiene al primer hijo
    int r = 2*i+2;//obtiene al segundo hijo
    *contador+=6;//las operaciones para obtener a los hijos involucran sumas multiplicaciones y asignaciones
    int largest;

    if(l <=heapSize && A[l]>A[i]) {
        largest = l;
        *contador+=1;
    }

    else {
        largest = i;
        *contador+=1;
    }
    *contador+=1;
    if(r<=heapSize && A[r]>A[largest]) {
        largest=r;
        *contador+=1;
    }

    if(largest !=i) {
        swap(&A[i],&A[largest]);
        *contador+=3;
        //printArray(A,size);
        Heapify(A,largest,size,contador);
    }
    *contador+=1;


}

void BuildHeap(int *A, int size,int *contador) {

    heapSize = size-1;
    *contador+=1;
    int i;
    for(i=(size-1)/2; i>=0; i--) {
        Heapify(A,i,size,contador);
    }
    //printf("termin%c de construir el heap\n",162);
}

int partition(int arr[], int low, int high, int *contador) {//acomoda el pivote en su posicion y retorna el valor de dicha posicion

    int pivot = arr[high];
    *contador+=1;
    //printf("\nEl pivote es: %d\n",pivot);
    int j,i= (low-1);
    *contador+=2; //hace una operacion y asignacion
    for(j=low; j<=high-1; j++) {
        if(arr[j]<=pivot) {
            i++;
            swap(&arr[i],&arr[j]);
            *contador+=4;
        }
        *contador+=1;
    }
    swap(&arr[i+1],&arr[high]);
    *contador+=3;
   // printf("Una vez colocado el pivote en su posicion ");
    //printArray(arr,high+1);
    return(i+1);
}

void quickSort(int arr[], int low, int high, int *contador) {//proceso recursivo de quickSort para ordenar una lista partiendola en trozos deacuerdo al pivote
    if(low<high) {
        int pi=partition(arr,low,high,contador);
        *contador+=1;
        //printf("Izquierda ");
        //printSubArray(arr,low,pi-1);
        quickSort(arr,low,pi-1,contador);
        //printf("Derecha ");
        //printSubArray(arr,pi+1,high);
        quickSort(arr,pi+1,high,contador);
    }
    *contador+=1;
}


void mergeSort(int *array,int low, int high,int *contador) {//proceso de mergeSort para ir partiendo el arreglo en sub arreglos
//una vez que ya no se puede partir mas los arreglos realiza la mezcla  de estos con merge
    int q;
    if(low<high) {
        q = (low+high)/2;
        *contador+=2;
        //printf("Parte arreglo hacia la izquierda\n"); //para ir visualizando como parte el arreglo hacia la izquierda
        //printSubArray(array,low,q);
        mergeSort(array,low,q,contador);
        //printf("Parte arreglo hacia la derecha\n"); //para ir visualizando como parte el arreglo hacia la derecha
        //printSubArray(array,q+1,high);
        mergeSort(array,q+1,high,contador);
        merge(array,low,q,high,contador);
    }
    *contador+=1;
}



void merge(int *array, int p, int q, int r, int *contador) { //realiza la mezcla de los elementos de sub arreglos

    int i,j,k;
    int list[r+1];
    k=0;
    i=p;
    j=q+1;

    *contador+=4;

    while(i<=q && j<=r) {
        if(array[i]<array[j]) {
            list[k++] = array[i++];
            *contador+=3;
        } else {
            list[k++] = array[j++];
            *contador+=3;
        }
        *contador+=1;

    }

    while(i<=q) {
        list[k++] = array[i++];
        *contador+=3;
    }
    while(j<=r) {
        list[k++]=array[j++];
        *contador+=3;
    }

    //printf("Sub arreglo 1 ");
    //printSubArray(array,p,q);

    //printf("Sub arreglo 2 ");
    //printSubArray(array,q+1,r);

    //printf("Mezcla: ");
    for(i=r; i>=p; i--) {
        array[i]=list[--k];
        *contador+=2;
    }
    //printSubArray(array,p,r);
    //printf("\n");
}





