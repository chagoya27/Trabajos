/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package practica4_.chagoyagonzalez.leonardo;

/**
 *
 * @author devyl
 */
public class Asignatura {
    
    //atributos
    String nombre;
    int clave;
    int creditos;
    int horasSemana;
    boolean acreditada;

    
    //metodo constructor
    public Asignatura(String nombre, int clave, int creditos) {
        this.nombre = nombre;
        this.clave = clave;
        this.creditos = creditos;
    }
    
    
    //metodo Constructor
    public Asignatura(String nombre, int clave, int creditos, int horasSemana, boolean acreditada){
        this.nombre = nombre;
        this.clave = clave;
        this.creditos = creditos;
        this.horasSemana = horasSemana;
        this.acreditada = acreditada;
    }
    
    
    //Setters
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setClave(int clave) {
        this.clave = clave;
    }

    public void setCreditos(int creditos) {
        this.creditos = creditos;
    }

    public void setHorasSemana(int horasSemana) {
        this.horasSemana = horasSemana;
    }

    public void setAcreditada(boolean acreditada) {
        this.acreditada = acreditada;
    }
    
    //adicionales
    public void Imprimir(){
        System.out.println("La asignarura es: "+nombre);
        System.out.println("Clave: "+clave);
        System.out.println("Num de creditos "+creditos);
    }
    
    
    
    
    
    
    
    
    
    
    
    
    
}
