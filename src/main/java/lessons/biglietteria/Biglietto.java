package lessons.biglietteria;

import java.math.BigDecimal;
import java.time.LocalDate;

public class Biglietto {
    //ATTRIBUTI
    private int eta;
    private int km;
    private LocalDate data;
    private boolean flessibile;
    private final static BigDecimal SCONTO_MINORI = new BigDecimal("0.2");
    private final static BigDecimal SCONTO_MAGGIORI = new BigDecimal("0.4");
    private final static BigDecimal PREZZO_KM = new BigDecimal("0.21");
    private final static int DURATA_NORMALE = 30;
    private final static int DURATA_FLESSIBILE = 90;

    //COSTRUTTORI


    public Biglietto(int eta, int km, LocalDate data, boolean flessibile) {
        isValidKm(km);
        isValidEta(eta);
        isValidData(data);
        this.eta = eta;
        this.km = km;
        this.data = data;
        this.flessibile = flessibile;
    }

    //GETTER E SETTER
        //GETTER
            public int getEta() {
                return eta;
            }

            public int getKm() {
                return km;
            }

            public LocalDate getData() {
                return data;
            }

            public boolean isFlessibile() {
                return flessibile;
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

            public void setData(LocalDate data) {
                isValidData(data);
                this.data = data;
            }

            public void setFlessibile(boolean flessibile) {
                this.flessibile = flessibile;
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

        //Metodo per la validazione della data
            private void isValidData (LocalDate data) {
                if (data==null) {
                    throw new RuntimeException("Deve Inserire una data!");
                }
            }


        //Metodo per il calcolo dello sconto
            private BigDecimal calcolaSconto () {
                BigDecimal kmDecimal = new BigDecimal(km);
                BigDecimal prezzoBase = kmDecimal.multiply(PREZZO_KM);
                if (eta >= 65) {
                    BigDecimal sconto = prezzoBase.multiply(SCONTO_MAGGIORI);
                    return sconto;
                } else if (eta <= 18){
                    BigDecimal sconto = prezzoBase.multiply(SCONTO_MINORI);
                    return sconto;
                } else {
                    BigDecimal sconto = null;
                }
                return calcolaSconto();
            }

        //Metodo per il calcolo del prezzo finale del biglietto

            public BigDecimal calcoloPrezzo () {
                BigDecimal kmDecimal = new BigDecimal(km);
                BigDecimal prezzo = kmDecimal.multiply(PREZZO_KM);
                BigDecimal prezzoTotale = prezzo.subtract(calcolaSconto());
                return prezzoTotale;
            }

        //Metodo per il calcolo dei giorni validi del biglietto
            public LocalDate calcolaDataScadenza () {

                if (flessibile) {
                    LocalDate newData = data.plusDays(DURATA_NORMALE);
                    return newData;
                } else if (!flessibile) {
                    LocalDate newData = data.plusDays(DURATA_FLESSIBILE);
                    return newData;
                }
            }
}
