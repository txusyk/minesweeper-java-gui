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

import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.FileReader;

/**
 * Created by josu on 5/15/16.
 */
public class GestorFicherosTest {

    @Test
    public void testGetMiCargarFicheros() throws Exception {
        System.out.println("Tratamos de acceder al objeto *miCargarFichero*");
        Assert.assertNotNull(GestorFicheros.getMiCargarFicheros());
    }

   @Test
    public void testCargarFicheroJug() throws Exception {
        FileReader fr = new FileReader("/home/josu/Documentos/IntelliJ Projects/Buscaminas/src/Usuarios.txt");
        System.out.println("Tratamos de cargar un fichero de prueba e imprimir la informacion almacenada");
        GestorFicheros.getMiCargarFicheros().cargarFicheroJug(fr);

        System.out.println("Tratamos de cargar los jugadores desde un CSV");
        GestorFicheros.getMiCargarFicheros().cargarFicheroJug(fr);

        System.out.println("El nombre del jugador guardado es: " + ListaJugadores.getMiListaJugadores().getJugador("Josu").getNombreJugador());
        System.out.println("Su comtraseña es: "+ListaJugadores.getMiListaJugadores().getJugador("Josu").imprimirPassw());
        System.out.println("Imprimira la lista de partidas cargada desde el CSV: ");
        ListaJugadores.getMiListaJugadores().getJugador("Josu").getListaPartidas().imprimirPartidas();
       System.out.println("------------------------------------------------------");
    }

    @Test
    public void testCargarFicheroJugXML() throws Exception{
        System.out.println("Tratamos de cargar los jugadores desde un XML");
        System.out.println("------------------------------------------------------");
        GestorFicheros.getMiCargarFicheros().cargarFichJugXML();

        System.out.println("El nombre del jugador guardado es: " + ListaJugadores.getMiListaJugadores().getJugador("Josu").getNombreJugador());
        System.out.println("Su comtraseña es: "+ListaJugadores.getMiListaJugadores().getJugador("Josu").imprimirPassw());
        System.out.println("Imprimira la lista de partidas, las anteriores, mas las añadidas desde el XML: ");
        ListaJugadores.getMiListaJugadores().getJugador("Josu").getListaPartidas().imprimirPartidas();
    }

    @Test
    public void testExportarAFichero() throws Exception {

    }

}