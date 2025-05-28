package Entidades;

import java.util.Random;

public abstract class Pelicula {
    protected Director director;
    protected int cantidadDeEscenas;
    protected String titulo;
    protected double precio;
    protected static Random generadorDeEscenas;

    static {
        generadorDeEscenas = new Random();
    }

    public Pelicula(String titulo, double precio, Director director) {
        this.titulo = titulo;
        this.precio = precio;
        this.director = director;
    }

    public Pelicula(String titulo, double precio, String nombre, String apellido, String dni) {
        this.titulo = titulo;
        this.precio = precio;
        this.director = new Director(nombre, apellido, dni);
    }

    public int getCantidadDeEscenas() {
        if (cantidadDeEscenas == 0) {
            cantidadDeEscenas = generadorDeEscenas.nextInt(31) + 20;
        }
        return cantidadDeEscenas;
    }

    private static String mostrarPelicula(Pelicula p) {
            StringBuilder sb = new StringBuilder();
            sb.append("Título: ").append(p.titulo)
                .append(", Precio: ").append(p.precio)
                .append(", Director: ").append(p.director.toString())
                .append(", Escenas: ").append(p.cantidadDeEscenas);
        return sb.toString();
    }

    public static boolean sonIguales(Pelicula p1, Pelicula p2) {
        return p1.titulo.equals(p2.titulo) &&
               Director.sonIguales(p1.director, p2.director);
    }

    @Override
    public boolean equals(Object obj) {
        if (obj instanceof Pelicula) {
            Pelicula otra = (Pelicula) obj;
            return sonIguales(this, otra);
        }
        return false;
    }

    @Override
    public String toString() {
        return titulo + " - " + director.toString() + " - Escenas: " + getCantidadDeEscenas();
    }
}
