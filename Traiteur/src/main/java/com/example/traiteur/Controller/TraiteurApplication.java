package com.example.traiteur.Controller;

import com.example.traiteur.Models.Articles;
import com.example.traiteur.Models.Categories;
import com.example.traiteur.Views.TraiteurController;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;


public class TraiteurApplication extends Application {


    public static List<Categories> categories = new ArrayList<>();

    @Override
    public void start(Stage stage) throws IOException {

        listeCategories();
        System.out.println(TraiteurController.class.getResource(""));
        FXMLLoader fxmlLoader1 = new FXMLLoader(TraiteurController.class.getResource("Traiteur-view.fxml"));
        Scene scene1 = new Scene(fxmlLoader1.load());
        stage.setTitle("bonjour je suis traiteur");
        stage.setScene(scene1);
        stage.show();

        FXMLLoader fxmlLoader2 = new FXMLLoader(TraiteurController.class.getResource("Balance-view.fxml"));
        Scene scene2 = new Scene(fxmlLoader2.load());
        Stage stage2 = new Stage();
        stage2.setTitle("Balance");
        stage2.setScene(scene2);
        stage2.show();







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
}