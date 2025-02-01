package main.Entities;

import jakarta.persistence.*;

@Entity
@Table(name = "rivenditori") // Nome della tabella in minuscolo per convenzione
public class Rivenditori extends EmettitoreBiglietti {

    @Id
    @Column(name = "idrivenditore", nullable = false, unique = true)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idRivenditore;

    @Column(name = "bigliettivenduti", nullable = false)
    private int bigliettiVenduti = 0;

    @Column(name = "abbonamentivenduti", nullable = false)
    private int abbonamentiVenduti = 0;

    // Costruttore vuoto richiesto da Hibernate
    public Rivenditori() {
    }

    // Getter e Setter
    public Long getIdRivenditore() {
        return idRivenditore;
    }

    public void setIdRivenditore(Long idRivenditore) {
        this.idRivenditore = idRivenditore;
    }

    public int getBigliettiVenduti() {
        return bigliettiVenduti;
    }

    public void setBigliettiVenduti(int bigliettiVenduti) {
        this.bigliettiVenduti = bigliettiVenduti;
    }

    public int getAbbonamentiVenduti() {
        return abbonamentiVenduti;
    }

    public void setAbbonamentiVenduti(int abbonamentiVenduti) {
        this.abbonamentiVenduti = abbonamentiVenduti;
    }

    // Metodo per emettere un biglietto
    public Biglietto emettiBiglietto() {
        bigliettiVenduti++;
        return new Biglietto();
    }

    // Metodo per emettere un abbonamento
    public Abbonamento emettiAbbonamento() {
        abbonamentiVenduti++;
        return new Abbonamento();
    }

    @Override
    public String toString() {
        return "\nRivenditori : {" +
                "Numero Rivenditore = " + idRivenditore +
                ", Biglietti Venduti = " + bigliettiVenduti +
                ", Abbonamenti Venduti = " + abbonamentiVenduti +
                '}';
    }
}
