package com.example.traiteur.Views;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.control.Label;
import javafx.scene.layout.AnchorPane;

import java.io.Serializable;


public class ArticleListeController extends Node implements Serializable {
    @FXML
    private AnchorPane ArticleListeAnchor;
    @FXML
    private  Label PoidsLabel;
    @FXML
    private  Label NomLabel;
    @FXML
    private  Label PrixLabel;

    private String nomProduit;
    private String prixProduit;
    private String poidsProduit;


    public void initialize() {
        PoidsLabel.setText(poidsProduit);
        NomLabel.setText(nomProduit);
        PrixLabel.setText(prixProduit);
    }
    public ArticleListeController(String nomProduit, String prixProduit, String poidsProduit) {
        this.nomProduit = nomProduit;
        this.prixProduit = prixProduit;
        this.poidsProduit = poidsProduit;
    }

    @Override
    public Node getStyleableNode() {
        return super.getStyleableNode();
    }
}