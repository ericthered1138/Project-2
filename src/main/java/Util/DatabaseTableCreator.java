package Util;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

public class DatabaseTableCreator {


    public static void table_creator(){
        try (Connection connection = DatabaseConnection.createConnection()) {
            String sql = "create table user_table(user_id int, username varchar(40), passcode varchar(20), " +
                    "first_name varchar(20), last_name varchar(20), primary key (user_id)); " +
                    "create table employee_table(employee_id int, handler_id int, handler bool, username varchar(40), " +
                    "passcode varchar(20),first_name varchar(20), last_name varchar(20), primary key (employee_id)); " +
                    "create table claim_table(claim_id int, user_id int, employee_id int, amount decimal, " +
                    "description varchar(280), date_of_occurrence DATE, location_of_occurrence varchar(100), " +
                    "datetime_of_creation TIMESTAMP, approval varchar(20), handler_comment varchar(280), " +
                    "primary key (claim_id), foreign key (employee_id) references employee_table(employee_id)); " +
                    "create table debriefing_table(debriefing_id int, employee_id int, debriefing_text varchar(480), " +
                    "date_of_occurrence DATE, location_of_occurrence varchar(100), datetime_of_creation TIMESTAMP, " +
                    "primary key (debriefing_id), foreign key (employee_id) references employee_table(employee_id));";
            Statement statement = connection.createStatement();
            statement.executeQuery(sql);
        }catch (SQLException e){
            e.printStackTrace();
        }
    }

    public static void table_populator(){
        try (Connection connection = DatabaseConnection.createConnection()) {
            String sql = "insert into user_table values('1000001', 'test_username', 'test_password', 'test_first_name', 'test_last_name'); " +
                    "insert into employee_table values('1000001', Null, TRUE, 'test_handler', 'handler_password','handler_first', 'handler_last'); " +
                    "insert into employee_table values('1000002', '1000001', False, 'test_agent', 'test_agent_password','agent_first_name', 'agent_last_name'); " +
                    "insert into claim_table values('1000001', '1000001', '1000002', '50.34', 'test_description', '2021-12-10', 'new york', '2021-12-10', 'pending', 'test_handler_comment'); " +
                    "insert into debriefing_table values('1000001', '1000002', 'test_debriefing_text', '2021-12-10', 'new york', '2021-12-10');";
            Statement statement = connection.createStatement();
            statement.executeQuery(sql);
        }catch (SQLException e){
            e.printStackTrace();
        }
    }

    public static void table_depopulator(){
        try (Connection connection = DatabaseConnection.createConnection()) {
            String sql = "delete from claim_table where employee_id > 999999; " +
                    "delete from debriefing_table where employee_id > 999999; " +
                    "delete from employee_table where employee_id > 999999; " +
                    "delete from user_table where user_id > 999999;";
            Statement statement = connection.createStatement();
            statement.executeQuery(sql);
        }catch (SQLException e){
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        //table_creator(); // Creates the tables
        table_populator();//populates the tables
        //table_depopulator();//depopulates the tables
        System.out.println();
    }
}
