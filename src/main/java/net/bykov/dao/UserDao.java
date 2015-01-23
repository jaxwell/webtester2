package net.bykov.dao;

        import net.bykov.entities.User;

        import java.util.List;

/**
 * Created by Ievgen on 11/30/2014.
 */
public interface UserDao extends IEntityDao<User> {

    List<User> listAccounts (int offset, int count);

    User findByLogin(String login);

    User activate(User user);

    User deactivate(User user);
}
