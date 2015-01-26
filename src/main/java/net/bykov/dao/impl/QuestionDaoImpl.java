package net.bykov.dao.impl;

import net.bykov.dao.QuestionDao;
import net.bykov.entities.Question;
import org.springframework.stereotype.Repository;

/**
 * Created by Ievgen on 12/02/2014.
 */
@Repository("hibernateQuestionDao")
public class QuestionDaoImpl extends AbstractEntityDao<Question> implements QuestionDao {
    @Override
    protected Class<Question> getEntityClass() {
        return Question.class;
    }

}
