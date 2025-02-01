package main.DAO;

import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import main.Entities.Corsa;
import main.EntityManagerUtil;
import main.DAO.Interfaces.CorseDAO;

import java.util.List;
import java.util.UUID;

public class CorseDAOImpl implements CorseDAO {

    @Override
    public void aggiungiCorsa(Corsa corsa) {
        EntityManager em = EntityManagerUtil.getEntityManager();
        try {
            em.getTransaction().begin();
            em.persist(corsa); 
            em.getTransaction().commit();
            System.out.println("\nCorsa aggiunta con successo: " + corsa);
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
    public void rimuoviCorsa(UUID idCorsa) {
        EntityManager em = EntityManagerUtil.getEntityManager();
        try {
            em.getTransaction().begin();

          
            Corsa corsaDaEliminare = em.find(Corsa.class, idCorsa);

            if (corsaDaEliminare != null) {
                em.remove(corsaDaEliminare); 
                System.out.println("Corsa rimossa con successo: " + corsaDaEliminare);
            } else {
                System.out.println("Corsa non trovata con ID: " + idCorsa);
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
    public List<Corsa> getAllCorse() {
        EntityManager em = EntityManagerUtil.getEntityManager();
        try {
           
            TypedQuery<Corsa> query = em.createQuery("SELECT c FROM Corsa c", Corsa.class);
            return query.getResultList(); 
        } catch (Exception e) {
            e.printStackTrace();
            return null; 
        } finally {
            em.close();
        }
    }
}
