/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Vista;

import Controlador.CargaArchivos;
import Controlador.DaemonPeticionesMaestro;
import Controlador.EnviarMulticast;

/**
 *
 * @author Daniel
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        CargaArchivos cargado = new CargaArchivos();
        cargado.registrarArchivos();
        
        DaemonPeticionesMaestro peticionesMaestro = new DaemonPeticionesMaestro();
        peticionesMaestro.start();
        
        Ventana ventana = new Ventana();
        ventana.setVisible(true);
        
        
    }
    
}
