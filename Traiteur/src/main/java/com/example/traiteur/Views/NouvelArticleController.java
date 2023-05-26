package com.example.traiteur.Views;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;

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

    public void initialize() {
        prixToggleGroup = new ToggleGroup();
        RadioButtonKilo.setToggleGroup(prixToggleGroup);
        RadioButtonPiece.setToggleGroup(prixToggleGroup);
    }

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
        }else{
            System.out.println("Erreur lors de l'ajout");
        }
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

