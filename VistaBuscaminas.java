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

import javax.swing.*;
import java.awt.*;
import java.util.Observable;
import java.util.Observer;

/**
 * Created by josu on 4/18/16.
 */
public class VistaBuscaminas extends JPanel implements Observer {
    /**
     * Declaracion de variables
     */
    private static final long serialVersionUID = 1L;
    private JPanel panelJuego = new JPanel();
    private JLabel numBombas, estadoJuego, reloj;
    private VistaCasillas[][] casillas;
    private ModeloTablero tablero;

    private JMenuBar barra_menu;
    private JMenu menu_archivo;
    private JMenuItem ranking;
    private JMenuItem salir;
    private JMenuItem reiniciar;
    private JMenu menu_ayuda;
    private JMenuItem FAQ;
    private JMenuItem acercaDe;
    private JMenuItem problemasFrecuentes;

    /**
     * Constructora
     *
     * @param pTablero
     */
    public VistaBuscaminas(ModeloTablero pTablero) {
        this.tablero = pTablero;
        this.setLayout(new BorderLayout());
        this.panelJuego = new JPanel();
        //this.barra_menu = new JMenuBar();
        //this.numBombas = new JLabel("Minas restantes :" + Integer.toString(tablero.getNumMinasRestantes()));
        //this.estadoJuego = new JLabel("Estado de juego: " + tablero.getEstado());

        //this.ranking = new JMenuItem("Reiniciar");
        //Controlador controlador = new Controlador(this.tablero);
        //this.ranking.addMouseListener(controlador);

        /*this.menu_archivo = new JMenu();
        this.menu_archivo.add(this.ranking);
        this.menu_archivo.add(this.reiniciar);
        this.menu_archivo.add(this.salir);

        this.menu_ayuda = new JMenu();
        this.menu_ayuda.add(this.acercaDe);
        this.menu_ayuda.add(this.FAQ);
        this.menu_ayuda.add(this.problemasFrecuentes);

        this.barra_menu.add(menu_archivo);
        this.barra_menu.add(menu_ayuda);*/

        //this.add(this.numBombas, BorderLayout.WEST);
        //this.add(this.estadoJuego, BorderLayout.EAST);
        this.add(restartButton(), BorderLayout.NORTH);
        //faltaria añadir en el centro el boton del ttemporizador
        //this.add(this.barra_menu, BorderLayout.NORTH);
        this.casillas = new VistaCasillas[tablero.getX()][tablero.getY()];
        this.tablero.addObserver(this);

        this.panelJuego.setLayout(new GridLayout(tablero.getX(), tablero.getY()));
        costruirBotonesTableroJuego();
        this.add(panelJuego, BorderLayout.SOUTH);
    }

    /**
     * @return devuelve la vista del panel de juego
     */
    public JPanel getPanelJuego() {
        return this.panelJuego;
    }

    /**
     * actualizamos los botones
     */
    public void actualizarBotones() {
        this.restablecerBotones();
        costruirBotonesTableroJuego();
    }

    /**
     * Elimina todos los botones
     */
    private void restablecerBotones() {
        for (int i = 0; i < this.tablero.getX(); i++) {
            for (int j = 0; j < this.tablero.getY(); j++) {
                this.panelJuego.remove(casillas[i][j].getBoton_casilla());
            }
        }
    }

    private void costruirBotonesTableroJuego() {
        for (int i = 0; i < this.tablero.getX(); i++) {
            for (int j = 0; j < this.tablero.getY(); j++) {
                VistaCasillas botonAux = new VistaCasillas(this.tablero.getCasilla(i, j));
                casillas[i][j] = botonAux;
                this.panelJuego.add(botonAux.getBoton_casilla());
            }
        }
    }

    /**
     * Sera el encargado de actualizar la vista
     *
     * @param o
     * @param arg
     */
    @Override
    public void update(Observable o, Object arg) {
        if (o != null) {
            actualizarBotones();
        }
        //this.numBombas = new JLabel("Minas restantes :" + Integer.toString(tablero.getNumMinasRestantes()));
        //this.estadoJuego = new JLabel("Estado de juego: " + tablero.getEstado());
    }

    public JButton restartButton() {
        JButton button = new JButton("Restart");
        button.setPreferredSize(new Dimension(20, 40));
        Controlador controller = new Controlador(tablero);
        button.addMouseListener(controller);
        return button;

    }
}
