/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package practica5chagoyaleonardo;

import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

/**
 *
 * @author devyl
 */
public class HashModulo {

    public void Menu() {

        List<Integer> lista = new LinkedList<>();
        Scanner entrada = new Scanner(System.in);
        int valor;
        int op;

        //inicializacion de la lista
        for (int i = 0; i < 15; i++) {
            lista.add(null);
        }
        System.out.println("Lista inicializada con 15 elementos nulos");
        do {
            
            System.out.println("\n------------MENU------------");
            System.out.print("1.-Agregar Elementos\n2.-Imprimir Lista\n3.-Buscar Elementos\n4.-Salir\nOpcion: ");
            op = entrada.nextInt();
            switch (op) {
                //plegamiento agregar elementos
                case 1:
                    System.out.println("\n******AGREGAR*****");
                    System.out.println("Ingrese el valor: ");
                    valor = entrada.nextInt();
                    valor = Verificacion(valor);
                    HashMod(lista,valor);
                    break;
                
                //impresion de la lista
                case 2:
                    Imprimir(lista);
                    break;
                
                //busqueda de elemento
                case 3:
                    System.out.println("\n******BUSQUEDA*****");
                    System.out.println("Ingrese el valor: ");
                    valor = entrada.nextInt();
                    valor = Verificacion(valor);
                    Busqueda(lista,valor);

                    break;
                    
                    
                case 4:
                    System.out.println("Proceso de Hash modulo terminado");
                    break;
                    
                    
                default:
                    System.out.println("No es una opcion valida");
            }

        } while (op != 4);

    }

    //obtiene la conversion de la clave por pregamiento de 4 bloques y aplica el modulo
    public int Plegamiento(int valor) {
        int pos;

        int bloque;
        int claveAux = valor;
        int sumaBloques = 0;
        
        //obtencion del primero bloque de 4 digitos
        bloque = claveAux / 100000;
        claveAux = claveAux % 100000;
        System.out.println("El bloque de informacion es: "+bloque);
        sumaBloques += bloque;

        //obtencion del segundo bloque de 4 digitos
        bloque = claveAux / 10;
        System.out.println("El bloque de informacion es: "+bloque);
        sumaBloques += bloque;

        //obtencion del ultimo digito
        bloque = claveAux % 10;
        System.out.println("El bloque de informacion es: "+bloque);
        sumaBloques += bloque;

        System.out.println("La suma de los bloques es: "+sumaBloques);
        
        bloque = sumaBloques %100; //obtencion de los 2 ultimos digitos
        System.out.println("Los dos ultimos digitos: "+bloque);
        pos = bloque%15;
        System.out.println("La posicion inicial del elemento debe de ser: "+pos);
        return pos;
    } 
    
    
    public void HashMod(List <Integer> lista,int valor){
        int pos;
        pos = Plegamiento(valor);
        
        //solucion de colision por prueba lineal
        if (lista.get(pos) != null) {
            System.out.println("\nHay una colision la posicion esta siendo ocupada!!\n");
            for (int j = (pos + 1); j < 15; j++) {
                if (lista.get(j) == null) { //si la posicion esta con elemento nulo se puede agregar el elemento 
                    lista.set(j, valor);
                    System.out.println("El valor "+valor+" fue ingresado en la posicion "+j);
                    return ;
                }
            }
             //no se pudo solucionar la colision ya que no hay mas espacios disponibles
             System.out.println("El elemento no pudo ser ingresado en la lista");
             return;
        }
        //en caso de que no haya colision
        lista.set(pos,valor);
        System.out.println("El valor "+valor+" fue ingresado en la posicion "+pos);

    }
    
    
    public void Busqueda(List<Integer> lista, int valor){
        int pos;
        pos = Plegamiento(valor);
        
        if(lista.get(pos)== null){
            System.out.println("El valor "+valor+" no fue encontrado en la lista");
            return;
        }
            
        if (lista.get(pos)!=valor){ //puede que el valor no este en la posicion que inicialmente le corresponde
            for (int j=(pos+1);j<15;j++){
                if (lista.get(j)==valor){
                    System.out.println("El valor "+valor+" fue encontrado en la posicion "+j);
                }
            }
        }
        System.out.println("El valor "+valor+" fue encontrado en la posicion "+pos);
        
    }
    
    //imprime las claves y los valores de la lista
    public void Imprimir(List <Integer>lista){
        System.out.println("\nLa lista al momento es:");
        System.out.println("Llave/Posicion\tValor");
        int i=0; //para las posiciones
        for (Integer elem:lista){
            System.out.println(i+"\t\t"+elem);
            i++;
        }
    }
    
    //verifica que el elemento ingresado sea un numero de 9 digitos
    public int Verificacion(int valor){
        
        Scanner entrada = new Scanner(System.in);
        
        if (valor>=100000000 && valor<=999999999){
            System.out.println("El valor ingresado es correcto");
        }
        else{
            do{
                System.out.println("El valor ingresado es incorrecto");
                System.out.println("Ingrese un nuevo valor: ");
                valor = entrada.nextInt();
            }while(valor<100000000 || valor>999999999);
        }
        
        return valor;    
        
    }

}
