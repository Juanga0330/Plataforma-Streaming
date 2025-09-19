import java.time.LocalDateTime;

public class Suscripcion {
    private Usuario usuario;
    private Plan plan;
    private LocalDateTime fechaInicio;
    private LocalDateTime fechaVencimiento;
    
    public Suscripcion(Usuario usuario, Plan plan) {
        this.usuario = usuario;
        this.plan = plan;
        this.fechaInicio = LocalDateTime.now();
        this.fechaVencimiento = fechaInicio.plusDays(30);
    }
    
    public Usuario getUsuario() { return usuario; }
    public Plan getPlan() { return plan; }
    public LocalDateTime getFechaInicio() { return fechaInicio; }
    public LocalDateTime getFechaVencimiento() { return fechaVencimiento; }
    
    public boolean isActiva() {
        return LocalDateTime.now().isBefore(fechaVencimiento);
    }
    
    @Override
    public String toString() {
        return "Usuario: " + usuario.getNombre() + " | Plan: " + plan.getNombre() + 
               " | Vence: " + fechaVencimiento.toLocalDate() + 
               " | Estado: " + (isActiva() ? "Activa" : "Vencida");
    }
}
 
    

