import java.util.ArrayList;
public class Olimpiada {
    private String nombre;
    private int anio;
    ArrayList<Evento> eventos = new ArrayList<>();

    public Olimpiada(String nombre, int anio){
        this.nombre = nombre;
        this.anio = anio;
    }

    public void setNombre(String nuevoNombre)throws DatosInvalidosException{
        if (nuevoNombre.trim().isEmpty()) {
            throw new DatosInvalidosException("Nombre de olimpiada vacío.");
        }else {
            this.nombre=nuevoNombre;
        }
    }
    public String getNombre(){
        return nombre;
    }

    public void setAnio(int nuevoAnio)throws DatosInvalidosException{
        if (nuevoAnio <= 0) {
            throw new DatosInvalidosException("Año inválido.");
        }else{
            this.anio=nuevoAnio;
        }
    }
    public int getAnio(){
        return anio;
    }


    public void agregarEvento(Evento evento){
        eventos.add(evento);
        System.out.println("Evento registrado con éxito.");
    }

    public ArrayList<Evento> getEventos() {
        return eventos;
    }

    public void mostrarEventos()throws DatosInvalidosException{
        if (eventos.isEmpty()){
            throw new DatosInvalidosException("No hay eventos registrados.");
        }else{
            System.out.println("------ Registro de Eventos -----");
            for (Evento evento : eventos){
                System.out.println("Olimpiada "+nombre+" del "+anio);
                System.out.println(evento.toString());
            }
        }
    }

    public Evento buscarEvento(String nombre){
        for (Evento evento : eventos){
            if (evento.getTipoEvento().equalsIgnoreCase(nombre)){
                return evento;
            }
        }
        return null;
    }
}
