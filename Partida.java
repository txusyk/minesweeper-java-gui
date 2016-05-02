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
 * Created by portatil on 18/04/16.
 */
public class Partida {
    //puntuacion = [(numCasillasTablero * factor de correccion)/tiempo] * 1000
    //                                      f:1 m: d:1
    private int segundos;
    private String dificultad;
    private int puntuacion;

    public Partida(int pSegundos, String pDificultad){
        this.segundos=pSegundos;
        this.dificultad=pDificultad;
        this.setPuntuacion();
    }

    public int getSegundos(){
        return segundos;
    }

    public String getDificultad(){
        return this.dificultad;
    }

    public int getPuntuacion(){
        return this.puntuacion;
    }

    private void setPuntuacion(){
        if(dificultad.equalsIgnoreCase("facil")){
            double auxPuntuacion = (70.0*0.3)/(double)(segundos)*1000;
            this.puntuacion=(int)auxPuntuacion;
        }
        else if(dificultad.equalsIgnoreCase("medio")){
            double auxPuntuacion = (150*0.5)/(double)(segundos)*1000;
            this.puntuacion=(int)auxPuntuacion;
        }
        else{
            double auxPuntuacion = (300)/(double)(segundos)*1000;
            this.puntuacion=(int)auxPuntuacion;
        }
    }

}
