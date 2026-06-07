/*
 */
package Entidades;
import java.util.Random;

public abstract class Producto {
    protected Fabricante fabricante;
    protected String nombre;
    protected double precio; 
    protected int calorias; 
    protected int tiempoPreparacion;
    protected static Random generadorAleatorio;
    
    static {
        generadorAleatorio = new Random();
    }

    public Producto(String nombre, double precio, Fabricante fabricante) {        
        this.nombre = nombre;
        this.precio = precio;
        this.fabricante = fabricante;
    }

    public Producto(String nombre, double precio, String nombreFabricante,  String ciudadFabricante, int antiguedadFabricante) {
        this.nombre = nombre;
        this.precio = precio;
        this.fabricante = new Fabricante(nombreFabricante, ciudadFabricante, antiguedadFabricante);
    }
    
    public int getCalorias(){
        if(calorias == 0){
            calorias = generadorAleatorio.nextInt(601) + 200; // entre 200 y 800
        }
        return calorias;
    }
    
    public int getTiempoPreparacion(){
        if(tiempoPreparacion == 0){
            tiempoPreparacion = generadorAleatorio.nextInt(16) + 5; //entre 5 y 20
        }
        return tiempoPreparacion;
    }
    
    private static String mostrar(Producto producto){
        return "Nobre: " + producto.nombre + ", Precio: " +producto.precio + 
              ", Calorias: " + producto.getCalorias()+ 
                ", Tiempo preparacion: " + producto.tiempoPreparacion+
                ", Fabricante: " + producto.fabricante;
    }

    private static boolean sonIguales(Producto p1, Producto p2){
        return p1.nombre.equals(p2.nombre) &&
                Fabricante.sonIguales(p1.fabricante, p2.fabricante);
    }
    
    public boolean equals(Object obj){
        if(obj != null && obj instanceof Producto ){
            return Producto.sonIguales(this, (Producto)obj);
        }
        return false;
    }

    @Override
    public String toString() {
        return Producto.mostrar(this);
    }
    
    
    
    
}
