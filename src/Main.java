import java.util.Scanner;
public class Main {
    public static void main(String[] args) {

        GestionStock gestionStock = new GestionStock(); // Instance de GestionStock
        Scanner scanner = new Scanner(System.in);
        int choix;
        do {
            gestionStock.printMenu();
            System.out.print("Entrez votre choix : ");
            choix = scanner.nextInt();
            scanner.nextLine();

            switch (choix) {
                case 1:
                    System.out.print("Entrez le code : ");
                    int code = scanner.nextInt();
                    scanner.nextLine();
                    System.out.print("Entrez le nom : ");
                    String nom = scanner.nextLine();
                    System.out.print("Entrez la quantité : ");
                    int quantite = scanner.nextInt();
                    System.out.print("Entrez le prix : ");
                    double prix = scanner.nextDouble();
                    gestionStock.ajouterProduit(new Produit(code, nom, quantite, prix));
                    break;
                case 2:
                    System.out.print("Entrez le code du produit à modifier : ");
                    code = scanner.nextInt();
                    scanner.nextLine();
                    System.out.print("Entrez le nouveau nom : ");
                    String nouveauNom = scanner.nextLine();
                    System.out.print("Entrez la nouvelle quantité : ");
                    int nouvelleQuantite = scanner.nextInt();
                    System.out.print("Entrez le nouveau prix : ");
                    double nouveauPrix = scanner.nextDouble();
                    gestionStock.modifierProduit(code, nouveauNom, nouvelleQuantite, nouveauPrix);
                    break;
                case 3:
                    System.out.print("Entrez le code du produit à supprimer : ");
                    code = scanner.nextInt();
                    gestionStock.supprimerProduit(code);
                    break;
                case 4:
                    gestionStock.afficherProduits();
                    break;
                case 5:
                    System.out.print("Entrez le nom du produit à rechercher : ");
                    nom = scanner.nextLine();
                    gestionStock.rechercherProduit(nom);
                    break;
                case 6:
                    gestionStock.calculerValeurStock();
                    break;
                case 7:
                    System.out.println("Au revoir !");
                    break;
                default:
                    System.out.println("Choix invalide. Veuillez réessayer.");
            }
        } while (choix != 7);

        scanner.close();
    }
}