package com.example.Eval.modele;

public class User
{
    int id;
    String nom;
    String email;
    String mdp;
    PointDeVente pointDeVente;

    public User() {
    }

    public User(int id, String nom, String email, String mdp, PointDeVente pointDeVente) {
        this.id = id;
        this.nom = nom;
        this.email = email;
        this.mdp = mdp;
        this.pointDeVente = pointDeVente;
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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getMdp() {
        return mdp;
    }

    public void setMdp(String mdp) {
        this.mdp = mdp;
    }

    public PointDeVente getPointDeVente() {
        return pointDeVente;
    }

    public void setPointDeVente(PointDeVente pointDeVente) {
        this.pointDeVente = pointDeVente;
    }
}
