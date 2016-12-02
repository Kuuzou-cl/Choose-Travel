package chooseandtravel;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.StringTokenizer;
import javax.swing.DefaultComboBoxModel;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;

/**
 *
 * Clase con los metodos para manipular la informacion que se relacione con viajes
 * 
 * @author Carlo Bernucci, Javier Nualart
 * @version 3.1
 */
public class Datos_Viajes {
    
    Datos_Empresa mSuc=new Datos_Empresa();
    File DatosViajes = new File("/home/kuuzou/NetBeansProjects/ChooseAndTravel/src/chooseandtravel/viajes.txt");
    Viaje objetoV = null;

    /**
     * Metodo que limpia un arraylist de viajes, y despues llama el metodo
     * txt_array para pasar la informacion del archivo de texto al arraylist
     * @param viajes ArrayList de viajes
     * @return Retorna el ArrayList de viajes leno de la informacion del archivo de texto
     */
    public ArrayList syncArrayViajes(ArrayList viajes) {
        viajes.clear();
        txt_array(viajes);
        return viajes;
    }

    /**
     * Metodo que escribe la informacion del archivo de texto al arraylist,
     * lo ahce creando objetos de tipo Viaje
     * @param viajes Arraylist de viajes donde se guardan los objetos
     */
    public void txt_array(ArrayList viajes) {
        try {
            String linea = null;
            BufferedReader read = new BufferedReader(new FileReader(DatosViajes));
            while ((linea = read.readLine()) != null) {
                StringTokenizer split = new StringTokenizer(linea, "|");
                String strEmpresa = split.nextToken().trim();
                String strOrigen = split.nextToken().trim();
                String strDestino = split.nextToken().trim();
                String strHorario = split.nextToken().trim();
                String strFecha = split.nextToken().trim();
                String strAsiento = split.nextToken().trim();
                String strEstado = split.nextToken().trim();
                String strUser = split.nextToken().trim();
                int asiento = Integer.parseInt(strAsiento);
                Boolean estado;
                if (strEstado.equals("null")) {
                    estado = null;
                } else {
                    estado = Boolean.parseBoolean(strEstado);
                }
                objetoV = new Viaje(strEmpresa, strOrigen, strDestino, strHorario, strFecha, asiento, estado, strUser);
                viajes.add(objetoV);
            }
            read.close();
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
    }

    /**
     * Metodo que escribe la informacion del arraylist al archivo de texto
     * @param viajes Parametro ArrayList de viajes
     */
    public void guardar(ArrayList viajes) {
        try {
            BufferedWriter write = new BufferedWriter(new FileWriter(DatosViajes));
            for (int n = 0; n < viajes.size(); n++) {
                if (n + 1 == viajes.size()) {
                    write.write(((Viaje) viajes.get(n)).getEmpresa() + "|" + ((Viaje) viajes.get(n)).getOrigen()
                            + "|" + ((Viaje) viajes.get(n)).getDestino() + "|" + ((Viaje) viajes.get(n)).getHorario() + "|"
                            + ((Viaje) viajes.get(n)).getFecha() + "|" + ((Viaje) viajes.get(n)).getAsiento() + "|"
                            + ((Viaje) viajes.get(n)).getEstado() + "|" + ((Viaje) viajes.get(n)).getUsuario());
                } else {
                    write.write(((Viaje) viajes.get(n)).getEmpresa() + "|" + ((Viaje) viajes.get(n)).getOrigen()
                            + "|" + ((Viaje) viajes.get(n)).getDestino() + "|" + ((Viaje) viajes.get(n)).getHorario() + "|"
                            + ((Viaje) viajes.get(n)).getFecha() + "|" + ((Viaje) viajes.get(n)).getAsiento() + "|"
                            + ((Viaje) viajes.get(n)).getEstado() + "|" + ((Viaje) viajes.get(n)).getUsuario() + "\r\n");
                }

            }
            write.close();
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
    }
    
    /**
     *
     * Metodo que agrega un viaje, llama un metodo para agregarlo al arraylist y despues escribirlo 
     * en el archivo de texto
     * @param origen Parametro String de origen del viaje
     * @param destino Parametro String de destino del viaje
     * @param horario Parametro String de horario del viaje
     * @param fecha Parametro String de fehca del viaje
     * @param asiento Parametro int del asiento pedido por el usuario
     * @param user Parametro String del usuario asociado al viaje
     * @param viajes Arraylist de viajes
     */
    public void agregarViaje(String origen, String destino, String horario, String fecha, int asiento, String user,ArrayList viajes){
        objetoV=new Viaje("turbus",origen,destino,horario,fecha,asiento,null,user);
        viajes.add(objetoV);
        viajeToTxt(objetoV);
    }
    
    /**
     * Metodo que que recibe un objeto Viaje y 
     * lo escribe en el archivo de texto
     * @param viaje Objeto de tipo Viaje para esribir en el archivo de texto
     */
    public void viajeToTxt(Viaje viaje) {
        try {
            String linea = null;
            BufferedReader read = new BufferedReader(new FileReader(DatosViajes));
            BufferedWriter write = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(DatosViajes, true), "utf-8"));
            if((linea = read.readLine()) == null){
                write.write(viaje.getEmpresa() + "|" + viaje.getOrigen() + "|" + viaje.getDestino() 
                    + "|" + viaje.getHorario() + "|" + viaje.getFecha() + "|"
                    + viaje.getAsiento() + "|" + null + "|" + viaje.getUsuario());
            }else{
                write.write("\r\n" + viaje.getEmpresa() + "|" + viaje.getOrigen() + "|" + viaje.getDestino() 
                    + "|" + viaje.getHorario() + "|" + viaje.getFecha() + "|"
                    + viaje.getAsiento() + "|" + null + "|" + viaje.getUsuario());
            }
           
            write.close();

        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
    }


    /**
     *
     * Metodo que convierte la informacion de un ArrayList de viajes 
     * segun un usuario a un TableModel
     * @param nombre String de usuario para identificar sus viajes
     * @param viajes ArrayList de Viajes
     * @return Retorna un TableModel con la informacion
     */
    public DefaultTableModel viajesToTable(String nombre, ArrayList viajes) {
        String colum[] = {"Origen", "Destino", "Horario", "Fecha", "Asiento"};
        DefaultTableModel table = new DefaultTableModel(colum, 0);
        for (int n = 0; n < viajes.size(); n++) {
            if (((Viaje) viajes.get(n)).getUsuario().equals(nombre)) {
                Object[] viaje = {((Viaje) viajes.get(n)).getOrigen(), ((Viaje) viajes.get(n)).getDestino(),
                    ((Viaje) viajes.get(n)).getHorario(), ((Viaje) viajes.get(n)).getFecha(), ((Viaje) viajes.get(n)).getAsiento()
                };
                table.addRow(viaje);
            }
        }
        return table;
    }

    /**
     * Metodo que retorna un TableModel con todos los viajes de todos los tipos de un usuario
     * @param nombre String del nombre de usuario de los viajes a buscar
     * @param viajes ArrayList de viajes
     * @return Retorna un TableModel con la informacion de los viajes del usuario
     */
    public DefaultTableModel viajesHistorialUser(String nombre, ArrayList viajes) {
        
        String colum[] = {"Origen", "Destino", "Horario", "Fecha", "Asiento"};
        DefaultTableModel table = new DefaultTableModel(colum, 0);
        for (int n = 0; n < viajes.size(); n++) {
            if (((Viaje) viajes.get(n)).getUsuario().equals(nombre)) {
                if (Validador.fechaPasada(((Viaje) viajes.get(n)).getFecha(), ((Viaje) viajes.get(n)).getHorario())) {
                    Object[] viaje = {((Viaje) viajes.get(n)).getOrigen(),
                        ((Viaje) viajes.get(n)).getDestino(),
                        ((Viaje) viajes.get(n)).getHorario(),
                        ((Viaje) viajes.get(n)).getFecha(),
                        ((Viaje) viajes.get(n)).getAsiento()
                    };
                    table.addRow(viaje);
                }

            }
        }
        return table;
    }

    /**
     *
     * Metodo que cambia el estado de un viaje a true o false para aceptar o rechazar
     * @param tab Tabla con la informacion
     * @param i Integer con el numero de fila
     * @param us Nombre de Usuario asociado viaje
     * @param viajes ArrayList de Viajes
     * @param est Estado al cual se desea cambiar el viaje
     */
    public void aceptarViaje(TableModel tab, int i, String us, ArrayList viajes, Boolean est) {
        TableModel table = tab;
        String destino = (String) table.getValueAt(i, 2);
        String horario = (String) table.getValueAt(i, 3);
        String fecha = (String) table.getValueAt(i, 4);
        for (int j = 0; j < viajes.size(); j++) {
            if (((Viaje) viajes.get(j)).getUsuario().equals(us) 
                    && ((Viaje) viajes.get(j)).getDestino().equals(destino)
                    && ((Viaje) viajes.get(j)).getHorario().equals(horario) 
                    && ((Viaje) viajes.get(j)).getFecha().equals(fecha)) {
                ((Viaje) viajes.get(j)).setEstado(est);
            }
        }
        guardar(viajes);
    }
    
    /**
     * Metodo que retorna un TableModel con la informacion de usuario, viajes y
     * gastos asociados
     * @param cuentas ArrayList con la informacion de cuentas
     * @param viajes ArrayList con la informacion de viajes
     * @param sucursales ArrayList con la informacion de Sucursales
     * @return retorna un TableModel con la informacion asociada
     */
    public DefaultTableModel arrayToTab(ArrayList cuentas, ArrayList viajes,ArrayList sucursales) {
        String colum[] = {"Usuario", "Aprobados", "Rechazados", "Pendientes","Gastos"};
        DefaultTableModel table = new DefaultTableModel(colum, 0);
        for (int n = 1; n < cuentas.size(); n++) {
            Object[] user = {((Cliente) cuentas.get(n)).getNombre(), 
                    contadorViajes(viajes, true, ((Cliente) cuentas.get(n)).getNombre()), 
                    contadorViajes(viajes, false, ((Cliente) cuentas.get(n)).getNombre()), 
                    contadorViajes(viajes, null,((Cliente) cuentas.get(n)).getNombre()),
                    calcularGasto(viajes,((Cliente) cuentas.get(n)).getNombre(),sucursales)};
            table.addRow(user);
        }
        return table;
    }
    
    /**
     * Metodo que retorna un TableModel con los viajes pendientes
     * @param viajes ArrayList con la informacion de viajes
     * @param user String con el usuario
     * @return Retorna el TableModel con la informacion
     */
    public DefaultTableModel arrayToTabShowViaje(ArrayList viajes, String user) {
        String colum[] = {"Empresa", "Origen", "Destino", "Horario", "Fecha", "Asiento"};
        DefaultTableModel table = new DefaultTableModel(colum, 0);
        for (int i = 0; i < viajes.size(); i++) {
            if (((Viaje) viajes.get(i)).getUsuario().equals(user) && ((Viaje) viajes.get(i)).getEstado() == null&&Validador.fechaActual(((Viaje) viajes.get(i)).getFecha())) {
                Object[] viaj = {((Viaje) viajes.get(i)).getEmpresa(), ((Viaje) viajes.get(i)).getOrigen(), ((Viaje) viajes.get(i)).getDestino(), ((Viaje) viajes.get(i)).getHorario(), ((Viaje) viajes.get(i)).getFecha(), ((Viaje) viajes.get(i)).getAsiento()};
                table.addRow(viaj);

            }
        }
        return table;
    }
    
    /**
     * 
     * Metodo que genera un TableModel con la informacion de viajes, con sus respectivos estados
     * @param viajes  ArrayList con la informacion de viajes 
     * @param nombre String con el nombre de usuario de los viajes
     * @return Retorna un TableModel con la informacion
     */
    public DefaultTableModel arrayToTabShowHistorial(ArrayList viajes, String nombre) {
        String colum[] = {"Empresa", "Origen", "Destino", "Horario", "Fecha", "Asiento", "Estado"};
        DefaultTableModel table = new DefaultTableModel(colum, 0);
        String est = "";
        for (int i = 0; i < viajes.size(); i++) {
            if (((Viaje) viajes.get(i)).getUsuario().equals(nombre) && ((Viaje) viajes.get(i)).getEstado() != null) {
                if (((Viaje) viajes.get(i)).getEstado() == true) {
                    est = "aprobado";
                } else {
                    est = "rechazado";
                }
                Object[] viaj = {((Viaje) viajes.get(i)).getEmpresa(), ((Viaje) viajes.get(i)).getOrigen(), ((Viaje) viajes.get(i)).getDestino(), ((Viaje) viajes.get(i)).getHorario(), ((Viaje) viajes.get(i)).getFecha(), ((Viaje) viajes.get(i)).getAsiento(), est};
                table.addRow(viaj);

            }
        }
        return table;
    }
    
    /**
     * Metodo que genera un TableModel con los viajes segun usuarios y estados
     * @param viajes ArrayList con la informacion de los viajes
     * @return Retorna un tableModel con la informacion de los viajes
     */
    public DefaultTableModel resumen( ArrayList viajes) {
        String colum[] = {"Usuario", "Fecha", "Horario", "Origen","Destino","Estado"};
        DefaultTableModel table = new DefaultTableModel(colum, 0);
        String est;
        for (int i = 0; i < viajes.size(); i++) {
            if(((Viaje) viajes.get(i)).getEstado()!=null){
                 if (((Viaje) viajes.get(i)).getEstado() == true) {
                    est = "aprobado";
                } else {
                    est = "rechazado";
                }
            Object[] user = {((Viaje) viajes.get(i)).getUsuario() ,((Viaje) viajes.get(i)).getFecha()
                                ,((Viaje) viajes.get(i)).getHorario(),((Viaje) viajes.get(i)).getOrigen(),((Viaje) viajes.get(i)).getDestino(),est};
            table.addRow(user);
            }
        }
        return table;
    }
    
    /**
     * 
     * Metodo que cuenta la cantidad de viajes con un estado en especifico y 
     * de un usuario en especifico
     * @param viajes ArrayList con la informaicon de viajes
     * @param est Estado de los viajes a contar
     * @param nombre Usuario de los viajes a contar
     * @return Retorna un int con el numero de viajes
     */
    public int contadorViajes(ArrayList viajes, Boolean est, String nombre) {
        int cont = 0;
        for (int i = 0; i < viajes.size(); i++) {
            if (((Viaje) viajes.get(i)).getUsuario().equals(nombre) && ((Viaje) viajes.get(i)).getEstado() == est) {
                cont++;
            }
        }
        return cont;
    }
    
    /**
     * Metodo que calcula el gasto de un usuario segun los viajes y el 
     * origen y destino en sucursales
     * @param viajes ArrayList con la informacion de viajes 
     * @param user String con el usuario 
     * @param sucursales ArrayList con la informacion de sucursales
     * @return Retorna un int con el total de gastos
     */
    public int calcularGasto(ArrayList viajes,String user,ArrayList sucursales){
    int gast = 0;
        for (int i = 0; i < viajes.size(); i++) {
            if(((Viaje)viajes.get(i)).getUsuario().equals(user)&&((Viaje)viajes.get(i)).getEstado()==true){
            int origen = mSuc.getCodigoNomn(((Viaje)viajes.get(i)).getOrigen(),sucursales);
            int destino=mSuc.getCodigoNomn(((Viaje)viajes.get(i)).getDestino(),sucursales);
            gast=Math.abs(destino-origen)*3000+gast;
            }
        }
    return gast;
    }
    
}
