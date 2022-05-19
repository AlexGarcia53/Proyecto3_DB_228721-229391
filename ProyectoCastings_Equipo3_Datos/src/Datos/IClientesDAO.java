/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Datos;

import dominio.Cliente;
import java.util.List;

/**
 * Interfaz implementada por ClientesDAO.
 *
 * @author Equipo 3
 */
interface IClientesDAO {

    public Cliente obtener(Cliente cliente);

    public Cliente obtener(String codigoCliente);

    public void agregar(Cliente cliente);

    public List<Cliente> consultarTodos();
}
