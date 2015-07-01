/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import Modelo.Archivo;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import Utils.Utils;

/**
 *
 * @author Daniel
 */
public class CargaArchivos {
    
    public CargaArchivos(){
        
    }
    
    public boolean registrarArchivos(){
        
        File directorio = new File("C:/Archivos-SD/");
        BufferedReader  br = null;
        
        try {
        
        for (File archivoLeido : directorio.listFiles()) {

            Archivo nuevoArchivo;
            String extension = "", contenido;
            StringBuilder sb = new StringBuilder();

                    
            int i = archivoLeido.getName().lastIndexOf('.');
            if (i != -1) {
                extension = archivoLeido.getName().substring(i+1);
            }
            
            br = new BufferedReader(new FileReader(archivoLeido));
            String line = br.readLine();

            while (line != null) {
                sb.append(line);
                sb.append(System.lineSeparator());
                
                line = br.readLine();
            }
            
            contenido = sb.toString();

            nuevoArchivo = new Archivo(archivoLeido.getName().split("\\.")[0],extension,contenido);
            Utils.listaArchivos.getLista().add(nuevoArchivo);
            
        }
        
            
        } catch (FileNotFoundException ex) {
            Logger.getLogger(CargaArchivos.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(CargaArchivos.class.getName()).log(Level.SEVERE, null, ex);
        }
            
        return false;
        
    }
            
        
    
}
