/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dominio;

import Excepciones.DatosClienteErroneosException;
import java.util.List;
import java.util.Objects;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import org.bson.types.ObjectId;

/**
 * Clase que representa a la entidad Cliente.
 *
 * @author Equipo 3
 */
public class Cliente {

    /**
     * Identificador único del cliente.
     */
    private ObjectId id;
    /**
     * Código del cliente.
     */
    private String codigoCliente;
    /**
     * Nombre del cliente.
     */
    private String nombre;
    /**
     * Dirección del cliente.
     */
    private String direccion;
    /**
     * Teléfono del cliente.
     */
    private String telefono;
    /**
     * Persona de contacto del cliente.
     */
    private String personaContacto;
    /**
     * Actividad del cliente.
     */
    private Actividad actividad;
    /**
     * Lista de castings del cliente.
     */
    private List<Casting> listaCastings;

    /**
     * Constructor vacío de Cliente.
     */
    public Cliente() {
    }

    /**
     * Constructor que inicializa los atributos con los valores dados por los
     * parámetros.
     *
     * @param nombre Nombre del cliente.
     * @param direccion Dirección del cliente.
     * @param telefono Teléfono del cliente.
     * @param personaContacto Persona de contacto del cliente.
     * @param actividad Actividad del cliente.
     */
    public Cliente(String nombre, String direccion, String telefono, String personaContacto, Actividad actividad) {
        this.nombre = nombre;
        this.direccion = direccion;
        this.telefono = telefono;
        this.personaContacto = personaContacto;
        this.actividad = actividad;
    }

    /**
     * Constructor que inicializa los atributos con los valores dados por los
     * parámetros.
     *
     * @param codigoCliente Código del cliente.
     * @param nombre Nombre del cliente.
     * @param direccion Dirección del cliente.
     * @param telefono Teléfono del cliente.
     * @param personaContacto Persona de contacto del cliente.
     */
    public Cliente(String codigoCliente, String nombre, String direccion, String telefono, String personaContacto) {
        this.codigoCliente = codigoCliente;
        this.nombre = nombre;
        this.direccion = direccion;
        this.telefono = telefono;
        this.personaContacto = personaContacto;
    }

    /**
     * Constructor que inicializa los atributos con los valores dados por los
     * parámetros.
     *
     * @param codigoCliente Código del cliente.
     * @param nombre Nombre del cliente.
     * @param direccion Dirección del cliente.
     * @param telefono Teléfono del cliente.
     * @param personaContacto Persona de contacto del cliente.
     * @param actividad Actividad del cliente.
     * @param listaCastings Lista de castings del cliente.
     */
    public Cliente(String codigoCliente, String nombre, String direccion, String telefono, String personaContacto, Actividad actividad, List<Casting> listaCastings) {
        this.codigoCliente = codigoCliente;
        this.nombre = nombre;
        this.direccion = direccion;
        this.telefono = telefono;
        this.personaContacto = personaContacto;
        this.actividad = actividad;
        this.listaCastings = listaCastings;
    }

    /**
     * Constructor que inicializa los atributos con los valores dados por los
     * parámetros.
     *
     * @param id Identificador único del cliente.
     * @param codigoCliente Código del cliente.
     * @param nombre Nombre del cliente.
     * @param direccion Dirección del cliente.
     * @param telefono Teléfono del cliente.
     * @param personaContacto Persona de contacto del cliente.
     * @param actividad Actividad del cliente.
     */
    public Cliente(ObjectId id, String codigoCliente, String nombre, String direccion, String telefono, String personaContacto, Actividad actividad) {
        this.id = id;
        this.codigoCliente = codigoCliente;
        this.nombre = nombre;
        this.direccion = direccion;
        this.telefono = telefono;
        this.personaContacto = personaContacto;
        this.actividad = actividad;
    }

    /**
     * Método para obtener el identificador único del cliente.
     *
     * @return Identificador único del cliente.
     */
    public ObjectId getId() {
        return id;
    }

    /**
     * Método para establecer el identificador único del cliente.
     *
     * @param id Identificador único del cliente.
     */
    public void setId(ObjectId id) {
        this.id = id;
    }

    /**
     * Método para obtener el código del cliente.
     *
     * @return Código del cliente.
     */
    public String getCodigoCliente() {
        return codigoCliente;
    }

    /**
     * Método para establecer el código del cliente.
     *
     * @param codigoCliente Código del cliente.
     */
    public void setCodigoCliente(String codigoCliente) {
        this.codigoCliente = codigoCliente;
    }

    /**
     * Método para obtener el nombre del cliente.
     *
     * @return Nombre del cliente.
     */
    public String getNombre() {
        return nombre;
    }

    /**
     * Método para establecer el nombre del cliente.
     *
     * @param nombre Nombre del cliente.
     */
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    /**
     * Método para obtener la dirección del cliente.
     *
     * @return Dirección del cliente.
     */
    public String getDireccion() {
        return direccion;
    }

    /**
     * Método para establecer la dirección del cliente.
     *
     * @param direccion Dirección del cliente.
     */
    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    /**
     * Método para obtener el teléfono del cliente.
     *
     * @return Teléfono del cliente.
     */
    public String getTelefono() {
        return telefono;
    }

    /**
     * Método para establecer el teléfono del cliente.
     *
     * @param telefono Teléfono del cliente.
     */
    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    /**
     * Método para obtener la persona de contacto del cliente.
     *
     * @return Persona de contacto del cliente.
     */
    public String getPersonaContacto() {
        return personaContacto;
    }

    /**
     * Método para establecer la persona de contacto del cliente.
     *
     * @param personaContacto Persona de contacto del cliente.
     */
    public void setPersonaContacto(String personaContacto) {
        this.personaContacto = personaContacto;
    }

    /**
     * Método para obtener la actividad del cliente.
     *
     * @return Actividad del cliente.
     */
    public Actividad getActividad() {
        return actividad;
    }

    /**
     * Método para establecer la actividad del cliente.
     *
     * @param actividad Actividad del cliente.
     */
    public void setActividad(Actividad actividad) {
        this.actividad = actividad;
    }

    /**
     * Método para obtener la lista de castings del cliente.
     *
     * @return Lista de castings del cliente.
     */
    public List<Casting> getListaCastings() {
        return listaCastings;
    }

    /**
     * Método para establecer la lista de castings del cliente.
     *
     * @param listaCastings Lista de castings del cliente.
     */
    public void setListaCastings(List<Casting> listaCastings) {
        this.listaCastings = listaCastings;
    }

    /**
     * Método utilizado para verificar los datos del cliente.
     *
     * @throws DatosClienteErroneosException Excepción en caso de haber error en
     * los datos.
     */
    public void verificarDatos() throws DatosClienteErroneosException {
        if (this.nombre.equals("")) {
            throw new DatosClienteErroneosException("El nombre del cliente es vacío");
        } else if (this.direccion.equals("")) {
            throw new DatosClienteErroneosException("La dirección del cliente es vacía");
        } else if (this.telefono.equals("")) {
            throw new DatosClienteErroneosException("El teléfono del cliente es vacío");
        } else if (this.personaContacto.equals("")) {
            throw new DatosClienteErroneosException("La persona de contacto del cliente es vacía");
        } else if (this.actividad == null) {
            throw new DatosClienteErroneosException("La actividad del cliente es vacía");
        }
        Pattern pat = Pattern.compile("^([A-Za-zñÑáéíóúÁÉÍÓÚ]+[ ]*){1,6}$");
        Matcher comprobacionNombre = pat.matcher(this.nombre);
        if (!comprobacionNombre.matches()) {
            throw new DatosClienteErroneosException("El nombre del cliente contiene caracteres no válidos");
        }
        Matcher comprobacionPersonaContacto = pat.matcher(this.personaContacto);
        if (!comprobacionPersonaContacto.matches()) {
            throw new DatosClienteErroneosException("La persona de contacto del cliente contiene caracteres no válidos");
        }
        Pattern patronTelefono = Pattern.compile("^([0-9]+[ ]*){1,6}$");
        Matcher comprobacionTelefono = patronTelefono.matcher(this.telefono);
        if (!comprobacionTelefono.matches()) {
            throw new DatosClienteErroneosException("El teléfono contiene caracteres no válidos");
        }
        if (this.telefono.length() < 10) {
            throw new DatosClienteErroneosException("La longitud del teléfono no es correcta");
        }
    }

    /**
     * Método para generar el identificador único del cliente.
     */
    public void generarIdCliente() {
        this.id = new ObjectId();
    }

    /**
     * Método utilizado para generar un código para el cliente.
     */
    public void asignaCodigoCliente() {
        this.codigoCliente = this.hashCode() + "";
    }

    /**
     * Método hashCode.
     *
     * @return código hash.
     */
    @Override
    public int hashCode() {
        int hash = 3;
        hash = 29 * hash + Objects.hashCode(this.id);
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
        final Cliente other = (Cliente) obj;
        if (!Objects.equals(this.id, other.id)) {
            return false;
        }
        return true;
    }

    /**
     * Método que se encarga de regresar una cadena de texto con los datos del
     * cliente.
     *
     * @return Cadena de texto con atributos de la clase.
     */
    @Override
    public String toString() {
        return "Cliente{" + "codigoCliente=" + codigoCliente + ", nombre=" + nombre + ", direccion=" + direccion + ", telefono=" + telefono + ", personaContacto=" + personaContacto + '}';
    }

}
