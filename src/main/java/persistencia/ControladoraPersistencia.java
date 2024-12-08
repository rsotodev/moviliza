package persistencia;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import logica.Automovil;
import persistencia.exceptions.NonexistentEntityException;

public class ControladoraPersistencia {
    
    AutomovilJpaController autoJpa = new AutomovilJpaController();
    
    //CREAR
    public void crearAutomovil(Automovil newvcl){
        autoJpa.create(newvcl);
    }
    
    //READ
    public List<Automovil> traerVehiculos(){
        return autoJpa.findAutomovilEntities();
    }

    public void borrarAutomovil(int id_eliminar) {
        try {
            autoJpa.destroy(id_eliminar);
        } catch (NonexistentEntityException ex) {
            Logger.getLogger(ControladoraPersistencia.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public Automovil traerVehiculo(int id_editar) {
            return autoJpa.findAutomovil(id_editar);
    }

    public void editarAutomovil(Automovil auto) {
        try {
            autoJpa.edit(auto);
        } catch (Exception ex) {
            Logger.getLogger(ControladoraPersistencia.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
