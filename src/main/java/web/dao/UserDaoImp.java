package web.dao;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.Query;
import jakarta.persistence.TypedQuery;
import web.model.User;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class UserDaoImp implements UserDao {

    @PersistenceContext
    EntityManager em;

    @Override
    public void addUser(User user) {
        em.merge(user);
    }

    @Override
    public List<User> getUsers() {
        TypedQuery<User> query = em.createQuery("from User", User.class);
        return query.getResultList();
    }

    @Override
    public User getUserById(long id) {
        return em.find(User.class, id);
    }

    @Override
    public void removeUser(long id) {
        User removed = em.find(User.class, id);
        em.remove(removed);
    }

}
