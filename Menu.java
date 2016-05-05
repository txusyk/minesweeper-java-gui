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

import javafx.scene.control.*;
import javafx.scene.control.Label;

import javax.swing.*;
import java.awt.*;
import java.awt.Button;

/**
 * Created by josu on 4/16/16.
 */
public class Menu extends JFrame{

    public Menu(){
        //creamos los paneles que seran necesarios
        JPanel menu_datos_partida = new JPanel(new BorderLayout());
        JPanel panel_logIn = new JPanel(new GridLayout(2,2));
        JPanel panel_botones = new JPanel(new GridLayout(1,3));
        JPanel miMenu = new JPanel(new BorderLayout());

        //Creamos la barra de menu (de la ventana)
        JMenuBar barra_menu = new JMenuBar(); //Creamos una barra de menu
        //Creamos dos botones para el  menu
        JMenu menu_archivo = new JMenu("Archivo");
        JMenu menu_ayuda = new JMenu("Ayuda");
        //Creamos los items que contendran cada uno de los botones anteriores
        //boton de archivo
        JMenuItem nuevaPartida = new JMenuItem("Nueva partida");
        JMenuItem ranking = new JMenuItem("Ranking de mejores jugadores");
        JMenuItem salir = new JMenuItem("Salir");
        //boton de ayuda
        JMenuItem FAQ = new JMenuItem("FAQ");
        JMenuItem acercaDe = new JMenuItem("Acerca de");
        //añadimos los botones al menu
        //añadimos los botones al menu->Archivo
        menu_archivo.add(nuevaPartida);
        menu_archivo.add(ranking);
        menu_archivo.add(salir);
        //añadimos los botones al menu->Ayuda
        menu_ayuda.add(FAQ);
        menu_ayuda.add(acercaDe);

        //Añadimos a la barra_menu los menus de "archivo" y "ayuda"
        barra_menu.add(menu_archivo);
        barra_menu.add(menu_ayuda);

        //Creamos botones de unica seleccion
        JRadioButton boton_facil = new JRadioButton("Facil");
        boton_facil.setSelected(true); //Establecemos que por defecto este seleccionado
        JRadioButton boton_medio = new JRadioButton("Medio");
        JRadioButton boton_dificil = new JRadioButton("Dificil");
        //establecemos que la accion que devolvera sea respectiva al nivel de dificultad
        boton_facil.setActionCommand("facil");
        boton_medio.setActionCommand("medio");
        boton_dificil.setActionCommand("dificil");

        //Cremos un grupo que contendra botones
        ButtonGroup grupoBotonesDif = new ButtonGroup();
        //Añadimos los botones creados al grupo de botones
        grupoBotonesDif.add(boton_facil);
        grupoBotonesDif.add(boton_medio);
        grupoBotonesDif.add(boton_dificil);

        //añadimos los botones al panel_botones
        panel_botones.add(boton_facil);
        panel_botones.add(boton_medio);
        panel_botones.add(boton_dificil);
        
        //creamos los botones para el login
        JLabel petUsuario = new JLabel("Usuario");
        JTextField nomUsuario = new JTextField("Nombre");
        JLabel petContraseña = new JLabel("Contraseña");
        JTextField contraseña = new JTextField("Password");
        JButton botonNuevoUsuario = new JButton("Nuevo Usuario");
        JButton botonLogIn = new JButton("Log In");

        panel_logIn.add(petUsuario);
        panel_logIn.add(nomUsuario);
        //panel_logIn.add(botonNuevoUsuario);
        panel_logIn.add(petContraseña);
        panel_logIn.add(contraseña);
        //panel_logIn.add(botonLogIn);

        JPanel panel_botonesLogin = new JPanel(new GridLayout(1,2));
        panel_botonesLogin.add(botonNuevoUsuario);
        panel_botonesLogin.add(botonLogIn);

        menu_datos_partida.add(panel_botones, BorderLayout.NORTH); //En el norte del menu_datos_partida guardaremos el panel_botones
        menu_datos_partida.add(panel_botonesLogin,BorderLayout.CENTER);
        menu_datos_partida.add(panel_logIn, BorderLayout.SOUTH);
        
        miMenu.add(new JLabel("Seleccione un nivel de dificultad:\n"),BorderLayout.NORTH); //en el norte de miMenu ponemos un label
        miMenu.add(menu_datos_partida,BorderLayout.CENTER); // En el centro de miMenu, estara el menu_datos_partida


        this.add(barra_menu,BorderLayout.NORTH); //En el norte de la ventana estara la barra de menu
        this.add(miMenu,BorderLayout.CENTER); //En el centro de la ventana, estara miMenu


        this.setVisible(true);
    }

    public static void main(String args[ ]) {
        Frame frame = new Buscaminas();
        frame.setLocation(400,300);
        frame.setVisible(true);
        frame.setResizable(false);

        /*Frame frame1 = new Menu();
        frame.setLocation(400,300);
        frame1.setPreferredSize(new Dimension(300,300));
        frame1.setBounds(400,300,400,300);
        frame1.setVisible(false);

        Frame frame2 = new  Ranking();
        frame.setLocation(400,300);
        frame2.setPreferredSize(new Dimension(300,300));
        frame2.setBounds(350,150,600,450);
        frame2.setVisible(false);*/
    }


}
