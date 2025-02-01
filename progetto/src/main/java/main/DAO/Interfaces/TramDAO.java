package main.DAO.Interfaces;

import java.util.List;
import java.util.UUID;

import main.Entities.Tram;

public interface TramDAO {
    void aggiungiTram(Tram tram);

    void rimuoviTram(UUID codiceUnivoco);

    List<Tram> getAllTram();

    Tram getTramByID(UUID id_da_cercare);
}
