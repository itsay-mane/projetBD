package src.model;

public class Client {
    private int email;
    private String nom;
    private String prenom;
    private String tel;


    public Client(int email, String nom, String prenom, String tel) {
        this.email = email;
        this.nom = nom;
        this.prenom = prenom;
        this.tel = tel;
    }

    public int getEmail() {
        return email;
    }
    public void setEmail(int email) {
        this.email = email;
    }

    public String getNom() {
        return nom;
    }
    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getPrenom() {
        return prenom;
    }
    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public String getTel() {
        return tel;
    }
    public void setTel(String tel) {
        this.tel = tel;
    }

    @Override
    public String toString() {
        return "Client [email=" + email + ", nom=" + nom + ", prenom=" + prenom + ", tel=" + tel + "]";
    }
}
