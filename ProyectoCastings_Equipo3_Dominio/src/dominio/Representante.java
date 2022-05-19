/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dominio;

import java.util.List;

/**
 * Clase que representa a la entidad Representante.
 *
 * @author Equipo 3
 */
public class Representante {

    /**
     * RFC del representante.
     */
    private String RFC;
    /**
     * CURP del representante.
     */
    private String CURP;
    /**
     * Nombre del representante.
     */
    private String nombre;
    /**
     * Teléfono del representante.
     */
    private String telefono;
    /**
     * Dirección del representante.
     */
    private String direccion;
    /**
     * Lista de candidatos del representante.
     */
    private List<Candidato> listaCandidatos;

    /**
     * Constructor vacío de Prueba.
     */
    public Representante() {
    }

    /**
     * Constructor que inicializa los atributos con los valores dados por los
     * parámetros.
     *
     * @param RFC RFC del representante.
     * @param CURP CURP del representante.
     * @param nombre Nombre del representante.
     * @param telefono Teléfono del representante.
     * @param direccion Dirección del representante.
     */
    public Representante(String RFC, String CURP, String nombre, String telefono, String direccion) {
        this.RFC = RFC;
        this.CURP = CURP;
        this.nombre = nombre;
        this.telefono = telefono;
        this.direccion = direccion;
    }

    /**
     * Constructor que inicializa los atributos con los valores dados por los
     * parámetros.
     *
     * @param RFC RFC del representante.
     * @param CURP CURP del representante.
     * @param nombre Nombre del representante.
     * @param telefono Teléfono del representante.
     * @param direccion Dirección del representante.
     * @param listaCandidatos Lista de candidatos del representante.
     */
    public Representante(String RFC, String CURP, String nombre, String telefono, String direccion, List<Candidato> listaCandidatos) {
        this.RFC = RFC;
        this.CURP = CURP;
        this.nombre = nombre;
        this.telefono = telefono;
        this.direccion = direccion;
        this.listaCandidatos = listaCandidatos;
    }

    /**
     * Método para obtener el RFC del Representante.
     *
     * @return RFC del representante.
     */
    public String getRFC() {
        return RFC;
    }

    /**
     * Método para establecer el RFC del representante.
     *
     * @param RFC RFC del representante.
     */
    public void setRFC(String RFC) {
        this.RFC = RFC;
    }

    /**
     * Método para obtener la CURP del representante.
     *
     * @return CURP del representante.
     */
    public String getCURP() {
        return CURP;
    }

    /**
     * Método para establecer la CURP del representante.
     *
     * @param CURP CURP del representante.
     */
    public void setCURP(String CURP) {
        this.CURP = CURP;
    }

    /**
     * Método para obtener el nombre del representante.
     *
     * @return Nombre del representante.
     */
    public String getNombre() {
        return nombre;
    }

    /**
     * Método para establecer el nombre del representante.
     *
     * @param nombre Nombre del representante.
     */
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    /**
     * Método para obtener el teléfono del representante.
     *
     * @return Teléfono del representante.
     */
    public String getTelefono() {
        return telefono;
    }

    /**
     * Método para establecer el teléfono del representante.
     *
     * @param telefono Teléfono del representante.
     */
    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    /**
     * Método para obtener la dirección del representante.
     *
     * @return Dirección del representante.
     */
    public String getDireccion() {
        return direccion;
    }

    /**
     * Método para establecer la dirección del representante.
     *
     * @param direccion Dirección del representante.
     */
    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    /**
     * Método para obtener la lista de candidatos del representante.
     *
     * @return Lista de candidatos del representante.
     */
    public List<Candidato> getListaCandidatos() {
        return listaCandidatos;
    }

    /**
     * Método para establecer la lista de candidatos del representante.
     *
     * @param listaCandidatos Lista de candidatos del representante.
     */
    public void setListaCandidatos(List<Candidato> listaCandidatos) {
        this.listaCandidatos = listaCandidatos;
    }

    /**
     * Método que se encarga de regresar una cadena de texto con los datos del
     * representante.
     *
     * @return Cadena de texto con atributos de la clase.
     */
    @Override
    public String toString() {
        return "Representante{" + "RFC=" + RFC + ", CURP=" + CURP + ", nombre=" + nombre + ", telefono=" + telefono + ", direccion=" + direccion + '}';
    }

}
