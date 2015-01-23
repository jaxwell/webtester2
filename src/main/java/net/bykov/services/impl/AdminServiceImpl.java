package net.bykov.services.impl;

import net.bykov.dao.UserDao;
import net.bykov.entities.User;
import net.bykov.exceptions.InvalidUserInputException;
import net.bykov.services.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by Ievgen on 11/30/2014.
 */

@Service("adminService")
public class AdminServiceImpl implements AdminService {

    @Autowired
    private UserDao userDao;

    @Override
    public List<User> listAllUsers() {
        List<User> users = userDao.findAll();
        return users;
    }

    @Override
    @Transactional(readOnly=false, rollbackFor={InvalidUserInputException.class, RuntimeException.class})
    public User deleteUser(Long idUser) {
        User u = userDao.findById(idUser);
        userDao.delete(u);
        return u;
    }

    @Override
    public User loadUser(Long idUser) {
        User u = userDao.findById(idUser);
        return u;
    }

    @Override
    @Transactional(readOnly=false, rollbackFor={InvalidUserInputException.class, RuntimeException.class})
    public User activateUser(Long idUser) {
        User u = userDao.findById(idUser);
        userDao.activate(u);
        return u;
    }

    @Override
    @Transactional(readOnly=false, rollbackFor={InvalidUserInputException.class, RuntimeException.class})
    public User deactivateUser(Long idUser) {
        User u = userDao.findById(idUser);
        userDao.deactivate(u);
        return u;
    }


}