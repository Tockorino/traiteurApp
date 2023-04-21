package com.example.boucherie.Views;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.TitledPane;
import javafx.scene.layout.AnchorPane;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.ArrayList;

public class ProductViewController {


    private ArrayList<ArrayList<Button>> categories = new ArrayList<ArrayList<Button>>();
    private ArrayList<Button> Viandes = new ArrayList<Button>();
    private ArrayList<Button> Volailles = new ArrayList<Button>();
    private ArrayList<Button> Accompagnement = new ArrayList<Button>();



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
        Viandes.add(new Button("Entrecôte"));
        Viandes.add(new Button("Ajouter un article"));

        Volailles.add(new Button("Volaille"));
        Volailles.add(new Button("Poulet"));
        Volailles.add(new Button("Dinde"));
        Volailles.add(new Button("Ajouter un article"));

        Accompagnement.add(new Button("Accompagnement"));
        Accompagnement.add(new Button("Pomme de terre"));
        Accompagnement.add(new Button("Purrée"));
        Accompagnement.add(new Button("Patate douce"));
        Accompagnement.add(new Button("Ajouter un article"));



        categories.add(Accompagnement);
        categories.add(Volailles);
        categories.add(Viandes);

        for (int i = 0; i < categories.size(); i++) {
            TitledPane titledPane = new TitledPane();
            titledPane.setText(categories.get(i).get(0).getText());
            titledPane.minWidth(400);
            titledPane.minHeight(500);
            FlowPane flowPane = new FlowPane();
            VboxListeArticle.getChildren().add(titledPane);
            titledPane.setContent(flowPane);
            for (int j = 1; j < categories.get(i).size(); j++) {
                flowPane.getChildren().add(categories.get(i).get(j));
            }

        }
    }
}

