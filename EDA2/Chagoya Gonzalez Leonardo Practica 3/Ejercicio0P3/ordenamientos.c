#include <stdio.h>
#include "utilidades.h"
#include "ordenamientos.h"
#include "Cola.h"

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





void radixSort(int *array, int n){ //hara el procedimiento de tomar en cuenta las unidades decenas centenas y miles de acuerdo a la iteracion

    printf("El arreglo original es:\n");
    imprimirArreglo2(array,n);

    //analizando las unidades
    printf("\nIteracion 1:\n");
    sort(array,n,unidades);
    imprimirArreglo2(array,n);

    //analizando las decenas
    printf("\nIteracion 2:\n");
    sort(array,n,decenas);
    imprimirArreglo2(array,n);

    //analizando las centenas
    printf("\nIteracion 3:\n");
    sort(array,n,centenas);
    imprimirArreglo2(array,n);

    //analizando los miles
    printf("\nIteracion 4:\n");
    sort(array,n,miles);
    imprimirArreglo2(array,n);



}


void sort(int *array, int n, int (*f)(int elem)) { //hace el procedimiento de colocar los elementos en estructuras tipo cola

    int i,aux;
    Nodo *unNodo;
    //creacion de estructuras tipo cola
    Cola *cola1 = nuevaCola();
    Cola *cola2 = nuevaCola();
    Cola *cola3 = nuevaCola();
    Cola *cola4 = nuevaCola();
    //

    for(i=0; i<n; i++) { //analizara cada elemento del arreglo original
        aux = f(array[i]); //obtiene las unidades, decenas,centenas, miles segun el caso
        unNodo = nuevoNodo(array[i]); //se crea un nodo con la informacion del elemento en turno

        //dependiendo del numero de unidades decenas, centenas o miles agregara el nodo creado en una cola
        if(aux ==1)
            encolar(cola1,unNodo);
        if(aux == 2)
            encolar(cola2,unNodo);
        if(aux == 3)
            encolar(cola3,unNodo);
        if(aux==4)
            encolar(cola4,unNodo);
    }

    //impresion de las estructuras
    printf("Cola 1: ");
    imprimirCola(cola1);
    printf("Cola 2: ");
    imprimirCola(cola2);
    printf("Cola 3: ");
    imprimirCola(cola3);
    printf("Cola 4: ");
    imprimirCola(cola4);
    //termino de impresion

     i =0; //contabilizara cuantos elementos extraidos de la cola se han agregado al arreglo, el numero de i coincidira con las posiciones de los elemntos en el arreglo al final de cada iteracion
    //ira recorriendo la estructura cola quitando el primer elemento de la misma, dicho elemento sera asignado a nuestro arreglo
    recorrer(desencolar,cola1,array,&i);
    recorrer(desencolar,cola2,array,&i);
    recorrer(desencolar,cola3,array,&i);
    recorrer(desencolar,cola4,array,&i);

}
