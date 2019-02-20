package userTest.dao;

import userTest.model.User;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.util.List;

@Stateless
public class UserDAO {
    @PersistenceContext
    private EntityManager entityManager;

    public long save(User u) {
        entityManager.persist(u);
        return u.getId();
    }

    public User update(User u) {
        return entityManager.merge(u);
    }

    public void delete(Long id) {
        final User u = entityManager.find(User.class, id);
        if (u != null) {
            entityManager.remove(u);
        }
    }

    public List<User> findAll() {
        final Query query = entityManager.createQuery("SELECT u FROM User u");

        return query.getResultList();
    }
}
