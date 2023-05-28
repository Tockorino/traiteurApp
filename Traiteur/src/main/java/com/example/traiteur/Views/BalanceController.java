package com.example.traiteur.Views;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

public class BalanceController {

    @FXML
    private TextField TextFieldBalance;

    public String getPoids() {
        return TextFieldBalance.getText();
    }
}
