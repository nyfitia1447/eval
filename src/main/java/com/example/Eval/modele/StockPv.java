package com.example.Eval.modele;

public class StockPv {
    Laptop laptop;
    PointDeVente pv;
    int quantite;

    public StockPv(Laptop laptop, PointDeVente pv, int quantite) {
        this.laptop = laptop;
        this.pv = pv;
        this.quantite = quantite;
    }

    public Laptop getLaptop() {
        return laptop;
    }

    public void setLaptop(Laptop laptop) {
        this.laptop = laptop;
    }

    public PointDeVente getPv() {
        return pv;
    }

    public void setPv(PointDeVente pv) {
        this.pv = pv;
    }

    public int getQuantite() {
        return quantite;
    }

    public void setQuantite(int quantite) {
        this.quantite = quantite;
    }
}
