import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.ArrayList;

import static org.testng.Assert.*;

/**
 * Created by portatil on 17/05/16.
 */
public class RankingTest{

    ArrayList<InfoPartida> listaAux;

    InfoPartida iP1;
    InfoPartida iP2;
    InfoPartida iP3;
    InfoPartida iP4;

    @BeforeMethod
    public void setUp() throws Exception {
        listaAux=new ArrayList<InfoPartida>();

        iP1 = new InfoPartida("Josu", 300);
        iP2 = new InfoPartida("David", 300);
        iP3 = new InfoPartida("Josu", 500);
        iP4 = new InfoPartida("David", 670);
    }

    @Test
    public void testGetListaRanking() throws Exception {
        System.out.println("\nComprobamos como funciona getListaRanking()->");
        Assert.assertNotNull(Ranking.getMiRanking().getListaRanking());
    }

    @Test
    public void testCrearListaRanking() throws Exception {
        System.out.println("\nComprobamos como funciona crearListaRanking()->");
        GestorFicheros.getMiCargarFicheros().cargarFichJugXML();
        Ranking.getMiRanking().crearListaRanking();
        Ranking.getMiRanking().mostrarInfo();
        Assert.assertNotNull(Ranking.getMiRanking().getListaRanking());

    }

    @Test
    public void testGetMiRanking() throws Exception {
        System.out.println("\nComprobamos si se crea miModeloRanking....");
        Assert.assertNotNull(Ranking.getMiRanking());
    }

    @Test
    public void testObtenerDiezMejores() throws Exception {
        System.out.println("\n Comprobamos su funcionamiento en la implementacion de la interfaz.");
    }

    @Test
    public void testMostrarInfo() throws Exception {
        System.out.println("\nComprobamos como funciona mostrarInfo()->");
        Ranking.getMiRanking().mostrarInfo();
    }

    @Test
    public void testEsta() throws Exception {
        System.out.println("\nComprobamos como funciona esta()->");
        Ranking.getMiRanking().añadirInfoPartida(iP1);
        Assert.assertTrue(Ranking.getMiRanking().esta(iP1));
        Assert.assertFalse(Ranking.getMiRanking().esta(iP2));
    }
}