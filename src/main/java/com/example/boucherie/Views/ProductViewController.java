package com.example.boucherie.Views;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.io.IOException;

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
    private VBox VboxListeArticle;

    @FXML
    void OpenNouvelArticle(ActionEvent event) throws IOException {
            // Charger le fichier FXML "Nouvel-Article.fxml"
            Parent root = FXMLLoader.load(getClass().getResource("Nouvel-Article.fxml"));



    }
}

