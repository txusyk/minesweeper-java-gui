import javafx.scene.control.Tab;

/**
 * Created by jalva on 21/02/2016.
 */
public class Partida {

    public String nombreJugador;
    public int puntuacion;
    public int nivelDif;
    public int tiempo;
    public int contadorMinas;
    private static Partida miPartida;
    private boolean bomba = false;

    /**
     * Constructora
     * @param contadorMinas
     * @param tiempo
     * @param nivelDif
     * @param puntuacion
     * @param nombreJugador
     */
    public Partida(int contadorMinas, int tiempo, int nivelDif, int puntuacion, String nombreJugador) {
        this.contadorMinas = contadorMinas;
        this.tiempo = tiempo;
        this.nivelDif = nivelDif;
        this.puntuacion = puntuacion;
        this.nombreJugador = nombreJugador;
    }

    public static Partida getMiPartida() {
        return Partida.miPartida;
    }

    /**
     * Llama a la clase tablero y construye un objeto de ese tipo
     * cuyo tamaño esta definido por la dificultad
     */
    private void crearTablero(){
        System.out.println("Introduzca el nivel de tablero que desea: ");
        int auxN = Teclado.getMiTeclado().recogerInt();
        Tablero.getMiTablero().setNivel(auxN);
        Tablero.getMiTablero().crearTablero();
    }

    /**
     * Cambia el valor del booleano bomba
     */
    public void setBomba() {
        this.bomba = false;
    }


    /**
     * Comienza a jugar la partida hasta que este resuelta o bien se haya encontrado una mina
     */
    public void jugarPartida(){
        int auxLvl;

        System.out.println("Introduzca el nivel del tablero deseado: ");
        auxLvl = Teclado.getMiTeclado().regogerInt();
        Tablero.getMiTablero().crearTablero()
        while (!bomba) {

        }
        do
    }

    /**
     * Imprime la informacion de la partida
     */
    public void imprimirInfo(){

    }


}
