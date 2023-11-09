package com.example.Eval.modele;

public class Processeur {
    int id;
    String marque;
    String modele;
    int generation;
    double frequence;

    public Processeur() {
    }

    public Processeur(int id, String marque, String modele, int generation, double frequence) {
        this.id = id;
        this.marque = marque;
        this.modele = modele;
        this.generation = generation;
        this.frequence = frequence;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getMarque() {
        return marque;
    }

    public void setMarque(String marque) {
        this.marque = marque;
    }

    public String getModele() {
        return modele;
    }

    public void setModele(String modele) {
        this.modele = modele;
    }

    public int getGeneration() {
        return generation;
    }

    public void setGeneration(int generation) {
        this.generation = generation;
    }

    public double getFrequence() {
        return frequence;
    }

    public void setFrequence(double frequence) {
        this.frequence = frequence;
    }
}
