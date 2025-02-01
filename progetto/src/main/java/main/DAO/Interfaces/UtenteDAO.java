package main.DAO.Interfaces;

import java.util.List;
import java.util.UUID;
import main.Entities.Utente;

public interface UtenteDAO {
    void aggiungiUtente(Utente utente);

    void rimuoviUtente(UUID idUtente);

    Utente trovaUtente(String nome, String cognome, int eta);

    List<Utente> getAllUtenti();

    void aggiornaUtente(Utente utente);
}
