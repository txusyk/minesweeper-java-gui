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
public class ListaJugadores {

    private static ListaJugadores miListaJugadores;
    HashMap<String, Jugador> lJugadores;

    /**
     * Constructora
     */
    public ListaJugadores() {
        this.lJugadores = new HashMap<>();
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

    public HashMap<String, Jugador> getLjugadores() {
        return this.lJugadores;
    }

    /**
     * @param pNombre
     * @return Devuelve el jugador en caso de existir, en caso contrario devuelve null
     */
    public Jugador getJugador(String pNombre) {
        Jugador jugAux = null;
        if (this.lJugadores.get(pNombre) != null) {
            jugAux = this.lJugadores.get(pNombre);
        }
        return jugAux;
    }

    /**
     * pre: Disponemos de una lista de jugadores
     * post: Habremos añadido el jugador en caso de no existir previamente
     *
     * @param pJugador
     */
    public boolean anadirJugador(Jugador pJugador) {
        boolean anadido = false;
        if (!this.esta(pJugador)) {
            this.lJugadores.put(pJugador.getNombreJugador(), pJugador);
            anadido = true;
        }
        return anadido;
    }

    /**
     * Elimina al jugador de la lista
     *
     * @param pJugador
     */
    public void eliminarJugador(Jugador pJugador) {
        if (this.esta(pJugador)) {
            this.lJugadores.remove(pJugador.getNombreJugador());
        }
    }

    /**
     * @param pJugador
     * @return Devolvera true en caso de encontrar al jugador que recibe como parametro
     */
    private boolean esta(Jugador pJugador) {
        boolean enc = false;
        if (this.lJugadores.get(pJugador.getNombreJugador()) != null) {
            enc = true;
        }
        return enc;
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
}
