module com.example.demo {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.demo to javafx.fxml;
    exports com.example.demo;
    exports vk2;
    opens vk2 to javafx.fxml;
    exports vk1;
    opens vk1 to javafx.fxml;
}