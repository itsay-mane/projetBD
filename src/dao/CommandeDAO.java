package src.dao;

import src.model.Commande;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

public class CommandeDAO {
    private int ligneCommande;
    private int sousTotal = 10;

    public CommandeDAO() {
        this.ligneCommande = 1;
    }

    public void nextLigneCommande() {
        this.ligneCommande++;
    }

    public void insertLigneDeCommande (int idClient, String dateCommande) {

        try {
            Connection conn = DatabaseConnection.getConnection();
            PreparedStatement statement = conn.prepareStatement(
                    "INSERT INTO LigneDeCommande " +
                            "(idClient, dateCommande, numLigne, quantiteCommandee, sousTotalLigne, idProduit, dateReceptionLot, conditionnement) " +
                            "VALUES (?, ?, ?, ?, ?, ?, ?, ?)"
            );
            Scanner scan = new Scanner(System.in);

            statement.setInt(1, idClient);
            statement.setString(2, dateCommande);
            statement.setInt(3, ligneCommande);
            nextLigneCommande();


            ProduitDAO produitDAO = new ProduitDAO();
            System.out.print("Veuillez séléctionner un produit (id) : ");
            int id = Integer.parseInt(scan.next());
            scan.nextLine();

            if (produitDAO.estDispo(id)) {
                System.out.print("Quelle quantitée désirez vous? : ");
                String quantite = scan.next();
                scan.nextLine();
                statement.setString(4, quantite);
                System.out.println("Votre commande est en cours de préparation! sous total :" + sousTotal);
            } else {
                System.out.println("Ce produit est malheureusement indisponible.");
            }
            //ResultSet rs = statement.executeQuery();
        }
        catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
