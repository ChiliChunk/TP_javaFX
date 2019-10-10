module com.mycompany.tp1 {
    requires javafx.controls;
    requires javafx.fxml;

    opens com.mycompany.tp1 to javafx.fxml;
    exports com.mycompany.tp1;
}