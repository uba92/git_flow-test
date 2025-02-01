package main.Entities;

import java.time.LocalDate;
import java.util.UUID;

import jakarta.persistence.*;

@Entity
public class Biglietto {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID idBiglietto;
   
    @Column(name = "stato", nullable = false)
    private boolean stato;

    @Column(name = "data_emissione", nullable = false)
    private LocalDate data_emissione;

    // costruttori
    public Biglietto() {
    }

    public Biglietto(boolean stato, LocalDate data_emissione) {
        this.stato = stato;
        this.data_emissione = data_emissione;
    }

    // getters e setters
    public void setStato(boolean stato) {
        this.stato = stato;
    }

    public void setDataEmissione(LocalDate data_emissione) {
        this.data_emissione = data_emissione;
    }

    public boolean getStato() {
        return this.stato;
    }

    public LocalDate getDataEmissione() {
        return this.data_emissione;
    }

    @Override
    public String toString() {
        return "Biglietto{" +
                "codiceUnivoco=" + idBiglietto +
                ", data_di_Emissione=" + data_emissione +
                ", stato =" + stato +
                '}';
    }
}
