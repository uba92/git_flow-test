package main.Entities;

import jakarta.persistence.*;
import java.util.UUID;

@Entity
@Table(name = "corse")
public class Corsa {

    @Id
    @GeneratedValue
    @Column(name = "idcorsa", nullable = false, unique = true)
    private UUID idCorsa;

    @Column(name = "tempoeffettivo", nullable = false)
    private String tempoDiPercorrenza; // Usato come String, può essere convertito in tipo INTERVAL in caso di
                                       // necessità

    @Column(name = "idtratta", nullable = false)
    private UUID idtratte;

    // Costruttore vuoto richiesto da Hibernate
    public Corsa() {
    }

    // Costruttore con parametri
    public Corsa(UUID idtratte) {
        this.idtratte = idtratte;
    }

    // Getter e Setter
    public UUID getIdCorsa() {
        return idCorsa;
    }

    public void setIdCorsa(UUID idCorsa) {
        this.idCorsa = idCorsa;
    }

    public String getTempoDiPercorrenza() {
        return tempoDiPercorrenza;
    }

    public void setTempoDiPercorrenza(String tempoDiPercorrenza) {
        this.tempoDiPercorrenza = tempoDiPercorrenza;
    }

    public UUID getIDTratte() {
        return idtratte;
    }

    public void setTratta(UUID idtratte) {
        this.idtratte = idtratte;
    }

    @Override
    public String toString() {
        return "\nCorsa: " +
                "ID Corsa = " + idCorsa +
                "\nTempo Di Percorrenza = '" + tempoDiPercorrenza + '\'' +
                "\nTratta = " + idtratte;

    }
}
