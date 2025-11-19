package src.dao;
import src.model.Produit;
import java.sql.*;
import java.util.*;

public class ProduitDAO {
    ArrayList<Produit> produits;

    // --- Init ---
    public ProduitDAO() {
        produits = new ArrayList<>();
    }

    public ArrayList<Produit> getCatalogue() {
        String sql = "SELECT * FROM produit";

        try (Connection conn = DatabaseConnection.getConnection();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {
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
}
