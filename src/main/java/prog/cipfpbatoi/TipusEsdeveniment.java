package prog.cipfpbatoi;
public enum TipusEsdeveniment {
    ANIVERSARI, FESTIU, ESPECIAL, ALTRES;
    
    public String toString(){
        return switch (this){
            case ANIVERSARI -> "Aniversari"; 
            case FESTIU -> "Festiu"; 
            case ESPECIAL -> "Especial"; 
            case ALTRES -> "Altres"; 
        };
    }
}
