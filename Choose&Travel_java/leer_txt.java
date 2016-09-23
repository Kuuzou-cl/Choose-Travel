/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fundamentos;

import java.io.*;

/**
 *
 * @author juan
 */
public class leer_txt {

    public void leer(String txtName) {
        try {
            FileReader r = new FileReader(txtName);
            BufferedReader buffer = new BufferedReader(r);
            String cont = "";
            while (cont != null) {//un ciclo para leer todas las lineas
                cont = buffer.readLine();//se guarda la info de la linea en un String (en futuro un array de String)
                if (cont == null) {//valida que exista informacion en la linea
                    break;
                }
            }
        } catch (Exception e) {//En caso de que el archivo no exista 
            System.out.println(e.getMessage());
        };
    }
}
