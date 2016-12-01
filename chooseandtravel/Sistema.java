package chooseandtravel;

import java.util.ArrayList;
import ventanas.AdminVentana;
import ventanas.ClienteVentana;

/**
 *
 * @author kuuzou
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
     */
    public void inicio() {
        viajes = mViajes.syncArrayViajes(viajes);
        buses = mBuses.synArrayBuses(buses);
        cuentas = mCuentas.syncArrayList(cuentas);
        sucursales = mSucursales.syncSucursal(sucursales);
    }

    /**
     *
     * @return
     */
    public ArrayList getCuentas() {
        return cuentas;
    }

    /**
     *
     * @return
     */
    public ArrayList getSucursales() {
        return sucursales;
    }

    /**
     *
     * @return
     */
    public ArrayList getBuses() {
        return buses;
    }

    /**
     *
     * @return
     */
    public ArrayList getViajes() {
        return viajes;
    }

    /**
     *
     * @return
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
     *
     * @param s
     */
    public void setSesion(String s) {
        this.sesion = s;
    }

    /**
     *
     */
    public void hacerVisible(){
        inicio();
        adminV.setVisible(true);
        adminV.reload();
    }
    
    /**
     *
     */
    public void hacerVisibleCliente(){
        inicio();
        clienteV.setVisible(true);
        
    }
    
    /**
     *
     * @param user
     * @param pass
     * @param sistema
     * @return
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
