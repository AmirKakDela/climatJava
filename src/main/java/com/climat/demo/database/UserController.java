package com.climat.demo.database;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class UserController {
    Statement statement;

    public UserController(Statement statement) {
        this.statement = statement;
    }

    public boolean login(String login, String password) throws SQLException {
        ResultSet rs = statement.executeQuery("SELECT *\n" +
                "FROM users\n" +
                "WHERE user_login = '" + login + "' AND user_password = '" + password + "'");
        while (rs.next()) {
            System.out.println(rs.getInt("user_id") + " " + rs.getString("user_login"));
            return true;
        }
        return false;
    }
}
