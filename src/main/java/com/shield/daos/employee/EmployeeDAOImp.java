package com.shield.daos.employee;

import com.shield.Util.DatabaseConnection;
import com.shield.customexceptions.EmployeeNotFound;
import com.shield.entities.Claim;
import com.shield.entities.Debrief;
import com.shield.entities.Employee;

import java.io.*;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class EmployeeDAOImp implements EmployeeDAO {
    @Override
    public List<Employee> getAllEmployees() {
        // grab a list of all the agents
        List<Employee> employees;
        try (Connection connection = DatabaseConnection.createConnection()) {

            String sql = "select * from employee_table where handler = false";
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(sql);
            employees = new ArrayList<>();
            while (resultSet.next()) {
                Employee employee = new Employee(
                        resultSet.getInt("employee_id"),
                        resultSet.getInt("handler_id"),
                        resultSet.getBoolean("handler"),
                        resultSet.getString("username"),
                        resultSet.getString("passcode"),
                        resultSet.getString("first_name"),
                        resultSet.getString("last_name")
                );
                employees.add(employee);
            }
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
        return employees;
    }


    @Override
    public Employee getEmployeeById(int employee_id) {
        try (Connection connection = DatabaseConnection.createConnection()) {

            String sql = "select * from employee_table where employee_id = ?";
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1, employee_id);
            ResultSet resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) {
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
            } else {
                throw new EmployeeNotFound("The employee was not found.");
            }
        } catch (SQLException e) {
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
            if (resultSet.next()) {
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
            } else {
                throw new EmployeeNotFound("The employee was not found.");
            }
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }

    @Override
    public List<Claim> getAllHandlerClaims(int handler_employee_id) {

        // grab a list of the handler's agents
        List<Employee> employees;
        try (Connection connection = DatabaseConnection.createConnection()) {

            String sql = "select * from employee_table where handler_id = ?";
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1, handler_employee_id);
            ResultSet resultSet = preparedStatement.executeQuery();
            employees = new ArrayList<>();
            while (resultSet.next()) {
                Employee employee = new Employee(
                        resultSet.getInt("employee_id"),
                        resultSet.getInt("handler_id"),
                        resultSet.getBoolean("handler"),
                        resultSet.getString("username"),
                        resultSet.getString("passcode"),
                        resultSet.getString("first_name"),
                        resultSet.getString("last_name")
                );
                employees.add(employee);
            }
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }

        // for each agent create a list of claims
        List<Claim> claims = new ArrayList<>();
        for (Employee anEmployee : employees) {
            try (Connection connection = DatabaseConnection.createConnection()) {
                String sql = "select * from claim_table where employee_id = ?";
                PreparedStatement preparedStatement = connection.prepareStatement(sql);
                preparedStatement.setInt(1, anEmployee.getEmployeeId());
                ResultSet resultSet = preparedStatement.executeQuery();
                while (resultSet.next()) {
                    Claim claim = new Claim(
                            resultSet.getInt("claim_id"),
                            resultSet.getInt("user_id"),
                            resultSet.getInt("employee_id"),
                            resultSet.getInt("amount"),
                            resultSet.getString("description"),
                            resultSet.getDate("date_of_occurrence").toString(),
                            resultSet.getString("location_of_occurrence"),
                            resultSet.getTimestamp("datetime_of_creation").toString(),
                            resultSet.getString("approval"),
                            resultSet.getString("handler_comment")
                    );
                    claims.add(claim);
                }

            } catch (SQLException e) {
                e.printStackTrace();
                return null;
            }
        }
        return claims;
    }

    @Override
    public List<Claim> getUserClaimsByAgent(int agent_employee_id) {
        //grab the list of claims by employee_id
        try (Connection connection = DatabaseConnection.createConnection()) {
            String sql = "select * from claim_table where employee_id = ?";
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1, agent_employee_id);
            ResultSet resultSet = preparedStatement.executeQuery();
            List<Claim> claims = new ArrayList<>();
            while (resultSet.next()) {
                Claim claim = new Claim(
                        resultSet.getInt("claim_id"),
                        resultSet.getInt("user_id"),
                        resultSet.getInt("employee_id"),
                        resultSet.getInt("amount"),
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

        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }

    @Override
    public List<Debrief> getAllAgentDebriefings(int handler_employee_id) {

        // grab a list of the handler's agents to use to grab each agent's debriefs
        List<Employee> employees;
        try (Connection connection = DatabaseConnection.createConnection()) {

            String sql = "select * from employee_table where handler_id = ?";
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1, handler_employee_id);
            ResultSet resultSet = preparedStatement.executeQuery();
            employees = new ArrayList<>();
            while (resultSet.next()) {
                Employee employee = new Employee(
                        resultSet.getInt("employee_id"),
                        resultSet.getInt("handler_id"),
                        resultSet.getBoolean("handler"),
                        resultSet.getString("username"),
                        resultSet.getString("passcode"),
                        resultSet.getString("first_name"),
                        resultSet.getString("last_name")
                );
                employees.add(employee);
            }
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
        // for each agent create a list of debriefings
        List<Debrief> debriefs = new ArrayList<>();
        // add the agent's debriefings list to the returned list
        for (Employee anEmployee : employees) {
            try (Connection connection = DatabaseConnection.createConnection()) {
                String sql = "select * from debriefing_table where employee_id = ?";
                PreparedStatement preparedStatement = connection.prepareStatement(sql);
                preparedStatement.setInt(1, anEmployee.getEmployeeId());
                ResultSet resultSet = preparedStatement.executeQuery();
                while (resultSet.next()) {
                    Debrief debrief = new Debrief(
                            resultSet.getInt("debriefing_id"),
                            resultSet.getInt("employee_id"),
                            resultSet.getString("debriefing_text"),
                            resultSet.getDate("date_of_occurrence").toString(),
                            resultSet.getString("location_of_occurrence"),
                            resultSet.getTimestamp("datetime_of_creation").toString()
                    );
                    debriefs.add(debrief);
                }

                return debriefs;

            } catch (SQLException e) {
                e.printStackTrace();
                return null;
            }
        }
        return debriefs;
    }

    @Override
    public List<Debrief> getAgentDebriefings(int agent_employee_id) {
        // grab a list of debriefings by agent's employee_id
        try (Connection connection = DatabaseConnection.createConnection()) {
            String sql = "select * from debriefing_table where employee_id = ?";
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1, agent_employee_id);
            ResultSet resultSet = preparedStatement.executeQuery();
            List<Debrief> debriefs = new ArrayList<>();
            while (resultSet.next()) {
                Debrief debrief = new Debrief(
                        resultSet.getInt("debriefing_id"),
                        resultSet.getInt("employee_id"),
                        resultSet.getString("debriefing_text"),
                        resultSet.getDate("date_of_occurrence").toString(),
                        resultSet.getString("location_of_occurrence"),
                        resultSet.getTimestamp("datetime_of_creation").toString()
                );
                debriefs.add(debrief);
            }

            return debriefs;

        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }

    @Override
    public List<String> getLeaderboard() {

        List<String> leaderboardList = new ArrayList<>();
        try (Connection connection = DatabaseConnection.createConnection()) {
            String sql = "select employee_id, first_name, last_name, sum(amount) from claim_table natural join " +
                    "employee_table group by employee_id, first_name, last_name order by sum(amount) desc;";
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(sql);
            while (resultSet.next()) {
                String name = resultSet.getString("first_name") + " " + resultSet.getString("last_name");
                leaderboardList.add(name);
                Float total = resultSet.getFloat("sum");
                leaderboardList.add(total.toString());
            }
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
        return leaderboardList;
    }

    @Override
    public Boolean insertEmployeeImage(int employee_id, File file) {
        try (Connection connection = DatabaseConnection.createConnection()) {
            FileInputStream fileInputStream = new FileInputStream(file);
            String sql = "INSERT INTO employee_picture_table VALUES (default, ?, ?)";
            PreparedStatement preparedStatment = connection.prepareStatement(sql);
            preparedStatment.setInt(1, employee_id);
            preparedStatment.setBinaryStream(2, fileInputStream, file.length());
            preparedStatment.executeUpdate();
        } catch (SQLException | FileNotFoundException e) {
            e.printStackTrace();
            return false;
        }
        return true;
    }

    @Override
    public byte[] getEmployeeImage(int employee_id) {
        try (Connection connection = DatabaseConnection.createConnection()) {
            String sql = "SELECT picture FROM employee_picture_table WHERE employee_id = ?";
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1, employee_id);
            ResultSet resultSet = preparedStatement.executeQuery();
            InputStream image;
            if (resultSet != null) {
                while(resultSet.next()){
                    byte[] imgByte = resultSet.getBytes(1);
                    return imgByte;
            }}
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
        return null;
    }
}
