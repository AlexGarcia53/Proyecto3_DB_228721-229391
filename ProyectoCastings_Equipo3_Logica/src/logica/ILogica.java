/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package logica;

import dominio.Agente;
import dominio.Cliente;
import dominio.Perfil;
import dominio.Presencial;
import java.util.Date;
import java.util.List;

/**
 * Interfaz implementada por FachadaLogica.
 *
 * @author Equipo 3
 */
public interface ILogica {

    public void registrarCliente(Cliente cliente);

    public List<Cliente> obtenerClientes();

    public List<Agente> obtenerAgentes();

    public Cliente obtenerCliente(String codigoCliente);

    public Agente obtenerAgente(String numEmpleado);

    public void registrarCasting(Presencial casting);

    public List<Presencial> obtenerCastingFecha(Date fecha);

    public Presencial obtenerCastingCodigo(String codigo);

    public Presencial obtenerCastingNombre(String nombre);

    public List<Presencial> obtenerCastingFechaCodigo(Date fecha, String codigo);

    public List<Presencial> obtenerCastingFechaNombre(Date fecha, String nombre);

    public List<Presencial> obtenerCastingCodigoNombre(String codigo, String nombre);

    public List<Presencial> obtenerCastingFechaCodigoNombre(Date fecha, String codigo, String nombre);

    public List<Presencial> obtenerTodosCastings();

    public void agregarPerfilACasting(Presencial presencial, Perfil perfil);
}
