/**
 * Created by portatil on 16/05/16.
 */
public class EnJuego implements Estado{

    public void jugar(ModeloTablero modelo){
        modelo.setEstado(this);
    }

    public String getEstado(){
        return "En Juego";
    }

}
