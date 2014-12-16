package net.bykov.security;

import net.bykov.ApplicationConstants;
import net.bykov.dao.UserDao;
import net.bykov.entities.User;
import net.bykov.entities.UserRole;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.*;

/**
 * Created by Ievgen on 12/16/2014.
 */
@Service("accountAuthentificationService")
public class AuthentificationService implements UserDetailsService {
    private static final Map<Integer, String> ROLES = new HashMap<Integer, String>();
    static {
        ROLES.put(ApplicationConstants.ADMIN_ROLE, "ADMIN");
        ROLES.put(ApplicationConstants.TUTOR_ROLE, "TUTOR");
        ROLES.put(ApplicationConstants.ADVANCED_TUTOR_ROLE, "ADVANCED_TUTOR");
        ROLES.put(ApplicationConstants.STUDENT_ROLE, "STUDENT");
    }
    static Collection<? extends GrantedAuthority> convert(List<UserRole> roles) {
        Collection<SimpleGrantedAuthority> res = new ArrayList<SimpleGrantedAuthority>();
        for(UserRole ar : roles) {
            res.add(new SimpleGrantedAuthority(ROLES.get(ar.getRoleByIdRole().getIdRole())));
        }
        return res;
    }

    @Autowired
    private UserDao userDao;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User a = userDao.findByLogin(username);
        if(a == null) {
            throw new UsernameNotFoundException("Account not found by id="+username);
        }
        return new CurrentAccount(a);
    }
}

