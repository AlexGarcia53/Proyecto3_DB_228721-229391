/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Datos;

import dominio.Agente;
import dominio.Cliente;
import dominio.Perfil;
import dominio.Presencial;
import java.util.Date;
import java.util.List;

/**
 * Clase fachada que implementa la interfaz IDatos.
 *
 * @author Equipo 3
 */
class FachadaDatos implements IDatos {

    /**
     * Atributo de tipo IClientesDAO.
     */
    private IClientesDAO clientesDAO;
    /**
     * Atributo de tipo IAgentesDAO.
     */
    private IAgentesDAO agentesDAO;
    /**
     * Atributo de tipo ICastingsDAO.
     */
    private ICastingsDAO castingsDAO;

    /**
     * Constructor que inicializa los atributos de la clase.
     */
    public FachadaDatos() {

        clientesDAO = ClientesDAO.obtenerClientesDAO();
        agentesDAO = AgentesDAO.obtenerAgentesDAO();
        castingsDAO = CastingsDAO.obtenerCastingsDAO();
    }

    /**
     * Método para obtener un cliente.
     *
     * @param cliente a obtener.
     * @return cliente a obtener.
     */
    @Override
    public Cliente getCliente(Cliente cliente) {
        return clientesDAO.obtener(cliente);
    }

    /**
     * Método para agregar un cliente.
     *
     * @param cliente cliente a agregar.
     */
    @Override
    public void agregarCliente(Cliente cliente) {
        clientesDAO.agregar(cliente);
    }

    /**
     * Método para consultar todos los clientes.
     *
     * @return todos los clientes.
     */
    @Override
    public List<Cliente> consultarTodosClientes() {
        return clientesDAO.consultarTodos();
    }

    /**
     * Método para consultar todos los agentes.
     *
     * @return todos los agentes.
     */
    @Override
    public List<Agente> consultarTodosAgentes() {
        return agentesDAO.consultarTodos();
    }

    /**
     * Método para obtener un cliente en base a su código.
     *
     * @param codigoCliente código del cliente.
     * @return cliente coincidente.
     */
    @Override
    public Cliente getCliente(String codigoCliente) {
        return clientesDAO.obtener(codigoCliente);
    }

    /**
     * Método para obtener un agente en base a su número de empleado.
     *
     * @param numEmpleado número de empleado.
     * @return agente coincidente.
     */
    @Override
    public Agente getAgente(String numEmpleado) {
        return agentesDAO.obtener(numEmpleado);
    }

    /**
     * Método para agregar un casting.
     *
     * @param casting casting a agregar.
     */
    @Override
    public void agregarCasting(Presencial casting) {
        castingsDAO.agregar(casting);
    }

    /**
     * Método para consultar castings por fecha.
     *
     * @param fecha fecha de contratación.
     * @return castings coincidentes.
     */
    @Override
    public List<Presencial> consultarCastingFecha(Date fecha) {
        return castingsDAO.consultarFecha(fecha);
    }

    /**
     * Método para consultar castings por código.
     *
     * @param codigo código de casting.
     * @return castings coincidentes.
     */
    @Override
    public Presencial consultarCastingCodigo(String codigo) {
        return castingsDAO.consultarCodigo(codigo);
    }

    /**
     * Método para consultar castings por nombre.
     *
     * @param nombre nombre del casting.
     * @return castings coincidentes.
     */
    @Override
    public Presencial consultarCastingNombre(String nombre) {
        return castingsDAO.consultarNombre(nombre);
    }

    /**
     * Método para consultar castings por fecha y código.
     *
     * @param fecha fecha de contratación.
     * @param codigo código de casting.
     * @return castings coincidentes.
     */
    @Override
    public List<Presencial> consultarCastingFechaCodigo(Date fecha, String codigo) {
        return castingsDAO.consultarFechaCodigo(fecha, codigo);
    }

    /**
     * Método para consultar castings por fecha y nombre.
     *
     * @param fecha fecha de contratación.
     * @param nombre nombre de casting.
     * @return castings coincidentes.
     */
    @Override
    public List<Presencial> consultarCastingFechaNombre(Date fecha, String nombre) {
        return castingsDAO.consultarFechaNombre(fecha, nombre);
    }

    /**
     * Método para consultar casting por código y nombre.
     *
     * @param codigo código de casting.
     * @param nombre nombre de casting.
     * @return castings coincidentes.
     */
    @Override
    public List<Presencial> consultarCastingCodigoNombre(String codigo, String nombre) {
        return castingsDAO.consultarCodigoNombre(codigo, nombre);
    }

    /**
     * Método para consultar casting por código, nombre y fecha.
     *
     * @param fecha fecha de contratación.
     * @param codigo código de casting.
     * @param nombre nombre de casting.
     * @return castings coincidentes.
     */
    @Override
    public List<Presencial> consultarCastingFechaCodigoNombre(Date fecha, String codigo, String nombre) {
        return castingsDAO.consultarFechaCodigoNombre(fecha, codigo, nombre);
    }

    /**
     * Método para consultar todos los castings.
     *
     * @return todos los castings.
     */
    @Override
    public List<Presencial> consultarTodosCastings() {
        return castingsDAO.consultarTodos();
    }

    /**
     * Método para agregar perfil a casting.
     *
     * @param presencial casting.
     * @param perfil perfil a agregar.
     */
    @Override
    public void agregarPerfil(Presencial presencial, Perfil perfil) {
        this.castingsDAO.agregarPerfil(presencial, perfil);
    }

    /**
     * Método para verificar la existencia del campo perfil.
     *
     * @param codigo código del casting.
     * @return registro casting.
     */
    @Override
    public Presencial verificarExistenciaCampoPerfil(String codigo) {
        return castingsDAO.verificarExistenciaCampoPerfil(codigo);
    }

    /**
     * Método para agregar el campo perfil.
     *
     * @param codigo código de casting.
     */
    @Override
    public void agregarCampoPerfil(String codigo) {
        this.castingsDAO.agregarCampoPerfil(codigo);
    }

    /**
     * Método para verificar la existencia de un mismo perfil.
     *
     * @param codigoCasting código del casting.
     * @param codigoPerfil código del perfil.
     * @return registro de casting.
     */
    @Override
    public Presencial verificarPerfilExistente(String codigoCasting, String codigoPerfil) {
        return castingsDAO.verificarPerfilExistente(codigoCasting, codigoPerfil);
    }
}
