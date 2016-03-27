/**
 * Created by jalva on 21/02/2016.
 */
public class CasillaMina extends Casilla {

    public boolean descubierta;

    /**
     * @param pPosX
     * @param pPosY
     * Constructora
     */
    public CasillaMina(int pPosX, int pPosY){
        super(pPosX,pPosY);
    }

    /**
     *
     * @param posX
     * @param posY
     * En caso de descubrir una mina dara por finalizado el juego
     */
    public void descubrirCasilla(int posX, int posY) {
        Partida.getMiPartida().setBomba();
    }
}
