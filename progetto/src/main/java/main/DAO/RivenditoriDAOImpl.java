package main.DAO;

import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import main.Entities.Rivenditori;
import main.EntityManagerUtil;
import main.DAO.Interfaces.RivenditoriDAO;

import java.util.List;

public class RivenditoriDAOImpl implements RivenditoriDAO {

    @Override
    public void aggiungiRivenditori(Rivenditori rivenditore) {
        EntityManager em = EntityManagerUtil.getEntityManager();
        try {
            em.getTransaction().begin();
            em.persist(rivenditore); // Persiste il rivenditore
            em.getTransaction().commit();
            System.out.println("\nRivenditore aggiunto con successo: " + rivenditore);
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
    public void rimuoviRivenditori(Long idRivenditore) {
        EntityManager em = EntityManagerUtil.getEntityManager();
        try {
            em.getTransaction().begin();

            // Recupera il rivenditore dal DB tramite idRivenditore
            Rivenditori rivenditoreDaEliminare = em.find(Rivenditori.class, idRivenditore);

            if (rivenditoreDaEliminare != null) {
                em.remove(rivenditoreDaEliminare); // Rimuove il rivenditore trovato
                System.out.println("Rivenditore rimosso con successo: " + rivenditoreDaEliminare);
            } else {
                System.out.println("Rivenditore non trovato con ID: " + idRivenditore);
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
    public List<Rivenditori> getAllRivenditori() {
        EntityManager em = EntityManagerUtil.getEntityManager();
        try {
            // Creiamo una query JPQL per ottenere tutti i rivenditori
            TypedQuery<Rivenditori> query = em.createQuery("SELECT r FROM Rivenditori r", Rivenditori.class);
            if (query.getResultList().isEmpty()) {
                System.out.println("Non ci sono rivenditori al momento !");
            }
            return query.getResultList(); // Restituisce la lista di rivenditori
        } catch (Exception e) {
            e.printStackTrace();
            return null; // In caso di errore, restituisce null
        } finally {
            em.close();
        }
    }

    @Override
    public Rivenditori getRivenditore(int scelta) {

        EntityManager em = EntityManagerUtil.getEntityManager();
        try {
            // Creiamo una query JPQL per ottenere tutti i distributori
            TypedQuery<Rivenditori> query = em.createQuery("SELECT r FROM Rivenditori r", Rivenditori.class);

            List<Rivenditori> listRivenditori = query.getResultList();
            Rivenditori rivenditore = listRivenditori.get(scelta);
            return rivenditore;

        } catch (Exception e) {

            e.printStackTrace();
            return null; // In caso di errore, restituisce null

        } finally {
            em.close();
        }
    }

}
