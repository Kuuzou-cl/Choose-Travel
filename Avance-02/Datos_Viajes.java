package chooseandtravel;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
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
                int horario = Integer.parseInt(strHorario);
                int fecha = Integer.parseInt(strFecha);
                int asiento = Integer.parseInt(strAsiento);
                
                
                objetoV = new Viaje(strEmpresa, strOrigen,strDestino,horario,fecha,asiento);
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
                write.write(((Viaje) viajes.get(n)).getEmpresa() + "|" + ((Viaje) viajes.get(n)).getOrigen() + "|" + ((Viaje) viajes.get(n)).getDestino()+"|"+ ((Viaje) viajes.get(n)).getHorario()+"|"+ ((Viaje) viajes.get(n)).getFecha()+"|"+ ((Viaje) viajes.get(n)).getAsiento()+"|"+ ((Viaje) viajes.get(n)).getEstado() + "\r\n");
            }
            write.close();
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
        System.exit(0);
    }
}