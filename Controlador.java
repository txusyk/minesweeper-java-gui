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

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

/**
 * Created by josu on 5/3/16.
 */
public class Controlador extends MouseAdapter {

    private ModeloCasilla casilla;
    private ModeloTablero tablero;

    public Controlador(ModeloCasilla pCasilla){
        this.casilla = pCasilla;
    }

    public void actualizarCambiosCasilla(ModeloCasilla pCasilla){
        this.casilla = pCasilla;
    }

    public Controlador(ModeloTablero pTablero){
        this.tablero = pTablero;
    }

    public void clickDeRaton(MouseEvent e){
        if (e.getButton() == MouseEvent.BUTTON1){
            if (this.tablero == null){
                if (!this.casilla.getSiEstaMarcada()){
                    this.casilla.revelarCasilla();
                }
            }else{
                this.tablero.inicializacion();
            }
        }else if (e.getButton() == MouseEvent.BUTTON3){
            if (this.tablero == null){
                this.casilla.marcarCasilla();
            }
        }
    }

}
