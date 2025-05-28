
package Entidades;


public class Director {
    
    private String nombre;
    private String apellido;
    private String dni;
    
    public Director(String nombre, String apellido, String dni) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.dni = dni;
    }

    public static boolean sonIguales(Director d1, Director d2) {
        return d1.nombre.equals(d2.nombre) &&
               d1.apellido.equals(d2.apellido) &&
               d1.dni.equals(d2.dni);
    }

    @Override
    public String toString() {
        return nombre + " " + apellido;
   
}    
    
    
    
    
 
}
