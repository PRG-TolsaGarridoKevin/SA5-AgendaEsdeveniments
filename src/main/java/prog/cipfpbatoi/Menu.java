package prog.cipfpbatoi;

public class Menu {

    private Agenda agenda;

    public Menu() {
        this.agenda = new Agenda();
    }

    public void iniciar() {
        boolean salir = false;

        while (!salir) {
            System.out.println("\n\n----- MENÚ D'OPCIONS -----");
            System.out.println("1. Crear nou esdeveniment");
            System.out.println("2. Buscar esdeveniment per data (i editar data)");
            System.out.println("3. Mostrar l'estat actual de l'agenda");
            System.out.println("4. Eixir");

            int opcionSeleccionada = GestorIO.llegirEnter("Selecciona una opció[1-4]: ");

            switch (opcionSeleccionada) {
                case 1:
                    agenda.afegirEsdeveniment(crearNouEsdeveniment());
                    break;
                case 2:
                    agenda.cercarEsdeveniment(demanarData());
                    cambiarData();
                    break;
                case 3:
                    agenda.mostrarEsdeveniments();
                    break;
                case 4:
                    salir = true;
                    System.out.println("Eixint del programa");
                    break;
                default:
                    System.out.println("Opcion no valida torna a intentar");
            }

        }
        GestorIO.tancar();
    }

    private Esdeveniment crearNouEsdeveniment() {
        String tipoString = GestorIO.llegirText("De que tipus es ? [Aniversari, Festiu, Especial, Altres]:  ");
        TipusEsdeveniment tipusEsd = TipusEsdeveniment.stringToEnum(tipoString);
        String descripcion = GestorIO.llegirText("Introdueix una nota descriptiva: ");
        String ubicacion = GestorIO.llegirText("Afegeix una ubicacion (Opcional, deixa buit si no): ");
        int diasRestantes = GestorIO.llegirEnter("Afegeix els dies que falten fins el esdeveniment: ");
        Data fecha = new Data().afegir(diasRestantes);

        if (ubicacion == null) {
            Esdeveniment eventoSinUbicacion = new Esdeveniment(tipusEsd, descripcion, fecha);
            return eventoSinUbicacion;
        } else {
            Esdeveniment eventoConUbicacion = new Esdeveniment(tipusEsd, descripcion, ubicacion, fecha);
            return eventoConUbicacion;
        }
    }

    private Data demanarData() {
        int dia = GestorIO.llegirEnter("Introdueix el dia: ");
        int mes = GestorIO.llegirEnter("Introdueix el mes: ");
        int any = GestorIO.llegirEnter("Introdueix el any: ");
        Data fecha = new Data(dia, mes, any);
       return fecha;
    }
    
    private void cambiarData(){
        boolean confirmacion = GestorIO.solicitarConfirmacio("\nVols modificar la data? [S/N]: ");
                    if (confirmacion) {
                        
                    }
    }
    
}
