/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import Modelo.Peticion;
import java.io.ByteArrayInputStream;
import java.io.DataInputStream;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectInputStream;
import java.net.Socket;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author LAB_A112
 */
public class PeticionesMaestro extends Thread {
    
    private final Socket so;
    
    public PeticionesMaestro(Socket so){
        
        this.so = so;
        
    }
    
    private Object convertFromBytes(byte[] bytes) throws IOException, ClassNotFoundException {

        try (ByteArrayInputStream bis = new ByteArrayInputStream(bytes);
            ObjectInput in = new ObjectInputStream(bis)) {
            return in.readObject();
        }
    }
    
    
    @Override
    public void run(){
          
        try {
            DataInputStream input = new DataInputStream(this.so.getInputStream());
            
            Peticion peticion = this.convertFromBytes(input.readByte());
            //System.out.println(comando);
            
            
            
        } catch (IOException ex) {
            Logger.getLogger(PeticionesMaestro.class.getName()).log(Level.SEVERE, null, ex);
        }

            
        
    }
    
    
    
}
