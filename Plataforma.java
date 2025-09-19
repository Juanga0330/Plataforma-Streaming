import java.util.*;

public class Plataforma{
    private List<Usuario> usuarios;
    private List<Plan> planes;
    private List<Pelicula> peliculas;
    private List<Suscripcion> suscripciones;
    private Scanner scanner;
    
    public static void main(String[] args) {
        new Plataforma().mostrarMenu();
    }
    public  Plataforma() {
        usuarios = new ArrayList<>();
        planes = new ArrayList<>();
        peliculas = new ArrayList<>();
        suscripciones = new ArrayList<>();
        scanner = new Scanner(System.in);
        
        
        planes.add(new Plan(1, "Plan Básico", 9.99, 1, "SD", false));
        planes.add(new Plan(2, "Plan Premium", 15.99, 4, "4K", true));
        
        peliculas.add(new Pelicula(1, "Inception", "Sci-Fi", 148));
        peliculas.add(new Pelicula(2, "Avatar", "Acción", 162));
        peliculas.add(new Pelicula(3, "Matrix", "Sci-Fi", 136));
    }
    
    public void mostrarMenu() {
        int opcion;
        do {
            System.out.println("\n=== STREAMING ===");
            System.out.println("1. Registrar usuario");
            System.out.println("2. Seleccionar plan y crear suscripción");
            System.out.println("3. Consultar películas");
            System.out.println("4. Ver película");
            System.out.println("5. Ver historial de usuario");
            System.out.println("6. Mostrar suscripciones");
            System.out.println("0. Salir");
            System.out.print("Opción: ");
            
            opcion = scanner.nextInt();
            scanner.nextLine();
            
            switch (opcion) {
                case 1: registrarUsuario(); break;
                case 2: crearSuscripcion(); break;
                case 3: consultarPeliculas(); break;
                case 4: verPelicula(); break;
                case 5: verHistorialUsuario(); break;
                case 6: mostrarSuscripciones(); break;
            }
        } while (opcion != 0);
    }
    
    private void registrarUsuario() {
        System.out.print("Nombre: ");
        String nombre = scanner.nextLine();
        System.out.print("Email: ");
        String email = scanner.nextLine();
        
        Usuario usuario = new Usuario(nombre, email);
        usuarios.add(usuario);
        System.out.println("Usuario registrado: " + nombre);
    }
    
    private void crearSuscripcion() {
        if (usuarios.isEmpty()) {
            System.out.println("No hay usuarios registrados");
            return;
        }
        
        System.out.println("Usuarios:");
        for (int i = 0; i < usuarios.size(); i++) {
            System.out.println((i + 1) + ". " + usuarios.get(i).getNombre());
        }
        System.out.print("Seleccione usuario: ");
        int indiceUsuario = scanner.nextInt() - 1;
        
        System.out.println("Planes:");
        for (int i = 0; i < planes.size(); i++) {
            System.out.println((i + 1) + ". " + planes.get(i).getDescripcion());
        }
        System.out.print("Seleccione plan: ");
        int indicePlan = scanner.nextInt() - 1;
        
        Usuario usuario = usuarios.get(indiceUsuario);
        Plan plan = planes.get(indicePlan);
        
        Suscripcion suscripcion = new Suscripcion(usuario, plan);
        suscripciones.add(suscripcion);
        usuario.agregarSuscripcion(suscripcion);
        
        System.out.println("Suscripción creada: " + suscripcion);
    }
    
    private void consultarPeliculas() {
        System.out.println("\n=== PELÍCULAS ===");
        for (Pelicula pelicula : peliculas) {
            System.out.println(pelicula);
        }
    }
    
    private void verPelicula() {
        if (usuarios.isEmpty()) {
            System.out.println("No hay usuarios");
            return;
        }
        
        System.out.println("Usuarios:");
        for (int i = 0; i < usuarios.size(); i++) {
            System.out.println((i + 1) + ". " + usuarios.get(i).getNombre());
        }
        System.out.print("Seleccione usuario: ");
        int indiceUsuario = scanner.nextInt() - 1;
        
        Usuario usuario = usuarios.get(indiceUsuario);
        if (!usuario.tieneSuscripcionActiva()) {
            System.out.println("Usuario sin suscripción activa");
            return;
        }
        
        consultarPeliculas();
        System.out.print("ID de película: ");
        int id = scanner.nextInt();
        
        for (Pelicula pelicula : peliculas) {
            if (pelicula.getId() == id) {
                usuario.agregarPeliculaAlHistorial(pelicula);
                System.out.println("Viendo: " + pelicula.getTitulo());
                return;
            }
        }
        System.out.println("Película no encontrada");
    }
    
    private void verHistorialUsuario() {
        if (usuarios.isEmpty()) {
            System.out.println("No hay usuarios");
            return;
        }
        
        System.out.println("Usuarios:");
        for (int i = 0; i < usuarios.size(); i++) {
            System.out.println((i + 1) + ". " + usuarios.get(i).getNombre());
        }
        System.out.print("Seleccione usuario: ");
        int indiceUsuario = scanner.nextInt() - 1;
        
        Usuario usuario = usuarios.get(indiceUsuario);
        usuario.mostrarHistorial();
    }
    
    private void mostrarSuscripciones() {
        System.out.println("\n=== SUSCRIPCIONES ===");
        for (Suscripcion suscripcion : suscripciones) {
            System.out.println(suscripcion);
        }
    }
    
    
} 
    

