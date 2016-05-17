import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static org.testng.Assert.*;

/**
 * Created by portatil on 16/05/16.
 */
public class ModeloCasillaTest{

    ModeloTablero mTablero;
    ModeloCasilla mCasillaMina;
    ModeloCasilla mCasillaVacia;
    ModeloCasilla mCasillaNum;

    @BeforeMethod
    public void setUp() throws Exception {
        mTablero = new ModeloTablero(7, 10, 10);
        mCasillaMina = new ModeloCasilla(mTablero, 2, 2, 9);
        mCasillaNum = new ModeloCasilla(mTablero, 3,3,1);
        mCasillaVacia = new ModeloCasilla(mTablero, 6, 6, 0);
    }

    @AfterMethod
    public void tearDown() throws Exception {

    }

    @Test
    public void testInit() throws Exception {
        System.out.println("Comprobamos si el Init() funciona correctamente->");
        mCasillaNum.Init(mTablero, 3, 3, 9);
        Assert.assertNotNull(mCasillaNum);
        mCasillaVacia.Init(mTablero, 6, 6, 1);
        Assert.assertNotNull(mCasillaVacia);
        mCasillaMina.Init(mTablero, 2, 2, 0);
        Assert.assertNotNull(mCasillaMina);
    }

    @Test
    public void testDescubreCasilla() throws Exception {

        System.out.println("\nComprobamos como funciona descubrirCasilla()->");
        mTablero.setEstado(new EnJuego());

        System.out.println("\tComprobamos como se descubre casillaNum");
        mCasillaNum.descubreCasilla();
        System.out.println("\t\tComprobamos que la casilla se ha cambiado a descubierta...");
        Assert.assertTrue(mCasillaNum.getEstaDescubierta());

        System.out.println("\t\tComprobamos como se descubre casillaVacia,...");
        mCasillaVacia.descubreCasilla();
        System.out.println("\t\tComprobamos que la casilla se han cambiado a descubierta...");
        Assert.assertTrue(mCasillaVacia.getEstaDescubierta());


        System.out.println("\tComprobamos como se descubre casillaMina");
        mCasillaMina.descubreCasilla();
        System.out.println("\t\tComprobamos que el estado de la casilla se ha cambiado a descubierta...");
        Assert.assertEquals(mTablero.getModo(), "Has Perdido");
    }

    @Test
    public void testCambiaEstado() throws Exception {
        System.out.println("\nComprobamos como funciona el cambiaEstado()->");
        System.out.println("\tComprobamos para casillaVacia");
        System.out.println("\t\tMiramos que al marcarla se disminuyen las minas restantes en el tablero:");
        System.out.println("\t\tMINAS ANTES DEL CAMBIO\t"+mTablero.minasRestantes());
        mCasillaVacia.cambiaEstado();
        System.out.println("\t\tMINAS DESPUES DEL CAMBIO\t"+mTablero.minasRestantes());

        System.out.println("\tComprobamos para casillaNum");
        System.out.println("\t\tMiramos que al marcarla se disminuyen las minas restantes en el tablero:");
        System.out.println("\t\tMINAS ANTES DEL CAMBIO\t"+mTablero.minasRestantes());
        mCasillaNum.cambiaEstado();
        System.out.println("\t\tMINAS DESPUES DEL CAMBIO\t"+mTablero.minasRestantes());

        System.out.println("\tComprobamos para casillaMina");
        System.out.println("\t\tMiramos que al marcarla se disminuyen las minas restantes en el tablero:");
        System.out.println("\t\tMINAS ANTES DEL CAMBIO\t"+mTablero.minasRestantes());
        mCasillaMina.cambiaEstado();
        System.out.println("\t\tMINAS DESPUES DEL CAMBIO\t"+mTablero.minasRestantes());
    }

    @Test
    public void testIsFlag() throws Exception {
        System.out.println("\nComprobamos como funciona isFlag()->");
        System.out.println("\tComprobamos que casillaVacia se inicializa con esBandera a 'false'...");
        Assert.assertFalse(mCasillaVacia.isFlag());
        System.out.println("\tY ahora comprobamos que despues de marcarla lo cambia a 'true'...");
        mCasillaVacia.cambiaEstado();
        Assert.assertTrue(mCasillaVacia.isFlag());

        System.out.println("\tComprobamos que casillaNum se inicializa con esBandera a 'false'...");
        Assert.assertFalse(mCasillaNum.isFlag());
        System.out.println("\tY ahora comprobamos que despues de marcarla lo cambia a 'true'...");
        mCasillaNum.cambiaEstado();
        Assert.assertTrue(mCasillaNum.isFlag());

        System.out.println("\tComprobamos que casillaMina se inicializa con esBandera a 'false'...");
        Assert.assertFalse(mCasillaMina.isFlag());
        System.out.println("\tY ahora comprobamos que despues de marcarla lo cambia a 'true'...");
        mCasillaMina.cambiaEstado();
        Assert.assertTrue(mCasillaMina.isFlag());
    }

    @Test
    public void testGetIdCasilla() throws Exception {
        System.out.println("\nComprobamos como funciona getIdCasilla()->");
        System.out.println("\tComprobamos que se inicializa correctamente para casillaVacia...");
        Assert.assertEquals(mCasillaVacia.getIdCasilla(), 0);

        System.out.println("\tComprobamos que se inicializa correctamente para casillaNum...");
        Assert.assertEquals(mCasillaNum.getIdCasilla(), 1);

        System.out.println("\tComprobamos que se inicializa correctamente para casillaMina...");
        Assert.assertEquals(mCasillaMina.getIdCasilla(), 9);

    }

    @Test
    public void testGetPosx() throws Exception {
        System.out.println("\nComprobamos como funciona getPosx()->");
        System.out.println("\tComprobamos que se inicializa correctamente para casillaVacia...");
        Assert.assertEquals(mCasillaVacia.getPosx(), 6);

        System.out.println("\tComprobamos que se inicializa correctamente para casillaNum...");
        Assert.assertEquals(mCasillaNum.getPosx(), 3);

        System.out.println("\tComprobamos que se inicializa correctamente para casillaMina...");
        Assert.assertEquals(mCasillaMina.getPosx(), 2);

    }

    @Test
    public void testGetPosy() throws Exception {
        System.out.println("\nComprobamos como funciona getPosy()->");
        System.out.println("\tComprobamos que se inicializa correctamente para casillaVacia...");
        Assert.assertEquals(mCasillaVacia.getPosy(), 6);

        System.out.println("\tComprobamos que se inicializa correctamente para casillaNum...");
        Assert.assertEquals(mCasillaNum.getPosy(), 3);

        System.out.println("\tComprobamos que se inicializa correctamente para casillaMina...");
        Assert.assertEquals(mCasillaMina.getPosy(), 2);

    }

    @Test
    public void testGetEstaDescubierta() throws Exception {
        System.out.println("\nComprobamos como funciona getEstaDescubierta()->");
        System.out.println("\tComprobamos para casillaVacia...");
        Assert.assertFalse(mCasillaVacia.getEstaDescubierta());

        System.out.println("\tComprobamos para casillaNum...");
        Assert.assertFalse(mCasillaNum.getEstaDescubierta());

        System.out.println("\tComprobamos para casillaMina...");
        Assert.assertFalse(mCasillaVacia.getEstaDescubierta());
    }

    @Test
    public void testAdd1() throws Exception {
        System.out.println("\nComprobamos como funciona add1()->");
        System.out.println("\tComprobamos para casillaVacia...");
        mCasillaVacia.add1();
        Assert.assertEquals(mCasillaVacia.getIdCasilla(), 1);

        System.out.println("\tComprobamos para casillaNum...");
        mCasillaNum.add1();
        Assert.assertEquals(mCasillaNum.getIdCasilla(), 2);
    }

    @Test
    public void testSetMina() throws Exception {
        System.out.println("\nComprobamos como funciona setMina()->");
        System.out.println("\tComprobamos para casillaVacia...");
        mCasillaVacia.setMina();
        Assert.assertEquals(mCasillaVacia.getIdCasilla(), 9);

        System.out.println("\tComprobamos para casillaNum...");
        mCasillaNum.setMina();
        Assert.assertEquals(mCasillaVacia.getIdCasilla(), 9);
    }

    @Test
    public void testSetEstaDescubierta() throws Exception {
        System.out.println("\nComprobamos como funciona setEstaDescubierta()->");
        System.out.println("\tComprobamos para casillaVacia...");
        mCasillaVacia.setEstaDescubierta();
        Assert.assertTrue(mCasillaVacia.getEstaDescubierta());

        System.out.println("\tComprobamos para casillaNum...");
        mCasillaNum.setEstaDescubierta();
        Assert.assertTrue(mCasillaNum.getEstaDescubierta());

        System.out.println("\tComprobamos para casillaMina...");
        mCasillaMina.setEstaDescubierta();
        Assert.assertTrue(mCasillaMina.getEstaDescubierta());
    }
}