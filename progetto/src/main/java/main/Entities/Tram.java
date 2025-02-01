package main.Entities;

import jakarta.persistence.*;
import java.util.UUID;

@Entity
@Table(name = "Tram")
public class Tram {

    @Id
    @GeneratedValue
    @Column(name = "idtram", nullable = false, unique = true)
    private UUID idTram;

    @Column(name = "capienza", nullable = false)
    private int capienza;

    @ManyToOne
    @JoinColumn(name = "statoId", nullable = false)
    private StatoMezzo stato;

    @ManyToOne
    @JoinColumn(name = "idcorsa")
    private Corsa corsa;

    // Costruttore vuoto richiesto da Hibernate
    public Tram() {
    }

    // Costruttore con parametri
    public Tram(int capienza, StatoMezzo stato, Corsa corsa) {
        this.capienza = capienza;
        this.stato = stato;
        this.corsa = corsa;
    }

    // Getter e Setter
    public UUID getIdTram() {
        return idTram;
    }

    public void setIdTram(UUID idTram) {
        this.idTram = idTram;
    }

    public int getCapienza() {
        return capienza;
    }

    public void setCapienza(int capienza) {
        this.capienza = capienza;
    }

    public StatoMezzo getStato() {
        return stato;
    }

    public boolean getStatoMezzo() {
        return stato.isStato();
    }

    public void setStato(StatoMezzo stato) {
        this.stato = stato;
    }

    public Corsa getCorsa() {
        return corsa;
    }

    public void setCorsa(Corsa corsa) {
        this.corsa = corsa;
    }

    @Override
    public String toString() {
        return "\nTram :" +
                "\nidTram = " + idTram +
                "\ncapienza = " + capienza +
                "\nstato = " + stato +
                "\ncorsa = " + (corsa != null ? corsa.getIdCorsa() : "null");
    }
}
