package main.DAO;

import jakarta.persistence.EntityManager;
import jakarta.persistence.NoResultException;
import jakarta.persistence.TypedQuery;
import main.Entities.Utente;
import main.EntityManagerUtil;
import main.DAO.Interfaces.UtenteDAO;

import java.util.List;
import java.util.UUID;

public class UtenteDAOImpl implements UtenteDAO {

    @Override
    public void aggiungiUtente(Utente utente) {
        EntityManager em = EntityManagerUtil.getEntityManager();
        try {
            em.getTransaction().begin();
            if (utente.getTessera() != null) {
                em.persist(utente.getTessera());
            }
            em.persist(utente); // Poi persiste l'utente
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
    public void rimuoviUtente(UUID idUtente) {
        EntityManager em = EntityManagerUtil.getEntityManager();
        try {
            em.getTransaction().begin();

            // Recupera l'utente dal DB tramite idUtente
            Utente utenteDaEliminare = em.find(Utente.class, idUtente);

            if (utenteDaEliminare != null) {
                em.remove(utenteDaEliminare); // Rimuove l'utente trovato
                System.out.println("Utente rimosso con successo: " + utenteDaEliminare);
            } else {
                System.out.println("Utente non trovato con id: " + idUtente);
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
    public List<Utente> getAllUtenti() {
        EntityManager em = EntityManagerUtil.getEntityManager();
        try {
            // Creiamo una query JPQL per ottenere tutti gli utenti
            TypedQuery<Utente> query = em.createQuery("SELECT u FROM Utente u", Utente.class);
            return query.getResultList(); // Restituisce la lista di utenti
        } catch (Exception e) {
            e.printStackTrace();
            return null; // In caso di errore, restituisce null
        } finally {
            em.close();
        }
    }

    @Override
    public Utente trovaUtente(String nome, String cognome, int eta) {
        EntityManager em = EntityManagerUtil.getEntityManager();
        try {

            TypedQuery<Utente> query = em.createQuery(
                    "SELECT u FROM Utente u WHERE u.nome = :nome AND u.cognome = :cognome AND u.eta = :eta",
                    Utente.class);

            // Imposta i parametri nella query
            query.setParameter("nome", nome);
            query.setParameter("cognome", cognome);
            query.setParameter("eta", eta);

            return query.getSingleResult();

        } catch (NoResultException e) {
            System.out.println("Nessun utente trovato con i dati specificati.");
            return null;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        } finally {
            em.close();
        }
    }

    @Override
    public void aggiornaUtente(Utente utente) {
        EntityManager em = EntityManagerUtil.getEntityManager();
        try {
            em.getTransaction().begin();

            Utente utenteDaAggiornare = em.find(Utente.class, utente.getIdUtente());

            if (utenteDaAggiornare != null) {

                utenteDaAggiornare.setNome(utente.getNome());
                utenteDaAggiornare.setCognome(utente.getCognome());
                utenteDaAggiornare.setEta(utente.getEta());
                utenteDaAggiornare.setAbbonamento(utente.getAbbonamento());
                em.merge(utenteDaAggiornare);
                System.out.println("Utente aggiornato con successo ! ");
            } else {
                System.out.println("Utente non trovato con id: " + utente.getIdUtente());
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

}
