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

import java.awt.*;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JButton;

/**
 * @author Josu Alvarez <jalvarez041.ehu.eus>
 */
public class CasillaGraficaPrueba implements ActionListener {

    private JButton boton;
    private TableroPruebas tablero;
    private int valor;
    private int id;
    private boolean clickada;


    public CasillaGraficaPrueba(TableroPruebas pTablero) {
        boton = new JButton();
        boton.addActionListener(this);
        boton.setPreferredSize(new Dimension(20, 20));
        boton.setMargin(new Insets(0, 0, 0, 0));
        this.tablero = pTablero;
        clickada = false;
    }

    public JButton getBoton() {
        return this.boton;
    }

    public int getValor() {
        return this.valor;
    }

    public int getId() {
        return this.id;
    }

    public void setId(int pId) {
        this.id = pId;
    }

    public void setValor(int pValor) {
        this.valor = pValor;
    }

    public void mostrarValor() {
        if (valor == -1) { //en caso de ser mina
            boton.setText("\u2600");
            boton.setBackground(Color.red);
        } else if (valor != 0) { //en caso de ser una casilla numerica
            boton.setText(String.valueOf(valor));
        }
    }

    public void clickarCasilla() {
        boton.setEnabled(false);
        this.mostrarValor();
        this.clickada = true;
        if (this.valor == 0) {
            this.tablero.buscarCasillasVacias();
        }
        if (this.valor == -1) {
            this.tablero.fallo();
        }
    }

    public void incrementarValor() {
        this.valor++;
    }

    public boolean estaClickado() {
        return this.clickada;
    }

    public void revelar() {
        this.mostrarValor();
        boton.setEnabled(false);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        this.clickarCasilla();
    }

}
