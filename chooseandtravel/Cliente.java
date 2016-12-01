package chooseandtravel;

/**
 *
 * @author kuuzou
 */
public class Cliente extends Cuenta {

    private String nombre;
    private int sucursal;

    /**
     *
     * @param u
     * @param p
     * @param n
     * @param s
     */
    public Cliente(String u, String p, String n, int s) {
        super(u, p);
        this.nombre = n;
        this.sucursal = s;
    }

    /**
     *
     * @return
     */
    public String getNombre() {
        return this.nombre;
    }

    /**
     *
     * @return
     */
    public int getSucursal() {
        return this.sucursal;
    }

    /**
     *
     * @param n
     */
    public void setNombre(String n) {
        nombre = n;
    }

    /**
     *
     * @param s
     */
    public void setSucursal(int s) {
        sucursal = s;
    }
    
    /**
     *
     */
    public static void menuGeneral(){
        System.out.println("---------Menu--------");
        System.out.println("1. Menu de Viajes");
        System.out.println("2. Configuracion de cuenta");
        System.out.println("3. Guardar y  salir");
    }

    /**
     *
     */
    public static void menuUs2() {
        System.out.println("---------Menu de configuracion--------");
        System.out.println("1. Modificar password");
        System.out.println("2. Guardar y  salir");
    }
    
    /**
     *
     */
    public static void menuUs1(){
        System.out.println("---------Menu de Viajes--------");
        System.out.println("1. Solicitar Viaje");
        System.out.println("2. Cancelar Viaje");
        System.out.println("3. Mostra Viajes Aprobados");
        System.out.println("4. Mostrar Viajes Pendientes");
        System.out.println("5. Historial");
        System.out.println("6. Guardar y  salir");
    }

}
