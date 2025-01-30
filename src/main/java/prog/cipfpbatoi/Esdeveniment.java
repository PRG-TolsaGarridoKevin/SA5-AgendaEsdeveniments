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
        long diasRestantes = this.fechaEsdeveniment.getDiesDeDiferencia(fechaEsdeveniment);
    }
    
    public Esdeveniment(TipusEsdeveniment tipusEsdeveniment, String notaDescriptiva, String ubicacion, Data fechaEsdeveniment) {
        this.tipusEsdeveniment = tipusEsdeveniment;
        this.notaDescriptiva = notaDescriptiva;
        this.ubicacion = ubicacion;
        this.fechaEsdeveniment = fechaEsdeveniment;
        long diasRestantes = this.fechaEsdeveniment.getDiesDeDiferencia(fechaEsdeveniment);
    }

    public Esdeveniment(TipusEsdeveniment tipusEsdeveniment, String notaDescriptiva, String ubicacion) {
        this.tipusEsdeveniment = tipusEsdeveniment;
        this.notaDescriptiva = notaDescriptiva;
        this.ubicacion = ubicacion;
        this.fechaEsdeveniment = fechaEsdeveniment;
        long diasRestantes = 30;
    }
    
    
    
    public static void mostrarEsdeveniment(Esdeveniment esdeveniment){
        Data fechaActual = new Data();
        if (esdeveniment.fechaEsdeveniment.esPosteriorA(fechaActual)) {
           
            System.out.printf("%s (%s) -> %s - Data: ",esdeveniment.tipusEsdeveniment,esdeveniment.notaDescriptiva, esdeveniment.ubicacion);
            esdeveniment.fechaEsdeveniment.mostrarEnFormatES();
        }else{
            System.out.printf("%s (%s) -> Ja ha tingut lloc el dia ",esdeveniment.tipusEsdeveniment,esdeveniment.notaDescriptiva);
            esdeveniment.fechaEsdeveniment.mostrarEnFormatES();
        }
    }
    
    public static void substituir(Esdeveniment esdeveniment, long dias){
        if (dias < 0) {
            esdeveniment.fechaEsdeveniment.restar(dias);
        }else{
            esdeveniment.fechaEsdeveniment.afegir(dias);
        }
        System.out.println("Cambio de fecha realizado correctamente");
    }
    
    
    
    
    
    
}
