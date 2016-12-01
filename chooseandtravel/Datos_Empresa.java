package chooseandtravel;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.StringTokenizer;
import javax.swing.DefaultComboBoxModel;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author kuuzou
 */
public class Datos_Empresa {

    File DatosEmpresa = new File("/home/kuuzou/NetBeansProjects/ChooseAndTravel/src/chooseandtravel/sucursales.txt");
    Sucursal objetoS = null;
    Scanner intro = new Scanner(System.in);
    Validador validar = new Validador();

    /**
     *
     * @param sucursales
     * @return
     */
    public ArrayList syncSucursal(ArrayList sucursales) {
        sucursales.clear();
        txt_array(sucursales);
        return sucursales;
    }

    /**
     *
     * @param sucursales
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
     * @param n
     * @param c
     * @param sucursales
     */
    public void agregarSucursalTxt(String n, int c, ArrayList sucursales) {
        try {
            BufferedWriter write = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(DatosEmpresa, true), "utf-8"));
            write.write(n + "|" + c + "\r\n");
            System.out.println("La sucursal ha sido agregada exitosamente");
            write.close();

        } catch (Exception ex) {
            
        }
        syncSucursal(sucursales);
    }

    /**
     *
     * @param sucursales
     * @param codigo
     */
    public void eliminarSuc(ArrayList sucursales,int codigo) {
        try {
            BufferedWriter write = new BufferedWriter(new FileWriter(DatosEmpresa));
            for (int n = 0; n < sucursales.size(); n++) {
                if (((Sucursal) sucursales.get(n)).getCodigo() == (codigo)) {
                } else {
                    write.write(((Sucursal) sucursales.get(n)).getNombre() + "|" + ((Sucursal) sucursales.get(n)).getCodigo() + "\r\n");
                }
            }
            write.close();
            
        } catch (Exception ex) {
        }
        syncSucursal(sucursales);
    }

    /**
     *
     * @param sucursales
     */
    public void guardarS(ArrayList sucursales) {
        System.out.println("Guardando");
        try {
            BufferedWriter write = new BufferedWriter(new FileWriter(DatosEmpresa));
            for (int n = 0; n < sucursales.size(); n++) {
                write.write(((Sucursal) sucursales.get(n)).getNombre() + "|" + ((Sucursal) sucursales.get(n)).getCodigo() + "\r\n");

            }
            write.close();
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
        System.exit(0);
    }

    /**
     *
     * @param codigo
     * @param sucursales
     * @return
     */
    public String getNombreCod(int codigo, ArrayList sucursales) {
        String nombre = null;
        for (int n = 0; n < sucursales.size(); n++) {
            if (((Sucursal) sucursales.get(n)).getCodigo() == codigo) {
                nombre = ((Sucursal) sucursales.get(n)).getNombre();
                break;
            }
        }
        return nombre;
    }
    
    /**
     *
     * @param nombre
     * @param sucursales
     * @return
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
     * @param sucursales
     * @return
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
     * @param sucursales
     * @return
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
     *
     * @param sucursales
     * @param origen
     * @return
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
    
    /**
     *
     * @param sucursales
     * @param cod
     * @return
     */
    public boolean existSuc(ArrayList sucursales,int cod){
        for (int i = 0; i <sucursales.size(); i++) {
            if(((Sucursal) sucursales.get(i)).getCodigo() ==(cod)){
            return true;
            }
        }
        return false;
    }
    


}
