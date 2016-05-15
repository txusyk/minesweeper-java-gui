/*
 * Copyright [2016] [Josu]
 *
 *    Licensed under the Apache License, Version 2.0 (the "License");
 *    you may not use this file except in compliance with the License.
 *    You may obtain a copy of the License at
 *
 *        http://www.apache.org/licenses/LICENSE-2.0
 *
 *    Unless required by applicable law or agreed to in writing, software
 *    distributed under the License is distributed on an "AS IS" BASIS,
 *    WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *    See the License for the specific language governing permissions and
 *    limitations under the License.
 */

import java.util.ArrayList;
import java.util.Iterator;

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

    public void imprimirPartidas(){
        for (int i=0; i<listaPartidas.size();i++){
            listaPartidas.get(i).imprimirInfo();
        }
    }

    /*private ArrayList<Partida> ordenarListaPorPuntuaion(){
            ArrayList <Partida> listaOrdenada;
            TreeMap hashOrdenado = new TreeMap<String, Partida>();
            Iterator<Partida> it = this.listaPartidas.iterator();
            Partida auxPartida;
            while (it.hasNext()){
                auxPartida = it.next();
                hashOrdenado.put();
            }
            hashOrdenado = new TreeMap("",this.listaPartidas);
            Partida auxP=null;

            listaOrdenada= new ArrayList<Partida>(hashOrdenado.values());

            return listaOrdenada;
    }*/


}
