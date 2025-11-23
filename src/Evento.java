import java.util.ArrayList;
public class Evento {

    private String nombreEvento;
    ArrayList<Participante> listaEvento = new ArrayList<>();

    public Evento(String nombreEvento) throws DatosIncorrectosException {

        if (nombreEvento == null || nombreEvento.trim().isEmpty()) {
            throw new DatosIncorrectosException("El nombre del evento no puede estar vacío.");
        }

        this.nombreEvento = nombreEvento;
    }

    public String getNombreEvento(){
        return nombreEvento;
    }
    public void agregarParticipantes(Participante p){
        listaEvento.add(p);
    }

    public void mostrarParticipantes(){
        System.out.println("----- Lista de participantes del Evento " + nombreEvento + "-----");
        if (listaEvento.isEmpty()) {
            System.out.println("No hay participantes agregados aun.");
        }
        for ( Participante p : listaEvento){
            p.mostrarTipo();
            System.out.println("----------------------------");
        }
    }

}
