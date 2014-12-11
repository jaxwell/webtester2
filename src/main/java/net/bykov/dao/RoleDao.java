package net.bykov.dao;

import net.bykov.entities.Role;

/**
 * Created by Ievgen on 11/30/2014.
 */
public interface RoleDao extends IEntityDao<Role> {

    Role getStudentRole();
}