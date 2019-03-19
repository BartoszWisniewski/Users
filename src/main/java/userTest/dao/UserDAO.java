package userTest.dao;

import userTest.model.User;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.util.List;

@Stateless
public class UserDAO {
    @PersistenceContext
    private EntityManager entityManager;

    public String save(User u) {
        entityManager.persist(u);
        return u.getLogin();
    }

    public User update(User u) {
        return entityManager.merge(u);
    }

    public void delete(String log) {
        final User u = entityManager.find(User.class, log);
        if (u != null) {
            entityManager.remove(u);
        }
    }

    public List<User> findAll() {
        final Query query = entityManager.createQuery("SELECT u FROM User u");
        return query.getResultList();
    }

    public List findByLogin(String login) {
        final Query query = entityManager.createQuery("SELECT u FROM User u WHERE u.login = :login");
        query.setParameter("login", login);
        return query.getResultList();
    }

   /* public User findByLog(String login) {
        final Query query = entityManager.createQuery("SELECT u FROM User u WHERE u.login = :login");
        query.setParameter("login", login);
        return (User) query.getSingleResult();
    }*/

    public User findByLog(String login) {
        final Query query = entityManager.createQuery("SELECT u FROM User u WHERE u.login = :login");
        query.setParameter("login", login);
        return (User) query.getResultList().stream().findFirst().orElse(null);
    }

}
