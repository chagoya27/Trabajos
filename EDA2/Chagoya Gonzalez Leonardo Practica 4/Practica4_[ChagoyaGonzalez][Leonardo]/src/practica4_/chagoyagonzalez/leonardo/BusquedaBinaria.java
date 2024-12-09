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
public class BusquedaBinaria {
    
    //comprobara si el elemento clave existe en la lista
    //n es el numero de elementos en la lista
    static boolean Existencia(List<Integer> lista, int clave,int n){
        int[]array = new int [n];
        int i=0; //indice arreglo
        int izq,der,medio;
        
        for(Integer elem:lista){ //pasara los elementos de la lista a un arreglo mediante un ciclo for each
            array[i] = elem; 
            i++;
        }
        
        izq = 0;
        der = n-1;
        while(izq<=der){
            //System.out.println("Valor izquierda "+izq);
            medio = (der+izq)/2;
            //System.out.println("Valor medio "+medio);
            if (clave == array[medio])
                return true; //en cuanto encuentre un solo elemento de clave en el arreglo este devolverà true
            if (clave <array[medio])
                der = medio-1;
            if (clave>array[medio])
                izq = medio+1;
                    
        }
        return false; 
            
    }
    
    //contara cuantas veces aparece un elemento en la lista
    //n es el numero de elementos en la lista
    static int AparicionElemento(List<Integer> lista, int clave,int n){
        
        int cont =0;//variable que nos ayudara a realizar el conteo
        int aux;
        int izq,der,medio;
        int[]array = new int [n]; //instancia
        int i=0; //indice del arreglo
        
        for(Integer elem:lista){ //pasara los elementos de la lista a un arreglo mediante ciclo for each
            array[i] = elem; 
            i++;
        }
        
        izq = 0;
        der = n-1;
        while(izq<=der){
            medio = (der+izq)/2;
            if (clave == array[medio]){
                cont++; //en vez de retornar si la clave y el elemento en la lista coinciden se sumara al contador
               
                //una vez encontrado el valor puede que exista mas de uno hacia la izquierda o derecha inmediata
                while(izq!=medio && der!=medio){ //se recorre ambos extremos de izq y derecha
                    if(array[der]==clave)
                        cont++;
                    if(array[izq]==clave)
                        cont++;
                    der--;
                    izq++;
                
                }
                return cont;

            }
            if (clave <array[medio])
                der = medio-1;
            if (clave>array[medio])
                izq = medio+1;
                    
        }
        return cont; //contador sera =0 sino se encuentra nunca el elemento
        
    }
    
    
}
