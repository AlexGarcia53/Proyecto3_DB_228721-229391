/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Excepciones;

/**
 * Clase utilizada para lanzar excepciones de tipo datos incorrectos en casting,
 * que extiende de RuntimeException.
 *
 * @author Equipo 3
 */
public class DatosCastingIncorrectosException extends RuntimeException {

    /**
     * Método utilizado para arrojar excepciones sin mensajes.
     */
    public DatosCastingIncorrectosException() {
    }

    /**
     * Método utilizado para arrojar excepciones un mensaje definido.
     *
     * @param string Mensaje a mostrar.
     */
    public DatosCastingIncorrectosException(String string) {
        super(string);
    }

}
