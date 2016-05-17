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
 * @author Josu Alvarez <jalvarez041.ehu.eus>
 */
public class ModeloTablero extends Observable {


    private ModeloCasilla[][] casilla;
    private int y;
    private int x;
    private int numMinas;
    private int minasRestantes;
    private Estado estado;
    private int descubierto;
    private Thread thread;    //Thread para el temporizador
    private int timer;        //entero para el timer
    private boolean enEjecucion;    //booleano que controla la ejecucion del thread

    private long start = System.currentTimeMillis();

    /**
     * Constructor
     *
     * @param x        x del ModeloCasilla de juego
     * @param y        y del ModeloCasilla de juego
     * @param numMinas numero de numMinas
     */
    public ModeloTablero(int x, int y, int numMinas) {

        //Crea las casillas como un array
        this.casilla = new ModeloCasilla[y][x];
        this.x = x;
        this.y = y;
        this.numMinas = numMinas;
        this.minasRestantes = numMinas;
        this.descubierto = 0;
        this.timer = 0;
        this.estado = new EnJuego();
        this.enEjecucion = false;
        this.thread = new Thread();

        panelJuego();

    }

    /**
     * Inicializacion
     */
    public void Init() {
        //reset a las casillas
        resetearCasillas();
        this.estado = new EnJuego();
        this.minasRestantes = this.numMinas;
        this.descubierto = 0;

        resetThread();
        panelJuego();
        this.setChanged();
        this.notifyObservers(true);
    }

    /**
     * crea el thread para el timer
     */
    private void setThread() {

        this.thread = new Thread() {
            @Override
            public void run() {
                while (enEjecucion) {
                    try {
                        updateTimer();
                        setChanged();
                        notifyObservers();
                        this.sleep(500);

                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        };
        this.thread.start();
    }

    /**
     * establece el timer
     */
    public void updateTimer() {
        this.timer = Integer.parseInt(String.valueOf((System.currentTimeMillis()-start)/1000));
    }

    /**
     * crea el PanelJuego
     */
    public void panelJuego() {
        //set a todas las casillas
        setCasillas();

        //"random" para colocar numMinas
        for (int i = 0; i < numMinas; i++) {
            int x, y;

            do {
                x = (int) (Math.random() * (this.x));
                y = (int) (Math.random() * (this.y));
            } while (this.casilla[y][x].getIdCasilla() == 9);

            this.casilla[y][x].setMina();
            contadorMinas(getCasilla(y, x));
        }
    }


    /**
     * Añade +1 a cada casilla alrededor
     *
     * @param casilla
     */
    public void contadorMinas(ModeloCasilla casilla) {
        int ax;
        int ay;
        for (int i = -1; i < 2; i++) {
            for (int j = -1; j < 2; j++) {
                ay = casilla.getPosy() + i;
                ax = casilla.getPosx() + j;

                if (ay >= 0 && ay < this.y && ax >= 0 && ax < this.x) {
                    if (this.casilla[ay][ax].getIdCasilla() != 9) {
                        this.casilla[ay][ax].add1();
                    }
                }
            }
        }
    }

    /**
     * Descubre las casillas vacias pertinentes
     *
     * @param casilla
     */
    public void descubrirCasillasVacias(ModeloCasilla casilla) {
        int x = casilla.getPosx();
        int y = casilla.getPosy();

        int ax;
        int ay;
        for (int i = -1; i < 2; i++) {
            for (int j = -1; j < 2; j++) {
                ay = y + i;
                ax = x + j;

                if (ay >= 0 && ay < this.y && ax >= 0 && ax < this.x) {
                    if (!this.casilla[ay][ax].isFlag()) {
                        this.casilla[ay][ax].descubreCasilla();
                    }
                }
            }

        }
    }

    /**
     * set las casillas
     */
    private void setCasillas() {
        for (int i = 0; i < this.y; i++) {
            for (int j = 0; j < this.x; j++) {
                this.casilla[i][j] = new ModeloCasilla(this, j, i, 0);
            }
        }
    }

    public void descubrirTablero() {
        for (int i = 0; i < this.y; i++) {
            for (int j = 0; j < this.x; j++) {
                this.casilla[i][j].setEstaDescubierta();
            }
        }
    }

    /**
     * resetea las casillas a 0
     */
    private void resetearCasillas() {
        for (int i = 0; i < this.y; i++) {
            for (int j = 0; j < this.x; j++) {
                this.casilla[i][j].Init(this, j, i, 0);
            }
        }
    }

    /**
     * añade +1 al numero de numMinas descubiertas y cambia el estado a ganado,
     * si asi se dan las condiciones
     */
    public void annadirADescubiertas() {
        this.descubierto++;
        if (this.descubierto >= ((this.x * this.y) - numMinas)) {
            this.estado = new Ganado();

        }
        this.setChanged();
        this.notifyObservers();
    }

    /**
     * +1 a las numMinas restantes
     */
    public void addMinasRestantes() {
        this.minasRestantes++;
        this.setChanged();
        this.notifyObservers();
    }

    /**
     * -1 a las numMinas restantes
     */
    public void subMinasRestantes() {
        this.minasRestantes--;
        this.setChanged();
        this.notifyObservers();
    }

    /**
     * inicio del Thread
     */
    public void startThread() {
        this.enEjecucion = true;
        this.setThread();
    }

    /**
     * resetea el thread del timer
     */
    public void resetThread() {
        this.enEjecucion = false;
        this.timer = 0;
        this.start = System.currentTimeMillis();
        this.setChanged();
        this.notifyObservers();
    }

    /**
     * para el thread
     */
    public void stopThread() {
        this.enEjecucion = false;
    }

    /**
     * @return el thread del timer
     */
    public Thread getThread() {
        return this.thread;
    }

    /**
     * @return y del ModeloCasilla de juego
     */
    public int getAltura() {
        return this.y;
    }

    /**
     * @return x del ModeloCasilla del juego
     */
    public int getAncho() {
        return this.x;
    }

    /**
     * @return estado de juego
     */
    public String getModo() {
        return this.estado.getEstado();
    }

    /**
     * establece el estado
     *
     * @param estado estado
     */
    /*public void setModo(String estado) {
        this.estado = estado;
        this.setChanged();
        this.notifyObservers();
    }*/

    /**
     * @param y
     * @param x
     * @return
     */
    public ModeloCasilla getCasilla(int y, int x) {
        return this.casilla[y][x];
    }

    /**
     * @return numero de numMinas restantes
     */
    public int minasRestantes() {
        return this.minasRestantes;
    }

    /**
     * @return el timer
     */
    public int getTimer() {

        return this.timer;
    }

    public void setEstado(Estado pEstado){
        this.estado = pEstado;
        setChanged();
        notifyObservers();
    }

}