package com.shield.daos.user;

import com.shield.entities.Claim;
import com.shield.entities.User;
import java.util.List;

public interface UserDAO {

    int maxCreator();

    User getUserById(int userId);

    User createUser(User user);

    List<User> getAllUsers();

    User checkUserLogin(String username, String passcode);

    List<Claim> getUserClaimsByUser(int user_id);

    boolean insertUserImage(int userId, String image);

    String getUserImage(int userId);

    boolean checkUserImage(int userId);

    boolean checkUserByUsername(String username);

}
