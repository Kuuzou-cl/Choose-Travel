
package chooseandtravel;


class Viaje {
    private String empresa;
    private String origen;
    private String destino;
    private String horario;
    private String fecha;
    private int asiento;
    private Boolean estado;
    
    public Viaje(String e, String o, String d, String h, String f,int a){
        this.empresa=e;
        this.origen=o;
        this.destino=d;
        this.horario=h;
        this.fecha=f;
        this.asiento=a;
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
}
