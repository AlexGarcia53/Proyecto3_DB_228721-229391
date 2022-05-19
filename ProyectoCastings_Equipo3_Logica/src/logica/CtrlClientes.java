/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package logica;

import Datos.FabricaDatos;
import Datos.IDatos;
import Excepciones.ClienteExistenteException;
import dominio.Cliente;
import java.util.List;

/**
 * Clase control para clientes.
 *
 * @author Equipo 3
 */
class CtrlClientes {

    /**
     * Atributo de IDatos.
     */
    private IDatos datos;
    /**
     * Atributo de CtrlClientes.
     */
    private static CtrlClientes ctrlClientes;

    /**
     * Constructor que inicializa el atributo datos.
     */
    private CtrlClientes() {
        datos = FabricaDatos.crearFachadaDatos();
    }

    /**
     * Método utilizado para obtener el atributo ctrlClientes inicializado.
     *
     * @return atributo ctrlClientes.
     */
    public static CtrlClientes crearCtrlClientes() {
        if (ctrlClientes == null) {
            ctrlClientes = new CtrlClientes();
        }
        return ctrlClientes;
    }

    /**
     * Método utilizado registrar un cliente.
     *
     * @param cliente cliente a registrar.
     */
    public void registrar(Cliente cliente) {
        Cliente clienteExistente = datos.getCliente(cliente);
        if (clienteExistente != null) {
            throw new ClienteExistenteException("El cliente ya existe en la base de datos");
        }
        datos.agregarCliente(cliente);
    }

    /**
     * Método utilizado para obtener a todos los clientes.
     *
     * @return registros de cliente.
     */
    public List<Cliente> obtenerClientes() {
        return datos.consultarTodosClientes();
    }

    /**
     * Método utilizado para obtener a un cliente en base a su código.
     *
     * @param codigoCliente código de cliente.
     * @return cliente coincidente.
     */
    public Cliente obtener(String codigoCliente) {
        return datos.getCliente(codigoCliente);
    }
}
