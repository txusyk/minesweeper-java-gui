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
public class ModeloCasilla extends Observable{

    /**
     * Atributos=> Seran unicamente modificables desde la propia clase
     */
    private int id;
    private int x,y;
    private ModeloTablero tablero;
    private boolean estaRevelada, estaMarcada;

    /**
     * Constructora
     *
     * @param pTablero
     * @param pX
     * @param pY
     * @param pIdCasilla
     */
    public ModeloCasilla(ModeloTablero pTablero,int pX,int pY, int pIdCasilla){
        this.tablero = pTablero;
        this.x = pX;
        this.y = pY;
        this.id= pIdCasilla;
        this.tablero = pTablero;

        this.estaRevelada = false;
        this.estaMarcada = false;
    }

    //Getters&Setters
    /**
     * getID()
     * @return Devolvera el ID de la casilla
     */
    public int getId(){
        return this.id;
    }

    /**
     * @return devuelve la posicion X
     */
    public int getX(){
        return this.x;
    }

    /**
     * @return devuelve la posicion Y
     */
    public int getY(){
        return this.y;
    }

    /**
     * @return devuelve si la casilla esta revelada
     */
    public boolean getSiEstaRevelada(){
        return this.estaRevelada;
    }

    /**
     * getEstaRevelada()
     * @return Devolvera un booleano indicando si la casilla esta revelada
     */
    public boolean getEstaRevelada(){ return this.estaRevelada;}

    public boolean getSiEstaMarcada(){ return this.estaMarcada;}


    /**
     * setMina()
     * Fijara la casilla como una mina
     */
    public  void setMina(){
        this.id = -1;
    }

    /**
     * Pre: Tenemos un tablero compuesto por elementos ModeloCasilla
     * Post: Revelaremos una/variass de dichas casillas
     */
    public void revelarCasilla(){
        if (this.tablero.equals("jugando")){
            if (this.id == -1){
                this.tablero.setEstado("perdido");
                this.estaRevelada = true;
                this.setChanged();
                this.notifyObservers();
            }
            else if(!this.getSiEstaRevelada()){
                this.tablero.aniadirAreveladas();
                this.estaRevelada = true;
                if (this.id == 0){
                    this.tablero.revelarCasillasDesdeCero(this);
                }
                this.setChanged();
                this.notifyObservers();
            }
        }
    }

    /**
     * Pre: Tenemos un tablero compuesto por ModeloCasillas
     * Post: Hemos marcado/desmarcado una casilla que vacia/marcada
     */
    public void marcarCasilla(){
        if (!this.estaMarcada && !this.getEstaRevelada() && this.tablero.getEstado().equals("jugando")){
            this.estaMarcada = true;
            this.tablero.reducirMarcadorMinas();
            this.setChanged();
            this.notifyObservers();
        }
        else if(!this.getEstaRevelada() && this.tablero.getEstado().equals("jugando")){
            this.estaMarcada = false;
            this.tablero.aumentarMarcadorMinas();
            this.setChanged();
            this.notifyObservers();
        }
    }

    public void incrementarEnUno(){
        this.id++;
    }
}
