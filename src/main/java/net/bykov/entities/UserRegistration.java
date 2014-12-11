package net.bykov.entities;

import javax.persistence.*;
import java.io.Serializable;

/**
 * The persistent class for the user_registration database table.
 */
@Entity
@Table(name = "user_registration", schema = "public")
@NamedQuery(name="UserRegistration.findAll", query="SELECT u FROM UserRegistration u")
public class UserRegistration extends AbstractEntity implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @Column(name="id_user", unique=true, nullable=false)
    private long idUser;

    @Basic
    @Column(name = "hash")
    private String hash;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_user", referencedColumnName = "id_user", nullable = false)
    private User userByIdUser;

    public UserRegistration() {
    }

    public long getIdUser() {
        return idUser;
    }

    public void setIdUser(long idUser) {
        this.idUser = idUser;
    }

    public String getHash() {
        return hash;
    }

    public void setHash(String hash) {
        this.hash = hash;
    }

    @Override
    public Serializable getId() {
        return getIdUser();
    }

    public User getUserByIdUser() {
        return userByIdUser;
    }

    public void setUserByIdUser(User userByIdUser) {
        this.userByIdUser = userByIdUser;
    }
}
