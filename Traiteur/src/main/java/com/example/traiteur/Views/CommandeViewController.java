package com.example.traiteur.Views;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.control.Label;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.VBox;
import java.io.IOException;

public class CommandeViewController {
    public static float total = 0;
    @FXML
    private static VBox VboxListeCommande;
    @FXML
    private static Label labelCommandeTotal;

    public CommandeViewController() {
    }

    public static void ajouterProduit(String nomProduit, String prixProduit, String poidsProduit) throws IOException {
        AnchorPane anchorPane = new AnchorPane();

        FXMLLoader loader = new FXMLLoader(ArticleListeController.class.getResource("ArticleListe-view.fxml"));
        Parent p = loader.load();
        ArticleListeController controller = loader.getController();
        ArticleListeController nouveauProduit = new ArticleListeController(nomProduit, prixProduit, poidsProduit);
        anchorPane.getChildren().add(nouveauProduit);
        VboxListeCommande.getChildren().add(anchorPane);

        /*try {
            FXMLLoader loader = new FXMLLoader(ArticleListeController.class.getResource("ArticleListe-view.fxml"));
            Parent p = loader.load();
            ArticleListeController controller = loader.getController();
            ArticleListeController nouveauProduit = new ArticleListeController(nomProduit, prixProduit, poidsProduit);
            VboxListeCommande.getChildren().add(nouveauProduit);
            changeTotal(prixProduit);
        } catch (IOException e) {
            Label label = new Label("Erreur lors de l'ajout du produit");
            VboxListeCommande.getChildren().add(label);

        }*/
    }

    private static void changeTotal(String prixProduit) {
        float prix = Float.parseFloat(prixProduit);
        total += prix;
        labelCommandeTotal.setText(String.valueOf(total));
    }
}
