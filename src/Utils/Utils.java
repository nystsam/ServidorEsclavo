/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Utils;

import Modelo.ListaRedes;
import Modelo.Red;

/**
 *
 * @author Daniel
 */
public class Utils {
    
    public static int puerto = 55500;
    public static int puertoMulticast = 56000;
    public static Red redConectada = new Red(null,null);
    public static ListaRedes listaRedes = new ListaRedes();
    
    public static boolean AplicacionIniciada = false;
    public static ListaRedes redes = new ListaRedes();

    
}
