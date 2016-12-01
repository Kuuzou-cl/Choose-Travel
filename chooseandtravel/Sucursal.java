
package chooseandtravel;

/**
 *
 * @author kuuzou
 */
public class Sucursal {
    
    private String nombre;
    private int codigo;
    
    /**
     *
     * @param n
     * @param c
     */
    public Sucursal(String n, int c){
        this.nombre=n;
        this.codigo=c;
    }
    
    /**
     *
     * @return
     */
    public String getNombre(){
        return this.nombre;
    }
    
    /**
     *
     * @return
     */
    public int getCodigo(){
        return this.codigo;
    }
    
}
