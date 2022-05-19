/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dominio;

import java.util.Date;
import java.util.Objects;
import org.bson.types.ObjectId;

/**
 * Clase que representa a la entidad Casting.
 *
 * @author Equipo 3
 */
public class Casting {

    /**
     * Identificador único para el casting.
     */
    protected ObjectId id;
    /**
     * Código del casting.
     */
    protected String codigoCasting;
    /**
     * Nombre del casting.
     */
    protected String nombre;
    /**
     * Descripción del casting.
     */
    protected String descripcion;
    /**
     * Fecha de contratación del casting.
     */
    protected Date fechaContratacion;
    /**
     * Cliente que contrata el casting.
     */
    protected Cliente cliente;
    /**
     * Relación entre cliente y casting.
     */
    protected ClienteCasting clienteCasting;

    /**
     * Contructor vacío de casting.
     */
    public Casting() {
    }

    /**
     * Constructor que inicializa los atributos con los valores dados por los
     * parámetros.
     *
     * @param codigoCasting Código del casting.
     * @param nombre Nombre del casting.
     * @param descripcion Descripción del casting.
     * @param fechaContratacion Fecha de contratación del casting.
     */
    public Casting(String codigoCasting, String nombre, String descripcion, Date fechaContratacion) {
        this.codigoCasting = codigoCasting;
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.fechaContratacion = fechaContratacion;
    }

    /**
     * Constructor que inicializa los atributos con los valores dados por los
     * parámetros.
     *
     * @param codigoCasting Código del casting.
     * @param nombre Nombre del casting.
     * @param descripcion Descripción del casting.
     * @param fechaContratacion Fecha de contratación del casting.
     * @param cliente Cliente que contrata el casting.
     */
    public Casting(String codigoCasting, String nombre, String descripcion, Date fechaContratacion, Cliente cliente) {
        this.codigoCasting = codigoCasting;
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.fechaContratacion = fechaContratacion;
        this.cliente = cliente;
    }

    /**
     * Constructor que inicializa los atributos con los valores dados por los
     * parámetros.
     *
     * @param codigoCasting Código del casting.
     * @param nombre Nombre del casting.
     * @param descripcion Descripción del casting.
     * @param fechaContratacion Fecha de contratación del casting.
     * @param cliente Cliente que contrata el casting.
     * @param clienteCasting Relación entre cliente y casting.
     */
    public Casting(String codigoCasting, String nombre, String descripcion, Date fechaContratacion, Cliente cliente, ClienteCasting clienteCasting) {
        this.codigoCasting = codigoCasting;
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.fechaContratacion = fechaContratacion;
        this.cliente = cliente;
        this.clienteCasting = clienteCasting;
    }

    /**
     * Constructor que inicializa los atributos con los valores dados por los
     * parámetros.
     *
     * @param id Identificador único para el casting.
     * @param codigoCasting Código del casting.
     * @param nombre Nombre del casting.
     * @param descripcion Descripción del casting.
     * @param fechaContratacion Fecha de contratación del casting.
     * @param cliente Cliente que contrata el casting.
     */
    public Casting(ObjectId id, String codigoCasting, String nombre, String descripcion, Date fechaContratacion, Cliente cliente) {
        this.id = id;
        this.codigoCasting = codigoCasting;
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.fechaContratacion = fechaContratacion;
        this.cliente = cliente;
    }

    /**
     * Constructor que inicializa los atributos con los valores dados por los
     * parámetros.
     *
     * @param id Identificador único para el casting.
     * @param codigoCasting Código del casting.
     * @param nombre Nombre del casting.
     * @param descripcion Descripción del casting.
     * @param fechaContratacion Fecha de contratación del casting.
     * @param cliente Cliente que contrata el casting.
     * @param clienteCasting Relación entre cliente y casting.
     */
    public Casting(ObjectId id, String codigoCasting, String nombre, String descripcion, Date fechaContratacion, Cliente cliente, ClienteCasting clienteCasting) {
        this.id = id;
        this.codigoCasting = codigoCasting;
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.fechaContratacion = fechaContratacion;
        this.cliente = cliente;
        this.clienteCasting = clienteCasting;
    }

    /**
     * Método para obtener el identificador único del casting.
     *
     * @return Identificador único del casting.
     */
    public ObjectId getId() {
        return id;
    }

    /**
     * Método para establecer el identificador único del casting.
     *
     * @param id Identificador único del casting.
     */
    public void setId(ObjectId id) {
        this.id = id;
    }

    /**
     * Método para obtener el código del casting.
     *
     * @return código del casting.
     */
    public String getCodigoCasting() {
        return codigoCasting;
    }

    /**
     * Método para establecer el código del casting.
     *
     * @param codigoCasting código del casting.
     */
    public void setCodigoCasting(String codigoCasting) {
        this.codigoCasting = codigoCasting;
    }

    /**
     * Método para obtener el nombre del casting.
     *
     * @return nombre del casting.
     */
    public String getNombre() {
        return nombre;
    }

    /**
     * Método para establecer el nombre del casting.
     *
     * @param nombre nombre del casting.
     */
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    /**
     * Método para obtener la descripción del casting.
     *
     * @return descripción del casting.
     */
    public String getDescripcion() {
        return descripcion;
    }

    /**
     * Método para establecer la descripción del casting.
     *
     * @param descripcion descripción del casting.
     */
    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    /**
     * Método para obtener la fecha de contratación del casting.
     *
     * @return fecha de contratación del casting.
     */
    public Date getFechaContratacion() {
        return fechaContratacion;
    }

    /**
     * Método para establecer la fecha de contratación del casting.
     *
     * @param fechaContratacion fecha de contratación del casting.
     */
    public void setFechaContratacion(Date fechaContratacion) {
        this.fechaContratacion = fechaContratacion;
    }

    /**
     * Método para obtener el cliente del casting.
     *
     * @return cliente que contrata el casting.
     */
    public Cliente getCliente() {
        return cliente;
    }

    /**
     * Método para establecer el cliente del casting.
     *
     * @param cliente cliente que contrata el casting.
     */
    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    /**
     * Método para obtener la relación ClienteCasting del casting.
     *
     * @return Relación entre cliente y casting.
     */
    public ClienteCasting getClienteCasting() {
        return clienteCasting;
    }

    /**
     * Método para establecer la relación ClienteCasting del casting.
     *
     * @param clienteCasting Relación entre cliente y casting.
     */
    public void setClienteCasting(ClienteCasting clienteCasting) {
        this.clienteCasting = clienteCasting;
    }

    /**
     * Método hashCode.
     *
     * @return código hash.
     */
    @Override
    public int hashCode() {
        int hash = 7;
        hash = 67 * hash + Objects.hashCode(this.id);
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
        final Casting other = (Casting) obj;
        if (!Objects.equals(this.id, other.id)) {
            return false;
        }
        return true;
    }

    /**
     * Método utilizado para generar el identificador único del casting.
     */
    public void generarId() {
        this.id = new ObjectId();
    }

    /**
     * Método que se encarga de regresar una cadena de texto con los datos del
     * casting.
     *
     * @return Cadena de texto con atributos de la clase.
     */
    @Override
    public String toString() {
        return "Casting{" + "codigoCasting=" + codigoCasting + ", nombre=" + nombre + ", descripcion=" + descripcion + ", fechaContratacion=" + fechaContratacion + ", cliente=" + cliente + '}';
    }

}
