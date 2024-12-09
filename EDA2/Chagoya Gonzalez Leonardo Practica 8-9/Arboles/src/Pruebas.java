
import java.util.Scanner;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author Edgar
 */
public class Pruebas {

    public static void main(String args[]) {
        ArbolBin arbol;

        //Ejercicio1 a y b
        /*
        Nodo n7 = new Nodo(7);
        Nodo n9 = new Nodo(9);
        Nodo n1 = new Nodo(1,n7,n9); //nodo raiz
        Nodo n15 = new Nodo(15);
        Nodo n8 = new Nodo(8);
        Nodo n4 = new Nodo(4);
        Nodo n2 = new Nodo(2);
        Nodo n16 = new Nodo(16);
        Nodo n3 = new Nodo(3);
        
        arbol = new ArbolBin(n1);
        arbol.add(n7,n15,0);
        arbol.add(n7,n8,1);
        arbol.add(n9,n4,0);
        arbol.add(n9,n2,1);
        arbol.add(n15,n16,1);
        arbol.add(n8,n3,0);
        arbol.breadthFrist();
         */
        //Ejercicio c
        /*
        Nodo n12 = new Nodo(12);
        Nodo n30 = new Nodo(30);
        Nodo n20 = new Nodo(20,n12,n30); //nodo raiz
        Nodo n1 = new Nodo(1);
        Nodo n23 = new Nodo(23);
        Nodo n40 = new Nodo(40);
        Nodo n7 = new Nodo(7);
        Nodo n24 = new Nodo(24);
        Nodo n33 = new Nodo(33);
        Nodo n47 = new Nodo(47);
        
        ArbolBin arbol_2 = new ArbolBin(n20);
        arbol_2.add(n12, n1, 0);
        arbol_2.add(n30, n23, 0);
        arbol_2.add(n30, n40, 1);
        arbol_2.add(n1, n7, 1);
        arbol_2.add(n23, n24, 1);
        arbol_2.add(n40, n33, 0);
        arbol_2.add(n40, n47, 1);
        arbol_2.breadthFrist();
         
        
        //Ejercicio D y E
        //para ocuparlo se necesita el arbol del ejercicio C
        
        
        System.out.println("\n----------------Eliminando el nodo 47------------");
        arbol_2.Eliminacion(47);
        arbol_2.breadthFrist();
        System.out.println("\n--------------Eliminando a 23--------------");
        arbol_2.Eliminacion(23);
        arbol_2.breadthFrist();
        arbol_2.Lado(n47, 0);
        System.out.println("\n-------Eliminando el nodo 20----------");
        arbol_2.Eliminacion(20);
        arbol_2.breadthFrist();
        
        System.out.println("\n---------------Busqueda---------------");
        System.out.println("El valor 20 se encuentra en el arbol? "+arbol_2.Busqueda(20) );
        System.out.println("El valor 33 se encuentra en el arbol? "+arbol_2.Busqueda(33) );
         */
        //EJERCICIO 2
        //se construye otro arbol binario
        /*
        Nodo n8 = new Nodo(8);
        Nodo n15 = new Nodo(15);
        Nodo n4 = new Nodo(4,n8,n15); //nodo raiz
        Nodo n16 = new Nodo(16);
        Nodo n23 = new Nodo(23);
        Nodo n42 = new Nodo(42);
        Nodo n17 = new Nodo(17);
        Nodo n5 = new Nodo(5);
        Nodo n18 = new Nodo(18);
        Nodo n30 = new Nodo(30);
        Nodo n35 = new Nodo(35);
        Nodo n26 = new Nodo(26);
        
        ArbolBin arbol3 = new ArbolBin(n4);
        arbol3.add(n8, n16, 0);
        arbol3.add(n8, n23, 1);
        arbol3.add(n15, n42, 0);
        arbol3.add(n23, n17, 0);
        arbol3.add(n23, n5, 1);
        arbol3.add(n42, n18, 0);
        arbol3.add(n42, n30, 1);
        arbol3.add(n5,n35,0);
        arbol3.add(n5,n26,1);
        arbol3.breadthFrist();
        
        System.out.print("Recorrido en Preorden: ");
        arbol3.PreOrden(n4);
        System.out.println("");
        
        System.out.print("Recorrido en InOrden: ");
        arbol3.InOrden(n4);
        System.out.println("");
        
        System.out.print("Recorrido en PostOrden: ");
        arbol3.PostOrden(n4);
        System.out.println("");
         */
        //Ejercicio 3
        /*
        Nodo n120 = new Nodo(120); //nodo que sera raiz
        Nodo n87 = new Nodo(87);
        Nodo n140 = new Nodo(140);
        Nodo n43 = new Nodo(43);
        Nodo n99 = new Nodo(99);
        Nodo n130= new Nodo(130);
        Nodo n22 = new Nodo(22);
        Nodo n65 = new Nodo(65);
        Nodo n93 = new Nodo(93);
        Nodo n135 = new Nodo(135);
        Nodo n56 = new Nodo(56);
     
       
        ArbolBinBusq arbol4 = new ArbolBinBusq();
        arbol4.add(n120, n120, 2); //para añadir raiz
        
        arbol4.add(n120, n87, 2);
        arbol4.add(n120, n140, 2);
        arbol4.add(n120, n43, 2);
        arbol4.add(n120, n99, 2);
        arbol4.add(n120, n130, 2);
        arbol4.add(n120, n22, 2);
        arbol4.add(n120, n65, 2);
        arbol4.add(n120, n93, 2);
        arbol4.add(n120, n135, 2);
        arbol4.add(n120, n56, 2);

        
        
        
        
        arbol4.breadthFrist();
        System.out.println("\n---------------Eliminando 56-----------------");
        arbol4.Eliminacion(56);
        arbol4.breadthFrist();
        
        System.out.println("\n--------------Eliminando 120-----------");
        arbol4.Eliminacion(120);
        arbol4.breadthFrist();
        
        System.out.println("\n-------------Eliminando  87----------------");
        arbol4.Eliminacion(87);
        arbol4.breadthFrist();
         */
        //Ejercicio 4 y 6
        int op;
        Scanner entrada = new Scanner(System.in);

        System.out.println("-------------MENU PRINCIPAL-------------");
        System.out.print("1.-Arboles Binarios\n"
                + "2.-Arboles Binarios de Busqueda\n"
                + "3.-Arboles B\n"
                + "4.-Salir\n"
                + "Opcion: ");
        op = entrada.nextInt();
        switch (op) {
            case 1:
                MenuArbolBin();
                break;
            case 2:
                MenuArbolBinBusq();
                break;
            case 3:
                MenuArbolB();
                break;
            case 4:
                System.out.println("Programa terminado c:");
                break;
            default:
                System.out.println("No es una opcion valida");
        }

    }

    static void MenuArbolB() {
        BTree arbolB = null;
        Scanner entrada = new Scanner(System.in);
        int op;
        int valor;
        do {
            System.out.println("\n--------------Menu Arbol B----------------");
            System.out.print("1.-Crear Arbol\n"
                    + "2.-Agregar un valor\n"
                    + "3.-Buscar un valor\n"
                    + "4.-Imprimir Arbol\n"
                    + "5.-Salir\n"
                    + "Opcion: ");
            op = entrada.nextInt();
            switch (op) {
                case 1:
                    System.out.println("Creacion del arbol de orden 5");
                    arbolB = new BTree(5); //arbol de orden 5
                    break;

                case 2:
                    if (arbolB == null) {
                        System.out.println("No se puede operar sobre un arbol nulo");
                        break;
                    }
                    System.out.print("Ingrese el valor del nodo ");
                    valor = entrada.nextInt();
                    arbolB.add(valor);
                    break;

                case 3:
                    if (arbolB == null) {
                        System.out.println("No se puede operar sobre un arbol nulo");
                        break;
                    }
                    System.out.println("Valor a buscar: ");
                    valor = entrada.nextInt();
                    System.out.println("El valor existe dentro del arbol? "+arbolB.find(valor));
                    break;

                case 4:
                    if (arbolB == null) {
                        System.out.println("No se puede operar sobre un arbol nulo");
                        break;
                    }
                    arbolB.mostrarArbol();
                    break;

                case 5:
                    System.out.println("Proceso de arboles B terminado");
                    break;

                default:
                    System.out.println("Esa no es una opcion valida");
                    break;
            }

        } while (op != 5);

    }

    static void MenuArbolBin() {
        ArbolBin arbol = null;
        Scanner entrada = new Scanner(System.in);
        Nodo unNodo;
        Nodo nodoPadre;
        int valor;
        int valorPadre;

        int op;
        do {
            System.out.println("\n-----------Menu Arbol Binario----------");
            System.out.print("1.-CrearArbol\n"
                    + "2.-Agregar Dato\n"
                    + "3.-Eliminar dato\n"
                    + "4.-Imprimir Arbol\n"
                    + "5.-Notacion Prefija\n"
                    + "6.-Notacion Infija\n"
                    + "7.-Notacion Posfija\n"
                    + "8-Salir\n"
                    + "Opcion: ");
            op = entrada.nextInt();
            switch (op) {
                case 1:
                    System.out.print("Ingrese el valor del nodo raiz: ");
                    valor = entrada.nextInt();
                    unNodo = new Nodo(valor); //instancia del nodo raiz
                    arbol = new ArbolBin(unNodo); //instancia del arbol teniendo como raiz el nodo pasado como parametro
                    System.out.println("ARBOL CREADO CON EXITO");
                    break;

                case 2:
                    if (arbol == null) {
                        System.out.println("El arbol no ha sido creado");
                        break;
                    }
                    System.out.print("Ingrese el valor del padre: ");
                    valorPadre = entrada.nextInt();

                    if ("No".equals(arbol.Busqueda(valorPadre))) {
                        System.out.println("El nodo padre no existe");
                        break;
                    }

                    System.out.print("Ingrese el valor a agregar: ");
                    valor = entrada.nextInt();
                    unNodo = new Nodo(valor);

                    System.out.print("0.-Ingresar del lado izquierdo 1.-Ingresar del lado derecho    ");
                    op = entrada.nextInt();

                    if (arbol.root.valor == valorPadre) {
                        arbol.add(arbol.root, unNodo, op);
                        arbol.breadthFrist();
                    } else {

                        nodoPadre = arbol.BusquedaPadre(valorPadre);

                        System.out.println("Valor Padre");

                        if (nodoPadre.izq != null) {
                            if (nodoPadre.izq.valor == valorPadre) {
                                arbol.ImpresionNodo(nodoPadre.izq);
                                arbol.add(nodoPadre.izq, unNodo, op);
                            }
                        } else if (nodoPadre.der != null) {
                            if (nodoPadre.der.valor == valorPadre) {
                                arbol.ImpresionNodo(nodoPadre.der);
                                arbol.add(nodoPadre.der, unNodo, op);
                            }
                        }
                        arbol.breadthFrist();
                    }
                    break;

                case 3:
                    System.out.print("Ingrese el valor a eliminar: ");
                    valor = entrada.nextInt();
                    arbol.Eliminacion(valor);
                    break;

                case 4:
                    if (arbol == null) {
                        System.out.println("No se puede imprimir un arbol nulo");
                        break;
                    }
                    arbol.breadthFrist();

                    break;

                case 5:
                    if (arbol == null) {
                        System.out.println("No se puede realizar el recorrido en un arbol nulo");
                        break;
                    }
                    System.out.println("Recorrido Preorden");
                    arbol.PreOrden(arbol.root);
                    break;

                case 6:
                    if (arbol == null) {
                        System.out.println("No se puede realizar el recorrido en un arbol nulo");
                        break;
                    }
                    System.out.println("Recorrido InOrden");
                    arbol.InOrden(arbol.root);
                    break;

                case 7:
                    if (arbol == null) {
                        System.out.println("No se puede realizar el recorrido en un arbol nulo");
                        break;
                    }
                    System.out.println("Recorrido PostOrden");
                    arbol.PostOrden(arbol.root);
                    break;

                case 8:
                    System.out.println("Fin del Proceso para arbol binario c:");
                    break;

                default:
                    System.out.println("Esa no es una opcion valida ");
                    break;
            }

        } while (op != 8);

    }

    static void MenuArbolBinBusq() {
        Scanner entrada = new Scanner(System.in);
        ArbolBinBusq arbol = null;
        int op;
        int valor;
        Nodo unNodo;

        do {
            System.out.println("\n-------------MENU ARBOL BINARIO BUSQUEDA----------");
            System.out.print("1.-Crear Arbol\n"
                    + "2.-Agregar dato\n"
                    + "3.-Eliminar dato\n"
                    + "4.-Buscar\n"
                    + "5.-Imprimir Arbol\n"
                    + "6.-Salir\n"
                    + "Opcion: ");
            op = entrada.nextInt();
            switch (op) {
                case 1:
                    System.out.print("Ingrese el valor del nodo raiz: ");
                    valor = entrada.nextInt();
                    unNodo = new Nodo(valor); //instancia del nodo raiz
                    arbol = new ArbolBinBusq(unNodo); //instancia del arbol teniendo como raiz el nodo pasado como parametro
                    System.out.println("ARBOL CREADO CON EXITO");
                    break;

                case 2:
                    if (arbol == null) {
                        System.out.println("No se puede agregar a un Arbol nulo");
                        break;
                    }
                    System.out.print("Ingresa el valor del nodo a agregar: ");
                    valor = entrada.nextInt();
                    unNodo = new Nodo(valor);
                    arbol.add(arbol.root, unNodo, 2);
                    System.out.println("Ingreso exitoso");
                    break;

                case 3:
                    if (arbol == null) {
                        System.out.println("No se puede eliminar a un Arbol nulo");
                        break;
                    }
                    System.out.print("Ingresa el valor a eliminar: ");
                    valor = entrada.nextInt();
                    arbol.Eliminacion(valor);
                    break;

                case 4:
                    if (arbol == null) {
                        System.out.println("No se puede buscar en un Arbol nulo");
                        break;
                    }
                    System.out.println("Ingresa el valor del nodo a buscar: ");
                    valor = entrada.nextInt();
                    if (arbol.Busqueda(arbol.root, valor) != null) {
                        System.out.println("El nodo a buscar existe dentro del arbol");
                        break;
                    }
                    System.out.println("El nodo no existe");

                    break;

                case 5:
                    if (arbol == null) {
                        System.out.println("Arbol nulo");
                        break;
                    }
                    arbol.breadthFrist();
                    break;

                case 6:
                    System.out.println("Arbol binario de busqueda finalizado");
                    break;
                default:
                    System.out.println("No es una opcion valida");
                    break;

            }

        } while (op != 6);
    }
}
