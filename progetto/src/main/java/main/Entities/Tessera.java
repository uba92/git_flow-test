package main.Entities;

import jakarta.persistence.*;
import java.time.LocalDate;
import java.util.UUID;

@Entity
@Table(name = "Tessere")
public class Tessera {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID idTessera;

    private boolean stato;
    private LocalDate dataEmissione;
    private LocalDate scadenza;

    // Costruttore vuoto
    public Tessera() {
    }

    // Costruttore con parametri
    public Tessera(boolean stato, LocalDate dataEmissione) {
        this.stato = stato;
        this.dataEmissione = dataEmissione;
        this.scadenza = dataEmissione.plusYears(1); // Aggiungi un anno di validità come esempio
    }

    // Getter e Setter
    public UUID getIdTessera() {
        return idTessera;
    }

    public void setIdTessera(UUID idTessera) {
        this.idTessera = idTessera;
    }

    public boolean isStato() {
        return stato;
    }

    public void setStato(boolean stato) {
        this.stato = stato;
    }

    public LocalDate getDataEmissione() {
        return dataEmissione;
    }

    public void setDataEmissione(LocalDate dataEmissione) {
        this.dataEmissione = dataEmissione;
    }

    public LocalDate getScadenza() {
        return scadenza;
    }

    public void setScadenza(LocalDate scadenza) {
        this.scadenza = scadenza;
    }

    @Override
    public String toString() {
        return "{" +
                "idTessera = " + idTessera +
                ", stato = " + stato +
                ", dataEmissione = " + dataEmissione +
                ", scadenza = " + scadenza +
                '}';
    }
}
