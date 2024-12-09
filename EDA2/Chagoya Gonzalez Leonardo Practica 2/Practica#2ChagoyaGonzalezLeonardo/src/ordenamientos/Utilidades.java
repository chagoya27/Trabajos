/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ordenamientos;

import java.util.Scanner;

/**
 *
 * @author devyl
 */
public class Utilidades {
    
    static void printArray(int arr[]){
        int n=arr.length;
        for(int i=0;i<n;++i){
            System.out.print(arr[i]+" ");
        }
        System.out.println();
    }
    
    static void printSubArray(int arr[],int low, int high){
        int i;
        System.out.print("Sub Array: ");
        for(i=low; i<=high; i++){
            System.out.print(" "+ arr[i]);   
        }
        System.out.println();
    }
    
    static void swap(int arr[],int i,int j){
      int temp = arr[i];
      arr[i]=arr[j];
      arr[j]=temp;
    }
    
    static void Inicializar(int arr[]){
        Scanner entrada = new Scanner(System.in);
        for(int i=0;i<arr.length;i++){
            System.out.print("Ingresa un numero: ");
            arr[i]=entrada.nextInt();
        }
    }
}
