public class Libro {

    String titulo;
    String autor;
    int anioPublicacion;

    public Libro(String titulo, String autor, int anioPublicacion){

        this.titulo=titulo;
        this.autor=autor;
        this.anioPublicacion=anioPublicacion;

    }

    void mostrarInformacion(){

        System.out.println("--------------------------------------------");
        System.out.println("Titulo del libro:  "+titulo);
        System.out.println("Su autor es  "+autor);
        System.out.println("Se publico en el año "+anioPublicacion);
        System.out.println("--------------------------------------------");
    }

    public static void main(String [] args){
        Libro objeto1= new Libro("Cien años de soledad","Gabriel Garcia Marquez", 1967);
        objeto1.mostrarInformacion();
        Libro objeto2= new Libro("Prohibido","Tabitha Suzuma",2010);
        objeto2.mostrarInformacion();
    }

}
