package proyecto_1.entidades;

public class Consulta {

    private int id;
    private Paciente paciente;
    private Medico medico;
    private String fecha;

    public Consulta(int id, Paciente paciente, Medico medico, String fecha) {



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
