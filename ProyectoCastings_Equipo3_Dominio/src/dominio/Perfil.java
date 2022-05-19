/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dominio;

import Excepciones.DatosPerfilErroneosException;
import java.util.List;
import java.util.Objects;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import org.bson.types.ObjectId;

/**
 * Clase que representa a la entidad Perfil.
 *
 * @author Equipo 3
 */
public class Perfil {

    /**
     * Identificador único del perfil.
     */
    private ObjectId id;
    /**
     * Código del perfil.
     */
    private String codigoPerfil;
    /**
     * Estado del perfil.
     */
    private Estado estado;
    /**
     * Sexo del perfil.
     */
    private String sexo;
    /**
     * Rango de altura del perfil.
     */
    private RangoAltura rangoAltura;
    /**
     * Rango de edad del perfil.
     */
    private RangoEdad rangoEdad;
    /**
     * Color de pelo del perfil.
     */
    private String colorPelo;
    /**
     * Color de ojos del perfil.
     */
    private String colorOjos;
    /**
     * Experiencia del perfil.
     */
    private boolean experiencia;
    /**
     * Especialidad del perfil.
     */
    private Especialidad especialidad;
    /**
     * Lista de castings del perfil.
     */
    private List<Presencial> listaPresenciales;
    /**
     * Lista de candidatos del pefil.
     */
    private List<Candidato> listaCandidatos;

    /**
     * Contructor vacío de Perfil.
     */
    public Perfil() {
    }

    /**
     * Constructor que inicializa los atributos con los valores dados por los
     * parámetros.
     *
     * @param codigoPerfil Código del perfil.
     * @param estado Estado del perfil.
     * @param sexo Sexo del perfil.
     * @param rangoAltura Rango de altura del perfil.
     * @param rangoEdad Rango de edad del perfil.
     * @param colorPelo Color de pelo del perfil.
     * @param colorOjos Color de ojos del perfil.
     * @param experiencia Experiencia del perfil.
     */
    public Perfil(String codigoPerfil, Estado estado, String sexo, RangoAltura rangoAltura, RangoEdad rangoEdad, String colorPelo, String colorOjos, boolean experiencia) {
        this.codigoPerfil = codigoPerfil;
        this.estado = estado;
        this.sexo = sexo;
        this.rangoAltura = rangoAltura;
        this.rangoEdad = rangoEdad;
        this.colorPelo = colorPelo;
        this.colorOjos = colorOjos;
        this.experiencia = experiencia;
    }

    /**
     * Constructor que inicializa los atributos con los valores dados por los
     * parámetros.
     *
     * @param codigoPerfil Código del perfil.
     * @param estado Estado del perfil.
     * @param sexo Sexo del perfil.
     * @param rangoAltura Rango de altura del perfil.
     * @param rangoEdad Rango de edad del perfil.
     * @param colorPelo Color de pelo del perfil.
     * @param colorOjos Color de ojos del perfil.
     * @param experiencia Experiencia del perfil.
     * @param especialidad Especialidad del perfil.
     */
    public Perfil(String codigoPerfil, Estado estado, String sexo, RangoAltura rangoAltura, RangoEdad rangoEdad, String colorPelo, String colorOjos, boolean experiencia, Especialidad especialidad) {
        this.codigoPerfil = codigoPerfil;
        this.estado = estado;
        this.sexo = sexo;
        this.rangoAltura = rangoAltura;
        this.rangoEdad = rangoEdad;
        this.colorPelo = colorPelo;
        this.colorOjos = colorOjos;
        this.experiencia = experiencia;
        this.especialidad = especialidad;
    }

    /**
     * Constructor que inicializa los atributos con los valores dados por los
     * parámetros.
     *
     * @param codigoPerfil Identificador único del perfil.
     * @param estado Estado del perfil.
     * @param sexo Sexo del perfil.
     * @param rangoAltura Rango de altura del perfil.
     * @param rangoEdad Rango de edad del perfil.
     * @param colorPelo Color de pelo del perfil.
     * @param colorOjos Color de ojos del perfil.
     * @param experiencia Experiencia del perfil.
     * @param especialidad Especialidad del perfil.
     * @param listaPresenciales Lista de castings del perfil.
     * @param listaCandidatos Lista de candidatos del pefil.
     */
    public Perfil(String codigoPerfil, Estado estado, String sexo, RangoAltura rangoAltura, RangoEdad rangoEdad, String colorPelo, String colorOjos, boolean experiencia, Especialidad especialidad, List<Presencial> listaPresenciales, List<Candidato> listaCandidatos) {
        this.codigoPerfil = codigoPerfil;
        this.estado = estado;
        this.sexo = sexo;
        this.rangoAltura = rangoAltura;
        this.rangoEdad = rangoEdad;
        this.colorPelo = colorPelo;
        this.colorOjos = colorOjos;
        this.experiencia = experiencia;
        this.especialidad = especialidad;
        this.listaPresenciales = listaPresenciales;
        this.listaCandidatos = listaCandidatos;
    }

    /**
     * Constructor que inicializa los atributos con los valores dados por los
     * parámetros.
     *
     * @param id Identificador único del perfil.
     * @param codigoPerfil Identificador único del perfil.
     * @param estado Estado del perfil.
     * @param sexo Sexo del perfil.
     * @param rangoAltura Rango de altura del perfil.
     * @param rangoEdad Rango de edad del perfil.
     * @param colorPelo Color de pelo del perfil.
     * @param colorOjos Color de ojos del perfil.
     * @param experiencia Experiencia del perfil.
     * @param especialidad Especialidad del perfil.
     */
    public Perfil(ObjectId id, String codigoPerfil, Estado estado, String sexo, RangoAltura rangoAltura, RangoEdad rangoEdad, String colorPelo, String colorOjos, boolean experiencia, Especialidad especialidad) {
        this.id = id;
        this.codigoPerfil = codigoPerfil;
        this.estado = estado;
        this.sexo = sexo;
        this.rangoAltura = rangoAltura;
        this.rangoEdad = rangoEdad;
        this.colorPelo = colorPelo;
        this.colorOjos = colorOjos;
        this.experiencia = experiencia;
        this.especialidad = especialidad;
    }

    /**
     * Método para obtener el identificador único del perfil.
     *
     * @return Identificador único del perfil.
     */
    public ObjectId getId() {
        return id;
    }

    /**
     * Método para establecer el identificador único del perfil.
     *
     * @param id Identificador único del perfil.
     */
    public void setId(ObjectId id) {
        this.id = id;
    }

    /**
     * Método para obtener el código del perfil.
     *
     * @return Código del perfil.
     */
    public String getCodigoPerfil() {
        return codigoPerfil;
    }

    /**
     * Método para establecer el código del perfil.
     *
     * @param codigoPerfil Código del perfil.
     */
    public void setCodigoPerfil(String codigoPerfil) {
        this.codigoPerfil = codigoPerfil;
    }

    /**
     * Método para obtener el estado del perfil.
     *
     * @return Estado del perfil.
     */
    public Estado getEstado() {
        return estado;
    }

    /**
     * Método para establecer el estado del perfil.
     *
     * @param estado Estado del perfil.
     */
    public void setEstado(Estado estado) {
        this.estado = estado;
    }

    /**
     * Método para obtener el sexo del perfil.
     *
     * @return Sexo del perfil.
     */
    public String isSexo() {
        return sexo;
    }

    /**
     * Método para establecer el sexo del perfil.
     *
     * @param sexo Sexo del perfil.
     */
    public void setSexo(String sexo) {
        this.sexo = sexo;
    }

    /**
     * Método para obtener el rango de altura del perfil.
     *
     * @return Rango de altura del perfil.
     */
    public RangoAltura getRangoAltura() {
        return rangoAltura;
    }

    /**
     * Método para establecer el rango de altura del perfil.
     *
     * @param rangoAltura Rango de altura del perfil.
     */
    public void setRangoAltura(RangoAltura rangoAltura) {
        this.rangoAltura = rangoAltura;
    }

    /**
     * Método para obtener el rango de edad del perfil.
     *
     * @return Rango de edad del perfil.
     */
    public RangoEdad getRangoEdad() {
        return rangoEdad;
    }

    /**
     * Método para establecer el rango de edad del perfil.
     *
     * @param rangoEdad Rango de edad del perfil.
     */
    public void setRangoEdad(RangoEdad rangoEdad) {
        this.rangoEdad = rangoEdad;
    }

    /**
     * Método para obtener el color de pelo del perfil.
     *
     * @return Color de pelo del perfil.
     */
    public String getColorPelo() {
        return colorPelo;
    }

    /**
     * Método para establecer el color de pelo del perfil.
     *
     * @param colorPelo Color de pelo del perfil.
     */
    public void setColorPelo(String colorPelo) {
        this.colorPelo = colorPelo;
    }

    /**
     * Método para obtener el color de ojos del perfil.
     *
     * @return Color de ojos del perfil.
     */
    public String getColorOjos() {
        return colorOjos;
    }

    /**
     * Método para establecer el color de ojos del perfil.
     *
     * @param colorOjos Color de ojos del perfil.
     */
    public void setColorOjos(String colorOjos) {
        this.colorOjos = colorOjos;
    }

    /**
     * Método para obtener la experiencia del perfil.
     *
     * @return Experiencia del perfil.
     */
    public boolean isExperiencia() {
        return experiencia;
    }

    /**
     * Método para establecer la experiencia del perfil.
     *
     * @param experiencia Experiencia del perfil.
     */
    public void setExperiencia(boolean experiencia) {
        this.experiencia = experiencia;
    }

    /**
     * Método para obtener la especialidad del perfil.
     *
     * @return Especialidad del perfil.
     */
    public Especialidad getEspecialidad() {
        return especialidad;
    }

    /**
     * Método para establecer la especialidad del perfil.
     *
     * @param especialidad Especialidad del perfil.
     */
    public void setEspecialidad(Especialidad especialidad) {
        this.especialidad = especialidad;
    }

    /**
     * Método para obtener la lista de castings del perfil.
     *
     * @return Lista de castings del perfil.
     */
    public List<Presencial> getListaPresenciales() {
        return listaPresenciales;
    }

    /**
     * Método para establecer la lista de castings del perfil.
     *
     * @param listaPresenciales Lista de castings del perfil.
     */
    public void setListaPresenciales(List<Presencial> listaPresenciales) {
        this.listaPresenciales = listaPresenciales;
    }

    /**
     * Método para obtener la lista de castings del perfil.
     *
     * @return Lista de castings del perfil.
     */
    public List<Candidato> getListaCandidatos() {
        return listaCandidatos;
    }

    /**
     * Método para establecer la lista de castings del perfil.
     *
     * @param listaCandidatos Lista de castings del perfil.
     */
    public void setListaCandidatos(List<Candidato> listaCandidatos) {
        this.listaCandidatos = listaCandidatos;
    }

    /**
     * Método hashCode.
     *
     * @return código hash.
     */
    @Override
    public int hashCode() {
        int hash = 7;
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
        final Perfil other = (Perfil) obj;
        if (!Objects.equals(this.id, other.id)) {
            return false;
        }
        return true;
    }

    /**
     * Método para generar el identificador único del perfil.
     */
    public void generarId() {
        this.id = new ObjectId();
    }

    /**
     * Método utilizado para verificar los datos del perfil.
     *
     * @throws DatosPerfilErroneosException Excepción en caso de haber error en
     * los datos.
     */
    public void verificarDatos() throws DatosPerfilErroneosException {
        if (this.codigoPerfil.equals("")) {
            throw new DatosPerfilErroneosException("El código de perfil es vacío");
        } else if (this.sexo.equals("")) {
            throw new DatosPerfilErroneosException("El sexo es vacío");
        } else if (this.colorPelo.equals("")) {
            throw new DatosPerfilErroneosException("El color de pelo es vacío");
        } else if (this.especialidad == null) {
            throw new DatosPerfilErroneosException("La especialidad del perfil es vacía");
        } else if (this.estado == null) {
            throw new DatosPerfilErroneosException("El estado del perfil es vacío");
        } else if (this.rangoAltura == null) {
            throw new DatosPerfilErroneosException("El rango de altura del perfil es vacío");
        } else if (this.rangoEdad == null) {
            throw new DatosPerfilErroneosException("El rango de edad del perfil es vacío");
        }
        Pattern patronColores = Pattern.compile("^([A-Za-zñÑáéíóúÁÉÍÓÚ]+[ ]*){1,5}$");
        Matcher matcherColores = patronColores.matcher(this.colorPelo);
        if (!matcherColores.matches()) {
            throw new DatosPerfilErroneosException("El color de pelo contiene caracteres no válidos");
        }
        matcherColores = patronColores.matcher(this.colorOjos);
        if (!matcherColores.matches()) {
            throw new DatosPerfilErroneosException("El color de ojos contiene caracteres no válidos");
        }

        Pattern patronCodigo = Pattern.compile("^([0-9A-Za-zñÑáéíóúÁÉÍÓÚ]*){1,5}$");
        Matcher matcherCodigo = patronCodigo.matcher(this.codigoPerfil);
        if (!matcherCodigo.matches()) {
            throw new DatosPerfilErroneosException("El código de perfil tiene caracteres no válidos");
        }
    }

    /**
     * Método que se encarga de regresar una cadena de texto con los datos del
     * perfil.
     *
     * @return Cadena de texto con atributos de la clase.
     */
    @Override
    public String toString() {
        return "Perfil{" + "codigoPerfil=" + codigoPerfil + ", estado=" + estado + ", sexo=" + sexo + ", rangoAltura=" + rangoAltura + ", rangoEdad=" + rangoEdad + ", colorPelo=" + colorPelo + ", colorOjos=" + colorOjos + ", experiencia=" + experiencia + '}';
    }

}
