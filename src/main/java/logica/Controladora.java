package logica;

import java.util.List;
import persistencia.ControladoraPersistencia;

public class Controladora {
    
    ControladoraPersistencia controlPersis = new ControladoraPersistencia ();
    
    public void crearAutomovil(Automovil auto){
        controlPersis.crearAutomovil(auto);
    }
    
    public List<Automovil> traerVehiculos(){
        return controlPersis.traerVehiculos();
    }

    public void borrarAutomovil(int id_eliminar) {
        controlPersis.borrarAutomovil(id_eliminar);
    }

    public Automovil traerVehiculo(int id_editar) {
        return controlPersis.traerVehiculo(id_editar);
    }

    public void editarAutomovil(Automovil auto) {
        controlPersis.editarAutomovil(auto);
    }
}
