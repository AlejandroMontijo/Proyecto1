/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Persistencias;

import Entidades.EquipoMedico;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author abigomez
 */
public class PersistenciaInventarios {
    private List<EquipoMedico> inventarios;
    
    public PersistenciaInventarios(List<EquipoMedico> equipo) {
        this.inventarios = equipo;
    }
    
    public void agregarEquipoMedico(EquipoMedico equipo){
        inventarios.add(equipo);
    }
    
    public void actualizarCantidadEquipo(int id, int cantidad){
        for (EquipoMedico equipo : inventarios) {
            if (equipo.getId() == id) {
                equipo.setCantidad(cantidad);
            }
        } 
    }
    
    public List<EquipoMedico> listarEquiposMedicos() {
        return new ArrayList<>(inventarios);
    }
}
