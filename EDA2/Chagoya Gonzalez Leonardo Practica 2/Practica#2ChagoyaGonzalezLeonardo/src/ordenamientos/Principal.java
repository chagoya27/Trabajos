/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ordenamientos;

/**
 *
 * @author devyl
 */
public class Principal {
    public static void main(String args[]) {
        //Declara e inicializa un arreglo de 20 elementos
        int[] arr = new int[20];
        Utilidades.Inicializar(arr);
        System.out.println("Ordenamiento MergeSort");
        MergeSort.sort(arr,0,19);
        System.out.println("El arreglo ordenado es: ");
        Utilidades.printArray(arr);
    }
}
