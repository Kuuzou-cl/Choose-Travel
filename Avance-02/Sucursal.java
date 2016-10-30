
package chooseandtravel;


public class Sucursal {
    
    private String nombre;
    private int codigo;
    
    public Sucursal(String n, int c){
        this.nombre=n;
        this.codigo=c;
    }
    
    public String getNombre(){
        return this.nombre;
    }
    
    public int getCodigo(){
        return this.codigo;
    }
    
}
