package src.model;

public class Commande {
    private String date;
    private int heure;
    private String statutCommande;
    private String modePaiement;
    private String modeRecuperation;

    public int getHeure() {
        return heure;
    }

    public void setHeure(int heure) {
        this.heure = heure;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getStatutCommande() {
        return statutCommande;
    }

    public void setStatutCommande(String statutCommande) {
        this.statutCommande = statutCommande;
    }

    public String getModePaiement() {
        return modePaiement;
    }

    public void setModePaiement(String modePaiement) {
        this.modePaiement = modePaiement;
    }

    public String getModeRecuperation() {
        return modeRecuperation;
    }

    public void setModeRecuperation(String modeRecuperation) {
        this.modeRecuperation = modeRecuperation;

    }
}
