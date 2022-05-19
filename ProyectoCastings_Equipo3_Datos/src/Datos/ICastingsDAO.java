/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Datos;

import dominio.Perfil;
import dominio.Presencial;
import java.util.Date;
import java.util.List;

/**
 * Interfaz implementada por CastingsDAO.
 *
 * @author Equipo 3
 */
interface ICastingsDAO {

    public void agregar(Presencial casting);

    public List<Presencial> consultarFecha(Date fecha);

    public Presencial consultarCodigo(String codigo);

    public Presencial consultarNombre(String nombre);

    public List<Presencial> consultarFechaCodigo(Date fecha, String codigo);

    public List<Presencial> consultarFechaNombre(Date fecha, String nombre);

    public List<Presencial> consultarCodigoNombre(String codigo, String nombre);

    public List<Presencial> consultarFechaCodigoNombre(Date fecha, String codigo, String nombre);

    public List<Presencial> consultarTodos();

    public List<Presencial> consultarVigentes(Date fecha);

    public void agregarPerfil(Presencial presencial, Perfil perfil);

    public Presencial verificarExistenciaCampoPerfil(String codigo);

    public void agregarCampoPerfil(String codigo);

    public Presencial verificarPerfilExistente(String codigoCasting, String codigoPerfil);
}
