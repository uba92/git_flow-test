package main.Entities;

public class EmettitoreBiglietti {

    private Abbonamento abbonamento;
    private Biglietto biglietto;

    // Costruttore vuoto
    public EmettitoreBiglietti() {}

    // Costruttore con parametri
    public EmettitoreBiglietti(Abbonamento abbonamento, Biglietto biglietto) {
        this.abbonamento = abbonamento;
        this.biglietto = biglietto;
    }

    // Setters
    public void setAbbonamento(Abbonamento abbonamento) {
        this.abbonamento = abbonamento;
    }

    public void setBiglietto(Biglietto biglietto) {
        this.biglietto = biglietto;
    }

    // Getters
    public Abbonamento getAbbonamento() {
        return this.abbonamento;
    }

    public Biglietto getBiglietto() {
        return this.biglietto;
    }
}
