package hibernate.dao;

import hibernate.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import org.w3c.dom.Entity;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Repository
public class UserDaoImp implements UserDao{

    @PersistenceContext
    EntityManager entityManager;

    @Override
    public User getUser(Long id) {
        return entityManager.createQuery("select u from User u where u.id=: param", User.class)
                .setParameter("param", id).getSingleResult();
    }

    @Override
    public List<User> getAllUsers() {
            return entityManager.createQuery("SELECT u from User u", User.class).getResultList();
    }

    @Override
    public void addUser(User user) {
        entityManager.persist(user);
    }

    @Override
    public void deleteUser(Long id) {
        entityManager.createQuery("DELETE FROM User u where u.id = :param")
                .setParameter("param", id).executeUpdate();
    }

    @Override
    public void edit(User user) {
       entityManager.merge(user);
        System.out.println(user);

    }
}
