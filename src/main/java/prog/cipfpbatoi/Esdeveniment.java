package prog.cipfpbatoi;
public class Esdeveniment {
    private TipusEsdeveniment tipusEsdeveniment;
    private String notaDescriptiva;
    private String ubicacion;
    public Data fechaEsdeveniment;
    
    public Esdeveniment(TipusEsdeveniment tipusEsdeveniment, String notaDescriptiva, Data fechaEsdeveniment) {
        this.tipusEsdeveniment = tipusEsdeveniment;
        this.notaDescriptiva = notaDescriptiva;
        this.ubicacion = "";
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
        this.fechaEsdeveniment = new Data().afegir(30);
    }
    
    
    
    public void mostrarEsdeveniment(Esdeveniment esdeveniment){
        Data fechaActual = new Data();
        if (esdeveniment.fechaEsdeveniment.esPosteriorA(fechaActual)) {
           
            if (ubicacion != null && !ubicacion.isEmpty()) {
                System.out.printf("%s (%s) -> %s - Data: %02d/%02d/%04d",esdeveniment.tipusEsdeveniment,esdeveniment.notaDescriptiva, esdeveniment.ubicacion,fechaEsdeveniment.getDia(),fechaEsdeveniment.getMes(),fechaEsdeveniment.getAny());
            }else {
                System.out.printf("%s (%s) -> Data: %02d/%02d/%04d",esdeveniment.tipusEsdeveniment,esdeveniment.notaDescriptiva,fechaEsdeveniment.getDia(),fechaEsdeveniment.getMes(),fechaEsdeveniment.getAny());
            }
        }else{
            System.out.printf("%s (%s) -> Ja ha tingut lloc el dia %02d/%02d/%04d",esdeveniment.tipusEsdeveniment,esdeveniment.notaDescriptiva,fechaEsdeveniment.getDia(),fechaEsdeveniment.getMes(),fechaEsdeveniment.getAny());
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
    
    public boolean determinarProximitat(Esdeveniment esdeveniment, Data fecha){
        long diasEsdeveniment1 = fechaEsdeveniment.getDiesDeDiferencia(fecha);
        long diasEsdeveniment2 = esdeveniment.fechaEsdeveniment.getDiesDeDiferencia(fecha);
        return diasEsdeveniment1 < diasEsdeveniment2;
    }
    
    public boolean esAntesDe(Data fecha){
        return this.fechaEsdeveniment.esPosteriorA(fecha);
    }
    
    
    public boolean determinarEsdevenimentFinalitzat(){
        Data fechaActual = new Data();
        return !fechaEsdeveniment.esPosteriorA(fechaActual);
    }
    
    
}
