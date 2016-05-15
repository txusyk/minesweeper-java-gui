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
                        //this.boton.setForeground(Color.white);
                        this.boton.setIcon(new ImageIcon("/home/josu/Documentos/IntelliJ Projects/Buscaminas/src/1.png"));
                        break;
                    case 2:
                        //this.boton.setForeground(Color.blue);
                        this.boton.setIcon(new ImageIcon("/home/josu/Documentos/IntelliJ Projects/Buscaminas/src/2.png"));
                        break;
                    case 3:
                        //this.boton.setForeground(Color.cyan);
                        this.boton.setIcon(new ImageIcon("/home/josu/Documentos/IntelliJ Projects/Buscaminas/src/3.png"));
                        break;
                    case 4:
                        //this.boton.setForeground(Color.GREEN);
                        this.boton.setIcon(new ImageIcon("/home/josu/Documentos/IntelliJ Projects/Buscaminas/src/4.png"));
                        break;
                    case 5:
                        this.boton.setIcon(new ImageIcon("/home/josu/Documentos/IntelliJ Projects/Buscaminas/src/5.jpg"));
                        //this.boton.setForeground(Color.MAGENTA);
                        break;
                    case 6:
                        this.boton.setIcon(new ImageIcon("/home/josu/Documentos/IntelliJ Projects/Buscaminas/src/6.gif"));
                        //this.boton.setForeground(Color.ORANGE);
                        break;
                    case 7:
                        this.boton.setIcon(new ImageIcon("/home/josu/Documentos/IntelliJ Projects/Buscaminas/src/7.png"));
                        //this.boton.setForeground(Color.lightGray);
                        break;
                    case 8:
                        this.boton.setIcon(new ImageIcon("/home/josu/Documentos/IntelliJ Projects/Buscaminas/src/8.png"));
                        //this.boton.setForeground(Color.YELLOW);
                        break;
                    case 9:
                        this.boton.setIcon(new ImageIcon("/home/josu/Documentos/IntelliJ Projects/Buscaminas/src/bomb.png"));
                    default:
                        break;
                }
                //this.boton.setText(Integer.toString(this.casilla.getIdCasilla()));
            }
        }
        if (casilla.isFlag()) {
            this.boton.setIcon(new ImageIcon("/home/josu/Documentos/IntelliJ Projects/Buscaminas/src/bandera.gif"));
            //this.boton.setText("P");
            //this.boton.setBackground(Color.yellow);
        }
        if (!casilla.isFlag() && !casilla.getEstaDescubierta()) {
            this.boton.setText("");
            this.boton.setBackground(new JButton().getBackground());
        }
    }
}

