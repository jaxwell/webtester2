package net.bykov.security;

import net.bykov.entities.User;

/**
 * Created by Ievgen on 12/16/2014.
 */
public class CurrentAccount extends org.springframework.security.core.userdetails.User {
    private static final long serialVersionUID = 8252540687900090175L;
    private final long idUser;
    private int role;
    public CurrentAccount(User a) {
        super(a.getEmail(), a.getPassword(), a.getActive(), true, true, true,
                AuthentificationService.convert(a.getUserRolesByIdUser()));
        this.idUser = a.getIdUser();
    }
    public long getIdAccount() {
        return idUser;
    }
    public int getRole() {
        return role;
    }
    public void setRole(int role) {
        this.role = role;
    }
}