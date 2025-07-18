module org.example.encomendanotifier {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.sql;

    opens org.example.encomendanotifier to javafx.fxml;
    opens org.example.encomendanotifier.Controller to javafx.fxml;
    opens org.example.encomendanotifier.Model to javafx.base;

    exports org.example.encomendanotifier;
    exports org.example.encomendanotifier.Controller;
}
