/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Edgar
 */
public class Nodo {
    
    int valor; //valor del nodo
    Nodo izq = null; 
    Nodo der = null;
    
    public Nodo(){ //constructor de un nodo vacio 
        izq=der=null;
    }
    public Nodo(int data){ //constructor de un nodo que tendra un valor pero no hara referencia a mas nodos
        this(data,null,null); //se hace refencia al tercer constructor
    }
    public Nodo(int data, Nodo lt, Nodo rt){ //constructor de un nodo que en cada campo ya tiene refrencias hacia otros nodos
        valor=data;
        izq = lt;
        der = rt;
    }   
    
    public void setIzq(Nodo izq) { //agrega la referencia al atribudo izq que este a su vez es objeto Nodo
        this.izq = izq;
    }
    
    public void setDer(Nodo der) { //agrega refencia al atributo der que este a su vez es un objeto Nodo
        this.der = der;
    }

    
}
