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
    private static String cartaParam;
    
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
        Coleccion metodo = new Coleccion();
        ArrayList<Carta> biblioteca = new ArrayList<>();
        
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
                    
                    continuar = true;
                } else if (opcion.equals("2")) {
                    //TODO
                    System.out.println("Ingrese el nombre de la carta ");
                    cartaParam = read.nextLine();
                    cartaParam = read.nextLine();
                    String buscar = metodo.buscar(cartaParam, mapa);
                    System.out.println(buscar);
                    continuar = true;
                } else if (opcion.equals("3")) {
                    //TODO
                    System.out.println("Ingrese el nombre de la carta que desea buscar:");
                    cartaParam = read.nextLine();
                    cartaParam = read.nextLine();
                    String buscar = metodo.buscar(cartaParam, mapa);
                     Carta res = metodo.getCarta(cartaParam, mapa);
                    if (res!=null){
                        if(metodo.cartaExiste(biblioteca, res)){ 
                            //ya existe la carta
                            //entonces solo agregue uno a la cantidad.
                            int pos = biblioteca.indexOf(res);
                            biblioteca.get(pos).setCantidad(biblioteca.get(pos).getCantidad() + 1);
                        }else{
                            res.setCantidad(1);
                            biblioteca.add(res);
                        }
                        System.out.println("Carta agregada exitosamente.");
                    } else {
                        System.out.println("Esta carta no existe.");
                        
                       }
                    
                    System.out.println(buscar);
                    
                    
                    
                    continuar = true;
                } else if (opcion.equals("4")) {
                    //TODO
                    
                    continuar = true;
                } else if (opcion.equals("5")) {
                    //TODO
                    
                    continuar = true;
                } else if (opcion.equals("6")) {
                    //TODO
                    
                    continuar = true;
                } else if (opcion.equals("7")) {
                    continuar = false;
                }
            }
        }
    }
    
}
