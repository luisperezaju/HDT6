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
    
    public Coleccion(){
    
}
    /**
     * 
     * @param param
     * @return 
     */
    
    Map<String, String> cartas;
    
    public void asignarMapa(Map mapa){
        this.cartas = mapa;
    }
    
    public void agregarCarta(String nombre, String tipo){
        cartas.put(nombre, tipo);        
    }
    
    public String buscar(String param, Map<String, Carta> mapa){
    String existe="";
        if(mapa.containsKey(param)){
            Carta c = mapa.get(param);
            
            existe = "La carta " + c.getNombre() + " si existe y su tipo es " + c.getTipo() ;
        }else{ 
            existe = "Esta carta no existe";
        }
        
        return existe;
    }
    
    
    public Map<String, Carta> sortThots(Map<String, Carta> unsortedMap, String opt){

        List<Map.Entry<String, Carta>> list = new LinkedList<Map.Entry<String, Carta>>(
                unsortedMap.entrySet());
         
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
    
    
      public ArrayList<Carta> sortMisCartas(ArrayList<Carta> biblioteca){ 
        /*List<Card> cards = new ArrayList<Card>();
        Card card;
        
        for*/
        
        ArrayList<Carta> cartas = biblioteca;
        
        Collections.sort(cartas, new Comparator<Carta>(){
            @Override
            public int compare(Carta c2, Carta c1){
                return c1.getTipo().compareTo(c2.getTipo());
            }
         });
        
        return cartas;
    }
    
    public Carta getCarta(String param, Map<String, Carta> mapa){
        if(mapa.containsKey(param)){
            Carta c = mapa.get(param);
            return c;
        } else{
            return null;
        }
    }
    
    public String darTipoPorNombre(String param, Map<String, Carta> mapG){
        String result="";
        if(mapG.containsKey(param)){
            Carta c = mapG.get(param);
            result = "La carta " + param + " es de tipo:" + c.getTipo();
        } else{
            result="no existe dicha carta..";
        }
        return result;
    }
    
    public boolean cardExiste(ArrayList<Carta> cartas, Carta res){ 
        boolean cardEx = false;
        
        
        for(Carta c : cartas){ 
            if(c.getNombre().equals(res.getNombre())){
                cardEx = true;
                break;
            }
        }
        
        return cardEx;
    }
    
    
    public void mostrarTodasLasCartas(Map<String, Carta> mapG){ 
        for (Map.Entry<String, Carta> entry : mapG.entrySet()){ 
                    System.out.println("Nombre de carta: " + entry.getKey() + " Tipo de Carta: " + entry.getValue().getTipo());
        }
    }
     
     public void mostrarCartas(ArrayList<Carta> biblioteca){ 
        System.out.println("Sus cartas son: ");
        for(Carta c : biblioteca){ 
            System.out.println("Nombre de carta: " + c.getNombre() + " Tipo de Carta: " + c.getTipo() + " Cantidad: " + c.getCantidad());
        }
    }
     
     public void sortCartas(Map<String, Carta> mapa){
        for (Map.Entry<String, Carta> entry : mapa.entrySet()){ 
            if(entry.getValue().getTipo().equals("Trampa")){
                
            }
               
        }    
        
    }
     
     public boolean cartaExiste(ArrayList<Carta> cartas, Carta res){ 
        boolean cardEx = false;
        
        
        for(Carta c : cartas){ 
            if(c.getNombre().equals(res.getNombre())){
                cardEx = true;
                break;
            }
        }
        
        return cardEx;
    }
     
     public void mostrarMisCartas(ArrayList<Carta> biblioteca){ 
        System.out.println("Sus cartas son: ");
        for(Carta c : biblioteca){ 
            System.out.println("Nombre de carta: " + c.getNombre() + " Tipo de Carta: " + c.getTipo() + " Cantidad: " + c.getCantidad());
        }
    }
     
}
