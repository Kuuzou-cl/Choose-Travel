package chooseandtravel;

import java.util.ArrayList;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Validador {

    public String leerString() {
        Scanner intro = new Scanner(System.in);
        String cadena = intro.nextLine();
        return cadena;
    }

    public static boolean valUs(String oper) {
        Pattern pat = Pattern.compile("^([a-z]{1}" + "\\.{1}" + "[a-z]+" + "\\d{2})|admin$");
        Matcher mat = pat.matcher(oper);
        if (mat.matches() == false) {
            System.out.println("Usuario ingresado incorrecto. intente de nuevo.");
            return false;
        }
        return true;
    }

    public static boolean valInfo(String oper) {
        Pattern pat = Pattern.compile("^[a-z]+" + " " + "[a-z]+$");
        Matcher mat = pat.matcher(oper);
        if (mat.matches() == false) {
            System.out.println("Ingresado incorrecto. intente de nuevo.");
            return false;
        }
        return true;
    }

    public static boolean valSuc(String oper) {
        Pattern pat = Pattern.compile("^[a-z]+$");
        Matcher mat = pat.matcher(oper);
        if (mat.matches() == false) {
            System.out.println("Ingresado incorrecto. intente de nuevo.");
            return false;
        }
        return true;
    }

    public int leerInt() {
        int num = 0;
        boolean x;
        do {
            try {
                Scanner intro = new Scanner(System.in);
                num = intro.nextInt();
                x = true;
            } catch (Exception e) {
                System.out.println("Opcion ingresada incorrecta, intente denuevo");
                x = false;
            }
        } while (x == false);
        return num;
    }

    public boolean existUs(ArrayList cuentas, String us) {
        for (int i = 0; i < cuentas.size(); i++) {
            if (((Cuenta) cuentas.get(i)).getUser().equals(us)) {
                System.out.println("El usuario ingresado no esta disponible");
                return false;
            }
        }
        return true;
    }

}
