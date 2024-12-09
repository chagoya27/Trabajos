
import java.util.LinkedList;
import java.util.Queue;
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
public class ArbolBin {

    Nodo root; //nodo raiz

    public ArbolBin() {
        root = null; //instancia la raiz con un valor nulo
    }

    public ArbolBin(int val) {
        root = new Nodo(val); //instancia la raiz con la referencia de un nodo que tendra como valor val
    }

    public ArbolBin(Nodo root) {
        this.root = root; //asigna una direccion de un nodo a la raiz
    }

    public void add(Nodo padre, Nodo hijo, int lado) { //dependiendo de la variable lado agregara el objeto hijo a uno de los dos lados del nodo padre 
        if (lado == 0) {
            padre.setIzq(hijo);
        } else {
            padre.setDer(hijo);
        }
    }

    protected void visit(Nodo n) {
        System.out.print(n.valor + " "); //imprime el atributo valor del ojeto pasado como parametro
    }

    public void breadthFrist() { //recorrido por BFS del arbol binario
        Nodo r = root; //inicia con la raiz
        Queue<Nodo> queue = new LinkedList(); //cola de objetos nodos que actuará como una lista ligada
        System.out.print("Recorrido por BFS del arbol: ");
        if (r != null) {
            queue.add(r); //cola que almacenara los nodos visitados
            while (!queue.isEmpty()) { //mientras la cola no se encuentre vacia
                r = (Nodo) queue.poll();
                visit(r);
                if (r.izq != null) {
                    queue.add(r.izq);
                }
                if (r.der != null) {
                    queue.add(r.der);
                }
            }
        }
        System.out.println("");
    }

    //realiza el proceso de eliminacion de un nodo en el arbol
    //recibe como parametro un valor de tipo entero el cual corresponde al valor del nodo
    public void Eliminacion(int value) {

        Nodo Padre = BusquedaPadre(value); //se busca el nodo padre de nuestro nodo a eliminar
        if (Padre != null) { //si el padre se encuentra
            if (Padre.izq.valor == value) { //en caso de que el nodo a eliminar sea hijo izquierdo del padre
                System.out.println(" " + value + " es hijo izquierdo de " + " " + Padre.valor);
                ConvertirHoja(Padre, Padre.izq, 0); //proceso de convertir el nodo a eliminar en un nodo hoja
            }
            if (Padre.der.valor == value) { //en caso de que el nodo a eliminar sea hijo derecho del padre
                System.out.println(" " + value + " es hijo derecho de " + " " + Padre.valor);
                ConvertirHoja(Padre, Padre.der, 1); //proceso de convertir el nodo a eliminar en un nodo hoja
            }
            System.out.println("Eliminacion de hoja");
            EliminarHoja(value);
        } else { //en caso de que el padre no se encuentre

            if (value == root.valor) { //en caso de que el nodo a eliminar sea la raiz
                System.out.println("Eliminacion de la raiz");
                ConvertirRaizHoja();
                System.out.println("Eliminacion de hoja");
                EliminarHoja(value);

            } else { //si no se encuentra el padre y ademas el nodo a eliminar no es raiz
                //el nodo a eliminar no existe dentro del arbol
                System.out.println("No se ha encontrado  un nodo con el valor a eliminar");
            }

        }
    }

    protected void ConvertirRaizHoja() {
        Nodo raizTemp;
        
        if (root.izq != null) { //la raiz tiene subArbol izquierdo
            raizTemp = root.izq;
            Swap(root, root.izq);
            root = raizTemp;
            System.out.println("Nueva raiz " + root.valor);
            ConvertirHoja(root, root.izq, 0);
        } else if (root.der != null) { //la raiz tiene sub arbol derecho
            raizTemp = root.der;
            Swap(root, root.der);
            root = root.der;
            System.out.println("Nueva raiz " + root.valor);
            ConvertirHoja(root, root.der, 1);
        }

    }

    //indica si el nodo correspondiente a value es hijo izquierdo o derecho del nodo padre
    //en caso de que el nodo sea hijo izquierdo devuelve un 0
    //en caso de que el nodo sea hijo derecho devuelve un 1
    public int Lado(Nodo Padre, int value) {

        if (Padre == null) {
            System.out.println("El nodo Padre es nulo");
            return 2;
        }

        if (Padre.izq != null) {
            if (Padre.izq.valor == value) {
                System.out.println(" " + value + " es hijo izquierdo de " + " " + Padre.valor);
                return 0;
            }
        }

        if (Padre.der != null) {

            if (Padre.der.valor == value) {
                System.out.println(" " + value + " es hijo derecho de " + " " + Padre.valor);
                return 1;
            }

        }

        return 2;
    }

    //convierte el nodo Eliminar en una Hoja
    public void ConvertirHoja(Nodo Padre, Nodo Eliminar, int lado) {

        System.out.println("El padre del nodo a eliminar es: " + Padre.valor);
        if (Eliminar.izq == null && Eliminar.der == null) { //en caso de que el nodo a eliminar ya se haya convertido en una hoja se rompe la recursividad
            System.out.println("El nodo " + Eliminar.valor + " ya es hoja");
            return;
        }

        if (lado == 0) { //el nodo a eliminar se encuentra como hijo izquierdo del padre
            if (Eliminar.izq != null) { //si el hijo izquierdo del nodo a eliminar es distinto de null
                Padre.izq = Eliminar.izq; //conexion del nodo izquierdo del padre  con el nodo hijo izquierdo del nodo a eliminar

            } else if (Eliminar.der != null) { // en caso contrario si el hijo derecho del nodo a eliminar es distinto de null
                Padre.izq = Eliminar.der;

            }
            Swap(Eliminar, Padre.izq); //realiza un intercambio de las referencias hacia los nodos del nodo a eliminar y su hijo izquierdo
            ConvertirHoja(Padre.izq, Eliminar, Lado(Padre.izq, Eliminar.valor)); //proceso recursivo

        } else if (lado == 1) { //el nodo a eliminar se encuentra como hijo derecho del padre
            if (Eliminar.izq != null) { //si el nodo hijo izquierdo del nodo a eliminar es distinto de null
                Padre.der = Eliminar.izq;
            } else if (Eliminar.der != null) { // en caso contrario si el nodo hijo derecho del nodo a eliminar es distinto de null
                Padre.der = Eliminar.der;
            }
            Swap(Eliminar, Padre.der); //realiza un intercambio de las referencias hacia los nodos del nodo a eliminar y su hijo derecho
            ConvertirHoja(Padre.der, Eliminar, Lado(Padre.der, Eliminar.valor)); //proceso recursivo
        }

    }

    //Elimina el nodo correspondiente a value
    //este nodo sera una hoja si o si, ya que la unica forma de acceder a el es mediante el proceso Eliminacion
    protected void EliminarHoja(int value) {

        Nodo padre = BusquedaPadre(value);
        System.out.println("Nodo padre " + padre.valor + " de la hoja " + value);
        if (padre.izq != null) {
            if (padre.izq.valor == value) {
                padre.izq = null;
            }
        }
        if (padre.der != null) {
            if (padre.der != null) {
                if (padre.der.valor == value) {
                    padre.der = null;
                }
            }
        }
        System.out.println("EL nodo eliminado es: " + value);
    }

    //realiza el intercambio de las refencias a las que apuntan el padre y el hijo
    protected void Swap(Nodo Padre, Nodo Hijo) {
        System.out.println("**Intercambio**");
        Nodo izqTemp;
        Nodo derTemp;

        izqTemp = Padre.izq;
        derTemp = Padre.der;

        //el padre ahora tiene las referencias del hijo
        Padre.izq = Hijo.izq;
        Padre.der = Hijo.der;

        //determina las refencias que tendra el nodo hijo
        if (izqTemp == Hijo) {
            Hijo.izq = Padre;
            Hijo.der = derTemp;

        } else if (derTemp == Hijo) {
            Hijo.izq = izqTemp;
            Hijo.der = Padre;
        }

    }

    //mediante un recorrido BFS se busca el nodo padre del valor a requerido
    //en caso de encontrar el valor requerido se retorna su nodo padre
    public Nodo BusquedaPadre(int value) {
        Nodo r = root;
        Queue<Nodo> queue = new LinkedList(); //cola de objetos nodos que actuará como una lista ligada
        if (r != null) {
            queue.add(r); //cola que almacenara los nodos visitados
            while (!queue.isEmpty()) { //mientras la cola no se encuentre vacia
                r = (Nodo) queue.poll();
                if (r != null) {
                    //verificacion de los nodos adyacentes con value
                    if (r.izq != null) {
                        if (r.izq.valor == value) {
                            return r;
                        }
                    }
                    if (r.der != null) {
                        if (r.der.valor == value) {
                            return r;
                        }
                    }
                }

                if (r.izq != null) {
                    queue.add(r.izq);
                }
                if (r.der != null) {
                    queue.add(r.der);
                }
            }
        }

        return null; //en caso de no encontrarse retorna un null
    }

    //proceso de busqueda devuelve "Si" en caso de que el nodo buscado exista, devuelve "No" en caso contrario
    //se busca el nodo por medio del parametro valor
    public String Busqueda(int valor) {

        if (valor == root.valor) { //verificacion de que nuestro nodo buscado sea una raiz
            return "Si";
        }

        if (BusquedaPadre(valor) != null) { //si el nodo a buscar no es raiz se busca el padre del valor y si es distinto de null el nodo existe
            return "Si";
        }
        return "No";
    }

    public void ImpresionNodo(Nodo n) {
        if (n == null) {
            System.out.println("Nodo nulo");
            return;
        }

        System.out.println("Valor: " + n.valor);

        if (n.izq == null) {
            System.out.println("Hijo izq nulo");
        }

        if (n.der == null) {
            System.out.println("Hijo der nulo");
        }
        if (n.izq != null) {
            System.out.println("Hijo izq: " + n.izq.valor);

        }
        if (n.der != null) {
            System.out.println("Hijo der: " + n.der.valor);
        }

        System.out.println("*********************");

    }

    //notacion Prefija de un arbol binario
    public void PreOrden(Nodo n) {
        visit(n); //visita el nodo
        if (n.izq != null) { //examina el sub arbol izquierdo en caso de que exista
            PreOrden(n.izq);
        }
        if (n.der != null) { //examina el sub arbol derecho en caso de que exista
            PreOrden(n.der);
        }

    }

    //notacion Infija de un Arbol Binario
    public void InOrden(Nodo n) {
        if (n.izq != null) { //se recorre en inOrden el sub arbol izquierdo en caso de que exista
            InOrden(n.izq);
        }
        visit(n); //visita el nodo
        if (n.der != null) { //se recorre en inOrden el sub arbol derecho en caso de que exista
            InOrden(n.der);
        }
    }

    //notacion Posfija de un arbol binario
    public void PostOrden(Nodo n) {
        if (n.izq != null) { //se recorre el subarbol izquierdo en  caso de que exista
            PostOrden(n.izq);
        }
        if (n.der != null) { //se recorre el subarbol derecho en caso de que exista
            PostOrden(n.der);
        }
        visit(n); //visita del nodo
    }

}
