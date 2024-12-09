#include <stdio.h>
#include "utilidades.h"
#include "ordenamientos.h"

void countingSort(char *array,char *arrayOrdenado,int n) {
    int rango =10; //numero de letras de "a"-"j"
    int arregloConteo[rango];
    fillZeros(arregloConteo,rango); //coloca en 0 todos los espacios para el conteo
    conteo(array,arregloConteo,n);// cuenta cuantos elementos hay en la lista
    printf("EL numero de apariciones de cada elemento\n");
    imprimirArregloContador(arregloConteo,rango);
    sumaConteo(arregloConteo,rango);
    printf("Una vez realizada la suma\n");
    imprimirArregloContador(arregloConteo,rango);
    printf("Acomodando para que coincida con los indices\n");
    acomodoArreglo(arregloConteo,rango); //recordar que el indice en un arreglo inicia por el 0
    imprimirArregloContador(arregloConteo,rango);
    couting(array,arregloConteo,arrayOrdenado,n);

}

void fillZeros(int *arrayConteo, int n) {
    int i;
    for(i=0; i<n; i++) {
        arrayConteo[i]=0;
    }
}


void conteo(char *array, int*arrayConteo, int n) {

    int i;
    char aux; //identificar la letra a contar
    for(i=0; i<n; i++) {
        aux = array[i]; //obtiene la letra
        arrayConteo[aux-97]+=1;  //aux-97 se apoya del codigo ascii para obteneder el indice de cada letra
    }

}


void sumaConteo(int *arrayConteo, int n) {
    int i;
    for(i=0; i<n; i++) {
        arrayConteo[i]+=arrayConteo[i-1];
    }

}

void acomodoArreglo(int *arrayConteo, int n){
int i;
for(i=0;i<n;i++){
    arrayConteo[i]+= -1;
}

}

void couting(char *array, int *arrayConteo,char *arrayOrdenado, int n) {

    int i,pos;
    char aux;
    for(i=n-1; i>=0; i--){
        aux = array[i]; //obtiene el elemento
        printf("\nLa letra es: %c\n",aux);
        pos = arrayConteo[aux-97]; //determina la posicion del elemento en el arreglo conteo
        arrayConteo[aux-97]-=1;
        arrayOrdenado[pos]=aux; //coloca el elemento en la posicion correspondidnete al arreglo del conteo
        printf("Ingresando la letra: \n");
        imprimirArreglo(arrayOrdenado,n);
        printf("El arreglo contador es:\n");
        imprimirArregloContador(arrayConteo,10);

    }

}
