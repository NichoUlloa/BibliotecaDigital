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
    // Metodo agregarRecursoDigital
    public void agregarRecursoDigital(RecursoDigital recursoDigital) {
        recursosDigitales.add(recursoDigital);
        guardarHistorialRecursoDigital(recursoDigital);
    }
    // Metodo eliminarRecursoDigital
    public void eliminarRecursoDigital(RecursoDigital recursoDigital) {
        recursosDigitales.remove(recursoDigital);
    }

    // Metodo agregarUsuario
    public void agregarUsuario(Usuario usuario) {
        usuarios.add(usuario);
    }
    // Metodo eliminarUsuario
    public void eliminarUsuario(Usuario usuario) {
        usuarios.remove(usuario);
    }

    // Metodo registrarPrestamo
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

    // Metodo extenderPlazoPrestamo
    public void extenderPlazoPrestamo(Prestamo prestamo, LocalDate nuevaFechaDevolucion) {
        for (Prestamo prestamoRegistrado : prestamos) {
            if (prestamoRegistrado.equals(prestamo)) {
                prestamoRegistrado.setFechaDevolucion(nuevaFechaDevolucion);
            }
        }
    }

    // Metodo filtrarUsuario
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

    // Metodo buscarRecursoDigitalPorTitulo
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
    // Metodo buscarRecursoDigitalPorAutor
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
    // Metodo buscarRecursoDigitalPorAnioPublicacion
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
    // Metodo buscarRecursoDigitalPorClasificacionTematica
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

    // Metodo ofrecerRecomendacionesLectura
    public void ofrecerRecomendacionesLectura(Usuario usuario) {
        List<RecursoDigital> recursosDisponibles = filtrarUsuario(recursosDigitales, usuario);

        if (!recursosDisponibles.isEmpty()) {
            int indiceRecomendacion = (int) (Math.random() * recursosDisponibles.size());
            System.out.println(recursosDisponibles.get(indiceRecomendacion).getTitulo());
        } else {
            System.out.println("No hay recomendaciones disponibles para el usuario.");
        }
    }

    // Metodo realizarPrestamo
    public void realizarPrestamo(Prestamo prestamo) {
        prestamos.add(prestamo);
    }

    // Metodo devolverRecurso
    public void devolverRecurso(Prestamo prestamo) {
        prestamos.remove(prestamo);
    }

    // Metodo imprimirPrestamos
    public void imprimirPrestamos() {
        for (Prestamo prestamo : prestamos) {
            prestamo.imprimirPrestamo();
        }
    }

    // Metodo enviarNotificacionDevolucion
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

    // Metodo enviarNotificacionReservaDisponible
    public void enviarNotificacionReservaDisponible() {
    }

    // Metodo guardarHistorialRecursoDigital
    public void guardarHistorialRecursoDigital(RecursoDigital recursoDigital) {
        List<RecursoDigital> historialRecursosDigitales = new ArrayList<RecursoDigital>();
        historialRecursosDigitales.add(recursoDigital);
    }

    // Metodo realizarReservaRecursoDigital
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

    // Metodo imprimirReservas
    public void imprimirReservas() {
        for (Reserva reserva : reservas) {
            reserva.imprimirReserva();
        }
    }
}
