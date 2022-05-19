/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Datos;

import com.mongodb.client.MongoDatabase;

/**
 * Interfaz implementada por ConexionDB
 *
 * @author Equipo 3
 */
interface IConexionBD {

    public MongoDatabase crearConexion();
}
