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

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Scanner;

/**
 * Created by josu on 4/18/16.
 */
public class GestorFicheros {

    private static GestorFicheros miGestorFicheros;

    /**
     * @return Devuelve un elemento de tipo CargarFicheros siempre inicializado
     */
    public static GestorFicheros getMiCargarFicheros() {
        if ((miGestorFicheros) == null) {
            miGestorFicheros = new GestorFicheros();
        }
        return miGestorFicheros;
    }

    /**
     * Cargamos el fichero que contiene los datos de los jugadores
     *
     * @param pFichero
     */
    public void cargarFicheroJug(FileReader pFichero) {
        Scanner sc = new Scanner(pFichero);
        String arrayElementos[];
        String nombreJug = "";

        while (sc.hasNext()) {
            String linea1 = sc.nextLine();

            if (linea1.equalsIgnoreCase("jugador")) {
                linea1 = sc.nextLine();
                arrayElementos = linea1.split(",");

                nombreJug = arrayElementos[0];
                String auxContrasena = arrayElementos[1];
                char[] contrasena = auxContrasena.toCharArray();
                ListaJugadores.getMiListaJugadores().anadirJugador(new Jugador(nombreJug, contrasena));
            } else {
                linea1 = sc.nextLine();
                arrayElementos = linea1.split(",");
                int tiempo = Integer.parseInt(arrayElementos[0]);
                String dif = arrayElementos[1];
                Partida auxPartida = new Partida(tiempo, dif);
                ListaJugadores.getMiListaJugadores().getJugador(nombreJug).getListaPartidas().anadirPartida(auxPartida);
            }
        }
        sc.close();
    }

    public void cargarFichJugXML(){

        try{
            File auxXML = new File("/home/josu/Documentos/IntelliJ Projects/Buscaminas/src/Usuarios.xml");
            DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder dbBuilder = dbFactory.newDocumentBuilder();
            Document doc = dbBuilder.parse(auxXML);

            doc.getDocumentElement().normalize();

            NodeList nList = doc.getElementsByTagName("Jugador");
            NodeList nListPartidas = doc.getElementsByTagName("partida");

            for(int i=0; i<nList.getLength(); i++){
                Node nNode = nList.item(i);
                if (nNode.getNodeType() == Node.ELEMENT_NODE){
                    Element auxElement = (Element) nNode;

                    String auxNombre = auxElement.getElementsByTagName("nombre").item(0).getTextContent();
                    char[] auxPassw = auxElement.getElementsByTagName("passw").item(0).getTextContent().toCharArray();
                    Jugador auxJug = new Jugador(auxNombre,auxPassw);

                    ListaJugadores.getMiListaJugadores().anadirJugador(auxJug);
                }
            }

            for (int i=0;i<nListPartidas.getLength(); i++){
                Node nNodePartida = nListPartidas.item(i);
                if (nNodePartida.getNodeType() == Node.ELEMENT_NODE) {
                    Element auxElement = (Element) nNodePartida;

                    String auxNombreJug = auxElement.getElementsByTagName("nombre").item(0).getTextContent();
                    int tiempo = Integer.parseInt(auxElement.getElementsByTagName("tiempo").item(0).getTextContent());
                    String dif = auxElement.getElementsByTagName("dif").item(0).getTextContent();

                    Partida auxPartida = new Partida(tiempo,dif);
                    Jugador auxJug = ListaJugadores.getMiListaJugadores().getJugador(auxNombreJug);

                    auxJug.getListaPartidas().anadirPartida(auxPartida);
                }

            }

        }catch (Exception e){
            e.printStackTrace();
        }
    }

    @SuppressWarnings("rawtypes")
    public void exportarAFichero() {
        ArrayList<Jugador> auxArray = new ArrayList<Jugador>(ListaJugadores.getMiListaJugadores().getLjugadores().values());

        FileWriter fichero = null;
        PrintWriter pw = null;

        Iterator<Jugador> it = auxArray.iterator();

        try {
            String directorio = System.getProperty("user.dir");//cogemos variable entorno
            fichero = new FileWriter(directorio + "/DatosBuscaminas.txt");
            pw = new PrintWriter(fichero);

            while (it.hasNext()) {
                Jugador auxJug = it.next();
                pw.println("Jugador");
                pw.println(auxJug.getNombreJugador() + "," + auxJug.getContrasena());
                Iterator<Partida> itPartidas = auxJug.getListaPartidas().getIterador();
                while (itPartidas.hasNext()) {
                    Partida auxPartida = itPartidas.next();
                    pw.println("Partida");
                    pw.println(auxPartida.getSegundos() + "," + auxPartida.getDificultad());
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
