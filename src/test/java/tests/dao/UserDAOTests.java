package tests.dao;

import customexceptions.UserNotFound;
import entities.User;
import daos.user.UserDAOImp;
import daos.user.UserDAO;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.List;

public class UserDAOTests {

    UserDAO userDAO = new UserDAOImp();

    @Test
    void selectUserById(){
        User user = userDAO.getUserById(1000001);
        System.out.println(user);
        Assert.assertEquals(user.getUserId(), 1000001);
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
        Assert.assertTrue(users.size() >= 1);
    }

}
