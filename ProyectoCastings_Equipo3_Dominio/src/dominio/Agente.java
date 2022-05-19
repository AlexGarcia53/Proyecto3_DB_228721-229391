/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dominio;

import java.util.List;
import java.util.Objects;
import org.bson.types.ObjectId;


/**
 * Clase que representa a la entidad Agente.
 *
 * @author Equipo 3
 */
public class Agente {

    /**
     * Identificador único del agente.
     */
    private ObjectId id;
    /**
     * Número de empleado del agente.
     */
    private String numEmpleado;
    /**
     * CURP del agente.
     */
    private String curp;
    /**
     * RFC del agente.
     */
    private String rfc;
    /**
     * Nombre del agente.
     */
    private String nombre;
    /**
     * Dirección que tiene el agente.
     */
    private String direccion;
    /**
     * Lista de canstings presenciales que tiene el agente.
     */
    private List<Presencial> presencial;

    /**
     * Constructor vacío de agente.
     */
    public Agente() {
    }

    /**
     * Constructor que inicializa los atributos con los valores dados por los
     * parámetros.
     *
     * @param id Identificador único de agente.
     * @param numEmpleado Número de empleado del agente.
     * @param rfc RFC del agente.
     * @param curp CURP del agente.
     * @param nombre Nombre del agente.
     * @param direccion Dirección que tiene el agente.
     */
    public Agente(ObjectId id, String numEmpleado, String rfc, String curp, String nombre, String direccion) {
        this.id = id;
        this.numEmpleado = numEmpleado;
        this.rfc = rfc;
        this.curp = curp;
        this.nombre = nombre;
        this.direccion = direccion;
    }

    /**
     * Constructor que inicializa los atributos con los valores dados por los
     * parámetros.
     *
     * @param numEmpleado Número de empleado del agente.
     * @param rfc RFC del agente.
     * @param curp CURP del agente.
     * @param nombre Nombre del agente.
     * @param direccion Dirección que tiene el agente.
     */
    public Agente(String numEmpleado, String rfc, String curp, String nombre, String direccion) {
        this.numEmpleado = numEmpleado;
        this.rfc = rfc;
        this.curp = curp;
        this.nombre = nombre;
        this.direccion = direccion;
    }

    /**
     * Constructor que inicializa los atributos con los valores dados por los
     * parámetros.
     *
     * @param numEmpleado Número de empleado del agente.
     * @param rfc RFC del agente.
     * @param curp CURP del agente.
     * @param nombre Nombre del agente.
     * @param direccion Dirección que tiene el agente.
     * @param presencial Lista de canstings presenciales que tiene el agente.
     */
    public Agente(String numEmpleado, String rfc, String curp, String nombre, String direccion, List<Presencial> presencial) {
        this.numEmpleado = numEmpleado;
        this.rfc = rfc;
        this.curp = curp;
        this.nombre = nombre;
        this.direccion = direccion;
        this.presencial = presencial;
    }

    /**
     * constructor que inicializa los atributos con los valores dados por los
     * parámetros.
     *
     * @param id Identificador único de agente.
     * @param numEmpleado Número de empleado del agente.
     * @param rfc RFC del agente.
     * @param curp CURP del agente.
     * @param nombre Nombre del agente.
     * @param direccion Dirección que tiene el agente.
     * @param presencial Lista de canstings presenciales que tiene el agente.
     */
    public Agente(ObjectId id, String numEmpleado, String rfc, String curp, String nombre, String direccion, List<Presencial> presencial) {
        this.id = id;
        this.numEmpleado = numEmpleado;
        this.rfc = rfc;
        this.curp = curp;
        this.nombre = nombre;
        this.direccion = direccion;
        this.presencial = presencial;
    }

    /**
     * Método para obtener el id del agente.
     *
     * @return Identificador único del agente.
     */
    public ObjectId getId() {
        return id;
    }

    /**
     * Método para establecer el id del agente.
     *
     * @param id Identificador único del agente.
     */
    public void setId(ObjectId id) {
        this.id = id;
    }

    /**
     * Método para obtener el número de empleado del agente.
     *
     * @return Número de empleado del agente.
     */
    public String getNumEmpleado() {
        return numEmpleado;
    }

    /**
     * Método para establecer el número del empleado del agente.
     *
     * @param numEmpleado Número de empleado del agente.
     */
    public void setNumEmpleado(String numEmpleado) {
        this.numEmpleado = numEmpleado;
    }

    /**
     * Método para obtener el RFC del agente.
     *
     * @return RFC del agente.
     */
    public String getrfc() {
        return rfc;
    }

    /**
     * Método para establecer el RFC del agente.
     *
     * @param rfc RFC del agente.
     */
    public void setrfc(String rfc) {
        this.rfc = rfc;
    }

    /**
     * Método para obtener la CURP del agente.
     *
     * @return CURP del agente.
     */
    public String getcurp() {
        return curp;
    }

    /**
     * Método para obtener la CURP del agente.
     *
     * @return CURP del agente.
     */
    public String getCurp() {
        return curp;
    }

    /**
     * Método para establecer la CURP del agente.
     *
     * @param curp CURP del agente.
     */
    public void setCurp(String curp) {
        this.curp = curp;
    }

    /**
     * Método para obtener el RFC del agente.
     *
     * @return RFC del agente.
     */
    public String getRfc() {
        return rfc;
    }

    /**
     * Método para establecer el RFC del agente.
     *
     * @param rfc RFC del agente.
     */
    public void setRfc(String rfc) {
        this.rfc = rfc;
    }

    /**
     * Método para establecer la CURP del agente.
     *
     * @param curp CURP del agente.
     */
    public void setcurp(String curp) {
        this.curp = curp;
    }

    /**
     * Método para obtener el nombre del agente.
     *
     * @return Nombre del agente.
     */
    public String getNombre() {
        return nombre;
    }

    /**
     * Método para establecer el nombre del agente.
     *
     * @param nombre Nombre del agente.
     */
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    /**
     * Método para obtener el la dirección del agente.
     *
     * @return Dirección que tiene el agente.
     */
    public String getDireccion() {
        return direccion;
    }

    /**
     * Método para establecer la dirección del agente.
     *
     * @param direccion Dirección que tiene el agente.
     */
    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    /**
     * Método para obtener la lista de canstings presenciales que tiene el
     * agente.
     *
     * @return Lista de canstings presenciales que tiene el agente.
     */
    public List<Presencial> getPresencial() {
        return presencial;
    }

    /**
     * Método para establecer la lista de canstings presenciales que tiene el
     * agente.
     *
     * @param presencial Lista de canstings presenciales que tiene el agente.
     */
    public void setPresencial(List<Presencial> presencial) {
        this.presencial = presencial;
    }

    /**
     * Método hashCode.
     *
     * @return código hash.
     */
    @Override
    public int hashCode() {
        int hash = 3;
        hash = 43 * hash + Objects.hashCode(this.id);
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
        final Agente other = (Agente) obj;
        if (!Objects.equals(this.id, other.id)) {
            return false;
        }
        return true;
    }

    /**
     * Método que se encarga de regresar una cadena de texto con los datos del
     * agente.
     *
     * @return Cadena de texto con atributos de la clase.
     */
    @Override
    public String toString() {
        return "Agente{" + "numEmpleado=" + numEmpleado + ", rfc=" + rfc + ", curp=" + curp + ", nombre=" + nombre + ", direccion=" + direccion + ", presencial=" + presencial + '}';
    }

}
