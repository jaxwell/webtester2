package net.bykov.dao.impl;

import net.bykov.dao.UserDao;
import net.bykov.entities.User;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by Ievgen on 11/30/2014.
 */
@Repository("hibernateAccountDao")
@SuppressWarnings("unchecked")
public class UserDaoImpl extends AbstractEntityDao<User> implements UserDao {

    @Override
    public List<User> listAccounts(final int offset, final int count) {
        return getSession().createCriteria(getEntityClass()).setFirstResult(offset).setMaxResults(count).list();
    }

    @Override
    protected Class<User> getEntityClass() {
        return User.class;
    }

    @Override
    public User findByLogin(final String login) {
        return (User) getSession().createCriteria(getEntityClass()).add(Restrictions.eq("login", login)).uniqueResult();
    }
}