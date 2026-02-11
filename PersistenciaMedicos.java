/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Persistencias;

import Entidades.Medico;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author abigomez
 */
public class PersistenciaMedicos {
    private List<Medico> medicos;

    public PersistenciaMedicos(List<Medico> medicos) {
        this.medicos = medicos;
    }
    
    public void agregarMedico(Medico medico){
        medicos.add(medico);
    }
    
    public Medico obtenerMedicoPorId(int id){
        for (Medico m : medicos) {
            if (m.getId() == id) {
                return m;
            }
        } 
        return null;
    }
    
    public List<Medico> listarMedicos() {
        return new ArrayList<>(medicos);
    }
    
    
}
