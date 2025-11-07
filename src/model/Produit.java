package src.model;

public class Produit {
    private int id;
    private String nom;
    private String description;

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
        return "Produit{" + "id=" + id + ", nom=" + nom + ", description=" + description + '}';
    }
}
