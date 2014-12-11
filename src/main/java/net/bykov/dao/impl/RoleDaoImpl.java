package net.bykov.dao.impl;

import net.bykov.dao.RoleDao;
import net.bykov.entities.Role;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

/**
 * Created by Ievgen on 11/30/2014.
 */
@Repository("hibernateRoleDao")
public class RoleDaoImpl extends AbstractEntityDao<Role> implements RoleDao {

    @Override
    protected Class<Role> getEntityClass() {
        return Role.class;
    }

    @Override
    public Role getStudentRole() {
        return (Role) getSession().createCriteria(getEntityClass()).add(Restrictions.eq("idRole", 4L)).uniqueResult();
    }
}