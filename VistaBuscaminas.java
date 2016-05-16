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
public class VistaBuscaminas extends JPanel implements Observer {

    private JPanel vista;
    private JLabel minas, modo, timer;
    private VistaCasillas[][] casilla;
    private ModeloTablero ModeloTablero;
    private boolean hasPerdido = false;

    /**
     * Constructora
     *
     * @param modeloTablero establece los parametros estandar para la vista
     */
    public VistaBuscaminas(ModeloTablero modeloTablero) {
        this.ModeloTablero = modeloTablero;
        this.setLayout(new BorderLayout());
        this.vista = new JPanel();
        this.minas = setLabel(this.minas, "Minas:  " + Integer.toString(modeloTablero.minasRestantes()));
        this.modo = setLabel(this.modo, "Modo:  " + modeloTablero.getModo());
        this.timer = setLabel(this.timer, "Tiempo:  " + modeloTablero.getTimer());

        this.add(this.minas, BorderLayout.WEST);
        this.add(this.modo, BorderLayout.EAST);
        this.add(this.timer, BorderLayout.CENTER);
        this.add(reiniciarBoton(), BorderLayout.NORTH);
        this.casilla = new VistaCasillas[modeloTablero.getAltura()][modeloTablero.getAncho()];
        this.ModeloTablero.addObserver(this);

        this.vista.setLayout(new GridLayout(modeloTablero.getAltura(), modeloTablero.getAncho()));
        crearBoton();
        this.add(vista, BorderLayout.SOUTH);
    }

    /**
     * actualizar la vista
     */
    @Override
    public void update(Observable obs, Object o) {
        // TODO Auto-generated method

        // si el objeto es vacio, actualiza todas
        if (o != null) {
            actualizarBotones();
        }
        this.minas = setLabel(this.minas, "Minas:  " + Integer.toString(ModeloTablero.minasRestantes()));
        this.modo = setLabel(this.modo, "Modo:  " + ModeloTablero.getModo());
        this.timer = setLabel(this.timer, "Tiempo: " + ModeloTablero.getTimer());

        if (this.ModeloTablero.getModo().equalsIgnoreCase("has perdido") && !this.hasPerdido) {
            this.hasPerdido = true;
            JOptionPane.showMessageDialog(this, "Has perdido");
        }
    }

    /**
     * @param label
     * @param string establece el texto
     * @return devuelve label con el string
     */
    private JLabel setLabel(JLabel label, String string) {
        if (!(label instanceof JLabel)) {
            label = new JLabel("");
        }
        label.setText(string);
        label.setPreferredSize(new Dimension(100, 40));
        label.setHorizontalAlignment(SwingConstants.CENTER);
        return label;

    }

    /**
     * boton restart
     *
     * @return JButton
     */
    public JButton reiniciarBoton() {
        JButton button = new JButton("Reiniciar Partida");
        button.setPreferredSize(new Dimension(20, 40));
        Controlador controller = new Controlador(ModeloTablero);
        button.addMouseListener(controller);
        return button;

    }

    /**
     * update botones
     */
    public void actualizarBotones() {

        eliminarBoton();

        crearBoton();
    }

    /**
     * elimina botones
     */
    private void eliminarBoton() {
        for (int i = 0; i < this.ModeloTablero.getAltura(); i++) {
            for (int j = 0; j < this.ModeloTablero.getAncho(); j++) {
                this.vista.remove(casilla[i][j].getBoton());
            }
        }
    }

    /**
     * crea botones
     */
    private void crearBoton() {

        for (int i = 0; i < this.ModeloTablero.getAltura(); i++) {
            for (int j = 0; j < this.ModeloTablero.getAncho(); j++) {
                VistaCasillas button = new VistaCasillas(this.ModeloTablero.getCasilla(i, j));
                casilla[i][j] = button;
                this.vista.add(button.getBoton());

            }

        }
    }
}
