import java.io.*;
import java.awt.image.*;
import javax.imageio.*;
import java.awt.*;

public class Pasaje{
    
    public static void crearPasaje(){
        try{
            BufferedImage img = new BufferedImage( 
                500, 500, BufferedImage.TYPE_INT_ARGB );
                Graphics2D g = (Graphics2D) img.getGraphics();
                
                g.setBackground(Color.WHITE);
                g.clearRect(0, 0, 500, 500);
                
                g.setColor(Color.BLACK);
                g.drawString("Destino:", 10, 20); 
                
            File f = new File("pasaje.png");
            
            ImageIO.write(img, "PNG", f);
        }
        catch(Exception e){
            e.printStackTrace();
        }
    }
}
