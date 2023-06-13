package com.climat.demo;

import com.climat.demo.Models.ParamsModel;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TextField;

import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;

public class MainController implements Initializable {
    ParamsController paramsController = new ParamsController();

    @FXML
    private TextField airMax;

    @FXML
    private TextField airMin;

    @FXML
    private TextField tempMax;

    @FXML
    private TextField tempMin;

    @FXML
    private TextField wetMax;

    @FXML
    private TextField wetMin;

    @FXML
    void save(ActionEvent event) {

    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        try {
            ParamsModel paramsModel = paramsController.getParams(1);
            setTextFields(paramsModel);
            System.out.println(paramsModel.getAirMax());
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public void setTextFields(ParamsModel paramsModel) {
        airMax.setText(paramsModel.getAirMax());
        airMin.setText(paramsModel.getAirMin());
        tempMin.setText(paramsModel.getTempMin());
        tempMax.setText(paramsModel.getTempMax());
        wetMin.setText(paramsModel.getWetMin());
        wetMax.setText(paramsModel.getWetMax());
    }
}
