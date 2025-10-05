import java.util.Scanner;
public class ejercicio02 {
    public static void main(String [] args){
        Scanner numero = new Scanner (System.in);

        int pares = 0;
        /* se crea un contador para poder contar los numeros pares que se ingresen
         */

        System.out.println("+++ NUMEROS PARES +++");
        System.out.println("Cuantos numeros ingresara?: ");
        int cantidad = numero.nextInt();

        for (int i = 0; i < cantidad; i++){
            System.out.println("Ingresa el numero " + (i + 1) +" : ");
            int numX= numero.nextInt();

            if (numX % 2 == 0) {
                pares++;
            }
        }
            if(pares == 0){
                System.out.println("No se ingreso ningun numero par.");
            }else{
                System.out.println("Hay un total de "+ pares +" numeros pares ingresados.");

            }

    }
}