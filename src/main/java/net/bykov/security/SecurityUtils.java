package net.bykov.security;

import net.bykov.entities.User;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;

/**
 * Created by Ievgen on 12/16/2014.
 */
public class SecurityUtils {

    public static long getCurrentIdAccount () {
        CurrentAccount a = getCurrentAccount();
        return a != null ? a.getIdAccount() : -1;
    }

    public static CurrentAccount getCurrentAccount () {
        Object principal;
        try {
            principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        } catch (Exception e) {
            return null;
        }
        if (principal instanceof CurrentAccount) {
            return (CurrentAccount)principal;
        }
        return null;
    }

    public static void authentificate(User user) {
        Authentication authentication = new UsernamePasswordAuthenticationToken(
                new CurrentAccount(user),
                user.getPassword(),
                AuthentificationService.convert(user.getUserRolesByIdUser()));
        SecurityContextHolder.getContext().setAuthentication(authentication);
    }
}