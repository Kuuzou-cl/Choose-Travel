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
public class Login {
    public void inicio(ArrayList cuentas) {
        Scanner intro = new Scanner(System.in);
        Dat_cuentas mCuentas=new Dat_cuentas();
        Validador validar = new Validador();
        String use = "";
        do {
            System.out.println("Ingrese usuario");
            use = intro.nextLine();
        } while (validar.valUs(use) == false);
        for (int i=0; i<cuentas.size();i++) {
            if (((Cuenta)cuentas.get(i)).getUser().equals(use)) {
                System.out.println("Ingrese contraseña");
                String pas = intro.nextLine();
                if (((Cuenta)cuentas.get(i)).getUser().equals(pas)) {
                    if(((Admin)cuentas.get(i)).getAdmin() == true) {
                        mCuentas.modificar_txt(cuentas);
                    } else {
                        mCuentas.modificar_txtUs(cuentas,use);
}
                }
            }
        }
    }
}
