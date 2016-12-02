
package chooseandtravel;

import java.util.ArrayList;

/**
 *
 * Clase base para crear objetos de tipo Bus
 * 
 * @author Carlo Bernucci, Javier Nualart
 * @version 3.1
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
     * Constructor de la Clase Bus
     * @param e Parametro tipo String, que almacena el nombre de la empresa del bus
     * @param o Parametro tipo String, que almacena el punto de origen del viaje
     * @param d Paramtro tipo String, que almacena el destino del viaje
     * @param h Parametro tipo String, con formato hh:mm, que representa la hora de salida del Bus
     * @param f Parametro tipo Strin, con formato dd/MM/yyyy, que representa la fecha del viaje
     * @param a Parametro de tipo int[], representa los asientos del Bus
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
     * @return Retorna el parametro empresa del bus, de tipo String
     */
    public String getEmpresa(){
        return empresa;
    }
    
    /**
     *
     * @return Retorna el parametro origen del viaje, de tipo String
     */
    public String getOrigen(){
        return origen;
    }
    
    /**
     *
     * @return Retorna el parametro destino del viaje, de tipo String
     */
    public String getDestino(){
        return destino;
    }
    
    /**
     *
     * @return Retorna el parametro horario del viaje, de formato hh:mm
     */
    public String getHorario(){
        return horario;
    }
    
    /**
     *
     * @return Retorna el parametro fecha del viaje, de formato dd/MM/yyyy
     */
    public String getFecha(){
        return fecha;
    }
    
    /**
     *
     * @return Retorna el array de asientos del Bus
     */
    public int [] getAsientos(){
        return asientos;
    }
}
