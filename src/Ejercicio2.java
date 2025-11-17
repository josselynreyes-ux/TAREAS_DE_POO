import java.util.InputMismatchException;
import java.util.Scanner;
public class Ejercicio2 {
    public static void main (String [] args){
        Scanner sc=new Scanner(System.in);
        int opcion;

            System.out.println("----- Menú -----");
            System.out.println("1. Pizza de pepperoni");
            System.out.println("2. Pizza hawaina");
            System.out.println("3. Pizza de jamon");
            System.out.println("4. Pizza de champiñones");
            System.out.println("Ingresa la opcion de pizza que desees:");

            try {
                opcion=sc.nextInt();
                if(opcion <1 || opcion >4){
                    //utilizamos esta excepcion cuando la opcion es invalida
                    // puede que se ingrese un dato del mismo tipo pero no cumpla
                    // con ciertas caracteristicas para ser valida.
                    throw new IllegalArgumentException("opción no válida");
                }
                switch (opcion){
                    case 1:
                        System.out.println("Elegiste pizza con pepperoni");
                        return;
                    case 2:
                        System.out.println("Elegiste pizza hawaina");
                        return;
                    case 3:
                        System.out.println("elegiste pizza de jamon");
                        return;
                    case 4:
                        System.out.println("Elegiste pizza de champiñones");
                        return;
                }
                //error que se lanza cuando el usuario ingresa un tipo de dato
                //diferente al que espera scanner recibir.
            } catch (InputMismatchException e) {
                System.out.println("----- ¡ERROR! -----");
                System.out.println("Debe ingresar solo números enteros.");
                sc.nextLine(); // limpia la entrada para evitar bucle infinito
            } catch (IllegalArgumentException e) {
                //error que sale cuando el usuario ingresa un tipo de dato
                //correcto pero fuera del rango
                System.out.println("----- ¡ERROR! -----");
                System.out.println(e.getMessage());
            }

    }
}
