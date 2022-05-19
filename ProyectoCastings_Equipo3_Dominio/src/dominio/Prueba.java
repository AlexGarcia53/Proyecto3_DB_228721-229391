/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dominio;

import java.util.Date;
import java.util.List;

/**
 * Clase que representa a la entidad Prueba.
 *
 * @author Equipo 3
 */
public class Prueba {

    /**
     * Número de prueba.
     */
    private int noPrueba;
    /**
     * Fecha de la prueba.
     */
    private Date fecha;
    /**
     * Sala de celebración de la prueba.
     */
    private String salaCelebracion;
    /**
     * Descripción de la prueba.
     */
    private String descripcion;
    /**
     * Lista de fases de la prueba.
     */
    private List<Fase> listaFases;
    /**
     * Lista de candidatos de la prueba.
     */
    private List<Candidato> listaCandidatos;

    /**
     * Constructor vacío de Prueba.
     */
    public Prueba() {
    }

    /**
     * Constructor que inicializa los atributos con los valores dados por los
     * parámetros.
     *
     * @param noPrueba Número de prueba.
     * @param fecha Fecha de la prueba.
     * @param salaCelebracion Sala de celebración de la prueba.
     * @param descripcion Descripción de la prueba.
     */
    public Prueba(int noPrueba, Date fecha, String salaCelebracion, String descripcion) {
        this.noPrueba = noPrueba;
        this.fecha = fecha;
        this.salaCelebracion = salaCelebracion;
        this.descripcion = descripcion;
    }

    /**
     * Constructor que inicializa los atributos con los valores dados por los
     * parámetros.
     *
     * @param noPrueba Número de prueba.
     * @param fecha Fecha de la prueba.
     * @param salaCelebracion Sala de celebración de la prueba.
     * @param descripcion Descripción de la prueba.
     * @param listaFases Lista de fases de la prueba.
     * @param listaCandidatos Lista de candidatos de la prueba.
     */
    public Prueba(int noPrueba, Date fecha, String salaCelebracion, String descripcion, List<Fase> listaFases, List<Candidato> listaCandidatos) {
        this.noPrueba = noPrueba;
        this.fecha = fecha;
        this.salaCelebracion = salaCelebracion;
        this.descripcion = descripcion;
        this.listaFases = listaFases;
        this.listaCandidatos = listaCandidatos;
    }

    /**
     * Método para obtener el número de prueba.
     *
     * @return Número de prueba.
     */
    public int getNoPrueba() {
        return noPrueba;
    }

    /**
     * Método para establecer el número de prueba.
     *
     * @param noPrueba Número de prueba.
     */
    public void setNoPrueba(int noPrueba) {
        this.noPrueba = noPrueba;
    }

    /**
     * Método para obtener la fecha de la prueba.
     *
     * @return Fecha de la prueba.
     */
    public Date getFecha() {
        return fecha;
    }

    /**
     * Método para establecer la fecha de la prueba.
     *
     * @param fecha Fecha de la prueba.
     */
    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    /**
     * Método para obtener la sala de celebración de la prueba.
     *
     * @return Sala de celebración de la prueba.
     */
    public String getSalaCelebracion() {
        return salaCelebracion;
    }

    /**
     * Método para establecer la sala de celebración de la prueba.
     *
     * @param salaCelebracion Sala de celebración de la prueba.
     */
    public void setSalaCelebracion(String salaCelebracion) {
        this.salaCelebracion = salaCelebracion;
    }

    /**
     * Método para obtener la descripción de la prueba.
     *
     * @return Descripción de la prueba.
     */
    public String getDescripcion() {
        return descripcion;
    }

    /**
     * Método para establecer la descripción de la prueba.
     *
     * @param descripcion Descripción de la prueba.
     */
    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    /**
     * Método para obtener la lista de fases de la prueba.
     *
     * @return Lista de fases de la prueba.
     */
    public List<Fase> getListaFases() {
        return listaFases;
    }

    /**
     * Método para establecer la lista de fases de la prueba.
     *
     * @param listaFases Lista de fases de la prueba.
     */
    public void setListaFases(List<Fase> listaFases) {
        this.listaFases = listaFases;
    }

    /**
     * Método para obtener la lista de candidatos de la prueba.
     *
     * @return Lista de candidatos de la prueba.
     */
    public List<Candidato> getListaCandidatos() {
        return listaCandidatos;
    }

    /**
     * Método para establecer la lista de candidatos de la prueba.
     *
     * @param listaCandidatos Lista de candidatos de la prueba.
     */
    public void setListaCandidatos(List<Candidato> listaCandidatos) {
        this.listaCandidatos = listaCandidatos;
    }

    /**
     * Método que se encarga de regresar una cadena de texto con los datos de la
     * prueba.
     *
     * @return Cadena de texto con atributos de la clase.
     */
    @Override
    public String toString() {
        return "Prueba{" + "noPrueba=" + noPrueba + ", fecha=" + fecha + ", salaCelebracion=" + salaCelebracion + ", descripcion=" + descripcion + '}';
    }

}
