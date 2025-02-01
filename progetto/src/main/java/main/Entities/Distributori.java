package main.Entities;

import jakarta.persistence.*;

@Entity
@Table(name = "distributori") // Nome della tabella nel database
public class Distributori {

    @Id
    @Column(name = "idDistributore", nullable = false, unique = true)
    @GeneratedValue(strategy = GenerationType.IDENTITY) // Se vuoi che venga generato automaticamente
    private Long idDistributore;

    @Column(nullable = false)
    private boolean stato;

    @Column(name = "bigliettiVenduti", nullable = false)
    private int bigliettiVenduti = 0;

    @Column(name = "abbonamentiVenduti", nullable = false)
    private int abbonamentiVenduti = 0;

    // Costruttore che accetta solo lo stato
    public Distributori(boolean stato) {
        this.stato = stato;
    }

    // Costruttore vuoto richiesto da Hibernate
    public Distributori() {
    }

    // Getter e Setter
    public Long getIdDistributore() {
        return idDistributore;
    }

    public boolean isStato() {
        return stato;
    }

    public void setStato(boolean stato) {
        this.stato = stato;
    }

    public int getBigliettiVenduti() {
        return bigliettiVenduti;
    }

    public int getAbbonamentiVenduti() {
        return abbonamentiVenduti;
    }

    // Metodo per emettere un biglietto
    public Biglietto emettiBiglietto() {
        if (!stato) {
            System.out.println("Distributore non attivo, impossibile emettere un biglietto.");
            return null;
        }
        bigliettiVenduti++;
        return new Biglietto(); // Presumo tu abbia una classe Biglietto con un costruttore
    }

    // Metodo per emettere un abbonamento
    public Abbonamento emettiAbbonamento() {
        if (!stato) {
            System.out.println("Distributore non attivo, impossibile emettere un abbonamento.");
            return null;
        }
        abbonamentiVenduti++;
        return new Abbonamento(); // Presumo tu abbia una classe Abbonamento con un costruttore
    }

    @Override
    public String toString() {
        return "\nDistributore : {" +
                "Numero Distributore = " + idDistributore +
                ", Attivo = " + stato +
                ", Biglietti Venduti = " + bigliettiVenduti +
                ", Abbonamenti Venduti = " + abbonamentiVenduti +
                "}\n";
    }
}
