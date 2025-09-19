public class Pelicula {
    private int id;
    private String titulo;
    private String genero;
    private int duracion;
    
    public Pelicula(int id, String titulo, String genero, int duracion) {
        this.id = id;
        this.titulo = titulo;
        this.genero = genero;
        this.duracion = duracion;
    }
    
    public int getId() { return id; }
    public String getTitulo() { return titulo; }
    public String getGenero() { return genero; }
    public int getDuracion() { return duracion; }
    
    @Override
    public String toString() {
        return "ID: " + id + " | " + titulo + " | " + genero + " | " + duracion + " min";
    }
}
