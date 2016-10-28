/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proyecto;

/**
 *
 * @author juan
 */
public class Cliente extends Cuenta {
    private String nombre;
    private int sucursal;
    public Cliente(String us,String pas,String nom,int suc){
    super(us,pas);    
    this.nombre=nom;
    this.sucursal=suc;
    }
    public void setNombre(String name){
    this.nombre=name;
    }
    public String getNombre(){
    return this.nombre;
    }
    public void setSucursal(int n){
    this.sucursal=n;
    }
    public int getSucursal(){
    return this.sucursal;
    }
    public static void usMenu(){
    System.out.println("---------Menu de configuracion--------");
    System.out.println("1. Modificar password");
    System.out.println("2. Guardar y  salir");
    }
}
