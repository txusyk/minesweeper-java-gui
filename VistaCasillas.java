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
 * @author Josu Alvarez <jalvarez041.ehu.eus>
 */
public class VistaCasillas extends JButton implements Observer {

    private JButton boton;
    private ModeloCasilla casilla;
    private Controlador controlador;

    /**
     * crea los botones necesarios
     *
     * @param field
     */
    public VistaCasillas(ModeloCasilla field) {
        this.casilla = field;
        this.boton = new JButton("");
        this.boton.setPreferredSize(new Dimension(25, 25));
        this.controlador = new Controlador(field);
        this.boton.addMouseListener(controlador);
        this.casilla.addObserver(this);
    }

    public JButton getBoton() {
        return this.boton;
    }

    /**
     * actualiza la vista de los botones
     *
     * @param obs
     * @param o
     */
    @Override
    public void update(Observable obs, Object o) {
        // TODO Auto-generated method stub
        if (casilla.getEstaDescubierta() == true) {
            this.boton.setBackground(Color.LIGHT_GRAY);
            if (this.casilla.getIdCasilla() == 0) {
                this.boton.setText("");
            } else {
                switch (this.casilla.getIdCasilla()) {
                    case 1:
                        this.boton.setIcon(new ImageIcon(getClass().getResource("1.png")));
                        break;
                    case 2:
                        this.boton.setIcon(new ImageIcon(getClass().getResource("2.png")));
                        break;
                    case 3:
                        this.boton.setIcon(new ImageIcon(getClass().getResource("3.png")));
                        break;
                    case 4:
                        this.boton.setIcon(new ImageIcon(getClass().getResource("4.jpg")));
                        break;
                    case 5:
                        this.boton.setIcon(new ImageIcon(getClass().getResource("5.jpg")));
                        break;
                    case 6:
                        this.boton.setIcon(new ImageIcon(getClass().getResource("6.gif")));
                        break;
                    case 7:
                        this.boton.setIcon(new ImageIcon(getClass().getResource("7.png")));
                        break;
                    case 8:
                        this.boton.setIcon(new ImageIcon(getClass().getResource("8.png")));
                        break;
                    case 9:
                        this.boton.setIcon(new ImageIcon(getClass().getResource("bomb.png")));
                    default:
                        break;
                }
            }
        }
        if (casilla.isFlag()) {
            this.boton.setIcon(new ImageIcon(getClass().getResource("bandera.gif")));
        }
        if (!casilla.isFlag() && !casilla.getEstaDescubierta()) {
            this.boton.setText("");
            this.boton.setBackground(new JButton().getBackground());
        }
    }
}

