
package Entidades;

public class PeliculaDrama extends Pelicula implements IAlquilable {
    private GeneroDrama tipoDrama;

    public PeliculaDrama(String titulo, double precio, Director director, GeneroDrama tipoDrama) {
        super(titulo, precio, director);
        this.tipoDrama = tipoDrama;
    }

    public PeliculaDrama(String titulo, double precio, String nombre, String apellido, String dni, GeneroDrama tipoDrama) {
        super(titulo, precio, nombre, apellido, dni);
        this.tipoDrama = tipoDrama;
    }

    @Override
    public double getPrecioAlquiler() {
        double adicional = switch (tipoDrama) {
            case ROMÁNTICO -> 0.5;
            case SOCIAL -> 0.4;
            case HISTÓRICO -> 0.2;
        };
        return precio * (1 + adicional);
    }


    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(super.toString());
        sb.append(", Género Drama: ").append(tipoDrama);
        return sb.toString();
}

    
    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (!(obj instanceof PeliculaDrama)) return false;
        if (!super.equals(obj)) return false; 
        PeliculaDrama otra = (PeliculaDrama) obj;
        return this.tipoDrama == otra.tipoDrama;
}

    
}
