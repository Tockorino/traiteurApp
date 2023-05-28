package com.example.traiteur.Views;

import com.example.traiteur.Controller.TraiteurApplication;
import com.example.traiteur.Models.Articles;
import com.example.traiteur.Models.Categories;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TitledPane;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.io.IOException;

import static com.example.traiteur.Views.CommandeViewController.*;

public class ProductViewController {
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
    private VBox vboxListeArticle;
    @FXML
    void openNouvelArticle(ActionEvent event) throws IOException {
        FXMLLoader fxmlLoader5 = new FXMLLoader(TraiteurController.class.getResource("Nouvel-Article-view.fxml"));
        Scene scene5 = new Scene(fxmlLoader5.load());
        Stage stage5 = new Stage();
        stage5.setTitle("Nouveaux Articles");
        stage5.setScene(scene5);
        stage5.show();
    }
    public void initialize() {
        for(Categories cat : TraiteurApplication.categories){
            TitledPane titledPane = new TitledPane();
            titledPane.setText(cat.getNom());
            FlowPane flowPane = new FlowPane();
            vboxListeArticle.getChildren().add(titledPane);
            titledPane.setContent(flowPane);
            for(Articles article : cat.articles){
                Button buttonArticle = new Button(article.getNom());
                flowPane.getChildren().add(buttonArticle);
                //ajouter action
            }
            Button buttonNewArticle = new Button("Ajouter un article");
            buttonNewArticle.setOnAction(event -> {
                try {
                    openNouvelArticle(event);
                } catch (IOException e) {
                    System.err.println("problem");
                }
            });
            flowPane.getChildren().add(buttonNewArticle);
        }
        /*
        for (int i = 0; i < categories.size(); i++) {
            TitledPane titledPane = new TitledPane();
            titledPane.setText(categories.get(i).get(0));
            titledPane.minWidth(400);
            titledPane.minHeight(500);
            FlowPane flowPane = new FlowPane();
            vboxListeArticle.getChildren().add(titledPane);
            titledPane.setContent(flowPane);
            for (int j = 1; j < categories.get(i).size(); j++) {
                Button buttonArticle = new Button(categories.get(i).get(j));
                if(j==categories.get(i).size()-1){
                    buttonArticle.setOnAction(event -> {
                        try {
                            openNouvelArticle(event);
                        } catch (IOException e) {
                            throw new RuntimeException(e);
                        }
                    });
                }
                else {
                }
                flowPane.getChildren().add(buttonArticle);
            }

        }
        */
    }

    public void rechargerVue(){
        vboxListeArticle.getChildren().clear();
        initialize();
    }

    public void ajouterNouveauBoutonArticle(String nomArticle, double prix){
        Button nouveauArticle = new Button (nomArticle + " " + prix);
    }

    public void ajouterAuPanier(){
        String nomProduit = LabelNomProduit.getText();
        String prixProduit = LabelPrixProduit.getText();
        String poidsProduit = LabelPoidProduit.getText();

        CommandeViewController.ajouterProduit(nomProduit, prixProduit, poidsProduit);
    }
}

