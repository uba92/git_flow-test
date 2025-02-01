package main.DAO.Interfaces;

import java.util.List;
import java.util.UUID;
import main.Entities.Biglietto;

public interface BigliettoDAO {
    void aggiungiBiglietto(Biglietto biglietto);

    void rimuoviBiglietto(UUID idBiglietto);

    List<Biglietto> getAllBiglietti();
}
