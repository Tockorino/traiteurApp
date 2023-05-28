package com.example.traiteur.Views;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;

public class CommandeViewController {
    @FXML
    private static VBox VboxListeCommande;

    @FXML
    private Label labelCommandeTotal;

    public static void ajouterProduit(String nomProduit, String prixProduit, String poidsProduit) {
        AnchorPane nouveauProduit = new AnchorPane();

        // Création des labels pour le nom, le prix et le poids
        Label labelNom = new Label(nomProduit);
        Label labelPrix = new Label(prixProduit);
        Label labelPoids = new Label(poidsProduit);

        // Positionnement des labels dans l'AnchorPane
        AnchorPane.setTopAnchor(labelNom, 10.0);
        AnchorPane.setLeftAnchor(labelNom, 10.0);
        AnchorPane.setTopAnchor(labelPrix, 40.0);
        AnchorPane.setLeftAnchor(labelPrix, 10.0);
        AnchorPane.setTopAnchor(labelPoids, 70.0);
        AnchorPane.setLeftAnchor(labelPoids, 10.0);

        // Ajout des labels à l'AnchorPane
        nouveauProduit.getChildren().addAll(labelNom, labelPrix, labelPoids);

        VboxListeCommande.getChildren().add(nouveauProduit);
    }
}
