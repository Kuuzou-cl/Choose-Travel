import java.io.*;
import java.util.*;
public class Cuenta
{ 
     private      String    user;
     private      String pass;
     private      String info;
     private      boolean    admin;   
     File   DatosCuenta= new File("cuentas.txt");
     ArrayList<Cuenta> cuentas =new ArrayList<Cuenta>();
     Cuenta             objeto = null;
    
   public Cuenta(String user, String pass, String info, boolean admin)
    {
         this.user=user;
         this.pass=pass;
         this.info=info; 
         this.admin=admin; 
    }     
    
   public Cuenta(){} 
   
   public  String getUser()
   {
      return this.user;
       
    }
   public  String getPass()
   {
      return this.pass;
       
    }
   public  String getInfo()
   {
      return this.info;
       
    }
   public  boolean getAdmin()
   {
      return this.admin;
       
    }
    
    public  void setUser(String u)
   {
       user=u;
       
    }
   public  void setPass(String p)
   {
       pass=p;
       
    }
   public  void setInfo(String i)
   {
       info=i;
       
    }
   public  void setAdmin(boolean a)
   {
       admin=a;
       
    }
    

   public void agregarCuenta(String user, String pass, String info)
      {
         try
      {  
         setUser(user);
         setPass(pass);
         setInfo(info);
         setAdmin(false);
 
          BufferedWriter write=new BufferedWriter(new OutputStreamWriter(new FileOutputStream(DatosCuenta,true), "utf-8"));  
 
          write.write(getUser()+"|"+getPass()+"|"+getInfo()+"|"+getAdmin()+"\r\n");  
           System.out.println("La cuenta ha sido agregada exitosamente");          
          write.close();
          
        }
        catch (Exception ex) 
       {  
          //Captura un posible error le imprime en pantalla   
          System.out.println(ex.getMessage());  
       }
      } 
      
   public void txt_array()
     {
        try
        {
         String linea = null;
         BufferedReader read = new BufferedReader (new FileReader(DatosCuenta));    
         while( (linea = read.readLine()) != null)
         {
            StringTokenizer split = new StringTokenizer(linea, "|");
            String           userStr =  split.nextToken().trim();
            String  passStr =  split.nextToken().trim();
            String       infoStr =  split.nextToken();
            String     adminStr =  split.nextToken().trim();
            
            boolean    admin=Boolean.parseBoolean(adminStr);
            
            objeto= new Cuenta(userStr,passStr,infoStr,admin);
            cuentas.add(objeto);
            
            }
         read.close();
       
       }catch (Exception ex) 
       {   
          System.out.println(ex.getMessage());  
       }
      }     
      
   public void syncArrayList()
   {
      cuentas.clear();
      txt_array(); 
   }
   
      public void mostrarObjetos()
      {
     if( cuentas.size()==0){txt_array();}
     System.out.println("=========================== Cuentas =========================================================================================================================================================================================");     
     for(Cuenta n:cuentas)
     {
      System.out.println("El user es:"+n.getUser()+"\t"+"La password es:"+n.getPass()+"\t"+"Info de usuario:"+n.getInfo()+"\t"+ "Permisos:"+ n.getAdmin());
     }  
     System.out.println("============================FIN==============================================================================================================================================================================================");
   }
   
   public void modificar_txt()
  {
    try{  
       txt_array();
        Scanner intro =new Scanner(System.in).useDelimiter("\n");            
        int op=10;        
        while(op!=5)
             {
               menuAdmin();
               op=intro.nextInt();
               switch(op)
               {
                   case 1:
                        System.out.println("Ingrese un nuevo usuario");
                        String us0=intro.nextLine();
                        us0=intro.nextLine();
                        System.out.println("Ingrese la contraseña");
                        String pas0=intro.nextLine();
                        System.out.println("Ingrese la informacion del usuario");
                        String inf0=intro.nextLine();
                        agregarCuenta(us0,pas0,inf0);
                        cuentas.clear();
                        txt_array();
                   break;
                   case 2: 
                        System.out.println("Introducir el usuario a modificar:");      
                        String    us=intro.nextLine();
                        boolean existCuen1 =false;
                        for(Cuenta n:cuentas)
                        {
                       
                            if(n.getUser().equals(us)){
                                existCuen1=true;
                               System.out.println("Introducir nueva contraseña:");
                               String    newPass=intro.nextLine();
                                n.setPass(newPass);     
                                System.out.println("=========================== Cuenta =========================================================================================================================================================================================");
                                System.out.println("El usuario es:"+n.getUser()+"\t"+"y la nueva contraseña es:"+n.getPass());
                                System.out.println("============================FIN==============================================================================================================================================================================================");
                                break;
                            }  
                           }
                           if(existCuen1==false){
                            System.out.println("El usuario no se ha encontrado");
                            }
                        break;
                    case 3: 
                        System.out.println("Introducir el usuario a modificar:");      
                        String    us2=intro.nextLine();
                         boolean existCuen2 =false;
                         for(Cuenta n:cuentas)
                        {
                       
                            if(n.getUser().equals(us2)){
                                existCuen2=true;
                               System.out.println("Introducir nueva informacion:");      
                               String newInfo=intro.next();
                                n.setInfo(newInfo);    
                                System.out.println("=========================== Cuenta =========================================================================================================================================================================================");
                                System.out.println("El usuario es:"+n.getUser()+"\t"+"La nueva informacion es:"+n.getInfo());
                                System.out.println("============================FIN==============================================================================================================================================================================================");
                                break;
                            }  
                        }
                        if(existCuen2==false){
                            System.out.println("El usuario no se ha encontrado");
                            }
                        break;
                    case 4: 
                        System.out.println("Inserte el usuario de la cuenta ha borrar");
                        String us3=intro.nextLine();   
                        try{
                            BufferedWriter write = new BufferedWriter(new FileWriter(DatosCuenta));
                            for(Cuenta n:cuentas)
                            {  
                                if(n.getUser()!=us3){
                                    write.write(n.getUser()+ "\t"+n.getPass()+ "\t"+ n.getInfo()+ "\t"+ n.getAdmin()+"\r\n");
                                }else{
                                    System.out.println("La cuenta ha sido eliminado");
                                }
                            }
                            write.close();
                            cuentas.clear();
                            txt_array();
                      
                        }catch (Exception ex) 
                        {  
                            //Captura un posible error le imprime en pantalla   
                            System.out.println(ex.getMessage());  
                        }
                        break;  
                    case 5: 
                        System.out.println("Guardando");
                        try{
                            BufferedWriter write = new BufferedWriter(new FileWriter(DatosCuenta));
                            for(Cuenta n:cuentas)
                            {
                                write.write(n.getUser()+ "|"+n.getPass()+ "|"+ n.getInfo()+ "|"+ n.getAdmin()+"\r\n");  
                            }
                            write.close();
                        }catch (Exception ex) 
                        {  
                            //Captura un posible error le imprime en pantalla   
                            System.out.println(ex.getMessage());  
                        }
                        System.exit(0);
                    }
                } 
        }catch (Exception ex) 
       {  
          //Captura un posible error le imprime en pantalla   
          System.out.println(ex.getMessage());  
       }     
     }  
  
  private void menuAdmin()
   {
     System.out.println("--------Menu de configuracion-------");
     System.out.println("1. Agregar cuenta");
     System.out.println("2. Modificar password");
     System.out.println("3. Modificar informacion de usuario ");
     System.out.println("4. Eliminar Cuenta");
     System.out.println("5. Guardar y Salir");
   }
  private void menuUs(){
    System.out.println("---------Menu de configuracion--------");
    System.out.println("1. Modificar password");
    System.out.println("2. Guardar y  salir");
    }
  public void modificar_txtUs(){
    txt_array();
    Scanner intro = new Scanner(System.in);
    int op=10;
        while(op!=2){
                  menuUs();
                   op=intro.nextInt();
             switch(op){      
                  case 1:
                    System.out.println("Introducir el usuario a modificar:");      
                   String    us=intro.nextLine();
                   us=intro.nextLine();
                   boolean existCuen3 =false;        
                    for(Cuenta n:cuentas)
                    {
                       
                      if(n.getUser().equals(us)){
                        existCuen3=true;
                        System.out.println("Introducir nueva contraseña:");
                        String    newPass=intro.nextLine();  
                        n.setPass(newPass);     
                        System.out.println("=========================== Cuenta =========================================================================================================================================================================================");
                        System.out.println("El usuario es:"+n.getUser()+"\t"+" La nueva contraseña es:"+n.getPass());
                        System.out.println("============================FIN==============================================================================================================================================================================================");
                        break;
                                         }  
                    }
                     if(existCuen3==false){
                            System.out.println("El usuario no se ha encontrado");
                            }
                    break;
                    case 2:
                    System.out.println("Guardando");
                    try{
                      BufferedWriter write = new BufferedWriter(new FileWriter(DatosCuenta));
                      for(Cuenta n:cuentas)
                      {
                          write.write(n.getUser()+ "|"+n.getPass()+ "|"+ n.getInfo()+ "|"+ n.getAdmin()+"\r\n");  
                      }
                      write.close();
                     }catch (Exception ex) 
                    {  
                      //Captura un posible error le imprime en pantalla   
                      System.out.println(ex.getMessage());  
                    }
                    System.exit(0);
                }
            }
    }
    
  public  void inicio() 
   {       
       syncArrayList();
       System.out.println(cuentas.get(0).getUser());
       modificar_txt();
    }
}