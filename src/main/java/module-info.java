module com.example.gange {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.gange to javafx.fxml;
    exports com.example.gange;
}