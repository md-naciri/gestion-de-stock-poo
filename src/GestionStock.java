public class GestionStock {
    // Tableau pour stocker les produits
    private static Produit[] produits = new Produit[100];

    // Compteur pour le suivre le nombre de produits
    private static int compteur = 0;

    public static void printMenu() {
        System.out.println("\n--- Menu Principal ---");
        System.out.println("1. Ajouter un produit");
        System.out.println("2. Modifier un produit");
        System.out.println("3. Supprimer un produit");
        System.out.println("4. Afficher la liste des produits");
        System.out.println("5. Rechercher un produit par nom");
        System.out.println("6. Calculer la valeur totale du stock");
        System.out.println("7. Quitter");
    }

    public static void ajouterProduit(Produit produit) {
        if (compteur >= 100) {
            System.out.println("Erreur : Le tableau est plein.");
            return;
        }
        for (int i = 0; i < compteur; i++) {
            if (produits[i].getCode() == produit.getCode()) {
                System.out.println("Erreur : Code produit déjà existant.");
                return;
            }
        }
        produits[compteur++] = produit;
        System.out.println("Produit ajouté avec succès !");
    }

    public static void modifierProduit(int code, String nouveauNom, int nouvelleQuantite, double nouveauPrix) {
        for (int i = 0; i < compteur; i++) {
            if (produits[i].getCode() == code) {
                produits[i].setNom(nouveauNom);
                produits[i].setQuantite(nouvelleQuantite);
                produits[i].setPrix(nouveauPrix);
                System.out.println("Produit modifié avec succès !");
                return;
            }
        }
        System.out.println("Erreur : Produit non trouvé.");
    }

    public static void supprimerProduit(int code) {
        for (int i = 0; i < compteur; i++) {
            if (produits[i].getCode() == code) {
                produits[i] = produits[--compteur];
                produits[compteur] = null;
                System.out.println("Produit supprimé avec succès !");
                return;
            }
        }
        System.out.println("Erreur : Produit non trouvé.");
    }

    public static void afficherProduits() {
        if (compteur == 0) {
            System.out.println("Aucun produit en stock.");
            return;
        }
        System.out.println("\nListe des produits :");
        for (int i = 0; i < compteur; i++) {
            System.out.println(produits[i]);
        }
    }

    public static void rechercherProduit(String nom) {
        for (int i = 0; i < compteur; i++) {
            if (produits[i].getNom().equalsIgnoreCase(nom)) {
                System.out.println("Produit trouvé : " + produits[i]);
                return;
            }
        }
        System.out.println("Erreur : Produit non trouvé.");
    }

    public static void calculerValeurStock() {
        double valeurTotale = 0.0;
        for (int i = 0; i < compteur; i++) {
            valeurTotale += produits[i].calculerValeurTotale();
        }
        System.out.println("Valeur totale du stock : " + valeurTotale);
    }

}
