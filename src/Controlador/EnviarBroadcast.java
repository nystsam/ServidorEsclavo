/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import Recursos.Util;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Daniel
 */
public class EnviarBroadcast extends Thread{
    
    public EnviarBroadcast(){
        
    }
    
    @Override
    public void run(){
        
        try {
            DatagramSocket socketUDP = new DatagramSocket();
            String aaa = "asdasd";
            byte[] mensaje = aaa.getBytes();
            InetAddress hostServidor = InetAddress.getByName("localhost");

            // Construimos un datagrama para enviar el mensaje al servidor
            DatagramPacket peticion = new DatagramPacket(mensaje, mensaje.length, hostServidor, Util.puertoUDP);

            // Enviamos el datagrama
            socketUDP.send(peticion);

            // Construimos el DatagramPacket que contendrá la respuesta
            byte[] bufer = new byte[1000];
            DatagramPacket respuesta =
              new DatagramPacket(bufer, bufer.length);
            socketUDP.receive(respuesta);

            // Enviamos la respuesta del servidor a la salida estandar
            System.out.println("Respuesta: " + new String(respuesta.getData()));

            // Cerramos el socket
            socketUDP.close();
            
        } catch (SocketException ex) {
            Logger.getLogger(EnviarBroadcast.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(EnviarBroadcast.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        
    }
    
}
