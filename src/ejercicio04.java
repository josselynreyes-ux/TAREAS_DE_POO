import java.util.Scanner;
public class ejercicio04 {
    public static void main(String [] args){
        Scanner estudiante=new Scanner (System.in);

        System.out.println("EQUIPO ESTUDIANTIL");
        System.out.println("Ingrese los siguientes datos del estudiante");

        System.out.println("Nombre: ");
        String nombre = estudiante.nextLine();

        System.out.println("Edad: ");
        int edad = estudiante.nextInt();

        System.out.println("Altura: ");
        double altura= estudiante.nextDouble();

        if (edad < 18 && altura < 1.60){
            System.out.println(nombre +" no cumple con los requisitos.");

        }else{
            System.out.println(nombre + " fue aceptado para el equipo");

        }

    }
}
