import org.testng.Assert;

import static org.testng.Assert.*;

/**
 * Created by portatil on 16/05/16.
 */
public class EnJuegoTest extends EnJuego {

    Estado estado;

    @org.testng.annotations.BeforeMethod
    public void setUp() throws Exception {
        estado = new EnJuego();
    }

    @org.testng.annotations.AfterMethod
    public void tearDown() throws Exception {

    }

    @org.testng.annotations.Test
    public void testJugar() throws Exception {
        System.out.println("Comprobamos que el jugar()");
    }

    @org.testng.annotations.Test
    public void testGetEstado() throws Exception {
        System.out.println("\nComprobamos como funciona getEstado()->");
        Assert.assertEquals(estado.getEstado(), "En Juego");
    }
}