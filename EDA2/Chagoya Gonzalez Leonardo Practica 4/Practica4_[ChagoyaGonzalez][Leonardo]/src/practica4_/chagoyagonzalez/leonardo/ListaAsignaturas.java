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
public class ListaAsignaturas {
    
    
    //metodos
    //creacion de una lista de objetos Asignatura
    static void Creacion(List<Asignatura> lista){
        lista.add(new Asignatura("Estructura de datos y algortimos",1317,10));
        lista.add(new Asignatura("Probabilidad",111,8,4,true));
        lista.add(new Asignatura("Cultura y Comunicacion",1222,2));
        lista.add(new Asignatura("Estructura de datos y Algortimos",2222,10,6,false));
        lista.add(new Asignatura("Ecuaciones diferenciales",1325,8));
        lista.add(new Asignatura("Calculo vectorial",1321,8,4,true));
        lista.add(new Asignatura("Probabilidad",1436,8));
        lista.add(new Asignatura("Programacion orientada a Objetos",1323,10,4,false));
    }
    
    //imprime todos los objetos de la lista
    static void ImprimirLista (List<Asignatura>lista){
        System.out.println("La lista de asignaturas es: ");
        for(Asignatura elem:lista){
            elem.Imprimir();
            System.out.println("*****");
        }
    }
}
