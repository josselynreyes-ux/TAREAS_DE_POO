public class Artista {
    private String nombre;
    private String genero;
    private double seguidores;

    //CONSTRUCTOR VACIO Y CON PARAMETROS
    public Artista (String nombre, String genero, double seguidores){

        this.nombre=nombre;
        this.genero=genero;
        this.seguidores=seguidores;

    }

    public Artista(){

    }

    //VALIDACION EN SET
    public void setGenero(String nuevoGenero){
        if (nuevoGenero.trim().isEmpty()){
            System.out.println("Error: el campo no puede estar vacio.");
        }else{
            this.genero=nuevoGenero;
            System.out.println("Genero ingresado correctamente.");
        }
    }
    public String getGenero(){
        return genero;
    }

    public void setNombre(String nuevoNombre){
        if (nuevoNombre.trim().isEmpty()){
            System.out.println("Error: el campo no puede estar vacio.");
        }else{
            this.nombre=nuevoNombre;
            System.out.println("Nombre del artista ingresado correctamente.");
        }
    }
    public String getNombre(){
        return nombre;
    }

    public void setSeguidores(double nuevoSeguidor){
        if (nuevoSeguidor>0){
            this.seguidores= nuevoSeguidor;
            System.out.println("Seguidores añadidos exitosamente.");
        }else{
            System.out.println("Error: no ingresar un valor negativo o igual a cero.");
        }
    }

    public double getSeguidores(){
        return seguidores;
    }

    //CREACION DE METODOS
    public void ganarSeguidores(int cantidad){
        if (cantidad>0){
            seguidores+=cantidad;
            System.out.println("Seguidores añadidos exitosamente.");
        }else{
            System.out.println("Error: no ingresar un valor negativo o igual a cero.");
        }
    }

    public void mostrarArtista(){
        System.out.println("------------ Artista -------------");
        System.out.println("Nombre: "+ nombre);
        System.out.println("Genero: "+ genero);
        System.out.println("Seguidores: "+ seguidores);
        System.out.println("----------------------------------");
    }
}
