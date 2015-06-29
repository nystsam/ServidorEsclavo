/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import Utils.Utils;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.MulticastSocket;
import java.net.SocketException;
import java.nio.charset.Charset;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Daniel
 */
public class EnviarMulticast extends Thread{
    
    public EnviarMulticast(){
        
    }
    
    @Override
    public void run(){
        
        try {
            InetAddress group = InetAddress.getByName("226.4.5.6");
            MulticastSocket multicastSock = new MulticastSocket();
            String msg = String.valueOf(Utils.puerto);
            
            byte[] objeto = msg.getBytes(Charset.forName("UTF-8"));
            DatagramPacket packet = new DatagramPacket(objeto,objeto.length, group,Utils.puertoMulticast);
            multicastSock.send(packet);
            multicastSock.close();
            
        } catch (SocketException ex) {
            Logger.getLogger(EnviarMulticast.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(EnviarMulticast.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        
    }
    
}
