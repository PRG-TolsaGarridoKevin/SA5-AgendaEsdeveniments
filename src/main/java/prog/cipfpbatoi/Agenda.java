package prog.cipfpbatoi;

public class Agenda {

    private Esdeveniment esdeveniment1;
    private Esdeveniment esdeveniment2;
    private Esdeveniment esdeveniment3;

    public Agenda() {
        this.esdeveniment1 = null;
        this.esdeveniment2 = null;
        this.esdeveniment3 = null;
    }

    public void afegirEsdeveniment(Esdeveniment nouEsdeveniment) {
        if (nouEsdeveniment.determinarEsdevenimentFinalitzat(esdeveniment1)) {
            System.out.println("No se puede añadir un evento finalizado");
            return;
        }
        if (esdeveniment1 == null) {
            esdeveniment1 = nouEsdeveniment;
        } else if (esdeveniment2 == null) {
            esdeveniment2 = nouEsdeveniment;
        } else if (esdeveniment3 == null) {
            esdeveniment3 = nouEsdeveniment;
        } else {
            Esdeveniment mesAntic = esdeveniment1;

            if (esdeveniment2 != null && esdeveniment2.esAntesDe(mesAntic.fechaEsdeveniment)) {
                mesAntic = esdeveniment2;
            }
            if (esdeveniment3 != null && esdeveniment3.esAntesDe(mesAntic.fechaEsdeveniment)) {
                mesAntic = esdeveniment3;
            }

            if (mesAntic == esdeveniment1) {
                esdeveniment1 = nouEsdeveniment;
            } else if (mesAntic == esdeveniment2) {
                esdeveniment2 = nouEsdeveniment;
            } else {
                esdeveniment3 = nouEsdeveniment;
            }
            System.out.println("La agenda estaba plena. es a reemplatzat el event mes antic");
        }
        System.out.println("Esdeveniment afegit correctament");
    }

    public Esdeveniment cercarEsdeveniment(Data fecha) {
        Esdeveniment esdevenimentResultat = null;

        if (esdeveniment1 != null && (esdeveniment1.fechaEsdeveniment.isIgual(fecha) || esdeveniment1.fechaEsdeveniment.esPosteriorA(fecha))) {
            esdevenimentResultat = esdeveniment1;
        }

        if (esdeveniment2 != null && (esdeveniment2.fechaEsdeveniment.isIgual(fecha) || esdeveniment2.fechaEsdeveniment.esPosteriorA(fecha))) {
            if (esdevenimentResultat == null || esdeveniment2.fechaEsdeveniment.esPosteriorA(esdevenimentResultat.fechaEsdeveniment)) {
                esdevenimentResultat = esdeveniment2;
            }
        }

        if (esdeveniment3 != null && (esdeveniment3.fechaEsdeveniment.isIgual(fecha) || esdeveniment3.fechaEsdeveniment.esPosteriorA(fecha))) {
            if (esdevenimentResultat == null || esdeveniment3.fechaEsdeveniment.esPosteriorA(esdevenimentResultat.fechaEsdeveniment)) {
                esdevenimentResultat = esdeveniment3;
            }
        }
        return esdevenimentResultat;
    }

    public void mostrarEsdeveniments() {
        boolean hayEventos = false;

        if (esdeveniment1 != null) {
            System.out.print("Esdeveniment 1: ");
            esdeveniment1.mostrarEsdeveniment(esdeveniment1);
            hayEventos = true;
        }
        if (esdeveniment2 != null) {
            System.out.print("Esdeveniment 2: ");
            esdeveniment2.mostrarEsdeveniment(esdeveniment2);
            hayEventos = true;
        }
        if (esdeveniment3 != null) {
            System.out.print("Esdeveniment 3: ");
            esdeveniment3.mostrarEsdeveniment(esdeveniment3);
            hayEventos = true;
        }

        if (!hayEventos) {
            System.out.println("No hi ha esdeveniments registrats en la agenda");
        }
    }
}
