
package Entidades;

import java.util.ArrayList;
import java.util.Iterator;

public class VideoClub implements Iterable<Pelicula>, Iterator<Pelicula> {
    private int capacidad;
    private int posicion;
    private ArrayList<Pelicula> peliculas;

    public VideoClub() {
        this.capacidad = 3;
        this.peliculas = new ArrayList<>();
        this.posicion = 0;
    }

    public VideoClub(int capacidad) {
        this.capacidad = capacidad;
        this.peliculas = new ArrayList<>();
        this.posicion = 0;
    }

    private boolean sonIguales(Pelicula p) {
        for (Pelicula peli : peliculas) {
            if (peli.equals(p)) return true;
        }
        return false;
    }

    public void agregar(Pelicula p) {
        if (peliculas.size() >= capacidad) {
            System.out.println("No hay más capacidad para almacenar películas.");
        } else if (sonIguales(p)) {
            System.out.println("La película ya se encuentra en el videoclub.");
        } else {
            peliculas.add(p);
        }
    }

    private double getPrecio(Class<?> tipoPelicula) {
        double total = 0;
        for (Pelicula peli : peliculas) {
            if (tipoPelicula.isInstance(peli) && peli instanceof IAlquilable) {
                total += ((IAlquilable) peli).getPrecioAlquiler();
            }
        }
        return total;
    }

    public double getPrecioPeliculasDrama() {
        return getPrecio(PeliculaDrama.class);
    }

    public double getPrecioPeliculasAccion() {
        return getPrecio(PeliculaAccion.class);
    }


    public double getPrecioTotal() {
        double total = 0;
        for (Pelicula peli : peliculas) {
            if (peli instanceof IAlquilable) {
                total += ((IAlquilable) peli).getPrecioAlquiler();
            }
        }
        return total;
    }
    
    
    public static String mostrarTotales(VideoClub vc) {
        StringBuilder sb = new StringBuilder();
        sb.append("Cantidad de películas: ").append(vc.peliculas.size()).append("\n");
        sb.append("Precio total películas drama: ").append(vc.getPrecioPeliculasDrama()).append("\n");
        sb.append("Precio total películas acción: ").append(vc.getPrecioPeliculasAccion()).append("\n");
        sb.append("Precio total de todas las películas: ").append(vc.getPrecioTotal());
        return sb.toString();
    }

   
    @Override
    public boolean hasNext() {
        return posicion < peliculas.size();
    }

    @Override
    public Pelicula next() {
        return peliculas.get(posicion++);
    }

    @Override
    public Iterator<Pelicula> iterator() {
        this.posicion = 0;
        return this;
    }
}