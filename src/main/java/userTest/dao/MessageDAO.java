package userTest.dao;

import userTest.data.Message;
import userTest.data.User;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.util.List;

@Stateless
public class MessageDAO {

    @PersistenceContext
    private EntityManager entityManager;

    public void save(Message m) {
        entityManager.persist(m);
    }

    public Message update(Message m) {
        return entityManager.merge(m);
    }

    public void delete(Long id) {
        final Message m = entityManager.find(Message.class, id);
        if (m != null) {
            entityManager.remove(m);
        }
    }

    public List<Message> findAll() {
        final Query query = entityManager.createQuery("SELECT m FROM Message m");
        return query.getResultList();
    }

    public List findById(Long id) {
        final Query query = entityManager.createQuery("SELECT m FROM Message m WHERE m.id = :id");
        query.setParameter("id", id);
        return query.getResultList();
    }

    public List<Message> findByGroup(String userGroup) {
        final Query query = entityManager.createQuery("SELECT m FROM Message m WHERE m.userGroup = :userGroup");
        query.setParameter("userGroup", userGroup);
        return query.getResultList();
    }

    public Message findByIdOneMessage(Long id) {
        final Query query = entityManager.createQuery("SELECT m FROM Message m WHERE m.id = :id");
        query.setParameter("id", id);
        return (Message) query.getResultList().stream().findFirst().orElse(null);
    }

}
