package main.DAO.Interfaces;

import java.util.List;
import java.util.UUID;
import main.Entities.Abbonamento;

public interface AbbonamentoDAO {
    void aggiungiAbbonamento(Abbonamento abbonamento);

    void rimuoviAbbonamento(UUID idAbbonamento);

    List<Abbonamento> getAllAbbonamenti();
}
