/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Persistencias;

import Entidades.Consulta;
import Entidades.EquipoMedico;
import Entidades.Especialidad;
import Entidades.Medico;
import Entidades.Paciente;
import java.util.List;

/**
 *
 * @author abigomez
 */
public class PersistenciaFachada implements IPersistenciaFachada{
    
    private PersistenciaPacientes persistenciaPacientes;
    private PersistenciaMedicos persistenciaMedicos;
    private PersistenciaEspecialidades persistenciaEspecialidades;
    private PersistenciaInventarios persistenciaInventarios;
    private PersistenciaConsultas persistenciaConsultas;
    
    @Override
    public void agregarPaciente(Paciente paciente) throws Exception {
        persistenciaPacientes.agregarPaciente(paciente);
    }

    @Override
    public Paciente obtenerPacientePorId(int id) throws Exception {
        return persistenciaPacientes.obtenerPacientePorId(id);
    }

    @Override
    public List<Paciente> listarPacientes() throws Exception {
       return persistenciaPacientes.listarPacientes();
    }

    @Override
    public void agregarMedico(Medico medico) throws Exception {
        persistenciaMedicos.agregarMedico(medico);
    }

    @Override
    public Medico obtenerMedicoPorId(int id) throws Exception {
        return persistenciaMedicos.obtenerMedicoPorId(id);
    }

    @Override
    public List<Medico> listarMedicos() throws Exception {
        return persistenciaMedicos.listarMedicos();
    }

    @Override
    public void agregarEspecialidad(Especialidad especialidad) throws Exception {
        persistenciaEspecialidades.agregarEspecialidad(especialidad);
    }

    @Override
    public Especialidad obtenerEspecialidadPorId(int id) throws Exception {
        return persistenciaEspecialidades.obtenerEspecialidadPorId(id);
    }

    @Override
    public List<Especialidad> listarEspecialidades() throws Exception {
       return persistenciaEspecialidades.listarEspecialidades();
    }

    @Override
    public void agregarEquipoMedico(EquipoMedico equipoMedico) throws Exception {
       persistenciaInventarios.agregarEquipoMedico(equipoMedico);
    }

    @Override
    public void actualizarCantidadEquipo(int id, int cantidad) throws Exception {
       persistenciaInventarios.actualizarCantidadEquipo(id, cantidad);
    }

    @Override
    public List<EquipoMedico> listarEquiposMedicos() throws Exception {
       return persistenciaInventarios.listarEquiposMedicos();
    }

    @Override
    public void programarConsulta(Consulta consulta) throws Exception {
        persistenciaConsultas.programarConsulta(consulta);
    }

    @Override
    public List<Consulta> listarConsultas() throws Exception {
        return persistenciaConsultas.listarConsultas();
    }
    
}
