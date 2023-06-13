module com.climat.demo {
    requires javafx.controls;
    requires javafx.fxml;

    requires com.dlsc.formsfx;
    requires net.synedra.validatorfx;
    requires java.sql;

    opens com.climat.demo to javafx.fxml;
    exports com.climat.demo;
}