package modelo;
import java.time.LocalDate;

public class Reserva {
    // Atributos
    private LocalDate fechaReserva;
    private RecursoDigital recursoDigital;
    private Usuario usuario;

    // Constructor
    public Reserva(LocalDate fechaReserva, RecursoDigital recursoDigital, Usuario usuario) {
        this.fechaReserva = fechaReserva;
        this.recursoDigital = recursoDigital;
        this.usuario = usuario;
    }

    // Getters y Setters
    public LocalDate getFechaReserva() {
        return fechaReserva;
    }
    public void setFechaReserva(LocalDate fechaReserva) {
        this.fechaReserva = fechaReserva;
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
    // metodo para imprimir reserva
    public void imprimirReserva() {
        System.out.println("Fecha de reserva: " + fechaReserva);
        System.out.println("Recurso digital: " + recursoDigital.getTitulo());
        System.out.println("Usuario: " + usuario.getNombre() + " " + usuario.getApellido());
        System.out.println();
    }
}
