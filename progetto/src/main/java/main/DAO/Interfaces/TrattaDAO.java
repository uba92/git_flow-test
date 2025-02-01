package main.DAO.Interfaces;

import java.util.List;
import java.util.UUID;

import main.Entities.Tratta;

public interface TrattaDAO {
    void aggiugiTratta(Tratta tratta);

    void rimuoviTratta(UUID idTratta);

    List<Tratta> getAllTratte();

    List<Tratta> getAllTratteWithID(UUID id_da_cercare);
}
