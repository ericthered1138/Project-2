package tests.service;

import customexceptions.InvalidPassword;
import customexceptions.InvalidUsername;
import customexceptions.UserNotFound;
import entities.User;
import daos.user.UserDAOImp;
import daos.user.UserDAO;
import org.testng.Assert;
import Util.DatabaseTableCreator;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import services.user.UserServices;
import services.user.UserServicesImp;

public class UserServiceTests {

    static UserDAO userDAO = new UserDAOImp();
    static UserServices userServices = new UserServicesImp(userDAO);

    User badLoginUsername = new User(2,"eric", "jennings", "badusername", "eric");
    User badLoginPassword = new User(2,"eric", "jennings", "eric", "badpassword");

    @Test(expectedExceptions = UserNotFound.class, expectedExceptionsMessageRegExp = "User not found")
    void badUserIdForGettingUser(){
        User user = userServices.getUserByIdService(500);
    }

    @Test(expectedExceptions = InvalidUsername.class, expectedExceptionsMessageRegExp = "Invalid username")
    void badUsernameForCheckingLogin(){
        User user = userServices.checkUserLoginService(badLoginUsername.getUsername(), badLoginUsername.getPasscode());
    }

    @Test(expectedExceptions = InvalidPassword.class, expectedExceptionsMessageRegExp = "Invalid password")
    void badPasswordForCheckingLogin(){
        User user = userServices.checkUserLoginService(badLoginPassword.getUsername(), badLoginPassword.getPasscode());
    }

//
//    @Test(expectedExceptions = UserNotFound.class, expectedExceptionsMessageRegExp = "User not found")
//    void badUserIdForDeletingUser(){
//        boolean user = userServices.deleteUserService(500);
//    }
}
