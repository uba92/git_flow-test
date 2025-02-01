package main.DAO;

import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import main.Entities.Tram;
import main.EntityManagerUtil;
import main.DAO.Interfaces.TramDAO;

import java.util.List;
import java.util.UUID;

public class TramDAOImpl implements TramDAO {

    @Override
    public void aggiungiTram(Tram tram) {
        EntityManager em = EntityManagerUtil.getEntityManager();
        try {
            em.getTransaction().begin();

            // Controlla se StatoMezzo è già nel DB, altrimenti salvalo prima
            if (tram.getStato() != null && tram.getStato().getIdStato() == null) {
                em.persist(tram.getStato()); // Salva prima StatoMezzo
            }

            em.persist(tram); // Ora salva Autobus
            em.getTransaction().commit();
        } catch (Exception e) {
            em.getTransaction().rollback();
            e.printStackTrace();
        } finally {
            em.close();
        }
    }

    @Override
    public void rimuoviTram(UUID codiceUnivoco) {
        EntityManager em = EntityManagerUtil.getEntityManager();
        try {
            em.getTransaction().begin();

            Tram tramDaEliminare = em.find(Tram.class, codiceUnivoco);

            if (tramDaEliminare != null) {
                em.remove(tramDaEliminare);
                System.out.println("Tram rimosso con successo: " + tramDaEliminare);
            } else {
                System.out.println("Tram non trovato con codice: " + codiceUnivoco);
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
    public List<Tram> getAllTram() {
        EntityManager em = EntityManagerUtil.getEntityManager();
        try {

            TypedQuery<Tram> query = em.createQuery("SELECT t FROM Tram t", Tram.class);
            return query.getResultList();
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        } finally {
            em.close();
        }
    }

    
    @Override
    public Tram getTramByID(UUID id_da_cercare) {
    EntityManager em = EntityManagerUtil.getEntityManager();
    try {
        TypedQuery<Tram> query = em.createQuery(
                "SELECT t FROM Tram t WHERE t.idTram = :idDaCercare", Tram.class);
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
