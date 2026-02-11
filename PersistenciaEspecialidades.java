/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Persistencias;

import Entidades.Especialidad;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author abigomez
 */
public class PersistenciaEspecialidades {
    private List<Especialidad> especialidades;
    
    public PersistenciaEspecialidades(List<Especialidad> especialidades) {
        this.especialidades = especialidades;
    }
    
    public void agregarEspecialidad(Especialidad especialidad){
        especialidades.add(especialidad);
    }
    
    public Especialidad obtenerEspecialidadPorId(int id){
        for (Especialidad e : especialidades) {
            if (e.getId() == id) {
                return e;
            }
        } 
        return null;
    }
    
    public List<Especialidad> listarEspecialidades() {
        return new ArrayList<>(especialidades);
    }
    
}
