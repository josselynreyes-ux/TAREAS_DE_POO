public abstract class Juego {
    protected String nombre;
    protected String genero;

    public Juego(String nombre, String genero) throws DatosIncorrectosException {

        if(nombre == null || nombre.trim().isEmpty()){
            throw new DatosIncorrectosException("El nombre no puede estar vacío.");
        }

        if(genero == null || genero.trim().isEmpty()){
            throw new DatosIncorrectosException("El género no puede estar vacío.");
        }

        this.nombre = nombre;
        this.genero = genero;
    }

    public String getNombre() {
        return nombre;
    }

    public String getGenero() {
        return genero;
    }

    public abstract void jugar();
    public abstract void mostrarInfo();
}

class MarioBros extends Juego {

    private int vidas;

    public MarioBros(String nombre, String genero, int vidas)
            throws DatosIncorrectosException {

        super(nombre, genero);

        if (vidas <= 0) {
            throw new DatosIncorrectosException("Las vidas deben ser positivas.");
        }

        this.vidas = vidas;
    }

    @Override
    public void jugar() {
        System.out.println("Jugando Mario Bros: saltar, correr y rescatar a la princesa.");
    }

    public void mostrarInfo(){
        System.out.println("=== MARIO BROS ===");
        System.out.println("Nombre: " + nombre);
        System.out.println("Género: " + genero);
        System.out.println("Vidas: " + vidas);
    }
}

class CarreraVehiculos extends Juego {

    private int vehiculos;

    public CarreraVehiculos(String nombre, String genero, int vehiculos)
            throws DatosIncorrectosException {

        super(nombre, genero);

        if (vehiculos <= 0) {
            throw new DatosIncorrectosException("Debe haber al menos 1 vehículo.");
        }

        this.vehiculos = vehiculos;
    }

    @Override
    public void jugar() {
        System.out.println("Jugando Carreras: conducir lo más rápido hasta la meta.");
    }

    public void mostrarInfo(){
        System.out.println("=== CARRERAS ===");
        System.out.println("Nombre: " + nombre);
        System.out.println("Género: " + genero);
        System.out.println("Vehículos: " + vehiculos);
    }
}

