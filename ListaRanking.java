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

import java.util.HashMap;

/**
 * @author Josu Alvarez <jalvarez041.ehu.eus>
 */
public class ListaRanking {

    private static ListaRanking miListaRanking;
    private HashMap<String, ListaPartidas> listaR;

    private ListaRanking() {
        this.listaR = new HashMap<String, ListaPartidas>();
    }

    public static ListaRanking getMiListaRanking() {
        if (miListaRanking == null) {
            miListaRanking = new ListaRanking();
        }
        return miListaRanking;
    }

    private boolean esta(String pNombreJug) {
        boolean esta = false;
        if (this.listaR.get(pNombreJug) != null) {
            esta = true;
        }
        return esta;
    }

    private void anadirOrdenado(String pNombreJug) {
        Jugador auxJug = ListaJugadores.getMiListaJugadores().getJugador(pNombreJug);
        if (auxJug.getNombreJugador() == null) {
            this.listaR.put(auxJug.getNombreJugador(), auxJug.getListaPartidas());
        }
    }
}

