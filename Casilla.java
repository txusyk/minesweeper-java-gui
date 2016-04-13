/*
 * The MIT License
 *
 * Copyright 2016 Josu Alvarez <jalvarez041.ehu.eus>.
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in
 * all copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN
 * THE SOFTWARE.
 */

/**
 * Created by jalva on 21/02/2016.
 */
public abstract class Casilla {

    protected int posX, posY;
    protected int estado = 0; //0 cubierta; 1 descubierta; 2 marcadaa




    /**
     * @param pPosX
     * @param pPosY
     * Constructora
     */
    public Casilla(int pPosX, int pPosY){
        this.posX = pPosX;
        this.posY = pPosY;
    }

    /**
     * @return devuelve la coordenadaX
     */
    public  int getPosX(){
        return this.posX;
    }

    /**
     * @return devuelve la coordenadaY
     */
    public int getPosY(){
        return this.posY;
    }

    /**
     *
     * @param posX
     * @param posY
     * Se encarga de accionar la casilla oportuna
     */
    abstract void descubrirCasilla(int posX, int posY);

    /**
     * Pone una marca en la casilla
     */

    public void marcarCasilla() {
        if (this.estado == 0) {
            this.estado = 2;
            Partida.getMiPartida().modificarMinasRestantes(true);
        }
    }

    public void desmarcarCasilla() {
        if (this.estado == 2) {
            this.estado = 0;
            Partida.getMiPartida().modificarMinasRestantes(false);
        }
    }




}
