public class Empleado {
    private String nombreCompleto;
    private String cedula;
    private double salarioMensual;
    private int aniosAntiguedad;
    private boolean esGerente;

    public Empleado(String nombreCompleto, String cedula,Double salarioMensual, int aniosAntiguedad, boolean esGerente ){
        this.nombreCompleto = nombreCompleto;
        this.cedula = cedula;
        this.salarioMensual= salarioMensual;
        this.aniosAntiguedad= aniosAntiguedad;
        this.esGerente= esGerente;
    }

    public void setNombreCompleto(String nuevoNombre) {
        this.nombreCompleto = nuevoNombre;
        if (nuevoNombre.trim().isEmpty()) {
            System.out.println("No deje vacío el nombre.");
        } else {
            System.out.println("Nombre ingresado correctamente.");
        }
    }

    public String getNombreCompleto() {
        return nombreCompleto;
    }

    public void setCedula(String nuevaCedula) {
        this.cedula = nuevaCedula;
        if (nuevaCedula.length() == 10) {
            System.out.println("Cédula ingresada correctamente.");
        } else {
            System.out.println("La cédula debe tener 10 dígitos.");
        }
    }

    public String getCedula() {
        return cedula;
    }

    public void setSalarioMensual(double salario) {
        if (salario >= 500) {
            this.salarioMensual = salario;
            System.out.println("Salario ingresado correctamente.");
        } else {
            System.out.println("El salario no puede ser menor a 500.");
        }
    }

    public double getSalarioMensual() {
        return salarioMensual;
    }

    public void setAniosAntiguedad(int anios) {
        if (anios >= 0) {
            this.aniosAntiguedad = anios;
            System.out.println("Años de antigüedad ingresados correctamente.");
        } else {
            System.out.println("Los años de antigüedad no pueden ser negativos.");
        }
    }

    public int getAniosAntiguedad() {
        return aniosAntiguedad;
    }

    public void setEsGerente(boolean esGerente) {
        this.esGerente = esGerente;
    }

    public boolean getEsGerente() {
        return esGerente;
    }

    public boolean puedeRecibirBonificacion() {
        return salarioMensual < 3000 && aniosAntiguedad >= 5;
    }

    public void generarResultado() {
        if (puedeRecibirBonificacion()) {
            System.out.println("Bonificación aprobada.");
            System.out.println("Bonificación mensual: " + calcularBonificacion());
            System.out.println("Bonificación con extra 50: " + calcularBonificacion(50));
        } else {
            System.out.println("Bonificación no aprobada.");
            if (salarioMensual >= 3000) {
                System.out.println("Motivo: Salario mayor o igual a 3000.");
            }
            if (aniosAntiguedad < 5) {
                System.out.println("Motivo: Antigüedad menor a 5 años.");
            }
        }
    }

    // toString()
    @Override
    public String toString() {
        return "Datos del empleado:" +
                "\nNombre: " + nombreCompleto +
                "\nCédula: " + cedula +
                "\nSalario mensual: " + salarioMensual +
                "\nAños de antigüedad: " + aniosAntiguedad +
                "\nEs gerente: " + esGerente +
                "\nResultado: " + (puedeRecibirBonificacion() ? "Bonificación aprobada" : "Bonificación no aprobada") +
                "\nBonificación mensual: " + calcularBonificacion() +
                "\nBonificación con extra 50: " + calcularBonificacion(50);
    }

    public static void mostrarReglasBonificacion() {
        System.out.println("Reglas de bonificación:");
        System.out.println("- Salario debe ser menor a 3000 o años de antigüedad >= 5");
        System.out.println("- Bonificación estándar: 10% del salario");
    }

    public double calcularBonificacion() {
        return salarioMensual * 0.10;
    }

    public double calcularBonificacion(double extra) {
        return calcularBonificacion() + extra;
    }

}
