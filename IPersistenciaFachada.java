/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package Persistencias;

import Entidades.*;
import java.util.List;

/**
 *
 * @author abigomez
 */
public interface IPersistenciaFachada {
    //Pacientes
    public void agregarPaciente(Paciente paciente) throws Exception;
    public Paciente obtenerPacientePorId(int id) throws Exception;
    public List<Paciente> listarPacientes() throws Exception;
    
    //Medicos
    public void agregarMedico(Medico medico) throws Exception;
    public Medico obtenerMedicoPorId(int id) throws Exception;
    public List<Medico> listarMedicos() throws Exception;
    
    //Especialidades
    public void agregarEspecialidad(Especialidad especialidad) throws Exception;
    public Especialidad obtenerEspecialidadPorId(int id) throws Exception;
    public List<Especialidad> listarEspecialidades() throws Exception;
    
    //Equipo Medico
    public void agregarEquipoMedico(EquipoMedico equipoMedico) throws Exception;
    public void actualizarCantidadEquipo(int id, int cantidad) throws Exception;
    public List<EquipoMedico> listarEquiposMedicos() throws Exception;
    
    //Consultas
    public void programarConsulta(Consulta consulta) throws Exception;
    public List<Consulta> listarConsultas() throws Exception;
}
