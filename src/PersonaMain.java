import java.util.Scanner;

public class PersonaMain {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Cliente clienteRegistrado = null;

        Cajero cajeroPrincipal = new Cajero("Carlos", "1100110011", "Loja", "+593999999999");
        BalconServicios balconPrincipal = new BalconServicios("María", "1100220022", "Quito", "+593888888888");
        JefeAgencia jefePrincipal = new JefeAgencia("Ana", "1100330033", "Guayaquil", "+593777777777");

        int opcion = 0;
        do {
            System.out.println("\n--- MENÚ PRINCIPAL ---");
            System.out.println("1. Registrar cliente");
            System.out.println("2. Ingresar como cliente");
            System.out.println("3. Ingresar como empleado");
            System.out.println("4. Salir");
            System.out.print("Seleccione una opción: ");

            try {
                opcion = scanner.nextInt();
                scanner.nextLine();

                switch (opcion) {
                    case 1:
                        System.out.println("\n--- Registro de Cliente ---");
                        System.out.print("Nombre: ");
                        String nombre = scanner.nextLine();
                        System.out.print("Cédula: ");
                        String cedula = scanner.nextLine();
                        System.out.print("Dirección: ");
                        String direccion = scanner.nextLine();
                        System.out.print("Teléfono: ");
                        String telefono = scanner.nextLine();
                        System.out.print("Edad: ");
                        int edad = scanner.nextInt();
                        scanner.nextLine();

                        Cliente nuevo = new Cliente("", "", "", "", edad, 0);
                        nuevo.setNombre(nombre);
                        nuevo.setCedula(cedula);
                        nuevo.setDireccion(direccion);
                        nuevo.setTelefono(telefono);

                        clienteRegistrado = nuevo;
                        System.out.println("Cliente registrado correctamente.");
                        break;

                    case 2:
                        if (clienteRegistrado != null) {
                            menuCliente(scanner, clienteRegistrado);
                        } else {
                            System.out.println("Primero debe registrar un cliente.");
                        }
                        break;

                    case 3:
                        System.out.println("\n--- LOGIN EMPLEADO ---");
                        System.out.print("Usuario: ");
                        String usuario = scanner.nextLine();
                        System.out.print("Contraseña: ");
                        String clave = scanner.nextLine();

                        if (usuario.equals("admin") && clave.equals("1234")) {
                            menuEmpleado(scanner, cajeroPrincipal, balconPrincipal, jefePrincipal, clienteRegistrado);
                        } else {
                            System.out.println("Usuario o contraseña incorrectos. No puede ingresar al menú de empleados.");
                        }
                        break;

                    case 4:
                        System.out.println("Saliendo del sistema...");
                        break;

                    default:
                        System.out.println("Opción inválida.");
                }
            } catch (Exception e) {
                System.out.println("Error: ingrese un valor válido.");
                scanner.nextLine();
            }

        } while (opcion != 4);

        scanner.close();
    }

    public static void menuCliente(Scanner sc, Cliente cliente) {
        int opcion = 0;
        do {
            System.out.println("\n--- MENÚ CLIENTE ---");
            System.out.println("1. Abrir cuenta");
            System.out.println("2. Ver saldo");
            System.out.println("3. Solicitar préstamo");
            System.out.println("4. Volver");
            System.out.print("Seleccione una opción: ");
            try {
                opcion = sc.nextInt();
                sc.nextLine();

                switch (opcion) {
                    case 1:
                        System.out.print("Tipo de cuenta (Ahorro/Corriente): ");
                        String tipo = sc.nextLine();
                        cliente.registrarCuenta(tipo);
                        break;
                    case 2:
                        cliente.verResumenFinanciero();
                        break;
                    case 3:
                        System.out.print("Monto del préstamo: ");
                        double monto = sc.nextDouble();
                        sc.nextLine();
                        cliente.solicitarPrestamo(monto);
                        break;
                    case 4:
                        System.out.println("Regresando al menú principal...");
                        break;
                    default:
                        System.out.println("Opción inválida.");
                }
            } catch (Exception e) {
                System.out.println("Error: ingrese un número válido.");
                sc.nextLine();
            }
        } while (opcion != 4);
    }

    public static void menuEmpleado(Scanner sc, Cajero cajero, BalconServicios balcon, JefeAgencia jefe, Cliente cliente) {
        int opcion = 0;
        do {
            System.out.println("\n--- MENÚ EMPLEADO ---");
            System.out.println("1. Cajero");
            System.out.println("2. Balcón de servicios");
            System.out.println("3. Jefe de agencia");
            System.out.println("4. Volver");
            System.out.print("Seleccione una opción: ");
            try {
                opcion = sc.nextInt();
                sc.nextLine();

                switch (opcion) {
                    case 1:
                        if (cliente != null) menuCajero(sc, cajero, cliente);
                        else System.out.println("No hay cliente registrado.");
                        break;
                    case 2:
                        menuBalcon(sc, balcon, cliente);
                        break;
                    case 3:
                        if (cliente != null) menuJefe(sc, jefe, cliente);
                        else System.out.println("No hay cliente registrado.");
                        break;
                    case 4:
                        System.out.println("Regresando...");
                        break;
                    default:
                        System.out.println("Opción inválida.");
                }
            } catch (Exception e) {
                System.out.println("Error: ingrese un número válido.");
                sc.nextLine();
            }
        } while (opcion != 4);
    }

    public static void menuCajero(Scanner sc, Cajero cajero, Cliente cliente) {
        int opcion = 0;
        do {
            System.out.println("\n--- MENÚ CAJERO ---");
            System.out.println("1. Retiro");
            System.out.println("2. Depósito");
            System.out.println("3. Consultar saldo");
            System.out.println("4. Volver");
            System.out.print("Seleccione una opción: ");
            try {
                opcion = sc.nextInt();
                sc.nextLine();
                switch (opcion) {
                    case 1:
                        System.out.print("Monto a retirar: ");
                        double retiro = sc.nextDouble();
                        sc.nextLine();
                        cajero.procesarRetiro(cliente, retiro);
                        break;
                    case 2:
                        System.out.print("Monto a depositar: ");
                        double deposito = sc.nextDouble();
                        sc.nextLine();
                        cajero.procesarDeposito(cliente, deposito);
                        break;
                    case 3:
                        cajero.consultarSaldo(cliente);
                        break;
                    case 4:
                        System.out.println("Regresando...");
                        break;
                    default:
                        System.out.println("Opción inválida.");
                }
            } catch (Exception e) {
                System.out.println("Error: ingrese un número válido.");
                sc.nextLine();
            }
        } while (opcion != 4);
    }

    public static void menuBalcon(Scanner sc, BalconServicios balcon, Cliente cliente) {
        int opcion = 0;
        do {
            System.out.println("\n--- MENÚ BALCÓN DE SERVICIOS ---");
            System.out.println("1. Registrar nuevo cliente");
            System.out.println("2. Actualizar datos de cliente");
            System.out.println("3. Volver");
            System.out.print("Seleccione una opción: ");
            try {
                opcion = sc.nextInt();
                sc.nextLine();
                switch (opcion) {
                    case 1:
                        balcon.registrarNuevoCliente();
                        break;
                    case 2:
                        if (cliente != null) balcon.actualizarDatosCliente(cliente);
                        else System.out.println("No hay cliente registrado.");
                        break;
                    case 3:
                        System.out.println("Regresando...");
                        break;
                    default:
                        System.out.println("Opción inválida.");
                }
            } catch (Exception e) {
                System.out.println("Error: ingrese un número válido.");
                sc.nextLine();
            }
        } while (opcion != 3);
    }

    public static void menuJefe(Scanner sc, JefeAgencia jefe, Cliente cliente) {
        int opcion = 0;
        do {
            System.out.println("\n--- MENÚ JEFE DE AGENCIA ---");
            System.out.println("1. Aprobar préstamo");
            System.out.println("2. Generar reporte");
            System.out.println("3. Volver");
            System.out.print("Seleccione una opción: ");
            try {
                opcion = sc.nextInt();
                sc.nextLine();
                switch (opcion) {
                    case 1:
                        System.out.print("Monto del préstamo: ");
                        double monto = sc.nextDouble();
                        sc.nextLine();
                        jefe.aprobarPrestamo(cliente, monto);
                        break;
                    case 2:
                        jefe.generarReporteOperaciones();
                        break;
                    case 3:
                        System.out.println("Regresando...");
                        break;
                    default:
                        System.out.println("Opción inválida.");
                }
            } catch (Exception e) {
                System.out.println("Error: ingrese un número válido.");
                sc.nextLine();
            }
        } while (opcion != 3);
    }
}