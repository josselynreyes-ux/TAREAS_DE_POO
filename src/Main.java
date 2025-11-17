import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        ArrayList<Producto> lista = new ArrayList<>();

        while (true) {

            System.out.println("----- MENU SISTEMA DE PRODUCTOS -----");
            System.out.println("1. Registrar producto");
            System.out.println("2. Mostrar productos");
            System.out.println("3. Salir");
            System.out.print("Seleccione una opción: ");

            try {

                int opcion = Integer.parseInt(sc.nextLine());

                switch (opcion) {

                    case 1:
                        // Registrar producto

                        System.out.print("Ingrese nombre del producto: ");
                        String nombre = sc.nextLine();

                        System.out.print("Ingrese precio: ");
                        double precio = Double.parseDouble(sc.nextLine());

                        // Validaciones
                        if (nombre.trim().isEmpty()) {
                            throw new IllegalArgumentException("El nombre no puede estar vacío.");
                        }
                        if (precio < 0) {
                            throw new IllegalArgumentException("El precio no puede ser negativo.");
                        }

                        // Crear y almacenar
                        Producto p = new Producto(nombre, precio);
                        lista.add(p);

                        System.out.println("Producto registrado correctamente.");
                        break;

                    case 2:
                        // Mostrar productos

                        if (lista.isEmpty()) {
                            System.out.println("No hay productos registrados.");
                        } else {
                            System.out.println("--- LISTA DE PRODUCTOS ---");
                            for (Producto prod : lista) {
                                System.out.println("Nombre: " + prod.getNombre() +
                                        " | Precio: $" + prod.getPrecio());
                            }
                        }
                        break;

                    case 3:
                        System.out.println("Saliendo del sistema...");
                        return;

                    default:
                        System.out.println("Opción fuera de rango.");
                }

            } catch (NumberFormatException e) {
                System.out.println("Debe ingresar un número válido.");
            } catch (IllegalArgumentException e) {
                System.out.println("Error: " + e.getMessage());
            } catch (Exception e) {
                System.out.println("Error inesperado: " + e.getMessage());
            }
        }
    }
}
