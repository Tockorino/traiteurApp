/*
package com.example.boucherie.Controleur;

import com.example.boucherie.Models.Articles;
import com.example.boucherie.Models.Categories;
import com.example.boucherie.Views.TraiteurController;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TitledPane;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;


public class TraiteurApplication extends Application {


    public static List<Categories> categories = new ArrayList<>();

    @Override
    public void start(Stage stage) throws IOException {

        listeCategories();

        FXMLLoader fxmlLoader1 = new FXMLLoader(TraiteurController.class.getResource("Traiteur-view.fxml"));
        Scene scene1 = new Scene(fxmlLoader1.load());
        stage.setTitle("bonjour je suis traiteur");
        stage.setScene(scene1);
        stage.show();

        FXMLLoader fxmlLoader2 = new FXMLLoader(TraiteurController.class.getResource("Balances-view.fxml"));
        Scene scene2 = new Scene(fxmlLoader2.load());
        Stage stage2 = new Stage();
        stage2.setTitle("Balances");
        stage2.setScene(scene2);
        stage2.show();

        FXMLLoader fxmlLoader3 = new FXMLLoader(TraiteurController.class.getResource("Commande-view.fxml"));
        Scene scene3 = new Scene(fxmlLoader3.load());
        Stage stage3 = new Stage();
        stage3.setTitle("Commande");
        stage3.setScene(scene3);
        stage3.show();

        FXMLLoader fxmlLoader4 = new FXMLLoader(TraiteurController.class.getResource("Terminal-view.fxml"));
        Scene scene4 = new Scene(fxmlLoader4.load());
        Stage stage4 = new Stage();
        stage4.setTitle("Terminal");
        stage4.setScene(scene4);
        stage4.show();



    }

    private static void listeCategories() {
        Categories fruit = new Categories();
        fruit.setNom("Fruit");
        Categories plat = new Categories();
        plat.setNom("Plat");
        Categories viandes = new Categories();
        viandes.setNom("Viandes");

        Articles pomme = new Articles("pomme", 1.5f, true);
        fruit.articles.add (pomme);
        Articles poire = new Articles("poire", 1.5f, true);
        fruit.articles.add(poire);

        Articles tartiflette = new Articles("tartiflette", 1.5f, false);
        plat.articles.add(tartiflette);

        Articles poulet = new Articles("poulet", 1.5f, false);
        viandes.articles.add(poulet);

        categories.add(fruit);
        categories.add(plat);
        categories.add(viandes);
    }

    public static void main(String[] args) {
        launch();
    }
}*/
