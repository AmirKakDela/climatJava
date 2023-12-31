package com.climat.demo;

import com.climat.demo.database.DBConnection;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class Main extends Application {
    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(Main.class.getResource("view.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 700, 500);
        stage.setTitle("Система умного офиса");
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        DBConnection.getInstance();
        launch();
    }

}