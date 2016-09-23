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

    public void main(String txtName) {
        try {
            FileReader r = new FileReader(txtName);
            BufferedReader buffer = new BufferedReader(r);
            System.out.println(buffer.readLine());//se tiene que guardar la linea en un array de String
            String cont = "";
            while (cont != null) {
                cont = buffer.readLine();
                if (cont == null) {
                    break;
                }
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        };
    }
}
