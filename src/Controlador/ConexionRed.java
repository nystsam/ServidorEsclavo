/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import Modelo.Equipo;
import Modelo.ListaRedes;
import javax.swing.JOptionPane;
import Modelo.Red;
import Utils.Utils;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.util.logging.Level;
import java.util.logging.Logger;
import static javax.swing.JOptionPane.INFORMATION_MESSAGE;

/**
 *
 * @author Daniel
 */
public class ConexionRed extends Thread {
    
    private String nombreRed;
    
    public ConexionRed(String nombreRed){
        this.nombreRed = nombreRed;
    }
    
    @Override
    public void run(){
        
        Red redMaestro = new Red(null, null);
        
        try {
            
            for(int i = 0; i <  Utils.listaRedes.getLista().size(); i++){
                redMaestro = Utils.listaRedes.getLista().get(i);
                if(redMaestro.getNombre().equals(this.nombreRed)){
                    
                    Socket so = new Socket(redMaestro.getIp(),redMaestro.getPuerto());
                    ObjectOutputStream output = new ObjectOutputStream(so.getOutputStream());
                    
                    Equipo equipoLocal = new Equipo();
                    equipoLocal.setArchivos(Utils.listaArchivos);
                    equipoLocal.setPuerto(Utils.puerto);
                    
                    output.writeObject(equipoLocal);
                    output.flush();
                    
                    ObjectInputStream input = new ObjectInputStream(so.getInputStream());
                    String respuesta = input.readUTF();
                    if(respuesta.equals("Ok")){
                    
                        String mensaje = "Se ha conectado a la red "+this.nombreRed.toUpperCase()+" con exito.";
                        JOptionPane.showMessageDialog(Utils.ventana, mensaje);
                        System.out.println(mensaje);
                        Utils.redConectada = redMaestro;
                    }
                    
                    so.close();
                    
                }
                
            }
            
                
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(Utils.ventana, "Error al conectarse con el Servidor Maestro", 
            "Error",JOptionPane.ERROR_MESSAGE);
            
            Utils.objetoVentana.botonDescubrir.setEnabled(true);
            Utils.listaRedes = new ListaRedes();
            Utils.objetoVentana.botonConectar.setEnabled(false);
            Utils.listaServidores.removeAllItems();
            
        }
        

        
    }
    
}
