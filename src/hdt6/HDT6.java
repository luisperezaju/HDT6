/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
//package hdt6;

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
        Scanner read = new Scanner(System.in);
        String tipoM;
        Map mapa1;
        Map mapa2;
        Coleccion cartasTotales =  new Coleccion();
        Coleccion coleccion = new Coleccion();
        Boolean continuar = true;
        
        System.out.println("Ingrese la implementacion que desea usar: ");
        System.out.println("1. HashMap");
        System.out.println("2. TreeMap");
        System.out.println("3. LinkedHashMap");
        tipoM = read.next();
        
        mapa1 = Fac.obtenerMap(tipoM);
        mapa2 = Fac.obtenerMap(tipoM);
        if (mapa1 != null && mapa2 != null){
            cartasTotales.asignarMapa(mapa1);
            coleccion.asignarMapa(mapa2);
            
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
                String[] cartaInfo = c.split("[|]");
                cartasTotales.crearAgregarCarta(cartaInfo[0], cartaInfo[1]);
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
                    System.out.println("Ingrese el nombre de la carta que desea agregar:");
                    read.nextLine();
                    String agregarCarta = read.nextLine();
                    
                    Boolean existe = cartasTotales.cartaExiste(agregarCarta);
                    
                    if (existe) {
                        Carta carta = cartasTotales.getCarta(agregarCarta);
                        coleccion.agregarCarta(carta);
                    } else {
                        System.out.println("Esta carta no existe.");
                    }
                    
                } else if (opcion.equals("2")) {
                    System.out.println("Ingrese nombre de carta para consultar el tipo de carta:");
                    read.nextLine();
                    String query = read.nextLine();
                    System.out.println(query);
                    System.out.println(cartasTotales.darTipoPorNombre(query));
                    
                } else if (opcion.equals("3")) {
                    coleccion.mostrarTodasLasCartas();
                } else if (opcion.equals("4")) {
                    coleccion.mostrarCartasPorTipo();
                } else if (opcion.equals("5")) {
                    cartasTotales.mostrarTodasLasCartas();
                } else if (opcion.equals("6")) {
                    cartasTotales.mostrarCartasPorTipo();
                } else if (opcion.equals("7")) {
                    continuar = false;
                }
            }
        }
    }
    
}
