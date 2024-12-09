#include <stdio.h>
#include "utilidades.h"
#include "ordenamientos.h"
#include "Cola.h"





void radixSort(int *array, int n) { //hara el procedimiento de tomar en cuenta las unidades decenas centenas y miles de acuerdo a la iteracion

    printf("El arreglo original es:\n");
    imprimirArreglo(array,n);

    //analizando las unidades
    printf("\nIteracion 1:\n");
    sort(array,n,unidades);
    imprimirArreglo(array,n);

    //analizando las decenas
    printf("\nIteracion 2:\n");
    sort(array,n,decenas);
    imprimirArreglo(array,n);

    //analizando las centenas
    printf("\nIteracion 3:\n");
    sort(array,n,centenas);
    imprimirArreglo(array,n);

    //analizando los miles
    printf("\nIteracion 4:\n");
    sort(array,n,miles);
    imprimirArreglo(array,n);



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

    i =0;
    printf("Cola 1: ");
    imprimirCola(cola1);
    printf("Cola 2: ");
    imprimirCola(cola2);
    printf("Cola 3: ");
    imprimirCola(cola3);
    printf("Cola 4: ");
    imprimirCola(cola4);
    //ira recorriendo la estructura cola quitando el primer elemento de la misma, dicho elemento sera asignado a nuestro arreglo
    recorrer(desencolar,cola1,array,&i);
    recorrer(desencolar,cola2,array,&i);
    recorrer(desencolar,cola3,array,&i);
    recorrer(desencolar,cola4,array,&i);

}



