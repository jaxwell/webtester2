package net.bykov.components;

import net.bykov.entities.*;

/**
 * Created by Ievgen on 11/30/2014.
 */
public interface EntityBuilder {

    User buildUser();

    UserRole buildUserRole(User user, Role role);

    Test buildTest();
}