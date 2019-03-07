/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hdt6;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Map;
import java.util.Scanner;
import java.util.stream.Stream;

/**
 *
 * @author Luis Perez Aju && Francisco Rosal
 */
public class HDT6 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        Scanner read = new Scanner(System.in);
        String tipo;
        Map mapa;
        
        System.out.println("Ingrese la implementacion que desea usar: ");
        System.out.println("1. HashMap");
        System.out.println("2. TreeMap");
        System.out.println("3. LinkedHashMap");
        tipo = read.next();
        
        mapa = Fac.obtenerMap(tipo);
        
        //Leer el archivo
        ArrayList<String> archivo = new ArrayList<>();
        try {
            Stream<String> lines;
            lines = Files.lines(Paths.get("cards_desc.txt"), StandardCharsets.UTF_8);
            lines.forEach(archivo::add);
        } catch (IOException e) {
            System.out.println("Ha ocurrido un error");
        }
        
        
        for (String a: archivo) {
            System.out.println(a);
        }
    }
    
}
