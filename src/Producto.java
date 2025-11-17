public abstract class Producto {
    private String codigo;
    private String nombre;
    private double precio;

    public Producto(String codigo, String nombre, double precio){
        this.codigo=codigo;
        this.nombre=nombre;
        this.precio=precio;
    }

    public void setcodigo(String nuevoCodigo){
        if (nuevoCodigo.trim().isEmpty()){
            throw new IllegalArgumentException("El campo no puede estar vacio");
        }else{
            this.codigo=nuevoCodigo;
            System.out.println("codigo ingresado correctamente.");
        }
    }

    public String getCodigo(){
        return codigo;
    }

    public void setNombre(String nuevoNombre){
        if (nuevoNombre.trim().isEmpty()){
            throw new IllegalArgumentException("El campo no puede estar vacio");
        }else{
            this.nombre=nuevoNombre;
            System.out.println("nombre ingresado correctamente.");
        }
    }

    public String getNombre(){
        return nombre;
    }

    public void setPrecio(Double nuevoPrecio){
        if (nuevoPrecio <= 0){
            throw new IllegalArgumentException("El precio no puede ser negativo o cero.");
        }else{
            this.precio=nuevoPrecio;
            System.out.println("precio ingresado correctamente.");
        }
    }

    public Double getPrecio(){
        return precio;
    }

    public abstract double total();

    public void mostrarInformacion(){
        System.out.println("----- Producto -----");
        System.out.println("Codigo: "+codigo);
        System.out.println("Nombre: "+nombre);
        System.out.println("precio: "+ precio);
        System.out.println("--------------------");
    }

}

class ProductoNacional extends Producto{
    String pais;
    public ProductoNacional(String codigo, String nombre, double precio,String pais){
        super(codigo,nombre,precio);
        this.pais=pais;
    }

    @Override
    public double total() {
        double iva = (getPrecio() * 0.12) + getPrecio();
        return iva;
    }
}

class ProductoImportado extends Producto{
    String pais;
    public ProductoImportado(String codigo, String nombre, double precio,String pais){
        super(codigo,nombre,precio);
        this.pais=pais;
    }

    @Override
    public double total() {
        double ivaImportado = (getPrecio() * 0.05) + getPrecio();
        return ivaImportado;
    }
}

