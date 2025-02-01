package main.DAO.Interfaces;

import java.util.List;
import main.Entities.StatoMezzo;

public interface StatoMezzoDAO {
    void aggiungiStatoMezzo(StatoMezzo StatoMezzo);

    void rimuoviStatoMezzo(Long idStato);

    List<StatoMezzo> getAllStatoMezzo();
}
