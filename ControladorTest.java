import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static org.testng.Assert.*;

/**
 * Created by portatil on 17/05/16.
 */
public class ControladorTest{

    @BeforeMethod
    public void setUp() throws Exception {

    }

    @AfterMethod
    public void tearDown() throws Exception {

    }

    @Test
    public void testMouseClicked() throws Exception {
        System.out.println("Comprobamos el funcionamiento de mouseClicked() en la implementacion de la interfaz");
    }
}