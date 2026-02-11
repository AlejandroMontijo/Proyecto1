package proyecto_1.persistencia;

import proyecto_1.entidades.Paciente;
import proyecto_1.entidades.Consulta;
import proyecto_1.entidades.Medico;
import proyecto_1.entidades.EquipoMedico;
import proyecto_1.entidades.Especialidad;
import java.util.List;

public interface IPersistenciaFachada {

    void agregarPaciente(Paciente paciente);

    Paciente obtenerPacientePorId(int id);

    List<Paciente> listarPacientes();

    void agregarMedico(Medico medico);

    Medico obtenerMedicoPorId(int id);

    List<Medico> listarMedicos();

    void agregarEspecialidad(Especialidad especialidad);

    Especialidad obtenerEspecialidadPorId(int id);

    List<Especialidad> listarEspecialidades();

    void agregarEquipoMedico(EquipoMedico equipo);

    void actualizarCantidadEquipo(int id, int cantidad);

    List<EquipoMedico> listarEquiposMedicos();

    void programarConsulta(Consulta consulta);

    List<Consulta> listarConsultas();
}
