/*
 */
package Entidades;

public class Postre extends Producto implements IVendible{
     private TipoPostre tipoPostre;

    public Postre(String nombre,double precio,Fabricante fabricante, TipoPostre tipoPostre) {
        super(nombre, precio, fabricante);
        this.tipoPostre = tipoPostre;
    }

    
    
    @Override
    public double getPrecioTotal(){
        if (tipoPostre == TipoPostre.FLAN){
            return precio * 1.10;
        } else if (tipoPostre == TipoPostre.HELADO){
            return precio * 1.15;
        }else {
            return precio * 1.20;
        }
    }
    
    @Override
    public boolean equals(Object obj) {
        if (obj instanceof Postre){
            Postre otraPostre = (Postre) obj;
            return super.equals(otraPostre) &&
                    tipoPostre == otraPostre.tipoPostre;
        }
        return false;
    }

    @Override
    public String toString() {
        return  super.toString()+
                " Postre{" + "Tipo de postre: " + tipoPostre + 
                ", Precio total: " + getPrecioTotal() + '}';
    }
    
}
