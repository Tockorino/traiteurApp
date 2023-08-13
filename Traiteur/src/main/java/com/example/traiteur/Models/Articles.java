package com.example.traiteur.Models;

public class Articles {
    String nom;
    float prix;
    boolean pc;

    public Articles(String nom, float prix, boolean type) {
        this.nom = nom;
        this.prix = prix;
        this.pc = type;
    }



    public String getNom() {
        return nom;
    }

    public boolean getType() {
        return pc;
    }

    public Object getPrix() {
        return prix;
    }

}
