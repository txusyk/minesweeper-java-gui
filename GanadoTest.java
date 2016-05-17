import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static org.testng.Assert.*;

/**
 * Created by portatil on 17/05/16.
 */
public class GanadoTest extends Ganado {

    Estado ganado;

    @BeforeMethod
    public void setUp() throws Exception {
        ganado=new Ganado();
    }

    @AfterMethod
    public void tearDown() throws Exception {

    }

    @Test
    public void testGetEstado() throws Exception {
        System.out.println("\nComprobamos como funciona getEstado()->");
        Assert.assertEquals(ganado.getEstado(), "Has ganado!!");
    }
}