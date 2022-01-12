package com.shield.tests.service;

import com.shield.customexceptions.InvalidPassword;
import com.shield.customexceptions.InvalidUsername;
import com.shield.customexceptions.UserNotFound;
import com.shield.customexceptions.UsernameAlreadyExists;
import com.shield.daos.employee.EmployeeDAO;
import com.shield.daos.employee.EmployeeDAOImp;
import com.shield.entities.Employee;
import com.shield.entities.User;
import com.shield.daos.user.UserDAOImp;
import com.shield.daos.user.UserDAO;
import org.testng.annotations.Test;
import com.shield.services.user.UserServices;
import com.shield.services.user.UserServicesImp;

public class UserServiceTests {

    static UserDAO userDAO = new UserDAOImp();
    static EmployeeDAO employeeDAO = new EmployeeDAOImp();
    static UserServices userServices = new UserServicesImp(userDAO, employeeDAO);

    User badLoginUsername = new User(2,"eric", "jennings", "badusername", "eric");
    User badLoginPassword = new User(2,"eric", "jennings", "eric", "badpassword");
    User duplicateUsernameUser = new User(4,"eric", "jennings", "victor", "badpassword");
    User duplicateUsernameEmployee = new User(1,  "Test", "Test", "scarlett", "Test");


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


    @Test(expectedExceptions = UserNotFound.class, expectedExceptionsMessageRegExp = "User not found")
    void badIdInsertUserImageService(){
        userServices.insertUserImageService(-5, "test");
    }

    @Test(expectedExceptions = UserNotFound.class, expectedExceptionsMessageRegExp = "User not found")
    void badIdGetUserImageService(){
        userServices.getUserImageService(-5);
    }

    @Test(expectedExceptions = UsernameAlreadyExists.class, expectedExceptionsMessageRegExp = "Username is already taken")
    void duplicateUserUsernameForCreateUserService(){
        userServices.createUser(duplicateUsernameUser);
    }
    @Test(expectedExceptions = UsernameAlreadyExists.class, expectedExceptionsMessageRegExp = "Username is already taken")
    void duplicateEmployeeUsernameForCreateUserService(){
        userServices.createUser(duplicateUsernameEmployee);
    }
}
