package modelo;
public abstract class Usuario {
    // Atributos
    private String nombre, apellido, run;
    private int edad;

    // Constructor
    public Usuario(String nombre, String apellido, String run, int edad) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.run = run;
        this.edad = edad;
    }

    // Getters y Setters
    public String getNombre() {
        return nombre;
    }
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }
    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getRun() {
        return run;
    }
    public void setRun(String run) {
        this.run = run;
    }

    public int getEdad() {
        return edad;
    }
    public void setEdad(int edad) {
        this.edad = edad;
    }

    // Métodos
    // metodo abstracto getTipoUsuario
    public abstract String getTipoUsuario();

    @Override
    public String toString() {
        return "Nombre: " + nombre + " " + apellido + "\n" +
                "RUN: " + run + "\n" +
                "Edad: " + edad + "\n";
    }
}
