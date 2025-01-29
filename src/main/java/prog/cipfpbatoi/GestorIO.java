package prog.cipfpbatoi;

import java.util.Scanner;

public class GestorIO {
    public static Scanner scanner = new Scanner(System.in);
    
    public static int llegirEnter(String missatge){
        System.out.println(missatge);
        //int respuesta = ;;
        return -1;
    }
    
    public static String llegirText(String missatge){
        System.out.println(missatge);
        String respuesta = scanner.nextLine();
        return respuesta;
    }
  
    public static boolean solicitarConfirmacio(String missatge){
        return true;
    }
    
    public static void tancar(){
        scanner.close();
    }
}
