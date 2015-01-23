package net.bykov.components.impl;

import net.bykov.components.EntityBuilder;
import net.bykov.entities.*;
import org.springframework.stereotype.Component;

import java.sql.Timestamp;

/**
 * Created by Ievgen on 11/30/2014.
 */
@Component("entityBuilder")
public class EntityBuilderImpl implements EntityBuilder {

    @Override
    public User buildUser() {
        User u = new User();
        u.setCreated(new Timestamp(System.currentTimeMillis()));
        u.setActive(Boolean.FALSE);
        return u;
    }

    @Override
    public UserRole buildUserRole(User user, Role role) {
        return new UserRole(user, role);
    }

    @Override
    public Test buildTest() {
        Test t = new Test();
        t.setCreated(new Timestamp(System.currentTimeMillis()));
        t.setActive(false);
        return t;
    }
}