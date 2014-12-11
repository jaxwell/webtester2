package net.bykov.entities;

import javax.persistence.*;
import java.io.Serializable;

/**
 * The persistent class for the Role database table.
 */
@Entity
@Table(name = "role", schema = "public")
@NamedQuery(name="Role.findAll", query="SELECT r FROM Role r")
public class Role extends AbstractEntity implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @Column(name = "id_role", unique = true, nullable = false)
    private long idRole;

    @Basic
    @Column(name = "name", nullable = false, length = 20)
    private String name;

    public Role() {
    }

    public long getIdRole() {
        return idRole;
    }

    public void setIdRole(long idRole) {
        this.idRole = idRole;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public Serializable getId() {
        return getIdRole();
    }
}
