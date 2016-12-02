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

/**
 *
 * Clase con los metodos para manipular la informacion que se relacione con sucursales
 * 
 * @author Carlo Bernucci, Javier Nualart
 * @version 3.1
 */
public class Datos_Empresa {

    File DatosEmpresa = new File("/home/kuuzou/NetBeansProjects/ChooseAndTravel/src/chooseandtravel/sucursales.txt");
    Sucursal objetoS = null;
    Validador validar = new Validador();

    /**
     * Metodo que limpia el ArrayList suscursales, y llama el metodo txt_array
     * para pasar la informacion del archivo de texto al ArrayList
     * @param sucursales ArrayList que viene de sistema
     * @return Retorna el ArrayList con la informacion del archivo de texto
     */
    public ArrayList syncSucursal(ArrayList sucursales) {
        sucursales.clear();
        txt_array(sucursales);
        return sucursales;
    }

    /**
     * Metodo que crea objetos de tipo Sucursal y los agrega al ArrayList
     * @param sucursales ArrayList sucursales, creado en Sistema
     */
    public void txt_array(ArrayList sucursales) {
        try {
            String linea = null;
            BufferedReader read = new BufferedReader(new FileReader(DatosEmpresa));
            while ((linea = read.readLine()) != null) {
                StringTokenizer split = new StringTokenizer(linea, "|");
                String strNombre = split.nextToken().trim();
                String strCodigo = split.nextToken().trim();

                int codigo = Integer.parseInt(strCodigo);
                objetoS = new Sucursal(strNombre, codigo);
                sucursales.add(objetoS);
            }
            read.close();

        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
    }

    /**
     * 
     * Metodo para agregar una sucurasal, la agrega en el ArrayList y despues en el archivo de texto
     * @param n Nombre de la Sucursal
     * @param c Codigo de la Sucursar
     * @param sucursales Parametro ArrayList de sucursales
     */
    public void agregarSucursal(String n, int c, ArrayList sucursales){
        objetoS=new Sucursal(n,c);
        sucursales.add(objetoS);
        sucursalToTxt(objetoS);
    }
    
    /**
     *
     * Metodo que escribe un objeto sucursal en el ArrayList
     * @param sucursal Objeto Sucursal para escribir en el texto
     */
    public void sucursalToTxt(Sucursal sucursal) {
        try {
            BufferedWriter write = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(DatosEmpresa, true), "utf-8"));
            write.write("\r\n"+sucursal.getNombre() + "|" + sucursal.getCodigo());
            write.close();

        } catch (Exception ex) {
            
        }
    }

    /**
     * Metodo qe elimina una sucursal del array y despues actualiza el 
     * archivo de texto
     * @param sucursales ArrayList de sucursales
     * @param codigo Parametro de codigo de sucursal a eliminar
     */
    public void eliminarSuc(ArrayList sucursales,int codigo) {
        for (int n = 0; n < sucursales.size(); n++) {
            if(((Sucursal) sucursales.get(n)).getCodigo()==codigo){
                sucursales.remove(n);
            }
        }
        guardar(sucursales);
    }

    /**
     * Metodo que escribe la informacion del Arraylist sucursales al
     * archivo de texto
     * @param sucursales Parametro ArrayList de sucursales
     */
    public void guardar(ArrayList sucursales) {
        try {
            BufferedWriter write = new BufferedWriter(new FileWriter(DatosEmpresa));
            for (int n = 0; n < sucursales.size(); n++) {
                if(n+1==sucursales.size()){
                    write.write(((Sucursal) sucursales.get(n)).getNombre() + "|" + ((Sucursal) sucursales.get(n)).getCodigo());
                }else{
                    write.write(((Sucursal) sucursales.get(n)).getNombre() + "|" + ((Sucursal) sucursales.get(n)).getCodigo() + "\r\n");
                }
            }
            write.close();
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
    }

    /**
     *
     * Metodo que retorna un String con el nombre de una sucursal
     * segun un codigo
     * @param codigo Parametro recibido para buscar el nombre asociado a este numero
     * @param sucursales ArrayList de sucursales
     * @return Retorna un String con el nombre de la sucursal
     */
    public String getNombreCod(int codigo, ArrayList sucursales) {
        String nombre = null;
        for (int n = 0; n < sucursales.size(); n++) {
            if (((Sucursal) sucursales.get(n)).getCodigo() == codigo) {
                nombre = ((Sucursal) sucursales.get(n)).getNombre();
            }
        }
        return nombre;
    }
    
    /**
     * Metodo que devuelve el codigo segun un nombre de sucursal
     * @param nombre Parametro del nombre de sucursal
     * @param sucursales ArrayList de sucursales
     * @return Retorna segun el String entregado un codigo, si es 0 no existe la sucursal
     */
    public int getCodigoNomn(String nombre, ArrayList sucursales){
        int codigo=0;
        for (int n = 0; n < sucursales.size(); n++) {
            if (((Sucursal) sucursales.get(n)).getNombre().equals(nombre)) {
                codigo=((Sucursal) sucursales.get(n)).getCodigo();
                break;
            }
        }
        return codigo;
    }
    
    /**
     * 
     * Metodo que genera un TableModel segun Nombre de la sucursal y codigo de esta
     * @param sucursales ArrayList sucursales que viene de Sistema
     * @return Retorna un TableModel con 2 columnas y filas segun la informacion del Arraylist
     */
    public DefaultTableModel arrayToTab(ArrayList sucursales){
        String colum[]={"Ciudad","Codigo de Sucursal"};
        DefaultTableModel table=new DefaultTableModel(colum,0); 
        for(int n = 0; n < sucursales.size(); n++){
            Object[]user={((Sucursal) sucursales.get(n)).getNombre(),((Sucursal) sucursales.get(n)).getCodigo()};
            table.addRow(user);
        }
        return table;
    }
    
    /**
     * 
     * Metodo genera un ComboBoxModel segun las sucursales en un arrayList
     * @param sucursales ArrayList de informacion de sucursales
     * @return Retorna un ComboBoxmodel con la informacion de sucursales
     */
    public DefaultComboBoxModel arrayToComboBox(ArrayList sucursales){
        String linea;
        DefaultComboBoxModel table=new DefaultComboBoxModel(); 
        for(int n = 0; n < sucursales.size(); n++){
            linea=((Sucursal)sucursales.get(n)).getNombre();
           table.addElement(linea);
        }
        return table;
    }
    
    /**
     * Metodo que genera un ComboBoxModel con la informacion de las sucursales menos una,
     * que recibe como parametro
     * @param sucursales ArrayList de sucursales
     * @param origen String de nombre de sucursal que se desea ocultar
     * @return Retorna un ComboBox Model
     */
    public DefaultComboBoxModel arrayToComboBoxToDestino(ArrayList sucursales,String origen){
        String linea;
        DefaultComboBoxModel table=new DefaultComboBoxModel(); 
        for(int n = 0; n < sucursales.size(); n++){
            if(origen.equals(((Sucursal)sucursales.get(n)).getNombre())){
                
            }else{
              linea=((Sucursal)sucursales.get(n)).getNombre();
              table.addElement(linea);  
            }
            
        }
        return table;
    }
    
    
    


}
