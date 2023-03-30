package com.example.boucherie.Views;

import javafx.fxml.FXML;
import javafx.scene.control.Label;

public class TraiteurController {
    @FXML
    private Label welcomeText;

    @FXML
    protected void onHelloButtonClick() {
        welcomeText.setText("Welcome to JavaFX Application!");
    }
}