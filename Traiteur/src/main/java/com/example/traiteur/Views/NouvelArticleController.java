package com.example.traiteur.Views;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import javafx.stage.Stage;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;


public class NouvelArticleController {

    @FXML
    private Button ButtonAjouterArticle;

    @FXML
    private Button ButtonAnnulerArticle;

    @FXML
    private RadioButton RadioButtonKilo;

    @FXML
    private RadioButton RadioButtonPiece;

    @FXML
    private TextField TextNom;

    @FXML
    private TextField TextPrix;

    private ToggleGroup prixToggleGroup;
//Fonstion pour choisir si le prix est au kilo ou à la pièce
    public void initialize() {
        prixToggleGroup = new ToggleGroup();
        RadioButtonKilo.setToggleGroup(prixToggleGroup);
        RadioButtonPiece.setToggleGroup(prixToggleGroup);
    }
// Ajouter un article dans le fichier texte
    public void ajouterArticle(){
        String nomArticle = TextNom.getText();
        double prix = Double.parseDouble(TextPrix.getText());
        String typePrix;

        if (RadioButtonKilo.isSelected()){
            typePrix = "Prix au poids";
        } else {
            typePrix = "Prix  à la quantité";
        }

        String donneesArticle = nomArticle + " " + prix + " " + typePrix;

        if (writeDataToFile("ListeArticles.txt", donneesArticle)) {
            System.out.println("Article ajouté");

            // fonction pour ajouter un nouvel article dans ProductViewController
            try {
                FXMLLoader loader = new FXMLLoader(getClass().getResource("Product-view.fxml"));
                Parent root = loader.load();
                ProductViewController ProductViewController = loader.getController();
                ProductViewController.ajouterNouveauBoutonArticle(nomArticle, prix);

                Stage stage = new Stage();
                stage.setScene(new Scene(root));
                stage.show();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }else{
            System.out.println("Erreur lors de l'ajout");
        }
    }
// Fermer la fenêtre si on annule l'ajout d'un article
    public void closeStage(){
        Stage stage = (Stage) TextNom.getScene().getWindow();
        stage.close();
    }
    private boolean writeDataToFile( String file, String donneesArticle){
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(file, true))){
            writer.write(donneesArticle);
            writer.newLine();
            return  true;
        } catch (IOException e) {
            System.out.println("Erreur lors de l'écriture'");
            e.printStackTrace();
            return false;
        }
    }

}

