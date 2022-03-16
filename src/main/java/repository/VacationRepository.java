package repository;

import model.Destination;
import model.Vacation;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.NoResultException;
import javax.persistence.Persistence;
import java.util.List;

public class VacationRepository {
    private static final EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("ro.tutorial.lab.SD");
    private SessionFactory sessionFactory;

    public void addVacation(Vacation vacation){

        if(vacation.getId() == null) {
            generateId(vacation);
        }

        EntityManager em = entityManagerFactory.createEntityManager();
        em.getTransaction().begin();
        em.persist(vacation);
        em.getTransaction().commit();
        em.close();
    }

    private Vacation generateId(Vacation vacation){
        int i = 1;
        Vacation temp = getById(Integer.toString(i));

        while (temp != null){
            i++;
            temp = getById(Integer.toString(i));
        }
        vacation.setId(Integer.toString(i));
        return vacation;
    }

    public Vacation getById(String id){
        try {
            EntityManager em = entityManagerFactory.createEntityManager();
            Object vacation = em.createQuery("SELECT vacation from Vacation vacation where vacation.id = ?1")
                    .setParameter(1, id)
                    .getSingleResult();
            return (Vacation) vacation;
        }catch (NoResultException e){
            return null;
        }

    }

    public List<Vacation> getByDestination(Destination destination){
        try {
            EntityManager em = entityManagerFactory.createEntityManager();
            return (List<Vacation>) em.createQuery("SELECT vacation from Vacation vacation where vacation.destination.id = ?1")
                    .setParameter(1, destination.getId()).getResultList();
            //return (Vacation) vacation;
        }catch (NoResultException e){
            return null;
        }

    }

    public void deleteByDestination(Destination destination){
        List<Vacation> list = getByDestination(destination);
        for(Vacation vacation:list){
            deleteById(vacation.getId());
        }
    }

    public List<Vacation> getAll(){
        EntityManager em = entityManagerFactory.createEntityManager();
        return (List<Vacation>) em.createQuery("SELECT vacation from Vacation vacation ").getResultList();
    }

    public void deleteById(String id){




        EntityManager em = entityManagerFactory.createEntityManager();
        em.getTransaction().begin();
        em.createQuery("DELETE from Vacation vacation where vacation.id = ?1")
                .setParameter(1, id)
                .executeUpdate();
        em.getTransaction().commit();
        em.close();
        //System.out.println(id);
    }

    public void editVacation(Vacation vacation){

        EntityManager em = entityManagerFactory.createEntityManager();
        em.getTransaction().begin();
        em.merge(vacation);
        em.getTransaction().commit();
        em.close();
    }

}
