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

/**
 * Created by portatil on 8/05/16.
 */
public class InfoPartida {

    private String nombreJugador;
    private int puntuacion;

    public InfoPartida(String pNombre, int pPuntuacion){
        this.nombreJugador=pNombre;
        this.puntuacion=pPuntuacion;
    }

    public void setNombre(String pNombre){
        this.nombreJugador=pNombre;
    }
    public void setPuntuacion(int pPuntuacion){
        this.puntuacion=pPuntuacion;
    }

    public String getNombreJugador(){
        return this.nombreJugador;
    }

    public int getPuntuacion(){
        return this.puntuacion;
    }

}
