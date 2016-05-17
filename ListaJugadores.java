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
 * @author Josu Alvarez <jalvarez041.ehu.eus>
 */
public class ListaJugadores {

    private static ListaJugadores miListaJugadores;
    ArrayList<Jugador> lJugadores;

    /**
     * Constructora
     */
    public ListaJugadores() {
        this.lJugadores = new ArrayList<>();
    }

    /**
     * Inicializa la ListaJugadores en caso de que sea null y la devuelve
     *
     * @return ListaJugadores
     */
    public static ListaJugadores getMiListaJugadores() {
        if (miListaJugadores == null) {
            miListaJugadores = new ListaJugadores();
        }
        return miListaJugadores;
    }

    public ArrayList<Jugador> getLjugadores() {
        return this.lJugadores;
    }

    public Iterator<Jugador> getIterator() {
        return this.lJugadores.iterator();
    }

    /**
     * @param pNombre
     * @return Devuelve el jugador en caso de existir, en caso contrario devuelve null
     */
    public Jugador getJugador(String pNombre) {
        Jugador jugAux = null;
        Iterator<Jugador> itr = this.getIterator();
        boolean enc = false;
        while (itr.hasNext() && !enc) {
            jugAux = itr.next();
            if (jugAux.getNombreJugador().equalsIgnoreCase(pNombre)) {
                enc = true;
            }
        }
        if (!enc) {
            jugAux = null;
        }
        return jugAux;
    }

    /**
     * pre: Disponemos de una lista de jugadores
     * post: Habremos añadido el jugador en caso de no existir previamente
     *
     * @param pJugador
     */
    public void anadirJugador(Jugador pJugador){
        if(!this.esta(pJugador)) {
            this.lJugadores.add(pJugador);
        }
    }

    /**
     * Elimina al jugador de la lista
     *
     * @param pJugador
     */
    public void eliminarJugador(Jugador pJugador) {
        if (esta(pJugador)) {
            this.lJugadores.remove(pJugador);
        }
    }

    /**
     * @param pJugador
     * @return Devolvera true en caso de encontrar al jugador que recibe como parametro
     */
    public boolean esta(Jugador pJugador) {
        Iterator<Jugador> itr = this.getIterator();
        //Partida auxPartida;
        boolean encontrado = false;

        for (Jugador auxJug : lJugadores) {
            if (auxJug.getNombreJugador().equalsIgnoreCase(pJugador.getNombreJugador())) {
                encontrado = true;
            }
        }
        return encontrado;
    }

        /**
         * @param pNombre
         * @param pContrasena
         * @return Devuelve true en caso de que pContraseña coincida con el usuario
         */

    public boolean comprobarContrasena(String pNombre, char[] pContrasena) {
        boolean coinciden = false;
        if (this.getJugador(pNombre) != null) {
            coinciden = this.getJugador(pNombre).comprobarPasswd(pContrasena);
        }
        return coinciden;
    }

    public void imprimirJugadores(){
        for(Jugador auxJug : this.lJugadores){
            System.out.println("Nombre: "+auxJug.getNombreJugador());
            System.out.println("Su lista de partidas es->");
            auxJug.getListaPartidas().imprimirPartidas();
        }
    }

    public void ordenarPartidasFull() {
        Iterator<Jugador> itr = this.getIterator();
        Jugador auxU;
        while (itr.hasNext()) {
            auxU = itr.next();
            auxU.ordenarJugadas();
        }
    }
}