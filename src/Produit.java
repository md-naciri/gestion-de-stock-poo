public class Produit {
    private int code;
    private String nom;
    private int quantite;
    private double prix;

    public Produit(int code, String nom, int quantite, double prix) {
        this.code = code;
        this.nom = nom;
        this.quantite = quantite;
        this.prix = prix;
    }

    // Constructeur par défaut
    public Produit() {
        this(0, "", 0, 0.0);
    }

    // Getters and setters
    public void setCode(int code) {
        this.code = code;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public void setQuantite(int quantite) {
        this.quantite = quantite;
    }

    public void setPrix(double prix) {
        this.prix = prix;
    }

    public int getCode() {
        return code;
    }

    public String getNom() {
        return nom;
    }

    public int getQuantite() {
        return quantite;
    }

    public double getPrix() {
        return prix;
    }

    @Override
    public String toString() {
        return "Produit{" +
                "code=" + code +
                ", nom='" + nom + '\'' +
                ", quantite=" + quantite +
                ", prix=" + prix +
                '}';
    }

    // Calculer la valeur totale d'un produit en stock
    public double calculerValeurTotale() {
        return quantite * prix;
    }
}
