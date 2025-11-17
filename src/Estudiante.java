public class Estudiante {
    private String nombre;
    private int edad;

    public Estudiante(String nombre, int edad){
        this.nombre = nombre;
        this.edad=edad;
    }

    public void setNombre(String nuevoNombre){
        if(nuevoNombre.trim().isEmpty()){
          throw new IllegalArgumentException("El nombre del estudiante no puede estar vacio.");
        }else{
            this.nombre = nuevoNombre;
        }
    }

    public String getNombre(){
        return nombre;
    }

    public void setEdad(int nuevaEdad){
        if (nuevaEdad<0||nuevaEdad>120){
            throw new IllegalArgumentException("Edad fuera del rango valido.");
        }else{
            this.edad=nuevaEdad;
        }
    }

    public int getEdad(){
        return edad;
    }

    public void mostrasInformacion(){
        System.out.println("----- Datos del estudiante -----");
        System.out.println("Nombre: "+ nombre);
        System.out.println("Edad: "+ edad);
        System.out.println("--------------------------------");
    }
}

