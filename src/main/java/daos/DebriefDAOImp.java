package daos;

import Util.DatabaseConnection;
import customexceptions.DebriefNotFound;
import entities.Debrief;

import java.sql.*;
import java.time.LocalDate;
import java.time.LocalDateTime;

public class DebriefDAOImp implements DebriefDAO{

    @Override
    public int maxCreator(){
        try (Connection connection = DatabaseConnection.createConnection()) {
            String sql = "select max(debriefing_id) as highest_debriefing_id from debriefing_table";
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(sql);
            int returned_index = 1001;
            if (resultSet.next()){
                returned_index = resultSet.getInt("highest_debriefing_id");
            }
            System.out.println(returned_index);
            return returned_index + 1;
        }catch (SQLException e){
            e.printStackTrace();
            return -1;
        }
    }

    //Need to add a static method for counter
    int debrief_id_counter = this.maxCreator();


    @Override
    public Debrief getDebrief(int debriefing_id) {
        try (Connection connection = DatabaseConnection.createConnection()) {

            String sql = "select * from debriefing_table where debriefing_id = ?";
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1, debriefing_id);
            ResultSet resultSet = preparedStatement.executeQuery();
            if(resultSet.next()) {
                return new Debrief(
                        resultSet.getInt("debriefing_id"),
                        resultSet.getInt("employee_id"),
                        resultSet.getString("debriefing_text"),
                        resultSet.getDate("date_of_occurrence").toLocalDate(),
                        resultSet.getString("location_of_occurrence"),
                        resultSet.getTimestamp("datetime_of_creation").toLocalDateTime()
                );
            }else{
                throw new DebriefNotFound("The debrief was not found.");
            }
        } catch (SQLException e){
            e.printStackTrace();
            return null;
        }
    }

    @Override
    public Debrief createDebrief(Debrief debrief) {
        debrief.setDebriefingId(this.debrief_id_counter);
        this.debrief_id_counter += 1;

        try (Connection connection = DatabaseConnection.createConnection()) {

            String sql = "insert into debriefing_table values(?, ?, ?, ?, ?, ?);";
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1, debrief.getDebriefingId());
            preparedStatement.setInt(2, debrief.getEmployeeId());
            preparedStatement.setString(3, debrief.getDebriefingText());
            preparedStatement.setDate(4, Date.valueOf(debrief.getDateOfOccurrence()));
            preparedStatement.setString(5, debrief.getLocationOfOccurrence());
            preparedStatement.setTimestamp(6, Timestamp.valueOf(debrief.getDateTimeOfCreation()));
            preparedStatement.execute();
            return debrief;
        }catch (SQLException e){
            e.printStackTrace();
            return null;
        }

    }
}
