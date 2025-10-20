public class Cancion {

    private String titulo;
    private double duracion;
    private int reproducciones;

    //COMO REPRODUCCIONES EMPIEZA EN 0 NO SE DEBE PONER EN EL CONSTRUCTOR COMO PARAMETRO,
    //ASI EVITAMOS QUE EL USUARIO PUEDA CAMBIARLO.
    public Cancion (String titulo, double duracion){

        this.titulo= titulo;
        this.duracion=duracion;
        this.reproducciones=0; //reproducciones siempre inicia en cero

    }

    public Cancion(){

    }

    //VALIDACIONES CON SET Y GET
    public void setTitulo(String nuevoTitulo){
        if (nuevoTitulo.trim().isEmpty()){
            System.out.println("Error: el campo no puede estar vacio.");
        }else{
            this.titulo=nuevoTitulo;
            System.out.println("Titulo ingresado correctamente.");
        }
    }
    public String getTitulo(){
        return titulo;
    }

    public void setDuracion(double nuevaDuracion){
        if (nuevaDuracion<=0){
            System.out.println("Error: no ingresar un valor negativo o igual a cero.");
        }else{
            this.duracion=nuevaDuracion;
            System.out.println("Duracion ingresada correctamente.");
        }
    }
    public double getDuracion(){
        return duracion;
    }

    //METODO REPRODUCIR
    public void reproducir(){
        reproducciones=reproducciones+1;

    }
    public int getReproducciones(){
        return reproducciones;
    }

    public void mostrarCancion(){
        System.out.println("---- Cancion ----");
        System.out.println("Titulo: "+ titulo);
        System.out.println("Duracion: "+duracion);
        System.out.println("Reproducciones: "+reproducciones);
        System.out.println("------------------");
    }
}
