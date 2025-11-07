package src.model;

public class Producteur {
    private int id;
    private String nom;
    private String adresse;
    private String contact;

    public Producteur(int id, String nom, String adresse, String contact) {
        this.id = id;
        this.nom = nom;
        this.adresse = adresse;
        this.contact = contact;
    }

    public int getId() {
        return id  ;
    }
    public String getNom() {
        return nom;
    }

    public String getAdresse() {
        return adresse;
    }
    public String getContact() {
        return contact;
    }

    public void setId(int id) {
        this.id = id;
    }
    public void setNom(String nom) {
        this.nom = nom;
    }
    public void setAdresse(String adresse) {
        this.adresse = adresse;
    }
    public void setContact(String contact) {
        this.contact = contact;
    }

    @Override
    public String toString() {
        return "producteur : " + id + " " + nom + " " + adresse + " " + contact ;
    }
}
