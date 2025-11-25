package src.model;

import java.util.ArrayList;

public class Produit {
    private int id;
    private String nom;
    private String description;
    private String dateDebut = null;
    private String dateFin = null;
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

    public void setDateDebut
            (String dateDebut) {
        this.dateDebut = dateDebut;
    }
    public String getDateDebut() {
        return dateDebut;
    }

    public void setDateFin(String dateFin) {
        this.dateFin = dateFin;
    }
    public String getDateFin() {
        return dateFin;
    }

    public String getDescription() {
        return description;
    }
    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public String toString() {
        if (dateDebut != null) {
            return " [id: " + id + "] " + nom + ": " + description + "( disponible du " + dateDebut + " au " + dateFin + " )";
        }
        return " [id: " + id + "] " + nom + " : " + description + " (indisponible) ";
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
