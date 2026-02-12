package proyecto_1.persistencia;

import proyecto_1.entidades.Medico;
import java.util.ArrayList;
import java.util.List;

public class PersistenciaMedicos {

    private ArrayList<Medico> medicos = new ArrayList<>();

    public PersistenciaMedicos() {
    }

    public void agregarMedico(Medico medico) {
        int nuevoId = medicos.isEmpty() ? 1 : medicos.get(medicos.size() - 1).getId() + 1;
        medico.setId(nuevoId);
        medicos.add(medico);
    }

    public Medico obtenerMedicoPorId(int id) {
        for (Medico m : medicos) {
            if (m.getId() == id)
                return m;
        }
        return null;
    }

    public List<Medico> listarMedicos() {
        return new ArrayList<>(medicos);
    }

}
