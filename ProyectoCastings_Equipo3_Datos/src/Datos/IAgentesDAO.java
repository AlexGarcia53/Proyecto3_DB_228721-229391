/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Datos;

import dominio.Agente;
import java.util.List;

/**
 * Interfaz implementada por AgentesDAO
 *
 * @author Equipo 3
 */
interface IAgentesDAO {

    public Agente obtener(String numEmpleado);

    public List<Agente> consultarTodos();
}
