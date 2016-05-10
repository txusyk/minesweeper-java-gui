import java.awt.*;
import java.io.IOException;
import java.util.Scanner;

import javax.swing.JFrame;
import javax.xml.stream.Location;

public class Buscaminas2 {

    /**
     * Starts Buscaminas
     * @param argv Se elije dificultad o se personalizan los parametros de juego
     * @throws IOException
     */
    public static void main(String[] argv) throws IOException {
        String input = "";
        int ancho = -1;
        int alto = -1;
        int minas = -1;
        final int altoFacil=9, altoMedio=9, altoDificil=30, anchoFacil=9, anchoMedio=16, anchoDificil=16;
        final int numMinasFacil=10, numMinasMedio=20, numMinasDificil=75;

        //Set Modo - dificultad
        if (argv.length == 1) {
            input = argv[0];
        }
        //Set alto,ancho, numero de minas
        if (argv.length == 3) {
            ancho = Integer.parseInt(argv[0]);
            alto = Integer.parseInt(argv[1]);
            minas = Integer.parseInt(argv[2]);
            input = "Personalizado";
        }

        @SuppressWarnings("resource")
        Scanner scan = new Scanner(System.in);

        ModeloTablero model;

        System.out.println("Dificultad: Fácil/Medio/Difícil/Personalizado");

        //vamos a molestar al usuario hasta que elija dificultad
        while (!input.equals("Facil")
                && !input.equals("facil")
                && !input.equals("Medio")
                && !input.equals("medio")
                && !input.equals("Dificil")
                && !input.equals("dificil")
                && !input.equals("personalizado")
                && !input.equals("Personalizado")) {

            System.out.print("ELIGE DIFICULTAD: ");
            input = scan.nextLine();
        }

        //establece parametros dependiendo la dificultad
        if (input.equals("Facil") || input.equals("facil") || input.equals("FACIL")) {
            ancho = anchoFacil;
            alto = altoFacil;
            minas = numMinasFacil;
            model = new ModeloTablero(ancho, alto, minas);
        } else if (input.equals("Medio") || input.equals("medio") || input.equals("MEDIO")) {
            ancho = anchoMedio;
            alto = altoMedio;
            minas = numMinasMedio;
            model = new ModeloTablero(ancho, alto, minas);
        } else if (input.equals("Dificil") || input.equals("dificil") || input.equals("DIFICIL")) {
            ancho = anchoDificil;
            alto = altoDificil;
            minas = numMinasDificil;
            model = new ModeloTablero(ancho, alto, minas);
        } else {

            System.out.println();
            while (ancho < 6 || ancho > 35) {

                System.out.print("Elija el ancho deseado (min:6/max:35): ");
                ancho = scan.nextInt();

            }

            System.out.println();
            while (alto < 6 || alto > 20) {

                System.out.print("Elija la altura deseada (min:6/max:20): ");
                alto = scan.nextInt();

            }

            int maxMinas = alto * ancho - 1;

            System.out.println();
            while (minas < 1 || minas > maxMinas) {
                System.out.print("Introduce el número de minas (min:1/max:" + maxMinas + "): ");
                minas = scan.nextInt();
            }
            //Create el modelo con los parametros definidos
            model = new ModeloTablero(ancho, alto, minas);
        }

        //Información del juego
        System.out.println("\n\nGenerando Buscaminas:");
        System.out.println("Altura: " + alto);
        System.out.println("Ancho: " + ancho);
        System.out.println("Minas: " + minas);

        VistaBuscaminas view = new VistaBuscaminas(model); //creamos una vista que contendra el modelo del tablero

        JFrame frame = new JFrame("Buscaminas"); //creamos una ventana que se llamara buscaminas

        frame.setContentPane(view); //metemos como contenedor la vista
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); //fijamos que la operacion por defecto al cerrar es salir
        frame.pack(); //    hacemos que la ventana se ajuste al tamaño del contenido
        //En dim guardamos el tamaño de la pantalla donde se esta ejecutando el programa
        Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
        //Con setLocation() fijamos donde aparecera la ventana en nuestro programa. Con esta configuracion, la ventana siempre
        //aparecera en el centro de la pantalla del usuario
        frame.setLocation(dim.width/2-frame.getSize().width/2, dim.height/2-frame.getSize().height/2);
        frame.setVisible(true); //hacemos el frame visible
        frame.setResizable(false); //definimos que no podra modificar el tamaño de la ventana de nuestro programa
        frame.setAlwaysOnTop(true); //definimos que mientras este ejcutandose se superponga a cualquier otro programa

    }
}
