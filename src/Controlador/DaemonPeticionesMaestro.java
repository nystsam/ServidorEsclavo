/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import Utils.Utils;
import java.net.ServerSocket;
import java.net.Socket;

/**
 *
 * @author LAB_A112
 */
public class DaemonPeticionesMaestro extends Thread {
    
    public DaemonPeticionesMaestro(){
        
    }
    
    @Override
    public void run(){
        
        ServerSocket ss;
        Socket so;
        try{
            
            ss = new ServerSocket(Utils.puerto);
            
            while (true){
                
                System.out.println("Esperando petciones del Maestro por el puerto: " + Utils.puerto);
                so = ss.accept();
                System.out.println( "Peticion recibida... Atendiendo peticion\n");
                
                // Atender solicitud 
                PeticionesMaestro atender = new PeticionesMaestro(so);
                atender.start();
                
            }
        }catch(Exception e ){
            System.out.println("Exploto el hilo...");
        }
        
    }
    
}
