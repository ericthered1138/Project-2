package com.shield.daos.user;

import com.shield.customexceptions.UserNotFound;
import com.shield.entities.Claim;
import com.shield.entities.User;
import com.shield.Util.DatabaseConnection;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class UserDAOImp implements UserDAO {

    @Override
    public int maxCreator() {
        try (Connection connection = DatabaseConnection.createConnection()) {
            String sql = "select max(user_id) as highest_user_id from user_table";
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(sql);
            int returned_index = 1001;
            if (resultSet.next()){
                returned_index = resultSet.getInt("highest_user_id");
            }
            //System.out.println(returned_index);
            return returned_index + 1;
        }catch (SQLException e){
            e.printStackTrace();
            return -1;
        }
    }

    int user_id_counter = this.maxCreator();

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
        user.setUserId(this.user_id_counter);
        this.user_id_counter++;

        try(Connection connection = DatabaseConnection.createConnection()){
           String sql = "insert into user_table values(?, ?, ?, ?, ?)";
           PreparedStatement preparedStatement = connection.prepareStatement(sql);
           preparedStatement.setInt(1, user.getUserId());
           preparedStatement.setString(2, user.getUsername());
           preparedStatement.setString(3, user.getPasscode());
           preparedStatement.setString(4, user.getFirstName());
           preparedStatement.setString(5, user.getLastName());
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

    @Override
    public List<Claim> getUserClaimsByUser(int user_id) {
        //grab the list of claims by user_id
        try (Connection connection = DatabaseConnection.createConnection()){
            String sql = "select * from claim_table where user_id = ?";
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1, user_id);
            ResultSet resultSet = preparedStatement.executeQuery();
            List<Claim> claims = new ArrayList<>();
            while(resultSet.next()) {
                Claim claim = new Claim(
                        resultSet.getInt("claim_id"),
                        resultSet.getInt("user_id"),
                        resultSet.getInt("employee_id"),
                        resultSet.getFloat("amount"),
                        resultSet.getString("description"),
                        resultSet.getDate("date_of_occurrence").toString(),
                        resultSet.getString("location_of_occurrence"),
                        resultSet.getTimestamp("datetime_of_creation").toString(),
                        resultSet.getString("approval"),
                        resultSet.getString("handler_comment")
                );
                claims.add(claim);
            }
            return claims;

        } catch (SQLException e){
            e.printStackTrace();
            return null;
        }
    }

}
