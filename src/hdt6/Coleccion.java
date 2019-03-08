/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hdt6;

import java.util.Map;

/**
 *
 * @author Luis Perez Aju && Francisco Rosal
 */
public class Coleccion {
    Map<String, String> cartas;
    
    public void asignarMapa(Map mapa){
        this.cartas = mapa;
    }
    
    public void agregarCarta(String nombre, String tipo){
        cartas.put(nombre, tipo);        
    }
    
}
