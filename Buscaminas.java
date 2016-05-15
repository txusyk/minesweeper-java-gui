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
import java.io.FileReader;
import java.io.IOException;

/**
 * @author Josu Alvarez <jalvarez041.ehu.eus>
 */
public class Buscaminas {

    /**
     * Starts Buscaminas
     *
     * @param argv Seleccion de dificultad
     * @throws IOException
     */
    public static void main(String[] argv) throws IOException {

        String input = "facil";
        int x = -1;
        int y = -1;
        int numMinas = -1;

        ModeloTablero model;
        JFrame frame = new JFrame("Buscaminas"); //creamos una ventana que se llamara buscaminas

        //Creamos la lista de jugadores desde el fichero
        FileReader fr = new FileReader("/home/josu/Documentos/IntelliJ Projects/Buscaminas/src/Usuarios.txt");
        GestorFicheros.getMiCargarFicheros().cargarFicheroJug(fr); //cargamos la lista de jugadores y partidas

        MenuLogin login = new MenuLogin();
        frame.setContentPane(login); //Llamamos al menu de logIn

        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); //fijamos que la operacion por defecto al cerrar es salir
        frame.pack(); //    hacemos que la ventana se ajuste al tamaño del contenido
        //En dim guardamos el tamaño de la pantalla donde se esta ejecutando el programa
        Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
        //Con setLocation() fijamos donde aparecera la ventana en nuestro programa. Con esta configuracion, la ventana siempre
        //aparecera en el centro de la pantalla del usuario
        frame.setLocation(dim.width / 2 - frame.getSize().width / 2, dim.height / 2 - frame.getSize().height / 2);
        frame.setVisible(true); //hacemos el frame visible
        frame.setResizable(false); //definimos que no podra modificar el tamaño de la ventana de nuestro programa
        frame.setAlwaysOnTop(true); //definimos que mientras este ejcutandose se superponga a cualquier otro programa


        do {
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        } while (login.isShowing());
        input = login.getDificultad_juego();

        //fijamos las medidas y el numero de bombas del tablero en base a la dificultad
        switch (input.toLowerCase()) {
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

        model = new ModeloTablero(x, y, numMinas);

        VistaBuscaminas view = new VistaBuscaminas(model); //creamos una vista que contendra el modelo del tablero

        frame.setContentPane(view); //metemos como contenedor la vista
        view.setVisible(true);
        frame.repaint();

        frame.pack(); //    hacemos que la ventana se ajuste al tamaño del contenido
        frame.setLocation(dim.width / 2 - frame.getSize().width / 2, dim.height / 2 - frame.getSize().height / 2);
    }
}
