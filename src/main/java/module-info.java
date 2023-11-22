module com.example.proyectofinal {
    requires javafx.controls;
    requires javafx.fxml;
    requires poi;
    requires java.mail;


    opens com.example.proyectofinal to javafx.fxml;
    exports com.example.proyectofinal;
}