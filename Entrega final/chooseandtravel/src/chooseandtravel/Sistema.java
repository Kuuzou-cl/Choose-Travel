package chooseandtravel;

import java.util.ArrayList;
import ventanas.AdminVentana;
import ventanas.ClienteVentana;

/**
 * Clase que genera los ArrayList con el que el programa funciona, 
 * es la memoria del programa
 * 
 * @author Carlo Bernucci, Javier Nualart
 * @version 3.1
 */
public class Sistema {
    
    AdminVentana adminV;
    ClienteVentana clienteV;
    private ArrayList<Cuenta> cuentas = new ArrayList<Cuenta>();
    private ArrayList<Sucursal> sucursales = new ArrayList<Sucursal>();
    private ArrayList<Bus> buses = new ArrayList<Bus>();
    private ArrayList<Viaje> viajes = new ArrayList<Viaje>();
    private String sesion;
    Datos_Cuentas mCuentas = new Datos_Cuentas();
    Datos_Empresa mSucursales = new Datos_Empresa();
    Datos_Buses mBuses = new Datos_Buses();
    Datos_Viajes mViajes = new Datos_Viajes();

    /**
     *
     * Metodo que pasa la informacion de la base de datos a los ArrayList creado en la clase Sistema
     */
    public void inicio() {
        viajes = mViajes.syncArrayViajes(viajes);
        buses = mBuses.synArrayBuses(buses);
        cuentas = mCuentas.syncArrayList(cuentas);
        sucursales = mSucursales.syncSucursal(sucursales);
    }

    /**
     *
     * @return Retorna el ArrayList de cuentas
     */
    public ArrayList getCuentas() {
        return cuentas;
    }

    /**
     *
     * @return Retorna el ArrayList de Sucursales
     */
    public ArrayList getSucursales() {
        return sucursales;
    }

    /**
     *
     * @return Retorna el ArrayList de Buses
     */
    public ArrayList getBuses() {
        return buses;
    }

    /**
     *
     * @return Retorna el ArrayList de Viajes
     */
    public ArrayList getViajes() {
        return viajes;
    }

    /**
     *
     * @return Retorna el nombre de ususario de la sesion actual
     */
    public String getSesion() {
        if(sesion.equals("admin")){
            sesion="Administrador";
            return sesion;
        }else{
            return sesion;
        }
        
    }

    /**
     * Metodo para asignar un String a la variable sesion
     * @param s Parametro de tipo String, debe ser un nombre de usuario
     */
    public void setSesion(String s) {
        this.sesion = s;
    }

    /**
     * Metodo que hace Visible la ventana de Admin si es que existe
     * 
     */
    public void hacerVisible(){
        inicio();
        adminV.setVisible(true);
        adminV.reloadTable();
        adminV.reloadComboBox();
    }
    
    /**
     * Metodo que hace visible la ventana del Cliente si existe
     */
    public void hacerVisibleCliente(){
        inicio();
        clienteV.setVisible(true);
        
    }
    
    /**
     *
     * Metodo para verificar el usuario y contraseña y asi mostrar un error o la ventana correspondiente a la cuenta
     * @param user Parametro de tipo String , representa el usuario ingresado
     * @param pass Parametro String, representa la contraseña ingresada
     * @param sistema Parametro de tipo Sistema, sirve para pasar la informacion de los ArrayList
     * @return Retorna Verdadero si pasa el login, y falso siesta erronea la cuenta o contraseña
     */
    public boolean login(String user, String pass, Sistema sistema) {
        for (int n = 0; n < cuentas.size(); n++) {
            if (((Cuenta) cuentas.get(n)).getUser().equals(user)) {
                if (((Cuenta) cuentas.get(n)).getPass().equals(pass)) {
                    if (((Cuenta) cuentas.get(n)).getUser().equals("admin")) {
                        setSesion(user);
                        adminV = new AdminVentana(sistema);
                        adminV.setVisible(true);
                        return true;
                    } else {
                        setSesion(((Cliente) cuentas.get(n)).getNombre());
                        clienteV = new ClienteVentana(sistema);
                        clienteV.setVisible(true);
                        return true;
                    }
                }else{
                }
            }else{
            }
        }
        return false;
    }
}
