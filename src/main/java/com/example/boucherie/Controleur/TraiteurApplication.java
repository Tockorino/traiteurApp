package com.example.boucherie.Controleur;

import com.example.boucherie.Views.TraiteurController;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TitledPane;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.ArrayList;

public class TraiteurApplication extends Application {

    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader1 = new FXMLLoader(TraiteurController.class.getResource("Traiteur-view.fxml"));
        Scene scene1 = new Scene(fxmlLoader1.load());
        stage.setTitle("bonjour je suis traiteur");
        stage.setScene(scene1);
        stage.show();

        FXMLLoader fxmlLoader2 = new FXMLLoader(TraiteurController.class.getResource("Balances-view.fxml"));
        Scene scene2 = new Scene(fxmlLoader2.load());
        Stage stage2 = new Stage();
        stage2.setTitle("Balances");
        stage2.setScene(scene2);
        stage2.show();

        FXMLLoader fxmlLoader3 = new FXMLLoader(TraiteurController.class.getResource("Commande-view.fxml"));
        Scene scene3 = new Scene(fxmlLoader3.load());
        Stage stage3 = new Stage();
        stage3.setTitle("Commande");
        stage3.setScene(scene3);
        stage3.show();



    }

    public static void main(String[] args) {
        launch();
    }
}