package main.Entities;

import jakarta.persistence.*;
import java.util.UUID;

@Entity
@Table(name = "Utenti")
public class Utente {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO) // Generazione automatica dell'ID
    private UUID idUtente;

    private String nome;
    private String cognome;
    private int eta;

    @OneToOne(cascade = CascadeType.REMOVE)
    @JoinColumn(name = "idtessera", nullable = true)
    private Tessera tessera;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "idabbonamento", nullable = true) // Può essere nullo
    private Abbonamento abbonamento;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "idbiglietto", nullable = true) // Può essere nullo
    private Biglietto biglietto;

    // Costruttore vuoto richiesto da Hibernate
    public Utente() {
    }

    // Costruttore base (senza abbonamento e senza biglietto)
    public Utente(String nome, String cognome, int eta, Tessera tessera) {
        this.nome = nome;
        this.cognome = cognome;
        this.eta = eta;
        this.tessera = tessera;
        this.abbonamento = null;
        this.biglietto = null;
    }

    public Utente(String nome, String cognome, int eta, Biglietto biglietto) {
        this.nome = nome;
        this.cognome = cognome;
        this.eta = eta;
        this.tessera = null;
        this.abbonamento = null;
        this.biglietto = biglietto;
    }

    // Getter e Setter
    public UUID getIdUtente() {
        return idUtente;
    }

    public void setIdUtente(UUID idUtente) {
        this.idUtente = idUtente;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCognome() {
        return cognome;
    }

    public void setCognome(String cognome) {
        this.cognome = cognome;
    }

    public int getEta() {
        return eta;
    }

    public void setEta(int eta) {
        this.eta = eta;
    }

    public Tessera getTessera() {
        return tessera;
    }

    public void setTessera(Tessera tessera) {
        this.tessera = tessera;
    }

    public Abbonamento getAbbonamento() {
        return abbonamento;
    }

    public void setAbbonamento(Abbonamento abbonamento) {
        this.abbonamento = abbonamento;
    }

    public Biglietto getBiglietto() {
        return biglietto;
    }

    public void setBiglietto(Biglietto biglietto) {
        this.biglietto = biglietto;
    }

    @Override
    public String toString() {
        return "ID = " + idUtente +
                ",\nNome = '" + nome + '\'' +
                ",\nCognome = '" + cognome + '\'' +
                ",\nEta = " + eta +
                ",\nTessera = " + tessera +
                ",\nAbbonamento = " + (abbonamento != null ? abbonamento.toString() : "Nessun abbonamento") +
                ",\nBiglietto = " + (biglietto != null ? biglietto.toString() : "Nessun biglietto");
    }
}
