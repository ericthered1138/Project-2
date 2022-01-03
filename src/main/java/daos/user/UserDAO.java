package daos.user;

import entities.User;
import java.util.List;

public interface UserDAO {

    int maxCreator();

    User getUserById(int userId);

    User createUser(User user);

    List<User> getAllUsers();

    User checkUserLogin(String username, String passcode);
}
