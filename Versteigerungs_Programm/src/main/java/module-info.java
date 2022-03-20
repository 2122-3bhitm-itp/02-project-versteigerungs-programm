module com.example.versteigerungs_programm {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.versteigerungs_programm to javafx.fxml;
    exports com.example.versteigerungs_programm;
}