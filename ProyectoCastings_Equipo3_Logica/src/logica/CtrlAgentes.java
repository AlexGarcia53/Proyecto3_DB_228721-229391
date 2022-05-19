/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package logica;

import Datos.FabricaDatos;
import Datos.IDatos;
import dominio.Agente;
import java.util.List;

/**
 * Clase control para agentes.
 *
 * @author Equipo 3
 */
class CtrlAgentes {

    /**
     * Atributo de IDatos.
     */
    private IDatos datos;
    /**
     * Atributo de CtrlAgentes.
     */
    private static CtrlAgentes ctrlAgentes;

    /**
     * Constructor que inicializa el atributo datos.
     */
    private CtrlAgentes() {
        datos = FabricaDatos.crearFachadaDatos();
    }

    /**
     * Método utilizado para obtener el atributo ctrlAgentes inicializado.
     *
     * @return atributo ctrlAgentes.
     */
    public static CtrlAgentes obtenerCtrlAgentes() {
        if (ctrlAgentes == null) {
            ctrlAgentes = new CtrlAgentes();
        }
        return ctrlAgentes;
    }

    /**
     * Método utilizado para obtener los agentes.
     *
     * @return todos los registros de agente.
     */
    public List<Agente> obtenerAgentes() {
        return datos.consultarTodosAgentes();
    }

    /**
     * Método utilizado para obtener los agentes por número de empleado.
     *
     * @param numEmpleado número de empleado.
     * @return registros de agente coincidentes.
     */
    public Agente obtener(String numEmpleado) {
        return datos.getAgente(numEmpleado);
    }
}
