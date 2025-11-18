import java.util.ArrayList;
public class Evento {
    private String tipoEvento;
    ArrayList<Participante> participantes = new ArrayList<>();

    public Evento(String tipoEvento){
        this.tipoEvento=tipoEvento;
    }

    public void setTipoEvento(String tipoEvento) throws DatosInvalidosException {
        if (tipoEvento.trim().isEmpty()) {
            throw new DatosInvalidosException("El nombre del evento no puede estar vacío.");
        }
        this.tipoEvento = tipoEvento;
    }

    public String getTipoEvento() {
        return tipoEvento;
    }

    public void agregarParticipante(Participante participante){
        participantes.add(participante);
        System.out.println("Participante agregado al evento: " + tipoEvento);
    }

    public void mostrarParticipantes()throws DatosInvalidosException{
        if (participantes.isEmpty()){
            throw new DatosInvalidosException("El evento no tiene participantes.");
        }else{
            System.out.println("----- Atletas registrados -----");
            for (Participante participante : participantes){
                //llamar al metodo de esta forma es
                // lo que se considera polimorfismo
                participante.mostrarTipo();
            }
        }
    }

    public ArrayList<Participante> getParticipantes() {
        return participantes;
    }

    @Override
    public String toString() {
        return "Evento: " + tipoEvento + " | Participantes: " + participantes.size();
    }
}
