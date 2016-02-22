/**
 * Created by jalva on 21/02/2016.
 */
public class CasillaNumerica extends Casilla {

    public boolean descubierta;
    public int valor = 1;

    /**
     * @param pPosX
     * @param pPosY
     * Constructora
     */
    public CasillaNumerica(int pPosX, int pPosY) {
        super(pPosX, pPosY);
    }

    /**
     * @param posX
     * @param posY
     * En caso de descubrir la casilla
     */
    @Override
    protected void descubrirCasilla(int posX, int posY) {

    }

    protected void aumentarValor(){
        this.valor++;
    }
}
