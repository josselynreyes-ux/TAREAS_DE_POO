public class Producto {

    String nombre;
    double precio;
    int cantidad;

    /*constructor con parametros*/
    public Producto(String nombre, double precio, int cantidad){
        this.nombre= nombre;
        this.precio= precio;
        this.cantidad= cantidad;

    }

    /*constructor sin parametros con valores fijos*/
    public Producto(){
        this.nombre="Galleta";
        this.precio= 0.50;
        this.cantidad=2;
    }

    /*constructor vacio*/
    public Producto(boolean vacio){

    }

    void mostrar(){

        System.out.println("--------------------------------------------");
        System.out.println("Producto:  "+nombre);
        System.out.println("Precio: "+precio);
        System.out.println("Cantidad: "+cantidad);
        System.out.println("--------------------------------------------");
    }

    public static void main(String [] args){

        Producto objeto1= new Producto("Libro",10.50,2);
        objeto1.mostrar();
        Producto objeto2= new Producto();
        objeto2.mostrar();
        Producto objeto3= new Producto(true);
        objeto3.mostrar();
    }


}
