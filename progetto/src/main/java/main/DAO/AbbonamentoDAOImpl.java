package main.DAO;

import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import main.Entities.Abbonamento;
import main.EntityManagerUtil;
import main.DAO.Interfaces.AbbonamentoDAO;

import java.util.List;
import java.util.UUID;

public class AbbonamentoDAOImpl implements AbbonamentoDAO {

    @Override
    public void aggiungiAbbonamento(Abbonamento abbonamento) {
        EntityManager em = EntityManagerUtil.getEntityManager();
        try {
            em.getTransaction().begin();
            em.persist(abbonamento); // Persiste l'abbonamento
            em.getTransaction().commit();
            System.out.println("Abbonamento aggiunto con successo: " + abbonamento);
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
    public void rimuoviAbbonamento(UUID idAbbonamento) {
        EntityManager em = EntityManagerUtil.getEntityManager();
        try {
            em.getTransaction().begin();

            // Recupera l'abbonamento dal DB tramite idAbbonamento
            Abbonamento abbonamentoDaEliminare = em.find(Abbonamento.class, idAbbonamento);

            if (abbonamentoDaEliminare != null) {
                em.remove(abbonamentoDaEliminare); // Rimuove l'abbonamento trovato
                System.out.println("Abbonamento rimosso con successo: " + abbonamentoDaEliminare);
            } else {
                System.out.println("Abbonamento non trovato con ID: " + idAbbonamento);
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
    public List<Abbonamento> getAllAbbonamenti() {
        EntityManager em = EntityManagerUtil.getEntityManager();
        try {
            // Creiamo una query JPQL per ottenere tutti gli abbonamenti
            TypedQuery<Abbonamento> query = em.createQuery("SELECT a FROM Abbonamento a", Abbonamento.class);
            return query.getResultList(); // Restituisce la lista di abbonamenti
        } catch (Exception e) {
            e.printStackTrace();
            return null; // In caso di errore, restituisce null
        } finally {
            em.close();
        }
    }
}
