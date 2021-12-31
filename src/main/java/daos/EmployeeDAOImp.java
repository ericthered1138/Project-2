package daos;

import Util.DatabaseConnection;
import customexceptions.EmployeeNotFound;
import entities.Claim;
import entities.Debrief;
import entities.Employee;

import java.sql.*;
import java.time.LocalDate;
import java.time.chrono.ChronoLocalDate;
import java.util.ArrayList;
import java.util.List;

public class EmployeeDAOImp implements EmployeeDAO {
    @Override
    public Employee getEmployeeById(int employee_id) {
        try (Connection connection = DatabaseConnection.createConnection()) {

            String sql = "select * from employee_table where employee_id = ?";
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1, employee_id);
            ResultSet resultSet = preparedStatement.executeQuery();
            if(resultSet.next()) {
                Employee employee = new Employee(
                        resultSet.getInt("employee_id"),
                        resultSet.getInt("handler_id"),
                        resultSet.getBoolean("handler"),
                        resultSet.getString("username"),
                        resultSet.getString("passcode"),
                        resultSet.getString("first_name"),
                        resultSet.getString("last_name")
                );
                return employee;
            }else{
                throw new EmployeeNotFound("The employee was not found.");
            }
        } catch (SQLException e){
            e.printStackTrace();
            return null;
        }
    }

    @Override
    public Employee loginEmployee(String username, String password) {
        try (Connection connection = DatabaseConnection.createConnection()) {

            String sql = "select * from employee_table where username = ? and passcode = ?";
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, username);
            preparedStatement.setString(2, password);
            ResultSet resultSet = preparedStatement.executeQuery();
            if(resultSet.next()) {
                Employee employee = new Employee(
                        resultSet.getInt("employee_id"),
                        resultSet.getInt("handler_id"),
                        resultSet.getBoolean("handler"),
                        resultSet.getString("username"),
                        resultSet.getString("passcode"),
                        resultSet.getString("first_name"),
                        resultSet.getString("last_name")
                );
                return employee;
            }else{
                throw new EmployeeNotFound("The employee was not found.");
            }
        } catch (SQLException e){
            e.printStackTrace();
            return null;
        }
    }

    @Override
    public List<Claim> getAllClaims(int handler_employee_id) {
        // grab a list of the handler's agents
        // for each agent create a list of claims
        // add the agent's claims list to the returned list
        List<Claim> claims = new ArrayList<>();
        return null;
    }

    @Override
    public List<Claim> getUserClaimsByUser(int user_id) {
        //grab the list of claims by user_id
        try (Connection connection = DatabaseConnection.createConnection()){
            String sql = "select * from claim_table where user_id = ?";
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1, user_id);
            ResultSet resultSet = preparedStatement.executeQuery(sql);
            List<Claim> claims = new ArrayList<>();
            // each iteration of this while loop tries to move the cursor to the next row of data
            // when there are no more rows of data the method returns false and we leave the loop
            while(resultSet.next()){
                LocalDate date_of_occurrence = new LocalDate(resultSet.getDate("date_of_occurrence"));


                Claim claim= new Claim(
                        resultSet.getInt("claim_id"),
                        resultSet.getInt("user_id"),
                        resultSet.getInt("employee_id"),
                        resultSet.getInt("amount"),
                        resultSet.getString("description"),
                        resultSet.getTimestamp("date_of_occurrence").toLocalDateTime().toLocalDate(),
                        resultSet.getString("location_of_occurrence"),
                        resultSet.getTimestamp("datetime_of_creation").toLocalDateTime(),
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

    @Override
    public List<Claim> getUserClaimsByAgent(int agent_employee_id) {
        //grab the list of claims by employee_id
        return null;
    }

    @Override
    public List<Debrief> getAllAgentDebriefings(int handler_employee_id) {
        // grab a list of the handler's agents
        // for each agent create a list of debriefings
        // add the agent's debriefings list to the returned list
        return null;
    }

    @Override
    public List<Debrief> getAgentDebriefings(int agent_employee_id) {
        // grab a list of debriefings by agent's employee_id
        return null;
    }

    @Override
    public List<String> getLeaderboard() {
        //grab a list of all agents
        return null;
    }
}
