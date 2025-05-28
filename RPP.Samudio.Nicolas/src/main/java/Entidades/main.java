
package Entidades;


public class main {

    public static void main(String[] args) {
        
        // Crear directores
Director d1 = new Director("Steven", "Spielberg", "12345678");
Director d2 = new Director("Christopher", "Nolan", "87654321");
// Peliculas de drama
PeliculaDrama drama1 = new PeliculaDrama("El Puente", 1000.0, "Michael", "Jackson", "11223344",
GeneroDrama.HISTÓRICO);
PeliculaDrama drama2 = new PeliculaDrama("Amor Real", 900.0, "Homero","Simpson","23019289",
GeneroDrama.ROMÁNTICO);
PeliculaDrama drama3 = new PeliculaDrama("Amor Real", 20.0, "Homero","Simpson","23019289",
GeneroDrama.ROMÁNTICO);
// Peliculas de acción
PeliculaAccion accion1 = new PeliculaAccion("Misión Final", 1200.0, d2, GeneroAccion.BELICA);
PeliculaAccion accion2 = new PeliculaAccion("Héroes Unidos", 1300.0, d1,
GeneroAccion.SUPERHEROES);
// Videoclub y agregar películas
VideoClub videoclub = new VideoClub(); // capacidad por defecto: 3
videoclub.agregar(drama1);
videoclub.agregar(drama2);
videoclub.agregar(drama3); // Debería no agregarse si ya se encuentra
videoclub.agregar(accion1);
videoclub.agregar(accion2); // Debería no agregarse si ya se llegó al límite
// Mostrar valores totales del videoclub
System.out.println("\n--- Detalle del Videoclub ---");
System.out.println(VideoClub.mostrarTotales(videoclub));
// Iterar las películas usando el Iterable
System.out.println("--- Iteración de Películas en el Videoclub ---");
for (Pelicula p : videoclub) {
System.out.println(p);
}
        
    }
}
