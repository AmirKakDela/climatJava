package com.climat.demo;

import com.climat.demo.Models.ParamsModel;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.scene.text.Text;

import java.net.URL;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;
import java.util.ResourceBundle;

public class MainController implements Initializable {

    ParamsController paramsController = new ParamsController();

    @FXML
    private TextField realAir;

    @FXML
    private TextField realTemp;

    @FXML
    private TextField realWet;

    @FXML
    private ListView<TimeOfDay> timeOfDay;

    @FXML
    private ListView<TimeOfYear> timeOfYear;

    @FXML
    private ListView<Fullness> fullness;

    @FXML
    private ListView<SystemPower> systemPower;

    @FXML
    private TextField suggestTempMin;

    @FXML
    private TextField suggestTempMax;

    @FXML
    private TextField suggestWetMin;

    @FXML
    private TextField suggestWetMax;

    @FXML
    private TextField suggestAirMin;

    @FXML
    private TextField suggestAirMax;

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
    private Text date;

    @FXML
    void save(ActionEvent event) {
        System.out.println("save");
        paramsController.save(getParamsModel());
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        initializeLists();
        setListenersOnLists();
        setSuggestParamsByListValues();
        setRandomRealValues();
        try {
            ParamsModel paramsModel = paramsController.getParams(1);
            setTextFields(paramsModel);
            Date currentDate = new Date();
            SimpleDateFormat dateFormat = new SimpleDateFormat("dd.MM.yyyy HH:mm");
            String formattedDate = dateFormat.format(currentDate);
            date.setText(formattedDate);
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

    public ParamsModel getParamsModel() {
        ParamsModel paramsModel = new ParamsModel();

        paramsModel.setAirMin(airMin.getText());
        paramsModel.setAirMax(airMax.getText());
        paramsModel.setTempMin(tempMin.getText());
        paramsModel.setTempMax(tempMax.getText());
        paramsModel.setWetMin(wetMin.getText());
        paramsModel.setWetMax(wetMax.getText());

        return paramsModel;
    }

    public void close(ActionEvent actionEvent) {
        date.getScene().getWindow().hide();
    }

    public void setListenersOnLists() {
        timeOfYear.getSelectionModel().select(RoomEnvironmentRecommendation.getCurrentSeason());
        timeOfDay.getSelectionModel().select(RoomEnvironmentRecommendation.getCurrentTimeOfDay());
        fullness.getSelectionModel().select(Fullness.Низкая);
        systemPower.getSelectionModel().select(SystemPower.Средняя);
    }

    public void setSuggestParamsByListValues() {
        TimeOfDay currentTimeOfDay = timeOfDay.getSelectionModel().getSelectedItem();
        TimeOfYear currentTimeOfYear = timeOfYear.getSelectionModel().getSelectedItem();
        SystemPower currentSystemPower = systemPower.getSelectionModel().getSelectedItem();
        Fullness currentFullness = fullness.getSelectionModel().getSelectedItem();

        int[] recommendedTemperature = RoomEnvironmentRecommendation.getRecommendedTemperature(currentTimeOfDay, currentTimeOfYear);
        suggestTempMin.setText(String.valueOf(recommendedTemperature[0]));
        suggestTempMax.setText(String.valueOf(recommendedTemperature[1]));

        int[] recommendedWet = RoomEnvironmentRecommendation.getRecommendedWet(currentTimeOfYear, currentSystemPower);
        suggestWetMin.setText(String.valueOf(recommendedWet[0]));
        suggestWetMax.setText(String.valueOf(recommendedWet[1]));

        int[] recommendedAir = RoomEnvironmentRecommendation.getRecommendedAirQuality(currentTimeOfYear, currentFullness);
        suggestAirMin.setText(String.valueOf(recommendedAir[0]));
        suggestAirMax.setText(String.valueOf(recommendedAir[1]));
    }

    public void initializeLists() {
        // Инициализация списка timeOfDay
        ObservableList<TimeOfDay> timeOfDayList = FXCollections.observableArrayList(TimeOfDay.values());
        timeOfDay.setItems(timeOfDayList);

        // Инициализация списка timeOfYear
        ObservableList<TimeOfYear> timeOfYearList = FXCollections.observableArrayList(TimeOfYear.values());
        timeOfYear.setItems(timeOfYearList);

        // Инициализация списка fullness
        ObservableList<Fullness> fullnessList = FXCollections.observableArrayList(Fullness.values());
        fullness.setItems(fullnessList);

        // Инициализация списка systemPower
        ObservableList<SystemPower> systemPowerList = FXCollections.observableArrayList(SystemPower.values());
        systemPower.setItems(systemPowerList);

        timeOfYear.getSelectionModel().selectedItemProperty().addListener((observable, oldValue, newValue) -> {
            setSuggestParamsByListValues();
        });
        timeOfDay.getSelectionModel().selectedItemProperty().addListener((observable, oldValue, newValue) -> {
            setSuggestParamsByListValues();
        });
        systemPower.getSelectionModel().selectedItemProperty().addListener((observable, oldValue, newValue) -> {
            setSuggestParamsByListValues();
        });
        fullness.getSelectionModel().selectedItemProperty().addListener((observable, oldValue, newValue) -> {
            setSuggestParamsByListValues();
        });
    }

    public void setRandomRealValues() {
        Random random = new Random();

        // Генерация случайного значения для влажности (от 40 до 60)
        int humidity = random.nextInt(21) + 40;
        realWet.setText(String.valueOf(humidity));

        // Генерация случайного значения для температуры (от 18 до 25)
        int temperature = random.nextInt(8) + 18;
        realTemp.setText(String.valueOf(temperature));

        // Генерация случайного значения для качества воздуха (от 30 до 90)
        int airQuality = random.nextInt(61) + 30;
        realAir.setText(String.valueOf(airQuality));
    }
}
