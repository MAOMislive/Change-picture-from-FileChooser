module com.example.irfan {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.maom to javafx.fxml;
    exports com.example.maom;
}