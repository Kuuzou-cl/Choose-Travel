
package chooseandtravel;


/**
 * Clase Viaje, para generar objetos Viajes
 *
 * @author Carlo Bernucci, Javier Nualart
 * @version 3.1
 */
public class Viaje {
    private String empresa;
    private String origen;
    private String destino;
    private String horario;
    private String fecha;
    private int asiento;
    private Boolean estado;
    private String usuario;
    
    /**
     *
     * @param e Parametro que representa la empresa del Bus del viaje
     * @param o Parametro que representa el origen del viaje
     * @param d Parametro que representa el destino del viaje
     * @param h Parametro que representa el horario de salida del Bus
     * @param f Parametro que representa la fecha de salida del Viaje
     * @param a Parametro que representa el asiento del Viaje
     * @param est Parametro que representa el estado, puede ser true, false o null
     * @param us Parametro que representa el usuario asociado a este viaje
     */
    public Viaje(String e, String o, String d, String h, String f,int a, Boolean est, String us){
        this.empresa=e;
        this.origen=o;
        this.destino=d;
        this.horario=h;
        this.fecha=f;
        this.asiento=a;
        this.estado=est;
        this.usuario=us;
    }
    
    /**
     *
     * @return Retorna la Empresa del viaje
     */
    public String getEmpresa(){
        return empresa;
    }
    
    /**
     *
     * @return Retorne el origen de un viaje
     */
    public String getOrigen(){
        return origen;
    }
    
    /**
     *
     * @return Retorna el destino de un viaje
     */
    public String getDestino(){
        return destino;
    }
    
    /**
     *
     * @return Retorna el horario de un viaje
     */
    public String getHorario(){
        return horario;
    }
    
    /**
     *
     * @return Retorna la fecha de un viaje
     */
    public String getFecha(){
        return fecha;
    }
    
    /**
     *
     * @return Retorna el asiento de un viaje
     */
    public int getAsiento(){
        return asiento;
    }
    
    /**
     * Metodo para asignar un estado a un viaje, puede ser true, false, null
     * @param es Parametro asociado al nuevo estado recibido
     */
    public void setEstado(Boolean es){
        this.estado=es;
    }
    
    /**
     * 
     * @return Retorna el estado de un viaje
     */
    public Boolean getEstado(){
        return estado;
    }
    
    /**
     *
     * @return Retorna el usuario asociado al viaje
     */
    public String getUsuario(){
        return usuario;
    }
    
}
