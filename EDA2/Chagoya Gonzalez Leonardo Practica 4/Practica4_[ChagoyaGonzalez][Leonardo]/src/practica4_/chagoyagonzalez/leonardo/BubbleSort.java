/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package practica4_.chagoyagonzalez.leonardo;

import java.util.List;

/**
 *
 * @author devyl
 */
public class BubbleSort {
    
    static void Bubble(List<Integer> lista){
        
        int n = lista.size();
        int i;
        int aux1, aux2,index1,index2;
        boolean ordenado = false;
        i = n;
        while(i>=0 && ordenado == false){
            ordenado = true;
            for (int j =0; j<(i-1);j++){
              if(lista.get(j)>lista.get(j+1)){ //realizacion del swap        
                aux1= lista.get(j); //retorna el elemento en la posicion j
                aux2 = lista.get(j+1); //retorna el elemento en la posicion j+1
                lista.set(j, aux2); //coloca en la posicion j el elemento aux2
                lista.set(j+1,aux1); //coloca en la posicion j+1 el elemento aux
                ordenado = false;
              }  
            }
            i--;
        }
        
    }
}
