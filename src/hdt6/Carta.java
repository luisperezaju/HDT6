/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
//package hdt6;

/**
 *
 * @author Luis Perez Aju
 */
public class Carta {
   private String nombre;
   private String tipo;
   private int cantidad;
   
   
   
   public Carta(String nombre, String tipo, int cantidad){
       this.nombre = nombre;
       this.tipo = tipo;        
       this.cantidad = cantidad;
       
   }
   
   public String getNombre(){
       return this.nombre;
       
   }
   
   public String getTipo(){
       return this.tipo;
       
   }
   
   public int getCantidad(){
       return this.cantidad;
       
   }
   
   public void setCantidad (int cantidad){
       this.cantidad = cantidad;
   }
}
