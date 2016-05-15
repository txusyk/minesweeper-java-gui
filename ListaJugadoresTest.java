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

/**
 * @author Josu Alvarez <jalvarez041.ehu.eus>
 */
public class ListaJugadoresTest extends ListaJugadores {

    @org.testng.annotations.Test
    public void testGetLjugadores() throws Exception {
        System.out.println("Probamos a llamar a getListaJugadores()->getLJugadores(). Nos aseguramos de que no es null");
        Assert.assertNotNull(ListaJugadores.getMiListaJugadores().getLjugadores());
    }

    @org.testng.annotations.Test
    public void testGetMiListaJugadores() throws Exception {
        System.out.println("Probamos a llamar a getListaJugadores(). Nos aseguramos de que no es null");
        Assert.assertNotNull(ListaJugadores.getMiListaJugadores());

    }

    @org.testng.annotations.Test
    public void testAnadirJugador() throws Exception {
        System.out.println("Añadimos un jugador que no esta previamente");
        Jugador j1 = new Jugador("NombrePrueba", "1234".toCharArray());
        Assert.assertTrue(ListaJugadores.getMiListaJugadores().anadirJugador(j1));
        System.out.println("Probamos a añadir a un usuario existente");
        Assert.assertFalse(ListaJugadores.getMiListaJugadores().anadirJugador(j1));
    }

    @org.testng.annotations.Test
    public void testGetJugador() throws Exception {
        System.out.println("Buscamos a un jugador que no existe");
        Assert.assertNull(ListaJugadores.getMiListaJugadores().getJugador("NombrePrueba2"));
        System.out.println("Buscamos a un jugador que si existe");
        Jugador j1 = new Jugador("NombrePrueba", "1234".toCharArray());
        ListaJugadores.getMiListaJugadores().anadirJugador(j1);
        Assert.assertNotNull(ListaJugadores.getMiListaJugadores().getJugador(j1.getNombreJugador()));
    }


    @org.testng.annotations.Test
    public void testEliminarJugador() throws Exception {
        System.out.println("Eliminamos a un jugador que existe");
        Jugador j1 = new Jugador("NombrePrueba", "1234".toCharArray());
        ListaJugadores.getMiListaJugadores().anadirJugador(j1);
        System.out.println("Primero probamos que existe");
        Assert.assertNotNull(ListaJugadores.getMiListaJugadores().getJugador(j1.getNombreJugador()));
        ListaJugadores.getMiListaJugadores().eliminarJugador(j1);
        Assert.assertNull(ListaJugadores.getMiListaJugadores().getJugador(j1.getNombreJugador()));
        System.out.println("Tratamos de eliminar un jugador que no existe");
        ListaJugadores.getMiListaJugadores().eliminarJugador(j1);
        Assert.assertNull(ListaJugadores.getMiListaJugadores().getJugador(j1.getNombreJugador()));
    }

    @org.testng.annotations.Test
    public void testComprobarContrasena() throws Exception {
        System.out.println("Comprobamos si detecta una contraseña y usuario validos");
        Jugador j1 = new Jugador("NombrePrueba", "1234".toCharArray());
        ListaJugadores.getMiListaJugadores().anadirJugador(j1);
        Assert.assertTrue(ListaJugadores.getMiListaJugadores().comprobarContrasena(j1.getNombreJugador(), j1.getContrasena()));

        System.out.println("Comprobamos si detecta un usuario existente, contraseña erronea");
        Assert.assertFalse(ListaJugadores.getMiListaJugadores().comprobarContrasena("jugadorPrueba2", j1.getContrasena()));

        System.out.println("Comprobamos si detecta un usuario no existente, contraseña verdadera");
        Assert.assertFalse(ListaJugadores.getMiListaJugadores().comprobarContrasena("jugadorPrueba2", "1234".toCharArray()));
    }


}