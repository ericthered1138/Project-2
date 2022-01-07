package com.shield.services.user;

import com.shield.customexceptions.InvalidPassword;
import com.shield.customexceptions.InvalidUsername;
import com.shield.customexceptions.UserNotFound;
import com.shield.entities.Claim;
import com.shield.entities.User;
import com.shield.daos.user.UserDAO;

import java.util.List;

public class UserServicesImp implements UserServices {

    UserDAO userDAO;

    public UserServicesImp(UserDAO userDAO){
        this.userDAO = userDAO;
    }

    @Override
    public User getUserByIdService(int userId) {
        try{
            User user = this.userDAO.getUserById(userId);
            return user;
        } catch (UserNotFound e){
            throw new UserNotFound("User not found");
        }
    }

    @Override
    public User createUser(User user) {
        return this.userDAO.createUser(user);
    }

    @Override
    public List<User> getAllUserService() {
        return this.userDAO.getAllUsers();
    }

    @Override
    public User checkUserLoginService(String username, String passcode) {
        List<User> userList;
        try {
            userList = this.userDAO.getAllUsers();
            for (User current_user : userList) {
                if (current_user.getUsername().equals(username)) {
                    if (current_user.getPasscode().equals(passcode)) {
                        return this.userDAO.checkUserLogin(username, passcode);
                    } else{
                        throw new InvalidPassword("Invalid password");
                    }
                }
            }
            throw new InvalidUsername("Invalid username");

        } catch (InvalidPassword e) {
            throw new InvalidPassword("Invalid password");
        } catch (InvalidUsername e) {
            throw new InvalidUsername("Invalid username");
        }
    }

    @Override
    public List<Claim> getUserClaimsByUserService(int user_id){
        //Check if the user exists by id.
        userDAO.getUserById(user_id);
        try {
            return userDAO.getUserClaimsByUser(user_id);
        }
        catch (UserNotFound e){
            throw new UserNotFound("User not found");
        }
    }
}
