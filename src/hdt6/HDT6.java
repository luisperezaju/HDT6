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
        String tipoM;
        Map mapa;
        Coleccion cartasTotales;
        Coleccion coleccion;
        Boolean continuar = true;
        
        System.out.println("Ingrese la implementacion que desea usar: ");
        System.out.println("1. HashMap");
        System.out.println("2. TreeMap");
        System.out.println("3. LinkedHashMap");
        tipoM = read.next();
        
        mapa = Fac.obtenerMap(tipoM);
        if (mapa != null){
            cartasTotales = new Coleccion();
            cartasTotales.asignarMapa(mapa);
            coleccion = new Coleccion();
            coleccion.asignarMapa(mapa);
            
            //Leer el archivo
            ArrayList<String> cartas = new ArrayList<>();
            try {
                Stream<String> lines;
                lines = Files.lines(Paths.get("cards_desc.txt"), StandardCharsets.UTF_8);
                lines.forEach(cartas::add);
            } catch (IOException e) {
                System.out.println("Ha ocurrido un error");
            }

            for (String c: cartas) {
                System.out.println(c);
                String[] cartaInfo = c.split("|");
                cartasTotales.agregarCarta(cartaInfo[0], cartaInfo[1]);
            }
            
            
            while(continuar) {
                System.out.println("Escoja un numero: ");
                System.out.println("1. Guarda una carta en tu coleccion");
                System.out.println("2. Que tipo de carta es...");
                System.out.println("3. Mostrar mis cartas");
                System.out.println("4. Mostrar mis cartas por tipo");
                System.out.println("5. Mostrar todas las cartas");
                System.out.println("6. Mostrar todas las cartas por tipo");
                System.out.println("7. Salir");
                String opcion = read.next();
                
                if (opcion.equals("1")) {
                    //TODO
                } else if (opcion.equals("2")) {
                    //TODO
                } else if (opcion.equals("3")) {
                    //TODO
                } else if (opcion.equals("4")) {
                    //TODO
                } else if (opcion.equals("5")) {
                    //TODO
                } else if (opcion.equals("6")) {
                    //TODO
                } else if (opcion.equals("7")) {
                    continuar = false;
                }
            }
        }
    }
    
}
