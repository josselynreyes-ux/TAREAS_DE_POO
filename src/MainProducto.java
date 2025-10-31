import java.util.Scanner;
public class MainProducto {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        Producto prod = new Producto("NombreInicial", "00000", 0.0, 0, false);

        Producto.mostrarReglasProducto();

        System.out.println("Ingrese nombre del producto: ");
        prod.setNombre(sc.nextLine());
        System.out.println("Ingrese código del producto: ");
        prod.setCodigo(sc.nextLine());
        System.out.println("Ingrese precio: ");
        prod.setPrecio(sc.nextDouble());
        System.out.println("Ingrese cantidad en stock: ");
        prod.setCantidadStock(sc.nextInt());
        System.out.println("¿Es perecible? (true/false): ");
        boolean esPerecible = sc.nextBoolean();
        prod.setEsPerecible(esPerecible);

        System.out.println(prod.toString());

        System.out.println("\n--- Estado del producto ---");
        prod.mostrarEstado();
    }
}
