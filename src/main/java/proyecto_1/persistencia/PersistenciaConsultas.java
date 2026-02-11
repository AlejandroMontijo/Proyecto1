package proyecto_1.persistencia;

import proyecto_1.entidades.Consulta;
import proyecto_1.entidades.Medico;
import proyecto_1.entidades.Paciente;
import java.io.*;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

public class PersistenciaConsultas {

    private ArrayList<Consulta> consultas = new ArrayList<>();
    private final String archivo = "consultas.txt";

    public PersistenciaConsultas() {
        cargarArchivo();
    }

    public void programarConsulta(Consulta consulta) {
        int nuevoId = consultas.isEmpty() ? 1 : consultas.get(consultas.size() - 1).getId() + 1;
        consulta.setId(nuevoId);
        consultas.add(consulta);
        guardarArchivo();
    }

    public List<Consulta> listarConsultas() {
        return new ArrayList<>(consultas);
    }

    // metodos adicionales para funcionalidad del spec

    public Consulta obtenerConsultaPorId(int id) {
        for (Consulta c : consultas) {
            if (c.getId() == id)
                return c;
        }
        return null;
    }

    public boolean cancelarConsulta(int id) {
        for (int i = 0; i < consultas.size(); i++) {
            if (consultas.get(i).getId() == id) {
                consultas.remove(i);
                guardarArchivo();
                return true;
            }
        }
        return false;
    }

    public List<Consulta> consultasPorPaciente(int idPaciente) {
        return consultas.stream()
                .filter(c -> c.getPaciente() != null && c.getPaciente().getId() == idPaciente)
                .collect(Collectors.toList());
    }

    public List<Consulta> consultasPorMedico(int idMedico) {
        return consultas.stream()
                .filter(c -> c.getMedico() != null && c.getMedico().getId() == idMedico)
                .collect(Collectors.toList());
    }

    public List<Consulta> consultasPorPeriodo(String desde, String hasta) {
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        sdf.setLenient(false);
        try {
            Date fechaDesde = sdf.parse(desde);
            Date fechaHasta = sdf.parse(hasta);
            return consultas.stream().filter(c -> {
                try {
                    Date fechaConsulta = sdf.parse(c.getFecha());
                    return (fechaConsulta.compareTo(fechaDesde) >= 0 && fechaConsulta.compareTo(fechaHasta) <= 0);
                } catch (Exception ex) {
                    return false;
                }
            }).collect(Collectors.toList());
        } catch (Exception ex) {
            ex.printStackTrace();
            return new ArrayList<>();
        }
    }

    private void guardarArchivo() {
        try (PrintWriter pw = new PrintWriter(new FileWriter(archivo))) {
            for (Consulta c : consultas) {
                int idPac = c.getPaciente() != null ? c.getPaciente().getId() : 0;
                int idMed = c.getMedico() != null ? c.getMedico().getId() : 0;
                pw.println(c.getId() + "|" + idPac + "|" + idMed + "|" + c.getFecha());
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
                    int idPac = Integer.parseInt(partes[1]);
                    int idMed = Integer.parseInt(partes[2]);
                    // crear objetos minimos, la fachada resuelve las referencias
                    Paciente pac = new Paciente(idPac, "", 0, "");
                    Medico med = new Medico(idMed, "", null);
                    Consulta c = new Consulta(
                            Integer.parseInt(partes[0]),
                            pac, med,
                            partes[3]);
                    consultas.add(c);
                }
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    // resolver referencias despues de cargar
    public void resolverReferencias(PersistenciaPacientes persPac, PersistenciaMedicos persMed) {
        for (int i = 0; i < consultas.size(); i++) {
            Consulta c = consultas.get(i);
            Paciente pacReal = persPac.obtenerPacientePorId(c.getPaciente().getId());
            Medico medReal = persMed.obtenerMedicoPorId(c.getMedico().getId());
            if (pacReal != null || medReal != null) {
                Consulta resuelta = new Consulta(
                        c.getId(),
                        pacReal != null ? pacReal : c.getPaciente(),
                        medReal != null ? medReal : c.getMedico(),
                        c.getFecha());
                consultas.set(i, resuelta);
            }
        }
    }
}
