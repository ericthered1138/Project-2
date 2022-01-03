package services.user;

import entities.User;
import java.util.List;

public interface UserServices
{
    User getUserByIdService(int userId);

    User createUser(User user);

    List<User> getAllUserService();

//    boolean deleteUserService(int userId);

    User checkUserLoginService(String username, String passcode);
}
