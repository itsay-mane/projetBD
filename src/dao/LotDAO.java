package src.dao;

import src.model.Produit;
import src.model.Lot;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class LotDAO {
    private final ProduitDAO produitDAO = new ProduitDAO();

    public void getPerimeLots() {
        String sql = "SELECT * FROM perime";

        try (Connection conn = DatabaseConnection.getConnection();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {
            List<Produit> produits = produitDAO.getProduitAlimentaires();
            while (rs.next()) {
                int id = rs.getInt("idProduit");
                String nom = "";
                for (Produit p : produits) {
                    if (p.getId() == id) {
                        nom = p.getNom();
                    }
                }
                String date = rs.getString("datePeremptionLot");
                System.out.println(nom + " périme le " + date);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
