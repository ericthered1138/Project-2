package tests.service;

import com.shield.customexceptions.InvalidPassword;
import com.shield.customexceptions.InvalidUsername;
import com.shield.customexceptions.UserNotFound;
import com.shield.entities.User;
import com.shield.daos.user.UserDAOImp;
import com.shield.daos.user.UserDAO;
import org.testng.Assert;
import com.shield.Util.DatabaseTableCreator;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import com.shield.services.user.UserServices;
import com.shield.services.user.UserServicesImp;

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
