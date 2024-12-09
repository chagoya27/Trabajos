/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package practica67;

import java.util.LinkedList;

/**
 *
 * @author devyl
 */
public class GraphPonderado {
    
    //atributos
    int V; //numero de vertices del grafo
    LinkedList<Integer> adjArray[]; //areglo de listas
    LinkedList<Integer> valores[]; //arreglo de listas para los valores de las aristas
    
    
    //constructor 
    GraphPonderado(int v){
        V = v; //numero de elementos de los vertices en el grafo
        adjArray = new LinkedList[v]; //instancia del arreglo de listas de tamaño v
        valores = new LinkedList[v];
        //inicializacion 
        for(int i=0;i<V;i++){
            adjArray[i]=new LinkedList(); //instancia cada elemento del arreglo con una lista ligada
            valores[i]= new LinkedList();
        }   
    }
    
     
    
    
    
    void addEdgeDireccion(int inicio, int destino, int valor){
        adjArray[inicio].add(destino);//agrega la relacion de la arista con el nodo inicio y destino
        valores[inicio].add(valor); //agrega en otra lista pero misma ubicacion el valor de la arista
    }
    
    //impresion del grafo creado
    void printGraph(GraphPonderado graph){
        for(int v=0;v<graph.V;v++){
            System.out.println("Lista de Adyaciencia del vertice "+v);
            for (int i=0; i<graph.adjArray[v].size(); i++){
                System.out.println("->"+graph.adjArray[v].get(i)+" valor de la arista "+valores[v].get(i));
            }
            System.out.println("\n");
        }
    }
    
    
    
    
}
