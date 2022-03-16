package repository;

import model.User;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class UserRepository {
    private static final EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("ro.tutorial.lab.SD");

    public void addUser(User user) {
        //user = new User("1", "asd", "ghj","poiuuyt");
        EntityManager em = entityManagerFactory.createEntityManager();
        em.getTransaction().begin();
        em.persist(user);
        em.getTransaction().commit();
        em.close();
    }

    public User getByUsername(String username){
        EntityManager em = entityManagerFactory.createEntityManager();
        Object user = em.createQuery("SELECT user from User user where user.username = ?1")
                .setParameter(1, username)
                .getSingleResult();
        return (User) user;
    }
}
