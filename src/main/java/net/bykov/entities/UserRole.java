package net.bykov.entities;

import javax.persistence.*;
import java.io.Serializable;

/**
 * The persistent class for the user_role database table.
 */
@Entity
@Table(name = "user_role", schema = "public")
@NamedQuery(name = "UserRole.findAll", query = "SELECT u FROM UserRole u")
public class UserRole extends AbstractEntity implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @SequenceGenerator(name = "ID_USER_ROLE_GENERATOR", sequenceName = "user_role_seq")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "ID_USER_ROLE_GENERATOR")
    @Column(name="id_user_role", unique=true, nullable=false)
    private long idUserRole;

    @Basic
    @Column(name = "id_user", nullable = false, insertable = false, updatable = false)
    private long idUser;

    @Basic
    @Column(name = "id_role", nullable = false, insertable = false, updatable = false)
    private long idRole;


    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_role", referencedColumnName = "id_role", nullable = false)
    private Role roleByIdRole;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_user", referencedColumnName = "id_user", nullable = false)
    private User userByIdUser;

    public UserRole() {
    }

    public UserRole(User user, Role role) {
        super();
        this.userByIdUser = user;
        this.roleByIdRole = role;
    }

    public long getIdUserRole() {
        return idUserRole;
    }

    public void setIdUserRole(long idUserRole) {
        this.idUserRole = idUserRole;
    }

    public long getIdUser() {
        return idUser;
    }

    public void setIdUser(long idUser) {
        this.idUser = idUser;
    }

    public long getIdRole() {
        return idRole;
    }

    public void setIdRole(long idRole) {
        this.idRole = idRole;
    }

    @Override
    public Serializable getId() {
        return getIdUserRole();
    }

    public Role getRoleByIdRole() {
        return roleByIdRole;
    }

    public void setRoleByIdRole(Role roleByIdRole) {
        this.roleByIdRole = roleByIdRole;
    }

    public User getUserByIdUser() {
        return userByIdUser;
    }

    public void setUserByIdUser(User userByIdUser) {
        this.userByIdUser = userByIdUser;
    }
}
