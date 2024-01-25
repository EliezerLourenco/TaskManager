module com.example.javaintroproject {
    requires javafx.controls;
    requires javafx.fxml;

    opens com.example.javaintroproject.controller to javafx.fxml;
    opens com.example.javaintroproject.model to javafx.base; // Add this line

    exports com.example.javaintroproject;
    exports com.example.javaintroproject.controller;
    exports com.example.javaintroproject.model; // This is optional, only if you want to export the model package
}
