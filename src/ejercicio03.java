import java.util.Scanner;
public class ejercicio03 {
    public static void main(String [] args){
        Scanner numeros=new Scanner(System.in);

        System.out.println("TABLAS DE MULTIPLICAR");
        System.out.println("Ingrese un numero del 1 al 10 para poder ver su tabla: ");
        int numero=numeros.nextInt();

        System.out.println("LA tabla de multiplicar de " + numero + " es: ");

        for(int i = 1;i <= 10; i++ ){
            System.out.println(numero + " x " + i +" = "+(i * numero));
        }

    }
}
