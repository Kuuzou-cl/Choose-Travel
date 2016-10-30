package chooseandtravel;

import java.io.*;
import java.util.*;

public class Datos_Cuentas {

    File DatosCuenta = new File("C:\\Users\\krlo9\\Documents\\NetBeansProjects\\ChooseAndTravel\\src\\chooseandtravel\\cuentas.txt");
    Cliente objetoC = null;
    Admin objetoA = null;
    Datos_Empresa mSuc = new Datos_Empresa();
    Datos_Viajes mViaj = new Datos_Viajes();
    Calendario calendario = new Calendario();
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

    public void config1Admin(ArrayList cuentas) {
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
    }

    public void config2Admin(ArrayList cuentas) {
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
    }

    public void config3Admin(ArrayList cuentas) {
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
    }

    public void config4Admin(ArrayList cuentas) {
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
                        config1Admin(cuentas);
                        break;
                    case 2:
                        config2Admin(cuentas);
                        break;
                    case 3:
                        config3Admin(cuentas);
                        break;
                    case 4:
                        config4Admin(cuentas);
                        break;
                    case 5:
                        mostrarCuentas(cuentas);
                        break;
                    case 6:
                        mSuc.agregarSuc(sucursales);
                        break;
                    case 7:
                        mSuc.eliminarSuc(sucursales);
                        break;
                    case 8:
                        mSuc.mostrarSucursales(sucursales);
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

    public void menu1UserCase1(ArrayList sucursales, ArrayList viajes) {
        System.out.println("------------------->Ingresar codigo de origen del viaje");
        mSuc.mostrarSucursales(sucursales);
        int codOrigen = validar.leerInt();
        String origen=mSuc.getNombreCod(codOrigen, sucursales);
        System.out.println("------------------->Ingresar codigo de destino del viaje");
        mSuc.mostrarSucursales2(sucursales, codOrigen);
        int codDestino = validar.leerInt();
        String destino =mSuc.getNombreCod(codDestino, sucursales);
        System.out.println("------------------->Ingresar opcion de horario");
        System.out.println("1.- 07:30 AM\n2.- 12:30 PM\n3.- 19:30 PM");
        int codHorario = validar.leerInt();
        String horario = null;
        switch(codHorario){
            case 1: horario="0730";
            break;
            case 2: horario="1230";
            break;
            case 3: horario="1930";
            break;
        }
        System.out.println("------------------->Ingresar Año del viaje (año actual: " + calendario.getAño() + ")");
        int codAño = validar.leerInt();
        System.out.println("------------------->Ingresar numero de Mes del viaje (mes actual: " + calendario.getMes() + ")");
        int codMes = validar.leerInt();
        System.out.println("------------------->Ingresar numero del dia del mes del viaje (dia actual: " + calendario.getDia() + ")");
        int codDia = validar.leerInt();
        String fecha = null;
        if(codDia<10&&codMes>9){
            fecha=("0"+Integer.toString(codDia)+Integer.toString(codMes));
        }
        if(codDia>9&&codMes<10){
            fecha=(Integer.toString(codDia)+"0"+Integer.toString(codMes));
        }
        if(codDia<10||codMes<10){
            fecha=("0"+Integer.toString(codDia)+"0"+Integer.toString(codMes));
        }
        System.out.println("------------------->Ingresar numero de asiento");
        int codAsiento = validar.leerInt();
        System.out.println("Viaje solicitado para el "+codDia+"/"+codMes+"/"+codAño+" a las "+horario.substring(0,1)+":"+horario.substring(2,3));
        mViaj.agregarViaje(origen,destino,horario,fecha,codAsiento);
    }

    public void menu1User(ArrayList viajes, ArrayList sucursales) {
        int resp1 = 10;
        Cliente.menuUs1();
        resp1 = validar.leerInt();
        switch (resp1) {
            case 1: menu1UserCase1(sucursales,viajes);
                break;
            case 2:
                break;
            case 3:
                break;
            case 4:
                break;
            case 5:
                break;
            case 6:
                mViaj.guardar(viajes);
                break;
        }
    }

    public void menu2User(ArrayList cuentas, String use) {
        int resp2;
        Cliente.menuUs2();
        resp2 = validar.leerInt();
        switch (resp2) {
            case 1:
                boolean existCuen3 = false;
                for (int n = 0; n < cuentas.size(); n++) {
                    if (((Cuenta) cuentas.get(n)).getUser().equals(use)) {
                        System.out.println("Ingresar contraseña ACTUAL");
                        String actual = intro.nextLine();
                        if (((Cliente) cuentas.get(n)).getPass().equals(actual)) {
                            System.out.println("Introducir nueva contraseña:");
                            String newPass = intro.nextLine();
                            ((Cliente) cuentas.get(n)).setPass(newPass);
                            System.out.println("=========================== Cuenta ==================================================================================================");
                            System.out.println("El usuario es:" + ((Cliente) cuentas.get(n)).getUser() + "\t" + " La nueva contraseña es:" + ((Cliente) cuentas.get(n)).getPass());
                            System.out.println("============================FIN======================================================================================================");
                        } else {
                            System.out.println("Contraseña erronea, volviendo a menu");
                        }
                        break;
                    }
                }
                break;
            case 2:
                guardar(cuentas);
        }
    }

    public void modificar_txtUs(ArrayList cuentas, String use, ArrayList buses, ArrayList viajes, ArrayList sucursales) {
        syncArrayList(cuentas);
        int resp = 10;
        while (resp != 3) {
            Cliente.menuGeneral();
            resp = validar.leerInt();
            switch (resp) {
                case 1:
                    menu1User(viajes, sucursales);
                    break;
                case 2:
                    menu2User(cuentas, use);
                    break;
                case 3:
                    guardar(cuentas);

                    break;
            }

        }
    }

    public void mostrarCuentas(ArrayList cuentas) {
        if (cuentas.isEmpty()) {
            syncArrayList(cuentas);
        }
        System.out.println("=========================== Cuentas ========================================================");
        for (int n = 1; n < cuentas.size(); n++) {
            System.out.println("Usuario:" + ((Cliente) cuentas.get(n)).getUser() + "\t" + "Password:" + ((Cliente) cuentas.get(n)).getPass() + "\t" + "Nombre:" + ((Cliente) cuentas.get(n)).getNombre() + "\t" + "Sucursal:" + ((Cliente) cuentas.get(n)).getSucursal());
        }
        System.out.println("======================================");
    }

    public void guardar(ArrayList cuentas) {
        System.out.println("Guardando");
        try {
            BufferedWriter write = new BufferedWriter(new FileWriter(DatosCuenta));
            for (int n = 0; n < cuentas.size(); n++) {
                if (n == 0) {
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
