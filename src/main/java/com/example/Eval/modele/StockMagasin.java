package com.example.Eval.modele;

public class StockMagasin {
    Laptop laptop;
    int quantite;

    public StockMagasin(Laptop laptop, int quantite) {
        this.laptop = laptop;
        this.quantite = quantite;
    }

    public Laptop getLaptop() {
        return laptop;
    }

    public void setLaptop(Laptop laptop) {
        this.laptop = laptop;
    }

    public int getQuantite() {
        return quantite;
    }

    public void setQuantite(int quantite) {
        this.quantite = quantite;
    }
}
