/**
 * Created by jalva on 21/02/2016.
 */
public abstract class Casilla {

    protected int posX, posY;
    protected int estado = 0; //0 cubierta; 1 descubierta; 2 marcadaa


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

    public void marcarCasilla() {
        if (this.estado == 0) {
            this.estado = 2;
            Partida.getMiPartida().modificarMinasRestantes(true);
        }
    }

    public void desmarcarCasilla() {
        if (this.estado == 2) {
            this.estado = 0;
            Partida.getMiPartida().modificarMinasRestantes(false);
        }
    }




}
