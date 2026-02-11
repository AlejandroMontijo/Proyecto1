package proyecto_1.persistencia;

import proyecto_1.entidades.EquipoMedico;
import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class PersistenciaInventarios {

    private ArrayList<EquipoMedico> inventarios = new ArrayList<>();
    private final String archivo = "inventarios.txt";

    public PersistenciaInventarios() {
        cargarArchivo();
    }

    public void agregarEquipoMedico(EquipoMedico equipo) {
        int nuevoId = inventarios.isEmpty() ? 1 : inventarios.get(inventarios.size() - 1).getId() + 1;
        equipo.setId(nuevoId);
        inventarios.add(equipo);
        guardarArchivo();
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
            guardarArchivo();
        }
    }

    public List<EquipoMedico> listarEquiposMedicos() {
        return new ArrayList<>(inventarios);
    }

    private void guardarArchivo() {
        try (PrintWriter pw = new PrintWriter(new FileWriter(archivo))) {
            for (EquipoMedico eq : inventarios) {
                pw.println(eq.getId() + "|" + eq.getNombre() + "|" + eq.getCantidad());
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
                    EquipoMedico eq = new EquipoMedico(
                            Integer.parseInt(partes[0]),
                            partes[1],
                            Integer.parseInt(partes[2]));
                    inventarios.add(eq);
                }
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
}
