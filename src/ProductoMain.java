import java.util.ArrayList;
import java.util.Scanner;
public class ProductoMain {
    public static  void main(String [] args){
        Scanner sc = new Scanner(System.in);
        //creamos la lista para guardar los productos nacionales o importados
        // aqui se guardan tambien los objetos creados cada que ponemos agregar producto pues no debemos crearlos manualmente.
        ArrayList<Producto>lista = new ArrayList<>();

        while (true) {
            System.out.println("---- Menú ----");
            System.out.println("1. Agregar producto");
            System.out.println("2. Mostrar lista");
            System.out.println("3. Calcular promedio de precios finales");
            System.out.println("4. Salir");
            System.out.print("Elige una opción: ");

            try {

                int opcion = Integer.parseInt(sc.nextLine()); // evita InputMismatchException

                switch (opcion) {

                    case 1:
                        System.out.println("1. Producto Nacional");
                        System.out.println("2. Producto Importado");
                        System.out.print("Elige tipo: ");
                        int tipo = Integer.parseInt(sc.nextLine());

                        System.out.print("Código: ");
                        String codigo = sc.nextLine();

                        System.out.print("Nombre: ");
                        String nombre = sc.nextLine();

                        System.out.print("Precio base: ");
                        double precio = Double.parseDouble(sc.nextLine());

                        if (tipo == 1) {
                            System.out.print("Provincia(Nacional): ");
                            String pais = sc.nextLine();

                            //aqui esta creando el objeto
                            lista.add(new ProductoNacional(codigo, nombre, precio, pais));

                        } else if (tipo == 2) {
                            System.out.print("País de origen (Importado): ");
                            String pais = sc.nextLine();

                            //aqui esta creando el objeto
                            lista.add(new ProductoImportado(codigo, nombre, precio, pais));

                        } else {
                            throw new IllegalArgumentException("Tipo inválido.");
                        }

                        System.out.println("Producto agregado correctamente.");
                        break;

                    case 2:
                        if (lista.isEmpty()) {
                            throw new DatosInvalidosException("La lista está vacía, no hay productos para mostrar.");
                        }
                        for (Producto p : lista) {
                            p.mostrarInformacion();
                            System.out.println("Precio final incluido IVA o Importe: " + p.total());
                        }
                        break;

                    case 3:
                        if (lista.isEmpty()) {
                            throw new DatosInvalidosException("No se puede calcular promedio: la lista está vacía.");
                        }
                        double suma = 0;
                        for (Producto p : lista) {
                            suma += p.total();
                        }
                        double promedio = suma / lista.size();
                        System.out.println("Promedio de precios finales: " + promedio);
                        break;

                    case 4:
                        System.out.println("Saliendo.");
                        return;

                    default:
                        throw new IllegalArgumentException("Opción fuera de rango.");
                }

            } catch (NumberFormatException e) {
                System.out.println("ERROR: Debes ingresar números válidos.");
            } catch (IllegalArgumentException e) {
                System.out.println("ERROR: " + e.getMessage());
            } catch (DatosInvalidosException e) {
                System.out.println("ERROR: " + e.getMessage());
            } catch (Exception e) {
                System.out.println("Error inesperado: " + e.getMessage());
            }
        }
    }
}
