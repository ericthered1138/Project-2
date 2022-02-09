package com.shield.util;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class InsertImage {

    public static void insertEmployeeImage(int employee_id, File file) {
        try (Connection connection = DatabaseConnection.createConnection()) {

            FileInputStream fileInputStream = new FileInputStream(file);
            String sql = "INSERT INTO employee_picture_table VALUES (default, ?, ?)";
            PreparedStatement preparedStatment = connection.prepareStatement(sql);
            preparedStatment.setInt(1, employee_id);
            preparedStatment.setBinaryStream(2, fileInputStream, file.length());
            preparedStatment.executeUpdate();
        } catch (SQLException | FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        File file = new File("Pictures/Agent 1.gif");
        int employee_id = 1;
        insertEmployeeImage(employee_id, file);//for manually adding images to the database
    }
}
