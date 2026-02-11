package proyecto_1.persistencia;

import proyecto_1.entidades.Especialidad;
import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class PersistenciaEspecialidades {

    private ArrayList<Especialidad> especialidades = new ArrayList<>();
    private final String archivo = "especialidades.txt";

    public PersistenciaEspecialidades() {
        cargarArchivo();
    }

    public void agregarEspecialidad(Especialidad especialidad) {
        int nuevoId = especialidades.isEmpty() ? 1 : especialidades.get(especialidades.size() - 1).getId() + 1;
        try {
            Especialidad nueva = new Especialidad(nuevoId, especialidad.getNombre());
            especialidades.add(nueva);
            guardarArchivo();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
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

    private void guardarArchivo() {
        try (PrintWriter pw = new PrintWriter(new FileWriter(archivo))) {
            for (Especialidad e : especialidades) {
                pw.println(e.getId() + "|" + e.getNombre());
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    private void cargarArchivo() {
        File file = new File(archivo);
        if (file.exists() == false)
            return;
        try (BufferedReader br = new BufferedReader(new FileReader(file))) {
            String linea;
            while ((linea = br.readLine()) != null) {
                String[] partes = linea.split("\\|");
                if (partes.length >= 2) {
                    Especialidad e = new Especialidad(
                            Integer.parseInt(partes[0]),
                            partes[1]);
                    especialidades.add(e);
                }
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
}
