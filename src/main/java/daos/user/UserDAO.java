package daos.user;

import entities.User;
import java.util.List;

public interface UserDAO {
    User getUserById(int userId);

    User createUser(User user);

    List<User> getAllUsers();

    boolean deleteUser(int userId);

    User checkUserLogin(String username, String passcode);
}
