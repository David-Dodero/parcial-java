/*
 */
package Entidades;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;

public class Pizzeria implements Iterable<Producto> {
    private String nombre;
    private int capacidad;
    private Collection<Producto>productos;

    public Pizzeria(String nombre) {
        this.nombre = nombre;
        this.capacidad = 3;
        this.productos = new ArrayList<>();
    }
    
    
    public Pizzeria(String nombre, int capacidad) {
        this.nombre = nombre;
        this.capacidad = capacidad;
        this.productos = new ArrayList<>();
    }
    
    private boolean sonIguales(Producto producto){
        return productos.contains(producto);
        
    }
    
    public void agregar(Producto producto){
        if (productos.size() < capacidad && !sonIguales(producto)){
            productos.add(producto);
        }else{
            if (productos.size() >= capacidad ){
                System.out.println("No hay capacidad para agregar" + producto.nombre );
            }else {
                System.out.println("El producto" + producto.nombre + " ya existe en la pizzeria");
            }
        }
    }
    
    private double getPrecioDePizzas(){
        double total = 0;
        for (Producto p : productos){
            if (p instanceof Pizza){
                total += ((Pizza)p).getPrecioTotal();
            }
        }
        return total;
    }
    
    private double getPrecioPostre(){
        double total = 0; 
        for (Producto p : productos){
            if (p instanceof Postre){
                total += ((Postre)p).getPrecioTotal();
            }
        }
        return total;
    }
    
    private double getPrecioTotal(){
        return getPrecioDePizzas() + getPrecioPostre();
    }
    
    private double getPrecioProductos(TipoProducto tipo){
        if (tipo == TipoProducto.PIZZAS){
          return getPrecioDePizzas();
        }else if (tipo == TipoProducto.POSTRES){
            return getPrecioPostre();
        }else {
            return getPrecioTotal();
        }
    }
    
    @Override
    public Iterator<Producto>iterator(){
        return productos.iterator();
    }

    @Override
    public String toString() {
        String info = "Pizzeria: " + "nombre: " + nombre +
                ", capacidad: " + capacidad + 
                ", productos: " + productos.size() + "\n";
    
        for(Producto p : productos){
            info += p.toString() + "\n";
        }
        
        info += "Precio pizzas: " + getPrecioDePizzas();
        info += "Precio postre: " + getPrecioPostre();
        info += "Precio total: " + getPrecioTotal();
        
        return info;
    }
    
    
    
    
}


