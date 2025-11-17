import java.util.Scanner;
public class Ejercicio1 {
    public static void main (String [] args){

        String precio1;
        Scanner sc = new Scanner(System.in);
        System.out.println("----- La Tiendita de Joss -----");
        System.out.println("Ingrese el precio del producto: ");
        precio1 = sc.nextLine();

        try {
            //Double.parseDouble(precio1) esto transformara string en numero, solo si es posible
            //de esta manera podemos verificar que el usuario ingrese
            //unicamente numeros.
            double precio2= Double.parseDouble(precio1);

            if (precio2 <=0 ){
                System.out.println("El precio ingresado no puede ser negativo o cero");
            }else{
                double total = (precio2 * 0.15) + precio2;
                System.out.println("El precio total más IVA es de $"+total);
            }

        }catch (NumberFormatException e){
            System.out.println("----- ¡ERROR! -----");
            System.out.println("Debe ingresar unicamente numeros validos.");

        }

    }

}
