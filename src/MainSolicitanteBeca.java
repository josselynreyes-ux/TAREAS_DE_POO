import java.util.Scanner;
public class MainSolicitanteBeca {
    public static void main(String [] args){
        Scanner sc=new Scanner(System.in);

        SolicitanteBeca objeto1 = new SolicitanteBeca("Juan","1234567891",0.0,0.0,true);

        SolicitanteBeca.mostrarReglasBeca();
        System.out.println("Ingrese su nombre completo: ");
        objeto1.setNombreCompleto(sc.nextLine());
        System.out.println("Ingrese su cedula: ");
        objeto1.setCedula(sc.nextLine());
        System.out.println("Ingrese su promedio: ");
        objeto1.setPromedio(sc.nextDouble());
        System.out.println("Ingrese sus ingresos familiares: ");
        objeto1.setIngresosFamiliares(sc.nextDouble());
        System.out.println("Tiene recomendacion? (true/false): ");
        boolean recomendacion = sc.nextBoolean();
        objeto1.setTieneRecomendacion(recomendacion);

        System.out.println(objeto1.toString());

    }

}
