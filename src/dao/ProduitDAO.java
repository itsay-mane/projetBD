package src.dao;
import src.model.Contenant;
import src.model.Produit;
import java.sql.*;
import java.util.*;

public class ProduitDAO {
    ArrayList<Produit> produits;

    // --- Init ---
    public ProduitDAO() {
        produits = new ArrayList<>();
    }

    public ArrayList<Produit> getProduitAlimentaires() {
        String sql1 = "SELECT * FROM produit, produitestdispo " +
                "WHERE produit.idproduit = produitestdispo.idproduit";
        String sql2 = "SELECT * FROM produit " +
                "WHERE produit.idproduit NOT IN (SELECT idproduit FROM produitestdispo)";
        // D'un coté produit alimentaire avec date de dispo et d'un autre produit non alimentaire

        try (Connection conn = DatabaseConnection.getConnection();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql1)) {
            while (rs.next()) {
                Produit p = new Produit();
                p.setId(rs.getInt("IDPRODUIT"));
                p.setNom(rs.getString("NOMPRODUIT"));
                p.setDescription(rs.getString("DESCRIPTIONPRODUIT"));
                p.setDateDebut(rs.getString("DateDebut"));
                p.setDateFin(rs.getString("DateFin"));
                produits.add(p);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        try (Connection conn = DatabaseConnection.getConnection();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql2)) {
            while (rs.next()) {
                Produit p = new Produit();
                p.setId(rs.getInt("IDPRODUIT"));
                p.setNom(rs.getString("NOMPRODUIT"));
                p.setDescription(rs.getString("DESCRIPTIONPRODUIT"));
                produits.add(p);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return produits;
    }

    public ArrayList<Contenant> getContenants() {
        String sql = "SELECT * FROM contenant";
        ArrayList<Contenant> contenants = new ArrayList<>();
        try (Connection conn = DatabaseConnection.getConnection();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {
            while (rs.next()) {
                Contenant c = new Contenant();
                c.setId(rs.getInt("IDPRODUIT"));
                c.setCapacite(rs.getString("CAPACITECONTENANT"));
                c.setType(rs.getString("TYPECONTENANT"));
                contenants.add(c);

            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return contenants;
    }

}
