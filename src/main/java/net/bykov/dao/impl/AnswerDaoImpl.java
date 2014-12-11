package net.bykov.dao.impl;

import net.bykov.dao.AnswerDao;
import net.bykov.entities.Answer;
import org.springframework.stereotype.Repository;

/**
 * Created by Ievgen on 12/02/2014.
 */
@Repository("hibernateAnswerDao")
public class AnswerDaoImpl extends AbstractEntityDao<Answer> implements AnswerDao {
    @Override
    protected Class<Answer> getEntityClass() {
        return Answer.class;
    }
}
