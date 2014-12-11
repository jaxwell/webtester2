package net.bykov.dao.impl;

import net.bykov.dao.UserRoleDao;
import net.bykov.entities.UserRole;
import org.springframework.stereotype.Repository;

/**
 * Created by Ievgen on 11/30/2014.
 */
@Repository("hiberanteAccountRoleDao")
public class UserRoleDaoImpl extends AbstractEntityDao<UserRole> implements UserRoleDao {

    @Override
    protected Class<UserRole> getEntityClass() {
        return UserRole.class;
    }

}