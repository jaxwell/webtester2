package net.bykov.services.impl;

import net.bykov.components.EntityBuilder;
import net.bykov.dao.TestDao;
import net.bykov.entities.Test;
import net.bykov.entities.User;
import net.bykov.exceptions.InvalidUserInputException;
import net.bykov.forms.CreateTestForm;
import net.bykov.services.TutorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

import static net.bykov.utils.ReflectionUtils.copyByFields;

/**
 * Created by Ievgen on 11/30/2014.
 */
@Service
public class TutorServiceImpl implements TutorService {

    @Autowired
    private TestDao testDao;

    @Autowired
    private EntityBuilder entityBuilder;

    public List<Test> listTests(User user) {
        List<Test> t = testDao.findByTutor(user);
        return t;
    }

    @Override
    @Transactional(readOnly=false, rollbackFor={InvalidUserInputException.class, RuntimeException.class})
    public Test createTest(CreateTestForm form) throws InvalidUserInputException {
        Test t = entityBuilder.buildTest();
        // TODO Creates id_tutor
        copyByFields(t, form);
        testDao.save(t);
        return t;
    }


}
