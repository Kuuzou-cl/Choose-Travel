package chooseandtravel;

import java.io.*;
import java.util.*;
import javax.swing.DefaultComboBoxModel;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author kuuzou
 */
public class Datos_Cuentas {

    File DatosCuenta = new File("/home/kuuzou/NetBeansProjects/ChooseAndTravel/src/chooseandtravel/cuentas.txt");
    Cliente objetoC = null;
    Admin objetoA = null;
    Datos_Empresa mSuc = new Datos_Empresa();
    Datos_Viajes mViaj = new Datos_Viajes();
    Validador validar = new Validador();

    /**
     *
     * @param cuentas
     * @return
     */
    public ArrayList syncArrayList(ArrayList cuentas) {
        cuentas.clear();
        txt_array(cuentas);
        return cuentas;
    }

    /**
     *
     * @param cuentas
     */
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

    /**
     *
     * @param cuentas
     * @param user
     * @param newpass
     */
    public void modPass(ArrayList cuentas, String user, String newpass) {

        for (int n = 0; n < cuentas.size(); n++) {

            if (((Cuenta) cuentas.get(n)).getUser().equals(user)) {
                ((Cuenta) cuentas.get(n)).setPass(newpass);
                break;
            }
        }
        guardar(cuentas);
    }

    /**
     *
     * @param cuentas
     * @param user
     * @param newname
     */
    public void modNombre(ArrayList cuentas, String user, String newname) {

        for (int n = 0; n < cuentas.size(); n++) {
            if (((Cuenta) cuentas.get(n)).getUser().equals(user)) {

                ((Cliente) cuentas.get(n)).setNombre(newname);
                break;
            }
        }
        guardar(cuentas);
    }

    /**
     *
     * @param user
     * @param cuentas
     * @return
     */
    public boolean eliminarUser(String user, ArrayList cuentas) {
        if (validar.existUs(cuentas, user)) {
            return false;
        } else {
            for (int n = 0; n < cuentas.size(); n++) {
                if (((Cuenta) cuentas.get(n)).getUser().equals(user)) {
                    cuentas.remove(n);
                }
            }
            try {
                BufferedWriter write = new BufferedWriter(new FileWriter(DatosCuenta));
                for (int n = 0; n < cuentas.size(); n++) {
                    if (n == 0) {
                        write.write(((Admin) cuentas.get(n)).getUser() + "|" + ((Admin) cuentas.get(n)).getPass() + "|" + ((Admin) cuentas.get(n)).getAdmin() + "\r\n");
                    } else {
                        if (n + 1 == (cuentas.size())) {
                            write.write(((Cliente) cuentas.get(n)).getUser() + "|" + ((Cliente) cuentas.get(n)).getPass() + "|" + ((Cliente) cuentas.get(n)).getNombre() + "|" + ((Cliente) cuentas.get(n)).getSucursal());
                        } else {
                            write.write(((Cliente) cuentas.get(n)).getUser() + "|" + ((Cliente) cuentas.get(n)).getPass() + "|" + ((Cliente) cuentas.get(n)).getNombre() + "|" + ((Cliente) cuentas.get(n)).getSucursal() + "\r\n");
                        }
                    }
                }
                write.close();
            } catch (Exception ex) {
                System.out.println(ex.getMessage());
            }
            return true;
        }
    }

    /**
     *
     * @param cuentas
     */
    public void guardar(ArrayList cuentas) {
        System.out.println("Guardando");
        try {
            BufferedWriter write = new BufferedWriter(new FileWriter(DatosCuenta));
            for (int n = 0; n < cuentas.size(); n++) {
                if (n == 0) {
                    write.write(((Admin) cuentas.get(n)).getUser() + "|" + ((Admin) cuentas.get(n)).getPass() + "|" + ((Admin) cuentas.get(n)).getAdmin() + "\r\n");
                } else {
                    if (n + 1 == (cuentas.size())) {
                        write.write(((Cliente) cuentas.get(n)).getUser() + "|" + ((Cliente) cuentas.get(n)).getPass() + "|" + ((Cliente) cuentas.get(n)).getNombre() + "|" + ((Cliente) cuentas.get(n)).getSucursal());
                    } else {
                        write.write(((Cliente) cuentas.get(n)).getUser() + "|" + ((Cliente) cuentas.get(n)).getPass() + "|" + ((Cliente) cuentas.get(n)).getNombre() + "|" + ((Cliente) cuentas.get(n)).getSucursal() + "\r\n");
                    }
                }
            }
            write.close();
        } catch (Exception ex) {

        }
    }

    /**
     *
     * @param user
     * @param pass
     * @param info
     * @param n
     * @param cuentas
     */
    public void agregarCuentaTxt(String user, String pass, String info, int n, ArrayList cuentas) {
        try {
            BufferedWriter write = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(DatosCuenta, true), "utf-8"));
            write.write("\r\n" + user + "|" + pass + "|" + info + "|" + n);
            write.close();
        } catch (Exception ex) {

        }
    }

    /**
     *
     * @param cuentas
     * @return
     */
    public DefaultTableModel arrayToTab(ArrayList cuentas) {
        String colum[] = {"Usuario", "Aprobados", "Rechazados", "Pendientes"};
        DefaultTableModel table = new DefaultTableModel(colum, 0);
        for (int n = 1; n < cuentas.size(); n++) {
            Object[] user = {((Cliente) cuentas.get(n)).getNombre()};
            table.addRow(user);
        }
        return table;
    }

    /**
     *
     * @param cuentas
     * @param sucursales
     * @return
     */
    public DefaultTableModel arrayToTabShow(ArrayList cuentas, ArrayList sucursales) {
        String colum[] = {"Usuario", "Nombre", "Sucursal", "Codigo de Sucursal"};
        DefaultTableModel table = new DefaultTableModel(colum, 0);
        for (int n = 1; n < cuentas.size(); n++) {
            Object[] user = {((Cliente) cuentas.get(n)).getUser(), ((Cliente) cuentas.get(n)).getNombre(),
                mSuc.getNombreCod(((Cliente) cuentas.get(n)).getSucursal(), sucursales), ((Cliente) cuentas.get(n)).getSucursal()};
            table.addRow(user);
        }
        return table;
    }

    /**
     *
     * @param cuentas
     * @return
     */
    public DefaultComboBoxModel userToComboBox(ArrayList cuentas) {
        DefaultComboBoxModel lista = new DefaultComboBoxModel();
        String linea;
        for (int n = 1; n < cuentas.size(); n++) {
            linea = ((Cliente) cuentas.get(n)).getNombre();
            lista.addElement(linea);
        }
        return lista;
    }
    
    /**
     *
     * @param cuentas
     * @param nombre
     * @param sucursales
     * @return
     */
    public String SucursalDeUser(ArrayList cuentas, String nombre, ArrayList sucursales){
        String sucNombre = null;
        for (int n = 1; n < cuentas.size(); n++) {
            if(((Cliente) cuentas.get(n)).getNombre().equals(nombre)){
                sucNombre=mSuc.getNombreCod(((Cliente) cuentas.get(n)).getSucursal(), sucursales);
            }
        }
        return sucNombre;
    }

}
