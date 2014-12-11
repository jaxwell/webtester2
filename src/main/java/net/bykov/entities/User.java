package net.bykov.entities;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

/**
 * The persistent class for the user database table.
 */
@Entity
@Table(name = "User", schema = "public")
@NamedQuery(name = "User.findAll", query = "SELECT u FROM User u")
public class User extends AbstractMainEntity implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @SequenceGenerator(name = "ID_USER_GENERATOR", sequenceName = "user_seq")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "ID_USER_GENERATOR")
    @Column(name = "id_user", unique = true, nullable = false)
    private long idUser;

    @Basic
    @Column(name = "login", nullable = false, length = 30)
    private String login;

    @Basic
    @Column(name = "email", nullable = false, length = 50)
    private String email;

    @Basic
    @Column(name = "password", nullable = false, length = 256)
    private String password;

    @Basic
    @Column(name = "name")
    private String name;

    // bi-directional many-to-one association to Result
    @OneToMany(mappedBy = "userByIdStudent")
    private List<Result> resultsByIdUser;

    @OneToMany(mappedBy = "userByIdTutor")
    private List<Test> testsByIdUser;

    @OneToOne(mappedBy = "userByIdUser", fetch = FetchType.LAZY)
    private UserRegistration userRegistrationByIdUser;

    @OneToMany(mappedBy = "userByIdUser", fetch = FetchType.LAZY)
    private List<UserRole> userRolesByIdUser;

    public User() {
    }

    public long getIdUser() {
        return idUser;
    }

    public void setIdUser(long idUser) {
        this.idUser = idUser;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public Serializable getId() {
        return getIdUser();
    }

    public List<Result> getResultsByIdUser() {
        return resultsByIdUser;
    }

    public void setResultsByIdUser(List<Result> resultsByIdUser) {
        this.resultsByIdUser = resultsByIdUser;
    }

    public List<Test> getTestsByIdUser() {
        return testsByIdUser;
    }

    public void setTestsByIdUser(List<Test> testsByIdUser) {
        this.testsByIdUser = testsByIdUser;
    }

    public UserRegistration getUserRegistrationByIdUser() {
        return userRegistrationByIdUser;
    }

    public void setUserRegistrationByIdUser(UserRegistration userRegistrationByIdUser) {
        this.userRegistrationByIdUser = userRegistrationByIdUser;
    }

    public List<UserRole> getUserRolesByIdUser() {
        return userRolesByIdUser;
    }

    public void setUserRolesByIdUser(List<UserRole> userRolesByIdUser) {
        this.userRolesByIdUser = userRolesByIdUser;
    }
}
