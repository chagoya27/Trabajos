/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package practica5chagoyaleonardo;

import java.util.LinkedList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

/**
 *
 * @author devyl
 */
public class Encadenamiento {

    public void MenuEncad() {

        Scanner entrada = new Scanner(System.in);
        int op; //variable para el menu
        int valor, clave;
        
        List<List<Integer>> listaDeListas = new LinkedList<List<Integer>>(); //instancia de la lista de listas de enteros
        for (int i = 0; i < 15; i++) {
            listaDeListas.add(new LinkedList<Integer>()); //geenerar dentro de la lista principal 15 sub listas ligadas
        }

        while (true) {
            System.out.println("------------MENU----------");
            System.out.print("1.-Agregar Elemento\n2.-Salir\nOpcion: ");
            op = entrada.nextInt();

            if (op == 1) {
                System.out.print("Ingrese el numero: ");
                valor = entrada.nextInt();
                clave = Random();
                listaDeListas.get(clave).add(valor); //Agregar elemento por encadenamiento
                System.out.println("EL valor "+valor+" fue colocado en la poscion "+clave);
                Imprimir(listaDeListas);
            } else if (op == 2) {
                System.out.println("Fin de Encadenamiento");
                return;
            } else {
                System.out.println("Opcion invalida");
            }
        }

    }

    public int Random() {
        int num;
        Random aleatorio = new Random();
        num = aleatorio.nextInt(15); //devuelve un numero entero entre 0 y 14
        return num;
    }

    public void Imprimir(List<List<Integer>> listaDeListas) {
        System.out.println("El estado global de la lista es: ");
        for (int i = 0; i < 15; i++) {
            System.out.print("LISTA " + i + ":");
            for (Integer elem : listaDeListas.get(i)) {
                System.out.print(" " + elem);
            }
            System.out.println("");
        }
    }

}
