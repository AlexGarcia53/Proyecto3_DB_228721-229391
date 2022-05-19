/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dominio;

import java.util.Date;
import java.util.List;

/**
 * Clase que representa a la entidad Candidato.
 *
 * @author Equipo 3
 */
public class Candidato {

    /**
     * Código que tiene el candidato.
     */
    protected String codigoCandidato;
    /**
     * Nombre que tiene el candidato.
     */
    protected String nombre;
    /**
     * Dirección que tiene el candidato.
     */
    protected String direccion;
    /**
     * Teléfono del candidato.
     */
    protected String telefonoContacto;
    /**
     * fecha de nacimiento del candidato.
     */
    protected Date fechaNacimiento;
    /**
     * fotografía del candidato.
     */
    protected String fotografia;
    /**
     * CURP del candidato.
     */
    protected String CURP;
    /**
     * validación de resultado del candidato.
     */
    protected boolean validacionResultado;
    /**
     * perfil del candidato.
     */
    protected Perfil perfil;
    /**
     * lista de pruebas que tiene el candidato.
     */
    protected List<Prueba> listaPruebas;
    /**
     * representante del candidato.
     */
    protected Representante representante;

    /**
     * Constructor vacío de candidato.
     */
    public Candidato() {
    }

    /**
     *
     * Constructor que inicializa los atributos con los valores dados por los
     * parámetros.
     *
     * @param codigoCandidato Código que tiene el candidato.
     * @param nombre Nombre que tiene el candidato.
     * @param direccion Dirección del candidato.
     * @param telefonoContacto teléfono del candidato.
     * @param fechaNacimiento fecha de nacimiento del candidato.
     * @param fotografia fotografía del candidato.
     * @param CURP CURP del candidato.
     * @param validacionResultado validación de resultado del candidato.
     */
    public Candidato(String codigoCandidato, String nombre, String direccion, String telefonoContacto, Date fechaNacimiento, String fotografia, String CURP, boolean validacionResultado) {
        this.codigoCandidato = codigoCandidato;
        this.nombre = nombre;
        this.direccion = direccion;
        this.telefonoContacto = telefonoContacto;
        this.fechaNacimiento = fechaNacimiento;
        this.fotografia = fotografia;
        this.CURP = CURP;
        this.validacionResultado = validacionResultado;
    }

    /**
     * constructor que inicializa los atributos con los valores dados por los
     * parámetros.
     *
     * @param codigoCandidato Código que tiene el candidato.
     * @param nombre Nombre que tiene el candidato.
     * @param direccion Dirección del candidato.
     * @param telefonoContacto teléfono del candidato.
     * @param fechaNacimiento fecha de nacimiento del candidato.
     * @param fotografia fotografía del candidato.
     * @param CURP CURP del candidato.
     * @param validacionResultado validación de resultado del candidato.
     * @param perfil perfil del candidato adulto.
     * @param listaPruebas lista de pruebas que tiene el candidato.
     * @param representante representante del candidato.
     */
    public Candidato(String codigoCandidato, String nombre, String direccion, String telefonoContacto, Date fechaNacimiento, String fotografia, String CURP, boolean validacionResultado, Perfil perfil, List<Prueba> listaPruebas, Representante representante) {
        this.codigoCandidato = codigoCandidato;
        this.nombre = nombre;
        this.direccion = direccion;
        this.telefonoContacto = telefonoContacto;
        this.fechaNacimiento = fechaNacimiento;
        this.fotografia = fotografia;
        this.CURP = CURP;
        this.validacionResultado = validacionResultado;
        this.perfil = perfil;
        this.listaPruebas = listaPruebas;
        this.representante = representante;
    }

    /**
     * Método para obtener el código del candidato.
     *
     * @return código del candidato.
     */
    public String getCodigoCandidato() {
        return codigoCandidato;
    }

    /**
     * Método para establecer el código del candidato.
     *
     * @param codigoCandidato código del candidato.
     */
    public void setCodigoCandidato(String codigoCandidato) {
        this.codigoCandidato = codigoCandidato;
    }

    /**
     * Método para obtener el nombre del candidato.
     *
     * @return nombre del candidato.
     */
    public String getNombre() {
        return nombre;
    }

    /**
     * Método para establecer el nombre del candidato.
     *
     * @param nombre nombre del candidato.
     */
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    /**
     * Método para obtener la dirección del candidato.
     *
     * @return dirección del candidato.
     */
    public String getDireccion() {
        return direccion;
    }

    /**
     * Método para establecer la dirección del candidato.
     *
     * @param direccion dirección del candidato.
     */
    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    /**
     * Método para obtener el teléfono del candidato.
     *
     * @return teléfono del candidato.
     */
    public String getTelefonoContacto() {
        return telefonoContacto;
    }

    /**
     * Método para establecer el teléfono del candidato.
     *
     * @param telefonoContacto teléfono del candidato.
     */
    public void setTelefonoContacto(String telefonoContacto) {
        this.telefonoContacto = telefonoContacto;
    }

    /**
     * Método para obtener la fecha de nacimiento del candidato.
     *
     * @return fecha de nacimiento del candidato.
     */
    public Date getFechaNacimiento() {
        return fechaNacimiento;
    }

    /**
     * Método para establecer la fecha de nacimiento del candidato.
     *
     * @param fechaNacimiento fecha de nacimiento del candidato.
     */
    public void setFechaNacimiento(Date fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
    }

    /**
     * Método para obtener la fotografía del candidato.
     *
     * @return fotografía del candidato.
     */
    public String getFotografia() {
        return fotografia;
    }

    /**
     * Método para establecer la fotografía del candidato.
     *
     * @param fotografia fotografía del candidato.
     */
    public void setFotografia(String fotografia) {
        this.fotografia = fotografia;
    }

    /**
     * Método para obtener la CURP del candidato.
     *
     * @return CURP del candidato.
     */
    public String getCURP() {
        return CURP;
    }

    /**
     * Método para establecer la CURP del candidato.
     *
     * @param CURP CURP del candidato.
     */
    public void setCURP(String CURP) {
        this.CURP = CURP;
    }

    /**
     * Método para obtener la validación del candidato.
     *
     * @return validación del candidato.
     */
    public boolean isValidacionResultado() {
        return validacionResultado;
    }

    /**
     * Método para establecer la validación del candidato.
     *
     * @param validacionResultado validación del candidato.
     */
    public void setValidacionResultado(boolean validacionResultado) {
        this.validacionResultado = validacionResultado;
    }

    /**
     * Método para obtener el perfil del candidato.
     *
     * @return perfil del candidato.
     */
    public Perfil getPerfil() {
        return perfil;
    }

    /**
     * Método para establecer el perfil del candidato.
     *
     * @param perfil perfil del candidato.
     */
    public void setPerfil(Perfil perfil) {
        this.perfil = perfil;
    }

    /**
     * Método para obtener la lista de pruebas del candidato.
     *
     * @return lista de pruebas del candidato.
     */
    public List<Prueba> getListaPruebas() {
        return listaPruebas;
    }

    /**
     * Método para establecer la lista de pruebas del candidato.
     *
     * @param listaPruebas lista de pruebas del candidato.
     */
    public void setListaPruebas(List<Prueba> listaPruebas) {
        this.listaPruebas = listaPruebas;
    }

    /**
     * Método para obtener al representante del candidato.
     *
     * @return representante del candidato.
     */
    public Representante getRepresentante() {
        return representante;
    }

    /**
     * Método para establecer al representante del candidato.
     *
     * @param representante representante del candidato.
     */
    public void setRepresentante(Representante representante) {
        this.representante = representante;
    }

    /**
     * Método que se encarga de regresar una cadena de texto con los datos del
     * candidato.
     *
     * @return Cadena de texto con atributos de la clase.
     */
    @Override
    public String toString() {
        return "Candidato{" + "codigoCandidato=" + codigoCandidato + ", nombre=" + nombre + ", direccion=" + direccion + ", telefonoContacto=" + telefonoContacto + ", fechaNacimiento=" + fechaNacimiento + ", fotografia=" + fotografia + ", CURP=" + CURP + ", validacionResultado=" + validacionResultado + '}';
    }

}
