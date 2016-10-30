
package chooseandtravel;

import java.util.ArrayList;


class Viaje {
    private String empresa;
    private String origen;
    private String destino;
    private String horario;
    private String fecha;
    private int asiento;
    private Boolean estado;
    private String usuario;
    
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
    
    public int getAsiento(){
        return asiento;
    }
    
    public void setEstado(Boolean es){
        this.estado=es;
    }
    
    public Boolean getEstado(){
        return estado;
    }
    
    public String getUsuario(){
        return usuario;
    }
    
    public static String toStringViaje(int n, ArrayList viajes){
        String strViaje="Origen: "+((Viaje) viajes.get(n)).getOrigen()+" |  Destino: "+((Viaje) viajes.get(n)).getDestino()+" |  Fecha: "+((Viaje) viajes.get(n)).getFecha()+" |  Horario:"+((Viaje) viajes.get(n)).getHorario()+" | "+ " |  Asiento: "+((Viaje) viajes.get(n)).getAsiento();
        return strViaje;
    }
}
