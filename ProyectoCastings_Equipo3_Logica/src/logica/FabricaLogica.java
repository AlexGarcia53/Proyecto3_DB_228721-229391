/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package logica;


/**
 * Clase fabrica que se utiliza para inicializar al atributo de tipo ILogica.
 *
 * @author Equipo 3
 */
public class FabricaLogica {
    private static ILogica logica;
    
    public static ILogica crearLogica(){
        if(logica == null){
            logica= new FachadaLogica();
        }
        return logica;
    }
}
