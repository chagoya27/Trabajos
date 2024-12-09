/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ordenamientos;

/**
 *
 * @author devyl
 */
public class QuickSort {
    
    
    static int partition(int arr[], int low, int high) {
        int pivot = arr[high];
        System.out.println("El pivote es: "+pivot);
        int i = (low - 1);
        for (int j = low; j < high; j++) {
            if (arr[j] <= pivot) {
                i++;
                Utilidades.swap(arr, i, j);
            }
        }
        int temp = arr[i + 1];
        arr[i + 1] = arr[high];
        arr[high] = temp;   
        System.out.println("Una vez colocado el pivote en su posicion ");
        Utilidades.printArray(arr);
        return (i + 1);
    }

    static void quickSort(int arr[], int low, int high) {
        if (low < high) {
            int pi = partition(arr, low, high);
            System.out.println("Izquierda ");
            Utilidades.printSubArray(arr, low, pi-1);
            quickSort(arr, low, pi - 1);
            System.out.println("Derecha ");
            Utilidades.printSubArray(arr, pi+1, high);
            quickSort(arr, pi + 1, high);
        }
    }
}
