#ifndef ORDENAMIENTOS_H_INCLUDED
#define ORDENAMIENTOS_H_INCLUDED

//funciones para coutingSort
void countingSort(char *array,char *arrayOrdenado,int n);
void conteo(char *array,int *arrayConteo,int n);
void sumaConteo(int *arrayConteo, int n);
void fillZeros(int *arrayConteo, int n);
void couting(char *array, int *arrayConteo,char *arrayOrdenado, int n);
void acomodoArreglo(int *arrayConteo, int n);

//funciones para radixSort
void radixSort(int *array, int n);
void sort(int *array, int n, int (*f)(int elem));

#endif // ORDENAMIENTOS_H_INCLUDED
