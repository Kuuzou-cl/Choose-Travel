/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proyecto;

import java.util.*;
import java.io.*;

/**
 *
 * @author juan
 */
public class Dat_cuentas {

    Scanner intro = new Scanner(System.in);
    File DatosCuenta = new File("cuentas.txt");

    public ArrayList syncArrayList(ArrayList cuentas) {
        cuentas.clear();
        return cuentas;
    }

    public void txt_array(ArrayList cuentas) {
        try {
            String linea = null;
            BufferedReader read = new BufferedReader(new FileReader(DatosCuenta));
            int cont = 0;
            while ((linea = read.readLine()) != null) {
                cont++;
                StringTokenizer split = new StringTokenizer(linea, "|");
                switch (cont) {
                    case 1:
                        String usStr = split.nextToken().trim();
                        String pasStr = split.nextToken().trim();
                        Admin ad = new Admin(usStr, pasStr);
                        cuentas.add(ad);
                        break;
                    default:
                        String userStr = split.nextToken().trim();
                        String passStr = split.nextToken().trim();
                        String nombreStr = split.nextToken();
                        String sucStr = split.nextToken().trim();
                        int sucursal = Integer.parseInt(sucStr);
                        Cliente cl = new Cliente(userStr, passStr, nombreStr, sucursal);
                        cuentas.add(cl);
                        break;
                }

            }
            read.close();

        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
    }

    public void modificar_txt(ArrayList cuentas) {
        Validador val = new Validador();
        try {
            txt_array(cuentas);
            int op = 10;
            while (op != 5) {
                Admin.AdMenu();
                op = intro.nextInt();
                switch (op) {
                    case 1:
                        String us0 = "";
                        do {
                            System.out.println("Ingrese un nuevo usuario");
                            us0 = intro.nextLine();
                            us0 = intro.nextLine();
                        } while (val.valUs(us0) == false);
                        System.out.println("Ingrese la contraseña");
                        String pas0 = intro.nextLine();
                        String inf0 = "";
                        do {
                            System.out.println("Ingrese la informacion del usuario");
                            inf0 = intro.nextLine();
                        } while (val.valInfo(us0) == false);
                        System.out.println("Ingrese la sucursal del usuario");
                        int suc0 = intro.nextInt();
                        agregarCuentaTxt(us0, pas0, inf0, suc0);
                        syncArrayList(cuentas);
                        break;
                    case 2:
                        String us = "";
                        do {
                            System.out.println("Introducir el usuario a modificar:");
                            us = intro.nextLine();
                        } while (val.valUs(us) == false);
                        boolean existCuen1 = false;
                        for (int i = 0; i < cuentas.size(); i++) {

                            if (((Cuenta) cuentas.get(i)).getUser().equals(us)) {
                                existCuen1 = true;
                                System.out.println("Introducir nueva contraseña:");
                                String newPass = intro.nextLine();
                                ((Cuenta) cuentas.get(i)).setPass(newPass);
                                System.out.println("=========================== Cuenta =========================================================================================================================================================================================");
                                System.out.println("El usuario es:" + ((Cuenta) cuentas.get(i)).getUser() + "\t" + "y la nueva contraseña es:" + ((Cuenta) cuentas.get(i)).getPass());
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
                        } while (val.valUs(us2) == false);
                        boolean existCuen2 = false;
                        for (int i = 0; i < cuentas.size(); i++) {

                            if (((Cuenta) cuentas.get(i)).getUser().equals(us2)) {
                                existCuen2 = true;
                                System.out.println("Introducir nueva informacion:");
                                String newInfo = intro.next();
                                ((Cliente) cuentas.get(i)).setNombre(newInfo);
                                System.out.println("=========================== Cuenta =========================================================================================================================================================================================");
                                System.out.println("El usuario es:" + ((Cliente) cuentas.get(i)).getUser() + "\t" + "La nueva informacion es:" + ((Cliente) cuentas.get(i)).getNombre());
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
                        } while (val.valUs(us3) == false);
                        try {
                            BufferedWriter write = new BufferedWriter(new FileWriter(DatosCuenta));
                            for (int i = 0; i < cuentas.size(); i++) {
                                if (((Cuenta) cuentas.get(i)).getUser().equals(us3)) {
                                    System.out.println("La cuenta ha sido eliminada");
                                } else if (i == 1) {
                                    write.write(((Admin) cuentas.get(i)).getUser() + "|" + ((Admin) cuentas.get(i)).getPass() + "|" + ((Admin) cuentas.get(i)).getAdmin() + "\r\n");
                                } else {
                                    write.write(((Cliente) cuentas.get(i)).getUser() + "|" + ((Cliente) cuentas.get(i)).getPass() + "|" + ((Cliente) cuentas.get(i)).getNombre() + "|" + ((Cliente) cuentas.get(i)).getSucursal() + "\r\n");
                                }
                            }
                            write.close();
                            cuentas.clear();
                            txt_array(cuentas);
                        } catch (Exception ex) {
                            //Captura un posible error le imprime en pantalla   
                            System.out.println(ex.getMessage());
                        }
                        break;
                    case 5:
                        guardar(cuentas);
                }
            }
        } catch (Exception ex) {
            //Captura un posible error le imprime en pantalla   
            System.out.println(ex.getMessage());
        }
    }

    private void guardar(ArrayList cuentas) {
        System.out.println("Guardando");
        try {
            BufferedWriter write = new BufferedWriter(new FileWriter(DatosCuenta));
            for (int i = 0; i < cuentas.size(); i++) {
                if (i == 1) {
                    write.write(((Admin) cuentas.get(i)).getUser() + "|" + ((Admin) cuentas.get(i)).getPass() + "|" + ((Admin) cuentas.get(i)).getAdmin() + "\r\n");
                } else {
                    write.write(((Cliente) cuentas.get(i)).getUser() + "|" + ((Cliente) cuentas.get(i)).getPass() + "|" + ((Cliente) cuentas.get(i)).getNombre() + "|" + ((Cliente) cuentas.get(i)).getSucursal() + "\r\n");
                }
            }
            write.close();
        } catch (Exception ex) {
            //Captura un posible error le imprime en pantalla   
            System.out.println(ex.getMessage());
        }
        System.exit(0);
    }

    public void agregarCuentaTxt(String user, String pass, String name, int suc)//Este metodo recibe 3 String que son el usuario,contraseña,informacion que son 
    {
        try {
            BufferedWriter write = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(DatosCuenta, true), "utf-8"));

            write.write(user + "|" + pass + "|" + name + "|" + suc + "\r\n");
            System.out.println("La cuenta ha sido agregada exitosamente");
            write.close();

        } catch (Exception ex) {
            //Captura un posible error le imprime en pantalla   
            System.out.println(ex.getMessage());
        }
    }
    public void modificar_txtUs(ArrayList cuentas,String use){
    txt_array(cuentas);
    int op=10;
        while(op!=2){
                  Cliente.usMenu();
                   op=intro.nextInt();
             switch(op){      
                  case 1:      
                    for(int i = 0; i < cuentas.size(); i++)
                    {
                       
                      if(((Cuenta) cuentas.get(i)).equals(use)){
                        System.out.println("Introducir nueva contraseña:");
                        String    newPass=intro.nextLine();  
                        ((Cuenta) cuentas.get(i)).setPass(newPass);     
                        System.out.println("=========================== Cuenta =========================================================================================================================================================================================");
                        System.out.println("El usuario es:"+((Cuenta) cuentas.get(i)).getUser()+"\t"+" La nueva contraseña es:"+((Cuenta) cuentas.get(i)).getPass());
                        System.out.println("============================FIN==============================================================================================================================================================================================");
                        break;
                                         }  
                    }
                    break;
                    case 2:guardar(cuentas);
                }
            }
    }
}
