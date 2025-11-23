import java.util.ArrayList;
public class Olimpiada {
    String nombreOlimpiada;
    ArrayList<Evento> listaOlimpiada= new ArrayList<>();

    public Olimpiada(String nombreOlimpiada) throws DatosIncorrectosException {
        if (nombreOlimpiada == null|| nombreOlimpiada.trim().isEmpty()){
            throw new DatosIncorrectosException("El campo no puede estar vacio.");
        }
        this.nombreOlimpiada = nombreOlimpiada;
    }

    public void agregarEvento(Evento e){
        listaOlimpiada.add(e);
    }

    public void mostrarEvento(){
        System.out.println("----- Lista de eventos de la Olimpiada " + nombreOlimpiada +"-----");
        if (listaOlimpiada.isEmpty()){
            System.out.println("No hay eventos registrados aun.");
        }

        for( Evento e : listaOlimpiada){
            e.mostrarParticipantes();
            System.out.println("----------------------------");
        }

    }

}
