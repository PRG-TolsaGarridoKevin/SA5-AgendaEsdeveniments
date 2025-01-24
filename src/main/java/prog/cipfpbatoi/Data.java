package prog.cipfpbatoi;

import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.StringTokenizer;

public class Data {

    private int dia;
    private int mes;
    private int any;

    public Data() {
        Calendar fechaDelSistema = new GregorianCalendar();
        this.dia = fechaDelSistema.get(Calendar.DAY_OF_MONTH);
        this.mes = fechaDelSistema.get(Calendar.MONTH) + 1;
        this.any = fechaDelSistema.get(Calendar.YEAR);
    }

    public Data(int dia, int mes, int any) {
        this.dia = dia;
        this.mes = mes;
        this.any = any;
    }

    public Data(String fecha) {
        StringTokenizer st = new StringTokenizer(fecha, "/");
        int tokenDia = Integer.parseInt(st.nextToken());
        int tokenMes = Integer.parseInt(st.nextToken());
        int tokenAny = Integer.parseInt(st.nextToken());

        this.dia = tokenDia;
        this.mes = tokenMes;
        this.any = tokenAny;
    }

    public void set(int dia, int mes, int any) {
        this.dia = dia;
        this.mes = mes;
        this.any = any;
    }

    public Data copy() {
        Data fecha = new Data(this.dia, this.mes, this.any);
        return fecha;
    }

    public int getDia() {
        return this.dia;
    }

    public int getMes() {
        return this.mes;
    }

    public int getAny() {
        return this.any;
    }

    public void mostrarEnFormatES() {
        System.out.printf("%02d/%02d/%04d",getDia(),getMes(),getAny());
    }

    public void mostrarEnFormatGB() {
       System.out.printf("%04d-%02d-%02d",getAny(),getMes(),getDia());
    }
                                            
    public void mostrarEnFormatText() {
        System.out.printf("%02d-%s-%04d",getDia(),getMesEnFormatText(),getAny());
    }

    public boolean isIgual(Data fecha) {
        return fecha.dia == this.dia
               && fecha.mes == this.mes
               && fecha.any == this.any;
    }

    private String getMesEnFormatText(){
        int mesInt = getMes();
        switch (mesInt){
            case 1: return "gener"; 
            case 2: return "febrer"; 
            case 3: return "març"; 
            case 4: return "abril"; 
            case 5: return "maig"; 
            case 6: return "juny"; 
            case 7: return "juliol"; 
            case 8: return "agost"; 
            case 9: return "setembre"; 
            case 10: return "octubre"; 
            case 11: return "novembre"; 
            case 12: return "desembre"; 
            default: return "Error, mes no encontrado";
        }
    }
    
    private int getDiesTranscorregutsEnAny(){
        
        
        return -1;
    }
    
    private int getDiesTranscorregutsOrigen(){
        int diaOrigen = 1;
        int mesOrigen = 1;
        int anyOrigen = 1;  //Hacer primero el isBisiesto
   
        return -1;
    }
    
    public String getDiaSetmana() {
        //------------------
        //Pagina 6 metodos privados necesarios
        //-------------------
        return null;
    }

    public boolean isFestiu() {
        return false;
    }

    public int getNumeroSetmana() {
        return -1;

    }

    public Data afegir(long numDias) {

        return null;
    }

    public Data restar(long numDias) {
        return null;
    }

    public boolean isCorrecta() {
        return false;
    }

    public long getDiesDeDiferencia(Data data) {
        return -1L;
    }

    public boolean esPosteriorA(Data data) {
        return false;
    }

    public static boolean isBisiesto(int any) {
        return any % 4 == 0 && any % 100 != 0 ||
               any % 4 == 0 && any % 100 == 0 && any % 400 == 0;
    }

    public static int getDiesMes(int mes, int any) {
        return switch (mes) {
            case 1, 3, 5, 7, 8, 10, 12 -> 31;
            case 4, 6, 9, 11 -> 30;
            case 2 -> isBisiesto(any) ? 29 : 28;
            default -> 30;
        };
    }

    public static int getDiesAny(int any) {
        return isBisiesto(any) ? 366 : 365;
    }
}
