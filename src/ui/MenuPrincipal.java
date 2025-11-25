package src.ui;

import src.dao.*;
import src.model.*;
import java.util.*;

public class MenuPrincipal {
    private final ProduitDAO produitDAO = new ProduitDAO();
    //private final CommandeDAO commandeDAO = new CommandeDAO();
    //private final AlerteDAO alerteDAO = new AlerteDAO();
    private final Scanner sc = new Scanner(System.in);

    public void afficherMenu() {
        while (true) {
            System.out.println("\n=== MENU PRINCIPAL ===");
            System.out.println("1. Consulter le catalogue");
            System.out.println("2. Passer une commande");
            System.out.println("3. Consulter les alertes de péremption");
            System.out.println("4. Clôturer une commande");
            System.out.println("0. Quitter");
            System.out.print("Votre choix : ");

            int choix = sc.nextInt();
            sc.nextLine(); // consomme le retour à la ligne

            switch (choix) {
                case 1 -> consulterCatalogue();
                case 2 -> passerCommande();
                case 3 -> consulterAlertes();
                case 4 -> cloturerCommande();
                case 0 -> {
                    System.out.println("Au revoir !");
                    return;
                }
                default -> System.out.println("Choix invalide.");
            }
        }
    }

    private void consulterCatalogue() {
        System.out.println("PRODUITS ALIMENTAIRES :");
        System.out.println("-------------------------------------------------");

        List<Produit> produits = produitDAO.getProduitAlimentaires();
        produits.forEach(System.out::println);

        System.out.println("");
        System.out.println("CONTENANTS :");
        System.out.println("-------------------------------------------------");

        List<Contenant> contenants = produitDAO.getContenants();
        contenants.forEach(System.out::println);

        System.out.println("");
    }

    private void passerCommande() {
        // logique de saisie produits + insertion via CommandeDAO
    }

    private void consulterAlertes() {
        LotDAO lotDAO = new LotDAO();
        lotDAO.getPerimeLots();

    }

    private void cloturerCommande() {
        // mise à jour du statut commande
    }
}