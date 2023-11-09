package com.example.Eval.modele;

public class Laptop
{
    int id;
    Marque marque;
    String references;
    Processeur processeur;
    double ram;
    DisqueDur disqueDur;
    double ecran;
    double prix;

    public Laptop() {
    }

    public Laptop(int id, Marque marque, String references, Processeur processeur, double ram, DisqueDur disqueDur, double ecran, double prix) {
        this.id = id;
        this.marque = marque;
        this.references = references;
        this.processeur = processeur;
        this.ram = ram;
        this.disqueDur = disqueDur;
        this.ecran = ecran;
        this.prix = prix;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Marque getMarque() {
        return marque;
    }

    public void setMarque(Marque marque) {
        this.marque = marque;
    }

    public String getReferences() {
        return references;
    }

    public void setReferences(String references) {
        this.references = references;
    }

    public Processeur getProcesseur() {
        return processeur;
    }

    public void setProcesseur(Processeur processeur) {
        this.processeur = processeur;
    }

    public double getRam() {
        return ram;
    }

    public void setRam(double ram) {
        this.ram = ram;
    }

    public DisqueDur getDisqueDur() {
        return disqueDur;
    }

    public void setDisqueDur(DisqueDur disqueDur) {
        this.disqueDur = disqueDur;
    }

    public double getEcran() {
        return ecran;
    }

    public void setEcran(double ecran) {
        this.ecran = ecran;
    }

    public double getPrix() {
        return prix;
    }

    public void setPrix(double prix) {
        this.prix = prix;
    }
}
