package net.bykov.services.impl;

import net.bykov.dao.UserDao;
import net.bykov.entities.User;
import net.bykov.services.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
}