/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package practica4_.chagoyagonzalez.leonardo;

import java.util.LinkedList;
import java.util.List;

/**
 *
 * @author devyl
 */
public class BusquedaLineal {
    
    //devuelve true si el numero que busca existe, false en caso contrario
    static boolean Existencia(List<Integer> lista, int clave){
        for(Integer elem:lista){ //bucle for each para recorrer los elementos de la lista
           if (elem==clave) //comparacion con el elemto a bucar
               return true;
        }
        return false;
        
    }
    
    //retorna la posicion en la que se encuentra el elemnto en la lista, -1 si no se encuentra
    static int Posicion(List<Integer> lista, int clave){
        int i=0;
        for(Integer elem:lista){ //recorre la lista mediante un bucle for each
            if(elem==clave)
                return i;
            i++;
        }
        return -1; //en caso de que no se encuentre el elemento
    }
    
    //indica cuantas veces aparece el elemento en la lista 
    static int AparicionElemento(List <Integer> lista, int clave){
        int cont =0; //variable auxiliar que realizara el conteo del elemento 
        for (Integer elem: lista){ //se recorre la lista mediante un bucle for each
            if (elem == clave)
                cont++;
        }
        return cont;
    }
    
    //PARA EJERCICIO 4
    
    static List<Asignatura> busquedaNombre(List<Asignatura> listaAsignaturas,String nombre){
        List<Asignatura> listaAparicion = new LinkedList<>(); //instanciar
      
        for(Asignatura elem:listaAsignaturas){ //bucle for each para recorrer la lista
            if(elem.nombre == nombre) //solo nos importa el campo del nombre de la asignatura
                listaAparicion.add(elem);
        }
        
        return listaAparicion;
    }
    
    
    static List<Asignatura>busquedaClave(List<Asignatura>listaAsignaturas,int clave){
        List<Asignatura> listaAparicion = new LinkedList<>();
        for (Asignatura elem: listaAsignaturas){
                if(elem.horasSemana == clave)
                    listaAparicion.add(elem);

        }
        return listaAparicion;
    }
    
    
}
