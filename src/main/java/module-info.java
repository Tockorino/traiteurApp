module com.example.boucherie {
    requires javafx.controls;
    requires javafx.fxml;

    requires org.controlsfx.controls;
    requires com.dlsc.formsfx;
    requires net.synedra.validatorfx;

    opens com.example.boucherie to javafx.fxml;
    exports com.example.boucherie.Controleur;
    opens com.example.boucherie.Controleur to javafx.fxml;
    exports com.example.boucherie.Views;
    opens com.example.boucherie.Views to javafx.fxml;
}