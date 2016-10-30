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

public class Datos_Empresa {

    File DatosEmpresa = new File("C:\\Users\\krlo9\\Documents\\NetBeansProjects\\ChooseAndTravel\\src\\chooseandtravel\\sucursales.txt");
    Sucursal objetoS = null;
    Scanner intro = new Scanner(System.in);
    Validador validar = new Validador();

    public ArrayList syncSucursal(ArrayList sucursales) {
        sucursales.clear();
        txt_array(sucursales);
        return sucursales;
    }

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

    public void agregarSuc(ArrayList sucursales) {
        String suc0 = "";
        do {
            System.out.println("Ingrese una nueva Sucursal");
            suc0 = intro.nextLine();
            suc0 = intro.nextLine();
        } while (validar.valSuc(suc0) == false);
        System.out.println("Ingrese el codigo");
        int cod0 = validar.leerInt();
        agregarSucursalTxt(suc0, cod0);
        syncSucursal(sucursales);
    }

    public void agregarSucursalTxt(String n, int c) {
        try {
            BufferedWriter write = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(DatosEmpresa, true), "utf-8"));
            write.write(n + "|" + c + "\r\n");
            System.out.println("La sucursal ha sido agregada exitosamente");
            write.close();

        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
    }

    public void eliminarSuc(ArrayList sucursales) {
        System.out.println("Ingrese codigo de Sucursal a borrar");
        int suc3 = validar.leerInt();
        try {
            BufferedWriter write = new BufferedWriter(new FileWriter(DatosEmpresa));
            for (int n = 0; n < sucursales.size(); n++) {
                if (((Sucursal) sucursales.get(n)).getCodigo()==(suc3)) {
                    System.out.println("La cuenta ha sido eliminada");
                } else {
                    write.write(((Sucursal) sucursales.get(n)).getNombre() + "|" + ((Sucursal) sucursales.get(n)).getCodigo() +"\r\n");
                }
            }
            write.close();
            syncSucursal(sucursales);
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
    }
    
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

}
