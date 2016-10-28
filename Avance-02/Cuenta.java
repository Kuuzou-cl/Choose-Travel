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
public class Cuenta {
    protected String user;
    protected String pass;
    public Cuenta(String us,String pas){
        this.user=us;
        this.pass=pas;
    }
    public void setUser(String us){
    this.user=us;
    }
    public String getUser(){
    return this.user;
    }
    public void setPass(String pas){
    this.pass=pas;
    }
    public String getPass(){
    return this.pass;
    }
}
