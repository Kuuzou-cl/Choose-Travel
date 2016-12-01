package chooseandtravel;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

/**
 *
 * @author kuuzou
 */
public class Datos_Buses {

    File DatosBuses = new File("/home/kuuzou/NetBeansProjects/ChooseAndTravel/src/chooseandtravel/buses.txt");
    Bus objetoB = null;

    /**
     *
     * @param buses
     * @return
     */
    public ArrayList synArrayBuses(ArrayList buses) {
        buses.clear();
        txt_array(buses);
        return buses;
    }

    /**
     *
     * @param buses
     */
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
                int [] asientos=new int [25];
                String asientoN;
                for(int n=0;n<25;n++){
                    int asiento = Integer.parseInt(asientoN = split.nextToken().trim());
                    asientos[n]=asiento;
                }  
                objetoB = new Bus(strEmpresa, strOrigen,strDestino,strHorario,strFecha,asientos);
                buses.add(objetoB);
            }
            read.close();
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
    }
    
    /**
     *
     * @param buses
     * @param empresa
     * @param origen
     * @param destino
     * @param horario
     * @param fecha
     * @return
     */
    public int[] getAsientos(ArrayList buses,String empresa,String origen, String destino, String horario,String fecha){
        for(int n=0;n<buses.size();n++){
            if(((Bus)buses.get(n)).getEmpresa().equals(empresa)&&((Bus)buses.get(n)).getOrigen().equals(origen)
                    &&((Bus)buses.get(n)).getDestino().equals(destino)&&((Bus)buses.get(n)).getHorario().equals(horario)
                    &&((Bus)buses.get(n)).getFecha().equals(fecha)){
                return ((Bus)buses.get(n)).getAsientos();
            }else{
                
            }
        }
        return null;
    }
    
    

}
