package tests.dao;

import com.shield.Util.DatabaseTableCreator;
import com.shield.daos.user.UserDAO;
import com.shield.daos.user.UserDAOImp;
import com.shield.entities.User;
import com.shield.customexceptions.UserNotFound;
import com.shield.entities.User;
import com.shield.daos.user.UserDAOImp;
import com.shield.daos.user.UserDAO;
import org.testng.Assert;
import com.shield.Util.DatabaseTableCreator;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.List;

public class UserDAOTests {

    UserDAO userDAO = new UserDAOImp();

    User newUser = new User(50, "test_first_name", "test_last_name", "test_username", "test_passcode");

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
        Assert.assertTrue(returnedUser.getUserId() != 0);
    }

    @Test
    void checkUsernameAndPassword(){
        User user = userDAO.getUserById(1000002);
        User login = userDAO.checkUserLogin(user.getUsername(), user.getPasscode());
        Assert.assertEquals(login.getUserId(), 1000002);
    }

}
