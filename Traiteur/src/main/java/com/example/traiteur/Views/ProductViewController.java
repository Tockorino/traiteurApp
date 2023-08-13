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


public class ProductViewController implements ProductInteraction{

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

    public Articles selectedArticle;
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
        String poidsBal = "";


        for(Categories cat : TraiteurApplication.categories){
            TitledPane titledPane = new TitledPane();
            titledPane.setText(cat.getNom());
            FlowPane flowPane = new FlowPane();
            vboxListeArticle.getChildren().add(titledPane);
            titledPane.setContent(flowPane);
            for(Articles article : cat.articles){
                String type = article.getType() ? "€/pcs": "€/kg";
                Button buttonArticle = new Button(article.getNom() + " " + article.getPrix() + type);
                flowPane.getChildren().add(buttonArticle);
                buttonArticle.setUserData(article);
                selectedArticle = article;
                //ajouter action
                buttonArticle.setOnAction(event -> {
                    LabelNomProduit.setText(((Articles)buttonArticle.getUserData()).getNom());
                    selectedArticle = article;
                });
                this.informationArticle(buttonArticle);
               // selectedArticle = article;
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
    }

    private void informationArticle(Button article) {

        LabelNomProduit.setText(((Articles)article.getUserData()).getNom());



    }


    public void rechargerVue(){
        vboxListeArticle.getChildren().clear();
        initialize();
    }

    public void ajouterNouveauBoutonArticle(String nomArticle, double prix){
        Button nouveauArticle = new Button (nomArticle + " " + prix);
    }

    public void ajouterAuPanier() {
        try {
            CommandeViewController.ajouterProduit(LabelNomProduit.getText(), LabelPoidProduit.getText(), LabelPrixProduit.getText());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    @Override
    public void nouvelleMasse(String masse) {
        System.out.println(masse);

        // Convertir la chaîne 'masse' en double (ou float, si nécessaire)
        if (masse.length() > 0) {
            double masseNumerique = Double.parseDouble(masse);
            double prixArticle = ((Float) selectedArticle.getPrix()).doubleValue();
            double poidsEnKilo = masseNumerique / 1000.0; // Convertir le poids en grammes en kilogrammes
            System.out.println(prixArticle +"prix article");
            if (selectedArticle.getType() == true) {
                // Le prix est à la pièce
                double prixAuPiece = prixArticle * masseNumerique;
                LabelPrixProduit.setText(prixAuPiece + "€");
                LabelPoidProduit.setText(masse + "pcs");
            } else {
                // Le prix est au kilo
                double prixAuKilo = prixArticle * poidsEnKilo;
                LabelPrixProduit.setText(prixAuKilo + "€");
                LabelPoidProduit.setText(masse + "g");
            }
        }else {
            LabelPrixProduit.setText("0€");
        }
        // }
    }
}