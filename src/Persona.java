public class Persona {
    private String nombre;
    private int edad;
    private String profesion;

    /* creamos el constructor Persona pero inicializamos con setter para que las validaciones
    * se cumplan y no exista un error*/
    public Persona(String nombre, int edad, String profesion){
        setNombre(nombre);
        setEdad(edad);
        setProfesion(profesion);
    }

    public void setNombre(String nuevoNombre) {
        if (nuevoNombre.trim().isEmpty()) {
            System.out.println("No puede dejar el campo vacio.");
        } else {
            this.nombre = nuevoNombre;
            System.out.println("Se modifico el nombre existosamente.");
        }
    }

    public String getNombre() {
        return this.nombre;
    }

    public void setEdad(int nuevaEdad) {
        if (nuevaEdad <= 0) {
            System.out.println("No puede ingresar una edad negativa.");
        } else {
            this.edad = nuevaEdad;
            System.out.println("Se modifico la edad exitosamente.");
        }
    }

    public int getEdad() {
        return this.edad;
    }

    public void setProfesion(String nuevaProfesion) {
        if (nuevaProfesion.trim().isEmpty()) {
            System.out.println("No puede dejar el campo vacio.");
        } else {
            this.profesion = nuevaProfesion;
            System.out.println("Se cambio la profesion exitosamente.");
        }
    }

    public String getProfesion() {
        return this.profesion;
    }

    public void mostrarDatos() {
        System.out.println("---- Datos de la Persona ----");
        System.out.println("Nombre: " + nombre);
        System.out.println("Edad: " + edad);
        System.out.println("Profesión: " + profesion);
        System.out.println("-----------------------------");
    }

    public static void main(String[] args) {
        Persona objeto1 = new Persona("Josselyn", 20, "Veterinaria");
        objeto1.mostrarDatos();

        Persona objeto2= new Persona("",-5," ");
        objeto2.mostrarDatos();
        

    }
}

