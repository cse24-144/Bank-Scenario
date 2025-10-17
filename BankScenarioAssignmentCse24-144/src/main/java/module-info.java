module com.example.bankscenarioassignmentcse24144 {
    requires javafx.controls;
    requires javafx.fxml;

    requires org.controlsfx.controls;

    opens com.example.bankscenarioassignmentcse24144 to javafx.fxml;
    exports com.example.bankscenarioassignmentcse24144;
}