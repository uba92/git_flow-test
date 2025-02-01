package main.DAO.Interfaces;

import java.util.List;
import main.Entities.Rivenditori;

public interface RivenditoriDAO {
    void aggiungiRivenditori(Rivenditori rivenditori);

    void rimuoviRivenditori(Long idRivenditore);

    List<Rivenditori> getAllRivenditori();

    Rivenditori getRivenditore(int scelta);
}
