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

import java.util.Random;

/**
 * Created by jalva on 21/02/2016.
 */
public class Tablero {

    private Casilla[][] tablero;
    private static Tablero miTablero;
    private int x, y;
    private final int numMinas;
    private int nivel;

    private Tablero() {
        switch (nivel) {
            case 1:
                this.x = 7;
                this.y = 10;
                break;
            case 2:
                this.x = 10;
                this.y = 15;
                break;
            case 3:
                this.x = 12;
                this.y = 25;
                break;
            default:
                break;
        }
        this.numMinas = y * nivel;
        this.tablero = new Casilla[x][y];
    }

    public void setNivel(int pNivel) {
        this.nivel = pNivel;
    }

    public int getX() {
        return this.x;
    }

    public int getY() {
        return this.y;
    }

    public static Tablero getMiTablero() {
        if (miTablero == null) {
            miTablero = new Tablero();
        }
        return miTablero;
    }

    private void anadirCasillaTablero(Casilla pCasilla) {
        this.tablero[pCasilla.getPosX()][pCasilla.getPosY()] = pCasilla;
    }

    public Casilla getCasilla(int posX, int posY) {
        return this.tablero[posX][posY];
    }

    public void crearTablero() {

        this.tablero = new CasillaVacia[x][y]; //Creamos un tablero con el tamaño definido por la dificultad

        /*for (int i=0; i<x;i++) { //rellenamos todas las casillas con espacios vacios
            for (int j=0;j<y;j++){
                this.anadirCasillaTablero(new CasillaVacia(i,j));
            }
        }*/

        for (int i = 1; i <= numMinas; i++) { //primero generamos las minas de forma aleatoria en el mapa
            Random rand = new Random();
            CasillaNumerica auxCasilla = null;
            int auxX = rand.nextInt(this.x - 1); //la clase random devuelve un numero entre 0 y el numero
            int auxY = rand.nextInt(this.y - 1); // indicado por el usuario

            this.anadirCasillaTablero(new CasillaMina(auxX, auxY));

            if (auxY != 0 && auxX != 0) { //miramos la casilla superior izq
                if (this.tablero[auxX - 1][auxY - 1] instanceof CasillaVacia) {
                    this.anadirCasillaTablero(new CasillaNumerica(auxX - 1, auxY - 1));
                } else if (this.tablero[auxX - 1][auxY - 1] instanceof CasillaNumerica) {
                    auxCasilla = (CasillaNumerica) Tablero.getMiTablero().getCasilla(auxX - 1, auxY - 1);
                    auxCasilla.aumentarValor();
                }
            }
            if (auxY != 0) {//miramos la casilla superior
                if (this.tablero[auxX][auxY - 1] instanceof CasillaVacia) {
                    this.anadirCasillaTablero(new CasillaNumerica(auxX, auxY - 1));
                } else if (this.tablero[auxX][auxY - 1] instanceof CasillaNumerica) {
                    auxCasilla = (CasillaNumerica) Tablero.getMiTablero().getCasilla(auxX, auxY - 1);
                    auxCasilla.aumentarValor();
                }
            }
            if (auxY != 0 && auxX != this.x - 1) {
                if (this.tablero[auxX + 1][auxY - 1] instanceof CasillaVacia) { //miramos la casilla superior derecha
                    this.anadirCasillaTablero(new CasillaNumerica(auxX + 1, auxY - 1));
                } else if (this.tablero[auxX + 1][auxY - 1] instanceof CasillaNumerica) {
                    auxCasilla = (CasillaNumerica) Tablero.getMiTablero().getCasilla(auxX + 1, auxY - 1);
                    auxCasilla.aumentarValor();
                }
            }
            if (auxX != this.x - 1) {
                if (this.tablero[auxX + 1][auxY] instanceof CasillaVacia) { //miramos la casilla derecha
                    this.anadirCasillaTablero(new CasillaNumerica(auxX + 1, auxY));
                } else if (this.tablero[auxX + 1][auxY] instanceof CasillaNumerica) {
                    auxCasilla = (CasillaNumerica) Tablero.getMiTablero().getCasilla(auxX + 1, auxY);
                    auxCasilla.aumentarValor();
                }
            }
            if (auxY != this.y - 1 && auxX != this.x - 1) { //miramos la casilla inferior derecha
                if (this.tablero[auxX + 1][auxY + 1] instanceof CasillaVacia) {
                    this.anadirCasillaTablero(new CasillaNumerica(auxX + 1, auxY + 1));
                } else if (this.tablero[auxX + 1][auxY + 1] instanceof CasillaNumerica) {
                    auxCasilla = (CasillaNumerica) Tablero.getMiTablero().getCasilla(auxX + 1, auxY + 1);
                    auxCasilla.aumentarValor();
                }
            }
            if (auxY != this.y - 1) { //comprobamos la casilla de abajo
                if (this.tablero[auxX][auxY + 1] instanceof CasillaVacia) {
                    this.anadirCasillaTablero(new CasillaNumerica(auxX, auxY + 1));
                } else if (this.tablero[auxX][auxY + 1] instanceof CasillaNumerica) {
                    auxCasilla = (CasillaNumerica) Tablero.getMiTablero().getCasilla(auxX, auxY + 1);
                    auxCasilla.aumentarValor();
                }
            }
            if (auxY != this.y - 1 && auxX != 0) {//comprobamos la casilla de abajo a la izq
                if (this.tablero[auxX - 1][auxY + 1] instanceof CasillaVacia) {
                    this.anadirCasillaTablero(new CasillaNumerica(auxX - 1, auxY + 1));
                } else if (this.tablero[auxX - 1][auxY + 1] instanceof CasillaNumerica) {
                    auxCasilla = (CasillaNumerica) Tablero.getMiTablero().getCasilla(auxX - 1, auxY + 1);
                    auxCasilla.aumentarValor();
                }
            }
            if (auxX != 0) {//comprobamos la casilla de la izq
                if (this.tablero[auxX - 1][auxY] instanceof CasillaVacia) {
                    this.anadirCasillaTablero(new CasillaNumerica(auxX - 1, auxY));
                } else if (this.tablero[auxX - 1][auxY] instanceof CasillaNumerica) {
                    auxCasilla = (CasillaNumerica) Tablero.getMiTablero().getCasilla(auxX - 1, auxY);
                    auxCasilla.aumentarValor();
                }
            }
        }
    }
}
