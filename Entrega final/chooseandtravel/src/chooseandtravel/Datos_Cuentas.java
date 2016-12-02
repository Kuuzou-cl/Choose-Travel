package chooseandtravel;

import java.io.*;
import java.util.*;
import javax.swing.DefaultComboBoxModel;
import javax.swing.table.DefaultTableModel;

/**
 *
 * Clase con los metodos para manipular la informacion que se relacione con cuentas
 * 
 * @author Carlo Bernucci, Javier Nualart
 * @version 3.1
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
     * Metodo que sincroniza el array con el archivo de texto
     * @param cuentas ArrayList en el momento vacio
     * @return Retorna el ArrayList con la informacion del archivo de texto
     */
    public ArrayList syncArrayList(ArrayList cuentas) {
        cuentas.clear();
        txt_array(cuentas);
        return cuentas;
    }
    
    /**
     * 
     * Metodo que crea un objeto cuenta, lo agrega al arraylist
     * y despues loe scribe en el archivo de texto
     * @param user String de nombre de usuario
     * @param pass String de contraseña del usuario
     * @param info String de nombre real del usuario
     * @param n Integer de sucursal del usuario
     * @param cuentas ArrayList con la informacion de los usuario
     */
    public void agregarCuenta(String user, String pass, String info, int n, ArrayList cuentas){
       objetoC= new Cliente(user,pass,info,n);
       cuentas.add(objetoC);
       cuentaToTxt(objetoC);
    }
    
    /**
     * Metodo que escribe la informacion del archivo de texto al arraylist creando objetos
     * @param cuentas ArrayList de cuentas
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
     * Metodo que modifica la contraseña en el arraylist segun un usuario
     * @param cuentas ArrayList con la informacion de las cuentas
     * @param cuenta String con el nombre de usuario que se desea modificar
     * @param newpass String con la nueva contraseña
     */
    public void modPass(ArrayList cuentas, String cuenta, String newpass) {

        for (int n = 1; n < cuentas.size(); n++) {

            if (((Cliente) cuentas.get(n)).getNombre().equals(cuenta)) {
                ((Cuenta) cuentas.get(n)).setPass(newpass);
                guardar(cuentas);
            }
        }
    }

    /**
     * 
     * Metodo que modifica la contrase del usuario logeado
     * @param cuentas ArrayList de cuentas
     * @param cuenta String del usuario logeado
     * @param newpass String de nueva contraseña
     * @param pass String de antigua contraseña
     * @return Retorna verdadero si se cambia y false si fallo
     */
    public boolean modPassUser(ArrayList cuentas, String cuenta, String newpass, String pass) {

        for (int n = 1; n < cuentas.size(); n++) {

            if (((Cliente) cuentas.get(n)).getNombre().equals(cuenta)&&((Cliente) cuentas.get(n)).getPass().equals(pass)) {
                ((Cuenta) cuentas.get(n)).setPass(newpass);
                guardar(cuentas);
                return true;
            }
        }
        return false;
    }

    /**
     * 
     * Metodo que modifica el nombre real de un usuario
     * @param cuentas ArrayList con la informacion de usuarios
     * @param user String con el nombre de usuario
     * @param newname String con el nuevo nombre real
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
     * Metodo que elimina un usuario del arraylist y despues actualiza
     * el archivo de texto
     * @param user String usuario que se quiere eliminar
     * @param cuentas ArrayList con la informacion de cuentas
     * @return Retonra verdadero si se pudo remover, y falso si no existe el usuario ingresado
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
            guardar(cuentas);
            return true;
        }
    }

    /**
     * Metodo que escribe en el archivo de texto la informaacion 
     * recibida del arraylist
     * @param cuentas ArrayList con la informacion de las cuentas
     */
    public void guardar(ArrayList cuentas) {
        try {
            BufferedWriter write = new BufferedWriter(new FileWriter(DatosCuenta));
            for (int n = 0; n < cuentas.size(); n++) {
                if (n == 0) {
                    write.write(((Admin) cuentas.get(n)).getUser() + "|" + ((Admin) cuentas.get(n)).getPass() + "|"  + "\r\n");
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
     * Metodo que escribe un objeto Cliente en un archivo de texto
     * @param cliente Objeto tipo Cliente que se va a escribir en el archivo de texto
     */
    public void cuentaToTxt(Cliente cliente) {
        try {
            BufferedWriter write = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(DatosCuenta, true), "utf-8"));
            write.write("\r\n" + cliente.getUser() + "|" + cliente.getPass() + "|" + cliente.getNombre() + "|" + cliente.getSucursal());
            write.close();
        } catch (Exception ex) {

        }
    }

    /**
     * Metodo que genera un TableModel con la informacion de usuario y 
     * sus viajes
     * @param cuentas ArrayList con la informacion de usuarios
     * @return retorna TableModel con la informacion
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
     * Metodo que genera un Table model con la informacion de usario y su sucursal
     * @param cuentas ArrayList con la informacion de cuentas
     * @param sucursales Arraylist con la informacion de sucursales 
     * @return Retorna un TableModel con la informacion
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
     * Metodo que Genera un ComboBoxModel con las cuentas de usuario
     * @param cuentas ArrayList con la informacion de las cuentas de usuario
     * @return Retorna un ComboBoxModel con la informacion de usuarios
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
     * Metodo que devuelve el nombre de la sucursale de un usuarioen especifico
     * @param cuentas ArrayList con la informacion de cuentas
     * @param nombre String con el usuario
     * @param sucursales ArrayList con la informacion de las sucursales
     * @return Retorna un String con el nombre de la sucursal del usuario recibido
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
