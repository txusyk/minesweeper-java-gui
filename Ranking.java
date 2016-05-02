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

/**
 * Created by josu on 4/16/16.
 */
public class Ranking extends JFrame{

    String nomJug = "JugPrueba";
    String dificultad = "facil";
    int tiempo = 2;

    public Ranking(){
        JPanel miRanking = new JPanel(new GridLayout(10,3));
        for (int i=0; i<10; i++){
            for (int j=0; j<3; j++){
                if (j==0){
                    miRanking.add(new JLabel("Nombre: "+nomJug));
                }
                if (j==1){
                    miRanking.add(new JLabel("Dificultad: "+dificultad));
                }
                if (j==2){
                    miRanking.add(new JLabel("Tiempo: "+tiempo+" min"));
                }
            }
        }
        this.add(miRanking);
        //this.paintAll(this.getGraphics());
        this.setVisible(true);
        this.pack();
    }
}
