package daos.user;

import customexceptions.UserNotFound;
import entities.User;
import Util.DatabaseConnection;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class UserDAOImp implements UserDAO {

    @Override
    public User getUserById(int userId) {
        try (Connection connection = DatabaseConnection.createConnection()) {
            String sql = "select * from user_table where user_id = ?";
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1, userId);
            ResultSet resultSet = preparedStatement.executeQuery();
            if(resultSet.next()){
                User user = new User();
                user.setUserId(resultSet.getInt("user_id"));
                user.setUsername(resultSet.getString("username"));
                user.setPasscode(resultSet.getString("passcode"));
                user.setFirstName(resultSet.getString("first_name"));
                user.setLastName(resultSet.getString("last_name"));
                return user;
            } else{
                throw new UserNotFound("User not found");
            }
        }
        catch (SQLException e){
            e.printStackTrace();
            return null;
        }
    }

    @Override
    public List<User> getAllUsers(){
        try(Connection connection = DatabaseConnection.createConnection()){
            String sql = "select * from user_table";
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(sql);
            List<User> users = new ArrayList<>();
            while(resultSet.next()){
                User user = new User();
                user.setUserId(resultSet.getInt("user_id"));
                user.setUsername(resultSet.getString("username"));
                user.setPasscode(resultSet.getString("passcode"));
                user.setFirstName(resultSet.getString("first_name"));
                user.setLastName(resultSet.getString("last_name"));
                users.add(user);
            }
            return users;
        } catch (SQLException e){
            e.printStackTrace();
            return null;
        }
    }

}
