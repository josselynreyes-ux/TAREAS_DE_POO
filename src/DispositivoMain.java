import java.util.ArrayList;
import java.util.Scanner;
public class DispositivoMain {
    static Scanner sc = new Scanner(System.in);
    static ArrayList<Dispositivo> lista = new ArrayList<>();

    public static void main(String[] args) {

        while (true) {
            System.out.println("\n===== MENÚ DISPOSITIVOS =====");
            System.out.println("1. Registrar Laptop");
            System.out.println("2. Registrar Teléfono");
            System.out.println("3. Mostrar todos");
            System.out.println("4. Salir");
            System.out.print("Opción: ");

            int op = validarEntero();

            switch (op) {
                case 1 -> registrarLaptop();
                case 2 -> registrarTelefono();
                case 3 -> mostrarTodos();
                case 4 -> { return; }
                default -> System.out.println("Opción inválida");
            }
        }
    }

    public static int validarEntero() {
        while (true) {
            try {
                return Integer.parseInt(sc.nextLine());
            } catch (Exception e) {
                System.out.print("Ingrese un número válido: ");
            }
        }
    }

    public static double validarDouble() {
        while (true) {
            try {
                return Double.parseDouble(sc.nextLine());
            } catch (Exception e) {
                System.out.print("Ingrese un número válido: ");
            }
        }
    }

    public static String validarTexto() {
        while (true) {
            String t = sc.nextLine().trim();
            if (!t.isEmpty()) return t;
            System.out.print("No puede estar vacío: ");
        }
    }

    public static void registrarLaptop() {
        try {
            System.out.print("Marca: ");
            String marca = validarTexto();

            System.out.print("Modelo: ");
            String modelo = validarTexto();

            System.out.print("Precio: ");
            double precio = validarDouble();

            System.out.print("RAM (GB): ");
            int ram = validarEntero();

            lista.add(new Laptop(marca, modelo, precio, ram));
            System.out.println("Laptop registrada.");
        }
        catch (DatoInvalidoException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }

    public static void registrarTelefono() {
        try {
            System.out.print("Marca: ");
            String marca = validarTexto();

            System.out.print("Modelo: ");
            String modelo = validarTexto();

            System.out.print("Precio: ");
            double precio = validarDouble();

            System.out.print("Operador: ");
            String operador = validarTexto();

            lista.add(new Telefono(marca, modelo, precio, operador));
            System.out.println("Teléfono registrado.");
        }
        catch (DatoInvalidoException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }

    public static void mostrarTodos() {
        if (lista.isEmpty()) {
            System.out.println("No hay dispositivos registrados.");
            return;
        }

        System.out.println("\n===== LISTA DE DISPOSITIVOS =====");
        for (Dispositivo d : lista) {
            d.mostrarInfo(); // POLIMORFISMO
            System.out.println("----------------------");
        }
    }
}
