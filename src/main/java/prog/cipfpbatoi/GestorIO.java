package prog.cipfpbatoi;

import java.util.Scanner;

public class GestorIO {
    public static Scanner scanner = new Scanner(System.in);
    
    public static int llegirEnter(String missatge){
        System.out.println(missatge);
        while (!scanner.hasNextInt()) {
            System.out.println("Error: introdueix un numero enter.");
            scanner.next(); 
        }
        return scanner.nextInt();
    }
    
    public static String llegirText(String missatge){
        System.out.println(missatge);
        scanner.nextLine();
        return scanner.nextLine();
    }
  
    public static boolean solicitarConfirmacio(String missatge){  
        boolean bucleActivo = true;
        do{
            System.out.println(missatge);
            String respuesta = scanner.next();
            if(respuesta.equalsIgnoreCase("s")||respuesta.equalsIgnoreCase("n")){
                bucleActivo = false;
                return true; 
            }else{
                return false;
            }
        }while(bucleActivo);
    }
    
    public static void tancar(){
        scanner.close();
    }
}
