/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package logica;

import Datos.FabricaDatos;
import Datos.IDatos;
import Excepciones.CastingExistenteException;
import Excepciones.PerfilExistenteException;
import dominio.Perfil;
import dominio.Presencial;
import java.util.Date;
import java.util.List;

/**
 * Clase control para castings.
 *
 * @author Equipo 3
 */
class CtrlCastings {

    /**
     * Atributo de IDatos.
     */
    private IDatos datos;
    /**
     * Atributo de CtrlCastings.
     */
    private static CtrlCastings ctrlCastings;

    /**
     * Constructor que inicializa el atributo datos.
     */
    private CtrlCastings() {
        datos = FabricaDatos.crearFachadaDatos();
    }

    /**
     * Método utilizado para obtener el atributo ctrlCastings inicializado.
     *
     * @return atributo ctrlCastings.
     */
    public static CtrlCastings obtenerCtrlCastings() {
        if (ctrlCastings == null) {
            ctrlCastings = new CtrlCastings();
        }
        return ctrlCastings;
    }

    /**
     * Método utilizado registrar un casting.
     *
     * @param casting casting a registrar.
     */
    public void registrar(Presencial casting) {
        if (datos.consultarCastingCodigo(casting.getCodigoCasting()) != null) {
            throw new CastingExistenteException("No se puede registrar ya que existe un casting con ese código");
        }
        if (datos.consultarCastingNombre(casting.getNombre()) != null) {
            throw new CastingExistenteException("No se puede registrar ya que existe un casting con ese nombre");
        }
        datos.agregarCasting(casting);
    }

    /**
     * Método utilizado para obtener casting por fecha.
     *
     * @param fecha fecha a consultar.
     * @return casting coincidente.
     */
    public List<Presencial> obtenerFecha(Date fecha) {
        return datos.consultarCastingFecha(fecha);
    }

    /**
     * Método utilizado para consultar casting por código.
     *
     * @param codigo código a consultar.
     * @return casting coincidente.
     */
    public Presencial obtenerCodigo(String codigo) {
        return datos.consultarCastingCodigo(codigo);
    }

    /**
     * Método utilizado para consultar casting por nombre.
     *
     * @param codigo nombre a consultar.
     * @return casting coincidente.
     */
    public Presencial obtenerNombre(String nombre) {
        return datos.consultarCastingNombre(nombre);
    }

    /**
     * Método utilizado para consultar casting por fecha y código.
     *
     * @param fecha fecha a consultar.
     * @param codigo código a consultar.
     * @return casting coincidente.
     */
    public List<Presencial> obtenerFechaCodigo(Date fecha, String codigo) {
        return datos.consultarCastingFechaCodigo(fecha, codigo);
    }

    /**
     * Método utilizado para consultar casting por fecha y nombre.
     *
     * @param fecha fecha a consultar.
     * @param nombre nombre a consultar.
     * @return casting coincidente.
     */
    public List<Presencial> obtenerFechaNombre(Date fecha, String nombre) {
        return datos.consultarCastingFechaNombre(fecha, nombre);
    }

    /**
     * Método utilizado para consultar casting por código y nombre.
     *
     * @param codigo código a consultar.
     * @param nombre nombre a consultar.
     * @return casting coincidente.
     */
    public List<Presencial> obtenerCodigoNombre(String codigo, String nombre) {
        return datos.consultarCastingCodigoNombre(codigo, nombre);
    }

    /**
     * Método utilizado para consultar casting por fecha, código y nombre.
     *
     * @param fecha fecha a consultar.
     * @param codigo código a consultar.
     * @param nombre nombre a consultar.
     * @return casting coincidente.
     */
    public List<Presencial> obtenerFechaCodigoNombre(Date fecha, String codigo, String nombre) {
        return datos.consultarCastingFechaCodigoNombre(fecha, codigo, nombre);
    }

    /**
     * Método para obtener todos los castings.
     *
     * @return todos los castings.
     */
    public List<Presencial> obtenerTodos() {
        return datos.consultarTodosCastings();
    }

    /**
     * Método utilizado para agregar un perfil a un casting.
     *
     * @param presencial casting.
     * @param perfil perfil a agregar.
     */
    public void agregarPefilACasting(Presencial presencial, Perfil perfil) {
        Presencial presencialVerficacion = datos.verificarExistenciaCampoPerfil(presencial.getCodigoCasting());
        if (presencialVerficacion == null) {
            datos.agregarCampoPerfil(presencial.getCodigoCasting());
        }
        if (datos.verificarPerfilExistente(presencial.getCodigoCasting(), perfil.getCodigoPerfil()) != null) {
            throw new PerfilExistenteException("Ya existe un perfil igual en el casting");
        }
        datos.agregarPerfil(presencial, perfil);
    }
}
