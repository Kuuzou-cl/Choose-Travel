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

public class Datos_Viajes {

    File DatosViajes = new File("C:\\Users\\krlo9\\Documents\\NetBeansProjects\\ChooseAndTravel\\src\\chooseandtravel\\viajes.txt");
    Viaje objetoV = null;

    public ArrayList syncArrayViajes(ArrayList viajes) {
        viajes.clear();
        txt_array(viajes);
        return viajes;
    }

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
                Boolean estado= Boolean.parseBoolean(strEstado);
                objetoV = new Viaje(strEmpresa, strOrigen, strDestino, strHorario, strFecha, asiento, estado ,strUser);
                viajes.add(objetoV);
            }
            read.close();
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
    }

    public void guardar(ArrayList viajes) {
        System.out.println("Guardando");
        try {
            BufferedWriter write = new BufferedWriter(new FileWriter(DatosViajes));
            for (int n = 0; n < viajes.size(); n++) {
                write.write(((Viaje) viajes.get(n)).getEmpresa() + "|" + ((Viaje) viajes.get(n)).getOrigen() + "|" + ((Viaje) viajes.get(n)).getDestino() + "|" + ((Viaje) viajes.get(n)).getHorario() + "|" + ((Viaje) viajes.get(n)).getFecha() + "|" + ((Viaje) viajes.get(n)).getAsiento() + "|" + ((Viaje) viajes.get(n)).getEstado() +"|"+((Viaje) viajes.get(n)).getUsuario() +"\r\n");
            }
            write.close();
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
        System.exit(0);
    }

    public void agregarViaje(String origen, String destino, String horario, String fecha, int asiento, String user) {
        try {

            BufferedWriter write = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(DatosViajes, true), "utf-8"));

            write.write("turbus" + "|" + origen + "|" + destino + "|" + horario + "|" + fecha + "|" + asiento + "|" + null +"|"+user+ "\r\n");
            System.out.println("Viaje Solicitado");
            write.close();

        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
    }

    public void mostrarViajes(ArrayList viajes, Boolean estado, String use) {
        if (estado == true) {
            System.out.println("--------------Viajes aprobados---------");
            for (int n = 0; n < viajes.size(); n++) {
                if (((Viaje) viajes.get(n)).getEstado() == true&&((Viaje) viajes.get(n)).getUsuario().equals(use)) {
                    Viaje.toStringViaje(n, viajes);
                }
            }
        } else {
            if (estado == null) {
                System.out.println("--------------Viajes pendientes---------");
                for (int n = 0; n < viajes.size(); n++) {
                    if (((Viaje) viajes.get(n)).getEstado() == null&&((Viaje) viajes.get(n)).getUsuario().equals(use)) {
                        Viaje.toStringViaje(n, viajes);
                    }
                }
            }
        }

    }
}
