package main.DAO;

import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import main.Entities.Biglietto;
import main.EntityManagerUtil;
import main.DAO.Interfaces.BigliettoDAO;

import java.util.List;
import java.util.UUID;

public class BigliettoDAOImpl implements BigliettoDAO {

    @Override
    public void aggiungiBiglietto(Biglietto biglietto) {
        EntityManager em = EntityManagerUtil.getEntityManager();
        try {
            em.getTransaction().begin();
            em.persist(biglietto); // Persiste il biglietto
            em.getTransaction().commit();
            System.out.println("Biglietto aggiunto con successo: " + biglietto);
        } catch (Exception e) {
            if (em.getTransaction().isActive()) {
                em.getTransaction().rollback();
            }
            e.printStackTrace();
        } finally {
            em.close();
        }
    }

    @Override
    public void rimuoviBiglietto(UUID idBiglietto) {
        EntityManager em = EntityManagerUtil.getEntityManager();
        try {
            em.getTransaction().begin();

            // Recupera il biglietto dal DB tramite idBiglietto
            Biglietto bigliettoDaEliminare = em.find(Biglietto.class, idBiglietto);

            if (bigliettoDaEliminare != null) {
                em.remove(bigliettoDaEliminare); // Rimuove il biglietto trovato
                System.out.println("Biglietto rimosso con successo: " + bigliettoDaEliminare);
            } else {
                System.out.println("Biglietto non trovato con ID: " + idBiglietto);
            }

            em.getTransaction().commit();
        } catch (Exception e) {
            if (em.getTransaction().isActive()) {
                em.getTransaction().rollback();
            }
            e.printStackTrace();
        } finally {
            em.close();
        }
    }

    @Override
    public List<Biglietto> getAllBiglietti() {
        EntityManager em = EntityManagerUtil.getEntityManager();
        try {
            // Creiamo una query JPQL per ottenere tutti i biglietti
            TypedQuery<Biglietto> query = em.createQuery("SELECT b FROM Biglietto b", Biglietto.class);
            return query.getResultList(); // Restituisce la lista di biglietti
        } catch (Exception e) {
            e.printStackTrace();
            return null; // In caso di errore, restituisce null
        } finally {
            em.close();
        }
    }
}
