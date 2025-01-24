package prog.cipfpbatoi;

import java.time.format.DateTimeFormatter;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.Locale;
import java.util.StringTokenizer;

/**
 *
 * @author batoi
 */
public class Data {

    private int dia;
    private int mes;
    private int any;

    /**
     * Constructor por defecto Inicializa una fecha a la fecha del sistema
     */
    public Data() {
        Calendar fechaDelSistema = new GregorianCalendar();
        this.dia = fechaDelSistema.get(Calendar.DAY_OF_MONTH);
        this.mes = fechaDelSistema.get(Calendar.MONTH) + 1;
        this.any = fechaDelSistema.get(Calendar.YEAR);
    }

    /**
     * Inicializa la fecha a partir de los parámetros recibidos
     *
     * @param dia
     * @param mes
     * @param any
     */
    public Data(int dia, int mes, int any) {
        this.dia = dia;
        this.mes = mes;
        this.any = any;
    }

    /**
     * Inicializa la fecha a partir de otra pasada en formato String dd/mm/yyyy
     *
     * Deberemos trocearlas de forma que asignemos el día més y año a cada uno
     * de los atributos
     *
     * @param fecha
     */
    public Data(String fecha) {
        StringTokenizer st = new StringTokenizer(fecha, "/");
        int tokenDia = Integer.parseInt(st.nextToken());
        int tokenMes = Integer.parseInt(st.nextToken());
        int tokenAny = Integer.parseInt(st.nextToken());

        this.dia = tokenDia;
        this.mes = tokenMes;
        this.any = tokenAny;
    }

    /**
     * Modifica la fecha actual a partir de los datos pasados como argumento
     *
     * @param dia
     * @param mes
     * @param any
     */
    public void set(int dia, int mes, int any) {
        this.dia = dia;
        this.mes = mes;
        this.any = any;
    }

    /**
     * Creará y devolverá un nuevo objeto de la clase Data iniciado con los
     * valores que representa el objeto actual, es decir creará un clon exacto
     * del objeto actual.
     *
     * @return
     */
    public Data copy() {
        Data fecha = new Data(this.dia, this.mes, this.any);
        return fecha;
    }

    /**
     * (Ya implementado) Devuelve el día de la semana que representa por la Data
     * actual
     *
     * @return @dia
     */
    public int getDia() {
        return this.dia;
    }

    /**
     * (Ya implementado) Devuelve el mes que representa la Data actual
     *
     * @return @mes
     */
    public int getMes() {
        return this.mes;
    }

    /**
     * (Ya implementado) Devuelve el año que representa la Data actual
     *
     * @return @mes
     */
    public int getAny() {
        return this.any;
    }

    /**
     * Muestra por pantalla la fecha en formato español dd-mm-yyyy
     */
    public void mostrarEnFormatES() {
        DateTimeFormatter fechaFormatoEs = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        System.out.println(fechaFormatoEs);
    }

    /**
     * Muestra por pantalla la fecha en formato inglés yyyy-mm-dd
     */
    public void mostrarEnFormatGB() {
        DateTimeFormatter fechaFormatoIn = DateTimeFormatter.ofPattern("yyyy/MM/dd");
        System.out.println(fechaFormatoIn);
    }

    /**
     * Muestra por pantalla la fecha en formato texto dd-mmmmm-yyyy
     */
    public void mostrarEnFormatText() {
        DateTimeFormatter fechaFormatoText = DateTimeFormatter.ofPattern("dd-mm-yyyy");
        System.out.println(fechaFormatoText);
    }

    /**
     * Retorna un booleano indicando si la fecha del objeto es igual a la fecha
     * pasada como argumento
     *
     * @param fecha
     * @return boolean
     */
    public boolean isIgual(Data fecha) {
        return fecha.dia == this.dia
               && fecha.mes == this.mes
               && fecha.any == this.any;
    }

    /**
     * Retorna el dia correspondiente de la semana en formato String
     *
     * @return String
     */
    public String getDiaSetmana() {
        //------------------
        //Pagina 6 metodos privados necesarios
        //-------------------
        return null;
    }

    /**
     * Solo Festivo sábado o domingo
     *
     * @return boolean
     */
    public boolean isFestiu() {
        return false;
    }

    /**
     * Obtiene el número de la semana del año de la fecha actual
     *
     * @return
     */
    public int getNumeroSetmana() {
        return -1;

    }

    /**
     * Crea una nueva fecha con un número de días adicionales a la fecha actual
     *
     * @param numDias
     * @return
     */
    public Data afegir(long numDias) {

        return null;
    }

    /**
     * Crea una nueva fecha con un número de días anteriores a la fecha actual
     *
     * @param numDias
     * @return
     */
    public Data restar(long numDias) {
        return null;
    }

    /**
     * Determina si una fecha está compuesta por datos correctos
     *
     * @return
     */
    public boolean isCorrecta() {
        return false;
    }

    /**
     * Devuelve el valor absoluto de la diferencia de dias entre la fecha actual
     * y la proporcionada
     *
     * @param data
     * @return
     */
    public long getDiesDeDiferencia(Data data) {
        return -1L;
    }

    /**
     * Determina si una fecha es posterior a la fecha proporcionada
     *
     * @param data
     * @return
     */
    public boolean esPosteriorA(Data data) {
        return false;
    }

    /**
     * Indica si el año pasado como argumento es bisiesto Un año es bisiesto si
     * es divisible por 4 a su vez 100 por 400
     *
     * @param any
     * @return boolean
     */
    public static boolean isBisiesto(int any) {
        return false;
    }

    /**
     * Calcula el número de días que tiene el mes representado por la fecha
     * actual
     *
     * @param mes
     * @param any
     * @return int total dias mes en curso
     *
     */
    public static int getDiesMes(int mes, int any) {

        return -1;
    }

    /**
     * Calcula el número total de dias que tiene el año pasado como argumento
     *
     * @param any
     * @return int total dias any en curso
     */
    public static int getDiesAny(int any) {
        return -1;
    }
}
