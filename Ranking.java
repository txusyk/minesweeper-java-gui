import java.util.ArrayList;
import java.util.Iterator;

/**
 * Created by portatil on 8/05/16.
 */
public class Ranking {

    private ArrayList<InfoPartida> listaRanking;
    private static Ranking miRanking;

    private Ranking(){
        listaRanking = new ArrayList<>();
    }

    public ArrayList<InfoPartida> getListaRanking(){
        return this.listaRanking;
    }

    /**
     * Crea una lista de todas las partidas jugadas, ordenadas por puntuacion (mayor->menor)
     */
    public void crearListaRanking() {
        InfoPartida auxI;
        int i = 0;    //indice para marcar los loops sobre la lista general de jugadores.
        int k = 0;    //indice para marcar los loops sobre las puntuaciones de cada partida de cada jugador.

        ListaJugadores.getMiListaJugadores().ordenarPartidasFull();

        for (Jugador auxJ : ListaJugadores.getMiListaJugadores().getLjugadores()){
            for(Partida auxP : ListaJugadores.getMiListaJugadores().getJugador(auxJ.getNombreJugador()).getListaPartidas().getlPartidas()){
                auxI = new InfoPartida(auxJ.getNombreJugador(),auxP.getPuntuacion());
                this.listaRanking.add(auxI);
            }
        }
    }

    public static Ranking getMiRanking(){
        if(miRanking==null){
            miRanking = new Ranking();
        }
        return Ranking.miRanking;
    }

    private Iterator <InfoPartida> getIterator(){
        return this.listaRanking.iterator();
    }

    /**
     * Obtiene una lista de las 10 mejores partidas
     * @return ArrayList<InfoPartida>Contendra las 10 mejores partidas</InfoPartida>
     */
    public ArrayList<InfoPartida> obtenerDiezMejores(){
        ArrayList<InfoPartida> auxL= new ArrayList<>();
        InfoPartida auxI;
        Iterator<InfoPartida> itr=this.getIterator();
        int i=0;
        int j=0;

        while(itr.hasNext() && i<10){
            auxI=itr.next();
            auxL.add(auxI);
            i++;
        }

        while(j<auxL.size()){
            System.out.println("Jugador: "+auxL.get(j).getNombreJugador()+"\tPuntuacion: "+auxL.get(j).getPuntuacion());
            j++;
        }

        return auxL;
    }

    public void mostrarInfo(){
        Iterator<InfoPartida> itr=this.getIterator();
        InfoPartida auxI;

        while (itr.hasNext()){
            auxI=itr.next();
            System.out.println("Partida de "+auxI.getNombreJugador()+" con puntuacion: "+auxI.getPuntuacion());
        }

    }
    public void añadirInfoPartida(InfoPartida iP){
        if(!Ranking.getMiRanking().esta(iP)){
            this.listaRanking.add(iP);
        }
        else{
            System.out.println("La partida ya existia.");
        }
    }

    public boolean esta(InfoPartida iP){
        Iterator<InfoPartida> itr=Ranking.getMiRanking().getIterator();
        InfoPartida auxI;
        boolean enc=false;

        while(itr.hasNext() && !enc){
            auxI=itr.next();
            if (auxI.getNombreJugador().equals(iP.getNombreJugador()) && auxI.getPuntuacion() == iP.getPuntuacion()){
                enc=true;
            }
        }
        return enc;
    }

    public void resetear(){     //Lo utilizamos unicamento en los casos de prueba.
        Ranking.getMiRanking().listaRanking.clear();
    }

}
