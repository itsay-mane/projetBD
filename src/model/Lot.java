package src.model;

public class Lot {
    private String dateReception;
    private Conditionnement conditionnement;
    private int quantite;
    private float prixAchat;
    private float prixVente;

    public String getDateReception() {
        return dateReception;
    }
    public void setDateReception(String dateReception) {
        this.dateReception = dateReception;
    }
    public Conditionnement getConditionnement() {
        return conditionnement;
    }
    public void setConditionnement(Conditionnement conditionnement) {
        this.conditionnement = conditionnement;
    }
    public int getQuantite() {
        return quantite;
    }
    public void setQuantite(int quantite) {
        this.quantite = quantite;
    }
    public float getPrixAchat() {
        return prixAchat;
    }
    public void setPrixAchat(float prixAchat) {
        this.prixAchat = prixAchat;
    }
    public float getPrixVente() {
        return prixVente;
    }
    public void setPrixVente(float prixVente) {
        this.prixVente = prixVente;
    }


}
