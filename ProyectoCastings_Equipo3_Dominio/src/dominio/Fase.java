/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dominio;

import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;
import java.util.Objects;
import org.bson.types.ObjectId;

/**
 * Clase que representa a la entidad Fase.
 *
 * @author Equipo 3
 */
public class Fase {

    /**
     * Identificador único de la fase.
     */
    private ObjectId id;
    /**
     * Número que tiene la fase.
     */
    private int noFase;
    /**
     * Fecha de inicio de la fase.
     */
    private Date fechaInicio;
    /**
     * Lista de puebas que contiene la fase.
     */
    private List<Prueba> listaPruebas;
    /**
     * Lista de castings que tiene la fase.
     */
    private List<Presencial> listaPresenciales;

    /**
     * Constructor vacío de fase.
     */
    public Fase() {
    }

    /**
     * Constructor que inicializa los atributos noFase y fechaInicio con valores
     * dados por los parámetros
     *
     * @param noFase Número que tiene la fase.
     * @param fechaInicio Fecha de inicio de la fase.
     */
    public Fase(int noFase, Date fechaInicio) {
        this.noFase = noFase;
        this.fechaInicio = fechaInicio;
    }

    /**
     * Constructor que inicializa los atributos noFase y fechaInicio con valores
     * dados por los parámetros
     *
     * @param id Identificador único de la fase.
     * @param noFase Número que tiene la fase.
     * @param fechaInicio Fecha de inicio de la fase.
     */
    public Fase(ObjectId id, int noFase, Date fechaInicio) {
        this.id = id;
        this.noFase = noFase;
        this.fechaInicio = fechaInicio;
    }

    /**
     * Constructor que inicializa los atributos con los valores dados por los
     * parámetros.
     *
     * @param noFase Número que tiene la fase.
     * @param fechaInicio Fecha de inicio de la fase.
     * @param listaPruebas Lista de puebas que contiene la fase.
     * @param listaPresenciales Lista de castings que tiene la fase.
     */
    public Fase(int noFase, Date fechaInicio, List<Prueba> listaPruebas, List<Presencial> listaPresenciales) {
        this.noFase = noFase;
        this.fechaInicio = fechaInicio;
        this.listaPruebas = listaPruebas;
        this.listaPresenciales = listaPresenciales;
    }

    /**
     * Método para obtener el identificador único de la fase.
     *
     * @return Identificador único de la fase.
     */
    public ObjectId getId() {
        return id;
    }

    /**
     * Método para establecer el identificador único de la fase.
     *
     * @param id Identificador único de la fase.
     */
    public void setId(ObjectId id) {
        this.id = id;
    }

    /**
     * Método para obtener el número que tiene la fase.
     *
     * @return Número que tiene la fase.
     */
    public int getNoFase() {
        return noFase;
    }

    /**
     * Método para establecer el número que tiene la fase.
     *
     * @param noFase Número que tiene la fase.
     */
    public void setNoFase(int noFase) {
        this.noFase = noFase;
    }

    /**
     * Método para obtener la fecha de inicio de la fase.
     *
     * @return Fecha de inicio de la fase.
     */
    public Date getFechaInicio() {
        return fechaInicio;
    }

    /**
     * Método para establecer la fecha de inicio de la fase.
     *
     * @param fechaInicio Fecha de inicio de la fase.
     */
    public void setFechaInicio(Date fechaInicio) {
        this.fechaInicio = fechaInicio;
    }

    /**
     * Método para obtener la lista de pruebas de la fase.
     *
     * @return Lista de puebas que contiene la fase.
     */
    public List<Prueba> getListaPruebas() {
        return listaPruebas;
    }

    /**
     * Método para establecer la lista de pruebas de la fase.
     *
     * @param listaPruebas Lista de puebas que contiene la fase.
     */
    public void setListaPruebas(List<Prueba> listaPruebas) {
        this.listaPruebas = listaPruebas;
    }

    /**
     * Método para obtener la lista de castings que tiene la fase.
     *
     * @return Lista de castings que tiene la fase.
     */
    public List<Presencial> getListaPresenciales() {
        return listaPresenciales;
    }

    /**
     * Método para establecer la lista de castings que tiene la fase.
     *
     * @param listaPresenciales Lista de castings que tiene la fase.
     */
    public void setListaPresenciales(List<Presencial> listaPresenciales) {
        this.listaPresenciales = listaPresenciales;
    }

    /**
     * Método para generar el identificador único de la fase.
     */
    public void generarId() {
        this.id = new ObjectId();
    }

    /**
     * Método hashCode.
     *
     * @return código hash.
     */
    @Override
    public int hashCode() {
        int hash = 7;
        hash = 89 * hash + Objects.hashCode(this.id);
        return hash;
    }

    /**
     * Método equals.
     *
     * @param obj objeto a evaluar.
     * @return falso o verdadero.
     */
    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Fase other = (Fase) obj;
        if (!Objects.equals(this.id, other.id)) {
            return false;
        }
        return true;
    }

    /**
     * Método que se encarga de regresar una cadena de texto con los datos de la
     * fase.
     *
     * @return Cadena de texto con atributos de la clase.
     */
    @Override
    public String toString() {
        return "Fase{" + "noFase=" + noFase + ", fechaInicio=" + fechaInicio + '}';
    }

}
