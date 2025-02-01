package main.Entities;

import jakarta.persistence.*;
import java.time.LocalDate;
import java.util.UUID;

@Entity
public class Abbonamento {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "idAbbonamento", nullable = false) // Nome colonna e vincolo NOT NULL
    private UUID idAbbonamento;

    @Column(name = "tipologia", nullable = false, length = 50) // Nome colonna, NOT NULL, lunghezza massima 50
    private String tipologia;

    @Column(name = "stato", nullable = false) // Nome colonna e vincolo NOT NULL
    private boolean stato;

    @Column(name = "data_emissione", nullable = false) // Nome colonna e vincolo NOT NULL
    private LocalDate dataEmissione;

    @Column(name = "scadenza", nullable = false) // Nome colonna e vincolo NOT NULL
    private LocalDate scadenza;

    // Costruttore vuoto richiesto da Hibernate
    public Abbonamento() {
    }

    // Costruttore con parametri
    public Abbonamento(String tipologia, boolean stato, LocalDate dataEmissione, LocalDate scadenza) {
        this.tipologia = tipologia;
        this.stato = stato;
        this.dataEmissione = dataEmissione;
        this.scadenza = scadenza;
    }

    // Getter e Setter
    public UUID getIdAbbonamento() {
        return idAbbonamento;
    }

    public void setIdAbbonamento(UUID idAbbonamento) {
        this.idAbbonamento = idAbbonamento;
    }

    public String getTipologia() {
        return tipologia;
    }

    public void setTipologia(String tipologia) {
        this.tipologia = tipologia;
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
        setScadenza(dataEmissione);
    }

    public void setDataEmissioneMensile(LocalDate dataEmissione) {
        this.dataEmissione = dataEmissione;
        setScadenzaMensile(dataEmissione);
    }

    public LocalDate getScadenza() {
        return scadenza;
    }

    public void setScadenza(LocalDate dataEmissione) {
        this.scadenza = dataEmissione.plusDays(7);
    }

    public void setScadenzaMensile(LocalDate dataEmissione) {
        this.scadenza = dataEmissione.plusDays(30);
    }

    @Override
    public String toString() {
        return "{ idAbbonamento = " + idAbbonamento +
                ", tipologia = '" + tipologia + '\'' +
                ", stato = " + stato +
                ", dataEmissione = " + dataEmissione +
                ", scadenza = " + scadenza + '}';
    }

}
