package com.example.Eval.modele;

public class DisqueDur {
    int id;
    String type;
    double capacite;

    public DisqueDur() {
    }

    public DisqueDur(int id, String type, double capacite) {
        this.id = id;
        this.type = type;
        this.capacite = capacite;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public double getCapacite() {
        return capacite;
    }

    public void setCapacite(double capacite) {
        this.capacite = capacite;
    }
}
