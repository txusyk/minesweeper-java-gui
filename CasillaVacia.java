/**
 * Created by jalva on 21/02/2016.
 */
public class CasillaVacia extends Casilla {

    /**
     * @param posX
     * @param posY Constructora
     */
    public CasillaVacia(int posX, int posY) {
        super(posX, posY);
    }

    /**
     * @param posX
     * @param posY En caso de clickar sobre esta casilla no  ocurrirá nada. Solo se descubrira una casilla vacia.
     */
    public void descubrirCasilla(int posX, int posY) {
        Casilla auxCasilla = null;

        if (Tablero.getMiTablero().getCasilla(posX - 1, posY - 1) instanceof CasillaVacia && posX != 0 && posY != 0) { //miramos la de arriba a la izquierda asegurandonos de que existe
            auxCasilla = Tablero.getMiTablero().getCasilla(posX - 1, posY - 1);                    //en caso de que sea vacia, ejecutaremos el descubrirCasilla() de esa casilla para que se descubran recursivmente
            auxCasilla.descubrirCasilla(auxCasilla.getPosX(), auxCasilla.getPosY());
        }                                                                                        //si no es vacia pasaremos a la siguiente
        if (Tablero.getMiTablero().getCasilla(posX - 1, posY) instanceof CasillaVacia && posX != 0) { //miramos la casilla de encima asegurandonos de que existe
            auxCasilla = Tablero.getMiTablero().getCasilla(posX - 1, posY);
            auxCasilla.descubrirCasilla(auxCasilla.getPosX(), auxCasilla.getPosY());
        }
        if (Tablero.getMiTablero().getCasilla(posX - 1, posY + 1) instanceof CasillaVacia && posX != 0 && posY != Tablero.getMiTablero().getY()) { //miramos la casilla de arriba a la derecha asegurandonos de que existe
            auxCasilla = Tablero.getMiTablero().getCasilla(posX - 1, posY + 1);
            auxCasilla.descubrirCasilla(auxCasilla.getPosX(), auxCasilla.getPosY());
        }
        if (Tablero.getMiTablero().getCasilla(posX, posY - 1) instanceof CasillaVacia && posY != 0) { //miramos la casilla de la izquierda asegurandonos de que existe
            auxCasilla = Tablero.getMiTablero().getCasilla(posX, posY - 1);
            auxCasilla.descubrirCasilla(auxCasilla.getPosX(), auxCasilla.getPosY());
        }
        if (Tablero.getMiTablero().getCasilla(posX, posY + 1) instanceof CasillaVacia && posY != Tablero.getMiTablero().getY()) { //miramos la casilla de la derecha asegurandonos de que existe
            auxCasilla = Tablero.getMiTablero().getCasilla(posX, posY + 1);
            auxCasilla.descubrirCasilla(auxCasilla.getPosX(), auxCasilla.getPosY());
        }
        if (Tablero.getMiTablero().getCasilla(posX + 1, posY + 1) instanceof CasillaVacia && posX != Tablero.getMiTablero().getX() && posY != 0) { //miramos la casilla de abajo a la izquierda asegurandonos de que existe
            auxCasilla = Tablero.getMiTablero().getCasilla(posX + 1, posY + 1);
            auxCasilla.descubrirCasilla(auxCasilla.getPosX(), auxCasilla.getPosY());
        }
        if (Tablero.getMiTablero().getCasilla(posX + 1, posY) instanceof CasillaVacia && posX != Tablero.getMiTablero().getX()) { //miramos la casilla de abajo asegurandonos de que existe
            auxCasilla = Tablero.getMiTablero().getCasilla(posX + 1, posY);
            auxCasilla.descubrirCasilla(auxCasilla.getPosX(), auxCasilla.getPosY());
        }
        if (Tablero.getMiTablero().getCasilla(posX + 1, posY + 1) instanceof CasillaVacia && posX != Tablero.getMiTablero().getX() && posY != Tablero.getMiTablero().getY()) { //miramos la casilla de abajo a la derecha asegurandonos de que existe
            auxCasilla = Tablero.getMiTablero().getCasilla(posX + 1, posY + 1);
            auxCasilla.descubrirCasilla(auxCasilla.getPosX(), auxCasilla.getPosY());
        }
    }
}
