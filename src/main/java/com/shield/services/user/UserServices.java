package com.shield.services.user;

import com.shield.entities.User;
import java.util.List;

public interface UserServices
{
    User getUserByIdService(int userId);

    User createUser(User user);

    List<User> getAllUserService();

    User checkUserLoginService(String username, String passcode);
}
