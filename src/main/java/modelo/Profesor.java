package modelo;

public class Profesor extends Usuario{
    // Atributos
    private String[] asignaturas;

    // Constructor
    public Profesor(String nombre, String apellido, String run, int edad, String[] asignaturas) {
        super(nombre, apellido, run, edad);
        this.asignaturas = asignaturas;
    }

    // Getters y Setters
    public String[] getAsignaturas() {
        return asignaturas;
    }
    public void setAsignaturas(String[] asignaturas) {
        this.asignaturas = asignaturas;
    }

    // Métodos
    public String getTipoUsuario() {
        return "Profesor";
    }

    @Override
    public String toString() {
        return super.toString() +
                "Asignaturas: " + String.join(", ", asignaturas) + "\n";
    }
}
