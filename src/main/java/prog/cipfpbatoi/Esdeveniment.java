package prog.cipfpbatoi;
public class Esdeveniment {
    private TipusEsdeveniment tipusEsdeveniment;
    private String notaDescriptiva;
    private String ubicacion;
    private Data fechaEsdeveniment;
    
    public Esdeveniment(TipusEsdeveniment tipusEsdeveniment, String notaDescriptiva, Data fechaEsdeveniment) {
        this.tipusEsdeveniment = tipusEsdeveniment;
        this.notaDescriptiva = notaDescriptiva;
        this.fechaEsdeveniment = fechaEsdeveniment;
    }
    
    public Esdeveniment(TipusEsdeveniment tipusEsdeveniment, String notaDescriptiva, String ubicacion, Data fechaEsdeveniment) {
        this.tipusEsdeveniment = tipusEsdeveniment;
        this.notaDescriptiva = notaDescriptiva;
        this.ubicacion = ubicacion;
        this.fechaEsdeveniment = fechaEsdeveniment;
    }

    public Esdeveniment(TipusEsdeveniment tipusEsdeveniment, String notaDescriptiva, String ubicacion) {
        this.tipusEsdeveniment = tipusEsdeveniment;
        this.notaDescriptiva = notaDescriptiva;
        this.ubicacion = ubicacion;
        this.fechaEsdeveniment = new Data();
        this.fechaEsdeveniment.afegir(30);
    }
    
    
    
    public void mostrarEsdeveniment(Esdeveniment esdeveniment){
        Data fechaActual = new Data();
        if (esdeveniment.fechaEsdeveniment.esPosteriorA(fechaActual)) {
           
            System.out.printf("%s (%s) -> %s - Data: ",esdeveniment.tipusEsdeveniment,esdeveniment.notaDescriptiva, esdeveniment.ubicacion);
            esdeveniment.fechaEsdeveniment.mostrarEnFormatES();
        }else{
            System.out.printf("%s (%s) -> Ja ha tingut lloc el dia ",esdeveniment.tipusEsdeveniment,esdeveniment.notaDescriptiva);
            esdeveniment.fechaEsdeveniment.mostrarEnFormatES();
        }
    }
    
    public void substituir(Esdeveniment esdeveniment, long dias){
        if (dias < 0) {
            esdeveniment.fechaEsdeveniment.restar(Math.abs(dias));
        }else{
            esdeveniment.fechaEsdeveniment.afegir(dias);
        }
        System.out.println("Cambio de fecha realizado correctamente");
    }
    
    public static void determinarProximitat(Esdeveniment esdevenimentActual,Esdeveniment esdevenimentProporcionat, Data fecha){
        long diasEsdeveniment1 = esdevenimentActual.fechaEsdeveniment.getDiesDeDiferencia(fecha);
        long diasEsdeveniment2 = esdevenimentProporcionat.fechaEsdeveniment.getDiesDeDiferencia(fecha);
        
        if (diasEsdeveniment1 < diasEsdeveniment2) {
            System.out.println("El primer esdeveniment (actual) es el mes proxim a la data instroduida");
        }else{
            System.out.println("El segon esdeveniment proporcionat es el mes proxim a la data instroduida");
        } 
    }
    
    public boolean esDespuesDe(Data fecha){
        return this.fechaEsdeveniment.esPosteriorA(fecha);
    }
    
    
    public static boolean determinarEsdevenimentFinalitzat(Esdeveniment esdevenimentActual){
        Data fechaActual = new Data();
        return !esdevenimentActual.fechaEsdeveniment.esPosteriorA(fechaActual);
    }
    
    
}
