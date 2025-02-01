package main.DAO.Interfaces;

import java.util.List;
import main.Entities.Distributori;

public interface DistributoriDAO {
    void aggiungiDistributori(Distributori distributori);

    void rimuoviDistributori(Long idDistributore);

    Distributori getDistributore(int scelta);

    List<Distributori> getAllDistributori();
}
