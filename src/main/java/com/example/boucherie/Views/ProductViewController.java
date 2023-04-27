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


    private ArrayList<ArrayList<String>> categories = new ArrayList<ArrayList<String>>();
    private ArrayList<String> Viandes = new ArrayList<String>();
    private ArrayList<String> Volailles = new ArrayList<String>();
    private ArrayList<String> Accompagnement = new ArrayList<String>();



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
        stage5.setTitle("Nouveaux Articles");
        stage5.setScene(scene5);
        stage5.show();

    }

    public void initialize() {


        Viandes.add("Viande");
        Viandes.add("Steak");
        Viandes.add("Carbonade");
        Viandes.add("Entrecôte");
        Viandes.add("Ajouter un article");

        Volailles.add("Volaille");
        Volailles.add("Poulet");
        Volailles.add("Dinde");
        Volailles.add("Ajouter un article");

        Accompagnement.add("Accompagnement");
        Accompagnement.add("Pomme de terre");
        Accompagnement.add("Purrée");
        Accompagnement.add("Patate douce");
        Accompagnement.add("Ajouter un article");



        categories.add(Accompagnement);
        categories.add(Volailles);
        categories.add(Viandes);

        for (int i = 0; i < categories.size(); i++) {
            TitledPane titledPane = new TitledPane();
            titledPane.setText(categories.get(i).get(0));
            titledPane.minWidth(400);
            titledPane.minHeight(500);
            FlowPane flowPane = new FlowPane();
            VboxListeArticle.getChildren().add(titledPane);
            titledPane.setContent(flowPane);
            for (int j = 1; j < categories.get(i).size(); j++) {
                Button ButtonArticle = new Button(categories.get(i).get(j));
                if(j==categories.get(i).size()-1){
                    ButtonArticle.setOnAction(event -> {
                        try {
                            OpenNouvelArticle(event);
                        } catch (IOException e) {
                            throw new RuntimeException(e);
                        }
                    });
                }
                else {
                   // ButtonArticle.setOnAction(event -> {
                     //   try {
                          //  ajouterArticleCommande(event);
                        //} catch (IOException e) {
                        //    throw new RuntimeException(e);
                      ///  }
                   // });
                }
                flowPane.getChildren().add(ButtonArticle);
            }

        }
    }
}

