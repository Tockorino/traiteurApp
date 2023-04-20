package com.example.boucherie.Views;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TitledPane;
import javafx.scene.layout.AnchorPane;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.ArrayList;

public class ProductViewController {


    private ArrayList<ArrayList<Button>> categories = new ArrayList<ArrayList<Button>>();
    private ArrayList<Button> Viandes = new ArrayList<Button>();
    private ArrayList<Button> Fruits = new ArrayList<Button>();
    private ArrayList<Button> Plats = new ArrayList<Button>();



    @FXML
    private AnchorPane anchorPane;

    @FXML
    private Button ButtonAjouter;

    @FXML
    private Label LabelNomProduit;

    @FXML
    private Label LabelPoidProduit;

    @FXML
    private Label LabelPrixProduit;

    @FXML
    private VBox VboxListeArticle;

    @FXML
    void OpenNouvelArticle(ActionEvent event) throws IOException {
        FXMLLoader fxmlLoader5 = new FXMLLoader(TraiteurController.class.getResource("Nouvel-Article-view.fxml"));
        Scene scene5 = new Scene(fxmlLoader5.load());
        Stage stage5 = new Stage();
        stage5.setTitle("Nouveaux Article");
        stage5.setScene(scene5);
        stage5.show();

    }

    public void initialize() {


        Viandes.add(new Button("Viande"));
        Viandes.add(new Button("Steak"));
        Viandes.add(new Button("Carbonade"));
        Viandes.add(new Button("Ajouter un article"));

        Fruits.add(new Button("Fruits"));
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
            VboxListeArticle.getChildren().add(titledPane);
            for (Button bouton : cat) {
                Button button = new Button(bouton.getText());
                titledPane.setContent(button);
            }

        }
    }
}

