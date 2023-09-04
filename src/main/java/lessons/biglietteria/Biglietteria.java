package lessons.biglietteria;

import java.util.Scanner;

public class Biglietteria {
    public static void main(String[] args) {
        //Le nostre variabili
        boolean isValid = false;
        Biglietto bigliettoUno = null;
        //Inizializzamo il nostro scanner
        Scanner scan = new Scanner(System.in);

        //Chiediamo le i km, l'età al passeggero, controlliamo gli input e se positivo creiamo il biglietto


            while (bigliettoUno == null) {

                System.out.println("Inserisca la sua età: ");
                int etaBiglietto = 0;
                try {
                    etaBiglietto = Integer.parseInt(scan.nextLine());
                } catch (RuntimeException e) {
                    System.out.println("Numero invalido");
                }


                System.out.println("Inserisca la quantità di km: ");
                int kmBiglietto=0 ;
                try{
                    kmBiglietto = Integer.parseInt(scan.nextLine());
                } catch (RuntimeException e) {
                    System.out.println("Numero non valido!");
                }

                try {
                    bigliettoUno = new Biglietto(etaBiglietto, kmBiglietto);
                } catch (RuntimeException e) {
                    System.out.println("Invalid parameters");
                    System.out.println(e.getMessage());
                }
            }
            System.out.println(bigliettoUno);
            //calcolo il prezzo
            double prezzoBiglietto = bigliettoUno.calcoloPrezzo();
        System.out.println("Il prezzo del biglietto è: " + prezzoBiglietto);





        scan.close();
    }
}
