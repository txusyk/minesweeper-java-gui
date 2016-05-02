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

import java.util.Observable;


/**
 * Created by josu on 4/25/16.
 */
public class ModeloTablero extends Observable {

    /**
     * Ninguno de estos atributos debera de ser modificable desde fuera
     */
    private ModeloCasilla[][] casillas;
    private int x, y;
    private int numMinas, numMinasRestantes;
    private String estadoActual;
    private int numCasillasReveladas;
    private int reloj;

    /**
     * Constructora
     *
     * @param pX
     * @param pY
     * @param pNumBombas
     */
    public ModeloTablero(int pX, int pY, int pNumBombas) {
        this.x = pX;
        this.y = pY;
        this.casillas = new ModeloCasilla[x][y];
        this.numMinas = pNumBombas;
        this.numMinasRestantes = pNumBombas;
        this.numCasillasReveladas = 0;
        this.estadoActual = "jugando";

        this.costruirTablero();
    }

    public ModeloCasilla getCasilla(int pX,int pY){
        return this.casillas[pX][pY];
    }

    public int getX(){
        return this.x;
    }

    public int getY(){
        return this.y;
    }

    public String getEstado(){
        return this.estadoActual;
    }

    public void setEstado(String pEstado){
        this.estadoActual = pEstado;
    }

    public int getNumMinas(){
        return this.numMinas;
    }

    public int getNumMinasRestantes(){
        return this.numMinasRestantes;
    }

    /**
     * Inicializacion de los componentes
     */
    public void inicializacion() {
        this.resetearCasillas();
        this.estadoActual = "jugando";
        this.numMinasRestantes = this.numMinas;
        this.numCasillasReveladas = 0;

        this.construir();
        this.setChanged();
        this.notifyObservers();
    }

    public void construir() {
        //costruimos el tablero con casillas
        this.generarTablero();
        this.ponerMinas();
        this.notifyObservers(true);
    }

    private void generarTablero() {
        //fijamos todas las casillas
        this.fijarTodasLasCasillas();

        //añadimos las casillas de minas
        this.ponerMinas();


    }

    private void ponerMinas() {
        int auxX, auxY;
        for (int i = 0; i < numMinas; i++) {
            do {
                auxX = this.generarPosicionesRandom("x");
                auxY = this.generarPosicionesRandom("y");
            } while (this.casillas[auxX][auxY].getId() == -1);

            this.casillas[auxX][auxY].setMina();
            aumentarValoresCercanos(this.getCasilla(auxX,auxY));
        }
    }

    private int generarPosicionesRandom(String pXoY) {
        int random = 0;
        if (pXoY.equals("x")) {
            random = (int) (Math.random() * this.x);
        } else if (pXoY.equals("y")) {
            random = (int) (Math.random() * this.y);
        }
        return random;
    }

    public void aumentarValoresCercanos(ModeloCasilla pCasilla){
        int auxX;
        int auxY;

        for (int i= 1; i >= -1;i--){
            for (int j=1; j>= -1;j--){
                auxX = pCasilla.getX()+i; //guardamos las posiciones relativas a la casilla sobre x
                auxY = pCasilla.getY()+j; //guardamos las posiciones relativas al eje y

                if ((auxX>=0 && auxX<this.x) && (auxY>=0 && auxY<this.y)){
                    if (this.getCasilla(auxX,auxX).getId() != -1){
                        this.getCasilla(auxX,auxY).incrementarEnUno();
                    }
                }
            }
        }
    }

    public void revelarCasillasDesdeCero(ModeloCasilla pCasilla) {
        int x = pCasilla.getX();
        int y = pCasilla.getY();

        for (int i = 1; i >= -1; i--) {
            for (int j = 1; j >= -1; j--) {
                int auxY = x + i;
                int auxX = y + j;

                if ((auxX >= 0 && auxX < this.x) && (auxY >= 0 && auxY < this.y)) {
                    if (!this.getCasilla(auxX, auxY).getSiEstaMarcada() && this.getCasilla(auxX,auxY).getId()!=-1) {
                        this.getCasilla(auxX,auxY).revelarCasilla();
                    }
                }
            }
        }
    }

    public void aniadirAreveladas(){
        this.numCasillasReveladas++;
        int numCasillasNecesariasParaGanar = (this.x*this.y) - numMinas;
        if (this.numCasillasReveladas == numCasillasNecesariasParaGanar){
            this.setEstado("ganado");
        }
        this.setChanged();
        this.notifyObservers();
    }

    public void aumentarMarcadorMinas(){
        this.numMinasRestantes++;
        this.setChanged();
        this.notifyObservers();
    }

    public void reducirMarcadorMinas(){
        this.numMinasRestantes--;
        this.setChanged();
        this.notifyObservers();
    }

    public void resetearCasillas(){
        for (int i = 0; i < x; i++) {
            for (int j = 0; j < y; j++) {
                this.casillas[i][j] = new ModeloCasilla(this,i,j,0);
            }
        }
    }

    public void fallo() {
        for (ModeloCasilla[] a : casillas) {
            for (ModeloCasilla b : a) {
                b.revelar();
            }
        }
    }
}
