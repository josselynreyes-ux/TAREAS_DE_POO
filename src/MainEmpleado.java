import java.util.Scanner;
public class MainEmpleado {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        Empleado emp = new Empleado("NombreInicial", "0000000000", 500.0, 0, false);

        Empleado.mostrarReglasBonificacion();

        System.out.println("Ingrese nombre del empleado: ");
        emp.setNombreCompleto(sc.nextLine());
        System.out.println("Ingrese su cédula: ");
        emp.setCedula(sc.nextLine());
        System.out.println("Ingrese salario mensual: ");
        emp.setSalarioMensual(sc.nextDouble());
        System.out.println("Ingrese años de antigüedad: ");
        emp.setAniosAntiguedad(sc.nextInt());
        System.out.println("¿Es gerente? (true/false): ");
        boolean esGerente = sc.nextBoolean();
        emp.setEsGerente(esGerente);

        System.out.println(emp.toString());

        System.out.println("\n--- Resultado de la bonificación ---");
        emp.generarResultado();

    }
}
