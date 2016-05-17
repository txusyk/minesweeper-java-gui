import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static org.testng.Assert.*;

/**
 * Created by portatil on 17/05/16.
 */
public class InfoPartidaTest {

    InfoPartida iP1;

    @BeforeMethod
    public void setUp() throws Exception {
        iP1 = new InfoPartida("Mario", 100);
    }

    @AfterMethod
    public void tearDown() throws Exception {

    }

    @Test
    public void testSetNombre() throws Exception {
        System.out.println("\nComprobamos como funciona setNombre()->");
        iP1.setNombre("Aurelio");
        Assert.assertEquals(iP1.getNombreJugador(), "Aurelio");
    }

    @Test
    public void testSetPuntuacion() throws Exception {
        System.out.println("\nComprobamos como funciona setPuntuacion()->");
        iP1.setPuntuacion(30);
        Assert.assertEquals(iP1.getPuntuacion(), 30);
    }

    @Test
    public void testGetNombreJugador() throws Exception {
        System.out.println("\nComprobaremos si funciona correctamente getNombre()...");
        Assert.assertEquals(iP1.getNombreJugador(), "Mario");
    }

    @Test
    public void testGetPuntuacion() throws Exception {
        System.out.println("\nComprobaremos si funciona correctamente getPuntuacion()...");
        Assert.assertEquals(iP1.getPuntuacion(), 100);
    }
}