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
 * @author Josu Alvarez <jalvarez041.ehu.eus>
 */
public class Partida {
    //puntuacion = [(numCasillasTablero * factor de correccion)/tiempo] * 1000
    //                                      f:1 m: d:1
    private int segundos;
    private String dificultad;
    private int puntuacion;

    public Partida(int pSegundos, String pDificultad) {
        this.segundos = pSegundos;
        this.dificultad = pDificultad;
        this.setPuntuacion();
    }

    public int getSegundos() {
        return segundos;
    }

    public String getDificultad() {
        return this.dificultad;
    }

    public int getPuntuacion() {
        return this.puntuacion;
    }

    private void setPuntuacion() {
        int factorCalculoBase = 1000;
        int factorDificultad;
        if (dificultad.equalsIgnoreCase("facil")) {
            factorDificultad = 3;
        } else if (dificultad.equalsIgnoreCase("medio")) {
            factorDificultad = 2;
        } else {
            factorDificultad = 1;
        }
        double auxPuntuacion = ((double) factorCalculoBase*factorDificultad /(segundos)) * 10.7;
        this.puntuacion = (int) auxPuntuacion;

    }

    public void imprimirInfo() {
        System.out.println("La puntuacion fue: " + this.puntuacion + ". Tardo " + this.getSegundos() + ".La dificultad era: " + this.dificultad);
    }

}
