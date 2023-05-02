package com.example.boucherie.Models;

import java.util.List;

public class Categories {

    String nom;
    public List<Articles> articles;

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getNom() {
        return nom;
    }
}
