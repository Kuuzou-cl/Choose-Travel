
package chooseandtravel;

import java.util.ArrayList;


public class Bus {
    private String empresa;
    private String origen;
    private String destino;
    private int horario;
    private int fecha;
    private ArrayList<Integer> asientos;
    
    public Bus(String e, String o, String d, int h, int f,ArrayList a){
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
    
    public int getHorario(){
        return horario;
    }
    
    public int getFecha(){
        return fecha;
    }
    
    public ArrayList getAsientos(){
        return asientos;
    }
}
