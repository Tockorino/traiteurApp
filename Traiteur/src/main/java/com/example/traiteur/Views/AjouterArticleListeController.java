package com.example.traiteur.Views;

import javafx.fxml.FXML;
import javafx.scene.control.Label;

public class AjouterArticleListeController {

    @FXML
    private Label LabelNomProduitListe;

    @FXML
    private Label LabelPoidsProduitListe;

    @FXML
    private Label LabelPrixProduitListe;

    public void setArticleDetails(String nomProduit, String prixProduit, String poidsProduit){
        LabelNomProduitListe.setText(nomProduit);
        LabelPrixProduitListe.setText(prixProduit);
        LabelPoidsProduitListe.setText(poidsProduit);
    }
}
