/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package practica67;

import java.util.Iterator;
import java.util.LinkedList;

/**
 *
 * @author devyl
 */
public class Graph {

    //atributos
    int V; //numero de vertices del grafo
    LinkedList<Integer> adjArray[]; //areglo de listas

    //constructor 
    Graph(int v) {
        V = v; //numero de elementos de los vertices en el grafo
        adjArray = new LinkedList[v]; //instancia del arreglo de listas de tamaño v
        //inicializacion 
        for (int i = 0; i < V; i++) {
            adjArray[i] = new LinkedList(); //instancia cada elemento del arreglo con una lista ligada
        }
    }

    void addEdge(int v, int w) {
        adjArray[v].add(w); //en la lista que se encuentra en la posicion v añade el elemento w
        adjArray[w].add(v); //en la lista que se encuentra en la posicion w añade el elemento v
    }

    void addEdgeDireccion(int inicio, int destino) {
        adjArray[inicio].add(destino);

    }

    void printGraph(Graph graph) {
        for (int v = 0; v < graph.V; v++) {
            System.out.println("Lista de Adyaciencia del vertice " + v);
            System.out.println(v);
            for (Integer node : graph.adjArray[v]) {
                System.out.println("->" + node);
            }
            System.out.println("\n");
        }
    }

    //recorrido de BFS
    void BFS(int s) { //s es nodo de origen
        boolean visited[] = new boolean[V]; //instancia de un arreglo de booleanos  para saber que nodos estan visitados
        LinkedList<Integer> queue = new LinkedList<Integer>(); //instancia de una lista ligada de enteros
        visited[s] = true; // indica que el nodo fue visitado
        queue.add(s); //se añade a la cola el nodo inicial

        while (queue.size() != 0) {//mientras la cola tenga elementos
            s = queue.poll(); //devuelve el elemento al inicio de la lista
            System.out.print(s + " ");
            Iterator<Integer> i = adjArray[s].listIterator(); //instancia de un objeto iterador para la lista de s
            while (i.hasNext()) {  //si la lista tiene mas elementos
                int n = i.next(); //devuelve el siguiente elemento en la iteracion
                // System.out.println("el valor de n es: "+n);
                if (!visited[n]) { //en caso de que no este visitado
                    visited[n] = true; //marcar elemento como visitado
                    queue.add(n); //añadirlo a la cola
                }
            }
        }

    }

    void DFSUtil(int v, boolean visited[]) {
        visited[v] = true;
        System.out.print(v + " ");
        Iterator<Integer> i = adjArray[v].listIterator();
        while (i.hasNext()) { //mientras la lista no se encuentre vacia
            int n = i.next(); //obtencion del siguiente elemento en la lista
            if (!visited[n]) { //si no ha sido visitado
                DFSUtil(n, visited); //se aplica DFS sobre ese nodo
            }
        }
    }

    //algortimo de DFS
    void DFS(int v) { //v indica el nodo inicial
        boolean visited[] = new boolean[V];
        DFSUtil(v, visited);
    }

}
