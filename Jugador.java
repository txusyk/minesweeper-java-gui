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

import java.util.Arrays;

/**
 * Created by David on 18/04/16.
 */
public class Jugador {

    private String nombreJugador;
    private char[] passwd;
    private ListaPartidas listaPartidas;

    /**
     * @param pNombreJugador nombre del jugador
     * @param pPasswd        password del jugador
     */
    public Jugador(String pNombreJugador, char[] pPasswd) {
        this.nombreJugador = pNombreJugador;
        this.passwd = pPasswd;
        this.listaPartidas = new ListaPartidas();
    }

    /**
     * @return devuelve la lista de partidas
     */
    public ListaPartidas getListaPartidas() {
        return listaPartidas;
    }

    /**
     * @param passwd define la contraseña del jugador
     */
    public void setPasswd(char[] passwd) {
        this.passwd = passwd;
    }

    /**
     * @return devuelve el nombre del jugador
     */
    public String getNombreJugador() {
        return this.nombreJugador;
    }

    /**
     * @param nombreJug define el nombre del jugador
     */
    public void setNombreJugador(String nombreJug) {
        this.nombreJugador = nombreJug;
    }

    /**
     * @return devuelve la contraseña del jugador
     */
    public char[] getContrasena() {
        return this.passwd;
    }

    /**
     * @param pContrasena
     * @return devuelve true en caso de que las contraseñas coincidan y false en caso contrario.
     */
    public boolean comprobarPasswd(char[] pContrasena) {
        if (Arrays.equals(pContrasena, this.getContrasena())) {
            return true;
        } else {
            return false;
        }
    }

    /**
     * Se utiliza solo para debug. Dado que no es seguro convertir y/o imprimir una password
     * Por eso, se guardan en char[]
     */
    public String imprimirPassw(){
        String pass = "";

        for (char output : this.passwd) {

            pass = pass+""+output;
        }
        return pass;
    }

}