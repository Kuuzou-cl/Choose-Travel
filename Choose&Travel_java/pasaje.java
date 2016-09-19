
/**
 * Write a description of class pasaje here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class pasaje
{
    // instance variables - replace the example below with your own
    private int hora;
    private int fecha;
    private int precio;
    private int asiento;
    private String destino;
    private String origen;
    private String empresa;
    /**
     * Constructor for objects of class pasaje
     */
    public pasaje()
    {
    }
    public void setHora(int h){
    hora=h;
    }
    public int getHora(){
    return hora;
    }
    public void setFecha(int f){
    fecha=f;
    }
    public int getFecha(){
    return fecha;
    }
    public void setPrecio(int p){
    precio=p;
    }
    public int getPrecio(){
    return precio;
    }
    public void setAsiento(int a){
    asiento=a;
    }
    public int getAsiento(){
    return asiento;
    }
    public void setDestino(String d){
    destino=d;
    }
    public String getDestino(){
    return destino;
    }
    public void setOrigen(String o){
    origen=o;
    }
    public String getOrigen(){
    return origen;
    }
    public void setEmpresa(String e){
    empresa=e;
    }
    public String getEmpresa(){
    return empresa;
    }
}
