package com.example.traiteur.Views;

import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyEvent;

public class BalanceController {

    private ProductInteraction productInteraction;
    @FXML
    private TextField TextFieldBalance;

    public void setProductInteraction(ProductInteraction productInteraction) {
        this.productInteraction = productInteraction;
    }

    private String poidsString = "0"; // Initialiser la variable poidsString avec une valeur par défaut



    @FXML
    public void initialize() {

        // Ajouter un EventHandler pour détecter le changement de texte dans le TextFieldBalance
        TextFieldBalance.addEventHandler(KeyEvent.KEY_RELEASED, new EventHandler<KeyEvent>() {

            @Override
            public void handle(KeyEvent event) {
                // Mettre à jour la variable poidsString avec le nouveau texte du TextFieldBalance
                poidsString = TextFieldBalance.getText()+ "g";

                if (productInteraction == null) {
                    System.out.println("IS NULL");
                } else {
                    productInteraction.nouvelleMasse(poidsString);
                }
            }
        });
    }




}