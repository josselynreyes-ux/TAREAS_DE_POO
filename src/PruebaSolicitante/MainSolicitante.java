package PruebaSolicitante;

import java.util.Scanner;

public class MainSolicitante {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Ingrese nombre completo:");
        String nombre = sc.nextLine();

        System.out.println("Ingrese cédula:");
        String cedula = sc.nextLine();

        System.out.println("Ingrese ingresos mensuales:");
        double ingresos = sc.nextDouble();

        System.out.println("Ingrese cantidad de vehículos:");
        int vehiculos = sc.nextInt();

        System.out.println("¿Vive en Ecuador? (true/false):");
        boolean vive = sc.nextBoolean();

        SolicitanteSubsidio persona = new SolicitanteSubsidio(nombre, cedula, ingresos, vehiculos, vive);

        System.out.println("\nDatos ingresados:");
        System.out.println(persona);

        System.out.println("\nResultado del subsidio:");
        persona.generarResultado();

        System.out.println("\nConsumo mensual estimado sin km extra: " + persona.calcularConsumoMensual());
        System.out.println("Consumo mensual estimado con 200 km extra: " + persona.calcularConsumoMensual(200));

        System.out.println("\nReglas del subsidio:");
        SolicitanteSubsidio.mostrarReglasSubsidio();
    }
}
