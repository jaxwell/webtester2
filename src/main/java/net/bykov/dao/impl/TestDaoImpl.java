package net.bykov.dao.impl;

import net.bykov.dao.TestDao;
import net.bykov.entities.Test;
import net.bykov.entities.User;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by Ievgen on 12/02/2014.
 */
@Repository("hibernateTestDao")
public class TestDaoImpl extends AbstractEntityDao<Test> implements TestDao {

    @Autowired


    @Override
    protected Class<Test> getEntityClass() {
        return Test.class;
    }

    @Override
    public List<Test> listAllActiveTests() {
        return getSession().createCriteria(getEntityClass()).add(Restrictions.eq("active", true)).list();
    }

    @Override
    public List<Test> findByTutor(User user) {
        return getSession().createCriteria(getEntityClass()).add(Restrictions.eq("id_tutor", user.getId())).list();
    }

}
