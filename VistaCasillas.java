import java.awt.Color;
import java.awt.Dimension;
import java.util.Observable;
import java.util.Observer;

import javax.swing.*;

/**
 *
 * @author Eneko
 */
public class VistaCasillas extends JButton implements Observer {

    private static final long serialVersionUID = 1L;
    private JButton boton;
    private ModeloCasilla casilla;
    private Controlador controlador;

    /**
     * crea los botones necesarios
     *
     * @param field
     */
    public VistaCasillas(ModeloCasilla field) {
        this.casilla = field;
        this.boton = new JButton("");
        this.boton.setPreferredSize(new Dimension(30, 30));
        this.controlador = new Controlador(field);
        this.boton.addMouseListener(controlador);
        this.casilla.addObserver(this);
    }

    public JButton getBoton() {
        return this.boton;
    }

    /**
     * actualiza la vista de los botones
     *
     * @param obs
     * @param o
     */
    @Override
    public void update(Observable obs, Object o) {
        // TODO Auto-generated method stub
        if (casilla.getEstaDescubierta() == true) {

            if (this.casilla.getIdCasilla() == 9) {
                this.boton.setIcon(new ImageIcon("/home/josu/Documentos/IntelliJ Projects/Buscaminas/src/bomb.png"));
            } else {
                this.boton.setBackground(Color.LIGHT_GRAY);
                if (this.casilla.getIdCasilla() == 0) {
                    this.boton.setText("");
                } else {
                    switch (this.casilla.getIdCasilla()) {
                        case 1:
                            //this.boton.setForeground(Color.white);
                            this.boton.setIcon(new ImageIcon("/home/josu/Documentos/IntelliJ Projects/Buscaminas/src/1.png"));
                            break;
                        case 2:
                            //this.boton.setForeground(Color.blue);
                            this.boton.setIcon(new ImageIcon("/home/josu/Documentos/IntelliJ Projects/Buscaminas/src/2.png"));
                            break;
                        case 3:
                            //this.boton.setForeground(Color.cyan);
                            this.boton.setIcon(new ImageIcon("/home/josu/Documentos/IntelliJ Projects/Buscaminas/src/3.png"));
                            break;
                        case 4:
                            //this.boton.setForeground(Color.GREEN);
                            this.boton.setIcon(new ImageIcon("/home/josu/Documentos/IntelliJ Projects/Buscaminas/src/4.png"));
                            break;
                        case 5:
                            this.boton.setIcon(new ImageIcon("/home/josu/Documentos/IntelliJ Projects/Buscaminas/src/5.jpg"));
                            //this.boton.setForeground(Color.MAGENTA);
                            break;
                        case 6:
                            this.boton.setIcon(new ImageIcon("/home/josu/Documentos/IntelliJ Projects/Buscaminas/src/6.gif"));
                            //this.boton.setForeground(Color.ORANGE);
                            break;
                        case 7:
                            this.boton.setIcon(new ImageIcon("/home/josu/Documentos/IntelliJ Projects/Buscaminas/src/7.png"));
                            //this.boton.setForeground(Color.lightGray);
                            break;
                        case 8:
                            this.boton.setIcon(new ImageIcon("/home/josu/Documentos/IntelliJ Projects/Buscaminas/src/8.png"));
                            //this.boton.setForeground(Color.YELLOW);
                            break;
                        default:
                            break;
                    }
                    //this.boton.setText(Integer.toString(this.casilla.getIdCasilla()));
                }
            }
        }
        if (casilla.isFlag()) {
            this.boton.setText("P");
            this.boton.setBackground(Color.yellow);
        }
        if (!casilla.isFlag() && !casilla.getEstaDescubierta()) {
            this.boton.setText("");
            this.boton.setBackground(new JButton().getBackground());
        }
    }

}

        /*if (casilla.getSiEstaRevelada()){
            if (this.casilla.getId() != -1){
                this.setBackground(Color.DARK_GRAY);
                if (this.casilla.getId() != 0) {
                    switch (this.casilla.getId()) {
                        case 1:
                            this.boton_casilla.setForeground(Color.white);
                            break;
                        case 2:
                            this.boton_casilla.setForeground(Color.blue);
                            break;
                        case 3:
                            this.boton_casilla.setForeground(Color.cyan);
                            break;
                        case 4:
                            this.boton_casilla.setForeground(Color.GREEN);
                            break;
                        case 5:
                            this.boton_casilla.setForeground(Color.MAGENTA);
                            break;
                        case 6:
                            this.boton_casilla.setForeground(Color.ORANGE);
                            break;
                        case 7:
                            this.boton_casilla.setForeground(Color.lightGray);
                            break;
                        case 8:
                            this.boton_casilla.setForeground(Color.YELLOW);
                            break;
                        default:
                            break;
                    }
                    this.boton_casilla.setText(Integer.toString(this.casilla.getId()));
                }else{
                    this.boton_casilla.setText("");
                }
            }else{
                this.boton_casilla.setBackground(Color.RED);
            }
        }
        if (casilla.getSiEstaMarcada()){
            this.boton_casilla.setText("*");
            this.boton_casilla.setBackground(Color.BLACK);
            this.boton_casilla.setForeground(Color.RED);
        }else if (!casilla.getSiEstaRevelada() && !casilla.getSiEstaMarcada()){
            this.boton_casilla.setText("");
            this.boton_casilla.setBackground(new JButton().getBackground());
        }
    }*/

