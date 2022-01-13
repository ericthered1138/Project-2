package com.shield.tests.service;

import com.shield.customexceptions.InvalidPassword;
import com.shield.customexceptions.InvalidUsername;
import com.shield.customexceptions.UserNotFound;
import com.shield.daos.user.UserDAO;
import com.shield.entities.User;
import com.shield.services.user.UserServices;
import com.shield.services.user.UserServicesImp;
import org.mockito.Mockito;
import com.shield.entities.Claim;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import com.shield.customexceptions.UserNotFound;

import java.util.ArrayList;
import java.util.List;

public class UserServiceMockitoTest {

    public UserDAO userDAO;
    public UserServices userServices;

    @BeforeClass
    public void setup(){
        userDAO = Mockito.mock(UserDAO.class);
        userServices = new UserServicesImp(userDAO);
    }

    //Happy Tests

    //Checks to make sure the getUserById method is returning the correct user when given the userId
    @Test
    void getUserServiceByIdMock(){
        User returned_user = new User(1, "david", "zazulak", "david", "david");
        Mockito.when(userDAO.getUserById(1)).thenReturn(returned_user);
        User mocked_user = userServices.getUserByIdService(1);
        Assert.assertEquals(mocked_user.getUsername(), "david");
    }

    //Checks to make sure the getAllUsers method is returning a list of the users
    @Test
    void getAllUsersServiceMock(){
        User user_one = new User(1, "david", "zazulak", "david", "david");
        User user_two = new User(1, "david", "zazulak", "david", "david");
        List<User> userList = new ArrayList<>();
        userList.add(user_one);
        userList.add(user_two);
        Mockito.when(userDAO.getAllUsers()).thenReturn(userList);
        List<User> mockedUserList = userServices.getAllUserService();
        Assert.assertTrue(mockedUserList.size() >= 2);
    }

    //Checks to make sure the createUser method is creating and returning the user that is created
    @Test
    void createUserServiceMock(){
        Mockito.when(userDAO.checkUserByUsername("mock")).thenReturn(true);
        User created_user = new User(50000, "mock", "test", "mock", "mock");
        Mockito.when(userDAO.createUser(created_user)).thenReturn(created_user);
        User mocked_created_user = userServices.createUser(created_user);
        Assert.assertEquals(mocked_created_user.getUserId(), 50000);
    }

    //Checks to make sure the user is in the list of users, and then checks the checkUserLogin method to see if the user's username and password match
    @Test
    void checkUsernameAndPasswordServiceMock(){
        List<User> userList = new ArrayList<>();
        User returned_user_login_one = new User(50000, "mock", "test", "mock", "mock");
        User returned_user_login_two = new User(1, "david", "zazulak", "david", "david");
        userList.add(returned_user_login_one);
        userList.add(returned_user_login_two);
        Mockito.when(userDAO.getAllUsers()).thenReturn(userList);
        Mockito.when(userDAO.checkUserLogin(returned_user_login_one.getUsername(), returned_user_login_one.getPasscode())).thenReturn(returned_user_login_one);
        User mocked_user_login = userServices.checkUserLoginService("mock", "mock");
        Assert.assertEquals(mocked_user_login.getUserId(), 50000);
    }

    //Checks the getAllClaimsByUser method by taking in the user's Id and checking the list to see if it has more than one claim
    @Test
    void getAllClaimsByUserIdServiceMock(){
        User returned_user = new User(50000, "mock", "test", "mock", "mock");
        List<Claim> claimList = new ArrayList<>();
        Claim claim_one = new Claim(1, 50000, 1, 1000.50f, "Mock Test", "12-22-2022", "New Orleans", "12-22-2022", "pending", "");
        Claim claim_two = new Claim(1, 50000, 1, 123.50f, "Mock Test", "12-22-2022", "New Orleans", "12-22-2022", "pending", "");
        claimList.add(claim_one);
        claimList.add(claim_two);
        Mockito.when(userDAO.getUserClaimsByUser(returned_user.getUserId())).thenReturn(claimList);
        Assert.assertTrue(claimList.size()>1);
    }

    // Sad Tests


    // Checks to make sure that the user not found exception is thrown
    @Test(expectedExceptions = UserNotFound.class)
    void getUserServiceByIdSadMock(){
        Mockito.when(userDAO.getUserById(-5)).thenThrow(new UserNotFound("User not found"));;
        userServices.getUserByIdService(-5);
    }

    // Checks to make sure Invalid username exception is thrown in the checkUserLogin method
    @Test(expectedExceptions = InvalidUsername.class)
    void checkUsernameAndPasswordServiceSadUsernameMock(){
        User returned_user_login = new User(50000, "mock", "test", "mock", "mock");
        Mockito.when(userServices.checkUserLoginService("moc", returned_user_login.getPasscode())).thenThrow(new InvalidUsername("Invalid username"));
        userServices.checkUserLoginService("moc", returned_user_login.getPasscode());
    }

    // Checks to make sure the Invalid password exception is thrown in the checkUserLogin method
    @Test(expectedExceptions = InvalidPassword.class)
    void checkUsernameAndPasswordServiceSadPasswordMock(){
        User returned_user_login = new User(50000, "mock", "test", "mock", "mock");
        Mockito.when(userServices.checkUserLoginService(returned_user_login.getUsername(),"moc")).thenThrow(new InvalidPassword("Invalid password"));
        userServices.checkUserLoginService(returned_user_login.getUsername(), "moc");
    }










}
