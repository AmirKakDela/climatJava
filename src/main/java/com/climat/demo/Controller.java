package com.climat.demo;

import com.climat.demo.database.DBConnection;
import com.climat.demo.database.UserController;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.IOException;
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
    void login(ActionEvent event) throws SQLException, IOException {
        String login = login_login.getText().trim();
        String password = login_password.getText().trim();
        System.out.println(login);

        if (!login.equals("") && !password.equals("")) {
            boolean isAuth = userController.login(login, password);
            if (isAuth) {
                login_login.getScene().getWindow().hide();
                openForm();
            }
        }

    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {

    }

    public void openForm() throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(Main.class.getResource("main.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 700, 500);
        Stage stage = new Stage();
        stage.setTitle("Система умного офиса");
        stage.setScene(scene);
        stage.show();
    }
}
