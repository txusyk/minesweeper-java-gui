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
 *
 * @author Eneko
 */
public class ModeloCasilla extends Observable {


    private int idCasilla;
    private int posx;
    private int posy;
    private ModeloTablero model;
    private boolean estaDescubierta;        //si la casilla se revela
    private boolean esBandera;            //si se selecciona una casilla con bandera

    /**
     * Constructor
     *
     * @param model
     * @param x posicion x en el panel de juego
     * @param y posicion y en el panel de juego
     * @param idPanel
     */
    public ModeloCasilla(ModeloTablero model, int x, int y, int idPanel) {
        this.idCasilla = idPanel;
        this.posx = x;
        this.posy = y;
        this.model = model;
        this.estaDescubierta = false;
        this.esBandera = false;

    }

    /**
     * inicializacion del panel
     * @param model
     * @param x
     * @param y
     * @param idPanel
     */
    public void Init(ModeloTablero model, int x, int y, int idPanel) {
        this.idCasilla = idPanel;
        this.posx = x;
        this.posy = y;
        this.model = model;
        this.estaDescubierta = false;
        this.esBandera = false;

    }

    /**
     * descubre casilla
     */
    public void descubreCasilla() {
        if (model.getModo().equals("En Juego")) {
            if (!this.model.getThread().isAlive()) {
                this.model.startThread();
            }

            if (this.idCasilla == 9) {
                this.model.setModo("Has perdido");

                this.estaDescubierta = true;
                this.setChanged();
                this.notifyObservers();
            } else if (this.estaDescubierta == false) {
                model.annadirADescubiertas();
                this.estaDescubierta = true;
                if (this.idCasilla == 0) {
                    this.model.descubrirCasillasVacias(this);
                }
                this.setChanged();
                this.notifyObservers();

            }
        }

        //if (!model.getModo().equals("En juego")) {
        //this.model.stopThread();
        //}

    }

    /**
     * Cambio de estado
     */
    public void cambiaEstado() {
        if (!this.esBandera && !this.getEstaDescubierta() && model.getModo().equals("En Juego")) {

            if (!this.model.getThread().isAlive()) {
                this.model.startThread();
            }
            this.esBandera = true;
            this.model.subMinasRestantes();
            this.setChanged();
            this.notifyObservers();
        } else if (!this.getEstaDescubierta() && model.getModo().equals("En Juego")) {
            this.esBandera = false;
            this.model.addMinasRestantes();
            this.setChanged();
            this.notifyObservers();
        }

        if (!model.getModo().equals("En Juego")) {
            this.model.stopThread();
        }
    }

    /**
     *
     * @return si una casilla es marcada con bandera
     */
    public boolean isFlag() {
        return this.esBandera;
    }

    /**
     *
     * @return id de casilla
     */
    public int getIdCasilla() {
        return idCasilla;
    }

    /**
     *
     * @return posicion x
     */
    public int getPosx() {
        return posx;
    }

    /**
     *
     * @return posicion x
     */
    public int getPosy() {
        return posy;
    }

    /**
     *
     * @return esta descubierta
     */
    public boolean getEstaDescubierta() {
        return this.estaDescubierta;
    }

    /**
     * añade 1 al id de casilla
     */
    public void add1() {
        this.idCasilla++;
    }

    /**
     * casilla con mina
     */
    public void setMina() {
        this.idCasilla = 9;
    }

    /**
     *
     * @return el ModeloTablero
     */
    public ModeloTablero getModelo() {
        return this.model;
    }

}
