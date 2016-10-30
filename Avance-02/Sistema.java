package chooseandtravel;

import java.util.ArrayList;

public class Sistema {

	private ArrayList<Cuenta> cuentas;
        private ArrayList<Sucursal> sucursales;
        private ArrayList<Bus> buses;
        private ArrayList<Viaje> viajes;
        
        public void inicio(){
            ArrayList<Cuenta> cuentas =new ArrayList<Cuenta>();
            ArrayList<Sucursal>sucursales= new ArrayList<Sucursal>();
            ArrayList<Bus> buses=new ArrayList<Bus>();
            ArrayList<Viaje>viajes=new ArrayList<Viaje>();
            Datos_Cuentas mCuentas = new Datos_Cuentas();
            Datos_Empresa mSucursales= new Datos_Empresa();
            Datos_Buses mBuses= new Datos_Buses();
            Datos_Viajes mViajes=new Datos_Viajes();
            Login login =new Login();
            viajes=mViajes.syncArrayViajes(viajes);
            buses=mBuses.synArrayBuses(buses);
            cuentas=mCuentas.syncArrayList(cuentas);
            sucursales=mSucursales.syncSucursal(sucursales);
            login.inicio(cuentas, sucursales,buses,viajes);
        }
}