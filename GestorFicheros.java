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

import java.awt.image.FilteredImageSource;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Map;
import java.util.Scanner;

/**
 * Created by josu on 4/18/16.
 */
public class GestorFicheros {

    private static GestorFicheros miGestorFicheros;

    /**
     * @return Devuelve un elemento de tipo CargarFicheros siempre inicializado
     */
    public static GestorFicheros getMiCargarFicheros(){
        if ((miGestorFicheros) == null){
            miGestorFicheros = new GestorFicheros();
        }
        return miGestorFicheros;
    }

    /**
     * Cargamos el fichero que contiene los datos de los jugadores
     * @param pFichero
     */
    public void cargarFicheroJug(FileReader pFichero){
        Scanner sc = new Scanner(pFichero);
        String arrayElementos[];

        while(sc.hasNext()){
            String linea1 = sc.nextLine();
            String linea2;
            if (linea1.equals("Jugador"));{
                linea2 = sc.nextLine();
                arrayElementos = linea2.split(",");
                String nombreJug = arrayElementos[0];
                String contraseñaJug = arrayElementos[1];
                ListaJugadores.getMiListaJugadores().anadirJugador(new Jugador(nombreJug,contraseñaJug));
            }
            if(linea1.equals("Partida")){
                linea2 = sc.nextLine();
                arrayElementos = linea2.split(",");
                String nomJugador = arrayElementos[0];
                int segundos = Integer.parseInt(arrayElementos[1]);
                String dificultad = arrayElementos[2];
                if (ListaJugadores.getMiListaJugadores().getJugador(nomJugador) != null){
                    ListaJugadores.getMiListaJugadores().getJugador(nomJugador).getListaPartidas().anadirPartida(new Partida(segundos,dificultad));
                }
            }
        }
    }


    @SuppressWarnings("rawtypes")
    public void exportarAFichero() {
        ArrayList<Jugador> auxArray = new ArrayList<Jugador>(ListaJugadores.getMiListaJugadores().getLjugadores().values());

        FileWriter fichero = null;
        PrintWriter pw = null;

        Iterator<Jugador> it = auxArray.iterator();

        try{
            String directorio = System.getProperty("user.dir");//cogemos variable entorno
            fichero = new FileWriter(directorio+"/DatosBuscaminas.txt");
            pw = new PrintWriter(fichero);

            while (it.hasNext()) {
                Jugador auxJug = it.next();
                pw.println("Jugador");
                pw.println(auxJug.getNombreJugador()+","+auxJug.getContrasena());
                Iterator<Partida> itPartidas = auxJug.getListaPartidas().getIterador();
                while (itPartidas.hasNext()){
                    Partida auxPartida = itPartidas.next();
                    pw.println("Partida");
                    pw.println(auxPartida.getSegundos()+","+auxPartida.getDificultad());
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                // Nuevamente aprovechamos el finally para
                // asegurarnos que se cierra el fichero.
                if (null != fichero)
                    fichero.close();
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }
    }
}
