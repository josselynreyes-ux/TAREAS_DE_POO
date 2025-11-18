public abstract class Participante {
    protected String nombre;

    public Participante(String nombre){
        this.nombre=nombre;
    }
    public void setNombre(String nuevoNombre)throws DatosInvalidosException{
        if (nuevoNombre.trim().isEmpty()) {
            throw new DatosInvalidosException("El nombre no puede estar vacío.");
        }else{
            this.nombre=nuevoNombre;
        }
    }

    public String getNombre(){
        return nombre;
    }

    public abstract void mostrarTipo();
}

class Atleta extends Participante{
    private int edad;
    public Atleta (String nombre, int edad)throws DatosInvalidosException{
        super(nombre);
        this.edad = edad;
    }

    public void setEdad(int nuevaEdad)throws DatosInvalidosException{
        if (nuevaEdad <= 0){
            throw new DatosInvalidosException("La edad no puede ser negativa ni cero.");
        }else{
            this.edad = nuevaEdad;
        }

    }

    public int getEdad(){
        return edad;
    }


    @Override
    public void mostrarTipo(){
        System.out.println("----- ATLETA -----");
        System.out.println("Nombre: "+ nombre);
        System.out.println("Edad:" + edad);
        System.out.println("------------------");
    }
}

class Equipo extends Participante{
    private int anio;
    public Equipo(String nombre, int anio)throws DatosInvalidosException{
        super(nombre);
        this.anio=anio;
    }

    public void setAnio(int nuevoAnio)throws DatosInvalidosException{
        if (nuevoAnio <= 0){
            throw new DatosInvalidosException("El año de fundacion no puede ser negativo o cero.");
        }else{
            this.anio= nuevoAnio;
        }
    }

    public int getAnio(){
        return anio;
    }

    @Override
    public void mostrarTipo(){
        System.out.println("----- EQUIPO -----");
        System.out.println("Nombre: "+ nombre);
        System.out.println("Año de fundacion:" + anio);
        System.out.println("------------------");
    }
}

