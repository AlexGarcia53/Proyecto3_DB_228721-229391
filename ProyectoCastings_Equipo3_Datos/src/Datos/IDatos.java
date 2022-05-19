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
 * Interfaz implementada por FachadaDatos.
 *
 * @author Equipo 3
 */
public interface IDatos {

    public Cliente getCliente(Cliente cliente);

    public Cliente getCliente(String codigoCliente);

    public Agente getAgente(String numEmpleado);

    public void agregarCliente(Cliente cliente);

    public List<Cliente> consultarTodosClientes();

    public List<Agente> consultarTodosAgentes();

    public void agregarCasting(Presencial casting);

    public List<Presencial> consultarCastingFecha(Date fecha);

    public Presencial consultarCastingCodigo(String codigo);

    public Presencial consultarCastingNombre(String nombre);

    public List<Presencial> consultarCastingFechaCodigo(Date fecha, String codigo);

    public List<Presencial> consultarCastingFechaNombre(Date fecha, String nombre);

    public List<Presencial> consultarCastingCodigoNombre(String codigo, String nombre);

    public List<Presencial> consultarCastingFechaCodigoNombre(Date fecha, String codigo, String nombre);

    public List<Presencial> consultarTodosCastings();

    public void agregarPerfil(Presencial presencial, Perfil perfil);

    public Presencial verificarExistenciaCampoPerfil(String codigo);

    public void agregarCampoPerfil(String codigo);

    public Presencial verificarPerfilExistente(String codigoCasting, String codigoPerfil);
}
