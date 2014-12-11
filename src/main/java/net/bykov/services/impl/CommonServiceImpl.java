package net.bykov.services.impl;

import net.bykov.components.EntityBuilder;
import net.bykov.dao.RoleDao;
import net.bykov.dao.UserDao;
import net.bykov.dao.UserRoleDao;
import net.bykov.entities.Role;
import net.bykov.entities.User;
import net.bykov.entities.UserRole;
import net.bykov.exceptions.InvalidUserInputException;
import net.bykov.forms.SignupForm;
import net.bykov.services.CommonService;
import net.bykov.services.EmailService;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

import static net.bykov.utils.ReflectionUtils.copyByFields;

/**
* Created by Ievgen on 11/30/2014.
*/
@Service("commonService")
@Scope(ConfigurableBeanFactory.SCOPE_SINGLETON)
public class CommonServiceImpl implements CommonService {

    @Autowired
    private UserDao userDao;

    @Autowired
    @Qualifier("hibernateRoleDao")
    private RoleDao roleDao;

    @Autowired
    private UserRoleDao userRoleDao;

    @Autowired
    private EntityBuilder entityBuilder;

    @Autowired
    private EmailService emailService;

    public CommonServiceImpl() {
        super();
    }

    @Override
    public User login(String login, String password) throws InvalidUserInputException {
        User u = userDao.findByLogin(login);
        if(u == null) {
            throw new InvalidUserInputException("Bad credentials");
        }
        if(!StringUtils.equals(password, u.getPassword())) {
            throw new InvalidUserInputException("Bad credentials");
        }
        if(!u.getActive()) {
            throw new InvalidUserInputException("Account is not active");
        }
        boolean found = true;
//        for(UserRole ar : u.getUserRolesByIdUser()) {
//            if(ar.getRoleByIdRole().getIdRole() == role) {
//                found= true;
//                break;
//            }
//        }
        if(!found) {
            throw new InvalidUserInputException("Current account does not have selected role");
        }
        return u;
    }

    @Override
    @Transactional(readOnly=false, rollbackFor={InvalidUserInputException.class, RuntimeException.class})
    public User signUp(SignupForm form) throws InvalidUserInputException {
        User u = entityBuilder.buildUser();
        copyByFields(u, form);
        userDao.save(u);

        Role r = roleDao.getStudentRole();
        UserRole ar = entityBuilder.buildUserRole(u, r);
        userRoleDao.save(ar);

        emailService.sendVerificationEmail();

        return u;
    }

    @Override
    public List<Role> listAllRoles() {
        return roleDao.findAll();
    }
}