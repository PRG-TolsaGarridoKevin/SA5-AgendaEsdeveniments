package prog.cipfpbatoi;

import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.StringTokenizer;

public class Data {
    
    private String DILLUNS = "Dilluns";
    private String DIMARTS = "Dimarts";
    private String DIMECRES = "Dimecres";
    private String DIJOUS = "Dijous";
    private String DIVENDRES = "Divendres";
    private String DISSABTE = "Dissabte";
    private String DIUMENGE = "Diumenge";

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
        int diasTranscurridos = 0;
        for (int i = 1; i < this.mes; i++) {
            diasTranscurridos += getDiesMes(i, this.any);
        }
        diasTranscurridos += this.dia;
        
        return diasTranscurridos;
    }
    
    private int getDiesTranscorregutsOrigen(){
        int diasTranscurridos = 0;
        for (int any = 1; any < this.any; any++) {
            diasTranscurridos += getDiesAny(any);
        }
        diasTranscurridos += getDiesTranscorregutsEnAny();
        
        return diasTranscurridos;
    }
    
    public String getDiaSetmana() {
        Calendar fecha = new GregorianCalendar(this.any, this.mes - 1, this.dia);
    int diaSemana = fecha.get(Calendar.DAY_OF_WEEK);

    switch (diaSemana) {
        case Calendar.MONDAY: return DILLUNS;
        case Calendar.TUESDAY: return DIMARTS;
        case Calendar.WEDNESDAY: return DIMECRES;
        case Calendar.THURSDAY: return DIJOUS;
        case Calendar.FRIDAY: return DIVENDRES;
        case Calendar.SATURDAY: return DISSABTE;
        case Calendar.SUNDAY: return DIUMENGE;
        default: return "Dia no encontrado";
        }
    }

    public boolean isFestiu() {
        if (getDiaSetmana().equalsIgnoreCase(DISSABTE) ||
            getDiaSetmana().equalsIgnoreCase(DIUMENGE)) {
            return true;
        }else{
            return false;
        }    
    }

    public int getNumeroSetmana() {
        int diasTranscurridos = getDiesTranscorregutsEnAny();
        Calendar fechaInicio = new GregorianCalendar(this.any, Calendar.JANUARY, 1);
        int primerDiaDeLaSemana = fechaInicio.get(Calendar.DAY_OF_WEEK) -1;
        int primerLunes = (primerDiaDeLaSemana == 0)?1:(8-primerDiaDeLaSemana);
        if (diasTranscurridos < primerLunes) {
            return 1;
        }   
        return ((diasTranscurridos - primerLunes) / 7 ) +2;
    }

    public Data afegir(long numDias) {
        if (numDias <= 0) {
            return new Data();
        }
        
        Calendar fecha = new GregorianCalendar(this.any, this.mes - 1, this.dia);
        fecha.add(Calendar.DAY_OF_MONTH, (int) numDias);

        return new Data(fecha.get(Calendar.DAY_OF_MONTH), 
                        fecha.get(Calendar.MONTH) + 1, 
                        fecha.get(Calendar.YEAR));
    }

    public Data restar(long numDias) {
        if (numDias <= 0) {
            return new Data();
        }
        
        Calendar fecha = new GregorianCalendar(this.any, this.mes - 1, this.dia);
        fecha.add(Calendar.DAY_OF_MONTH, (int) -numDias);

        return new Data(fecha.get(Calendar.DAY_OF_MONTH), 
                        fecha.get(Calendar.MONTH) + 1, 
                        fecha.get(Calendar.YEAR));
    }

    public boolean isCorrecta() {
        if (this.mes < 1 || this.mes > 12) {
            return false; 
        }
        
        int diasDelMes = getDiesMes(this.mes, this.any);
        if (this.dia < 1 || this.dia > diasDelMes) {
            return false;
        }
        return true;
    }

    public long getDiesDeDiferencia(Data data) {
        long diasTranscurridosActual = getDiesTranscorregutsOrigen();
        long diasTranscurridosDataProporcionada = data.getDiesTranscorregutsOrigen();
        long diferenciaDias = diasTranscurridosActual - diasTranscurridosDataProporcionada;

        return diferenciaDias;
    }

    public boolean esPosteriorA(Data data) {
        long diasTranscurridosActual = getDiesTranscorregutsOrigen();
        long diasTranscurridosDataProporcionada = data.getDiesTranscorregutsOrigen();
        return diasTranscurridosActual > diasTranscurridosDataProporcionada;
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
