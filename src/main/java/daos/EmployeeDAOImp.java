package daos;

import Util.DatabaseConnection;
import customexceptions.EmployeeNotFound;
import entities.Claim;
import entities.Debrief;
import entities.Employee;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
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
        return null;
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
