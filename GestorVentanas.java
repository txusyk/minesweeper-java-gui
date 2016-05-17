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
import java.awt.event.ActionEvent;
import java.io.FileNotFoundException;
import java.io.FileReader;

/**
 * Created by josu on 5/16/16.
 */
public class GestorVentanas extends JFrame {

    JFrame frame;
    MenuLogin login = null;
    ModeloTablero tablero = null;
    VistaBuscaminas vistaTablero;

    Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();         //En dim guardamos el tamaño de la pantalla donde se esta ejecutando el programa

    JMenuBar menuBar;
    JMenu menuArchivo, menuAyuda, menuJuego;
    JMenuItem itemNuevo, itemSalir, itemFaq, itemAcercaDe,itemTop10,itemEliminarJugador;
    String dif = "facil";
    int x = 9;
    int y = 9;
    int numMinas = 9;

    private static GestorVentanas miGestorVentanas;

    private GestorVentanas(){
        menuBar = new JMenuBar();
        menuArchivo = new JMenu("Archivo");
        menuAyuda = new JMenu("Ayuda");
        menuJuego = new JMenu("Jugadores");

        itemNuevo = new JMenuItem("Reiniciar");
        itemNuevo.addActionListener(evt -> itemNuevoMouseClicked(evt));
        itemNuevo.setActionCommand("reiniciar");

        itemSalir = new JMenuItem("Salir");
        itemSalir.addActionListener(evt -> itemSalirMouseClicked(evt));
        itemSalir.setActionCommand("salir");

        itemFaq = new JMenuItem("FAQ");
        itemFaq.addActionListener(evt -> itemFaqMouseClicked(evt));
        itemFaq.setActionCommand("faq");

        itemAcercaDe = new JMenuItem("Acerca de");
        itemAcercaDe.addActionListener(evt -> itemAcercaDeMouseClicked(evt));
        itemAcercaDe.setActionCommand("acercade");

        itemTop10 = new JMenuItem("Top 10/ Ranking");
        itemTop10.addActionListener(evt -> itemTop10MouseClicked(evt));
        itemTop10.setActionCommand("top10");

        itemEliminarJugador = new JMenuItem("Eliminar Jugador");
        itemEliminarJugador.addActionListener(evt -> itemEliminarJugadorMouseClicked(evt));
        itemEliminarJugador.setActionCommand("eliminar");

        menuJuego.add(itemTop10);
        menuJuego.add(itemEliminarJugador);
        menuAyuda.add(itemAcercaDe);
        menuAyuda.add(itemFaq);
        menuArchivo.add(itemNuevo);
        menuArchivo.add(itemSalir);

        menuBar.add(menuArchivo);
        menuBar.add(menuAyuda);
        menuBar.add(menuJuego);

        this.setIconImage(new ImageIcon(getClass().getResource("icono.png")).getImage());
        frame = new JFrame("Buscaminas");
        frame.setJMenuBar(menuBar); //fijamos como barra de menu la barra que hemos creado
    }

    public static GestorVentanas getMiGestorVentanas(){
        if (miGestorVentanas == null){
            miGestorVentanas = new GestorVentanas();
        }
        return miGestorVentanas;
    }

    public void cargarFicheros(){
        String cargaDeFicheros = JOptionPane.showInputDialog("Introduzca XML o CSV para elegir el tipo de fichero de origen/destino");

        while (!cargaDeFicheros.equalsIgnoreCase("XML") && !cargaDeFicheros.equalsIgnoreCase("CSV")){
            cargaDeFicheros = JOptionPane.showInputDialog("Introduzca XML o CSV para elegir el tipo de fichero de origen/destino");
        }
        if (cargaDeFicheros.equalsIgnoreCase("XML")){
            GestorFicheros.getMiCargarFicheros().cargarFichJugXML();
        }
        else{
            //Creamos la lista de jugadores desde el fichero
            FileReader fr = null;
            try {
                fr = new FileReader("/home/josu/Documentos/IntelliJ Projects/Buscaminas/src/Usuarios.txt");
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            }
            GestorFicheros.getMiCargarFicheros().cargarFicheroJug(fr); //cargamos la lista de jugadores y
        }
    }


    public void lanzarVentanaLogin(){
        this.cargarFicheros();

        login = new MenuLogin();
        frame.setContentPane(login); //Llamamos al menu de logIn
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); //fijamos que la operacion por defecto al cerrar es salir
        frame.pack(); //    hacemos que la ventana se ajuste al tamaño del contenido
        frame.setLocation(dim.width / 2 - frame.getSize().width / 2, dim.height / 2 - frame.getSize().height / 2);         //Fijamos por defecto que la ventana siempre aparezca en el centro
        frame.setVisible(true); //hacemos el frame visible
        frame.setResizable(false); //definimos que no podra modificar el tamaño de la ventana de nuestro programa
        frame.setAlwaysOnTop(true); //definimos que mientras este ejcutandose se superponga a cualquier otro programa
    }

    private void esperarCierreVentana(JPanel pPanel){
        do {
            try {
                Thread.sleep(100);  //pausamos el hilo 100ms
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        } while (pPanel.isShowing()); //mientras la ventana de login siga activa
    }

    public void lanzarVentanaBuscaminas(){
        if (login != null){
            this.esperarCierreVentana(login);
            this.hallarMedidasTablero();
            tablero = new ModeloTablero(x, y, numMinas);
            vistaTablero = new VistaBuscaminas(tablero);
            frame.setContentPane(vistaTablero); //metemos como contenedor la vista
            frame.pack(); //    hacemos que la ventana se ajuste al tamaño del contenido//creamos una vista que contendra el modelo del tablero
            vistaTablero.setVisible(true); //hacemos visible la vistaTablero
            frame.repaint(); //redibujamos los graficos en la ventana

            frame.setLocation(dim.width / 2 - frame.getSize().width / 2, dim.height / 2 - frame.getSize().height / 2);
        }

    }

    private void itemSalirMouseClicked(ActionEvent evt){
        if (evt.getActionCommand().equalsIgnoreCase("salir")) {
            frame.setVisible(false); //you can't see me!
            frame.dispose(); //Destroy the JFrame object.
            System.exit(0);
        }
    }

    private void itemNuevoMouseClicked(ActionEvent evt){
        if (evt.getActionCommand().equalsIgnoreCase("reiniciar")){
            if (frame.isShowing()){
                if (!login.isShowing()) {
                    vistaTablero.setVisible(false);
                    lanzarVentanaBuscaminas();
                }
                else{
                    JOptionPane.showMessageDialog(login, "No se puede reiniciar sin comenzar una partida");
                }
            }

        }
    }

    private void itemFaqMouseClicked(ActionEvent evt){
        if (evt.getActionCommand().equalsIgnoreCase("faq")){
            JOptionPane.showMessageDialog(frame.getContentPane(), "Aqui mostraremos informacion sobre las preguntas frecuentes del juego", "FAQ",JOptionPane.INFORMATION_MESSAGE);
        }
    }

    private void itemAcercaDeMouseClicked(ActionEvent evt){
        if (evt.getActionCommand().equalsIgnoreCase("acercade")){
            JOptionPane.showMessageDialog(frame.getContentPane(), "El juego ha sido desarrollado por Josu Alvarez y David Max. Siendo el Buscaminas el proyecto seleccionado: Asignatura IS-2016, Centro: EUITI, Universidad: UPV/EHU", "Acerca de", JOptionPane.INFORMATION_MESSAGE);
        }
    }

    private void itemTop10MouseClicked(ActionEvent evt) {
        if (evt.getActionCommand().equalsIgnoreCase("top10")) {
            //if (frame.getContentPane() != login) {
            if (JOptionPane.showConfirmDialog(frame.getContentPane(), "Si continuas se mostrara el Ranking y perderas el progreso. ¿Estas seguro?", "Aviso", JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION){
                frame.setVisible(false);
                JFrame frameRanking = VistaRanking.getMiVistaRanking();
                frameRanking.pack(); //    hacemos que la ventana se ajuste al tamaño del contenido//creamos una vista que contendra el modelo del tablero
                frameRanking.setVisible(true); //hacemos visible la vistaTablero
                frameRanking.repaint(); //redibujamos los graficos en la ventana

                frameRanking.setLocation(dim.width / 2 - frameRanking.getSize().width / 2, dim.height / 2 - frameRanking.getSize().height / 2);
            }

            //}
        }
    }

    private void itemEliminarJugadorMouseClicked(ActionEvent evt){
        if (evt.getActionCommand().equalsIgnoreCase("eliminar")){
        }
    }

    private void hallarMedidasTablero(){
        dif = login.getDificultad_juego(); //guardamos en dif el valor de la dificultad

        //fijamos las medidas y el numero de bombas del tablero en base a la dificultad
        switch (dif.toLowerCase()) {
            case "facil":
                x = 7;
                y = 10;
                numMinas = y;
                break;
            case "medio":
                x = 10;
                y = 15;
                numMinas = y * 2;
                break;
            case "dificil":
                x = 12;
                y = 25;
                numMinas = y * 3;
                break;
            default:
                break;
        }
    }


}
