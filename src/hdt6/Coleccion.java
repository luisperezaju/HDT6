/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hdt6;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.SortedSet;
import java.util.stream.Collectors;
import java.util.Map;

/**
 *
 * @author Luis Perez Aju && Francisco Rosal
 */
public class Coleccion {
    private Fac builder;
    
    public Coleccion(){}
    /**
     * 
     * @param param
     * @return 
     */
    
    Map<String, Carta> cartas;
    
    public void asignarMapa(Map mapa){
        this.cartas = mapa;
    }
    
    public void agregarCarta(Carta c){
        if (cartas.containsKey(c.getNombre())) {
            c.setCantidad(c.getCantidad() + 1);
        }
        cartas.put(c.getNombre(), c);
    }
    
    public void crearAgregarCarta(String nombre, String tipo) {
        cartas.put(nombre, new Carta(nombre, tipo, 1));
    }
    
    public Boolean cartaExiste(String c){
        if(cartas.containsKey(c)){
            Carta carta = cartas.get(c);
            //System.out.println("Carta: " + carta.getNombre() +", Tipo: "+ carta.getTipo() +", Cantidad: "+ carta.getCantidad());
            return true;
        }else{ 
            return false;
        }
    }
    
    public Carta getCarta(String c){
        if(cartas.containsKey(c)){
            Carta carta = cartas.get(c);
            return carta;
        } else{
            return null;
        }
    }
    
    public void removeCarta(Carta c) {
        cartas.remove(c);
    }
    
    public void mostrarTodasLasCartas(){
        System.out.println("");
        System.out.println("Las cartas son: ");
        for (Map.Entry<String, Carta> entry : cartas.entrySet()){ 
            System.out.println("Carta: " + entry.getKey() + " Tipo: " + entry.getValue().getTipo() + " Cantidad: " + entry.getValue().getCantidad());
        }
        System.out.println("");
    }
    
    public String darTipoPorNombre(String param){
        String result="";
        if(cartas.containsKey(param)){
            Carta c = cartas.get(param);
            result = "La carta " + param + " es de tipo: " + c.getTipo();
        } else{
            result="No existe dicha carta";
        }
        return result;
    }
    
    public void mostrarCartasPorTipo(){
        String hechizos = "";
        String trampas = "";
        String monstruos = "";
        System.out.println("");
        System.out.println("Las cartas son: ");
        for (Map.Entry<String, Carta> entry : cartas.entrySet()){ 
            if (entry.getValue().getTipo().equals("Hechizo")) {
                hechizos += "Carta: " + entry.getKey() + " Tipo: " + entry.getValue().getTipo() + " Cantidad: " + entry.getValue().getCantidad() + "\n";
            } else if (entry.getValue().getTipo().equals("Trampa")) {
                trampas += "Carta: " + entry.getKey() + " Tipo: " + entry.getValue().getTipo() + " Cantidad: " + entry.getValue().getCantidad() + "\n";
            } else if (entry.getValue().getTipo().equals("Monstruo")) {
                monstruos += "Carta: " + entry.getKey() + " Tipo: " + entry.getValue().getTipo() + " Cantidad: " + entry.getValue().getCantidad() + "\n";
            }
            
        }
        
        System.out.println("Hechizos: ");
        System.out.println(hechizos);
        System.out.println("Trampa: ");
        System.out.println(trampas);
        System.out.println("Monstruos: ");
        System.out.println(monstruos);
        System.out.println("");
    }
    
}
