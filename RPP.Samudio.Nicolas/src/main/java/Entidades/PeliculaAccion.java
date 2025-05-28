
package Entidades;


public class PeliculaAccion extends Pelicula implements IAlquilable {
    private GeneroAccion tipoAccion;

    public PeliculaAccion(String titulo, double precio, Director director, GeneroAccion tipoAccion) {
        super(titulo, precio, director);
        this.tipoAccion = tipoAccion;
    }

    public PeliculaAccion(String titulo, double precio, String nombre, String apellido, String dni, GeneroAccion tipoAccion) {
        super(titulo, precio, nombre, apellido, dni);
        this.tipoAccion = tipoAccion;
    }

@Override
public double getPrecioAlquiler() {
    double adicional;

    if (tipoAccion == GeneroAccion.AVENTURA) {
        adicional = 0.4;
    } else if (tipoAccion == GeneroAccion.BELICA) {
        adicional = 0.3;
    } else if (tipoAccion == GeneroAccion.SUPERHEROES) {
        adicional = 0.5;
    } else {
        adicional = 0; 
    }

    return precio * (1 + adicional);
}

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder(super.toString());
        sb.append(" - Género Acción: ").append(tipoAccion);
        return sb.toString();
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (!(obj instanceof PeliculaAccion)) return false;
        if (!super.equals(obj)) return false;
        PeliculaAccion otra = (PeliculaAccion) obj;
        return this.tipoAccion == otra.tipoAccion;
    }
}
