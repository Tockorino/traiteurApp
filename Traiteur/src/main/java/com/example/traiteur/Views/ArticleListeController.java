package com.example.traiteur.Views;

import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.control.Label;
import javafx.scene.layout.AnchorPane;

import java.io.Serializable;

public class ArticleListeController extends Node implements Serializable {
    @FXML
    private AnchorPane ArticleListeAnchor;
    @FXML
    private static Label NomLabel;
    @FXML
    private static Label PoidsLabel;
    @FXML
    private static Label PrixLabel;

    public ArticleListeController() {
        NomLabel.setText("nomProduit");
        PrixLabel.setText("prixProduit");
        PoidsLabel.setText("poidsProduit");
    }
    public ArticleListeController(String nomProduit, String prixProduit, String poidsProduit) {
        NomLabel.setText(nomProduit);
        PrixLabel.setText(prixProduit);
        PoidsLabel.setText(poidsProduit);
    }
    @Override
    public Node getStyleableNode() {
        return super.getStyleableNode();
    }
}
