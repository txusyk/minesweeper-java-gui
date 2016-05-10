import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

/**
 *
 * @author Eneko
 */
public class Controlador extends MouseAdapter {

    private ModeloCasilla casilla;
    private ModeloTablero ModeloTablero;

    /**
     * Constructora
     *
     * @param casilla define las casillas de juego
     */
    public Controlador(ModeloCasilla casilla) {
        this.casilla = casilla;
    }



    /**
     * Constructora
     *
     * @param model
     */
    public Controlador(ModeloTablero model) {
        this.ModeloTablero = model;
    }

    /**
     * controla los click-s del raton y las clases y metodos del ModeloTablero
     *
     * @param e el MouseEvent acaba de activarse
     */
    @Override
    public void mouseClicked(MouseEvent e) {

        switch (e.getButton()) {
            case MouseEvent.BUTTON1:
                if (this.ModeloTablero == null) {
                    if (!casilla.isFlag()) {
                        casilla.descubreCasilla();

                    }
                } else {
                    ModeloTablero.Init();
                }
                break;
            case MouseEvent.BUTTON3:
                if (this.ModeloTablero == null) {
                    casilla.cambiaEstado();
                }
                break;
            default:
                break;
        }
    }
}
