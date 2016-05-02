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

import javafx.beans.value.ChangeListener;

import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.border.LineBorder;
import javax.swing.event.ChangeEvent;
import java.awt.*;

/**
 * Created by josu on 4/16/16.
 */



public class Buscaminas extends JFrame{

    public Buscaminas() {
        super("Buscaminas"); //Fijamos el nombre de la ventana

        JMenuBar barra_menu = new JMenuBar(); //Creamos una barra de menu
        JMenu menu_archivo = new JMenu("Archivo");
        JMenu menu_ayuda = new JMenu("Ayuda");
        JMenuItem nuevaPartida = new JMenuItem("Nueva partida");
        JMenuItem ranking = new JMenuItem("Ranking de mejores jugadores");
        JMenuItem salir = new JMenuItem("Salir");
        JMenuItem FAQ = new JMenuItem("FAQ");
        JMenuItem acercaDe = new JMenuItem("Acerca de");

        menu_archivo.add(nuevaPartida);
        menu_archivo.add(ranking);
        menu_archivo.add(salir);
        menu_ayuda.add(FAQ);
        menu_ayuda.add(acercaDe);

        barra_menu.add(menu_archivo);
        barra_menu.add(menu_ayuda);

        barra_menu.setVisible(true);

        this.setLayout(new BorderLayout()); //A la ventana le fijamos un BorderLayout

        JPanel panelAuxNorte = new JPanel(new BorderLayout());
        this.add(panelAuxNorte, BorderLayout.NORTH);
        panelAuxNorte.add(barra_menu, BorderLayout.NORTH);

        JPanel panel_info = new JPanel(new FlowLayout()); //Creamos otro panel con un FlowLayout
        panel_info.add(new JLabel("Minas")); //Le añadimos una etiqueta al panel
        panel_info.add(new TextField("0")); //añadimos el contador de minas
        //this.add(panel_info,BorderLayout.NORTH); //añadimos el panel a la ventana
        panelAuxNorte.add(panel_info, BorderLayout.SOUTH);
        panel_info.setVisible(true); //lo hacemos visible

        JPanel miPanel = new JPanel(new GridLayout(10,10)); // Creamos un panel para
        //el juego con un Layaout de X e Y
        for(int i=0; i<10; i++){
            for(int j=0; j<10 ; j++){
                JButton boton = new JButton();
                boton.setVisible(true);
                //boton.setForeground(new Color(0, 135, 200).brighter());
                boton.setForeground(Color.BLACK);
                boton.setHorizontalTextPosition(SwingConstants.CENTER);
                boton.setBorder(new LineBorder(Color.WHITE));
                boton.setFocusPainted(false);
                boton.setBackground(new Color(3, 59, 90));
                //boton.setBackground(Color.LIGHT_GRAY);
                boton.setPreferredSize(new Dimension(50,50));
                miPanel.add(boton);
            }
        }
        this.add(miPanel, BorderLayout.CENTER);
        miPanel.setVisible(true);
        this.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
        pack();
    }
}
