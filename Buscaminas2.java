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
import java.io.IOException;
import java.util.Scanner;

/**
 * Created by josu on 5/5/16.
 */
public class Buscaminas2 {

    public static void main(String[] argv) throws IOException {
        String entrada = "";
        int x=0,y=0,numMinas = 0;

        if (argv.length ==1){
            entrada = argv[0];
        }
        /*if (argv.length == 3){
            x = Integer.parseInt(argv[0]);
            y = Integer.parseInt(argv[1]);
            numMinas = Integer.parseInt(argv[2]);
            entrada = "Personalizado";
        }*/

        @SuppressWarnings("resource")
        Scanner scan = new Scanner(System.in);

        ModeloTablero tablero;

        System.out.println("Versiones: facil / medio / dificil");

        while (!entrada.equalsIgnoreCase("facil") && !entrada.equalsIgnoreCase("medio") && !entrada.equalsIgnoreCase("dificil")) {
            System.out.println("Introduce modo de juego");
            entrada = scan.nextLine();
        }

        switch (entrada.toLowerCase()){
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


        //Information about the game
        System.out.println("\n\nCreating Minesweeper:");
        System.out.println("Heigth: " + x);
        System.out.println("Width: " + y);
        System.out.println("Bombs: " + numMinas);

        //Creating the View
//        VistaBuscaminas view = new VistaBuscaminas(tablero);

        JFrame frame = new JFrame("Minesweeper");

        tablero = new ModeloTablero(x,y,numMinas);

        frame.setContentPane(new VistaBuscaminas(tablero));
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
    }
}
