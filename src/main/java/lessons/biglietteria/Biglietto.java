package lessons.biglietteria;

import java.math.BigDecimal;

public class Biglietto {
    //ATTRIBUTI
    private int eta;
    private int km;

    //COSTRUTTORI


    public Biglietto(int eta, int km) {
        this.eta = eta;
        this.km = km;
    }

    //GETTER E SETTER
        //GETTER
            public int getEta() {
                return eta;
            }

            public int getKm() {
                return km;
            }
        //SETTER
            public void setEta(int eta) {
                isValidEta(eta);
                this.eta = eta;
            }

            public void setKm(int km) {
                isValidKm(km);
                this.km = km;
            }


    //METODI
        @Override
        public String toString() {
            return "Biglietto{" +
                    "eta=" + eta +
                    ", km=" + km +
                    '}';
        }
        //Metodo per la validazione dei km
        private void isValidKm (int km){
            if (km <= 0){
                throw new RuntimeException("Numero di km non valido!");
            }
        }

        //Metodo per la validazione dell'eta
        private void isValidEta (int eta) {
            if(eta < 0 || eta > 150 ) {
                throw new RuntimeException("Età non valida!");
            }
        }

        //Metodo per il calcolo dello sconto
            private double calcolaSconto () {
                double scontoBiglietto = 0;
                if (eta >= 65) {
                    scontoBiglietto = km * 0.4;
                } else if (eta <= 18){
                    scontoBiglietto = km * 0.2;
                }
                return scontoBiglietto;
            }

        //Metodo per il calcolo del prezzo finale del biglietto

            public double calcoloPrezzo () {
                double prezzoFinale = (km * 0.21) + calcolaSconto();
                return prezzoFinale;
            }
}
