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

    public ListaPartidas() {
        this.listaPartidas = new ArrayList<>();
    }

    public   Iterator<Partida> getIterator(){
        return this.listaPartidas.iterator();
    }

    public ArrayList<Partida> getlPartidas(){
        return this.listaPartidas;
    }

    public void anadirPartida(Partida pPartida){
        if(!this.esta(pPartida)) {
            this.listaPartidas.add(pPartida);
        }
        else{
            System.out.println("La partida ya existia.");
        }
    }
    public void eliminarPartida(Partida partida) {
        if (esta(partida)) {
            listaPartidas.remove(partida);
        } else {
            System.out.println("La partida no existe.");
        }
    }

    public boolean esta(Partida partida) {
        Iterator<Partida> itr = this.getIterator();
        //Partida auxPartida;
        boolean encontrada = false;

        for (Partida auxPartida : listaPartidas){
            if (auxPartida.equals(partida)) {
                encontrada = true;
            }
        }
        return encontrada;

        /*while (itr.hasNext() && !encontrada) {
            auxPartida = itr.next();
            if (auxPartida.equals(partida)) {
                encontrada = true;
            }
        }
        return encontrada;*/
    }

    public void imprimirPartidas() {
        /*for (int i = 0; i < listaPartidas.size(); i++) {
            listaPartidas.get(i).imprimirInfo();
        }*/
        /*for (Partida auxPartida : listaPartidas){
            auxPartida.imprimirInfo();
        }*/
        listaPartidas.forEach((Partida) -> Partida.imprimirInfo());
    }

    public void ordenarListaPorPuntuaion(){
        Iterator<Partida> itr= this.getIterator();
        ArrayList<Partida> lAux = new ArrayList<>();
        Partida selec = null;
        Partida auxP;
        int i=1;

        while(itr.hasNext()&&listaPartidas.size()!=1){

            selec=this.listaPartidas.get(0);
            while(i<listaPartidas.size()) {
                auxP=this.listaPartidas.get(i);
                if (selec.getPuntuacion() < auxP.getPuntuacion()) {
                    selec = auxP;
                    i++;
                } else {
                    i++;
                }
            }
            lAux.add(selec);
            this.listaPartidas.remove(selec);
            i=1;

        }
        try{
            selec=listaPartidas.get(0);
        } catch(IndexOutOfBoundsException e){
                e.getMessage();
        }
        lAux.add(selec);
        this.listaPartidas=lAux;
    }



}
