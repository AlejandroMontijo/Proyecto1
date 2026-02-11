package proyecto_1.entidades;

public class Consulta {

    private int id;
    private Paciente paciente;
    private Medico medico;
    private String fecha;

    public Consulta(int id, Paciente paciente, Medico medico, String fecha) throws Exception {
        if (id <= 0) {
            throw new Exception("El ID de la consulta debe ser positivo.");
        }
        if (paciente == null) {
            throw new Exception("El paciente no puede ser nulo.");
        }
        if (medico == null) {
            throw new Exception("El médico no puede ser nulo.");
        }
        if (fecha == null || fecha.trim().isEmpty()) {
            throw new Exception("La fecha de la consulta no puede estar vacía.");
        }
        this.id = id;
        this.paciente = paciente;
        this.medico = medico;
        this.fecha = fecha;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Paciente getPaciente() {
        return paciente;
    }

    public Medico getMedico() {
        return medico;
    }

    public String getFecha() {
        return fecha;
    }

    @Override
    public String toString() {
        String nomPac = paciente != null ? paciente.getNombre() : "Desconocido";
        String nomMed = medico != null ? medico.getNombre() : "Desconocido";
        return "ID: " + id + " | Paciente: " + nomPac + " | Médico: " + nomMed + " | Fecha: " + fecha;
    }
}
