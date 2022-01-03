package services.user;

import customexceptions.InvalidPassword;
import customexceptions.InvalidUsername;
import customexceptions.UserNotFound;
import entities.User;
import daos.user.UserDAO;

import java.util.ArrayList;
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
}
