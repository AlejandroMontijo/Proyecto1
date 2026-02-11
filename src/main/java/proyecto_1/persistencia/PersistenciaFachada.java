package proyecto_1.persistencia;

import proyecto_1.entidades.Paciente;
import proyecto_1.entidades.Consulta;
import proyecto_1.entidades.Medico;
import proyecto_1.entidades.EquipoMedico;
import proyecto_1.entidades.Especialidad;
import java.util.List;

public class PersistenciaFachada implements IPersistenciaFachada {

    private PersistenciaPacientes persistenciaPacientes;
    private PersistenciaMedicos persistenciaMedicos;
    private PersistenciaEspecialidades persistenciaEspecialidades;
    private PersistenciaInventarios persistenciaInventarios;
    private PersistenciaConsultas persistenciaConsultas;

    public PersistenciaFachada() {
        persistenciaEspecialidades = new PersistenciaEspecialidades();
        persistenciaPacientes = new PersistenciaPacientes();
        persistenciaMedicos = new PersistenciaMedicos();
        persistenciaInventarios = new PersistenciaInventarios();
        persistenciaConsultas = new PersistenciaConsultas();

        // resolver referencias despues de cargar todo
        persistenciaMedicos.resolverEspecialidades(persistenciaEspecialidades);
        persistenciaConsultas.resolverReferencias(persistenciaPacientes, persistenciaMedicos);
    }

    // --- Pacientes (diagrama) ---

    @Override
    public void agregarPaciente(Paciente paciente) {
        persistenciaPacientes.agregarPaciente(paciente);
    }

    @Override
    public Paciente obtenerPacientePorId(int id) {
        return persistenciaPacientes.obtenerPacientePorId(id);
    }

    @Override
    public List<Paciente> listarPacientes() {
        return persistenciaPacientes.listarPacientes();
    }

    // metodos extra para funcionalidad del spec
    public boolean actualizarPaciente(Paciente paciente) {
        return persistenciaPacientes.actualizarPaciente(paciente);
    }

    public boolean eliminarPaciente(int id) {
        return persistenciaPacientes.eliminarPaciente(id);
    }

    public List<Paciente> filtrarPacientesPorDireccion(String direccion) {
        return persistenciaPacientes.filtrarPorDireccion(direccion);
    }

    public List<Paciente> filtrarPacientesPorEdad(int min, int max) {
        return persistenciaPacientes.filtrarPorEdad(min, max);
    }

    public List<Paciente> filtrarPacientesCombinado(String direccion, int min, int max) {
        return persistenciaPacientes.filtrarCombinado(direccion, min, max);
    }

    // --- Medicos (diagrama) ---

    @Override
    public void agregarMedico(Medico medico) {
        persistenciaMedicos.agregarMedico(medico);
    }

    @Override
    public Medico obtenerMedicoPorId(int id) {
        return persistenciaMedicos.obtenerMedicoPorId(id);
    }

    @Override
    public List<Medico> listarMedicos() {
        return persistenciaMedicos.listarMedicos();
    }

    // --- Especialidades (diagrama) ---

    @Override
    public void agregarEspecialidad(Especialidad especialidad) {
        persistenciaEspecialidades.agregarEspecialidad(especialidad);
    }

    @Override
    public Especialidad obtenerEspecialidadPorId(int id) {
        return persistenciaEspecialidades.obtenerEspecialidadPorId(id);
    }

    @Override
    public List<Especialidad> listarEspecialidades() {
        return persistenciaEspecialidades.listarEspecialidades();
    }

    public Especialidad obtenerEspecialidadPorNombre(String nombre) {
        return persistenciaEspecialidades.obtenerPorNombre(nombre);
    }

    // --- Inventario (diagrama) ---

    @Override
    public void agregarEquipoMedico(EquipoMedico equipo) {
        persistenciaInventarios.agregarEquipoMedico(equipo);
    }

    @Override
    public void actualizarCantidadEquipo(int id, int cantidad) {
        persistenciaInventarios.actualizarCantidadEquipo(id, cantidad);
    }

    @Override
    public List<EquipoMedico> listarEquiposMedicos() {
        return persistenciaInventarios.listarEquiposMedicos();
    }

    public EquipoMedico obtenerEquipoPorId(int id) {
        return persistenciaInventarios.obtenerEquipoPorId(id);
    }

    // --- Consultas (diagrama) ---

    @Override
    public void programarConsulta(Consulta consulta) {
        persistenciaConsultas.programarConsulta(consulta);
    }

    @Override
    public List<Consulta> listarConsultas() {
        return persistenciaConsultas.listarConsultas();
    }

    // metodos extra para funcionalidad del spec
    public Consulta obtenerConsultaPorId(int id) {
        return persistenciaConsultas.obtenerConsultaPorId(id);
    }

    public boolean cancelarConsulta(int id) {
        return persistenciaConsultas.cancelarConsulta(id);
    }

    public List<Consulta> consultasPorPaciente(int idPaciente) {
        return persistenciaConsultas.consultasPorPaciente(idPaciente);
    }

    public List<Consulta> consultasPorMedico(int idMedico) {
        return persistenciaConsultas.consultasPorMedico(idMedico);
    }

    public List<Consulta> consultasPorPeriodo(String desde, String hasta) {
        return persistenciaConsultas.consultasPorPeriodo(desde, hasta);
    }
}
