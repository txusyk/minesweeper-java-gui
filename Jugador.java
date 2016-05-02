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
 * Created by David on 18/04/16.
 */
public class Jugador {

    private String nombreJugador;
    private String passwd;
    private ListaPartidas listaPartidas;

    /**
     *
     * @param pNombreJugador        nombre del jugador
     * @param pPasswd               password del jugador
     */
    public Jugador(String pNombreJugador, String pPasswd){
        this.nombreJugador= pNombreJugador;
        this.passwd = pPasswd;
        this.listaPartidas=new ListaPartidas();
    }

    /**
     * @return devuelve la lista de partidas
     */
    public ListaPartidas getListaPartidas() {
        return listaPartidas;
    }

    /**
     *
      * @param nombreJug        define el nombre del jugador
     */
    public void setNombreJugador(String nombreJug){
        this.nombreJugador=nombreJug;
    }

    /**
     *
     * @param passwd        define la contraseña del jugador
     */
    public void setPasswd(String passwd){
        this.passwd=passwd;
    }

    /**
     *
     * @return devuelve el nombre del jugador
     */
    public String getNombreJugador(){
        return this.nombreJugador;
    }

    /**
     *
     * @return devuelve la contraseña del jugador
     */
    public String getContrasena(){
        return this.passwd;
    }

    /**
     *
     * @param contrasena
     * @return devuelve true en caso de que las contraseñas coincidan y false en caso contrario.
     */
    public boolean comprobarPasswd(String contrasena){
        if(this.passwd.equals(contrasena)){
            return true;
        }
        else{
            return false;
        }
    }

}