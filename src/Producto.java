/* Codigo original
class Producto {
    public double precio;
    String nombre;

    void setPrecio(double p) {
        precio = p;
    }

    String getnombre() {
        return nombre;
    }
}
*/
/*codigo modificado*/
public class Producto {
    private double precio;
    private String nombre;

    public Producto(double precio, String nombre){
        setPrecio(precio);
        setNombre(nombre);
    }

    public void setPrecio(double nuevoPrecio){
        if(nuevoPrecio<=0){
            System.out.println("El precio no puede ser menor o igual a cero.");
        }else{
            this.precio=nuevoPrecio;
            System.out.println("El precio ha sido actualizado.");
        }
    }
    public Double getPrecio(){
        return precio;
    }

    public void setNombre(String nuevoNombre){
        this.nombre=nuevoNombre;
    }
    public String getNombre(){
        return nombre;
    }

    public void mostraProducto(){
        System.out.println("----Datos del producto----");
        System.out.println("Nombre: "+nombre);
        System.out.println("Precio: "+precio);
        System.out.println("--------------------------");
    }

    public static void main(String[]args){
        Producto objeto1= new Producto(5.0,"Cepillo de cabello");
        objeto1.mostraProducto();

        Producto objeto2= new Producto(-2,"Caramelo");
        objeto2.mostraProducto();
    }

}
