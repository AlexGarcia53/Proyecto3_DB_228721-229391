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
 * Clase que representa la relación entre cliente y casting.
 *
 * @author Equipo 3
 */
public class ClienteCasting {

    /**
     * Identificador único para el ClienteCasting.
     */
    private ObjectId id;
    /**
     * Costo del casting.
     */
    private double coste;
    /**
     * Cliente que contrata el casting.
     */
    private Cliente cliente;
    /**
     * Lista de castings.
     */
    private List<Casting> listaCastings;

    /**
     * Constructor vacío de ClienteCasting.
     */
    public ClienteCasting() {
    }

    /**
     * Constructor que inicializa el atributo de Coste.
     *
     * @param coste Costo del casting.
     */
    public ClienteCasting(double coste) {
        this.coste = coste;
    }

    /**
     * Constructor que inicializa los atributos con los valores dados por los
     * parámetros.
     *
     * @param coste Costo del casting.
     * @param cliente Cliente que contrata el casting.
     */
    public ClienteCasting(double coste, Cliente cliente) {
        this.coste = coste;
        this.cliente = cliente;
    }

    /**
     * Constructor que inicializa los atributos con los valores dados por los
     * parámetros.
     *
     * @param coste Costo del casting.
     * @param cliente Cliente que contrata el casting.
     * @param listaCastings Lista de castings.
     */
    public ClienteCasting(double coste, Cliente cliente, List<Casting> listaCastings) {
        this.coste = coste;
        this.cliente = cliente;
        this.listaCastings = listaCastings;
    }

    /**
     * Constructor que inicializa los atributos con los valores dados por los
     * parámetros.
     *
     * @param id Identificador único para el ClienteCasting.
     * @param coste Costo del casting.
     */
    public ClienteCasting(ObjectId id, double coste) {
        this.id = id;
        this.coste = coste;
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
     * Método para establecer el identificador único del ClienteCasting.
     *
     * @param id Identificador único del ClienteCasting.
     */
    public void setId(ObjectId id) {
        this.id = id;
    }

    /**
     * Método para obtener el costo del casting.
     *
     * @return Costo del casting.
     */
    public double getCoste() {
        return coste;
    }

    /**
     * Método para establecer el costo del casting.
     *
     * @param coste Costo del casting.
     */
    public void setCoste(double coste) {
        this.coste = coste;
    }

    /**
     * Método para obtener al cliente.
     *
     * @return Cliente que contrata el casting.
     */
    public Cliente getCliente() {
        return cliente;
    }

    /**
     * Método para establecer al cliente.
     *
     * @param cliente Cliente que contrata el casting.
     */
    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    /**
     * Método para obtener la lista de castings.
     *
     * @return Lista de castings.
     */
    public List<Casting> getListaCastings() {
        return listaCastings;
    }

    /**
     * Método para establecer la lista de castings.
     *
     * @param listaCastings Lista de castings.
     */
    public void setListaCastings(List<Casting> listaCastings) {
        this.listaCastings = listaCastings;
    }

    /**
     * Método hashCode.
     *
     * @return código hash.
     */
    @Override
    public int hashCode() {
        int hash = 7;
        hash = 53 * hash + Objects.hashCode(this.id);
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
        final ClienteCasting other = (ClienteCasting) obj;
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
     * ClienteCasting.
     *
     * @return Cadena de texto con atributos de la clase.
     */
    @Override
    public String toString() {
        return "ClienteCasting{" + "coste=" + coste + ", cliente=" + cliente + '}';
    }

}
