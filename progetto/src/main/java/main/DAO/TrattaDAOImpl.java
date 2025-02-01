package main.DAO;

import java.util.Collections;
import java.util.List;
import java.util.UUID;

import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import main.EntityManagerUtil;
import main.DAO.Interfaces.TrattaDAO;
import main.Entities.Tratta;

public class TrattaDAOImpl implements TrattaDAO {

    @Override
    public void aggiugiTratta(Tratta tratta) {
        EntityManager em = EntityManagerUtil.getEntityManager();
        try {
            em.getTransaction().begin();

            if (tratta.getIdTratta() == null) {
                tratta.setIdTratta(UUID.randomUUID()); // Evita problemi se viene passato un ID null
            }

            em.persist(tratta);
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
    public void rimuoviTratta(UUID idTratta) {
        EntityManager em = EntityManagerUtil.getEntityManager();
        try {
            em.getTransaction().begin();

            // Recupera l'utente dal DB tramite idUtente
            Tratta trattaDaEliminare = em.find(Tratta.class, idTratta);

            if (trattaDaEliminare != null) {
                em.remove(trattaDaEliminare); // Rimuove l'utente trovato
                System.out.println("Utente rimosso con successo: " + trattaDaEliminare);
            } else {
                System.out.println("Utente non trovato con id: " + idTratta);
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
    public List<Tratta> getAllTratte() {
        EntityManager em = EntityManagerUtil.getEntityManager();
        try {
            TypedQuery<Tratta> query = em.createQuery("SELECT t FROM Tratta t", Tratta.class);
            return query.getResultList();
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        } finally {
            em.close();
        }
    }

    @Override
    public List<Tratta> getAllTratteWithID(UUID id_da_cercare) {
        EntityManager em = EntityManagerUtil.getEntityManager();
        try {
            TypedQuery<Tratta> query = em.createQuery(
                    "SELECT t FROM Tratta t WHERE t.idTratta = :idDaCercare", Tratta.class);
            query.setParameter("idDaCercare", id_da_cercare);
            return query.getResultList();
        } catch (Exception e) {
            e.printStackTrace();
            return Collections.emptyList();
        } finally {
            em.close();
        }
    }

}