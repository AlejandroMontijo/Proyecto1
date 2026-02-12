package proyecto_1.persistencia;

import proyecto_1.entidades.Consulta;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

public class PersistenciaConsultas {

    private ArrayList<Consulta> consultas = new ArrayList<>();

    public PersistenciaConsultas() {
    }

    public void programarConsulta(Consulta consulta) {
        int nuevoId = consultas.isEmpty() ? 1 : consultas.get(consultas.size() - 1).getId() + 1;
        consulta.setId(nuevoId);
        consultas.add(consulta);
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
}
