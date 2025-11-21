import java.util.ArrayList;
import java.util.Scanner;
public class JuegoMain {
    static Scanner sc = new Scanner(System.in);
    static ArrayList<Juego> listaJuegos = new ArrayList<>();

    public static void main(String[] args) {
        while (true) {
            System.out.println("===== MENÚ DE JUEGOS =====");
            System.out.println("1. Registrar juego Mario Bros");
            System.out.println("2. Registrar juego de Carreras");
            System.out.println("3. Mostrar todos los juegos");
            System.out.println("4. Buscar juego por nombre");
            System.out.println("5. Filtrar por tipo de juego");
            System.out.println("6. Salir");
            System.out.print("Ingrese una opción: ");

            int opcion = validarEntero();

            switch (opcion) {
                case 1 -> registrarMarioBros();
                case 2 -> registrarCarrera();
                case 3 -> mostrarTodos();
                case 4 -> buscarPorNombre();
                case 5 -> filtrarPorTipo();
                case 6 -> {
                    System.out.println("Saliendo del programa...");
                    return;
                }
                default -> System.out.println("Opción inválida.");
            }
        }
    }

    public static int validarEntero() {
        while (true) {
            try {
                String input = sc.nextLine();
                int valor = Integer.parseInt(input);
                return valor;
            } catch (NumberFormatException e) {
                System.out.print("Debe ingresar un número entero válido: ");
            }
        }
    }

    public static String validarTexto() {
        while (true) {
            String texto = sc.nextLine().trim();
            if (!texto.isEmpty()) return texto;
            System.out.print("El texto no puede estar vacío. Ingrese de nuevo: ");
        }
    }

    public static void registrarMarioBros() {
        try {
            System.out.print("Nombre del juego: ");
            String nombre = validarTexto();

            System.out.print("Género del juego: ");
            String genero = validarTexto();

            System.out.print("Nivel inicial del juego: ");
            int nivel = validarEntero();

            listaJuegos.add(new MarioBros(nombre, genero, nivel));
            System.out.println("Juego Mario Bros registrado correctamente.");

        } catch (DatosIncorrectosException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }

    public static void registrarCarrera() {
        try {
            System.out.print("Nombre del juego: ");
            String nombre = validarTexto();

            System.out.print("Género del juego: ");
            String genero = validarTexto();

            System.out.print("Velocidad máxima del vehículo: ");
            int velocidad = validarEntero();

            listaJuegos.add(new CarreraVehiculos(nombre, genero, velocidad));
            System.out.println("Juego de carreras registrado correctamente.");

        } catch (DatosIncorrectosException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }


    public static void mostrarTodos() {
        if (listaJuegos.isEmpty()) {
            System.out.println("No hay juegos registrados.");
            return;
        }
        System.out.println("\n=== LISTA DE JUEGOS ===");
        for (Juego j : listaJuegos) {
            j.mostrarInfo(); // Polimorfismo
            System.out.println("--------------------");
        }
    }

    public static void buscarPorNombre() {
        System.out.print("Ingrese el nombre a buscar: ");
        String nombre = validarTexto();

        boolean encontrado = false;

        for (Juego j : listaJuegos) {
            if (j.getNombre().equalsIgnoreCase(nombre)) {
                j.mostrarInfo();
                encontrado = true;
            }
        }
        if (!encontrado) {
            System.out.println("No se encontró un juego con ese nombre.");
        }
    }

    public static void filtrarPorTipo() {
        System.out.println("1. Mario Bros");
        System.out.println("2. Carreras");
        System.out.print("Ingrese tipo: ");

        int tipo = validarEntero();
        boolean encontrado = false;

        for (Juego j : listaJuegos) {
            if (tipo == 1 && j instanceof MarioBros) {
                j.mostrarInfo();
                encontrado = true;
            }
            if (tipo == 2 && j instanceof CarreraVehiculos) {
                j.mostrarInfo();
                encontrado = true;
            }
        }

        if (!encontrado) {
            System.out.println("No hay juegos de ese tipo.");
        }
    }
}
