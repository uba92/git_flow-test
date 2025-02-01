package main.DAO.Interfaces;

import java.util.List;
import java.util.UUID;

import main.Entities.Corsa;

public interface CorseDAO {
    void aggiungiCorsa(Corsa corsa);

    void rimuoviCorsa(UUID idCorsa);

    List<Corsa> getAllCorse();

}
