public abstract class Participante {
    protected String nombre;

    public Participante(String nombre){
        this.nombre=nombre;
    }
    public void setNombre(String nuevoNombre)throws DatoInvalidoException{
        if (nuevoNombre.trim().isEmpty()) {
            throw new DatoInvalidoException("El nombre no puede estar vacío.");
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
    private String deporte;

    public Atleta(String nombre, String deporte) throws DatosIncorrectosException {
        super(nombre);

        if (deporte == null || deporte.trim().isEmpty()) {
            throw new DatosIncorrectosException("El deporte no puede estar vacío.");
        }

        this.deporte = deporte;
    }

    @Override
    public void mostrarTipo() {
        System.out.println("Participante-Atleta: " + nombre);
        System.out.println("Deporte: " + deporte);
    }
}

class Equipo extends Participante{
    private int integrantes;

    public Equipo(String nombre, int integrantes) throws DatosIncorrectosException {
        super(nombre);

        if (integrantes <= 0) {
            throw new DatosIncorrectosException("El equipo debe tener al menos 1 integrante.");
        }

        this.integrantes = integrantes;
    }

    @Override
    public void mostrarTipo() {
        System.out.println("Participante - Equipo : " + nombre);
        System.out.println(" Integrantes: " + integrantes);
    }
}
