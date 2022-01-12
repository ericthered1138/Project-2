package com.shield.services.user;

import com.shield.customexceptions.InvalidPassword;
import com.shield.customexceptions.InvalidUsername;
import com.shield.customexceptions.UserNotFound;
import com.shield.customexceptions.UsernameAlreadyExists;
import com.shield.daos.employee.EmployeeDAO;
import com.shield.entities.Claim;
import com.shield.entities.Employee;
import com.shield.entities.User;
import com.shield.daos.user.UserDAO;

import java.util.List;

public class UserServicesImp implements UserServices {

    UserDAO userDAO;
    EmployeeDAO employeeDAO;

    public UserServicesImp(UserDAO userDAO){
        this.userDAO = userDAO;
    }

    public UserServicesImp(UserDAO userDAO, EmployeeDAO employeeDAO){
        this.userDAO = userDAO;
        this.employeeDAO = employeeDAO;
    }

    // Grabs the user from the database using the userId, and throws an exception if the userId is not found
    @Override
    public User getUserByIdService(int userId) {
        try{
            User user = this.userDAO.getUserById(userId);
            return user;
        } catch (UserNotFound e){
            throw new UserNotFound("User not found");
        }
    }

    // Sends the user information to the database to create users
    @Override
    public User createUser(User user) {
        if (userDAO.checkUserByUsername(user.getUsername())){
            return userDAO.createUser(user);
        }
        else{
            throw new UsernameAlreadyExists("Username is already taken");
        }
    }

    // Creates a list of all users in the database
    @Override
    public List<User> getAllUserService() {
        return this.userDAO.getAllUsers();
    }

    // Uses the GetAllUsers method, loops through the list of users and checks to see if the username and password match any of them
    // if it does not the method throws respective errors for invalid username or invalid password
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

    // Grabs all the claims of a user by their userId
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

    @Override
    public Boolean insertUserImageService(int userId, String image) {
        userDAO.getUserById(userId);

        return userDAO.insertUserImage(userId, image);
    }

    @Override
    public String getUserImageService(int userId) {
        userDAO.getUserById(userId);

        if(userDAO.checkUserImage(userId)){
            return userDAO.getUserImage(userId);
        } else{
            return userDAO.getUserImage(0);
        }
    }
}
