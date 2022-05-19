/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dominio;

import java.util.Date;
import org.bson.types.ObjectId;
import java.util.List;
import org.bson.types.ObjectId;

/**
 * Clase que representa a la entidad Online.
 *
 * @author Equipo 3
 */
public class Presencial extends Casting {

    /**
     * Número de personas del casting.
     */
    private int noPersonas;
    /**
     * Agente que dirige el casting.
     */
    private Agente agente;
    /**
     * Lista de fases que tiene el casting.
     */
    private List<Fase> listaFases;
    /**
     * Lista de perfiles tiene el casting.
     */
    private List<Perfil> listaPerfiles;

    /**
     * Constructor vacío.
     */
    public Presencial() {
        super();
    }

    /**
     * Constructor que inicializa los atributos con los valores dados por los
     * parámetros.
     *
     * @param agente Agente que dirige el casting.
     * @param listaFases Lista de fases que tiene el casting.
     * @param listaPerfiles Lista de perfiles tiene el casting.
     */
    public Presencial(Agente agente, List<Fase> listaFases, List<Perfil> listaPerfiles) {
        this.agente = agente;
        this.listaFases = listaFases;
        this.listaPerfiles = listaPerfiles;
    }

    /**
     * Constructor que inicializa los atributos con los valores dados por los
     * parámetros.
     *
     * @param agente Agente que dirige el casting.
     * @param listaFases Lista de fases que tiene el casting.
     * @param listaPerfiles Lista de perfiles tiene el casting.
     * @param codigoCasting Código del casting.
     * @param nombre Nombre del casting.
     * @param descripcion Descripción del casting.
     * @param fechaContratacion Fecha de contratación del casting.
     */
    public Presencial(Agente agente, List<Fase> listaFases, List<Perfil> listaPerfiles, String codigoCasting, String nombre, String descripcion, Date fechaContratacion) {
        super(codigoCasting, nombre, descripcion, fechaContratacion);
        this.agente = agente;
        this.listaFases = listaFases;
        this.listaPerfiles = listaPerfiles;
    }

    /**
     * Constructor que inicializa los atributos con los valores dados por los
     * parámetros.
     *
     * @param agente Agente que dirige el casting.
     * @param listaFases Lista de fases que tiene el casting.
     * @param listaPerfiles Lista de perfiles tiene el casting.
     * @param codigoCasting Código del casting.
     * @param nombre Nombre del casting.
     * @param descripcion Descripción del casting.
     * @param fechaContratacion Fecha de contratación del casting.
     * @param cliente Cliente que contrata el casting.
     */
    public Presencial(String codigoCasting, String nombre, String descripcion, Date fechaContratacion, Cliente cliente, Agente agente, List<Fase> listaFases, List<Perfil> listaPerfiles) {
        super(codigoCasting, nombre, descripcion, fechaContratacion, cliente);
        this.agente = agente;
        this.listaFases = listaFases;
        this.listaPerfiles = listaPerfiles;
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
     * @param noPersonas Número de personas del casting.
     * @param agente Agente que dirige el casting.
     * @param listaFases Lista de fases que tiene el casting.
     */
    public Presencial(String codigoCasting, String nombre, String descripcion, Date fechaContratacion, Cliente cliente, int noPersonas, Agente agente, List<Fase> listaFases) {
        super(codigoCasting, nombre, descripcion, fechaContratacion, cliente);
        this.noPersonas = noPersonas;
        this.agente = agente;
        this.listaFases = listaFases;
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
     * @param noPersonas Número de personas del casting.
     * @param agente Agente que dirige el casting.
     * @param listaFases Lista de fases que tiene el casting.
     */
    public Presencial(String codigoCasting, String nombre, String descripcion, Date fechaContratacion, Cliente cliente, ClienteCasting clienteCasting, int noPersonas, Agente agente, List<Fase> listaFases) {
        super(codigoCasting, nombre, descripcion, fechaContratacion, cliente, clienteCasting);
        this.noPersonas = noPersonas;
        this.agente = agente;
        this.listaFases = listaFases;
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
     * @param noPersonas Número de personas del casting.
     * @param agente Agente que dirige el casting.
     * @param listaFases Lista de fases que tiene el casting.
     */
    public Presencial(ObjectId id, String codigoCasting, String nombre, String descripcion, Date fechaContratacion, Cliente cliente, ClienteCasting clienteCasting, int noPersonas, Agente agente, List<Fase> listaFases) {
        super(id, codigoCasting, nombre, descripcion, fechaContratacion, cliente, clienteCasting);
        this.noPersonas = noPersonas;
        this.agente = agente;
        this.listaFases = listaFases;
    }

    /**
     * Método para obtener al agente del casting.
     *
     * @return Agente que dirige el casting.
     */
    public Agente getAgente() {
        return agente;
    }

    /**
     * Método para establecer al agente del casting.
     *
     * @param agente Agente que dirige el casting.
     */
    public void setAgente(Agente agente) {
        this.agente = agente;
    }

    /**
     * Método para obtener la lista de fases del casting.
     *
     * @return Lista de fases que tiene el casting.
     */
    public List<Fase> getListaFases() {
        return listaFases;
    }

    /**
     * Método para establecer la lista de fases del casting.
     *
     * @param listaFases Lista de fases que tiene el casting.
     */
    public void setListaFases(List<Fase> listaFases) {
        this.listaFases = listaFases;
    }

    /**
     * Método para obtener la lista de perfiles del casting.
     *
     * @return Lista de perfiles tiene el casting.
     */
    public List<Perfil> getListaPerfiles() {
        return listaPerfiles;
    }

    /**
     * Método para establecer la lista de perfiles del casting.
     *
     * @param listaPerfiles Lista de perfiles tiene el casting.
     */
    public void setListaPerfiles(List<Perfil> listaPerfiles) {
        this.listaPerfiles = listaPerfiles;
    }

    /**
     * Método para obtener el número de personas del casting.
     *
     * @return Número de personas del casting.
     */
    public int getNoPersonas() {
        return noPersonas;
    }

    /**
     * Método para establecer el número de personas del casting.
     *
     * @param noPersonas Número de personas del casting.
     */
    public void setNoPersonas(int noPersonas) {
        this.noPersonas = noPersonas;
    }

    /**
     * Método que se encarga de regresar una cadena de texto con los datos del
     * casting.
     *
     * @return Cadena de texto con atributos de la clase.
     */
    @Override
    public String toString() {
        return "Presencial{" + "agente=" + agente + ", listaFases=" + listaFases + ", listaPerfiles=" + listaPerfiles + '}';
    }

}
