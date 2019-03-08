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
        System.out.println("");
        System.out.println("Las cartas son: ");
        for (Map.Entry<String, Carta> entry : cartas.entrySet()){ 
            System.out.println("Carta: " + entry.getKey() + " Tipo: " + entry.getValue().getTipo() + " Cantidad: " + entry.getValue().getCantidad());
        }
        System.out.println("");
    }
    
    public Map<String, Carta> sortThots(String opt){

        List<Map.Entry<String, Carta>> list = new LinkedList<Map.Entry<String, Carta>>(
                cartas.entrySet());
         
        Collections.sort(list, new Comparator<Map.Entry<String, Carta>>() {
            @Override
            public int compare(Map.Entry<String, Carta> o1, Map.Entry<String, Carta> o2) {
                return o1.getValue().getTipo().compareTo(o2.getValue().getTipo());
            }                
        });
     
        Map<String, Carta> x = new LinkedHashMap<String, Carta>();
        for(Map.Entry<String, Carta> item : list){
            x.put(item.getKey(), item.getValue());
        }
        return x;         
    
    }
    
}
