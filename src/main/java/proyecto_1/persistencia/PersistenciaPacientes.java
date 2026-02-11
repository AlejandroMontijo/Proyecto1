package proyecto_1.persistencia;

import proyecto_1.entidades.Paciente;
import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class PersistenciaPacientes {

    private ArrayList<Paciente> pacientes = new ArrayList<>();
    private final String archivo = "pacientes.txt";

    public PersistenciaPacientes() {
        cargarArchivo();
    }

    public void agregarPaciente(Paciente paciente) {
        int nuevoId = pacientes.isEmpty() ? 1 : pacientes.get(pacientes.size() - 1).getId() + 1;
        paciente.setId(nuevoId);
        pacientes.add(paciente);
        guardarArchivo();
    }

    public Paciente obtenerPacientePorId(int id) {
        for (Paciente p : pacientes) {
            if (p.getId() == id)
                return p;
        }
        return null;
    }

    public List<Paciente> listarPacientes() {
        return new ArrayList<>(pacientes);
    }

    // metodos adicionales para funcionalidad del spec

    public boolean actualizarPaciente(Paciente actualizado) {
        for (int i = 0; i < pacientes.size(); i++) {
            if (pacientes.get(i).getId() == actualizado.getId()) {
                pacientes.set(i, actualizado);
                guardarArchivo();
                return true;
            }
        }
        return false;
    }

    public boolean eliminarPaciente(int id) {
        for (int i = 0; i < pacientes.size(); i++) {
            if (pacientes.get(i).getId() == id) {
                pacientes.remove(i);
                guardarArchivo();
                return true;
            }
        }
        return false;
    }

    public List<Paciente> filtrarPorDireccion(String direccion) {
        return pacientes.stream()
                .filter(p -> p.getDireccion().toLowerCase().contains(direccion.toLowerCase()))
                .collect(Collectors.toList());
    }

    public List<Paciente> filtrarPorEdad(int min, int max) {
        return pacientes.stream()
                .filter(p -> p.getEdad() >= min && p.getEdad() <= max)
                .collect(Collectors.toList());
    }

    public List<Paciente> filtrarCombinado(String direccion, int min, int max) {
        return pacientes.stream()
                .filter(p -> p.getDireccion().toLowerCase().contains(direccion.toLowerCase()))
                .filter(p -> p.getEdad() >= min && p.getEdad() <= max)
                .collect(Collectors.toList());
    }

    private void guardarArchivo() {
        try (PrintWriter pw = new PrintWriter(new FileWriter(archivo))) {
            for (Paciente p : pacientes) {
                pw.println(p.getId() + "|" + p.getNombre() + "|" + p.getEdad() + "|" + p.getDireccion());
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
                if (partes.length >= 4) {
                    Paciente p = new Paciente(
                            Integer.parseInt(partes[0]),
                            partes[1],
                            Integer.parseInt(partes[2]),
                            partes[3]);
                    pacientes.add(p);
                }
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
}
