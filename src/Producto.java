public class Producto {
        private String nombre;
        private String codigo;
        private double precio;
        private int cantidadStock;
        private boolean esPerecible;

        public Producto(String nombre, String codigo, double precio, int cantidadStock, boolean esPerecible){
            this.nombre = nombre;
            this.codigo = codigo;
            this.precio = precio;
            this.cantidadStock = cantidadStock;
            this.esPerecible = esPerecible;
        }

        public void setNombre(String nuevoNombre){
            this.nombre = nuevoNombre;
            if(nuevoNombre.trim().isEmpty()){
                System.out.println("No deje vacío el nombre del producto.");
            }else{
                System.out.println("Nombre ingresado correctamente.");
            }
        }

        public String getNombre(){
            return nombre;
        }

        public void setCodigo(String nuevoCodigo){
            this.codigo = nuevoCodigo;

            if(nuevoCodigo.length() >= 5){
                System.out.println("Código ingresado correctamente.");
            }else{
                System.out.println("El código debe tener al menos 5 caracteres.");
            }
        }

        public String getCodigo(){
            return codigo;
        }

        public void setPrecio(double nuevoPrecio){
            this.precio = nuevoPrecio;

            if(nuevoPrecio >= 0){
                System.out.println("Precio válido.");
            }else{
                System.out.println("El precio no puede ser negativo.");
            }
        }

        public double getPrecio(){
            return precio;
        }

        public void setCantidadStock(int nuevaCantidad){
            this.cantidadStock = nuevaCantidad;

            if(nuevaCantidad >= 0){
                System.out.println("Cantidad válida en stock.");
            }else{
                System.out.println("La cantidad en stock no puede ser negativa.");
            }
        }

        public int getCantidadStock(){
            return cantidadStock;
        }

        public void setEsPerecible(boolean nuevoValor){
            this.esPerecible = nuevoValor;

            if(nuevoValor){
                System.out.println("El producto es perecible.");
            }else{
                System.out.println("El producto no es perecible.");
            }
        }

        public boolean getEsPerecible(){
            return esPerecible;
        }

        public boolean stockDisponible(){
            if(cantidadStock > 0){
                return true;
            }else{
                return false;
            }
        }

        public void mostrarEstado(){
            if(stockDisponible()){
                System.out.println("El producto está disponible en stock.");
            }else{
                System.out.println("El producto no está disponible en stock.");
            }
        }

        @Override
        public String toString(){
            return "Datos del producto: " +
                    "\nNombre: " + nombre +
                    "\nCódigo: " + codigo +
                    "\nPrecio: " + precio +
                    "\nCantidad en stock: " + cantidadStock +
                    "\nEs perecible: " + (esPerecible ? "Sí" : "No") +
                    "\nStock disponible: " + stockDisponible() +
                    "\nValor total: " + calcularValorTotal() +
                    "\nValor total con descuento 10%: " + calcularValorTotal(10);
        }

        public static void mostrarReglasProducto(){
            System.out.println("Reglas para el registro del producto:");
            System.out.println("El código debe tener al menos 5 caracteres.");
            System.out.println("El precio y la cantidad no pueden ser negativos.");
            System.out.println("El producto estará disponible si la cantidad en stock es mayor a 0.");
        }

        public double calcularValorTotal(){
            return precio * cantidadStock;
        }

        public double calcularValorTotal(double descuentoPorcentaje){
        double total = calcularValorTotal();
        double descuento = total * (descuentoPorcentaje / 100.0);
        return total - descuento;
        }

}
