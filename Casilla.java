/**
 * Created by jalva on 21/02/2016.
 */
public abstract class Casilla {

    protected int posX, posY;
    protected  boolean marcada = false;

    /**
     * @param pPosX
     * @param pPosY
     * Constructora
     */
    public Casilla(int pPosX, int pPosY){
        this.posX = pPosX;
        this.posY = pPosY;
    }

    /**
     * @return devuelve la coordenadaX
     */
    public  int getPosX(){
        return this.posX;
    }

    /**
     * @return devuelve la coordenadaY
     */
    public int getPosY(){
        return this.posY;
    }

    /**
     *
     * @param posX
     * @param posY
     * Se encarga de accionar la casilla oportuna
     */
    abstract void descubrirCasilla(int posX, int posY);

    /**
     * Pone una marca en la casilla
     */
    public void marcarCasilla(){

    }



}
