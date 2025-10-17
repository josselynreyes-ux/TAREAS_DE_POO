public class Vehiculo {
    public String marca;
    private String modelo;
    private int velocidadMaxima;
    private int codigoSeguridad;
    private String color;

    public Vehiculo(String marca, String modelo, int velocidadMaxima, int codigoSeguridad,String color ){
        this.marca=marca;
        setModelo(modelo);
        this.velocidadMaxima=velocidadMaxima;
        setCodigoSeguridad(codigoSeguridad);
        setColor(color);
    }

    public void setModelo(String nuevoModelo){
        if (nuevoModelo.trim().isEmpty()){
            System.out.println("El campo no puede estar vacio.");
        }else{
            this.modelo= nuevoModelo;
            System.out.println("El modelo del vehiculo se ha modificado.");
        }
    }
    public String getModelo(){
        return modelo;
    }

    public int getVelocidadMaxima(){
        return velocidadMaxima;
    }

    public void setCodigoSeguridad(int nuevoCodigo){
        if (nuevoCodigo<=0){
            System.out.println("El campo no puede tener numeros negativos.");
        }else{
            this.codigoSeguridad= nuevoCodigo;
            System.out.println("Codigo agregado exitosamente.");
        }
    }

    public void setColor(String nuevoColor){
        if (nuevoColor.equals("rojo")||nuevoColor.equals("azul")||nuevoColor.equals("blanco")){
            this.color= nuevoColor;
            System.out.println("Color ingresado correctamente.");
        }else{
            System.out.println("Color invalido.");
        }
    }
    public String getColor(){
        return color;
    }

    public void mostraDatos(){
        System.out.println("----Datos del vehiculo----");
        System.out.println("Marca: "+marca);
        System.out.println("Modelo: " + modelo);
        System.out.println("Velocidad Maxima: " + velocidadMaxima);
        System.out.println("Color: " + color);
        System.out.println("--------------------------");
    }

    public static void main(String []args ) {
        Vehiculo objeto1 = new Vehiculo("Toyota", "Camioneta", 180, 1234, "rojo");

        /*Mostramos el atributo publico*/
        System.out.println("Marca: "+ objeto1.marca);

        /*Intentamos leer el codigo de seguridad nos da un error porque es clase privada (ERROR: PRIVATE)
        System.out.println(objeto1.codigoSeguridad);*/

        /*Color no permitido*/
        objeto1.setColor("morado");

        /*Color valido*/
        objeto1.setColor("azul");

        /*Imprimir datos validos*/
        objeto1.mostraDatos();
    }
}
