public abstract class Persona {
    private String nombre;
    private String cedula;
    private String direccion;
    private String telefono;

    public Persona(String nombre, String cedula, String direccion, String telefono) {
        this.nombre = nombre;
        this.cedula = cedula;
        this.direccion = direccion;
        this.telefono = telefono;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nuevoNombre) {
        if (nuevoNombre.trim().isEmpty()) {
            System.out.println("El nombre no puede estar vacío.");
        } else {
            this.nombre = nuevoNombre;
        }
    }

    public String getCedula() {
        return cedula;
    }

    public void setCedula(String nuevaCedula) {
        if (nuevaCedula.trim().isEmpty()) {
            System.out.println("La cédula no puede estar vacía.");
        } else if (nuevaCedula.length() != 10) {
            System.out.println("La cédula debe tener 10 dígitos.");
        } else {
            this.cedula = nuevaCedula;
        }
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String nuevaDireccion) {
        if (nuevaDireccion.trim().isEmpty()) {
            System.out.println("La dirección no puede estar vacía.");
        } else if (nuevaDireccion.length() < 5) {
            System.out.println("La dirección debe tener al menos 5 caracteres.");
        } else {
            this.direccion = nuevaDireccion;
        }
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String nuevoTelefono) {
        if (nuevoTelefono.trim().isEmpty()) {
            System.out.println("El teléfono no puede estar vacío.");
        } else if (nuevoTelefono.length() != 10) {
            System.out.println("El teléfono debe tener 10 dígitos.");
        } else {
            this.telefono = nuevoTelefono;
        }
    }

    public abstract void mostrarRol();
}

class Cliente extends Persona {
    private int edad;
    private double saldo;

    public Cliente(String nombre, String cedula, String direccion, String telefono, int edad, double saldo) {
        super(nombre, cedula, direccion, telefono);
        this.edad = edad;
        this.saldo = saldo;
    }

    @Override
    public void mostrarRol() {
        System.out.println("Rol: Cliente");
    }

    public double getSaldo() {
        return saldo;
    }

    public void setSaldo(double saldo) {
        this.saldo = saldo;
    }


    public boolean ingresarAlSistema() {
        System.out.println("Bienvenido " + getNombre());
        return true;
    }

    public void registrarCuenta(String tipo) {
        System.out.println("Cuenta registrada tipo: " + tipo);
    }

    public void solicitarPrestamo(double monto) {
        if (monto > 0) {
            System.out.println("Préstamo solicitado por $" + monto);
        } else {
            System.out.println("Monto inválido para préstamo.");
        }
    }

    public void agregarTarjetaCredito(TarjetaCredito tarjeta) {
        System.out.println("Tarjeta agregada: " + tarjeta.getNumero());
    }

    public void verResumenFinanciero() {
        System.out.println("Cliente: " + getNombre());
        System.out.println("Saldo disponible: $" + saldo);
    }
}


class Empleado extends Persona {
    private String cargo;
    private String usuario;
    private String clave;

    public Empleado(String nombre, String cedula, String direccion, String telefono, String cargo) {
        super(nombre, cedula, direccion, telefono);
        this.cargo = cargo;
        this.usuario = "admin";
        this.clave = "admin123";
    }

    @Override
    public void mostrarRol() {
        System.out.println("Rol: Empleado (" + cargo + ")");
    }

    public boolean autenticarEmpleado(String nuevoUsuario, String nuevaClave) {
        if (!nuevoUsuario.equals(usuario) || !nuevaClave.equals(clave)) {
            System.out.println("Error: autenticación fallida.");
            return false;
        } else {
            System.out.println("Bienvenido " + getNombre());
            return true;
        }
    }

    public void crearCuentaParaCliente(Cliente cliente, String tipo) {
        System.out.println("Cuenta creada para " + cliente.getNombre() + " de tipo: " + tipo);
    }

    public void modificarDatosCliente(Cliente cliente) {
        System.out.println("Datos del cliente " + cliente.getNombre() + " modificados.");
    }

    public void registrarPrestamo(Cliente cliente, double monto) {
        System.out.println("Préstamo de $" + monto + " registrado para " + cliente.getNombre());
    }

    public void cerrarCuenta(Cliente cliente, Cuenta cuenta) {
        System.out.println("Cuenta tipo " + cuenta.getTipo() + " cerrada para " + cliente.getNombre());
    }
}

class Cajero extends Empleado {
    public Cajero(String nombre, String cedula, String direccion, String telefono) {
        super(nombre, cedula, direccion, telefono, "Cajero");
    }

    public void procesarRetiro(Cliente cliente, double monto) {
        if (monto > 0 && cliente.getSaldo() >= monto) {
            cliente.setSaldo(cliente.getSaldo() - monto);
            System.out.println("Retiro de $" + monto + " realizado para " + cliente.getNombre());
        } else {
            System.out.println("Saldo insuficiente o monto inválido.");
        }
    }

    public void procesarDeposito(Cliente cliente, double monto) {
        if (monto > 0) {
            cliente.setSaldo(cliente.getSaldo() + monto);
            System.out.println("Depósito de $" + monto + " realizado para " + cliente.getNombre());
        } else {
            System.out.println("Monto inválido para depósito.");
        }
    }

    public void consultarSaldo(Cliente cliente) {
        System.out.println("Saldo actual de " + cliente.getNombre() + ": $" + cliente.getSaldo());
    }
}

class BalconServicios extends Empleado {
    public BalconServicios(String nombre, String cedula, String direccion, String telefono) {
        super(nombre, cedula, direccion, telefono, "BalconServicios");
    }

    public Cliente registrarNuevoCliente() {
        Cliente nuevo = new Cliente("Nuevo Cliente", "0000000000", "Dirección", "+593000000000", 25, 0);
        System.out.println("Nuevo cliente registrado: " + nuevo.getNombre());
        return nuevo;
    }

    public void actualizarDatosCliente(Cliente cliente) {
        System.out.println("Datos del cliente " + cliente.getNombre() + " actualizados.");
    }
}

class JefeAgencia extends Empleado {
    public JefeAgencia(String nombre, String cedula, String direccion, String telefono) {
        super(nombre, cedula, direccion, telefono, "JefeAgencia");
    }

    public boolean aprobarPrestamo(Cliente cliente, double monto) {
        if (monto > 0) {
            System.out.println("Préstamo aprobado para " + cliente.getNombre() + " por $" + monto);
            cliente.setSaldo(cliente.getSaldo() + monto);
            return true;
        } else {
            System.out.println("Monto inválido.");
            return false;
        }
    }

    public void generarReporteOperaciones() {
        System.out.println("Reporte de operaciones generado correctamente.");
    }

    public void evaluarEmpleado(Empleado empleado) {
        System.out.println("Evaluación realizada para el empleado: " + empleado.getNombre());
    }
}

class TarjetaCredito {
    private String numero;

    public TarjetaCredito(String numero) {
        this.numero = numero;
    }

    public String getNumero() {
        return numero;
    }
}

class Cuenta {
    private String tipo;
    private double saldo;

    public Cuenta(String tipo, double saldo) {
        this.tipo = tipo;
        this.saldo = saldo;
    }

    public String getTipo() {
        return tipo;
    }

    public double getSaldo() {
        return saldo;
    }
}


