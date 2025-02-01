package main.DAO.Interfaces;

import java.util.List;
import java.util.UUID;

import main.Entities.Autobus;

public interface AutobusDAO {
    void aggiungiAutobus(Autobus autobus);

    void rimuoviAutobus(UUID codiceUnivoco);

    List<Autobus> getAllAutobus();

    Autobus getAutobusByID(UUID id_da_cercare);
}
