/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author devyl
 */
public class ArbolBinBusq extends ArbolBin {

    public ArbolBinBusq() {
        root = null; //instancia la raiz con un valor nulo
    }

    public ArbolBinBusq(int val) {
        root = new Nodo(val); //instancia la raiz con la referencia de un nodo que tendra como valor val
    }

    public ArbolBinBusq(Nodo root) {
        this.root = root; //asigna una direccion de un nodo a la raiz
    }

    //realiza el proceso de recorrer el arbol deacuerdo al valo, si el valor es menor el recorrido lo hace por el sub arbol izquierdo
    //si el valor es mayor el recorrido lo hace por el sub arbol derecho
   
    @Override
    public void add(Nodo turno, Nodo n, int value) {
        if (value == 2) { //indicador de añadir raiz
            if (root == null) { //en caso de que la raiz este vacia
                root = n;
                return;
            }
        }

        if (n.valor < turno.valor) { //si el valor a insertar es menor que el nodo comparado en turno tiene que ir a la izquierda
            if (turno.izq == null) { //si no hay sub arbol izquierdo el nodo se inserta de forma directa
                turno.izq = n;
                return;
            } else {
                add(turno.izq, n, 2); //si hay sub arbol izquierdo
            }

        } else { //si el valor es mayor o igual
            if (turno.der == null) { //si no hay sub arbol derecho el nodo se inserta de forma directa
                turno.der = n;
                return;
            } else {
                add(turno.der, n, 2); //si hay sub arbol derecho
            }
        }
    }

    
    @Override
    public void Eliminacion(int value) {

        if (value == root.valor) { //si el nodo a eliminar es una raiz
            EliminarRaiz(value);
            
        } else {
            EliminarNodoIntermedio(value); //si el nodo a eliminar puede ser un nodo intermedio o una hoja o no existe
           
        }
    }

    private void EliminarRaiz(int value) {

        Nodo Padre; //contendra el padre del nodo a elmiminar
        Nodo PadremasDer; //contendra el padre del nodo encontrado mas derecho del subarbol izquierdo del nodo a eliminar
        Nodo masDer; //contiene el nodo mas a la derecha del sub arbol izquierdo
        Nodo eliminar; //es el nodo a eliminar

        eliminar = root; //la raiz es el nodo a eliminar
        System.out.println("No existe nodo padre de " + value);
        System.out.println("Eliminacion de una raiz");
        masDer = BuscarMasDer(eliminar.izq);
        if (masDer != null) { //el nodo a eliminar almenos tiene sub arbol izquierdo  
            PadremasDer = Busqueda(eliminar, masDer.valor);
            System.out.println("El nodo mas a la derecha del sub arbol izquierdo de " + value + "  es  " + masDer.valor);
            System.out.println("El padre " + masDer.valor + " es: " + PadremasDer.valor);
            System.out.println("Eliminacion de: " + eliminar.valor);

            if (PadremasDer == eliminar) { //caso en donde la raiz tiene sub arbol izquierdo pero este arbol ya no tiene nodos mas a la derecha
                ConvertirRaizHoja();

            } else { //la raiz tiene sub arbol izquierdo y ademas tiene mas nodos a la derecha
                SwapBinBusq(null,PadremasDer,eliminar,masDer); //intercambio de referencias
                System.out.println("Nueva raiz: "+root.valor);
                System.out.println("NODO A ELIMINAR: ");
                ImpresionNodo(eliminar);
                System.out.println("Se entra a eliminar el intermedio");
                
                
                ConvertirHoja(PadremasDer,eliminar,Lado(PadremasDer,value)); 
                System.out.println("Eliminando hoja");
                EliminarHoja(eliminar.valor);
                


            }

        } else { //en caso de que el nodo a eliminar no tenga sub arbol izquierdo
            System.out.println("No hay nodo mas a la derecha del sub arbol izquierdo");
            ConvertirRaizHoja();

        }
    }

    private void EliminarNodoIntermedio(int value) {

        Nodo Padre; //contendra el padre del nodo a elmiminar
        Nodo PadremasDer; //contendra el padre del nodo encontrado mas derecho del subarbol izquierdo del nodo a eliminar
        Nodo masDer; //contiene el nodo mas a la derecha del sub arbol izquierdo
        Nodo eliminar; //es el nodo a eliminar

        Padre = Busqueda(root, value); //busca el nodo padre asociado al nodo hijo que tiene por valor a value
        System.out.println("Haciendo el proceso de busqueda");
        if (Padre != null && value != root.valor) { //en caso de que se encuentre un nodo padre y que no sea la raiz
            eliminar = DarNodoHijo(Padre, value); //determina el nodo hijo
            System.out.println("El padre de " + eliminar.valor + " es: " + Padre.valor);
            masDer = BuscarMasDer(eliminar.izq); //determina el nodo mas a la derecha del sub arbol izquierdo
            if (masDer != null) { //el nodo a eliminar almenos tiene sub arbol izquierdo  
                PadremasDer = Busqueda(eliminar, masDer.valor); //determina el padre mas a la derecha partiendo del nodo a eliminar
                System.out.println("El nodo mas a la derecha del sub arbol izquierdo de " + value + "  es  " + masDer.valor);
                System.out.println("El padre " + masDer.valor + " es: " + PadremasDer.valor);
                System.out.println("Eliminacion de: " + eliminar.valor);

                if (PadremasDer == eliminar) { //caso en donde el nodo a eliminar tiene sub arbol izquierdo pero este arbol ya no tiene nodos mas a la derecha
                    ConvertirHoja(Padre, eliminar, Lado(PadremasDer, eliminar.valor)); //convierte el nodo a eliminar en una hoja
                    EliminarHoja(eliminar.valor); 

                } else { //en caso donde el nodo a eliminar si tiene sub arbol izquiero y ademas hay mas nodos a la derecha
                    
                    System.out.println("*********ANTES DEL INTERCAMBIO*********");
                    System.out.println("Valor del padre ");
                    ImpresionNodo(Padre);
                    System.out.println("Valor del padre mas a la derecha: ");
                    ImpresionNodo(PadremasDer);
                    System.out.println("Valor del nodo a eliminar ");
                    ImpresionNodo(eliminar);
                    System.out.println("Valor del nodo mas a la derecha ");
                    
                    SwapBinBusq(Padre, PadremasDer, eliminar, masDer); //intercambio de refencias, cambia el nodo a eliminar con el nodo encontrado mas a la derecha del subarbol izquierdo
                    
                    System.out.println("*********Despues DEL INTERCAMBIO*********");
                    System.out.println("Valor del padre ");
                    ImpresionNodo(Padre);
                    System.out.println("Valor del padre mas a la derecha: ");
                    ImpresionNodo(PadremasDer);
                    System.out.println("Valor del nodo a eliminar ");
                    ImpresionNodo(eliminar);
                    System.out.println("Valor del nodo mas a la derecha ");
                    ImpresionNodo(masDer);
                    
                    ConvertirHoja(PadremasDer, eliminar, Lado(PadremasDer,eliminar.valor)); //convierte en hoja al nodo a eliminar
                    ImpresionNodo(eliminar);
                    EliminarHoja(eliminar.valor);

                }

            } else { //en caso de que el nodo a eliminar no tenga sub arbol izquierdo
                System.out.println("No hay sub arbol izquierdo");
                ConvertirHoja(Padre, eliminar, 1); //se convierte a hoja el nodo a eliminar pero hacienndo primero por el sub arbol derecho
                EliminarHoja(eliminar.valor);
            }

        } else {
            System.out.println("El nodo a eliminar no se encuentra en el arbol");
        }

    }

    public void SwapBinBusq(Nodo Padre, Nodo PadreMasDer, Nodo eliminar, Nodo masDer) {

        Nodo temp;
        Nodo tempIzq;
        Nodo tempDer;

        System.out.println("****INTERCAMBIO DEL NODO MAS A LA DERECHA CON EL NODO A ELIMINAR*****");
        
        if(Padre == null){ //se trata de una raiz
            
            tempIzq = eliminar.izq;
            tempDer = eliminar.der;
            eliminar.izq = masDer.izq;
            eliminar.der = masDer.der;
            
            root = masDer; //se actualiza el nodo raiz;;
            
            masDer.der = tempDer;
            masDer.izq = tempIzq;
            
            PadreMasDer.der = eliminar; 
            return;    
        }

        if (Padre.izq == eliminar) { //si el nodo a elimanr es hijo izquierdo
            temp = Padre.izq;
            Padre.izq = masDer; //conexion del padre del nodo a eliminar con el nodo mas a la derecha
            PadreMasDer.der = temp; //conexion del padre mas a la derecha con el nodo a eliminar
        }
        if (Padre.der == eliminar) { //si el nodo a eliminar es hijo derecho
            temp = Padre.der;
            Padre.der = masDer; //conexion del padre del nodo aeliminar con el nodo mas a la derecha
            PadreMasDer.der = temp; //conexion del padre mas a la derecha con el nodo a eliminar

        }

        //intercambio de las referencias de eliminar con el nodo mas a la derecha
        tempIzq = eliminar.izq;
        tempDer = eliminar.der;

        eliminar.izq = masDer.izq;
        eliminar.der = masDer.der;
        masDer.izq = tempIzq;
        masDer.der = tempDer;



    }

    //devuelve el nodo hijo ya sea izquierdo o derecho del nodo Padre pasado como parametro la comparacion se hace atravez de los valores Padre.valor y n
    private Nodo DarNodoHijo(Nodo Padre, int n) {

        if (root.valor == n) {  //si el nodo es la raiz
            return root;
        }

        if (Padre.izq.valor == n) { //si el nodo es hijo izquierdo
            return Padre.izq;
        }
        if (Padre.der.valor == n) { //si el nodo es hijo derecho
            return Padre.der;
        }

        return null; //si no existe hijo

    }

    
    //proceso recursivo para buscar el nodo mas a la derecha
    private Nodo BuscarMasDer(Nodo n) {
        if (n == null) { //si el nodo pasado como parametro es nulo retorna
            return null;
        }
        if (n.der != null) {
            n = BuscarMasDer(n.der); //recorre por la parte de la derecha
        }
        return n; 
    }

    //proceso recursivo para determinar el nodo padre del nodo que tiene por valor a value
    protected Nodo Busqueda(Nodo turno, int value) {

        Nodo Padre = null;

        if(root.valor ==value){ //el valor a buscar es la raiz es un caso excepcional
            return root;
        }
        
        if (turno.valor > value) { //si el valor del nodo en turno es mayor que value quiere decir que nuestro nodo a buscar esta en la parte izquierda
            if (turno.izq != null) { //verifica que exista nodo izquierdo
                if (turno.izq.valor == value) { //compara el valor del nodo izquierdo de nuestro nodo en turno con value
                    Padre = turno; //si es igual encontramos al padre
                    return Padre; //retorna el padre
                } else {
                    Padre = Busqueda(turno.izq, value); //si no es igual sigue haciendo llamada recursiva por la parte izquierda

                }
            } else {
                return Padre;//si ya no hay mas nodos hacia el lado que le corresponde termina
            }

        } else if (turno.valor < value) { //si el valor del nodo en turno es menor que value quiere decir que nuestro nodo a buscar esta en la parte derecha
            if (turno.der != null) { //verificacion de que exista nodo derecho
                if (turno.der.valor == value) { //compara el valor del nodo izquierdo del nodo en turno con value
                    Padre = turno; //si es igual encontramos al padre
                    return Padre; //retorna padre
                } else {
                    Padre = Busqueda(turno.der, value);

                }
            } else {
                return Padre; //si ya no hay mas nodos hacia el lado que le corresponde termina
            }
        }
        return Padre;

    }

}
