/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Persistencias;

import Entidades.Paciente;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author abigomez
 */
public class PersistenciaPacientes {
    private List<Paciente> pacientes;

    public PersistenciaPacientes(List<Paciente> pacientes) {
        this.pacientes = pacientes;
    }
    
    public void agregarPaciente(Paciente paciente){
        pacientes.add(paciente);
    }
    
    public Paciente obtenerPacientePorId(int id){
        for (Paciente p : pacientes) {
            if (p.getId() == id) {
                return p;
            }
        } 
        return null;
    }
    
    public List<Paciente> listarPacientes() {
        return new ArrayList<>(pacientes);
    }
    
}
