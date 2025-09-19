import java.util.*;
import java.time.LocalDateTime;

class Usuario {
    private String nombre;
    private String email;
    private List<Suscripcion> suscripciones;
    private List<Pelicula> historialPeliculas;
    
    public Usuario(String nombre, String email) {
        this.nombre = nombre;
        this.email = email;
        this.suscripciones = new ArrayList<>();
        this.historialPeliculas = new ArrayList<>();
    }
    
    public String getNombre() { return nombre; }
    public String getEmail() { return email; }
    public List<Suscripcion> getSuscripciones() { return suscripciones; }
    public List<Pelicula> getHistorialPeliculas() { return historialPeliculas; }
    
    public void agregarSuscripcion(Suscripcion suscripcion) {
        suscripciones.add(suscripcion);
    }
    
    public void agregarPeliculaAlHistorial(Pelicula pelicula) {
        historialPeliculas.add(pelicula);
    }
    
    public boolean tieneSuscripcionActiva() {
        for (Suscripcion suscripcion : suscripciones) {
            if (suscripcion.isActiva()) {
                return true;
            }
        }
        return false;
    }
    
    public void mostrarHistorial() {
        if (historialPeliculas.isEmpty()) {
            System.out.println("Sin películas vistas");
        } else {
            System.out.println("Películas vistas:");
            for (Pelicula pelicula : historialPeliculas) {
                System.out.println("  - " + pelicula.getTitulo());
            }
        }
    }
}

