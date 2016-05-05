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
 * Created by josu on 5/3/16.
 */
public class VistaCasillas extends JButton implements Observer {

    private JButton boton_casilla;
    private ModeloCasilla casilla;
    private Controlador controlador;

    public VistaCasillas(ModeloCasilla pCasilla){
        this.casilla = pCasilla;
        this.boton_casilla = new JButton(""); //modificar por el icono por deffecto
        Dimension dimensionCasilla = new Dimension(30,30);
        this.boton_casilla.setPreferredSize(dimensionCasilla);
        this.controlador = new Controlador(casilla);
        this.boton_casilla.addMouseListener(controlador);
        this.casilla.addObserver(this);
    }

    public JButton getBoton_casilla(){
        return this.boton_casilla;
    }

    public void ocultarBoton(){
        this.boton_casilla.setVisible(false);
        this.casilla.revelarCasilla();
    }

    @Override
    public void update(Observable pObs, Object pObjeto){
        if (casilla.getSiEstaRevelada()){
            if (this.casilla.getId() != -1){
                this.setBackground(Color.DARK_GRAY);
                if (this.casilla.getId() != 0) {
                    switch (this.casilla.getId()) {
                        case 1:
                            this.boton_casilla.setForeground(Color.white);
                            break;
                        case 2:
                            this.boton_casilla.setForeground(Color.blue);
                            break;
                        case 3:
                            this.boton_casilla.setForeground(Color.cyan);
                            break;
                        case 4:
                            this.boton_casilla.setForeground(Color.GREEN);
                            break;
                        case 5:
                            this.boton_casilla.setForeground(Color.MAGENTA);
                            break;
                        case 6:
                            this.boton_casilla.setForeground(Color.ORANGE);
                            break;
                        case 7:
                            this.boton_casilla.setForeground(Color.lightGray);
                            break;
                        case 8:
                            this.boton_casilla.setForeground(Color.YELLOW);
                            break;
                        default:
                            break;
                    }
                    this.boton_casilla.setText(Integer.toString(this.casilla.getId()));
                }else{
                    this.boton_casilla.setText("");
                }
            }else{
                this.boton_casilla.setBackground(Color.RED);
            }
        }
        if (casilla.getSiEstaMarcada()){
            this.boton_casilla.setText("*");
            this.boton_casilla.setBackground(Color.BLACK);
            this.boton_casilla.setForeground(Color.RED);
        }else if (!casilla.getSiEstaRevelada() && !casilla.getSiEstaMarcada()){
            this.boton_casilla.setText("");
            this.boton_casilla.setBackground(new JButton().getBackground());
        }
    }
}
