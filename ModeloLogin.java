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

import java.util.Observable;

/**
 * Created by josu on 4/18/16.
 */
public class ModeloLogin extends Observable {


    private String valorDificultad;
    private String nombreJug, passwd;
    private boolean LoginCompletado = false;

    public ModeloLogin(String pValorDificultad, String pNombreJug, String pPasswd) {
        this.valorDificultad = pValorDificultad;
        this.nombreJug = pNombreJug;
        this.passwd = pPasswd;
        this.setDificultadPorDefecto();
    }

    /**
     * Inicializamos la dificultad de la botonera en facil
     */
    public void setDificultadPorDefecto() {
        valorDificultad = "facil";
    }




}
