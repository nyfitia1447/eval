package com.example.Eval.modele;

public class Marque
{
    int id;
    String nom;

    public Marque() {
    }

    public Marque(String nom) {
        this.nom = nom;
    }

    public Marque(int id, String nom) {
        this.id = id;
        this.nom = nom;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }
}
