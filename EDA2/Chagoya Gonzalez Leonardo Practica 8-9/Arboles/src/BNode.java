

import java.util.ArrayList;

public class BNode {
    static int m; //numero de referencias
    ArrayList<Integer> key;  //arreglo de valores enteros que seran las claves
    ArrayList<BNode> child;  //arreglo de referencias hacia otros nodos B
    BNode parent;  //valor padre del nodo
    boolean leaf; //indicador de una hoja
    
    public BNode() {  //constructor
        key = new ArrayList();
        child = new ArrayList();
        leaf = true;
        parent = null;
    }
    
    public int getKey( int i ){
        return this.key.get(i);//Devuelve el elemento del array list key encontrado en la posicion i
    }
    
    public BNode getChild( int i ){
        try{
            this.child.get(i); //devuelve un Bnode del array list child encontrado en la posicion i
        }catch(Exception e){
            return null; //si el elemento en la posicion i se controla la excepcion y se retorna un null
        }
        return this.child.get(i);
    }
    
    //seters
    public void setM( int m ){
        this.m = m;
    }
    
    public void setKeys( ArrayList<Integer> list ){
        this.key = list;
    }
    
    public void setChildren( ArrayList<BNode> list  ){
        this.child = list;
    }
    

    public int getChildIndex(){
        if( parent == null ){
            return -1;
        }
        else{
            BNode padre = parent;
            for( int i = 0 ; i < padre.child.size() ; i++ ){
                if( padre.child.get(i) == this )
                    return i;
            }     
            return -1;
        }
    }
    
    public void mostrarLlaves(){
        for( int i = 0 ; i < key.size() ; i++ )
            System.out.print( key.get(i) + " " );
    }
   
    
    
    
}
