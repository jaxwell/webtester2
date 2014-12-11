package net.bykov.services;

import net.bykov.entities.User;

import java.util.List;

/**
 * Created by Ievgen on 11/30/2014.
 */
public interface AdminService {
    List<User> listAllUsers();
}
