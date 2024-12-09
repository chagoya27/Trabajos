#ifndef UTILIDADES_H_INCLUDED
#define UTILIDADES_H_INCLUDED

//funciones para coutingSort
void cargaArreglo(char *array,int n);
void imprimirArregloContador(int *array, int n);
void imprimirArreglo(char *array,int n);
void ZeroArreglo( char *array, int n);

//funciones para radixSort
void cargaArreglo2(int *array,int n);
void imprimirArreglo2(int *array,int n);
int unidades(int elem);
int decenas(int elem);
int centenas(int elem);
int miles(int elem);
#endif // UTILIDADES_H_INCLUDED
