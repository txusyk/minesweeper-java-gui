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
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

/**
 * Created by josu on 5/11/16.
 */
public class JugadorTest{

    private Jugador j1,j2;

    @BeforeClass
    public void setUp() throws Exception {
        System.out.println("@BeforeTest - Se crean dos jugadores, uno con una partida y el otro con ninguna");
        j1 = new Jugador("Prueba","1234");
        j1.getListaPartidas().anadirPartida(new Partida(30,"facil"));
        j2 = new Jugador("Prueba2","4321");
    }

    @AfterMethod
    public void tearDown() throws Exception {
        j1 = null;
        j2 = null;
    }

    @Test
    public void testGetListaPartidas() throws Exception {
        System.out.println("Probamos a obtener la lista de un jugador existente y con lista de partidas");
        Assert.assertNotNull(j1.getListaPartidas());
        Assert.assertEquals(true, j1.getListaPartidas().esta(new Partida(30, "facil")));
        System.out.println("Probamos a obtener la lista de un jugadoor existente, sin partidas");
        Assert.assertNotNull(j2.getListaPartidas());
        System.out.println("Pribamos a obtener la lista de un jugador inexistente, sin partidas");
        Assert.assertNotNull(ListaJugadores.getMiListaJugadores().getJugador("Prueba3").getListaPartidas());
    }

    @Test
    public void testSetNombreJugador() throws Exception {
        System.out.println("Probamos a cambiar el nombre al jugador 2. Que se llama Prueba2");
        j2.setNombreJugador("Prueba4");
        Assert.assertEquals("Prueba4",j2.getNombreJugador());
    }

    @Test
    public void testSetPasswd() throws Exception {
        System.out.println("Probamos a cambiar la passwd al jugador 2. Que tiene 4321");
        j2.setPasswd("4321");
        Assert.assertEquals("4321",j2.getContrasena());
    }

    @Test
    public void testGetNombreJugador() throws Exception {
        System.out.println("Probamos el nombre del j1. Deberia de ser Prueba");
        Assert.assertEquals("Prueba",j1.getNombreJugador());
    }

    @Test
    public void testGetContrasena() throws Exception {
        System.out.println("Probamos la passwd del j1. Deberia de ser 1234");
        Assert.assertEquals("1234",j1.getContrasena());
    }

    @Test
    public void testComprobarPasswd() throws Exception {
        System.out.println("Probamos si es capaz de decirnos si la passwd esta bien");
        System.out.println("Probamos pasandole la passwd correcta");
        Assert.assertTrue(j1.comprobarPasswd("1234"));
        System.out.println("Probamos pasandole la passwd incorrecta");
        Assert.assertTrue(j1.comprobarPasswd("4321"));
    }
}