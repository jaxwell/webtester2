package net.bykov.services.impl;

import net.bykov.dao.ResultDao;
import net.bykov.dao.TestDao;
import net.bykov.entities.Test;
import net.bykov.entities.Result;
import net.bykov.services.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by Ievgen on 11/30/2014.
 */
@Service
public class StudentServiceImpl implements StudentService {

    @Autowired
    private TestDao testDao;

    @Autowired
    private ResultDao resultDao;

    @Override
    public List<Test> listAllActiveTests() {
        List<Test> tests = testDao.listAllActiveTests();
        return tests;
    }

    @Override
    public List<Result> listResults(long id_student) {
        return resultDao.listUserResults(id_student);
    }
}
