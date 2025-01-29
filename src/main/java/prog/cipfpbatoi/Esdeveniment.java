package prog.cipfpbatoi;
public class Esdeveniment {
    String tipusEsdeveniment;
    String notaDescriptiva;
    String ubicacion;
    Data fechaEsdeveniment;
    
    public Esdeveniment(String tipusEsdeveniment, String notaDescriptiva, Data fechaEsdeveniment) {
        this.tipusEsdeveniment = tipusEsdeveniment;
        this.notaDescriptiva = notaDescriptiva;
        long diasRestantes = this.fechaEsdeveniment.getDiesDeDiferencia(fechaEsdeveniment);
    }
    
    public Esdeveniment(String tipusEsdeveniment, String notaDescriptiva, String ubicacion, Data fechaEsdeveniment) {
        this.tipusEsdeveniment = tipusEsdeveniment;
        this.notaDescriptiva = notaDescriptiva;
        this.ubicacion = ubicacion;
        long diasRestantes = this.fechaEsdeveniment.getDiesDeDiferencia(fechaEsdeveniment);
    }

    public Esdeveniment(String tipusEsdeveniment, String notaDescriptiva, String ubicacion) {
        this.tipusEsdeveniment = tipusEsdeveniment;
        this.notaDescriptiva = notaDescriptiva;
        this.ubicacion = ubicacion;
        long diasRestantes = 30;
    }
    
    //Metododos necesarios ----
    
  
    
    
}
