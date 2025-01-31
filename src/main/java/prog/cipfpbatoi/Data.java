package prog.cipfpbatoi;

import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.StringTokenizer;

public class Data {
    
    private final String DILLUNS = "Dilluns";
    private final String DIMARTS = "Dimarts";
    private final String DIMECRES = "Dimecres";
    private final String DIJOUS = "Dijous";
    private final String DIVENDRES = "Divendres";
    private final String DISSABTE = "Dissabte";
    private final String DIUMENGE = "Diumenge";

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
      int diasTranscurridos = getDiesTranscorregutsOrigen();
      int diaSemana = diasTranscurridos % 7;
    return switch (diaSemana) {
        case 0 -> DILLUNS;
        case 1 -> DIMARTS;
        case 2 -> DIMECRES;
        case 3 -> DIJOUS;
        case 4 ->  DIVENDRES;
        case 5 -> DISSABTE;
        case 6 -> DIUMENGE;
        default -> "Dia no encontrado";
        };
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
        Data iniciAny = new Data(1, 1, this.any);
        String primerDiaSetmana = iniciAny.getDiaSetmana();

        int primerDiaNum = switch (primerDiaSetmana) {
            case DILLUNS ->
                1;
            case DIMARTS ->
                2;
            case DIMECRES ->
                3;
            case DIJOUS ->
                4;
            case DIVENDRES ->
                5;
            case DISSABTE ->
                6;
            case DIUMENGE ->
                7;
            default ->
                0;
        };

        int diesTranscorreguts = getDiesTranscorregutsEnAny();

        int numeroSetmana = (diesTranscorreguts + primerDiaNum - 1) / 7 + 1;

        return numeroSetmana;
    }

    public Data afegir(long dies) {
        if (dies < 0) {
            return this;
        }
        Data novaData = this.copy();
        while (dies > 0) {
            int diesMes = getDiesMes(novaData.mes, novaData.any);
            if (novaData.dia + dies > diesMes) {
                dies -= (diesMes - novaData.dia + 1);
                novaData.dia = 1;
                if (novaData.mes == 12) {
                    novaData.mes = 1;
                    novaData.any++;
                } else {
                    novaData.mes++;
                }
            } else {
                novaData.dia += dies;
                dies = 0;
            }
        }
        return novaData;
    }

    public Data restar(long dies) {
        if (dies < 0) {
            return this;
        }
        Data novaData = this.copy();
        while (dies > 0) {
            if (novaData.dia - dies < 1) {
                dies -= novaData.dia;
                if (novaData.mes == 1) {
                    novaData.mes = 12;
                    novaData.any--;
                } else {
                    novaData.mes--;
                }
                novaData.dia = getDiesMes(novaData.mes, novaData.any);
            } else {
                novaData.dia -= dies;
                dies = 0;
            }
        }
        return novaData;
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
