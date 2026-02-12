package proyecto_1.persistencia;

import proyecto_1.entidades.Especialidad;
import java.util.ArrayList;
import java.util.List;

public class PersistenciaEspecialidades {

    private ArrayList<Especialidad> especialidades = new ArrayList<>();

    public PersistenciaEspecialidades() {
    }

    public void agregarEspecialidad(Especialidad especialidad) {
        int nuevoId = especialidades.isEmpty() ? 1 : especialidades.get(especialidades.size() - 1).getId() + 1;
        Especialidad nueva = new Especialidad(nuevoId, especialidad.getNombre());
        especialidades.add(nueva);
    }

    public Especialidad obtenerEspecialidadPorId(int id) {
        for (Especialidad e : especialidades) {
            if (e.getId() == id)
                return e;
        }
        return null;
    }

    public List<Especialidad> listarEspecialidades() {
        return new ArrayList<>(especialidades);
    }

    // buscar por nombre para evitar duplicados
    public Especialidad obtenerPorNombre(String nombre) {
        for (Especialidad e : especialidades) {
            if (e.getNombre().equalsIgnoreCase(nombre))
                return e;
        }
        return null;
    }

}
