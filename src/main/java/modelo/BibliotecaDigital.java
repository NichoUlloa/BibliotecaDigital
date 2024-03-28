package modelo;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class BibliotecaDigital {
    // Atributos
    private List<RecursoDigital> recursosDigitales;
    private List<Prestamo> prestamos;
    private List<Reserva> reservas;
    private List<Usuario> usuarios;

    // Constructor
    public BibliotecaDigital() {
        recursosDigitales = new ArrayList<RecursoDigital>();
        prestamos = new ArrayList<Prestamo>();
        reservas = new ArrayList<Reserva>();
        usuarios = new ArrayList<Usuario>();
    }

    // Getters y Setters
    public List<RecursoDigital> getRecursosDigitales() {
        return recursosDigitales;
    }
    public void setRecursosDigitales(List<RecursoDigital> recursosDigitales) {
        this.recursosDigitales = recursosDigitales;
    }

    public List<Prestamo> getPrestamos() {
        return prestamos;
    }
    public void setPrestamos(List<Prestamo> prestamos) {
        this.prestamos = prestamos;
    }

    public List<Reserva> getReservas() {
        return reservas;
    }
    public void setReservas(List<Reserva> reservas) {
        this.reservas = reservas;
    }

    public List<Usuario> getUsuarios() {
        return usuarios;
    }
    public void setUsuarios(List<Usuario> usuarios) {
        this.usuarios = usuarios;
    }

    // Métodos
    // * La biblioteca debe poder gestionar diferentes tipos de recursos digitales, incluyendo libros, revistas académicas y tesis de grado.
    // Metodo para agregar recursoDigital a la lista de recursosDigitales y registrar en historial.
    public void agregarRecursoDigital(RecursoDigital recursoDigital) {
        recursosDigitales.add(recursoDigital);
        guardarHistorialRecursoDigital(recursoDigital);
    }
    // Metodo para eliminar recursoDigital de la lista de recursosDigitales
    public void eliminarRecursoDigital(RecursoDigital recursoDigital) {
        recursosDigitales.remove(recursoDigital);
    }

    // Metodo para agregar usuario a la lista de usuarios
    public void agregarUsuario(Usuario usuario) {
        usuarios.add(usuario);
    }
    // Metodo para eliminar usuario de la lista de usuarios
    public void eliminarUsuario(Usuario usuario) {
        usuarios.remove(usuario);
    }

    // * Cada préstamo debe registrar el recurso, el usuario que lo solicita, la fecha de préstamo y la fecha de devolución.
    // Metodo para registrar un prestamo, si no se encuentra el recurso retorna mensaje notificando que no se encontro
    public Prestamo registrarPrestamo(RecursoDigital recursoDigital, Usuario usuario, LocalDate fechaPrestamo, LocalDate fechaDevolucion) {
        String mensaje = "No se encontró el recurso";
        boolean recursoEncontrado = false;
        for (RecursoDigital recurso : recursosDigitales) {
            if (recurso.equals(recursoDigital)) {
                recursoEncontrado = true;
            }
        }
        if (recursoEncontrado) {
            Prestamo prestamo = new Prestamo(recursoDigital, usuario, fechaPrestamo, fechaDevolucion);
            prestamos.add(prestamo);
        } else {
            System.out.println(mensaje);
        }
        return null;
    }

    // * El sistema debe permitir extender el plazo de préstamo bajo ciertas condiciones.
    // metodo extenderPlazoPrestamo para extender el plazo de prestamo de un prestamo registrado 5 dias mas
    public void extenderPlazoPrestamo(Prestamo prestamo, LocalDate nuevaFechaDevolucion) {
        for (Prestamo prestamoRegistrado : prestamos) {
            if (prestamoRegistrado.equals(prestamo)) {
                prestamoRegistrado.setFechaDevolucion(nuevaFechaDevolucion);
            }
        }
    }

    // * Los usuarios deben poder buscar recursos por título, autor, año de publicación y clasificación temática.
    // * Los profesores tienen privilegios para acceder a ciertos recursos exclusivos.
    // metodo filtrar usuarios por usuario Usuario
    public List<RecursoDigital> filtrarUsuario(List<RecursoDigital> recursosDigitales, Usuario usuario) {
        List<RecursoDigital> recursosFiltrados = new ArrayList<RecursoDigital>();
        for (RecursoDigital recurso : recursosDigitales) {
            if (usuario.getTipoUsuario().equals("Profesor")) {
                if (recurso.getPrivilegiosAcceso().equals("exclusivo") || recurso.getPrivilegiosAcceso().equals("publico")) {
                    recursosFiltrados.add(recurso);
                }
            } else if (usuario.getTipoUsuario().equals("Estudiante")) {
                if (recurso.getPrivilegiosAcceso().equals("publico")) {
                    recursosFiltrados.add(recurso);
                }
            }
        }
        return recursosFiltrados;
    }

    // * Los usuarios del sistema se dividen en estudiantes y profesores. Todos los usuarios deben poder buscar recursos, realizar préstamos y devolverlos.
    // ** Los profesores tienen privilegios para acceder a ciertos recursos exclusivos.

    // metodo buscar recursoDigital por titulo
    public List<RecursoDigital> buscarRecursosPorTitulo(String titulo, Usuario usuario) {
        List<RecursoDigital> recursosEncontrados = new ArrayList<RecursoDigital>();
        for (RecursoDigital recurso : recursosDigitales) {
            if (recurso.getTitulo().equals(titulo)) {
                recursosEncontrados.add(recurso);
            }
        }
        for (RecursoDigital recurso : recursosEncontrados) {
            System.out.println(recurso.getTitulo());
        }
        recursosEncontrados = filtrarUsuario(recursosEncontrados, usuario);
        if (recursosEncontrados.isEmpty()) {
            System.out.println("No se encontró el recurso");
        }
        return recursosEncontrados;
    }
    // metodo buscar recursoDigital por autor
    public List<RecursoDigital> buscarRecursosPorAutor(String autor, Usuario usuario) {
        List<RecursoDigital> recursosEncontrados = new ArrayList<RecursoDigital>();
        for (RecursoDigital recurso : recursosDigitales) {
            for (String autorRecurso : recurso.getAutores()) {
                if (autorRecurso.equals(autor)) {
                    recursosEncontrados.add(recurso);
                }
            }
        }
        for (RecursoDigital recurso : recursosEncontrados) {
            System.out.println(recurso.getTitulo());
        }
        recursosEncontrados = filtrarUsuario(recursosEncontrados, usuario);
        if (recursosEncontrados.isEmpty()) {
            System.out.println("No se encontró el recurso");
        }
        return recursosEncontrados;
    }
    // metodo buscar recursoDigital por año de publicacion
    public List<RecursoDigital> buscarRecursosPorAnioPublicacion(int anioPublicacion, Usuario usuario) {
        List<RecursoDigital> recursosEncontrados = new ArrayList<RecursoDigital>();
        for (RecursoDigital recurso : recursosDigitales) {
            if (recurso.getAnioPublicacion() == anioPublicacion) {
                recursosEncontrados.add(recurso);
            }
        }
        for (RecursoDigital recurso : recursosEncontrados) {
            System.out.println(recurso.getTitulo());
        }
        recursosEncontrados = filtrarUsuario(recursosEncontrados, usuario);
        if (recursosEncontrados.isEmpty()) {
            System.out.println("No se encontró el recurso");
        }
        return recursosEncontrados;
    }
    // metodo buscar recursoDigital por clasificacion tematica
    public List<RecursoDigital> buscarRecursosPorClasificacionTematica(ClasificacionTematica clasificacionTematica, Usuario usuario) {
        List<RecursoDigital> recursosEncontrados = new ArrayList<RecursoDigital>();
        for (RecursoDigital recurso : recursosDigitales) {
            if (recurso.getClasificacionTematica().equals(clasificacionTematica)) {
                recursosEncontrados.add(recurso);
            }
        }
        for (RecursoDigital recurso : recursosEncontrados) {
            System.out.println(recurso.getTitulo());
        }
        recursosEncontrados = filtrarUsuario(recursosEncontrados, usuario);
        if (recursosEncontrados.isEmpty()) {
            System.out.println("No se encontró el recurso");
        }
        return recursosEncontrados;
    }

    // * El sistema debe ofrecer recomendaciones de lectura basadas en las preferencias y el historial de préstamos de cada usuario.
    // Metodo para ofrecer recomendaciones de lecturas registradas entregando alguna ramdom de la lista de recursosDigitales usar metodo filtrarUsuario para no ofrecer recursos exclusivos a estudiantes
    public void ofrecerRecomendacionesLectura(Usuario usuario) {
        List<RecursoDigital> recursosDisponibles = filtrarUsuario(recursosDigitales, usuario);

        if (!recursosDisponibles.isEmpty()) {
            int indiceRecomendacion = (int) (Math.random() * recursosDisponibles.size());
            System.out.println(recursosDisponibles.get(indiceRecomendacion).getTitulo());
        } else {
            System.out.println("No hay recomendaciones disponibles para el usuario.");
        }
    }

    // metodo realizar prestamo
    public void realizarPrestamo(Prestamo prestamo) {
        prestamos.add(prestamo);
    }

    // metodo devolver recurso
    public void devolverRecurso(Prestamo prestamo) {
        prestamos.remove(prestamo);
    }

    // metodo imprimir prestamos
    public void imprimirPrestamos() {
        for (Prestamo prestamo : prestamos) {
            prestamo.imprimirPrestamo();
        }
    }

    // * El sistema debe enviar notificaciones a los usuarios para recordarles la fecha de devolución de los recursos prestados y alertar sobre la disponibilidad de recursos reservados.
    // Metodo para enviar notificacion de devolucion con la fecha de devolucion revisando la lista de prestamos que estan registrados y sino esta registrado el prestamo retorna null
    public void enviarNotificacionDevolucion(Prestamo prestamo) {
        boolean prestamoEncontrado = false;
        for (Prestamo prestamoRegistrado : prestamos) {
            if (prestamoRegistrado.equals(prestamo)) {
                prestamoEncontrado = true;
            }
        }
        if (prestamoEncontrado) {
            System.out.println("Fecha de devolución: " + prestamo.getFechaDevolucion() +
                    "\npara el recurso: " + prestamo.getRecursoDigital().getTitulo() +
                    "\nusuario: " + prestamo.getUsuario().getNombre() + " "
                    + prestamo.getUsuario().getApellido() + " "
                    + prestamo.getUsuario().getRun());
        } else {
            System.out.println("No se encontró el préstamo");
        }
    }

    // metodo enviarNotificacionReservaDisponible
    public void enviarNotificacionReservaDisponible() {
    }

    // metodo guardarHistorialRecursoDigital en otra lista ya que la otra se van eliminando los recursos
    public void guardarHistorialRecursoDigital(RecursoDigital recursoDigital) {
        List<RecursoDigital> historialRecursosDigitales = new ArrayList<RecursoDigital>();
        historialRecursosDigitales.add(recursoDigital);
    }


    // Metodo realizarReservaRecursoDigital no disponible creando una lista de reservas, usando la lista de historialRecursosDigitales y filtrando por usuario y registrando las reservas en una lista para luego imprimir
    public void realizarReservaRecursoDigital(Reserva reserva) {
        List<RecursoDigital> recursosDisponibles = filtrarUsuario(recursosDigitales, reserva.getUsuario());
        boolean recursoEncontrado = false;
        for (RecursoDigital recurso : recursosDisponibles) {
            if (recurso.equals(reserva.getRecursoDigital())) {
                recursoEncontrado = true;
            }
        }
        if (recursoEncontrado) {
            reservas.add(reserva);
        } else {
            System.out.println("No se pudo realizar la reserva.");
        }
    }

    // Metodo para imprimir lista de reservas realizadas
    public void imprimirReservas() {
        for (Reserva reserva : reservas) {
            reserva.imprimirReserva();
        }
    }
}
