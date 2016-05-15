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
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.io.FileReader;

/**
 * Created by josu on 5/15/16.
 */
public class GestorFicherosTest{

    FileReader fr;

    @BeforeMethod
    public void setUp() throws Exception {
        fr = new FileReader("/home/josu/Documentos/IntelliJ Projects/Buscaminas/src/Usuarios.txt");
    }

    @AfterMethod
    public void tearDown() throws Exception {

    }

    @Test
    public void testGetMiCargarFicheros() throws Exception {
        System.out.println("Tratamos de acceder al objeto *miCargarFichero*");
        Assert.assertNotNull(GestorFicheros.getMiCargarFicheros());
    }

    @Test
    public void testCargarFicheroJug() throws Exception {
        System.out.println("Tratamos de cargar un fichero de prueba e imprimir la informacion almacenada");
        GestorFicheros.getMiCargarFicheros().cargarFicheroJug(fr);
        System.out.println("El nombre del jugador guardado es: "+ListaJugadores.getMiListaJugadores().getJugador("Josu").getNombreJugador());
        Assert.assertEquals("Josu",ListaJugadores.getMiListaJugadores().getJugador("Josu"));
        System.out.println("Su contraseña es: "+ListaJugadores.getMiListaJugadores().getJugador("Josu").getContrasena());
        Assert.assertEquals("1234",ListaJugadores.getMiListaJugadores().getJugador("David"));
        System.out.println("Probamos a buscar a un jugador inexistente");
        Assert.assertNull(ListaJugadores.getMiListaJugadores().getJugador("Paco"));
        System.out.println("Probamos a acceder a las partidas de *Josu*");
        ListaJugadores.getMiListaJugadores().getJugador("Josu").getListaPartidas().imprimirPartidas();

    }

    @Test
    public void testExportarAFichero() throws Exception {

    }

}