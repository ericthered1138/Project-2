package com.shield.tests.dao;

import com.shield.customexceptions.UserNotFound;
import com.shield.entities.Claim;
import com.shield.entities.User;
import com.shield.daos.user.UserDAOImp;
import com.shield.daos.user.UserDAO;
import org.apache.logging.log4j.core.net.Priority;
import org.testng.Assert;
import com.shield.Util.DatabaseTableCreator;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.List;

public class UserDAOTests {

    UserDAO userDAO = new UserDAOImp();

    User newUser = new User(50, "test_username", "test_passcode", "test_first_name", "test_last_name");

    @BeforeClass
    void setup(){
        DatabaseTableCreator.table_depopulator();
        DatabaseTableCreator.table_populator();
    }

    @AfterClass
    void tearDown(){
        DatabaseTableCreator.table_depopulator();
    }

    @Test
    void selectUserById(){
        User user = userDAO.getUserById(1000003);
        System.out.println(user);
        Assert.assertEquals(user.getUserId(), 1000003);
    }

    @Test(expectedExceptions = UserNotFound.class, expectedExceptionsMessageRegExp = "User not found")
    void selectUserByIdFail(){
        User user = userDAO.getUserById(500);
    }

    @Test
    void getAllUsers(){
        List<User> users = userDAO.getAllUsers();
        for (User u: users){
            System.out.println(u);
        }
        Assert.assertTrue(users.size() >= 2);
    }

    @Test
    void createUser(){
        User returnedUser = userDAO.createUser(newUser);
        System.out.println(userDAO.maxCreator());
        System.out.println(returnedUser);
        Assert.assertTrue(returnedUser.getUserId() != 0);
    }

    @Test
    void checkUsernameAndPassword(){
        User user = userDAO.getUserById(1_000_001);
        System.out.println(user);
        User login = userDAO.checkUserLogin(user.getUsername(), user.getPasscode());
        System.out.println(login);
        Assert.assertEquals(login.getUserId(), 1000001);
    }

    @Test
    void getUserClaimsByUser() {
        List<Claim> claimsList = userDAO.getUserClaimsByUser(1);
        System.out.println(claimsList);
        Assert.assertTrue(claimsList.size() > 1);
    }

    @Test(priority = 1)
    void insertUserImage(){
        String image = "test";
        int userId = 1000003;
        boolean returned_boolean = userDAO.insertUserImage(userId, image);
        Assert.assertTrue(returned_boolean);
    }

    @Test(priority = 2)
    void getUserImage(){
        this.insertUserImage();//insert the picture for the test
        int userId = 1000003;
        userDAO.insertUserImage(userId, "test");
        String returned_boolean = userDAO.getUserImage(userId);
        Assert.assertNotEquals(returned_boolean, "false");
    }

    @Test(priority = 3)
    void checkUserImage(){
        this.insertUserImage();//insert the picture for the test
        int userId = 1000003;
        userDAO.insertUserImage(userId, "test");
        boolean returned_boolean = userDAO.checkUserImage(userId);
        Assert.assertTrue(returned_boolean);
    }

    @Test
    void checkUserByUsername(){
        String username = "Paul";
        boolean returned_boolean = userDAO.checkUserByUsername(username);
        Assert.assertTrue(returned_boolean);
    }

}
