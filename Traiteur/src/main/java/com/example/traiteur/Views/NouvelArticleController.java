package com.example.traiteur.Views;

import com.example.traiteur.Controller.TraiteurApplication;
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

        ButtonAjouterArticle.setOnAction(event -> {
            ajouterArticle();
        });
        ButtonAnnulerArticle.setOnAction(event -> {
            closeStage();
        });
    }
// Ajouter un article dans le fichier texte
    public void ajouterArticle(){
        String catégorie = "nouvelle catgorie";
        String nomArticle = TextNom.getText();
        float prix = Float.parseFloat(TextPrix.getText());
        boolean typePrix;

        if (RadioButtonKilo.isSelected()){
            typePrix = false;
        } else {
            typePrix = true;
        }

        TraiteurApplication.ajouterArticle(catégorie, nomArticle, prix, typePrix);



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

