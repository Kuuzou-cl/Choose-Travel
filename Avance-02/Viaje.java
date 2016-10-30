
package chooseandtravel;


class Viaje {
    private String empresa;
    private String origen;
    private String destino;
    private int horario;
    private int fecha;
    private int asiento;
    private Boolean estado;
    
    public Viaje(String e, String o, String d, int h, int f,int a){
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
    
    public int getHorario(){
        return horario;
    }
    
    public int getFecha(){
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
