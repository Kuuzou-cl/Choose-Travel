package chooseandtravel;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Datos_Buses {

    File DatosBuses = new File("C:\\Users\\krlo9\\Documents\\NetBeansProjects\\ChooseAndTravel\\src\\chooseandtravel\\buses.txt");
    Bus objetoB = null;
    private ArrayList<Integer> asientos;

    public ArrayList synArrayBuses(ArrayList buses) {
        buses.clear();
        txt_array(buses);
        return buses;
    }

    public void txt_array(ArrayList buses) {
        try {
            String linea = null;
            BufferedReader read = new BufferedReader(new FileReader(DatosBuses));
            while ((linea = read.readLine()) != null) {
                StringTokenizer split = new StringTokenizer(linea, "|");
                String strEmpresa = split.nextToken().trim();
                String strOrigen = split.nextToken().trim();
                String strDestino = split.nextToken().trim();
                String strHorario = split.nextToken().trim();
                String strFecha = split.nextToken().trim();
                int horario = Integer.parseInt(strHorario);
                int fecha = Integer.parseInt(strFecha);
                asientos=new ArrayList<Integer>();
                for(int n=1;n<31;n++){
                    asientos.add(n);
                }
                
                objetoB = new Bus(strEmpresa, strOrigen,strDestino,horario,fecha,asientos);
                buses.add(objetoB);

            }
            read.close();

        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
    }
}
