
package chooseandtravel;

import java.util.ArrayList;

/**
 *
 * @author kuuzou
 */
public class Bus {
    private String empresa;
    private String origen;
    private String destino;
    private String horario;
    private String fecha;
    private int [] asientos;
    
    /**
     *
     * @param e
     * @param o
     * @param d
     * @param h
     * @param f
     * @param a
     */
    public Bus(String e, String o, String d, String h, String f, int[]a ){
        this.empresa=e;
        this.origen=o;
        this.destino=d;
        this.horario=h;
        this.fecha=f;
        this.asientos=a ;
    }
    
    /**
     *
     * @return
     */
    public String getEmpresa(){
        return empresa;
    }
    
    /**
     *
     * @return
     */
    public String getOrigen(){
        return origen;
    }
    
    /**
     *
     * @return
     */
    public String getDestino(){
        return destino;
    }
    
    /**
     *
     * @return
     */
    public String getHorario(){
        return horario;
    }
    
    /**
     *
     * @return
     */
    public String getFecha(){
        return fecha;
    }
    
    /**
     *
     * @return
     */
    public int [] getAsientos(){
        return asientos;
    }
}
