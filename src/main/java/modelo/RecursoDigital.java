package modelo;
public class RecursoDigital {
    // Atributos
    private String titulo;
    private String privilegiosAcceso;// exclusivo y público, exclusivo para profesores y publico para ambos.
    private String[] autores;
    private int anioPublicacion;
    private ClasificacionTematica clasificacionTematica;

    // Constructor
    public RecursoDigital(String titulo, String privilegiosAcceso, String[] autores, int anioPublicacion, ClasificacionTematica clasificacionTematica) {
        this.titulo = titulo;
        this.privilegiosAcceso = privilegiosAcceso;
        this.autores = autores;
        this.anioPublicacion = anioPublicacion;
        this.clasificacionTematica = clasificacionTematica;
    }

    // Getters y Setters
    public String getTitulo() {
        return titulo;
    }
    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getPrivilegiosAcceso() {
        return privilegiosAcceso;
    }
    public void setPrivilegiosAcceso(String privilegiosAcceso) {
        this.privilegiosAcceso = privilegiosAcceso;
    }

    public String[] getAutores() {
        return autores;
    }
    public void setAutores(String[] autores) {
        this.autores = autores;
    }

    public int getAnioPublicacion() {
        return anioPublicacion;
    }
    public void setAnioPublicacion(int anioPublicacion) {
        this.anioPublicacion = anioPublicacion;
    }

    public ClasificacionTematica getClasificacionTematica() {
        return clasificacionTematica;
    }
    public void setClasificacionTematica(ClasificacionTematica clasificacionTematica) {
        this.clasificacionTematica = clasificacionTematica;
    }
}

