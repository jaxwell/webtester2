package net.bykov.dao.impl;

import net.bykov.dao.ResultDao;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;
import net.bykov.entities.Result;

import java.util.List;

/**
 * Created by Ievgen on 12/02/2014.
 */
@Repository("hibernateResultDao")
public class ResultDaoImpl extends AbstractEntityDao<Result> implements ResultDao {

    @Override
    protected Class<Result> getEntityClass() {
        return Result.class;
    }

    @Override
    public List<Result> listUserResults(final long id_user) {
        return getSession().createCriteria(getEntityClass()).add(Restrictions.eq("id_student", id_user)).list();
    }
}
