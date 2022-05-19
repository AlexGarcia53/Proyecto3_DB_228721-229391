/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Datos;

import com.mongodb.ConnectionString;
import com.mongodb.MongoClientSettings;
import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoDatabase;
import static org.bson.codecs.configuration.CodecRegistries.fromProviders;
import static org.bson.codecs.configuration.CodecRegistries.fromRegistries;
import org.bson.codecs.configuration.CodecRegistry;
import org.bson.codecs.pojo.PojoCodecProvider;

/**
 * Clase que representa la conexión a la base de datos.
 *
 * @author Equipo 3
 */
class ConexionBD implements IConexionBD {

    /**
     * Host utilizado para conectar a la base de datos.
     */
    private static final String HOST = "localhost";
    /**
     * Puerto utilizado para conectar a la base de datos.
     */
    private static final int PUERTO = 27017;
    /**
     * Base de datos a utilizar.
     */
    private static final String BASE_DATOS = "Castings";
    /**
     * Atributo de ConexionBD.
     */
    private static ConexionBD conexionBD;

    /**
     * Constructor vacío.
     */
    private ConexionBD() {

    }

    /**
     * Método utilizado para obtener la conexión.
     *
     * @return atributo de ConexionBD.
     */
    public static ConexionBD obtenerConexion() {
        if (conexionBD == null) {
            conexionBD = new ConexionBD();
        }
        return conexionBD;
    }

    /**
     * Método para crear la conexión con la base de datos.
     *
     * @return conexión a base de datos.
     */
    @Override
    public MongoDatabase crearConexion() {
        try {
            //CONFIGURACIÓN PARA QUE MONGODRIVE REALICE EL MAPEO DE POJOS AUMATICAMENTE
            CodecRegistry pojoCodecRegistry = fromProviders(PojoCodecProvider.builder().automatic(true).build());

            CodecRegistry codecRegistry = fromRegistries(MongoClientSettings.getDefaultCodecRegistry(), pojoCodecRegistry);

            ConnectionString cadenaConexion = new ConnectionString("mongodb://" + HOST + "/" + PUERTO);

            MongoClientSettings clientsSettings = MongoClientSettings.builder()
                    .applyConnectionString(cadenaConexion)
                    .codecRegistry(codecRegistry)
                    .build();

            MongoClient clienteMongo = MongoClients.create(clientsSettings);

            MongoDatabase baseDatos = clienteMongo.getDatabase(BASE_DATOS);

            return baseDatos;
        } catch (Exception ex) {
            System.err.println(ex.getMessage());
            return null;
        }
    }

}
