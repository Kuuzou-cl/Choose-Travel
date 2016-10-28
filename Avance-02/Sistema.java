/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proyecto;
import java.util.*;
/**
 *
 * @author juan
 */
public class Sistema {
    private ArrayList<Cuenta>cuentas;
     public void inicio(){
            ArrayList<Cuenta> cuentas =new ArrayList<Cuenta>();
            Dat_cuentas mCuentas = new Dat_cuentas();
            Login login =new Login();
            cuentas=mCuentas.syncArrayList(cuentas);
            login.inicio(cuentas);
        }
}
