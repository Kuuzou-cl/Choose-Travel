
package chooseandtravel;

import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Date;

public  class Calendario {

    Date date = new Date();
    LocalDate localDate = date.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
    
    public int getDia(){
        int dia   = localDate.getDayOfMonth();
        return dia;
    }
    
    public int getMes(){
        int mes = localDate.getMonthValue();
        return mes;
    }
    
    public int getAño(){
        int año  = localDate.getYear();
        return año;
    }
}
