package proyecto_1.persistencia;

import proyecto_1.entidades.Especialidad;
import proyecto_1.entidades.Medico;
import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class PersistenciaMedicos {

    private ArrayList<Medico> medicos = new ArrayList<>();
    private final String archivo = "medicos.txt";

    public PersistenciaMedicos() {
        cargarArchivo();
    }

    public void agregarMedico(Medico medico) {
        int nuevoId = medicos.isEmpty() ? 1 : medicos.get(medicos.size() - 1).getId() + 1;
        medico.setId(nuevoId);
        medicos.add(medico);
        guardarArchivo();
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

    private void guardarArchivo() {
        try (PrintWriter pw = new PrintWriter(new FileWriter(archivo))) {
            for (Medico m : medicos) {
                int idEsp = m.getEspecialidad() != null ? m.getEspecialidad().getId() : 0;
                pw.println(m.getId() + "|" + m.getNombre() + "|" + idEsp);
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
                if (partes.length >= 3) {
                    int idEsp = Integer.parseInt(partes[2]);
                    Especialidad esp = new Especialidad(idEsp, "");
                    Medico m = new Medico(
                            Integer.parseInt(partes[0]),
                            partes[1],
                            esp);
                    medicos.add(m);
                }
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    // resolver referencias de especialidades despues de cargar
    public void resolverEspecialidades(PersistenciaEspecialidades persEsp) {
        for (Medico m : medicos) {
            if (m.getEspecialidad() != null) {
                Especialidad real = persEsp.obtenerEspecialidadPorId(m.getEspecialidad().getId());
                if (real != null)
                    m.setEspecialidad(real);
            }
        }
    }
}
