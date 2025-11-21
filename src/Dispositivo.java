public abstract class Dispositivo {
        private String marca;
        private String modelo;
        private double precio;

        public Dispositivo(String marca, String modelo, double precio) throws DatoInvalidoException {
            setMarca(marca);
            setModelo(modelo);
            setPrecio(precio);
        }

        public String getMarca() {
            return marca;
        }

        public void setMarca(String marca) throws DatoInvalidoException {
            if (marca == null || marca.trim().isEmpty()) {
                throw new DatoInvalidoException("La marca no puede estar vacía.");
            }
            this.marca = marca;
        }

        public String getModelo() {
            return modelo;
        }

        public void setModelo(String modelo) throws DatoInvalidoException {
            if (modelo == null || modelo.trim().isEmpty()) {
                throw new DatoInvalidoException("El modelo no puede estar vacío.");
            }
            this.modelo = modelo;
        }

        public double getPrecio() {
            return precio;
        }

        public void setPrecio(double precio) throws DatoInvalidoException {
            if (precio < 0) {
                throw new DatoInvalidoException("El precio no puede ser negativo.");
            }
            this.precio = precio;
        }

        // Método polimórfico
        public abstract void mostrarInfo();
    }

class Laptop extends Dispositivo {
    private int ram; // nuevo atributo

    public Laptop(String marca, String modelo, double precio, int ram) throws DatoInvalidoException {
        super(marca, modelo, precio);
        this.ram = ram;
    }

    @Override
    public void mostrarInfo() {
        System.out.println("=== LAPTOP ===");
        System.out.println("Marca: " + getMarca());
        System.out.println("Modelo: " + getModelo());
        System.out.println("Precio: $" + getPrecio());
        System.out.println("RAM: " + ram + " GB");
    }
}

class Telefono extends Dispositivo {
    private String operador;

    public Telefono(String marca, String modelo, double precio, String operador) throws DatoInvalidoException {
        super(marca, modelo, precio);
        this.operador = operador;
    }

    @Override
    public void mostrarInfo() {
        System.out.println("=== TELÉFONO ===");
        System.out.println("Marca: " + getMarca());
        System.out.println("Modelo: " + getModelo());
        System.out.println("Precio: $" + getPrecio());
        System.out.println("Operador: " + operador);
    }
}



