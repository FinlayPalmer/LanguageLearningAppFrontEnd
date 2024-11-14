module com.languageapp {
    requires javafx.controls;
    requires javafx.fxml;

    opens com.languageapp to javafx.fxml;
    exports com.languageapp;
}
