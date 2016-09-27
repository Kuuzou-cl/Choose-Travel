import java.io.*;
import java.util.*;
public class Cuenta
{ 
     private      String user;
     private      String pass;
     private      String info;
     private      boolean    admin;   
     File         DatosCuenta= new File("cuentas.txt");
     ArrayList<Cuenta> cuentas =new ArrayList<Cuenta>();
     Cuenta       objeto = null;
     Scanner      intro = new Scanner(System.in);
     datos dat =  new datos();
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
    

   public void agregarCuenta(String user, String pass, String info)//El metodo recibe 3 String que son usuario,contraseña,informa 
      {
      try//Al trabajar con archivos txt debemos obligatoriamente usar el try catch 
      {  
         setUser(user);//Se le manda al metodo setUser el valor del String user que llegó para que lo modifique. de la misma forma lo hacemos con los siguientes 3 metodos
         setPass(pass);
         setInfo(info);
         setAdmin(false);
 
         BufferedWriter write=new BufferedWriter(new OutputStreamWriter(new FileOutputStream(DatosCuenta,true), "utf-8"));/*Se instancian un conjuntos de objetos para poder
         abrir/modificar el archivo txt 
             */
         write.write(getUser()+"|"+getPass()+"|"+getInfo()+"|"+getAdmin()+"\r\n");/*Ocupamos el objeto write de la clase bufferedWriter para escribir en el txt los atributos
         que recibe el metodo*/
         System.out.println("La cuenta ha sido agregada exitosamente");//le indicamos al usuario que la cuenta fue agregada          
         write.close();//Cerramos el objeto buffered con el que escribimos
          
        }
        catch (Exception ex)//Le indicamos las excepciones para atrapar
       {  
          //Captura un posible error le imprime en pantalla   
          System.out.println(ex.getMessage());  
       }
       //El metodo no retorna ningun dato, ya que el metodo consiste en modificar el archivo txt
      } 
      
   public void txt_array()//Este metodo no recibe ningun tipo de dato de entrada
     {
        try//Al trabajar con archivos txt debemos obligatoriamente usar el try catch
        {
         cuentas.clear();//Eliminamos los posibles datos que tenga el arrayList para ingresar los datos actualizados   
         String linea = null;//Declaramos un String en nulo para que podamos compararlo con las lineas del archivo txt
         BufferedReader read = new BufferedReader (new FileReader(DatosCuenta));//Instanciamos el objeto read de la clase bufferedReader para leer las lineas del archivo txt    
         while( (linea = read.readLine()) != null)/*Este while el String linea se le asigna la informacion que tenga una linea del archivo txt. En la condicion vemos si el string
         posee informacion, esto nos sirve para poder recorrer todas las lineas del archivo */
         {
            StringTokenizer split = new StringTokenizer(linea, "|");/*Instanciamos el objeto split de la clase StringTokenizer que nos servira para poder dividir nuestro String
            en subString, el separador que utilizaremos sera el caracter "|"*/
            String  userStr =  split.nextToken().trim();//Le asignamos las subsCadenas a diferentes String con su respectivo significado.lo mismo en los siguientes 3 lineas
            String  passStr =  split.nextToken().trim();
            String  infoStr =  split.nextToken();
            String  adminStr =  split.nextToken().trim();
            
            boolean    admin=Boolean.parseBoolean(adminStr);//Ya que el atributo admin es del tipo boolean convertimos el String a un dato boolean
            
            objeto= new Cuenta(userStr,passStr,infoStr,admin);/*Instanciamos un objeto de tipo cuenta y le mandamos como parametros los Strings que asignamos anteriormente en
            el metodo*/
            cuentas.add(objeto);//Añadimos al arrayList el objeto
            
            }
         read.close();//Cerramos el objeto read de tipo bufferedReader
       
       }catch (Exception ex) //Le indicamos las excepciones para atrapar
       {   
          System.out.println(ex.getMessage());  
       }
       //Este metodo no retorna ningun valor. ya que podemos modificar el arrayList instanciado globalmente
      }     
      
   public void syncArrayList()//El metodo no recibe ningun tipo de dato de entrada
   {
      cuentas.clear();//Eliminamos los posibles datos que pueda tener el arrayList con el metodo clear
      txt_array();//Llamamos el metodo txt_array para actualizar el array con la informacion del archivo txt
      //Este metodo no tiene ningun tipo de dato de salida
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
   
   public void modificar_txt()//Este metodo no recibe ningun tipo de dato de entrada dado que lo ocupamos para modificar el archivo txt
  {
      
    try{//Al trabajar con archivos txt debemos obligatoriamente usar el try catch por algun posible error  
       txt_array();//Llamamos al metodo txt_array para actualizar el arrayList           
        int op=10;//Instanciamos una variable de tipo entero que ocuparemos en el siguiente while        
        while(op!=5)
             {
               menuAdmin();//Llamamos el metodo menuAdmin para mostrar por pantalla las opciones al usuario
               op=intro.nextInt();//Le asignamos a la variable op lo que el usuario a ingresado
               switch(op)//Con el switch separamos por casos en relacion a la variable op
               {
                   case 1:
                        String us0="";//Instanciamos un String en vacio
                        do{//El ciclo do-while lo ocuparemos para que el usuario ingrese correctamente lo que se pide
                            System.out.println("Ingrese un nuevo usuario");
                            us0=intro.nextLine();//Le asiganos al String anterior lo ingresado por el usuario
                            us0=intro.nextLine();
                        }while(dat.valUs(us0)==false);//Al metodo valUs de la clase datos le mandamos el String para ver si esta bien el formato en que el usuario escribio
                        System.out.println("Ingrese la contraseña");
                        String pas0=intro.nextLine();//Le asignamos al String pas0 lo ingresado por el usuario
                        System.out.println("Ingrese la informacion del usuario");
                        String inf0=intro.nextLine();//Le asignamos al String inf0 lo ingresado por el usuario
                        agregarCuenta(us0,pas0,inf0);//Llamamos al metodo agregarCuenta y le mandamos como parametros los String anteriores en el case1
                        syncArrayList();//Llamamos al metodo syncArrayList para sincronizar el arrayList con la informacion del archivo txt
                   break;
                   case 2: 
                        String    us="";//Instanciamos un String en vacio
                        do{//El ciclo do-while lo ocuparemos para que el usuario ingrese correctamente lo que se pide
                            System.out.println("Introducir el usuario a modificar:");      
                            us=intro.nextLine();//Le asignamos al String us lo que el usuario ingrese por teclado
                        }while(dat.valUs(us)==false);//Al metodo valUs de la clase datos le mandamos el String us para ver si esta bien el formato en que el usuario escribio
                        boolean existCuen1 =false;//Instanciamos un boolean que utilizaremos como auxiliar para mostrar un mensaje por pantalla sobre el estado de la cuenta
                        for(Cuenta n:cuentas)
                        {
                       
                            if(n.getUser().equals(us)){/*Comparamos los el String us con los metodos getUser de la cantidad de objetos que tenga el arrayList para confirmar que 
                              el usuario existe*/
                                existCuen1=true;//Ya que la cuenta existe cambiamos el estado del boolean a true
                               System.out.println("Introducir nueva contraseña:");
                               String    newPass=intro.nextLine();//Instanciamos y asignamos al String newPass lo que el usuario ingrese por teclado
                                n.setPass(newPass);//Llamamos al metodo setPass del objeto en la posicion n, y le mandamos como parametro el String newPass para modificar la contraseña     
                                System.out.println("=========================== Cuenta =========================================================================================================================================================================================");
                                System.out.println("El usuario es:"+n.getUser()+"\t"+"y la nueva contraseña es:"+n.getPass());//Le mostramos por pantalla al usuario el cambio
                                System.out.println("============================FIN==============================================================================================================================================================================================");
                                break;
                            }  
                           }
                           if(existCuen1==false){/*En este if ocupamos el boolean que instanciamos con antelacion en el metodo y en caso de que sea falso, mostramos por pantalla 
                            que el usuario no existe */
                            System.out.println("El usuario no se ha encontrado");
                            }
                        break;
                    case 3: 
                        String    us2="";//Instanciamos un String en vacio
                        do{//El ciclo do-while lo ocuparemos para que el usuario ingrese correctamente lo que se pide
                            System.out.println("Introducir el usuario a modificar:");      
                            us2=intro.nextLine();//Le asignamos al String us2 lo que el usuario ingrese por teclado
                        }while(dat.valUs(us2)==false);//Al metodo valUs de la clase datos le mandamos el String us2 para ver si esta bien el formato en que el usuario escribio
                         boolean existCuen2 =false;//Instanciamos un boolean que utilizaremos como auxiliar para mostrar un mensaje por pantalla sobre el estado de la cuenta
                         for(Cuenta n:cuentas)
                        {
                       
                            if(n.getUser().equals(us2)){/*Comparamos los el String us2 con los metodos getUser de la cantidad de objetos que tenga el arrayList para confirmar que 
                              el usuario existe*/
                                existCuen2=true;//Ya que la cuenta existe cambiamos el estado del boolean a true
                               System.out.println("Introducir nueva informacion:");      
                               String newInfo=intro.next();//Instanciamos y asignamos al String newInfo lo que el usuario ingrese por teclado
                                n.setInfo(newInfo);//Llamamos al metodo setInfo del objeto en la posicion n, y le mandamos como parametro el String newInfo para modificar la informacion   
                                System.out.println("=========================== Cuenta =========================================================================================================================================================================================");
                                System.out.println("El usuario es:"+n.getUser()+"\t"+"La nueva informacion es:"+n.getInfo());//Le mostramos por pantalla al usuario el cambio
                                System.out.println("============================FIN==============================================================================================================================================================================================");
                                break;
                            }  
                        }
                        if(existCuen2==false){/*En este if ocupamos el boolean que instanciamos con antelacion en el metodo y en caso de que sea falso, mostramos por pantalla 
                         que el usuario no existe */
                            System.out.println("El usuario no se ha encontrado");
                            }
                        break;
                    case 4: 
                        String us3="";//Instanciamos un String como vacio
                        do{//El ciclo do-while lo ocuparemos para que el usuario ingrese correctamente lo que se pide
                            System.out.println("Inserte el usuario de la cuenta ha borrar");
                            us3=intro.nextLine();//Le asignamos al String us3 lo que el usuario ingrese por teclado
                            us3=intro.nextLine();
                        }while(dat.valUs(us3)==false);//Al metodo valUs de la clase datos le mandamos el String us3 para ver si esta bien el formato en que el usuario escribio   
                        try{//Al trabajar con archivos txt debemos obligatoriamente usar el try catch por algun posible error
                            BufferedWriter write = new BufferedWriter(new FileWriter(DatosCuenta));/*Instanciamos el objeto read de la clase bufferedReader para leer las 
                            lineas del archivo txt*/
                            for(Cuenta n:cuentas)
                            {  
                                if(n.getUser().equals(us3)){/*Comparamos los el String us3 con los metodos getUser de la cantidad de objetos que tenga el arrayList para confirmar que 
                                 el usuario existe*/
                                    System.out.println("La cuenta ha sido eliminada");
                                }else{
                                     write.write(n.getUser()+ "|"+n.getPass()+ "|"+ n.getInfo()+ "|"+ n.getAdmin()+"\r\n");/*Ocupamos el objeto write de la clase bufferedWriter para 
                                 escribir en el txt los atributos que recibe de los metodos getter del objeto tipo cuenta*/
                                }
                            }
                            write.close();//Cerramos el objeto write
                            cuentas.clear();//Eliminamos los datos que pueda tener el arrayList con el metodo clear
                            txt_array();//Llamamos al metodo txt_array para actualizar el arrayList
                        }catch (Exception ex)//Le indicamos las excepciones para atrapar  
                        {  
                            //Captura un posible error le imprime en pantalla   
                            System.out.println(ex.getMessage());  
                        }
                        break;  
                    case 5: 
                       guardar();
                    }
                } 
        }catch (Exception ex)//Le indicamos las excepciones para atrapar 
       {  
          //Captura un posible error le imprime en pantalla   
          System.out.println(ex.getMessage());  
       }
       //El metodo no retorna ningun dato, ya que el metodo consiste en modificar el archivo txt y el arrayList instanciado
     }  
  
  private void menuAdmin()//Este metodo no recibe ningun tipo de dato de entrada ya que es un menu
   {
     System.out.println("--------Menu de configuracion-------");
     System.out.println("1. Agregar cuenta");
     System.out.println("2. Modificar password");
     System.out.println("3. Modificar informacion de usuario ");
     System.out.println("4. Eliminar Cuenta");
     System.out.println("5. Guardar y Salir");
   }
  private void menuUs(){//Este metodo no recibe ningun tipo de dato de entrada ya que es un menu
    System.out.println("---------Menu de configuracion--------");
    System.out.println("1. Modificar password");
    System.out.println("2. Guardar y  salir");
    }
  public void modificar_txtUs(){//Este metodo no recibe ningun tipo de dato de entrada dado que lo ocupamos para modificar el archivo txt
    txt_array();//Llamamos al metodo txt_array para actualizar la informacion del arrayList
    int op=10;//Instanciamos una variable de tipo entero que ocuparemos en el siguiente while
        while(op!=2){
                  menuUs();//Llamamos al metodo menuUs para mostrarle por pantalla las opciones que puede elegir
                   op=intro.nextInt();//Le asignamos el valor de la opcion que ingresa el usuario por teclado a la variable op
             switch(op){      
                  case 1:
                  String    us="";//Instanciamos un String
                    do{//El ciclo do-while lo ocuparemos para que el usuario ingrese correctamente lo que se pide
                        System.out.println("Introducir el usuario a modificar:");     
                        us=intro.nextLine();//Le asignamos al String us lo que el usuario ingrese 
                    }while(dat.valUs(us)==false);//Al metodo valUs de la clase datos le mandamos el String para ver si esta bien el formato en que el usuario escribio
                   boolean existCuen3 =false;//Instanciamos un boolean que utilizaremos como auxiliar para mostrar un mensaje por pantalla sobre el estado de la cuenta      
                    for(Cuenta n:cuentas)
                    {
                       
                      if(n.getUser().equals(us)){/*Comparamos los el String us con los metodos getUser de la cantidad de objetos que tenga el arrayList para confirmar que 
                          el usuario existe*/
                        existCuen3=true;//Ya que la cuenta existe cambiamos el estado del boolean a true
                        System.out.println("Introducir nueva contraseña:");
                        String    newPass=intro.nextLine();//Instanciamos y asignamos al String newPass lo que el usuario ingrese por teclado  
                        n.setPass(newPass);//Llamamos al metodo setPass del objeto en la posicion n, y le mandamos como parametro el String newPass para modificar la contraseña     
                        System.out.println("=========================== Cuenta =========================================================================================================================================================================================");
                        System.out.println("El usuario es:"+n.getUser()+"\t"+" La nueva contraseña es:"+n.getPass());//Le mostramos por pantalla al usuario el cambio
                        System.out.println("============================FIN==============================================================================================================================================================================================");
                        break;
                                         }  
                    }
                     if(existCuen3==false){/*En este if ocupamos el boolean que instanciamos con antelacion en el metodo y en caso de que sea falso, mostramos por pantalla 
                         que el usuario no existe */
                            System.out.println("El usuario no se ha encontrado");
                            }
                    break;
                    case 2:guardar();//Llamamos al metodo guardar para que hacer las modificaciones en el archivo txt
                }
            }
     //El metodo no retorna ningun dato, ya que el metodo consiste en modificar el archivo txt y el arrayList instanciado       
    }
  private void guardar(){//El metodo no tiene ningun parametro de entrada
    System.out.println("Guardando");
      try{//Al trabajar con archivos txt debemos obligatoriamente usar el try catch por algun posible error
         BufferedWriter write = new BufferedWriter(new FileWriter(DatosCuenta));//Instanciamos el objeto read de la clase bufferedReader para leer las lineas del archivo txt
          for(Cuenta n:cuentas)
           {
             write.write(n.getUser()+ "|"+n.getPass()+ "|"+ n.getInfo()+ "|"+ n.getAdmin()+"\r\n");/*Ocupamos el objeto write de la clase bufferedWriter para 
            escribir en el txt los atributos que recibe de los metodos getter del objeto tipo cuenta*/ 
           }
         write.close();//Cerramos el objeto write
        }catch (Exception ex)//Le indicamos las excepciones para atrapar 
        {  
         //Captura un posible error le imprime en pantalla   
        System.out.println(ex.getMessage());  
         }
       System.exit(0);
       //El metodo no retorna ningun dato, ya que el metodo consiste en modificar el archivo txt 
    }
  public  void inicio() 
   {       
       syncArrayList();
       login();
    }
  public void login(){//El metodo no tiene ningun parametro de entrada
     String use="";//Instanciamos un String en vacio
    do{//El ciclo do-while lo ocuparemos para que el usuario ingrese correctamente lo que se pide
     System.out.println("Ingrese usuario");
     use=intro.nextLine();//Le asignamos lo que ingreso el usuario al String use
    }while(dat.valUs(use)==false);//Al metodo valUs de la clase datos le mandamos como parametro el String us para validar que este bien escrito el formato
     for(Cuenta n:cuentas){
       if(n.getUser().equals(use)){//Comparamos los el String use con los metodos getUser de la cantidad de objetos que tenga el arrayList para confirmar que el usuario existe
        System.out.println("Ingrese contraseña");
        String pas=intro.nextLine();//Instanciamos y asignamos al String pas lo que el usuario ingrese
        if(n.getPass().equals(pas)){//Similar al if anterior comparamos el String pas con los datos que devuelve los metodos getPass para verificar que este correcto
         if(n.getAdmin()==true){//Aquí la condicion consiste en ver si la cuenta es del admin o de un usuario
            modificar_txt();//En caso de que sea true llama el metodo modificar_txt, que corresponde al menu y ociones de configuracion del administrador
            }else{
            modificar_txtUs();//En caso de ser false se llama al metodo modificar_txtUs, que corresponde al menu y opciones de configuracion del usuario
            }
        }
      }  
    }
  }
} 