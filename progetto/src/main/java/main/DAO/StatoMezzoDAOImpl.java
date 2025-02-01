package main.DAO;

import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import main.Entities.StatoMezzo;
import main.EntityManagerUtil;
import main.DAO.Interfaces.StatoMezzoDAO;

import java.util.List;

public class StatoMezzoDAOImpl implements StatoMezzoDAO {

    @Override
    public void aggiungiStatoMezzo(StatoMezzo statoMezzo) {
        EntityManager em = EntityManagerUtil.getEntityManager();
        try {
            em.getTransaction().begin();
            em.persist(statoMezzo); // Persiste il nuovo StatoMezzo
            em.getTransaction().commit();
            System.out.println("\nStatoMezzo aggiunto con successo: " + statoMezzo + '\n');
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
    public void rimuoviStatoMezzo(Long idStato) {
        EntityManager em = EntityManagerUtil.getEntityManager();
        try {
            em.getTransaction().begin();

            // Recupera StatoMezzo dal database usando l'id
            StatoMezzo statoMezzoDaEliminare = em.find(StatoMezzo.class, idStato);

            if (statoMezzoDaEliminare != null) {
                em.remove(statoMezzoDaEliminare); // Rimuove StatoMezzo
                System.out.println("StatoMezzo rimosso con successo: " + statoMezzoDaEliminare);
            } else {
                System.out.println("StatoMezzo non trovato con ID: " + idStato);
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
    public List<StatoMezzo> getAllStatoMezzo() {
        EntityManager em = EntityManagerUtil.getEntityManager();
        try {
            // Creiamo una query JPQL per ottenere tutti gli stati del mezzo
            TypedQuery<StatoMezzo> query = em.createQuery("SELECT s FROM StatoMezzo s", StatoMezzo.class);
            return query.getResultList(); // Restituisce la lista di StatoMezzo
        } catch (Exception e) {
            e.printStackTrace();
            return null; // Restituisce null in caso di errore
        } finally {
            em.close();
        }
    }
}
