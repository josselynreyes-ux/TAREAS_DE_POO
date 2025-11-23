import java.util.ArrayList;
import java.util.Scanner;
public class ParticipanteMain {

    static Scanner sc = new Scanner(System.in);
    static Olimpiada olimpiada;

    public static void main(String[] args) {

        try {
            System.out.print("Ingrese el nombre de la Olimpiada: ");
            String nombre = sc.nextLine();
            olimpiada = new Olimpiada(nombre);

        } catch (DatosIncorrectosException e) {
            System.out.println("Error: " + e.getMessage());
            return;
        }

        while (true) {
            System.out.println("===== MENÚ PRINCIPAL =====");
            System.out.println("1. Registrar evento");
            System.out.println("2. Registrar participante en un evento");
            System.out.println("3. Mostrar eventos y participantes");
            System.out.println("4. Salir");
            System.out.print("Opción: ");

            int opcion = leerEntero();

            switch (opcion) {
                case 1 -> registrarEvento();
                case 2 -> registrarParticipanteEvento();
                case 3 -> olimpiada.mostrarEvento();
                case 4 -> {
                    System.out.println("Saliendo...");
                    return;
                }
                default -> System.out.println("Opción inválida.");
            }
        }
    }



    public static int leerEntero() {
        while (true) {
            try {
                return Integer.parseInt(sc.nextLine());
            } catch (NumberFormatException e) {
                System.out.print("Ingrese un número válido: ");
            }
        }
    }

    public static void registrarEvento() {
        try {
            System.out.print("Nombre del evento: ");
            String nombre = sc.nextLine();

            Evento e = new Evento(nombre);
            olimpiada.agregarEvento(e);

            System.out.println("Evento registrado correctamente.");

        } catch (DatosIncorrectosException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }

    public static void registrarParticipanteEvento() {

        if (olimpiada.listaOlimpiada.isEmpty()) {
            System.out.println("Primero debe registrar un evento.");
            return;
        }

        System.out.println("Seleccione un evento:");
        for (int i = 0; i < olimpiada.listaOlimpiada.size(); i++) {
            System.out.println((i + 1) + ". " + olimpiada.listaOlimpiada.get(i).getNombreEvento());
        }

        int opcion = leerEntero() - 1;

        if (opcion < 0 || opcion >= olimpiada.listaOlimpiada.size()) {
            System.out.println("Evento no válido.");
            return;
        }

        Evento seleccionado = olimpiada.listaOlimpiada.get(opcion);

        System.out.println("1. Registrar Atleta");
        System.out.println("2. Registrar Equipo");
        System.out.print("Opción: ");
        int tipo = leerEntero();

        try {
            if (tipo == 1) {
                System.out.print("Nombre del atleta: ");
                String nombre = sc.nextLine();

                System.out.print("Deporte: ");
                String deporte = sc.nextLine();

                seleccionado.agregarParticipantes(new Atleta(nombre, deporte));
                System.out.println("Atleta registrado.");
            }
            else if (tipo == 2) {
                System.out.print("Nombre del equipo: ");
                String nombre = sc.nextLine();

                System.out.print("Número de integrantes: ");
                int integrantes = leerEntero();

                seleccionado.agregarParticipantes(new Equipo(nombre, integrantes));
                System.out.println("Equipo registrado.");
            }
            else {
                System.out.println("Opción inválida.");
            }

        } catch (DatosIncorrectosException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }

}
