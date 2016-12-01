package chooseandtravel;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.OutputStreamWriter;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.StringTokenizer;
import javax.swing.DefaultComboBoxModel;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import java.util.Date;

/**
 *
 * @author kuuzou
 */
public class Datos_Viajes {

    File DatosViajes = new File("/home/kuuzou/NetBeansProjects/ChooseAndTravel/src/chooseandtravel/viajes.txt");
    Viaje objetoV = null;

    /**
     *
     * @param viajes
     * @return
     */
    public ArrayList syncArrayViajes(ArrayList viajes) {
        viajes.clear();
        txt_array(viajes);
        return viajes;
    }

    /**
     *
     * @param viajes
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
     *
     * @param viajes
     */
    public void guardar(ArrayList viajes) {
        System.out.println("Guardando");
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
        System.exit(0);
    }

    /**
     *
     * @param origen
     * @param destino
     * @param horario
     * @param fecha
     * @param asiento
     * @param user
     */
    public void agregarViaje(String origen, String destino, String horario, String fecha, int asiento, String user) {
        try {

            BufferedWriter write = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(DatosViajes, true), "utf-8"));

            write.write("\r\n" + "turbus" + "|" + origen + "|" + destino + "|" + horario + "|" + fecha + "|"
                    + asiento + "|" + null + "|" + user);
            write.close();

        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
    }

    /**
     *
     * @param cuentas
     * @param nombre
     * @param viajes
     * @return
     */
    public DefaultComboBoxModel viajesToComboBox(ArrayList cuentas, String nombre, ArrayList viajes) {
        DefaultComboBoxModel lista = new DefaultComboBoxModel();
        String linea;
        for (int n = 1; n < cuentas.size(); n++) {
            if (((Cliente) cuentas.get(n)).getNombre().equals(nombre)) {
                for (int i = 0; i < viajes.size(); i++) {
                    if (((Viaje) viajes.get(i)).getUsuario().equals(nombre)) {
                        linea = ((Viaje) viajes.get(i)).getOrigen() + " a " + ((Viaje) viajes.get(i)).getDestino()
                                + ", Fecha: " + ((Viaje) viajes.get(i)).getFecha();
                        lista.addElement(linea);
                    }
                }
            }

        }

        return lista;
    }

    /**
     *
     * @param nombre
     * @param viajes
     * @return
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
     *
     * @param nombre
     * @param viajes
     * @return
     */
    public DefaultTableModel viajesHistorialUser(String nombre, ArrayList viajes) {
        DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
        Date hoyFecha = new Date();
        DateFormat horaFormat = new SimpleDateFormat("HH:mm");
        Date hoyHora = new Date();
        String colum[] = {"Origen", "Destino", "Horario", "Fecha", "Asiento"};
        DefaultTableModel table = new DefaultTableModel(colum, 0);
        for (int n = 1; n < viajes.size(); n++) {
            if (((Viaje) viajes.get(n)).getUsuario().equals(nombre)) {
                if (Validador.fechaPasada(((Viaje) viajes.get(n)).getFecha(), dateFormat.format(hoyFecha), horaFormat.format(hoyHora), ((Viaje) viajes.get(n)).getHorario())) {
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
     * @param tab
     * @param i
     * @param us
     * @param viajes
     * @param est
     */
    public void aceptarViaje(TableModel tab, int i, String us, ArrayList viajes, Boolean est) {
        TableModel table = tab;
        String destino = (String) table.getValueAt(i, 2);
        String horario = (String) table.getValueAt(i, 3);
        String fecha = (String) table.getValueAt(i, 4);
        for (int j = 0; j < viajes.size(); j++) {
            if (((Viaje) viajes.get(j)).getUsuario().equals(us) && ((Viaje) viajes.get(j)).getDestino().equals(destino)
                    && ((Viaje) viajes.get(j)).getHorario().equals(horario) && ((Viaje) viajes.get(j)).getFecha().equals(fecha)) {
                ((Viaje) viajes.get(j)).setEstado(est);
            }
        }
        guardar(viajes);
    }
    
    /**
     *
     * @param cuentas
     * @param viajes
     * @return
     */
    public DefaultTableModel arrayToTab(ArrayList cuentas, ArrayList viajes) {
        String colum[] = {"Usuario", "Aprobados", "Rechazados", "Pendientes"};
        DefaultTableModel table = new DefaultTableModel(colum, 0);
        for (int n = 1; n < cuentas.size(); n++) {
            Object[] user = {((Cliente) cuentas.get(n)).getNombre(), contadorViajes(viajes, true, ((Cliente) cuentas.get(n)).getNombre()), contadorViajes(viajes, false, ((Cliente) cuentas.get(n)).getNombre()), contadorViajes(viajes, null, ((Cliente) cuentas.get(n)).getNombre())};
            table.addRow(user);
        }
        return table;
    }
    
    /**
     *
     * @param viajes
     * @param user
     * @return
     */
    public DefaultTableModel arrayToTabShowViaje(ArrayList viajes, String user) {
        String colum[] = {"Empresa", "Origen", "Destino", "Horario", "Fecha", "Asiento"};
        DefaultTableModel table = new DefaultTableModel(colum, 0);
        for (int i = 0; i < viajes.size(); i++) {
            if (((Viaje) viajes.get(i)).getUsuario().equals(user) && ((Viaje) viajes.get(i)).getEstado() == null&&fechaActual(((Viaje) viajes.get(i)).getFecha())) {
                Object[] viaj = {((Viaje) viajes.get(i)).getEmpresa(), ((Viaje) viajes.get(i)).getOrigen(), ((Viaje) viajes.get(i)).getDestino(), ((Viaje) viajes.get(i)).getHorario(), ((Viaje) viajes.get(i)).getFecha(), ((Viaje) viajes.get(i)).getAsiento()};
                table.addRow(viaj);

            }
        }
        return table;
    }
    
    /**
     *
     * @param viajes
     * @param nombre
     * @return
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
     *
     * @param viajes
     * @return
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
     * @param viajes
     * @param est
     * @param nombre
     * @return
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
     *
     * @param fecha
     * @return
     */
    public boolean fechaActual(String fecha) {
        Calendario date = new Calendario();
        String[] fechaSplit = fecha.split("/");
        int dia = Integer.parseInt(fechaSplit[0]);
        int mes = Integer.parseInt(fechaSplit[1]);
        int año = Integer.parseInt(fechaSplit[2]);
        if (mes > date.getMes()) {
            return true;
        } else if (mes == date.getMes() && dia >= date.getDia()) {
            return true;
        }
        return false;
    }
    
}
