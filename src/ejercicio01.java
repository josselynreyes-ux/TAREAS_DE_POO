import java.util.Scanner;
public class ejercicio01 {
    public static void main(String[] args){
        Scanner notas = new Scanner(System.in);
        System.out.println("NOTAS DEL ESTUDIANTE");

        System.out.println("Ingrese el nombre del estudiante: ");
        String nombre= notas.nextLine();

        System.out.println("Ingrese la primera nota:");
        double nota1 = notas.nextDouble();

        System.out.println("Ingrese la segunda nota:");
        double nota2 = notas.nextDouble();

        System.out.println("Ingrese la tercera nota:");
        double nota3 = notas.nextDouble();

        double promedio = (nota1 + nota2 + nota3)/3;

        /*Para poder mostrar el promedio final redondeado pero sin cambiar la nota original y sin usar librerias,
        investigue y encontre este metodo de redondeo manual, el cual permite redondear con 2 decimales.
         */

        double redondeo = Math.pow(10, 2);
        double resultado = Math.round(promedio * redondeo)/redondeo;

        if(promedio >= 7){
            System.out.println("Felicidades la/el estudiante " + nombre + ", aprueba el curso con un promedio de " + resultado +".");
        }else{
            System.out.println("La/El estudiante " +nombre +", reprueba el curso con un promedio de " + resultado + ".");
        }

    }
}
