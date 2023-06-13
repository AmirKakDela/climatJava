package com.climat.demo.database;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class UserController {
    Statement statement;
    public UserController(Statement statement) {
        this.statement = statement;
    }

    public void login(String login, String password) throws SQLException {
        ResultSet rs = statement.executeQuery("SELECT * FROM users");
        while (rs.next()) {
            System.out.println(rs.getInt("user_id") + " " + rs.getString("user_login"));
        }
    }
}
