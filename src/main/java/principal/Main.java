package principal;
import modelo.*;
import java.time.LocalDate;
public class Main {
    public static void main(String[] args) {
        inicializar();
    }

    public static void inicializar() {
        // Crear biblioteca
        BibliotecaDigital biblioteca = new BibliotecaDigital();

        // Crear estudiantes
        Estudiante estudiante1 = new Estudiante("Juan", "Perez", "12345678-9", 20, "Ingeniería Civil", new String[]{"Deportes", "Música"});
        Estudiante estudiante2 = new Estudiante("Maria", "Gonzalez", "98765432-1", 21, "Ingeniería en Computación", new String[]{"Tecnología", "Música"});
        Estudiante estudiante3 = new Estudiante("Pedro", "Martinez", "12345678-9", 22, "Ingeniería Civil", new String[]{"Deportes", "Música"});

        // Crear profesores
        Profesor profesor1 = new Profesor("Luis", "Martinez", "12345678-9", 30, new String[]{"Programación", "Matemáticas"});
        Profesor profesor2 = new Profesor("Ana", "Gonzalez", "98765432-1", 31, new String[]{"Programación", "Matemáticas"});
        Profesor profesor3 = new Profesor("Carlos", "Perez", "12345678-9", 32, new String[]{"Programación", "Matemáticas"});

        // Crear recursos digitales
        RecursoDigital recurso1 = new RecursoDigital("Introducción a la programación", "publico", new String[]{"Maria", "Juan"}, 2022, ClasificacionTematica.INFORMATICA);
        RecursoDigital recurso2 = new RecursoDigital("Matemáticas básicas", "exclusivo", new String[]{"Ana", "Luis"}, 2023, ClasificacionTematica.MATEMATICAS);
        RecursoDigital recurso3 = new RecursoDigital("Historia de Chile", "publico", new String[]{"Pedro", "Carlos"}, 2024, ClasificacionTematica.HISTORIA);

        // Uso de metodos
        // usar metodo agregarUsuario
        biblioteca.agregarUsuario(estudiante1);
        biblioteca.agregarUsuario(estudiante2);
        biblioteca.agregarUsuario(estudiante3);
        biblioteca.agregarUsuario(profesor1);
        biblioteca.agregarUsuario(profesor2);
        biblioteca.agregarUsuario(profesor3);

        // usar metodo eliminarUsuario
        biblioteca.eliminarUsuario(estudiante3);
        biblioteca.eliminarUsuario(profesor3);

        // usar metodo agregarRecursoDigital
        biblioteca.agregarRecursoDigital(recurso1);
        biblioteca.agregarRecursoDigital(recurso2);
        biblioteca.agregarRecursoDigital(recurso3);

        // usar metodo eliminarRecursoDigital
        biblioteca.eliminarRecursoDigital(recurso3);

        // usar metodo buscarRecursosPorTitulo
        System.out.println("\n== Busqueda por titulo Profesor ==");
        biblioteca.buscarRecursosPorTitulo("Introducción a la programación", profesor1);
        biblioteca.buscarRecursosPorTitulo("Matemáticas básicas", profesor2);

        System.out.println("\n== Busqueda por titulo Estudiante ==");
        biblioteca.buscarRecursosPorTitulo("Introducción a la programación", estudiante1);
        biblioteca.buscarRecursosPorTitulo("Matemáticas básicas", estudiante2);

        // usar metodo buscarRecursosPorAutor
        System.out.println("\n== Busqueda por autor Profesor ==");
        biblioteca.buscarRecursosPorAutor("Maria", profesor1);
        biblioteca.buscarRecursosPorAutor("Ana", profesor2);

        System.out.println("\n== Busqueda por autor Estudiante ==");
        biblioteca.buscarRecursosPorAutor("Maria", estudiante1);
        biblioteca.buscarRecursosPorAutor("Ana", estudiante2);

        // usar metodo buscarRecursosPorAnioPublicacion
        System.out.println("\n== Busqueda por año de publicacion Profesor ==");
        biblioteca.buscarRecursosPorAnioPublicacion(2022, profesor1);
        biblioteca.buscarRecursosPorAnioPublicacion(2023, profesor2);

        System.out.println("\n== Busqueda por año de publicacion Estudiante ==");
        biblioteca.buscarRecursosPorAnioPublicacion(2022, estudiante1);
        biblioteca.buscarRecursosPorAnioPublicacion(2023, estudiante2);

        // usar metodo buscarRecursosPorClasificacionTematica
        System.out.println("\n== Busqueda por clasificacion tematica Profesor ==");
        biblioteca.buscarRecursosPorClasificacionTematica(ClasificacionTematica.INFORMATICA, profesor1);
        biblioteca.buscarRecursosPorClasificacionTematica(ClasificacionTematica.MATEMATICAS, profesor2);

        System.out.println("\n== Busqueda por clasificacion tematica Estudiante ==");
        biblioteca.buscarRecursosPorClasificacionTematica(ClasificacionTematica.INFORMATICA, estudiante1);
        biblioteca.buscarRecursosPorClasificacionTematica(ClasificacionTematica.MATEMATICAS, estudiante2);

        // usar metodo ofrecerRecomendacionesLectura
        System.out.println("\n== Recomendaciones de lectura Profesor ==");
        biblioteca.ofrecerRecomendacionesLectura(profesor1);

        // Crear prestamos usando el metodo agregarPrestamo
        System.out.println("\n== Prestamos ==");
        Prestamo prestamo1 = new Prestamo(recurso1, profesor1, LocalDate.now(), LocalDate.now().plusDays(7));
        biblioteca.realizarPrestamo(prestamo1);
        Prestamo prestamo2 = new Prestamo(recurso2, estudiante1, LocalDate.now(), LocalDate.now().plusDays(7));
        biblioteca.realizarPrestamo(prestamo2);

        // usar metodo imprimirPrestamos
        System.out.println("\n== Prestamos realizados ==");
        biblioteca.imprimirPrestamos();

        // usar metodo devolverRecurso
        System.out.println("\n== Devolucion de recursos ==");
        biblioteca.devolverRecurso(prestamo1);

        // usar metodo imprimirPrestamos
        System.out.println("\n== Prestamos realizados =="); // no deberia encontrarse el prestamo1 que se devolvio
        biblioteca.imprimirPrestamos();

        // usar metodo enviarNotificacionDevolucion
        System.out.println("\n== Notificaciones de devolucion ==");
        biblioteca.enviarNotificacionDevolucion(prestamo2);

        // usar metodo realizarReservaRecursoDigital
        System.out.println("\n== Realizar reserva estudiante recurso publico ==");
        Reserva reserva1 = new Reserva(LocalDate.now(), recurso1, estudiante1);
        biblioteca.realizarReservaRecursoDigital(reserva1);

        System.out.println("\n== Realizar reserva estudiante recurso exclusivo ==");
        Reserva reserva2 = new Reserva(LocalDate.now(), recurso2, estudiante2);
        biblioteca.realizarReservaRecursoDigital(reserva2);

        // usar metodo imprimirReservas
        System.out.println("\n== Reservas realizadas ==");
        biblioteca.imprimirReservas();

        // usar metodo extenderPlazoPrestamo
        System.out.println("\n== Extender plazo de prestamo ==");
        biblioteca.extenderPlazoPrestamo(prestamo2, LocalDate.now().plusDays(14));
        biblioteca.imprimirPrestamos(); // se debe ver el plazo extendido en 7 dias

        // usar metodo enviarNotificacionReservaDisponible
        // proximanete
    }
}
