/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package logica;

import Datos.FabricaDatos;
import Datos.IDatos;
import dominio.Agente;
import dominio.Cliente;
import dominio.Perfil;
import dominio.Presencial;
import java.util.Date;
import java.util.List;

/**
 * Clase fachada que implementa la interfaz ILogica.
 *
 * @author Equipo 3
 */
class FachadaLogica implements ILogica {

    /**
     * Atributo de tipo ctrlClientes.
     */
    private CtrlClientes ctrlClientes;
    /**
     * Atributo de tipo ctrlAgentes.
     */
    private CtrlAgentes ctrlAgentes;
    /**
     * Atributo de tipo ctrlCastings.
     */
    private CtrlCastings ctrlCastings;

    /**
     * Constructor que inicializa los atributos de la clase.
     */
    public FachadaLogica() {
        ctrlClientes = CtrlClientes.crearCtrlClientes();
        ctrlAgentes = CtrlAgentes.obtenerCtrlAgentes();
        ctrlCastings = CtrlCastings.obtenerCtrlCastings();
    }

    /**
     * Método utilizado registrar un cliente.
     *
     * @param cliente cliente a registrar.
     */
    @Override
    public void registrarCliente(Cliente cliente) {
        this.ctrlClientes.registrar(cliente);
    }

    /**
     * Método utilizado para obtener a todos los clientes.
     *
     * @return registros de cliente.
     */
    @Override
    public List<Cliente> obtenerClientes() {
        return this.ctrlClientes.obtenerClientes();
    }

    /**
     * Método utilizado para obtener los agentes.
     *
     * @return todos los registros de agente.
     */
    @Override
    public List<Agente> obtenerAgentes() {
        return this.ctrlAgentes.obtenerAgentes();
    }

    /**
     * Método utilizado para obtener a un cliente en base a su código.
     *
     * @param codigoCliente código de cliente.
     * @return cliente coincidente.
     */
    @Override
    public Cliente obtenerCliente(String codigoCliente) {
        return this.ctrlClientes.obtener(codigoCliente);
    }

    /**
     * Método utilizado para obtener los agentes por número de empleado.
     *
     * @param numEmpleado número de empleado.
     * @return registros de agente coincidentes.
     */
    @Override
    public Agente obtenerAgente(String numEmpleado) {
        return this.ctrlAgentes.obtener(numEmpleado);
    }

    /**
     * Método utilizado registrar un cliente.
     *
     * @param cliente cliente a registrar.
     */
    @Override
    public void registrarCasting(Presencial casting) {
        this.ctrlCastings.registrar(casting);
    }

    /**
     * Método utilizado para obtener casting por fecha.
     *
     * @param fecha fecha a consultar.
     * @return casting coincidente.
     */
    @Override
    public List<Presencial> obtenerCastingFecha(Date fecha) {
        return this.ctrlCastings.obtenerFecha(fecha);
    }

    /**
     * Método utilizado para consultar casting por código.
     *
     * @param codigo código a consultar.
     * @return casting coincidente.
     */
    @Override
    public Presencial obtenerCastingCodigo(String codigo) {
        return this.ctrlCastings.obtenerCodigo(codigo);
    }

    /**
     * Método utilizado para consultar casting por nombre.
     *
     * @param codigo nombre a consultar.
     * @return casting coincidente.
     */
    @Override
    public Presencial obtenerCastingNombre(String nombre) {
        return this.ctrlCastings.obtenerNombre(nombre);
    }

    /**
     * Método utilizado para consultar casting por fecha y código.
     *
     * @param fecha fecha a consultar.
     * @param codigo código a consultar.
     * @return casting coincidente.
     */
    @Override
    public List<Presencial> obtenerCastingFechaCodigo(Date fecha, String codigo) {
        return this.ctrlCastings.obtenerFechaCodigo(fecha, codigo);
    }

    /**
     * Método utilizado para consultar casting por fecha y nombre.
     *
     * @param fecha fecha a consultar.
     * @param nombre nombre a consultar.
     * @return casting coincidente.
     */
    @Override
    public List<Presencial> obtenerCastingFechaNombre(Date fecha, String nombre) {
        return this.ctrlCastings.obtenerFechaNombre(fecha, nombre);
    }

    /**
     * Método utilizado para consultar casting por código y nombre.
     *
     * @param codigo código a consultar.
     * @param nombre nombre a consultar.
     * @return casting coincidente.
     */
    @Override
    public List<Presencial> obtenerCastingCodigoNombre(String codigo, String nombre) {
        return this.ctrlCastings.obtenerCodigoNombre(codigo, nombre);
    }

    /**
     * Método utilizado para consultar casting por fecha, código y nombre.
     *
     * @param fecha fecha a consultar.
     * @param codigo código a consultar.
     * @param nombre nombre a consultar.
     * @return casting coincidente.
     */
    @Override
    public List<Presencial> obtenerCastingFechaCodigoNombre(Date fecha, String codigo, String nombre) {
        return this.ctrlCastings.obtenerFechaCodigoNombre(fecha, codigo, nombre);
    }

    /**
     * Método para obtener todos los castings.
     *
     * @return todos los castings.
     */
    @Override
    public List<Presencial> obtenerTodosCastings() {
        return this.ctrlCastings.obtenerTodos();
    }

    /**
     * Método utilizado para agregar un perfil a un casting.
     *
     * @param presencial casting.
     * @param perfil perfil a agregar.
     */
    @Override
    public void agregarPerfilACasting(Presencial presencial, Perfil perfil) {
        this.ctrlCastings.agregarPefilACasting(presencial, perfil);
    }

}
