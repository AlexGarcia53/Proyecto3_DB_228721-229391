/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Datos;

/**
 * Clase fabrica que se utiliza para inicializar al atributo de tipo IDatos.
 *
 * @author Equipo 3
 */
public class FabricaDatos {
    /**
     * Atributo de tipo IDatos.
     */
    private static IDatos datos;
    /**
     * Método utilizado para crear la fachada de datos.
     * @return atributo datos inicializado.
     */
    public static IDatos crearFachadaDatos(){
        if(datos == null){
            datos= new FachadaDatos();
        }
        return datos;
    }
}
