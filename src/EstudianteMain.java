import java.util.Scanner;
public class EstudianteMain {
    public static void main (String [] args){
        Scanner sc= new Scanner(System.in);
        Estudiante objeto1 = new Estudiante("Josselyn",20);

        try {
            System.out.println("Ingrese el nombre del estudiante: ");
            objeto1.setNombre(sc.nextLine());
            System.out.println("Ingrese la edad del estudiante: ");
            objeto1.setEdad(sc.nextInt());
            sc.nextLine();
            objeto1.mostrasInformacion();
        }catch (IllegalArgumentException e){
            System.out.println("----- ¡ERROR! -----");
            System.out.println(e.getMessage());
        }
    }
}
