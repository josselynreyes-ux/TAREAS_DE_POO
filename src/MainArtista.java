import java.util.Scanner;
public class MainArtista {
    public static void main (String[]args){

        int opcion;

        Scanner sc= new Scanner(System.in);
        Artista objeto1= new Artista("Carly Rae Jepsen", "pop",71.4);
        objeto1.mostrarArtista();

        Artista objeto2= new Artista();
        System.out.println("-----------------------------------------");
        System.out.println("Ingrese el nombre del artista: ");
        objeto2.setNombre(sc.nextLine());
        System.out.println("Ingrese el genero musical del artista: ");
        objeto2.setGenero(sc.nextLine());
        System.out.println("Ingrese la cantidad de seguidores del artista: ");
        objeto2.setSeguidores(sc.nextDouble());
        System.out.println("-----------------------------------------");
        objeto2.mostrarArtista();

        Cancion objetoCancion1= new Cancion("Call me maybe", 3.24 );

        while (true){
            System.out.println("---- Sistema de Artistas ----");
            System.out.println("1.Registrar un artista.");
            System.out.println("2.Registra una cancion.");
            System.out.println("3.Aumentar seguidores.");
            System.out.println("4.Reproducir una cancion.");
            System.out.println("5.Mostrar informacion.");
            System.out.println("6.Salir del sistema.");
            System.out.println("Ingresa la opcion a realizar: ");
            opcion = sc.nextInt();
            sc.nextLine(); //limpiamos buffer

            switch (opcion){
                case 1:
                    Artista nuevoArtista= new Artista();
                    System.out.println("Ingrese el nombre del artista: ");
                    nuevoArtista.setNombre(sc.nextLine());
                    System.out.println("Ingrese el genero musical del artista: ");
                    nuevoArtista.setGenero(sc.nextLine());
                    System.out.println("Ingrese la cantidad de seguidores del artista: ");
                    nuevoArtista.setSeguidores(sc.nextDouble());
                    sc.nextLine();// limpiamos buffer
                    System.out.println("Artista registrado exitosamente.");
                    break;
                case 2:
                    Cancion nuevaCancion= new Cancion();
                    System.out.println("Ingresa el nombre de la nueva cancion: ");
                    nuevaCancion.setTitulo(sc.nextLine());
                    System.out.println("Ingresa la duracion de la cancion: ");
                    nuevaCancion.setDuracion(sc.nextDouble());
                    sc.nextLine();
                    System.out.println("Cancion registrada exitosamente.");
                    break;
                case 3:
                    System.out.println("Ingrese la cantida de seguidores nuevos de "+ objeto2.getNombre());
                    int cantidad = sc.nextInt();
                    objeto2.ganarSeguidores(cantidad);
                    break;
                case 4:
                    objetoCancion1.reproducir();
                    System.out.println("La cancion "+ objetoCancion1.getTitulo() +" tiene "+ objetoCancion1.getReproducciones() + " reproducciones.");
                    break;
                case 5:
                    objeto1.mostrarArtista();
                    objeto2.mostrarArtista();
                    objetoCancion1.mostrarCancion();
                    break;
                case 6:
                    System.out.println("Saliendo del sistema de artistas.");
                    break;
                default:
                    System.out.println("Error: opcion invalidad.");
                    break;
            }
        }
    }
}
