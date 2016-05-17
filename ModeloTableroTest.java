import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static org.testng.Assert.*;

/**
 * Created by portatil on 16/05/16.
 */
public class ModeloTableroTest{

    ModeloTablero mTableroFacil;
    ModeloTablero mTableroMedio;
    ModeloTablero mTableroDificil;

    ModeloCasilla mCasillaMina;
    ModeloCasilla mCasillaMina2;
    ModeloCasilla mCasillaMina3;

    ModeloCasilla mCasillaVacia;
    ModeloCasilla mCasillaVacia2;
    ModeloCasilla mCasillaVacia3;
    ModeloCasilla mCasillaVacia4;
    ModeloCasilla mCasillaVacia5;
    ModeloCasilla mCasillaVacia6;
    ModeloCasilla mCasillaVacia7;
    ModeloCasilla mCasillaVacia8;
    ModeloCasilla mCasillaVacia9;
    ModeloCasilla mCasillaVacia10;
    ModeloCasilla mCasillaVacia11;
    ModeloCasilla mCasillaVacia12;
    ModeloCasilla mCasillaVacia13;
    ModeloCasilla mCasillaVacia14;
    ModeloCasilla mCasillaVacia15;
    ModeloCasilla mCasillaVacia16;
    ModeloCasilla mCasillaVacia17;
    ModeloCasilla mCasillaVacia18;
    ModeloCasilla mCasillaVacia19;
    ModeloCasilla mCasillaVacia20;
    ModeloCasilla mCasillaVacia21;
    ModeloCasilla mCasillaVacia22;
    ModeloCasilla mCasillaVacia23;
    ModeloCasilla mCasillaVacia24;

    Estado ganado;


    @BeforeMethod
    public void setUp() throws Exception {
        mTableroFacil = new ModeloTablero(7, 10, 10);
        mTableroMedio = new ModeloTablero(10, 15, 30);
        mTableroDificil = new ModeloTablero(12, 25, 75);

        mCasillaMina = new ModeloCasilla(mTableroFacil, 2, 2, 9);
        mCasillaMina2 = new ModeloCasilla(mTableroMedio, 2, 2, 9);
        mCasillaMina3 = new ModeloCasilla(mTableroDificil, 2, 2, 9);

        mCasillaVacia = new ModeloCasilla(mTableroFacil, 1, 1, 0);
        mCasillaVacia2 = new ModeloCasilla(mTableroFacil, 1, 2, 0);
        mCasillaVacia3 = new ModeloCasilla(mTableroFacil, 1, 3, 0);
        mCasillaVacia4 = new ModeloCasilla(mTableroFacil, 2, 1, 0);
        mCasillaVacia5 = new ModeloCasilla(mTableroFacil, 2, 3, 0);
        mCasillaVacia6 = new ModeloCasilla(mTableroFacil, 3, 1, 0);
        mCasillaVacia7 = new ModeloCasilla(mTableroFacil, 3, 2, 0);
        mCasillaVacia8 = new ModeloCasilla(mTableroFacil, 3, 3, 0);
        mCasillaVacia9 = new ModeloCasilla(mTableroMedio, 1, 1, 0);
        mCasillaVacia10 = new ModeloCasilla(mTableroMedio, 1, 2, 0);
        mCasillaVacia11 = new ModeloCasilla(mTableroMedio, 1, 3, 0);
        mCasillaVacia12 = new ModeloCasilla(mTableroMedio, 2, 1, 0);
        mCasillaVacia13 = new ModeloCasilla(mTableroMedio, 2, 3, 0);
        mCasillaVacia14 = new ModeloCasilla(mTableroMedio, 3, 1, 0);
        mCasillaVacia15 = new ModeloCasilla(mTableroMedio, 3, 2, 0);
        mCasillaVacia16 = new ModeloCasilla(mTableroMedio, 3, 3, 0);
        mCasillaVacia17 = new ModeloCasilla(mTableroDificil, 1, 1, 0);
        mCasillaVacia18 = new ModeloCasilla(mTableroDificil, 1, 2, 0);
        mCasillaVacia19 = new ModeloCasilla(mTableroDificil, 1, 3, 0);
        mCasillaVacia20 = new ModeloCasilla(mTableroDificil, 2, 1, 0);
        mCasillaVacia21 = new ModeloCasilla(mTableroDificil, 2, 3, 0);
        mCasillaVacia22 = new ModeloCasilla(mTableroDificil, 3, 1, 0);
        mCasillaVacia23 = new ModeloCasilla(mTableroDificil, 3, 2, 0);
        mCasillaVacia24 = new ModeloCasilla(mTableroDificil, 3, 3, 0);

        ganado = new Ganado();
    }

    @AfterMethod
    public void tearDown() throws Exception {

    }

    @Test
    public void testInit() throws Exception {
        System.out.println("\nComprobamos como funciona Init()->");

        System.out.println("\tComprobamos para tableroFacil");
        mTableroFacil.Init();
        Assert.assertNotNull(mTableroFacil);

        System.out.println("\tComprobamos para tableroMedio");
        mTableroMedio.Init();
        Assert.assertNotNull(mTableroMedio);

        System.out.println("\tComprobamos para tableroDificil");
        mTableroDificil.Init();
        Assert.assertNotNull(mTableroDificil);
    }


    @Test
    public void testPanelJuego() throws Exception {
        System.out.println("\nComprobamos como funciona panelJuego()->");
        System.out.println("\tComprobamos para tableroFacil...");
        mTableroFacil.panelJuego();
        Assert.assertNotNull(mTableroFacil.getCasilla(3,3));

        System.out.println("\tComprobamos para tableroMedio...");
        mTableroMedio.panelJuego();
        Assert.assertNotNull(mTableroMedio.getCasilla(3,3));

        System.out.println("\tComprobamos para tableroDificil...");
        mTableroDificil.panelJuego();
        Assert.assertNotNull(mTableroDificil.getCasilla(3,3));
    }

    @Test
    public void testContadorMinas() throws Exception {
        System.out.println("\ncontadorMinas() se prueba mediante la implementacion de la interfaz grafica.");

    }

    @Test
    public void testDescubrirCasillasVacias() throws Exception {

    }

    @Test
    public void testDescubrirTablero() throws Exception {
        System.out.println("\nComprobamos como funciona descubrirTablero()->");
        System.out.println("\tComnprobamos para tablero facil...");
        mTableroFacil.descubrirTablero();
        Assert.assertTrue(mTableroFacil.getCasilla(1,1).getEstaDescubierta());
        Assert.assertTrue(mTableroFacil.getCasilla(2,2).getEstaDescubierta());
        Assert.assertTrue(mTableroFacil.getCasilla(3,3).getEstaDescubierta());

        System.out.println("Comprobamos para tablero medio...");
        mTableroMedio.descubrirTablero();
        Assert.assertTrue(mTableroMedio.getCasilla(1,1).getEstaDescubierta());
        Assert.assertTrue(mTableroMedio.getCasilla(2,2).getEstaDescubierta());
        Assert.assertTrue(mTableroMedio.getCasilla(3,3).getEstaDescubierta());

        System.out.println("Comprobamos para tablero dificil...");
        mTableroDificil.descubrirTablero();
        Assert.assertTrue(mTableroDificil.getCasilla(1,1).getEstaDescubierta());
        Assert.assertTrue(mTableroDificil.getCasilla(2,2).getEstaDescubierta());
        Assert.assertTrue(mTableroDificil.getCasilla(3,3).getEstaDescubierta());

    }

    @Test
    public void testAnnadirADescubiertas() throws Exception {
        System.out.println("\nannadirADescubiertas() se prueba mediante la implementacion de la interfaz grafica.");
    }

    @Test
    public void testAddMinasRestantes() throws Exception {
        System.out.println("\naddMinasRestantes()se prueba mediante la implementacion de la interfaz grafica.");
    }

    @Test
    public void testSubMinasRestantes() throws Exception {
        System.out.println("\nsubMinasRestantes() se prueba mediante la implementacion de la interfaz grafica.");

    }


    @Test
    public void testGetAltura() throws Exception {
        System.out.println("\nComprobamos como funciona getAltura()->");
        System.out.println("\tComprobamos para tablero facil...");
        Assert.assertEquals(mTableroFacil.getAltura(),10);

        System.out.println("\tComprobamos para tablero medio...");
        Assert.assertEquals(mTableroMedio.getAltura(), 15);

        System.out.println("\tComprobamos para tablero dificil...");
        Assert.assertEquals(mTableroDificil.getAltura(), 25);


    }

    @Test
    public void testGetAncho() throws Exception {
//7.10 10.15 12.25

        System.out.println("\nComprobamos como funciona getAncho()->");
        System.out.println("\tComprobamos para tablero facil...");
        Assert.assertEquals(mTableroFacil.getAncho(), 7);

        System.out.println("\tComprobamos para tablero medio...");
        Assert.assertEquals(mTableroMedio.getAncho(), 10);

        System.out.println("\tComprobamos para tablero dificil...");
        Assert.assertEquals(mTableroDificil.getAncho(), 12);

    }

    @Test
    public void testGetModo() throws Exception {
        System.out.println("\nComprobamos como funciona getModo()->");
        System.out.println("\tComprobamos para tablero facil...");
        Assert.assertEquals(mTableroFacil.getModo(), "En Juego");

        System.out.println("\tComprobamos para tablero medio...");
        Assert.assertEquals(mTableroMedio.getModo(), "En Juego");

        System.out.println("\tComprobamos para tablero dificil...");
        Assert.assertEquals(mTableroDificil.getModo(), "En Juego");
    }

    @Test
    public void testGetCasilla() throws Exception {
        System.out.println("\nComprobamos el funcionamiento de getCasilla() mediante la implementacion de la interfaz.");
    }

    @Test
    public void testMinasRestantes() throws Exception {
        System.out.println("\nComprobamnos el funcionamiento de minasRestantes()->");
        System.out.println("\tComprobamos para tablero facil...");
        Assert.assertEquals(mTableroFacil.minasRestantes(), 10);

        System.out.println("\tComprobamos para tablero medio...");
        Assert.assertEquals(mTableroMedio.minasRestantes(), 30);

        System.out.println("\tComprobamos para tablero dificil...");
        Assert.assertEquals(mTableroDificil.minasRestantes(), 75);
    }

    @Test
    public void testGetTimer() throws Exception {
        System.out.println("\nComprobamos como funciona getTimer()->");
        System.out.println("\tComprobamos para tablero facil...");
        Assert.assertEquals(mTableroFacil.getTimer(), 0);

        System.out.println("\tComprobamos para tablero medio...");
        Assert.assertEquals(mTableroMedio.getTimer(), 0);

        System.out.println("\tComprobamos para tablero medio...");
        Assert.assertEquals(mTableroMedio.getTimer(), 0);
    }

    @Test
    public void testSetEstado() throws Exception {
        System.out.println("\nComprobamos como funciona setEstado()->");
        System.out.println("\tComprobamos para tablero facil...");
        mTableroFacil.setEstado(ganado);
        Assert.assertEquals(mTableroFacil.getModo(), "Has ganado!!");

        System.out.println("\tComprobamos para tablero medio...");
        mTableroMedio.setEstado(ganado);
        Assert.assertEquals(mTableroMedio.getModo(), "Has ganado!!");

        System.out.println("\tComprobamos para tablero dificil...");
        mTableroDificil.setEstado(ganado);
        Assert.assertEquals(mTableroDificil.getModo(), "Has ganado!!");
    }
}