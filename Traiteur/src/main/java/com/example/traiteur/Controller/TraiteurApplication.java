package com.example.traiteur.Controller;

import com.example.traiteur.Models.Articles;
import com.example.traiteur.Models.Categories;
import com.example.traiteur.Views.TraiteurController;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;


public class TraiteurApplication extends Application {

    public static List<String> categorieListe = new ArrayList<>();
    public static boolean existe = false;
    public static List<Categories> categories = new ArrayList<>();
    public static File file = new File("ListeArticles.txt");
    @Override
    public void start(Stage stage) throws IOException {

        if(file.exists()) {
            listeCategories();
        }
        else{
            file.createNewFile();
        }

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

        try (BufferedReader br = new BufferedReader(new FileReader(file))) {
                String line = br.readLine();
                while(line != null) {
                    String categorieNom = line;
                    for (String cat : categorieListe) {
                        if (cat.equals(categorieNom)) {
                            existe = true;
                            break;
                        }
                    }
                    if (!existe) {
                        categorieListe.add(categorieNom);
                        //ajouter la liste de catégories
                        Categories cat = new Categories();
                        cat.setNom(categorieNom);
                        categories.add(cat);
                    }

                    String article = br.readLine();
                    String prix = br.readLine();
                    String piece = br.readLine();
                    Articles articles = new Articles(article, Float.parseFloat(prix), Boolean.parseBoolean(piece));
                    for (Categories cat : categories) {
                        if (cat.getNom().equals(categorieNom)) {
                            cat.articles.add(articles);
                            break;
                        }
                    }
                    existe = false;
                    line = br.readLine();
                }
        } catch (IOException ex) {
            throw new RuntimeException(ex);
        }


        /*
        // Création des catégories manuellement
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
        */
    }


        public static void main(String[] args) {
        launch();
    }



}