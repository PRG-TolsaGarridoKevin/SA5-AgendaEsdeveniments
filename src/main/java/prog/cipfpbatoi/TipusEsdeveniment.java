package prog.cipfpbatoi;
public enum TipusEsdeveniment {
    ANIVERSARI, FESTIU, ESPECIAL, ALTRES;
    
    @Override
    public String toString(){
        return switch (this){
            case ANIVERSARI -> "Aniversari"; 
            case FESTIU -> "Festiu"; 
            case ESPECIAL -> "Especial"; 
            case ALTRES -> "Altres"; 
        };
    }
    
     public static TipusEsdeveniment stringToEnum(String text){
        
         
        if (text.equalsIgnoreCase("Aniversari")) return TipusEsdeveniment.ANIVERSARI;
        if (text.equalsIgnoreCase("Festiu")) return TipusEsdeveniment.FESTIU;
        if (text.equalsIgnoreCase("Especial")) return TipusEsdeveniment.ESPECIAL;
        if (text.equalsIgnoreCase("Altres")) return TipusEsdeveniment.ALTRES;
        return ALTRES;
    } 
}
