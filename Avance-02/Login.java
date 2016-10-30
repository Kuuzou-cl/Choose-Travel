package chooseandtravel;

import java.util.ArrayList;
import java.util.Scanner;

public class Login {

    public void inicio(ArrayList cuentas, ArrayList sucursales, ArrayList buses, ArrayList viajes) {
        Scanner intro = new Scanner(System.in);
        Datos_Cuentas mCuentas = new Datos_Cuentas();
        Validador validar = new Validador();
        String use = "";
        do {
            System.out.println("Ingrese usuario");
            use = intro.nextLine();
        } while (validar.valUs(use) == false);
        for (int n = 0; n<cuentas.size(); n++) {
            if (((Cuenta)cuentas.get(n)).getUser().equals(use)) {
                System.out.println("Ingrese contraseña");
                String pas = intro.nextLine();
                if (((Cuenta)cuentas.get(n)).getPass().equals(pas)) {
                    if (((Cuenta)cuentas.get(n)).getUser().equals("admin")) {
                        mCuentas.modificar_txt(cuentas, sucursales,buses,viajes);
                    } else {
                        mCuentas.modificar_txtUs(cuentas,use,buses,viajes, sucursales);
                    }
                }
            }
        }
    }
}
