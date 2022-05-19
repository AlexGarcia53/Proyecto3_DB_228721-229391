/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dominio;

import java.util.Date;

/**
 * Clase que representa a la entidad Online.
 *
 * @author Equipo 3
 */
public class Online extends Casting {

    /**
     * Contructor vacío de Online.
     */
    public Online() {
    }

    /**
     * constructor que inicializa los atributos con los valores dados por los
     * parámetros.
     *
     * @param codigoCasting Código del casting.
     * @param nombre Nombre del casting.
     * @param descripcion Descripción del casting.
     * @param fechaContratacion Fecha de contratación del casting.
     */
    public Online(String codigoCasting, String nombre, String descripcion, Date fechaContratacion) {
        super(codigoCasting, nombre, descripcion, fechaContratacion);
    }

    /**
     * constructor que inicializa los atributos con los valores dados por los
     * parámetros.
     *
     * @param codigoCasting Código del casting.
     * @param nombre Nombre del casting.
     * @param descripcion Descripción del casting.
     * @param fechaContratacion Fecha de contratación del casting.
     * @param cliente Cliente que contrata el casting.
     */
    public Online(String codigoCasting, String nombre, String descripcion, Date fechaContratacion, Cliente cliente) {
        super(codigoCasting, nombre, descripcion, fechaContratacion, cliente);
    }

    /**
     * Método para obtener el código del casting.
     *
     * @return código del casting.
     */
    @Override
    public String getCodigoCasting() {
        return codigoCasting;
    }

    /**
     * Método para establecer el código del casting.
     *
     * @param codigoCasting código del casting.
     */
    @Override
    public void setCodigoCasting(String codigoCasting) {
        this.codigoCasting = codigoCasting;
    }

    /**
     * Método para obtener el nombre del casting.
     *
     * @return nombre del casting.
     */
    @Override
    public String getNombre() {
        return nombre;
    }

    /**
     * Método para establecer el nombre del casting.
     *
     * @param nombre nombre del casting.
     */
    @Override
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    /**
     * Método para obtener la descripción del casting.
     *
     * @return descripción del casting.
     */
    @Override
    public String getDescripcion() {
        return descripcion;
    }

    /**
     * Método para establecer la descripción del casting.
     *
     * @param descripcion descripción del casting.
     */
    @Override
    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    /**
     * Método para obtener la fecha de contratación del casting.
     *
     * @return fecha de contratación del casting.
     */
    @Override
    public Cliente getCliente() {
        return cliente;
    }

    /**
     * Método para establecer el cliente del casting.
     *
     * @param cliente cliente que contrata el casting.
     */
    @Override
    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

}
