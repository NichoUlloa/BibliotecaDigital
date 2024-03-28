package modelo;

public class Estudiante extends Usuario{
    // Atributos
    private String carrera;
    private String[] intereses;

    // Constructor
    public Estudiante(String nombre, String apellido, String run, int edad, String carrera, String[] intereses) {
        super(nombre, apellido, run, edad);
        this.carrera = carrera;
        this.intereses = intereses;
    }

    // Getters y Setters
    public String getCarrera() {
        return carrera;
    }
    public void setCarrera(String carrera) {
        this.carrera = carrera;
    }

    public String[] getIntereses() {
        return intereses;
    }
    public void setIntereses(String[] intereses) {
        this.intereses = intereses;
    }

    // Métodos
    public String getTipoUsuario() {
        return "Estudiante";
    }

    @Override
    public String toString() {
        return super.toString() +
                "Carrera: " + carrera + "\n" +
                "Intereses: " + String.join(", ", intereses) + "\n";
    }
}
