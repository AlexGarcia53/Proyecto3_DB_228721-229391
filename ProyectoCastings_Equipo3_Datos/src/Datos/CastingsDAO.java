/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Datos;

import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import com.mongodb.client.model.Filters;
import static com.mongodb.client.model.Filters.*;
import dominio.Perfil;
import dominio.Presencial;
import java.util.Arrays;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;
import java.util.regex.Pattern;
import org.bson.Document;

/**
 * Clase de acceso de datos para los castings.
 *
 * @author Equipo 3
 */
class CastingsDAO implements ICastingsDAO {

    /**
     * Atributo para crear conexión a la base de datos.
     */
    private IConexionBD conexion;
    /**
     * Atributo para acceder a la base de datos.
     */
    private MongoDatabase baseDatos;
    /**
     * Atributo de tipo CastingsDAO.
     */
    private static CastingsDAO castingsDAO;

    /**
     * Constructor que inicia la conexión con la base de datos.
     */
    private CastingsDAO() {
        this.conexion = ConexionBD.obtenerConexion();
        this.baseDatos = this.conexion.crearConexion();
    }

    /**
     * Método utilizado para obtener a castingsDAO.
     *
     * @return atributo de tipo CastingsDAO
     */
    public static CastingsDAO obtenerCastingsDAO() {
        if (castingsDAO == null) {
            castingsDAO = new CastingsDAO();
        }
        return castingsDAO;
    }

    /**
     * Método para obtener la colección de castings.
     *
     * @return Colección de castings.
     */
    private MongoCollection<Presencial> getColeccion() {
        return this.baseDatos.getCollection("CastingsPresenciales", Presencial.class);
    }

    /**
     * Método para agregar un registro a la colección de castings.
     *
     * @param casting Casting a agregar.
     */
    @Override
    public void agregar(Presencial casting) {
        MongoCollection<Presencial> coleccion = this.getColeccion();
        coleccion.insertOne(casting);
    }

    /**
     * Método utilizado para consultar castings por su fecha de contratación.
     *
     * @param fecha fecha de contratación del casting.
     * @return lista de castings con fecha coincidente.
     */
    @Override
    public List<Presencial> consultarFecha(Date fecha) {
        MongoCollection<Presencial> coleccion = this.getColeccion();
        List<Document> etapas = new LinkedList<Document>();
        etapas.add(new Document()
                .append("$match", new Document()
                        .append("fechaContratacion", fecha))
        );

        List<Presencial> castings = new LinkedList<>();
        coleccion.aggregate(etapas).into(castings);
        return castings;
    }

    /**
     * Método utilizado para consultar castings por su código.
     *
     * @param codigo Código de casting.
     * @return lista de castings con código coincidente.
     */
    @Override
    public Presencial consultarCodigo(String codigo) {
        MongoCollection<Presencial> coleccion = this.getColeccion();
        List<Document> etapas = new LinkedList<Document>();
        etapas.add(new Document()
                .append("$match", new Document()
                        .append("codigoCasting", codigo))
        );

        List<Presencial> castings = new LinkedList<>();
        coleccion.aggregate(etapas).into(castings);
        if (castings.size() > 0) {
            return castings.get(0);
        }
        return null;
    }

    /**
     * Método utilizado para consultar castings por su nombre.
     *
     * @param nombre Nombre del casting.
     * @return lista de castings con nombre coincidente.
     */
    @Override
    public Presencial consultarNombre(String nombre) {
        MongoCollection<Presencial> coleccion = this.getColeccion();
        List<Document> etapas = new LinkedList<Document>();
        Pattern patron = Pattern.compile("/" + nombre + "/i");
        etapas.add(new Document()
                .append("$match", new Document()
                        .append("nombre", new Document().append("$regex", nombre).append("$options", "i")))
        );

        List<Presencial> castings = new LinkedList<>();
        coleccion.aggregate(etapas).into(castings);
        if (castings.size() > 0) {
            return castings.get(0);
        }
        return null;
    }

    /**
     * Método utilizado para consultar castings por su fecha de contratación y
     * código.
     *
     * @param fecha fecha de contratación del casting.
     * @param codigo Código de casting.
     * @return lista de castings con fecha y código coincidente.
     */
    @Override
    public List<Presencial> consultarFechaCodigo(Date fecha, String codigo) {
        MongoCollection<Presencial> coleccion = this.getColeccion();
        List<Document> etapas = new LinkedList<Document>();
        etapas.add(new Document()
                .append("$match", new Document()
                        .append("$or", Arrays.asList(new Document[]{new Document("fechaContratacion", fecha), new Document("codigoCasting", codigo)})))
        );

        List<Presencial> castings = new LinkedList<>();
        coleccion.aggregate(etapas).into(castings);
        return castings;
    }

    /**
     * Método utilizado para consultar castings por su fecha de contratación y
     * nombre.
     *
     * @param fecha fecha de contratación del casting.
     * @param nombre Nombre del casting.
     * @return lista de castings con fecha y nombre coincidente.
     */
    @Override
    public List<Presencial> consultarFechaNombre(Date fecha, String nombre) {
        MongoCollection<Presencial> coleccion = this.getColeccion();
        List<Document> etapas = new LinkedList<Document>();
        etapas.add(new Document()
                .append("$match", new Document()
                        .append("$or", Arrays.asList(new Document[]{new Document("fechaContratacion", fecha), new Document("nombre", new Document().append("$regex", nombre).append("$options", "i"))})))
        );

        List<Presencial> castings = new LinkedList<>();
        coleccion.aggregate(etapas).into(castings);
        return castings;
    }

    /**
     * Método utilizado para consultar castings por su código y nombre.
     *
     * @param codigo Código de casting.
     * @param nombre Nombre del casting.
     * @return lista de castings con código y nombre coincidente.
     */
    @Override
    public List<Presencial> consultarCodigoNombre(String codigo, String nombre) {
        MongoCollection<Presencial> coleccion = this.getColeccion();
        List<Document> etapas = new LinkedList<Document>();
        etapas.add(new Document()
                .append("$match", new Document()
                        .append("$or", Arrays.asList(new Document[]{new Document("codigoCasting", codigo), new Document("nombre", new Document().append("$regex", nombre).append("$options", "i"))})))
        );

        List<Presencial> castings = new LinkedList<>();
        coleccion.aggregate(etapas).into(castings);
        return castings;
    }

    /**
     * Método utilizado para consultar castings por su código, fecha de
     * contratación y nombre.
     *
     * @param fecha fecha de contratación del casting.
     * @param codigo Código de casting.
     * @param nombre Nombre del casting.
     * @return lista de castings con código y nombre coincidente.
     */
    @Override
    public List<Presencial> consultarFechaCodigoNombre(Date fecha, String codigo, String nombre) {
        MongoCollection<Presencial> coleccion = this.getColeccion();
        List<Document> etapas = new LinkedList<Document>();
        etapas.add(new Document()
                .append("$match", new Document()
                        .append("$or", Arrays.asList(new Document[]{new Document("fechaContratacion", fecha), new Document("codigoCasting", codigo), new Document("nombre", new Document().append("$regex", nombre).append("$options", "i"))})))
        );

        List<Presencial> castings = new LinkedList<>();
        coleccion.aggregate(etapas).into(castings);
        return castings;
    }

    /**
     * Método para consultar todos los registros de casting.
     *
     * @return lista con los registros de casting.
     */
    @Override
    public List<Presencial> consultarTodos() {
        MongoCollection<Presencial> coleccion = this.getColeccion();
        List<Presencial> listaCastings = new LinkedList<>();
        coleccion.find().into(listaCastings);
        return listaCastings;
    }

    /**
     * Método para agregar un perfil al casting.
     *
     * @param presencial casting al que se le agregará el perfil.
     * @param perfil perfil a agregar.
     */
    @Override
    public void agregarPerfil(Presencial presencial, Perfil perfil) {
        MongoCollection<Presencial> coleccion = this.getColeccion();
        Document filtro = new Document("codigoCasting", presencial.getCodigoCasting());
        Document actualizacion = new Document("$addToSet", new Document("perfiles", perfil));
        coleccion.updateOne(filtro, actualizacion);
        //        collection.updateOne(new Document(), new Document("$addToSet", new Document("categorias", "Ecologico")));
    }

    /**
     * Método para verificar la existencia del campo perfil en el casting.
     *
     * @param codigo código del casting.
     * @return registro de casting.
     */
    @Override
    public Presencial verificarExistenciaCampoPerfil(String codigo) {
        MongoCollection<Presencial> coleccion = this.getColeccion();
        List<Document> etapas = new LinkedList<Document>();
        etapas.add(new Document()
                .append("$match", new Document()
                        .append("codigoCasting", codigo)
                        .append("perfiles", new Document().append("$exists", true)))
        );

        List<Presencial> castings = new LinkedList<>();
        coleccion.aggregate(etapas).into(castings);
        if (castings.size() > 0) {
            return castings.get(0);
        }
        return null;
    }

    /**
     * Método para agregar el campo perfil en el casting.
     *
     * @param codigo código del casting.
     */
    @Override
    public void agregarCampoPerfil(String codigo) {
        MongoCollection<Presencial> coleccion = this.getColeccion();
        List<Document> etapas = new LinkedList<Document>();
        etapas.add(new Document()
                .append("$match", new Document()
                        .append("codigoCasting", codigo))
        );
        etapas.add(new Document()
                .append("$addFields", new Document()
                        .append("perfiles", "[]"))
        );

        coleccion.aggregate(etapas);
    }

    /**
     * Método para verificar que el casting no tenga un perfil registrado con el
     * mismo código.
     *
     * @param codigoCasting código del casting.
     * @param codigoPerfil código del perfil.
     * @return registro de casting.
     */
    @Override
    public Presencial verificarPerfilExistente(String codigoCasting, String codigoPerfil) {
        MongoCollection<Presencial> coleccion = this.getColeccion();
        List<Presencial> castings = new LinkedList<>();
        coleccion.find(new Document().append("codigoCasting", codigoCasting).append("perfiles.codigoPerfil", new Document("$in", Arrays.asList(codigoPerfil)))).into(castings);
        if (castings.size() > 0) {
            return castings.get(0);
        }
        return null;
    }

    /**
     * Método para consultar castings vigentes.
     *
     * @param fecha fecha de vigencia.
     * @return lista de castings vigentes.
     */
    @Override
    public List<Presencial> consultarVigentes(Date fecha) {
        MongoCollection<Presencial> coleccion = this.getColeccion();
        List<Presencial> castings = new LinkedList<>();
        coleccion.find(new Document()).into(castings);
        return castings;
    }

}
