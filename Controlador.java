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

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

/**
 * @author Josu Alvarez <jalvarez041.ehu.eus>
 */
public class Controlador extends MouseAdapter {

    private ModeloCasilla casilla;
    private ModeloTablero ModeloTablero;

    /**
     * Constructora
     *
     * @param casilla define las casillas de juego
     */
    public Controlador(ModeloCasilla casilla) {
        this.casilla = casilla;
    }


    /**
     * Constructora
     *
     * @param model
     */
    public Controlador(ModeloTablero model) {
        this.ModeloTablero = model;
    }

    /**
     * controla los click-s del raton y las clases y metodos del ModeloTablero
     *
     * @param e el MouseEvent acaba de activarse
     */
    @Override
    public void mouseClicked(MouseEvent e) {

        switch (e.getButton()) {
            case MouseEvent.BUTTON1:
                if (this.ModeloTablero == null) {
                    if (!casilla.isFlag()) {
                        casilla.descubreCasilla();
                    }
                } else {
                    ModeloTablero.Init();
                }
                break;
            case MouseEvent.BUTTON3:
                if (this.ModeloTablero == null) {
                    casilla.cambiaEstado();
                }
                break;
            default:
                break;
        }
    }
}
