package com.shield.tests.service;

import com.shield.customexceptions.InvalidPassword;
import com.shield.customexceptions.InvalidUsername;
import com.shield.customexceptions.UserNotFound;
import com.shield.entities.User;
import com.shield.daos.user.UserDAOImp;
import com.shield.daos.user.UserDAO;
import org.testng.annotations.Test;
import com.shield.services.user.UserServices;
import com.shield.services.user.UserServicesImp;

public class UserServiceTests {

    static UserDAO userDAO = new UserDAOImp();
    static UserServices userServices = new UserServicesImp(userDAO);

    User badLoginUsername = new User(2,"eric", "jennings", "badusername", "eric");
    User badLoginPassword = new User(2,"eric", "jennings", "eric", "badpassword");

    // Test for if a user is not in the database
    @Test(expectedExceptions = UserNotFound.class, expectedExceptionsMessageRegExp = "User not found")
    void badUserIdForGettingUser(){
        User user = userServices.getUserByIdService(500);
    }

    // Test for if the user inputs an invalid username, and it cannot be found in the database
    @Test(expectedExceptions = InvalidUsername.class, expectedExceptionsMessageRegExp = "Invalid username")
    void badUsernameForCheckingLogin(){
        userServices.checkUserLoginService(badLoginUsername.getUsername(), badLoginUsername.getPasscode());
    }

    // Tests if the user inputs a bad password
    @Test(expectedExceptions = InvalidPassword.class, expectedExceptionsMessageRegExp = "Invalid password")
    void badPasswordForCheckingLogin(){
        userServices.checkUserLoginService(badLoginPassword.getUsername(), badLoginPassword.getPasscode());
    }

    @Test(expectedExceptions = UserNotFound.class, expectedExceptionsMessageRegExp = "User not found")
    void badIdForGetUserClaimsByUserService(){
        userServices.getUserClaimsByUserService(-5);
    }
}
