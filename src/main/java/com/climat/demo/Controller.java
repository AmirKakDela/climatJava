package com.climat.demo;

import com.climat.demo.database.DBConnection;
import com.climat.demo.database.UserController;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TextField;

import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;

public class Controller implements Initializable {

    UserController userController = new UserController(DBConnection.getInstance().getStatement());

    @FXML
    private TextField login_login;

    @FXML
    private TextField login_password;

    @FXML
    void login(ActionEvent event) throws SQLException {
        String login = login_login.getText();
        String password = login_password.getText();
        System.out.println(login);
        userController.login(login, password);
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {

    }
}
