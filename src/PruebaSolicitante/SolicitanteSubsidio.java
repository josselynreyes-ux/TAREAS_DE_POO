package PruebaSolicitante;

public class SolicitanteSubsidio {
    private String nombreCompleto;
    private String cedula;
    private double ingresosMensuales;
    private int cantidadVehiculos;
    private boolean viveEnEcuador;

    public SolicitanteSubsidio(String nombreCompleto, String cedula, double ingresosMensuales, int cantidadVehiculos, boolean viveEnEcuador) {
        this.nombreCompleto = nombreCompleto;
        this.cedula = cedula;
        this.ingresosMensuales = ingresosMensuales;
        this.cantidadVehiculos = cantidadVehiculos;
        this.viveEnEcuador = viveEnEcuador;
    }

    public String getNombreCompleto() { return nombreCompleto; }
    public String getCedula() { return cedula; }
    public double getIngresosMensuales() { return ingresosMensuales; }
    public int getCantidadVehiculos() { return cantidadVehiculos; }
    public boolean isViveEnEcuador() { return viveEnEcuador; }

    public void setIngresosMensuales(double ingresosMensuales) {
        if (ingresosMensuales >= 470) {
            this.ingresosMensuales = ingresosMensuales;
        } else {
            System.out.println("El ingreso no puede ser menor a 470.");
        }
    }

    public void setCantidadVehiculos(int cantidadVehiculos) {
        if (cantidadVehiculos >= 0) {
            this.cantidadVehiculos = cantidadVehiculos;
        } else {
            System.out.println("Cantidad de vehículos no válida.");
        }
    }

    public static void mostrarReglasSubsidio() {
        System.out.println("Reglas para recibir el subsidio:");
        System.out.println("- Ingresos menores o iguales a 1200.");
        System.out.println("- Máximo 1 vehículo registrado.");
        System.out.println("- Debe vivir en Ecuador.");
    }

    public boolean subsidioAprobado() {
        return ingresosMensuales <= 1200 && cantidadVehiculos <= 1 && viveEnEcuador;
    }

    public void generarResultado() {
        if (subsidioAprobado()) {
            System.out.println("Subsidio aprobado.");
        } else {
            System.out.println("Subsidio rechazado.");
        }
    }

    public double calcularConsumoMensual() {
        double kmMensual = 800;
        return kmMensual / 40;
    }

    public double calcularConsumoMensual(double kmExtra) {
        double kmMensual = 800 + kmExtra;
        return kmMensual / 40;
    }

    @Override
    public String toString() {
        return "Nombre: " + nombreCompleto +
                "\nCédula: " + cedula +
                "\nIngresos: " + ingresosMensuales +
                "\nVehículos: " + cantidadVehiculos +
                "\nVive en Ecuador: " + viveEnEcuador;
    }
}


