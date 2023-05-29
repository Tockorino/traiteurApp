package com.example.traiteur.Views;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;

public class CommandeViewController {
    public static float total = 0;
    @FXML
    private static VBox VboxListeCommande;
    @FXML
    private static Label labelCommandeTotal;

    public static void ajouterProduit(String nomProduit, String prixProduit, String poidsProduit) {
        ArticleListeController nouveauProduit = new ArticleListeController(nomProduit, prixProduit, poidsProduit);
        VboxListeCommande.getChildren().add(nouveauProduit);
        changeTotal(prixProduit);
    }

    private static void changeTotal(String prixProduit) {
        float prix = Float.parseFloat(prixProduit);
        total += prix;
        labelCommandeTotal.setText(String.valueOf(total));
    }
}
