import java.awt.*;
import java.util.Observable;
import java.util.Observer;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

/**
 * Vista del buscaminas
 *
 * @author Eneko
 */
public class VistaBuscaminas extends JPanel implements Observer {

    private static final long serialVersionUID = 1L;
    private JPanel vista;
    private JLabel minas, modo, timer;
    private VistaCasillas[][] casilla;
    private ModeloTablero ModeloTablero;

    /**
     * Constructora
     *
     * @param model establece los parametros estandar para la vista
     */
    public VistaBuscaminas(ModeloTablero model) {
        this.ModeloTablero = model;
        this.setLayout(new BorderLayout());
        this.vista = new JPanel();
        this.minas = setLabel(this.minas, "Minas:  " + Integer.toString(model.minasRestantes()));
        this.modo = setLabel(this.modo, "Modo:  " + model.getModo());
        this.timer = setLabel(this.timer, "Tiempo:  " + model.getTimer());

        this.add(this.minas, BorderLayout.WEST);
        this.add(this.modo, BorderLayout.EAST);
        this.add(this.timer, BorderLayout.CENTER);
        this.add(reiniciarBoton(), BorderLayout.NORTH);
        this.casilla = new VistaCasillas[model.getAltura()][model.getAncho()];
        this.ModeloTablero.addObserver(this);

        this.vista.setLayout(new GridLayout(model.getAltura(), model.getAncho()));
        crearBoton();
        this.add(vista, BorderLayout.SOUTH);

    }

    /**
     * actualizar la vista
     */
    @Override
    public void update(Observable obs, Object o) {
        // TODO Auto-generated method

        // si el objeto es vacio, actualiza todas
        if (o != null) {
            actualizarBotones();
        }
        this.minas = setLabel(this.minas, "Minas:  " + Integer.toString(ModeloTablero.minasRestantes()));
        this.modo = setLabel(this.modo, "Modo:  " + ModeloTablero.getModo());
        this.timer = setLabel(this.timer, "Tiempo:  " + this.ModeloTablero.getTimer());

    }

    /**
     *
     * @param label
     * @param string establece el texto
     * @return devuelve label con el string
     */
    private JLabel setLabel(JLabel label, String string) {
        if (!(label instanceof JLabel)) {
            label = new JLabel("");
        }
        label.setText(string);
        label.setPreferredSize(new Dimension(100, 40));
        label.setHorizontalAlignment(SwingConstants.CENTER);
        return label;

    }

    /**
     * @return la vista
     */
    public JPanel getVista() {
        return this.vista;
    }

    /**
     * boton restart
     *
     * @return
     */
    public JButton reiniciarBoton() {
        JButton button = new JButton("Reiniciar Partida");
        button.setPreferredSize(new Dimension(20, 40));
        Controlador controller = new Controlador(ModeloTablero);
        button.addMouseListener(controller);
        return button;

    }

    /**
     * update botones
     */
    public void actualizarBotones() {

        eliminarBoton();

        crearBoton();

    }

    /**
     * elimina botones
     */
    private void eliminarBoton() {
        for (int i = 0; i < this.ModeloTablero.getAltura(); i++) {
            for (int j = 0; j < this.ModeloTablero.getAncho(); j++) {

                this.vista.remove(casilla[i][j].getBoton());

            }

        }

    }

    /**
     * crea botones
     */
    private void crearBoton() {

        for (int i = 0; i < this.ModeloTablero.getAltura(); i++) {
            for (int j = 0; j < this.ModeloTablero.getAncho(); j++) {
                VistaCasillas button = new VistaCasillas(this.ModeloTablero.getCasilla(i, j));
                casilla[i][j] = button;
                this.vista.add(button.getBoton());

            }

        }
    }
}
