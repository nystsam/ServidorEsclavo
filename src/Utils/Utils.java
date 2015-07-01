/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Utils;

import Modelo.ListaArchivos;
import Modelo.ListaRedes;
import Modelo.Red;
import javax.swing.JComboBox;
import javax.swing.JFrame;

/**
 *
 * @author Daniel
 */
public class Utils {
    
    public static int puerto = 57000;
    public static int puertoMulticast = 56000;
    public static Red redConectada = new Red(null,null);
    // Lista de las redes disponibles para la union
    public static ListaRedes listaRedes = new ListaRedes();
    
    public static ListaArchivos listaArchivos = new ListaArchivos();
    public static JFrame ventana;
    
    public static String ipMaestroLlegada;
    public static JComboBox listaServidores;
    
    public static boolean AplicacionIniciada = false;
    public static ListaRedes redes = new ListaRedes();
    public static boolean enUso = false;

    
}
