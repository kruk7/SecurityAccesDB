package ejb;

import entity.User;

import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Stateless
public class UserRepository
{
    @PersistenceContext
    private EntityManager em;

    public void add(User user)
    { em.persist(user); }
}
