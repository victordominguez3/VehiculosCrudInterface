module com.example.vehiculoscrudinterface {
    requires javafx.controls;
    requires javafx.fxml;
    requires kotlin.stdlib;


    opens com.example.vehiculoscrudinterface to javafx.fxml;
    exports com.example.vehiculoscrudinterface;
}