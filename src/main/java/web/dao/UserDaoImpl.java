package web.dao;

import org.springframework.stereotype.Repository;
import web.model.User;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Repository
public class UserDaoImpl implements UserDAO{

    @PersistenceContext//(unitName = "entityManagerFactory")
    private EntityManager em;

    @Override
    public void addUser(User user) {
        em.persist(user);
    }

    @Override
    public void editUser(User user) {
        em.merge(user);
//        em.flush();
    }

    @Override
    public void removeUserById(long id) {
        em.remove(em.find(User.class, id));
    }

    @Override
    public User getUserById(long id) {
        return em.find(User.class, id);
    }

    @Override
    public List<User> getAllUsers() {
        //TypedQuery<User> typedQuery = em.createQuery("from User");
        return em.createQuery("from User", User.class).getResultList();
    }

}
