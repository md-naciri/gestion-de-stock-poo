import java.util.ArrayList;
import java.util.List;

public class GestionStock {
    private List<Produit> produits; // Liste des produits en stock

    // Constructeur
    public GestionStock() {
        this.produits = new ArrayList<>();
    }

    // Méthode pour afficher le menu
    public void printMenu() {
        System.out.println("\n--- Menu Principal ---");
        System.out.println("1. Ajouter un produit");
        System.out.println("2. Modifier un produit");
        System.out.println("3. Supprimer un produit");
        System.out.println("4. Afficher la liste des produits");
        System.out.println("5. Rechercher un produit par nom");
        System.out.println("6. Calculer la valeur totale du stock");
        System.out.println("7. Quitter");
    }

    public void ajouterProduit(Produit produit) {
        for (Produit p : produits) {
            if (p.getCode() == produit.getCode()) {
                System.out.println("Erreur : Code produit déjà existant.");
                return;
            }
        }
        produits.add(produit);
        System.out.println("Produit ajouté avec succès !");
    }

    public void modifierProduit(int code, String nouveauNom, int nouvelleQuantite, double nouveauPrix) {
        for (Produit p : produits) {
            if (p.getCode() == code) {
                p.setNom(nouveauNom);
                p.setQuantite(nouvelleQuantite);
                p.setPrix(nouveauPrix);
                System.out.println("Produit modifié avec succès !");
                return;
            }
        }
        System.out.println("Erreur : Produit non trouvé.");
    }

    public void supprimerProduit(int code) {
        produits.removeIf(p -> p.getCode() == code);
        System.out.println("Produit supprimé avec succès !");
    }

    public void afficherProduits() {
        if (produits.isEmpty()) {
            System.out.println("Aucun produit en stock.");
            return;
        }
        System.out.println("\nListe des produits :");
        for (Produit p : produits) {
            System.out.println(p);
        }
    }

    public void rechercherProduit(String nom) {
        for (Produit p : produits) {
            if (p.getNom().equalsIgnoreCase(nom)) {
                System.out.println("Produit trouvé : " + p);
                return;
            }
        }
        System.out.println("Erreur : Produit non trouvé.");
    }

    public void calculerValeurStock() {
        double valeurTotale = produits.stream()
                .mapToDouble(Produit::calculerValeurTotale)
                .sum();
        System.out.println("Valeur totale du stock : " + valeurTotale);
    }
}
