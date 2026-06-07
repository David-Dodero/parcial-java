/*
 */
package Entidades;

public class Pizza extends Producto implements IVendible{
    private TipoPizza sabor;
    private TamanoPizza tamano;

    public Pizza(String nombre, double precio, Fabricante fabricante, TipoPizza sabor, TamanoPizza tamano) {
        super(nombre, precio, fabricante);
        this.sabor = sabor;
        this.tamano = tamano;
    }

    @Override
    public double getPrecioTotal(){
        if (tamano == TamanoPizza.CHICA){
            return precio * 1.05;
        } else if (tamano == TamanoPizza.MEDIANA){
            return precio * 1.10;
        }else {
            return precio * 1.20;
        }
    }

    @Override
    public boolean equals(Object obj) {
        if (obj != null && obj instanceof Pizza){
            Pizza otraPizza = (Pizza) obj;
            return super.equals(otraPizza) &&
                    sabor == otraPizza.sabor &&
                    tamano == otraPizza.tamano;
        }
        return false;
    }

    @Override
    public String toString() {
        return super.toString() + "Pizza{" + "sabor:" 
                + sabor + ", tamano:" + tamano + 
                ", Precio total:  " +  getPrecioTotal()   + '}';
    }
    
    
    
    
}
