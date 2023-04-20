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

    private ArrayList<ArrayList<Button>> categories = new ArrayList<ArrayList<Button>>();
    private ArrayList<Button> Viandes = new ArrayList<Button>();
    private ArrayList<Button> Fruits = new ArrayList<Button>();
    private ArrayList<Button> Plats = new ArrayList<Button>();
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



        Viandes.add(new Button("Viande"));
        Viandes.add(new Button("Steak"));
        Viandes.add(new Button("Carbonade"));
        Viandes.add(new Button("Ajouter un article"));

        Fruits.add(new Button("Volaille"));
        Fruits.add(new Button("Poulet"));
        Fruits.add(new Button("Dinde"));
        Fruits.add(new Button("Ajouter un article"));

        Plats.add(new Button("Accompagnement"));
        Plats.add(new Button("Pomme de terre"));
        Plats.add(new Button("Purrée"));
        Plats.add(new Button("Ajouter un article"));

        categories.add(Fruits);
        categories.add(Plats);
        categories.add(Viandes);


        for (ArrayList<Button> cat : categories) {
            TitledPane titledPane = new TitledPane();
            titledPane.setText(cat.get(0).getText());
            //VboxListeArticle.getChildren().add(titledPane);
            for (Button bouton : cat) {
                Button button = new Button(bouton.getText());
                titledPane.setContent(button);
            }

        }

    }

    public static void main(String[] args) {
        launch();
    }
}