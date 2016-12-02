
package chooseandtravel;

/**
 * Clase Sucursal, para generar objetos de tipo sucursal
 * 
 * @author Carlo Bernucci, Javier Nualart
 * @version 3.1
 */
public class Sucursal {
    
    private String nombre;
    private int codigo;
    
    /**
     *
     * @param n Parametro que representa el Nombre de la sucursal
     * @param c Parametro que representa el codigo de la sucursal
     */
    public Sucursal(String n, int c){
        this.nombre=n;
        this.codigo=c;
    }
    
    /**
     *
     * @return Retorna el nombre de una sucursal
     */
    public String getNombre(){
        return this.nombre;
    }
    
    /**
     *
     * @return Retorna el codgio de una sucursal
     */
    public int getCodigo(){
        return this.codigo;
    }
    
}
