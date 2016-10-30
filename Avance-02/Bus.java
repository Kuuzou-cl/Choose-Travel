
package chooseandtravel;

import java.util.ArrayList;


public class Bus {
    private String empresa;
    private String origen;
    private String destino;
    private String horario;
    private String fecha;
    private ArrayList<Integer> asientos;
    
    public Bus(String e, String o, String d, String h, String f,ArrayList a){
        this.empresa=e;
        this.origen=o;
        this.destino=d;
        this.horario=h;
        this.fecha=f;
        this.asientos=a;
    }
    
    public String getEmpresa(){
        return empresa;
    }
    
    public String getOrigen(){
        return origen;
    }
    
    public String getDestino(){
        return destino;
    }
    
    public String getHorario(){
        return horario;
    }
    
    public String getFecha(){
        return fecha;
    }
    
    public ArrayList getAsientos(){
        return asientos;
    }
}
