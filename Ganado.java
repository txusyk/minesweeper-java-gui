/**
 * Created by portatil on 16/05/16.
 */
public class Ganado implements Estado{

    public void jugar(ModeloTablero modelo){
        modelo.setEstado(this);
    }

    public String getEstado(){
        return "Has ganado!!";
    }

}
