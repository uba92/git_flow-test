package main.Entities;

import jakarta.persistence.*;
import java.util.UUID;

@Entity
@Table(name = "Tratta")
public class Tratta {
    
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private UUID idTratta; // Non usare auto-generazione del database

    @Column(name = "capoLinea", nullable = false)
    private String capoLinea;

    @Column(name = "zonaPartenza", nullable = false)
    private String zonaPartenza;

    @Column(name = "tempoDiPercorrenza", nullable = false)
    private String tempoDiPercorrenza; // Se INTERVAL in DB, usa Duration in Java

    // Costruttore con ID esplicito
    public Tratta(UUID idTratta, String capoLinea, String zonaPartenza, String tempoDiPercorrenza) {
        this.idTratta = idTratta;
        this.capoLinea = capoLinea;
        this.zonaPartenza = zonaPartenza;
        this.tempoDiPercorrenza = tempoDiPercorrenza;
    }

    // Costruttore vuoto richiesto da Hibernate
    public Tratta() {
    }

    // Getter e Setter
    public UUID getIdTratta() {
        return idTratta;
    }

    public void setIdTratta(UUID idTratta) {
        this.idTratta = idTratta;
    }

    public String getCapoLinea() {
        return capoLinea;
    }

    public void setCapoLinea(String capoLinea) {
        this.capoLinea = capoLinea;
    }

    public String getZonaPartenza() {
        return zonaPartenza;
    }

    public void setZonaPartenza(String zonaPartenza) {
        this.zonaPartenza = zonaPartenza;
    }

    public String getTempoDiPercorrenza() {
        return tempoDiPercorrenza;
    }

    public void setTempoDiPercorrenza(String tempoDiPercorrenza) {
        this.tempoDiPercorrenza = tempoDiPercorrenza;
    }

    @Override
    public String toString() {
        return "Tratta{" +
                "idTratta=" + idTratta +
                ", capoLinea='" + capoLinea + '\'' +
                ", zonaPartenza='" + zonaPartenza + '\'' +
                ", tempoDiPercorrenza='" + tempoDiPercorrenza + '\'' +
                '}';
    }
}
