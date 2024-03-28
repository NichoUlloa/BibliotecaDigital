package modelo;

public enum ClasificacionTematica {
    INFORMATICA("Informática"), MATEMATICAS("Matemáticas"), FISICA("Física"), QUIMICA("Química"), HISTORIA("Historia");

    private String clasificacionTematica;

    private ClasificacionTematica(String clasificacionTematica) {
        this.clasificacionTematica = clasificacionTematica;
    }

    public String getClasificacionTematica() {
        return clasificacionTematica;
    }

    public void setClasificacionTematica(String clasificacionTematica) {
        this.clasificacionTematica = clasificacionTematica;
    }

    @Override
    public String toString() {
        return clasificacionTematica;
    }
}
