/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package practica4_.chagoyagonzalez.leonardo;

/**
 *
 * @author devyl
 */
import java.util.LinkedList;
import java.util.List;

public class Practica4_ChagoyaGonzalezLeonardo {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        List<Integer> lista1 = new LinkedList<>();
       
        lista1.add(15);
        lista1.add(17);
        lista1.add(10);
        lista1.add(69);
        lista1.add(27);
        lista1.add(66);
        lista1.add(80);

        System.out.println(" Estado 1");
        imprimirLista(lista1);
        System.out.println(" *** ");

        lista1.add(2, 300);
        lista1.add(4, 500);
        lista1.add(5, 700);

        System.out.println("Estado 2");
        imprimirLista(lista1);
        System.out.println(" *** ");

        lista1.set(1, 14);
        lista1.set(2, 16);
        lista1.set(7, 18);

        System.out.println("Estado 3");
        imprimirLista(lista1);
        System.out.println(" *** ");

        List<Integer> lista2, lista3;
        lista2 = lista1.subList(2, 4);
        lista3 = lista1.subList(2, 4);
        imprimirLista(lista2);
        System.out.println(" *** ");
        imprimirLista(lista3);
        System.out.println(lista1.equals(lista2));
        System.out.println(" *** ");
        
      
        
        
        //Para ejemplificar el ejercicio1
        /*
        System.out.println("Estado 4 (borrando elementos de la lista 1)");
        lista1.remove(5); //recupera y elimina el elemento en la posicion 5 de la lista
        lista1.remove(1);
        imprimirLista(lista1);
        System.out.println(" *** ");
        
        

        
        System.out.println("Estado 5 buscar elementos dentro de una lista 2");
        System.out.println("Existencia del elemento: "+lista1.contains(18));
        imprimirLista(lista1);
        System.out.println(" *** ");
        
        
        
        System.out.println("Estado 6 comprobar si una lista esta vacia ");
        lista1.clear(); //se borran los elementos de la lista
        if( lista1.size()==0){
            System.out.println("La lista se encuentra vacia");
        }
        imprimirLista(lista1);
        System.out.println(" *** ");
        
        */
        
        
        // Para probar ejercicio 2
        /*
        int elem = 900; //elemento a buscar
        
        lista1.add(15);
        lista1.add(10);
        lista1.add(10);
        System.out.println("La lista al momento es: ");
        imprimirLista(lista1);
        System.out.println("*****");
        System.out.println("Buscando el numero "+elem);
        System.out.println("Existencia: "+BusquedaLineal.Existencia(lista1, elem));
        System.out.println("Posicion en donde se encuentra el elemento :"+BusquedaLineal.Posicion(lista1,elem));
        System.out.println("Numero de veces que aparece: "+BusquedaLineal.AparicionElemento(lista1, elem));
        */
        
        
        
        //Para probar Ejercicio 3
        /*
        lista1.add(15);
        lista1.add(10);
        lista1.add(10);
        int clave=15; //num a buscar
        System.out.println("La lista al momento es: ");
        imprimirLista(lista1);
        System.out.println("La lista ordenada es: ");
        BubbleSort.Bubble(lista1); //algoritmo de bubbleSort mejorado
        imprimirLista(lista1);
        System.out.println("Buscando el numero "+clave);
        System.out.println("Existencia: "+BusquedaBinaria.Existencia(lista1,clave,lista1.size()));
        System.out.println("Numero de veces que aparece: "+BusquedaBinaria.AparicionElemento(lista1,clave,lista1.size()));
        */
        
        
        
        //Para probar Ejericio 4
        /*
        String nombre = "Probabilidad"; //nombre de la materia
        int clave = 4; //num de horas a la semana
        List<Asignatura> lista = new LinkedList<Asignatura>(); //instancia de una lista Asignatura
        List<Asignatura> listaAparicion = new LinkedList<Asignatura>(); //tendra los elementos deeacuerdo a la busqueda
        ListaAsignaturas.Creacion(lista); //creacion de la lista de objetos Asignatura
        
        System.out.println("Busqueda por nombre de la asignatura: "+nombre); 
        listaAparicion = BusquedaLineal.busquedaNombre(lista,nombre); //busqueda por nombre
        ListaAsignaturas.ImprimirLista(listaAparicion); //impresion de los elementos encontrados deacuerdo a la busqueda
        
        System.out.println("\nBusqueda por numero de horas a la semana: "+clave); //busqueda por clave
        listaAparicion = BusquedaLineal.busquedaClave(lista,clave );
        ListaAsignaturas.ImprimirLista(listaAparicion);
        */
        
        
    }

    public static void imprimirLista(List<Integer> listaPrint) {
        for (Integer var : listaPrint) {
            System.out.println(var);
        }
    }

}
