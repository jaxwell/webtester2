package net.bykov.services;

import net.bykov.entities.Role;
import net.bykov.entities.User;
import net.bykov.exceptions.InvalidUserInputException;
import net.bykov.forms.SignupForm;

import java.util.List;

/**
 * Created by Ievgen on 11/30/2014.
 */
public interface CommonService {

    User login (String login, String password) throws InvalidUserInputException;

    User signUp (SignupForm form) throws InvalidUserInputException;

    List<Role> listAllRoles();
}