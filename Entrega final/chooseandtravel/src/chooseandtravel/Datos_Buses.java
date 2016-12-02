package chooseandtravel;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.StringTokenizer;
import javax.swing.table.TableModel;

/**
 *
 * Clase con los metodos para manipular la informacion que se relacione con buses
 * 
 * @author Carlo Bernucci, Javier Nualart
 * @version 3.1
 */
public class Datos_Buses {

    File DatosBuses = new File("/home/kuuzou/NetBeansProjects/ChooseAndTravel/src/chooseandtravel/buses.txt");
    Bus objetoB = null;

    /**
     * Metodo que limpia el ArrayList buses, y despues llama el metodo txt_array 
     * para pasar la informacion del archivo a el ArrayList
     * @param buses Parametro ArrayList de buses, se recibe de sistema
     * @return Retorna el ArrayList de buses con la informacion
     */
    public ArrayList synArrayBuses(ArrayList buses) {
        buses.clear();
        txt_array(buses);
        return buses;
    }

    /**
     * Metodo para pasar la informacion del archivo de texto al arraylist
     * @param buses Parametro ArrayList de buses
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
     * Metodo para retornar los asientos de un Bus
     * @param buses Parametro ArrayList de buses
     * @param empresa Parametro String del nombre de la empresa de un bus
     * @param origen Parametro String del origen del viaje
     * @param destino Parametro String del destino del viaje
     * @param horario Parametro String del horario del viaje, formato hh:mm
     * @param fecha Parametro String de la fecha del viaje, formato dd/MM/yyyy
     * @return Retorna un int[] si existe un bus sino  retorna null
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
    
    /**
     * Metodo que escribe la informacion del ArrayList al archivo de texto
     * @param buses Parametro ArrayList de buses
     */
    public void guardar(ArrayList buses) {
        try {
            BufferedWriter write = new BufferedWriter(new FileWriter(DatosBuses));
            for (int n = 0; n < buses.size(); n++) {
                if (n + 1 == buses.size()) {
                    String asientos="";
                    for(int i=0;i<((Bus)buses.get(n)).getAsientos().length;i++){
                        if(i+1==((Bus)buses.get(n)).getAsientos().length){
                            asientos=asientos+((Bus)buses.get(n)).getAsientos()[i]+"|";
                        }else{
                            asientos=asientos+((Bus)buses.get(n)).getAsientos()[i]+"|";
                        }
                        
                    }
                    write.write(((Bus)buses.get(n)).getEmpresa() + "|" + ((Bus)buses.get(n)).getOrigen()
                            + "|" + ((Bus)buses.get(n)).getDestino() + "|" + ((Bus)buses.get(n)).getHorario() + "|"
                            + ((Bus)buses.get(n)).getFecha() + "|" + asientos);
                } else {
                    String asientos="";
                    for(int i=0;i<((Bus)buses.get(n)).getAsientos().length;i++){
                        if(i+1==((Bus)buses.get(n)).getAsientos().length){
                            asientos=asientos+((Bus)buses.get(n)).getAsientos()[i]+"|";
                        }else{
                            asientos=asientos+((Bus)buses.get(n)).getAsientos()[i]+"|";
                        }
                    }
                    write.write(((Bus)buses.get(n)).getEmpresa() + "|" + ((Bus)buses.get(n)).getOrigen()
                            + "|" + ((Bus)buses.get(n)).getDestino() + "|" + ((Bus)buses.get(n)).getHorario() + "|"
                            + ((Bus)buses.get(n)).getFecha() + "|" + asientos +"\r\n");
                }

            }
            write.close();
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
    }
    
    /**
     * Metodo que cambia un numero dentro del array de numeros de asientos a 0
     * @param tab Parametro TableModel donde se selecciona un viaje
     * @param i Parametro Integer de la fila dela tabla seleccionada
     * @param buses ArrayList de Buses
     */
    public void comprarAsiento(TableModel tab, int i,ArrayList buses){
        TableModel table = tab;
        String empresa = (String) table.getValueAt(i, 0);
        String origen = (String) table.getValueAt(i, 1);
        String destino = (String) table.getValueAt(i, 2);
        String horario = (String) table.getValueAt(i, 3);
        String fecha = (String) table.getValueAt(i, 4);
        int asiento = (Integer) table.getValueAt(i, 5);
        for(int n=0;n<buses.size();n++){
            if(((Bus)buses.get(n)).getEmpresa().equals(empresa)
                    &&((Bus)buses.get(n)).getOrigen().equals(origen)
                    &&((Bus)buses.get(n)).getDestino().equals(destino)
                    &&((Bus)buses.get(n)).getHorario().equals(horario)
                    &&((Bus)buses.get(n)).getFecha().equals(fecha)){
                (((Bus)buses.get(n)).getAsientos() [(asiento-1)])=0;
            }
        }
        guardar(buses);
        
    }

}
