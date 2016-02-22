/**
 * Created by jalva on 21/02/2016.
 */
public class CasillaVacia extends Casilla{

    /**
     * @param posX
     * @param posY
     * Constructora
     */
    public CasillaVacia(int posX, int posY){
        super(posX, posY);
    }

    /**
     * @param posX
     * @param posY
     * En caso de clickar sobre esta casilla no  ocurrirá nada
     */
    @Override
    protected void descubrirCasilla(int posX, int posY) {
    }
}
