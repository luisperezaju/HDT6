/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
//package hdt6;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.TreeMap;

/**
 *
 * @author Luis Perez Aju && Francisco Rosal
 */
public class Fac {
    public Fac(){
        
    }
    
    public static Map<String, String> obtenerMap(String opcion){
        switch (opcion){
            case "1":
                return new HashMap<String, String>();
            case "2":
                return new HashMap<String, String>();
            case "3":
                return new LinkedHashMap<String, String>();
            default:
                return null;
        }
    }
}
