/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package practica67;

import java.util.Scanner;

/**
 *
 * @author devyl
 */
public class Practica67 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        /*
        Graph graph= new Graph(5);
        graph.addEdge(0,1);
        graph.addEdge(0,4);
        graph.addEdge(1,2);
        graph.addEdge(1,3);
        graph.addEdge(1,4);
        graph.addEdge(2,3);
        graph.addEdge(3,4);
        graph.printGraph(graph);
         */

        Scanner entrada = new Scanner(System.in);
        int op; //para indicar la opcion del menu
        int V; //indicara el numero de nodos de un grafo
        int A; //indicara el numero de aristas para los grafos
        int valor1; //indicara el nombre del nodo
        int valor2; //indicara el nombre de otro nodo
        int valor3; //para grafos ponderados colocar el valor de las aristas

        Graph graph;
 
        //para ejercicio 1,2,3
        /*
        do {
            System.out.println("**********PRACTICA 6-7**********");
            System.out.print("1.-Grafo no dirigido\n2.-Grafo dirigido\n3.-Ponderado Dirigido\n4.-Salir\nOpcion: ");
            op = entrada.nextInt();
            switch (op) {

                case 1:
                    //para grafos no dirigidos
                    //proceso de ingreso de numero de nodos y aristas
                    System.out.println("*********Grafo no dirigido******");
                    System.out.println("Construccion\n");
                    System.out.print("Ingrese el numero de nodos que contendra el grafo: ");
                    V = entrada.nextInt();
                    System.out.print("Ingrese la cantidad de aristas que contendra el grafo: ");
                    A = entrada.nextInt();
                    graph = new Graph(V);

                    //proceso de ingreso de aristas
                    for (int i = 0; i < A; i++) {
                        System.out.println("\nArista Num " + (i + 1));
                        System.out.print("Ingrese el nombre de un nodo (valor numerico): ");
                        valor1 = entrada.nextInt();
                        System.out.print("Ingrese el nombre del nodo con quien tendra conexion por medio de una arista: ");
                        valor2 = entrada.nextInt();
                        System.out.println("");
                        graph.addEdge(valor1, valor2);
                    }
                    System.out.println("");
                    graph.printGraph(graph); //impresion del grafo construido
                    break;

                case 2:
                    //para grafos dirigidos
                    //proceso de ingreso de numero de nodos y aristas
                    System.out.println("*********Grafo Dirigido******");
                    System.out.println("Construccion\n");
                    System.out.print("Ingrese el numero de nodos que contendra el grafo: ");
                    V = entrada.nextInt();
                    System.out.print("Ingrese la cantidad de aristas que contendra el grafo: ");
                    A = entrada.nextInt();
                    graph = new Graph(V);

                    //proceso de ingreso de aristas
                    for (int i = 0; i < A; i++) {
                        System.out.println("\nArista Num " + (i + 1));
                        System.out.print("Ingrese el nodo del que parte la arista: ");
                        valor1 = entrada.nextInt();
                        System.out.print("Ingrese el nodo destino: ");
                        valor2 = entrada.nextInt();
                        System.out.println("");
                        graph.addEdgeDireccion(valor1, valor2);
                    }
                    System.out.println("");

                    graph.printGraph(graph);//impresion del grafo construido
                    break;

                case 3:
                    //para grafos ponderados dirigidos
                    //proceso de ingreso de numero de nodos y aristas
                    System.out.println("********GRAFO PONDERADO DIRIGIDO*******");
                    System.out.println("Construccion\n");
                    System.out.print("Ingrese el numero de nodos que contendra el grafo: ");
                    V = entrada.nextInt();
                    System.out.print("Ingrese la cantidad de aristas que contendra el grafo: ");
                    A = entrada.nextInt();
                    
                    GraphPonderado grafo = new GraphPonderado(V);
                    

                    //proceso de ingreso de aristas
                    for (int i = 0; i < A; i++) {
                        System.out.println("Arista Num " + (i + 1));
                        System.out.print("Ingrese el nodo del que parte la arista: ");
                        valor1 = entrada.nextInt();
                        System.out.print("Ingrese el nodo destino: ");
                        valor2 = entrada.nextInt();
                        System.out.print("Ingrese el valor para esta arista: ");
                        valor3 = entrada.nextInt();
                        System.out.println("");
                        grafo.addEdgeDireccion(valor1, valor2, valor3);
                    }
                    System.out.println("");
                    grafo.printGraph(grafo);//impresion del grafo construido
                    break;

                case 4:
                    System.out.println("Practica terminada siuuuuuuuuu");
                    break;
            }
        } while (op != 4);
        
       */
        
        //Para ejercicio 4
        /*
        graph = new Graph(9);
        graph.addEdgeDireccion(0,1);
        graph.addEdgeDireccion(0,2);
        graph.addEdgeDireccion(0,3);
        graph.addEdgeDireccion(1,4);
        graph.addEdgeDireccion(1,5);
        graph.addEdgeDireccion(2,6);
        graph.addEdgeDireccion(3,8);
        graph.addEdgeDireccion(4,7);
        graph.addEdgeDireccion(5,7);
        graph.printGraph(graph);
        System.out.println("Recorrido de BFS iniciando en nodo 0 para un grafo no dirigido");
        graph.BFS(0);
        System.out.println("\nRecorrido de BFS iniciando en nodo 8 para un grafo no dirigido");
        graph.BFS(8);
        System.out.println("\nRecorrido de BFS iniciando en nodo 2 para un grafo no dirigido");
        graph.BFS(2);
        System.out.println("\nRecorrido de BFS iniciando en nodo 5 para un grafo no dirigido");
        graph.BFS(5);
        */
        
        //Para ejercicio 5
        /*
        graph = new Graph(8);
        graph.addEdge(1,5);
        graph.addEdge(5, 4);
        graph.addEdge(5, 7);
        graph.addEdge(4, 0);
        graph.addEdge(0, 2);
        graph.addEdge(0, 6);
        graph.addEdge(7,3);
        graph.printGraph(graph);
        
        System.out.print("Aplicando DFS  con el nodo inicial en 1: ");
        graph.DFS(1);
        System.out.println("");
        System.out.print("Aplicando DFS  con el nodo inicial en 4: ");
        graph.DFS(4);
        System.out.println("");
        System.out.print("Aplicando DFS  con el nodo inicial en 6: ");
        graph.DFS(6);
        */
        
        
        
        
        
        
        

        
        

    }

}
