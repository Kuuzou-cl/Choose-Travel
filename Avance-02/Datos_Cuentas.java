package chooseandtravel;

import java.io.*;
import java.util.*;

public class Datos_Cuentas {

    File DatosCuenta = new File("C:\\Users\\krlo9\\Documents\\NetBeansProjects\\ChooseAndTravel\\src\\chooseandtravel\\cuentas.txt");
    Cliente objetoC = null;
    Admin objetoA = null;
    Datos_Empresa mSuc = new Datos_Empresa();
    Datos_Viajes mViaj =new Datos_Viajes();
    Scanner intro = new Scanner(System.in);
    Validador validar = new Validador();

    public ArrayList syncArrayList(ArrayList cuentas) {
        cuentas.clear();
        txt_array(cuentas);
        return cuentas;
    }

    public void txt_array(ArrayList cuentas) {
        try {
            String linea = null;
            BufferedReader read = new BufferedReader(new FileReader(DatosCuenta));
            int n = 0;
            while ((linea = read.readLine()) != null) {
                n++;
                StringTokenizer split = new StringTokenizer(linea, "|");
                if (n == 1) {
                    String strUser = split.nextToken().trim();
                    String passStr = split.nextToken().trim();
                    String strAdmin = split.nextToken().trim();
                    objetoA = new Admin(strUser, passStr);
                    cuentas.add(objetoA);
                } else {
                    String strUser = split.nextToken().trim();
                    String passStr = split.nextToken().trim();
                    String infoStr = split.nextToken();
                    String intSucu = split.nextToken().trim();
                    int sucursal = Integer.parseInt(intSucu);
                    objetoC = new Cliente(strUser, passStr, infoStr, sucursal);
                    cuentas.add(objetoC);
                }

            }
            read.close();

        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
    }

    public void modificar_txt(ArrayList cuentas, ArrayList sucursales, ArrayList buses, ArrayList viajes) {

        try {
            syncArrayList(cuentas);
            int op = 10;
            while (op != 9) {
                Admin.menuAdmin();
                op = intro.nextInt();
                switch (op) {
                    case 1:
                        String us0 = "";
                        do {
                            System.out.println("Ingrese un nuevo usuario");
                            us0 = intro.nextLine();
                            us0 = intro.nextLine();
                        } while (validar.valUs(us0) == false);
                        System.out.println("Ingrese la contraseña");
                        String pas0 = intro.nextLine();
                        String inf0;
                        do {
                            System.out.println("Ingrese la informacion del usuario");
                            inf0 = intro.nextLine();
                        } while (validar.valInfo(inf0));
                        System.out.println("Ingrese sucursal del nuevo usuario");
                        int suc0 = intro.nextInt();
                        agregarCuentaTxt(us0, pas0, inf0, suc0);
                        syncArrayList(cuentas);
                        break;
                    case 2:
                        String us = "";
                        do {
                            System.out.println("Introducir el usuario a modificar:");
                            us = intro.nextLine();
                        } while (validar.valUs(us) == false);
                        boolean existCuen1 = false;
                        for (int n = 0; n < cuentas.size(); n++) {

                            if (((Cuenta) cuentas.get(n)).getUser().equals(us)) {
                                existCuen1 = true;
                                System.out.println("Introducir nueva contraseña:");
                                String newPass = intro.nextLine();
                                ((Cuenta) cuentas.get(n)).setPass(newPass);
                                System.out.println("=========================== Cuenta =========================================================================================================================================================================================");
                                System.out.println("El usuario es:" + ((Cuenta) cuentas.get(n)).getUser() + "\t" + "y la nueva contraseña es:" + ((Cuenta) cuentas.get(n)).getPass());
                                System.out.println("============================FIN==============================================================================================================================================================================================");
                                break;
                            }
                        }
                        if (existCuen1 == false) {
                            System.out.println("El usuario no se ha encontrado");
                        }
                        break;
                    case 3:
                        String us2 = "";
                        do {
                            System.out.println("Introducir el usuario a modificar:");
                            us2 = intro.nextLine();
                        } while (validar.valUs(us2) == false);
                        boolean existCuen2 = false;
                        for (int n = 0; n < cuentas.size(); n++) {

                            if (((Cuenta) cuentas.get(n)).getUser().equals(us2)) {
                                existCuen2 = true;
                                System.out.println("Introducir nueva informacion:");
                                String newInfo = intro.next();
                                ((Cliente) cuentas.get(n)).setNombre(newInfo);
                                System.out.println("=========================== Cuenta =========================================================================================================================================================================================");
                                System.out.println("El usuario es:" + ((Cliente) cuentas.get(n)).getUser() + "\t" + "La nueva informacion es:" + ((Cliente) cuentas.get(n)).getNombre());
                                System.out.println("============================FIN==============================================================================================================================================================================================");
                                break;
                            }
                        }
                        if (existCuen2 == false) {
                            System.out.println("El usuario no se ha encontrado");
                        }
                        break;
                    case 4:
                        String us3 = "";
                        do {
                            System.out.println("Inserte el usuario de la cuenta ha borrar");
                            us3 = intro.nextLine();
                            us3 = intro.nextLine();
                        } while (validar.valUs(us3) == false);
                        try {
                            BufferedWriter write = new BufferedWriter(new FileWriter(DatosCuenta));
                            for (int n = 0; n < cuentas.size(); n++) {
                                if (((Cuenta) cuentas.get(n)).getUser().equals(us3)) {
                                    System.out.println("La cuenta ha sido eliminada");
                                } else {
                                    if (n == 1) {
                                        write.write(((Admin) cuentas.get(n)).getUser() + "|" + ((Admin) cuentas.get(n)).getPass() + "|" + ((Admin) cuentas.get(n)).getAdmin() + "\r\n");
                                    } else {
                                        write.write(((Cliente) cuentas.get(n)).getUser() + "|" + ((Cliente) cuentas.get(n)).getPass() + "|" + ((Cliente) cuentas.get(n)).getNombre() + "|" + ((Cliente) cuentas.get(n)).getSucursal() + "\r\n");
                                    }
                                }
                            }
                            write.close();
                            cuentas.clear();
                            txt_array(cuentas);
                        } catch (Exception ex) {
                            System.out.println(ex.getMessage());
                        }
                        break;
                    case 5:
                        mostrarObjetos(cuentas, 5);
                        break;
                    case 6:
                        mSuc.agregarSuc(sucursales);
                        break;
                    case 7:
                        mSuc.eliminarSuc(sucursales);
                        break;
                    case 8:
                        mostrarObjetos(sucursales, 8);
                        break;
                    case 9:
                        guardar(cuentas);
                        mSuc.guardarS(sucursales);
                }
            }
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
    }

    public void mostrarObjetos(ArrayList array, int x) {
        switch (x) {
            case 5:
                if (array.size() == 0) {
                    syncArrayList(array);
                }
                System.out.println("=========================== Cuentas ========================================================");
                for (int n = 0; n < array.size(); n++) {
                    System.out.println("Usuario:" + ((Cliente) array.get(n)).getUser() + "\t" + "Password:" + ((Cliente) array.get(n)).getPass() + "\t" + "Nombre:" + ((Cliente) array.get(n)).getNombre() + "\t" + "Sucursal:" + ((Cliente) array.get(n)).getSucursal());
                }
                System.out.println("======================================");
                break;
            case 8:
                if (array.size() == 0) {
                    mSuc.syncSucursal(array);
                }
                System.out.println("=========================== Sucursales ========================================================");
                for (int n = 0; n < array.size(); n++) {
                    System.out.println("Sucursal:" + ((Sucursal) array.get(n)).getNombre() + "\t" + "Codigo:" + ((Sucursal) array.get(n)).getCodigo());
                }
                System.out.println("======================================");
                break;

        }

    }

    public void modificar_txtUs(ArrayList cuentas, String use, ArrayList buses, ArrayList viajes, ArrayList sucursales) {
        syncArrayList(cuentas);
        int op = 10;
        while (op != 2) {
            Cliente.menuGeneral();
            int resp1 = validar.leerInt();
            switch (resp1) {
                case 1:
                    Cliente.menuUs2();
                    op = validar.leerInt();
                    switch(op){
                        case 1:
                            break;
                        case 2:
                            break;
                        case 3:
                            break;
                        case 4:
                            break;
                        case 5:
                            break;
                        case 6:mViaj.guardar(viajes);
                            break;
                        
                    }
                    break;
                case 2:
                    Cliente.menuUs();
                    op = validar.leerInt();
                    switch (op) {
                        case 1:
                            boolean existCuen3 = false;
                            for (int n = 0; n < cuentas.size(); n++) {
                                if (((Cuenta) cuentas.get(n)).getUser().equals(use)) {
                                    existCuen3 = true;
                                    System.out.println("Introducir nueva contraseña:");
                                    String newPass = intro.nextLine();
                                    ((Cliente) cuentas.get(n)).setPass(newPass);
                                    System.out.println("=========================== Cuenta =========================================================================================================================================================================================");
                                    System.out.println("El usuario es:" + ((Cliente) cuentas.get(n)).getUser() + "\t" + " La nueva contraseña es:" + ((Cliente) cuentas.get(n)).getPass());
                                    System.out.println("============================FIN==============================================================================================================================================================================================");
                                    break;
                                }
                            }
                            if (existCuen3 == false) {
                                System.out.println("El usuario no se ha encontrado");
                            }
                            break;
                        case 2:
                            guardar(cuentas);
                    }
                    break;
                case 3:
                    break;

            }

        }
    }

    public void guardar(ArrayList cuentas) {
        System.out.println("Guardando");
        try {
            BufferedWriter write = new BufferedWriter(new FileWriter(DatosCuenta));
            for (int n = 0; n < cuentas.size(); n++) {
                if (n == 1) {
                    write.write(((Admin) cuentas.get(n)).getUser() + "|" + ((Admin) cuentas.get(n)).getPass() + "|" + ((Admin) cuentas.get(n)).getAdmin() + "\r\n");
                } else {
                    write.write(((Cliente) cuentas.get(n)).getUser() + "|" + ((Cliente) cuentas.get(n)).getPass() + "|" + ((Cliente) cuentas.get(n)).getNombre() + "|" + ((Cliente) cuentas.get(n)).getSucursal() + "\r\n");
                }
            }
            write.close();
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
        System.exit(0);
    }
    
    

    public void agregarCuentaTxt(String user, String pass, String info, int n) {
        try {

            BufferedWriter write = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(DatosCuenta, true), "utf-8"));

            write.write(user + "|" + pass + "|" + info + "|" + n + "\r\n");
            System.out.println("La cuenta ha sido agregada exitosamente");
            write.close();

        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
    }

}
