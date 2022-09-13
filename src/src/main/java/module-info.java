module com.example.src {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.src to javafx.fxml;
    exports com.example.src;
}