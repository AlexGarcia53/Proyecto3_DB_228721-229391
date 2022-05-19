/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Datos;

import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import dominio.Cliente;
import java.util.LinkedList;
import java.util.List;
import org.bson.Document;

/**
 * Clase de acceso de datos para los clientes.
 *
 * @author Equipo 3
 */
class ClientesDAO implements IClientesDAO {

    /**
     * Atributo para crear conexión a la base de datos.
     */
    private IConexionBD conexion;
    /**
     * Atributo para acceder a la base de datos.
     */
    private MongoDatabase baseDatos;
    /**
     * Atributo de tipo ClientesDAO.
     */
    private static ClientesDAO clientesDAO;

    /**
     * Constructor que inicia la conexión con la base de datos.
     */
    private ClientesDAO() {
        this.conexion = ConexionBD.obtenerConexion();
        this.baseDatos = this.conexion.crearConexion();
    }

    /**
     * Método utilizado para obtener a clientesDAO.
     *
     * @return atributo de tipo ClientesDAO
     */
    public static ClientesDAO obtenerClientesDAO() {
        if (clientesDAO == null) {
            clientesDAO = new ClientesDAO();
        }
        return clientesDAO;
    }

    /**
     * Método para obtener la colección de clientes.
     *
     * @return Colección de clientes.
     */
    private MongoCollection<Cliente> getColeccion() {
        return this.baseDatos.getCollection("Clientes", Cliente.class);
    }

    /**
     * Método utilizado para obtener a un cliente.
     *
     * @param cliente cliente a obtener.
     * @return cliente obtenido.
     */
    @Override
    public Cliente obtener(Cliente cliente) {
        MongoCollection<Cliente> coleccion = this.getColeccion();
        List<Document> etapas = new LinkedList<Document>();
        etapas.add(new Document()
                .append("$match", new Document()
                        .append("_id", cliente.getId()))
        );

        List<Cliente> clientes = new LinkedList<>();
        coleccion.aggregate(etapas).into(clientes);
        if (clientes.size() > 0) {
            return clientes.get(0);
        }
        return null;
    }

    /**
     * Método para agregar a un cliente.
     *
     * @param cliente cliente a agregar.
     */
    @Override
    public void agregar(Cliente cliente) {
        MongoCollection<Cliente> coleccion = this.getColeccion();
        coleccion.insertOne(cliente);
    }

    /**
     * Método para consultar a todos los registros de la colección de clientes.
     *
     * @return lista con todos los registros de clientes.
     */
    @Override
    public List<Cliente> consultarTodos() {
        MongoCollection<Cliente> coleccion = this.getColeccion();
        List<Cliente> listaClientes = new LinkedList<>();
        coleccion.find().into(listaClientes);
        return listaClientes;
    }

    /**
     * Método utilizado para obtener a un cliente en base a su código.
     *
     * @param codigoCliente código del cliente.
     * @return registro de cliente.
     */
    @Override
    public Cliente obtener(String codigoCliente) {
        MongoCollection<Cliente> coleccion = this.getColeccion();
        List<Document> etapas = new LinkedList<Document>();
        etapas.add(new Document()
                .append("$match", new Document()
                        .append("codigoCliente", codigoCliente))
        );

        List<Cliente> clientes = new LinkedList<>();
        coleccion.aggregate(etapas).into(clientes);
        if (clientes.size() > 0) {
            return clientes.get(0);
        }
        return null;
    }

}
