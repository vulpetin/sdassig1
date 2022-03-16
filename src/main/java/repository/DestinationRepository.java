package repository;

import model.Destination;
import model.User;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.NoResultException;
import javax.persistence.Persistence;
import java.util.ArrayList;
import java.util.List;

public class DestinationRepository {
    private static final EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("ro.tutorial.lab.SD");

    public void addDestination(Destination destination){
        if(destination.getId() == null) {
            generateId(destination);
        }


        EntityManager em = entityManagerFactory.createEntityManager();
        em.getTransaction().begin();
        em.persist(destination);
        em.getTransaction().commit();
        em.close();
    }

    private Destination generateId(Destination destination){
        int i = 1;
        Destination temp = getById(Integer.toString(i));

        while (temp != null){
            i++;
            temp = getById(Integer.toString(i));
        }
        destination.setId(Integer.toString(i));
        return destination;
    }

    public Destination getById(String id){
        try {
            EntityManager em = entityManagerFactory.createEntityManager();
            Object destination = em.createQuery("SELECT destination from Destination destination where destination.id = ?1")
                    .setParameter(1, id)
                    .getSingleResult();
            return (Destination) destination;
        }catch (NoResultException e){
            return null;
        }

    }



    public List<Destination> getAll(){
        EntityManager em = entityManagerFactory.createEntityManager();
        return (List<Destination>) em.createQuery("SELECT destination from Destination destination ").getResultList();
    }

    public void deleteById(String id){




        EntityManager em = entityManagerFactory.createEntityManager();
        em.getTransaction().begin();
        em.createQuery("DELETE from Destination destination where destination.id = ?1")
                .setParameter(1, id)
                .executeUpdate();
        em.getTransaction().commit();
        em.close();
        //System.out.println(id);
    }


}
