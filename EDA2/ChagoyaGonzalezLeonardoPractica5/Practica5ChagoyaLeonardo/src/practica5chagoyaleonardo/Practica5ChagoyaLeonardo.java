/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package practica5chagoyaleonardo;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/**
 *
 * @author devyl
 */
public class Practica5ChagoyaLeonardo {

    public static void main(String[] args) {
        // TODO code application logic here
        Scanner entrada = new Scanner(System.in);
        int op;

        Map<Integer, String> tabla = new HashMap<>(); //insntancia de un objeto de la clase Hash Map

        int clave = 318539822;
        String valor = "Ivan Mateos";
        Map<Integer, String> tabla2 = new HashMap<>(); //objeto atilizar para probar el metodo equals
        Map <Integer, String> tabla3 = new HashMap<>(); //objeto a utilizar para probar el metodo equals

        //agregar elementos para tabla 2      
        tabla2.put(clave, valor);

        //agregar elementos para tabla 1
        tabla.put(318218814, "Leonardo Chagoya");
        tabla.put(318321467, "Andrea Rojas");
        tabla.put(313599345, "Ivan Mateos");
        tabla.put(319865833, "Angel Serrano");
        tabla.put(318539822, "Vanesa Nava");
        tabla.put(318845761, "Omar Aguirre");
        tabla.put(313667425, "Heber Perez");
        tabla.put(318944924, "Alexa Quero");
        
        //agregar elementos para tabla 3
        tabla3.put(318218814, "Leonardo Chagoya");
        tabla3.put(318321467, "Andrea Rojas");
        tabla3.put(313599345, "Ivan Mateos");
        tabla3.put(319865833, "Angel Serrano");
        tabla3.put(318539822, "Vanesa Nava");
        tabla3.put(318845761, "Omar Aguirre");
        tabla3.put(313667425, "Heber Perez");
        tabla3.put(318944924, "Alexa Quero");

        System.out.println("--------PRACTICA 5------");
        do {
            System.out.println("-------------MENU-----------");
            System.out.print("1)Manejo de tablas hash\n2)Funcion Hash por modulo\n3)Encadenamiento\n4)Salir\nOpcion: ");
            op = entrada.nextInt();
            System.out.println("");
            switch (op) {
                case 1:
                    //tabla.Contains(clave);
                    Imprimir(tabla);
                    //contains key
                    System.out.println("\n***Utilizando el metodo containsKey***");
                    System.out.println("La clave: " + clave + " se encuentra en la tabla: " + tabla.containsKey(clave));
                    System.out.println("La clave 3111234 se encuentra en la tabla: "+tabla.containsKey(3111234));

                    //contaisValue
                    System.out.println("\n***Utilizando el metodo containsValue***");
                    System.out.println("El valor: " + valor + " se encuentra asignado por una o mas claves: " + tabla.containsValue(valor));
                    System.out.println("El valor Nikki se encuentra asignado por una o mas claves: "+tabla.containsValue("Nikki"));

                    //equals
                    System.out.println("\n****Utilizando el metodo equalss****");
                    System.out.println("Tabla 1");
                    Imprimir(tabla);
                    System.out.println("Tabla 2");
                    Imprimir(tabla2);
                    System.out.println("Tabla 3");
                    Imprimir(tabla3);
                    System.out.println("Comparando la igualdad de tabla 1 y tabla 2: " + tabla.equals(tabla2));
                    System.out.println("Comparando la igualdad de tabla 1 y tabla 3: "+tabla.equals(tabla3));

                    //get
                    System.out.println("\n****Utilizando el metodo get****");
                    System.out.println("Retornando el valor para la clave 123456789: " + tabla.get(123456789));
                    System.out.println("Retornando el valor para la clave 318845761 valor: "+tabla.get(318845761));

                    //put
                    System.out.println("\n****Utilizando el metodo put****");
                    System.out.println("Agregando a tabla 1 el valor Lemure asociado a la clave 123456789 ");
                    tabla.put(123456789, "lemure");
                    Imprimir(tabla);

                    //remove
                    System.out.println("\n****Utilizando el metodo remove***");
                    System.out.println("Eliminando de tabla 1 el valor asociado a la clave 318218814 ,valor removido: " + tabla.remove(318218814));
                    System.out.println("Eliminando de tabla 1 la clave 666666666 asociado a la clave kira   "+tabla.remove(666666666,"kira"));
                    System.out.println("Eliminando de tabla 1 la clave 123456789 asociado a la clave Vanesa Nava   "+tabla.remove(123456789,"Vanesa Nava"));
                    System.out.println("Eliminando de tabla 1 la clave 318539822 asociado a la clave Vanesa Nava   "+tabla.remove(318539822,"Vanesa Nava"));
                    Imprimir(tabla);

                    //size
                    System.out.println("\n****Utilizando el metodo size*****");
                    System.out.println("El numero de asignaciones clave-valor en tabla 1 es: " + tabla.size());
                    break;

                case 2:
                    //
                    System.out.println("\n*******FUNCION HASH POR MODULO********");
                    HashModulo obj = new HashModulo();
                    obj.Menu();
                    break;

                case 3:
                    //lIST
                    System.out.println("\n********ENCADENAMIENTO********");
                    Encadenamiento obj2 = new Encadenamiento();
                    obj2.MenuEncad();
                    break;
                case 4:
                    System.out.println("Gracias por usar el código c:");
                    break;
                default:
                    System.out.println("Esta no es una opcion valida");

            }
        } while (op != 4);

    }

    //imprime la tabla hash pasada como parametro
    public static void Imprimir(Map<Integer, String> tabla) {
        System.out.println("La tabla hash es ");
        System.out.println("Llave\t\tValor");

        for (Integer elem : tabla.keySet()) { //ciclo for each para ir tomando las llaves 
            System.out.println(elem + "\t" + tabla.get(elem)); //mediante las llaves se obtiene el elemento 
        }
        System.out.println("******************");
    }

}
