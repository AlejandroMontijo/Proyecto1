/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Persistencias;

import Entidades.Consulta;
import Entidades.EquipoMedico;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author abigomez
 */
public class PersistenciaConsultas {
    private List<Consulta> consultas;

    public PersistenciaConsultas(List<Consulta> consultas) {
        this.consultas = consultas;
    }
    
    public void programarConsulta(Consulta consulta) throws Exception{
       consultas.add(consulta);
    }
    
    public List<Consulta> listarConsultas() {
        return new ArrayList<>(consultas);
    }
}
