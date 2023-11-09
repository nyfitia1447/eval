package com.example.Eval.modele;

public class PointDeVente
{
    int id;
    String nom;
    String lieu;

    public PointDeVente() {
    }

    public PointDeVente(int id, String nom, String lieu) {
        this.id = id;
        this.nom = nom;
        this.lieu = lieu;
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

    public String getLieu() {
        return lieu;
    }

    public void setLieu(String lieu) {
        this.lieu = lieu;
    }
}
