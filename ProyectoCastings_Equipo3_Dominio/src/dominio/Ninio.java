/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dominio;

import java.util.Date;
import java.util.List;

/**
 * Clase que representa a la entidad Niño.
 *
 * @author Equipo 3
 */
public class Ninio extends Candidato {

    /**
     * Nombre que tiene el tutor del niño.
     */
    private String nombreTutor;

    /**
     * Constructor que inicializa el atributo de nombreTutor.
     *
     * @param nombreTutor Nombre que tiene el tutor del niño.
     */
    public Ninio(String nombreTutor) {
        this.nombreTutor = nombreTutor;
    }

    /**
     * Constructor que inicializa los atributos con los valores dados por los
     * parámetros.
     *
     * @param nombreTutor Nombre que tiene el tutor del niño.
     * @param codigoCandidato Código que tiene el candidato niño.
     * @param nombre Nombre que tiene el candidato niño.
     * @param direccion Dirección del candidato niño.
     * @param telefonoContacto teléfono del candidato niño.
     * @param fechaNacimiento fecha de nacimiento del candidato niño.
     * @param fotografia fotografía del candidato niño.
     * @param CURP CURP del candidato niño.
     * @param validacionResultado validación de resultado del candidato niño.
     */
    public Ninio(String nombreTutor, String codigoCandidato, String nombre, String direccion, String telefonoContacto, Date fechaNacimiento, String fotografia, String CURP, boolean validacionResultado) {
        super(codigoCandidato, nombre, direccion, telefonoContacto, fechaNacimiento, fotografia, CURP, validacionResultado);
        this.nombreTutor = nombreTutor;
    }

    /**
     * Constructor que inicializa los atributos con los valores dados por los
     * parámetros.
     *
     * @param nombreTutor Nombre que tiene el tutor del niño.
     * @param codigoCandidato Código que tiene el candidato niño.
     * @param nombre Nombre que tiene el candidato niño.
     * @param direccion Dirección del candidato niño.
     * @param telefonoContacto teléfono del candidato niño.
     * @param fechaNacimiento fecha de nacimiento del candidato niño.
     * @param fotografia fotografía del candidato niño.
     * @param CURP CURP del candidato niño.
     * @param validacionResultado validación de resultado del candidato niño.
     * @param perfil perfil del candidato niño.
     * @param listaPruebas lista de pruebas que tiene el candidato niño.
     * @param representante representante del candidato niño.
     */
    public Ninio(String nombreTutor, String codigoCandidato, String nombre, String direccion, String telefonoContacto, Date fechaNacimiento, String fotografia, String CURP, boolean validacionResultado, Perfil perfil, List<Prueba> listaPruebas, Representante representante) {
        super(codigoCandidato, nombre, direccion, telefonoContacto, fechaNacimiento, fotografia, CURP, validacionResultado, perfil, listaPruebas, representante);
        this.nombreTutor = nombreTutor;
    }

    /**
     * Método para obtener el nombre del tutor.
     *
     * @return Nombre que tiene el tutor del niño.
     */
    public String getNombreTutor() {
        return nombreTutor;
    }

    /**
     * Método para establecer el nombre del tutor.
     *
     * @param nombreTutor Nombre que tiene el tutor del niño.
     */
    public void setNombreTutor(String nombreTutor) {
        this.nombreTutor = nombreTutor;
    }

    /**
     * Método para obtener el código del candidato.
     *
     * @return Nombre que tiene el candidato.
     */
    @Override
    public String getCodigoCandidato() {
        return codigoCandidato;
    }

    /**
     * Método para establecer el código del candidato.
     *
     * @param codigoCandidato código del candidato.
     */
    @Override
    public void setCodigoCandidato(String codigoCandidato) {
        this.codigoCandidato = codigoCandidato;
    }

    /**
     * Método para obtener el nombre del candidato.
     *
     * @return nombre del candidato.
     */
    @Override
    public String getNombre() {
        return nombre;
    }

    /**
     * Método para establecer el nombre del candidato.
     *
     * @param nombre nombre del candidato.
     */
    @Override
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    /**
     * Método para obtener la dirección del candidato.
     *
     * @return dirección del candidato.
     */
    @Override
    public String getDireccion() {
        return direccion;
    }

    /**
     * Método para establecer la dirección del candidato.
     *
     * @param direccion dirección del candidato.
     */
    @Override
    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    /**
     * Método para obtener el teléfono del candidato.
     *
     * @return teléfono del candidato.
     */
    @Override
    public String getTelefonoContacto() {
        return telefonoContacto;
    }

    /**
     * Método para establecer el teléfono del candidato.
     *
     * @param telefonoContacto teléfono del candidato.
     */
    @Override
    public void setTelefonoContacto(String telefonoContacto) {
        this.telefonoContacto = telefonoContacto;
    }

    /**
     * Método para obtener la fecha de nacimiento del candidato.
     *
     * @return fecha de nacimiento del candidato.
     */
    @Override
    public Date getFechaNacimiento() {
        return fechaNacimiento;
    }

    /**
     * Método para establecer la fecha de nacimiento del candidato.
     *
     * @param fechaNacimiento fecha de nacimiento del candidato.
     */
    @Override
    public void setFechaNacimiento(Date fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
    }

    /**
     * Método para obtener la fotografía del candidato.
     *
     * @return fotografía del candidato.
     */
    @Override
    public String getFotografia() {
        return fotografia;
    }

    /**
     * Método para establecer la fotografía del candidato.
     *
     * @param fotografia fotografía del candidato.
     */
    @Override
    public void setFotografia(String fotografia) {
        this.fotografia = fotografia;
    }

    /**
     * Método para obtener la CURP del candidato.
     *
     * @return CURP del candidato.
     */
    @Override
    public String getCURP() {
        return CURP;
    }

    /**
     * Método para establecer la CURP del candidato.
     *
     * @param CURP CURP del candidato.
     */
    @Override
    public void setCURP(String CURP) {
        this.CURP = CURP;
    }

    /**
     * Método para obtener la validación del candidato.
     *
     * @return validación del candidato.
     */
    @Override
    public boolean isValidacionResultado() {
        return validacionResultado;
    }

    /**
     * Método para establecer la validación del candidato.
     *
     * @param validacionResultado validación del candidato.
     */
    @Override
    public void setValidacionResultado(boolean validacionResultado) {
        this.validacionResultado = validacionResultado;
    }

    /**
     * Método para obtener el perfil del candidato.
     *
     * @return perfil del candidato.
     */
    @Override
    public Perfil getPerfil() {
        return perfil;
    }

    /**
     * Método para establecer el perfil del candidato.
     *
     * @param perfil perfil del candidato.
     */
    @Override
    public void setPerfil(Perfil perfil) {
        this.perfil = perfil;
    }

    /**
     * Método para obtener la lista de pruebas del candidato.
     *
     * @return lista de pruebas del candidato.
     */
    @Override
    public List<Prueba> getListaPruebas() {
        return listaPruebas;
    }

    /**
     * Método para establecer la lista de pruebas del candidato.
     *
     * @param listaPruebas lista de pruebas del candidato.
     */
    @Override
    public void setListaPruebas(List<Prueba> listaPruebas) {
        this.listaPruebas = listaPruebas;
    }

    /**
     * Método para obtener al representante del candidato.
     *
     * @return representante del candidato.
     */
    @Override
    public Representante getRepresentante() {
        return representante;
    }

    /**
     * Método para establecer al representante del candidato.
     *
     * @param representante representante del candidato.
     */
    @Override
    public void setRepresentante(Representante representante) {
        this.representante = representante;
    }

    /**
     * Método que se encarga de regresar una cadena de texto con los datos del
     * candidato niño.
     *
     * @return Cadena de texto con atributos de la clase.
     */
    @Override
    public String toString() {
        return "Ninio{" + "nombreTutor=" + nombreTutor + '}';
    }

}
