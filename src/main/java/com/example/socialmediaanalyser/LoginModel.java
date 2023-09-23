package com.example.socialmediaanalyser;

import java.sql.*;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.*;
import java.sql.DriverManager;

public class LoginModel {
    Connection connection;

    public LoginModel() throws SQLException {
        connection = DatabaseConnection.getConnection();
        if (connection == null) {
            System.exit(1);
        }
    }

    public boolean isDbConnected() {
        try {
            return !connection.isClosed();
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    public boolean isLogin(String user, String pass) throws SQLException {
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        String query = "select * from Login where UserName = ? and password = ?";

        try {
            preparedStatement = connection.prepareStatement(query);
            preparedStatement.setString(1, user);
            preparedStatement.setString(2, pass);

            resultSet = preparedStatement.executeQuery();

            if (resultSet.next()) {
                return true;
            } else {
                return false;
            }

        } catch (Exception e) {
            return false;
        } finally {
            preparedStatement.close();
            resultSet.close();
        }
    }
}
