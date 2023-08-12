package com.example.traiteur.Views;

import javafx.fxml.FXML;

public class TraiteurController {

    @FXML
    private ProductViewController ProductViewController;

    private CommandeViewController CommandeViewController;

    public ProductViewController getProductViewController() {
        return this.ProductViewController;
    }

    public CommandeViewController getCommandeViewController() {
        return this.CommandeViewController;
    }
}

