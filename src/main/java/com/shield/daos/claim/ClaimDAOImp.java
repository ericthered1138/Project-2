package com.shield.daos.claim;

import com.shield.customexceptions.ClaimNotFound;
import com.shield.entities.Claim;
import com.shield.Util.DatabaseConnection;

//import org.openqa.selenium.devtools.v85.database.Database;

import java.sql.*;
import java.time.LocalDateTime;

public class ClaimDAOImp implements ClaimDAO {
    @Override
    public int maxCreator() {
        try (Connection connection = DatabaseConnection.createConnection()) {
            String sql = "select max(claim_id) as highest_claim_id from claim_table";
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(sql);
            int returned_index = 1001;
            if (resultSet.next()){
                returned_index = resultSet.getInt("highest_claim_id");
            }
            System.out.println(returned_index);
            return returned_index + 1;
        }catch (SQLException e){
            e.printStackTrace();
            return -1;
        }
    }

    //Need to add a static method for counter
    int claim_id_counter = this.maxCreator();

    @Override
    public Claim getClaimById(int claimId) {
        try (Connection connection = DatabaseConnection.createConnection()){
            String sql = "select * from claim_table where claim_id = ?";
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1, claimId);
            ResultSet resultSet = preparedStatement.executeQuery();
            if(resultSet.next()){
                return new Claim(
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
            } else{
                throw new ClaimNotFound("Claim not found");
            }
        }
        catch (SQLException e){
            e.printStackTrace();
            return null;
        }
    }
    @Override
    public Claim createClaim(Claim claim) {
        claim.setClaimId(this.claim_id_counter);
        this.claim_id_counter++;
        claim.setDateTimeOfCreation(Timestamp.valueOf(LocalDateTime.now()).toString());

        try (Connection connection = DatabaseConnection.createConnection()){
            String sql = "insert into claim_table values(?, ? ,?, ?, ?, ?, ? ,?, ?, ?)";
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1, claim.getClaimId());
            preparedStatement.setInt(2, claim.getUserId());
            preparedStatement.setInt(3, claim.getEmployeeId());
            preparedStatement.setFloat(4, claim.getAmount());
            preparedStatement.setString(5, claim.getDescription());
            preparedStatement.setDate(6, Date.valueOf(claim.getDateOfOccurrence()));
            preparedStatement.setString(7, claim.getLocationOfOccurrence());
            preparedStatement.setTimestamp(8, Timestamp.valueOf(claim.getDateTimeOfCreation()));
            preparedStatement.setString(9, "pending");
            preparedStatement.setString(10, claim.getHandlerComment());
            preparedStatement.execute();
            return claim;
        }
        catch (SQLException e) {
            e.printStackTrace();
            return null;
        }

    }

    @Override
    public Claim approveClaim(int claimId, String handlerComment) {
        try(Connection connection = DatabaseConnection.createConnection()){
            String sql = "update claim_table set approval = 'approved', handler_comment = ? where claim_id = ?";
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, handlerComment);
            preparedStatement.setInt(2, claimId);
            preparedStatement.execute();
            return getClaimById(claimId);
        }
        catch (SQLException e){
            e.printStackTrace();
            return null;
        }
    }

    @Override
    public Claim denyClaim(int claimId, String handlerComment) {
        try(Connection connection = DatabaseConnection.createConnection()){
            String sql = "update claim_table set approval = 'denied', handler_comment = ? where claim_id = ?";
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, handlerComment);
            preparedStatement.setInt(2, claimId);
            preparedStatement.execute();
            return getClaimById(claimId);
        }
        catch (SQLException e){
            e.printStackTrace();
            return null;
        }
    }
}
