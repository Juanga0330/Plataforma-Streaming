public class Plan {
    private int id;
    private String nombre;
    private double precio;
    private int numeroPantallas;
    private String calidadVideo;
    private boolean descargas;
    
    public Plan(int id, String nombre, double precio, int numeroPantallas, String calidadVideo, boolean descargas) {
        this.id = id;
        this.nombre = nombre;
        this.precio = precio;
        this.numeroPantallas = numeroPantallas;
        this.calidadVideo = calidadVideo;
        this.descargas = descargas;
    }
    
    public int getId() { return id; }
    public String getNombre() { return nombre; }
    public double getPrecio() { return precio; }
    public int getNumeroPantallas() { return numeroPantallas; }
    public String getCalidadVideo() { return calidadVideo; }
    public boolean tieneDescargas() { return descargas; }
    
    public String getDescripcion() {
        return nombre + " - $" + precio + " | " + numeroPantallas + " pantallas | " + calidadVideo + 
               (descargas ? " | Descargas" : "");
    }
}