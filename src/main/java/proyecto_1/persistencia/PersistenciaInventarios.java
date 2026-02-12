package proyecto_1.persistencia;

import proyecto_1.entidades.EquipoMedico;
import java.util.ArrayList;
import java.util.List;

public class PersistenciaInventarios {

    private ArrayList<EquipoMedico> inventarios = new ArrayList<>();

    public PersistenciaInventarios() {
    }

    public void agregarEquipoMedico(EquipoMedico equipo) {
        int nuevoId = inventarios.isEmpty() ? 1 : inventarios.get(inventarios.size() - 1).getId() + 1;
        equipo.setId(nuevoId);
        inventarios.add(equipo);
    }

    public EquipoMedico obtenerEquipoPorId(int id) {
        for (EquipoMedico eq : inventarios) {
            if (eq.getId() == id)
                return eq;
        }
        return null;
    }

    public void actualizarCantidadEquipo(int id, int cantidad) {
        EquipoMedico eq = obtenerEquipoPorId(id);
        if (eq != null) {
            eq.setCantidad(eq.getCantidad() + cantidad);
        }
    }

    public List<EquipoMedico> listarEquiposMedicos() {
        return new ArrayList<>(inventarios);
    }

}
