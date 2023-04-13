module com.example.mahin {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.mahin to javafx.fxml;
    exports com.example.mahin;
}