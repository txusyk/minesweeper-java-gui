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
public class Partida {

    public String nombreJugador;
    public int puntuacion;
    public int nivelDif;
    public int tiempo;
    public int contadorMinas;
    public int minasRestantes;
    private static Partida miPartida;
    private boolean bomba = false;

    /**
     * Constructora
     * @param contadorMinas
     * @param tiempo
     * @param nivelDif
     * @param puntuacion
     * @param nombreJugador
     */
    public Partida(int contadorMinas, int tiempo, int nivelDif, int puntuacion, String nombreJugador) {
        this.contadorMinas = contadorMinas;
        this.tiempo = tiempo;
        this.nivelDif = nivelDif;
        this.puntuacion = puntuacion;
        this.nombreJugador = nombreJugador;
        this.minasRestantes = this.contadorMinas;
    }

    public static Partida getMiPartida() {
        return Partida.miPartida;
    }

    /**
     * Llama a la clase tablero y construye un objeto de ese tipo
     * cuyo tamaño esta definido por la dificultad
     */
    private void crearTablero(){
        System.out.println("Introduzca el nivel de tablero que desea: ");
        int auxN = Teclado.getMiTeclado().recogerInt();
        Tablero.getMiTablero().setNivel(auxN);
        Tablero.getMiTablero().crearTablero();
    }

    public void modificarMinasRestantes(boolean pFlag) {
        if (pFlag) {
            this.minasRestantes++;
        } else if (!pFlag) {
            this.minasRestantes--;
        }
    }

    /**
     * Cambia el valor del booleano bomba
     */
    public void setBomba() {
        this.bomba = false;
    }


    /**
     * Comienza a jugar la partida hasta que este resuelta o bien se haya encontrado una mina
     */
    public void jugarPartida(){
        int auxLvl;
        String auxNombre;
        Jugador auxJugador = null;

        System.out.println("Introduzca su nombre: ");
        auxNombre = Teclado.getMiTeclado().recogerString();
        auxJugador = new Jugador(auxNombre);
        System.out.println("Introduzca el nivel de tablero deseado (1-3): ");
        auxLvl = Teclado.getMiTeclado().recogerInt();
        Tablero.getMiTablero().setNivel(auxLvl);
        Tablero.getMiTablero().crearTablero();
        while (!bomba) {

        }
    }

    /**
     * Imprime la informacion de la partida
     */
    public void imprimirInfo(){

    }


}
