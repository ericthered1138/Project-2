package daos.user;

import customexceptions.UserNotFound;
import entities.User;
import Util.DatabaseConnection;

import javax.xml.crypto.Data;
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
    public User createUser(User user) {
        try(Connection connection = DatabaseConnection.createConnection()){
           String sql = "insert into user_table values(?, ?, ?, ?, ?)";
           PreparedStatement preparedStatement = connection.prepareStatement(sql);
           preparedStatement.setInt(1, user.getUserId());
           preparedStatement.setString(2, user.getFirstName());
           preparedStatement.setString(3, user.getLastName());
           preparedStatement.setString(4, user.getUsername());
           preparedStatement.setString(5, user.getPasscode());
           preparedStatement.executeUpdate();
           return user;

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

    @Override
    public boolean deleteUser(int userId) {
        try(Connection connection = DatabaseConnection.createConnection()){
            String sql = "delete from user_table where user_id = ?";
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1, userId);
            preparedStatement.execute();
            return true;

        }
        catch (SQLException e){
            e.printStackTrace();
            return false;
        }
    }

    @Override
    public User checkUserLogin(String username, String passcode) {
        try(Connection connection = DatabaseConnection.createConnection()){
            String sql = "select * from user_table where username = ? and passcode = ?";
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, username);
            preparedStatement.setString(2, passcode);
            ResultSet resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) {
                User user = new User(
                        resultSet.getInt("user_id"),
                        resultSet.getString("username"),
                        resultSet.getString("passcode"),
                        resultSet.getString("first_name"),
                        resultSet.getString("last_name")
                );
                return user;
            } else{
                throw new UserNotFound(("User not found"));
            }

        } catch (SQLException e){
            e.printStackTrace();
            return null;
        }
    }

}
