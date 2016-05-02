import java.util.*;
import java.util.Map.*;

/**
 * Created by David on 18/04/16.
 */
public class ListaPartidas {

    private ArrayList<Partida> listaPartidas;

    public ListaPartidas(){
        this.listaPartidas=new ArrayList<Partida>();
    }

    public void anadirPartida(Partida partida){
        listaPartidas.add(partida);
    }

    public void eliminarPartida(Partida partida){
        if(esta(partida)){
            listaPartidas.remove(partida);
        }
        else {
            System.out.println("La partida no existe.");
        }
    }

    public Iterator<Partida> getIterador(){
        return this.listaPartidas.iterator();
    }

    public boolean esta(Partida partida){
        Iterator <Partida> itr=this.getIterador();
        Partida auxPartida;
        boolean encontrada=false;

        while(itr.hasNext()||!encontrada){
            auxPartida=itr.next();
            if(auxPartida.equals(partida)){
                encontrada=true;
            }
        }
        return encontrada;
    }

    private ArrayList<Partida> ordenarListaPorPuntuaion(){
            ArrayList <Partida> listaOrdenada;
            TreeMap hashOrdenado = new TreeMap<String, Partida>();
            Iterator<Partida> it = this.listaPartidas.iterator();
            Partida auxPartida;
            while (it.hasNext()){
                auxPartida = it.next();
                hashOrdenado.put()
            }
            hashOrdenado = new TreeMap("",this.listaPartidas);
            Partida auxP=null;

            listaOrdenada= new ArrayList<Partida>(hashOrdenado.values());

            return listaOrdenada;
    }


}
