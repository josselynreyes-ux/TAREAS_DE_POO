import java.util.Scanner;
public class MainParticipante {
    public static void main(String [] args){
        Scanner sc = new Scanner(System.in);

        Olimpiada objeto1 = new Olimpiada("Olimpiadas", 2025);

        while (true) {

            System.out.println("----- Sistema de Registro de Olimpiadas -----");
            System.out.println("1.Registrar atleta");
            System.out.println("2.Registrar equipo");
            System.out.println("3.Registrar evento");
            System.out.println("4.Mostrar participantes");
            System.out.println("5.Mostrar equipos");
            System.out.println("6.Mostrar eventos");
            System.out.println("7.Salir");
            System.out.println("Ingrese la opcion: ");
            int opcion = sc.nextInt();
            sc.nextLine();

            switch (opcion) {

                case 1: {
                    System.out.println("Ingrese el nombre del evento donde se registrará el atleta: ");
                    String nombreEvento = sc.nextLine();

                    Evento eventoEncontrado = objeto1.buscarEvento(nombreEvento);

                    if (eventoEncontrado == null) {
                        System.out.println("El evento no existe.");
                        break;
                    }

                    System.out.println("Ingrese nombre del atleta:");
                    String nombre = sc.nextLine();

                    System.out.println("Ingrese edad:");
                    int edad = sc.nextInt();
                    sc.nextLine();

                    try {
                        Atleta atleta = new Atleta(nombre, edad);
                        eventoEncontrado.agregarParticipante(atleta);
                        System.out.println("Atleta registrado correctamente.");
                    } catch (DatosInvalidosException e) {
                        System.out.println(e.getMessage());
                    }
                    break;
                }

                case 2: {
                    System.out.println("Ingrese el nombre del evento donde se registrará el equipo:");
                    String nombreEvento = sc.nextLine();

                    Evento eventoEncontrado = objeto1.buscarEvento(nombreEvento);

                    if (eventoEncontrado == null) {
                        System.out.println("El evento no existe.");
                        break;
                    }

                    System.out.println("Ingrese nombre del equipo:");
                    String nombre = sc.nextLine();

                    System.out.println("Ingrese año de fundación:");
                    int anio = sc.nextInt();
                    sc.nextLine();

                    try {
                        Equipo equipo = new Equipo(nombre, anio);
                        eventoEncontrado.agregarParticipante(equipo);
                        System.out.println("Equipo registrado correctamente.");
                    } catch (DatosInvalidosException e) {
                        System.out.println(e.getMessage());
                    }
                    break;
                }

                case 3: {
                    System.out.println("Ingrese el nombre del evento:");
                    String nombreEvento = sc.nextLine();

                    Evento nuevoEvento = new Evento(nombreEvento);
                    objeto1.agregarEvento(nuevoEvento);

                    System.out.println("Evento registrado correctamente.");
                    break;
                }

                case 4: {
                    System.out.println("Ingrese el nombre del evento que desea consultar:");
                    String nombreEvento = sc.nextLine();

                    Evento eventoEncontrado = objeto1.buscarEvento(nombreEvento);

                    if (eventoEncontrado == null) {
                        System.out.println("El evento no existe.");
                        break;
                    }

                    try {
                        eventoEncontrado.mostrarParticipantes();
                    } catch (DatosInvalidosException e) {
                        System.out.println(e.getMessage());
                    }
                    break;
                }

                case 5: {
                    System.out.println("Ingrese el nombre del evento que desea consultar:");
                    String nombreEvento = sc.nextLine();

                    Evento eventoEncontrado = objeto1.buscarEvento(nombreEvento);

                    if (eventoEncontrado == null) {
                        System.out.println("El evento no existe.");
                        break;
                    }

                    boolean hayEquipos = false;

                    for (Participante p : eventoEncontrado.getParticipantes()) {
                        if (p instanceof Equipo) {
                            p.mostrarTipo();
                            hayEquipos = true;
                        }
                    }

                    if (!hayEquipos) {
                        System.out.println("No hay equipos registrados en este evento.");
                    }
                    break;
                }

                case 6: {
                    try {
                        objeto1.mostrarEventos();
                    } catch (DatosInvalidosException e) {
                        System.out.println(e.getMessage());
                    }
                    break;
                }

                case 7:
                    System.out.println("Saliendo del sistema...");
                    return;

                default:
                    System.out.println("Ingrese una opción válida.");
            }
        }
    }

}
