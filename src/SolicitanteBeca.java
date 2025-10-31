public class SolicitanteBeca {
    private String nombreCompleto;
    private String cedula;
    private double promedio;
    private double ingresosFamiliares;
    private boolean tieneRecomendacion;

    public SolicitanteBeca(String nombreCompleto, String cedula, double promedio, double ingresosFamiliares, boolean tieneRecomendacion){
        this.nombreCompleto=nombreCompleto;
        this.cedula=cedula;
        this.promedio=promedio;
        this.ingresosFamiliares=ingresosFamiliares;
        this.tieneRecomendacion = tieneRecomendacion;
    }

    public void setNombreCompleto( String nuevoNombre){
        this.nombreCompleto = nuevoNombre;
        if(nuevoNombre.trim().isEmpty()){
            System.out.println("No deje vacio el nombre.");
        }else{
            System.out.println("Nombre ingresado.");
        }
    }

    public String getNombreCompleto(){
        return nombreCompleto;
    }

    public void setTieneRecomendacion(boolean nuevaRecomendacion) {
        this.tieneRecomendacion = nuevaRecomendacion;

        if (nuevaRecomendacion) {
            System.out.println("Usted cuenta con una recomendación válida.");
        } else {
            System.out.println("Usted no cuenta con una recomendación.");
        }
    }

    public boolean getTieneRecomendacion() {
        return tieneRecomendacion;
    }

    public void setPromedio(double nuevoPromedio) {
        this.promedio = nuevoPromedio;
        if(nuevoPromedio>=0.0 && nuevoPromedio<7 ){
            System.out.println("Usted no es posible candidato para la beca.");
        }else{
            System.out.println("Usted es candidato para solicitar una beca.");
        }
    }

    public double getPromedio(){
        return promedio;
    }

    public void setIngresosFamiliares(double nuevoIngreso){
        this.ingresosFamiliares = nuevoIngreso;
        if(nuevoIngreso>=0.0 && nuevoIngreso<500){
            System.out.println("Usted no es posible candidato para la beca.");
        }else{
            System.out.println("Usted es canditado para solicitar beca");
        }
    }

    public double getIngresosFamiliares(){
        return ingresosFamiliares;
    }

    public void setCedula(String nuevaCedula){
        this.cedula  = nuevaCedula;

        if(nuevaCedula.length()==10){
            System.out.println("Cedula ingresada correctamente");
        }else{
            System.out.println("Ingrese todos los numeros de su cedula");
        }
    }

    public String getCedula(){
        return cedula;
    }

    public boolean becaAprobada(){

        if(promedio>=7 && ingresosFamiliares>500 && tieneRecomendacion){
            return true;
        }else{
            return false;
        }
    }

    public void generarResultado() {

        if (becaAprobada()) {
            System.out.println("Usted ha obtenido la beca.");
        } else {
            System.out.println("Usted no ha obtenido la beca. Motivos: ");

            if (promedio < 7) {
                System.out.println("Usted no puede aplicar por su promedio menor a 7.");
            }
            if (ingresosFamiliares > 500) {
                System.out.println("Usted no puede aplicar por sus ingresos familiares menores a $500.");
            }
            if (!tieneRecomendacion) {
                System.out.println("Usted no puede solicitar una beca por falta de recomendacion.");
            }
        }
    }

    @Override
    public String toString() {
        return "Datos del solicitante: " +
                "\nNombre: " + nombreCompleto +
                "\nCédula: " + cedula +
                "\nPromedio: " + promedio +
                "\nIngresos familiares: " + ingresosFamiliares +
                "\nTiene recomendación: " + (tieneRecomendacion ? "Sí" : "No") +
                "\nResultado: "+ becaAprobada() +
                "\nHoras de estudio recomendadas: "+ calcularHorasEstudio() +
                "\nHoras de estudio con extra: "+calcularHorasEstudio(2);
    }

    public static void mostrarReglasBeca(){
        System.out.println("Reglas para solicitar la beca:");
        System.out.println("Promedio mínimo: 7.0");
        System.out.println("Ingresos familiares minimos: $500");
        System.out.println("Debe contar con una recomendación válida.");
    }

    public int calcularHorasEstudio() {
        return 2;
    }

    public int calcularHorasEstudio(int horasExtra) {
        return 2 + horasExtra;
    }

}
