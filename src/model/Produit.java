package src.model;

import java.util.ArrayList;

public class Produit {
    private int id;
    private String nom;
    private String description;
    private ArrayList<Lot> lots;

    public Produit(int id, String nom, String description) {
        this.id = id;
        this.nom = nom;
        this.description = description;

    }

    public Produit() {
        this.id = 0;
        this.nom = "";
        this.description = "";
    }

    // Constructeur, getters, setters, toString()

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

    public String getDescription() {
        return description;
    }
    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public String toString() {
        return nom + " : " + description;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj instanceof Produit) {
            Produit p = (Produit) obj;
            return p.getId() == this.getId();
        }
        return false;
    }
}
