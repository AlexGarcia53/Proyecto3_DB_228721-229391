/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Datos;

import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import dominio.Agente;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import org.bson.Document;

/**
 * Clase de acceso de datos para los agentes.
 *
 * @author Equipo 3
 */
class AgentesDAO implements IAgentesDAO {

    /**
     * Atributo para crear conexión a la base de datos.
     */
    private IConexionBD conexion;
    /**
     * Atributo para acceder a la base de datos.
     */
    private MongoDatabase baseDatos;
    /**
     * Atributo de tipo AgentesDAO.
     */
    private static AgentesDAO agentesDAO;

    /**
     * Constructor que inicia la conexión con la base de datos.
     */
    private AgentesDAO() {
        this.conexion = ConexionBD.obtenerConexion();
        this.baseDatos = this.conexion.crearConexion();
    }

    /**
     * Método utilizado para obtener a agentesDAO.
     *
     * @return atributo de tipo AgentesDAO
     */
    public static AgentesDAO obtenerAgentesDAO() {
        if (agentesDAO == null) {
            agentesDAO = new AgentesDAO();
        }
        return agentesDAO;
    }

    /**
     * Método para obtener la colección de agentes.
     *
     * @return Colección de agentes.
     */
    private MongoCollection<Agente> getColeccion() {
        return this.baseDatos.getCollection("Agentes", Agente.class);
    }

    /**
     * Método para consultar todos los registros de agente.
     *
     * @return lista con los registros de agente.
     */
    @Override
    public List<Agente> consultarTodos() {
        MongoCollection<Agente> coleccion = this.getColeccion();
        List<Agente> listaAgentes = new ArrayList<>();
        coleccion.find().into(listaAgentes);
        return listaAgentes;
    }

    /**
     * Método para obtener a un agente con base a su número de empleado.
     *
     * @param numEmpleado Número de empleado del agente.
     * @return agente a consultar.
     */
    @Override
    public Agente obtener(String numEmpleado) {
        MongoCollection<Agente> coleccion = this.getColeccion();
        List<Document> etapas = new LinkedList<Document>();
        etapas.add(new Document()
                .append("$match", new Document()
                        .append("numEmpleado", numEmpleado))
        );

        List<Agente> agentes = new LinkedList<>();
        coleccion.aggregate(etapas).into(agentes);
        if (agentes.size() > 0) {
            return agentes.get(0);
        }
        return null;
    }
}
