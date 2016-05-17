import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static org.testng.Assert.*;

/**
 * Created by portatil on 17/05/16.
 */
public class ListaPartidasTest extends ListaPartidas {

    ListaPartidas lPartidas;
    Partida p1;
    Partida p2;
    Partida p3;
    Partida p4;
    Partida p5;

    @BeforeMethod
    public void setUp() throws Exception {
        lPartidas=new ListaPartidas();
        p1 = new Partida(100, "facil");
        p2 = new Partida(530, "facil");
        p3 = new Partida(333, "medio");
        p4 = new Partida(550, "dificil");
        p5 = new Partida(200, "dificil");
    }

    @AfterMethod
    public void tearDown() throws Exception {

    }

    @Test
    public void testGetlPartidas() throws Exception {
        System.out.println("\nComprobamos si getlPartidas() funciona correctamente...");
        Assert.assertNotNull(lPartidas.getlPartidas());
    }

    @Test
    public void testAnadirPartida() throws Exception {
        System.out.println("\nComprobamos si añade bien una partida...");
        lPartidas.anadirPartida(p1);
        Assert.assertNotNull(lPartidas.getlPartidas().get(0));
        System.out.println("Y ahora comprobamos que no podemos volver a añadir la misma:");
        lPartidas.anadirPartida(p1);
    }

    @Test
    public void testEliminarPartida() throws Exception {
        System.out.println("\nComprobamos como funciona eliminarPartida()->");
        lPartidas.anadirPartida(p1);
        lPartidas.anadirPartida(p2);
        System.out.println("ANTES DE ELIMINAR: ");
        lPartidas.imprimirPartidas();
        System.out.println("DESPUES DE ELIMINAR:");
        lPartidas.eliminarPartida(p1);
        lPartidas.imprimirPartidas();

    }

    @Test
    public void testEsta() throws Exception {

    }

    @Test
    public void testImprimirPartidas() throws Exception {

    }

    @Test
    public void testOrdenarListaPorPuntuaion() throws Exception {
        System.out.println("\nAñadimos las partidas creadas a la lista de partidas:");
        lPartidas.anadirPartida(p1);
        lPartidas.anadirPartida(p2);
        lPartidas.anadirPartida(p3);
        lPartidas.anadirPartida(p4);
        lPartidas.anadirPartida(p5);

        System.out.println("Mostramos la informacion de las partidas añadidas: ");
        lPartidas.imprimirPartidas();
        System.out.println("Pasamos a comprobar si las partidas se ordenan correctamente...");
        lPartidas.ordenarListaPorPuntuaion();
        lPartidas.imprimirPartidas();
    }
}