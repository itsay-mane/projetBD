package src.model;

public class Contenant {
    private int id;
    private String type;
    private String capacite;

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

    public String getCapacite() {
        return capacite;
    }
    public void setCapacite(String capacite) {
        this.capacite = capacite;
    }

    @Override
    public String toString() {
        return "Contenant [id=" + id + ", type=" + type + ", capacite=" + capacite + "]";
    }
}
