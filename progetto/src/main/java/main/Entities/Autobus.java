package main.Entities;

import jakarta.persistence.*;
import java.util.UUID;

@Entity
@Table(name = "Autobus")
public class Autobus {

    @Id
    @GeneratedValue
    @Column(name = "idautobus", nullable = false, unique = true)
    private UUID idAutobus;

    @Column(name = "capienza", nullable = false)
    private int capienza;

    @ManyToOne
    @JoinColumn(name = "statoId", nullable = false)
    private StatoMezzo stato;

    @ManyToOne
    @JoinColumn(name = "idcorsa")
    private Corsa corsa;

    // Costruttore vuoto richiesto da Hibernate
    public Autobus() {
    }

    // Costruttore con parametri
    public Autobus(int capienza, StatoMezzo stato, Corsa corsa) {
        this.capienza = capienza;
        this.stato = stato;
        this.corsa = corsa;
    }

    // Getter e Setter
    public UUID getIdAutobus() {
        return idAutobus;
    }

    public void setIdAutobus(UUID idAutobus) {
        this.idAutobus = idAutobus;
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
        return "\nAutobus : " +
                "\nidAutobus = " + idAutobus +
                "\nCapienza = " + capienza +
                "\nStato = " + stato +
                "\nCorsa = " + (corsa != null ? corsa.getIdCorsa() : "null") + "\n";
    }
}
