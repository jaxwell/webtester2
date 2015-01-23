package net.bykov.services.impl;

import net.bykov.components.EntityBuilder;
import net.bykov.dao.TestDao;
import net.bykov.dao.UserDao;
import net.bykov.entities.Test;
import net.bykov.entities.User;
import net.bykov.exceptions.InvalidUserInputException;
import net.bykov.forms.CreateTestForm;
import net.bykov.security.CurrentAccount;
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
    private UserDao userDao;

    @Autowired
    private EntityBuilder entityBuilder;

    public List<Test> listTests(Long userId) {
        User u = userDao.findById(userId);
        List<Test> t = testDao.findByTutor(u);
        return t;
    }

    @Override
    @Transactional(readOnly=false, rollbackFor={InvalidUserInputException.class, RuntimeException.class})
    public Test createTest(CreateTestForm form, CurrentAccount user) throws InvalidUserInputException {
        Test t = entityBuilder.buildTest();
        // TODO Create add id_tutor
        // TODO validate null values
        copyByFields(t, form);
        t.setIdTutor(user.getIdAccount());
        t.setUserByIdTutor(t.getUserByIdTutor());
        testDao.save(t);
        return t;
    }


}
