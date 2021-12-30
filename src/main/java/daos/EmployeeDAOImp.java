package daos;

import Util.DatabaseConnection;
import customexceptions.EmployeeNotFound;
import entities.Employee;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

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
        return null;
    }

    @Override
    public Employee getAllClaims(int handler_employee_id) {
        return null;
    }

    @Override
    public Employee getUserClaimsByUser(int user_id) {
        return null;
    }

    @Override
    public Employee getUserClaimsByAgent(int agent_employee_id) {
        return null;
    }

    @Override
    public Employee getAllAgentDebriefings(int handler_employee_id) {
        return null;
    }

    @Override
    public Employee getAgentDebriefings(int agent_employee_id) {
        return null;
    }

    @Override
    public Employee getLeaderboard() {
        return null;
    }
}
