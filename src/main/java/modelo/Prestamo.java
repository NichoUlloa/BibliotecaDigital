package modelo;

import java.time.LocalDate;
public class Prestamo {
    // Atributos
    private LocalDate fechaPrestamo;
    private LocalDate fechaDevolucion;
    private RecursoDigital recursoDigital;
    private Usuario usuario;

    // Constructor
    public Prestamo(RecursoDigital recursoDigital, Usuario usuario, LocalDate fechaPrestamo, LocalDate fechaDevolucion) {
        this.fechaPrestamo = fechaPrestamo;
        this.fechaDevolucion = fechaDevolucion;
        this.recursoDigital = recursoDigital;
        this.usuario = usuario;
    }

    // Getters y Setters
    public LocalDate getFechaPrestamo() {
        return fechaPrestamo;
    }
    public void setFechaPrestamo(LocalDate fechaPrestamo) {
        this.fechaPrestamo = fechaPrestamo;
    }

    public LocalDate getFechaDevolucion() {
        return fechaDevolucion;
    }
    public void setFechaDevolucion(LocalDate fechaDevolucion) {
        this.fechaDevolucion = fechaDevolucion;
    }

    public RecursoDigital getRecursoDigital() {
        return recursoDigital;
    }
    public void setRecursoDigital(RecursoDigital recursoDigital) {
        this.recursoDigital = recursoDigital;
    }

    public Usuario getUsuario() {
        return usuario;
    }
    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    // Métodos
    // metodo para imprimir prestamo
    public void imprimirPrestamo() {
        System.out.println("Fecha de prestamo: " + fechaPrestamo);
        System.out.println("Fecha de devolucion: " + fechaDevolucion);
        System.out.println("Recurso digital: " + recursoDigital.getTitulo());
        System.out.println("Usuario: " + usuario.getNombre() + " " + usuario.getApellido());
        System.out.println();
    }
}
