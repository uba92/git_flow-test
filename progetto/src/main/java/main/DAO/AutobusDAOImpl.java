package main.DAO;

import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import main.Entities.Autobus;
import main.EntityManagerUtil;
import main.DAO.Interfaces.AutobusDAO;

import java.util.List;
import java.util.UUID;

public class AutobusDAOImpl implements AutobusDAO {

    public void aggiungiAutobus(Autobus autobus) {
        EntityManager em = EntityManagerUtil.getEntityManager();
        try {
            em.getTransaction().begin();

            // Controlla se StatoMezzo è già nel DB, altrimenti salvalo prima
            if (autobus.getStato() != null && autobus.getStato().getIdStato() == null) {
                em.persist(autobus.getStato()); // Salva prima StatoMezzo
            }

            em.persist(autobus); // Ora salva Autobus
            em.getTransaction().commit();
        } catch (Exception e) {
            em.getTransaction().rollback();
            e.printStackTrace();
        } finally {
            em.close();
        }
    }

    @Override
    public void rimuoviAutobus(UUID codiceUnivoco) {
        EntityManager em = EntityManagerUtil.getEntityManager();
        try {
            em.getTransaction().begin();

            Autobus autobusDaEliminare = em.find(Autobus.class, codiceUnivoco);

            if (autobusDaEliminare != null) {
                em.remove(autobusDaEliminare);
                System.out.println("Autobus rimosso con successo: " + autobusDaEliminare);
            } else {
                System.out.println("Autobus non trovato con codice univoco: " + codiceUnivoco);
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
    public List<Autobus> getAllAutobus() {
        EntityManager em = EntityManagerUtil.getEntityManager();
        try {

            TypedQuery<Autobus> query = em.createQuery("SELECT a FROM Autobus a", Autobus.class);
            return query.getResultList();
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        } finally {
            em.close();
        }
    }

    @Override
    public Autobus getAutobusByID(UUID id_da_cercare) {
    EntityManager em = EntityManagerUtil.getEntityManager();
    try {
        TypedQuery<Autobus> query = em.createQuery(
                "SELECT t FROM Autobus t WHERE t.idAutobus = :idDaCercare", Autobus.class);
        query.setParameter("idDaCercare", id_da_cercare);
        
        return query.getSingleResult(); // Restituisce un solo Tram
    } 
    catch (Exception e) {
        e.printStackTrace();
        return null;
    } finally {
        em.close();
    }
}
}
