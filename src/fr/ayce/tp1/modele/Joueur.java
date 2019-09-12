package fr.ayce.tp1.modele;

/**
 * The type Joueur.
 */
public class Joueur {
    private String nom;
    private int nbPartiesGagées;

    /**
     * Instantiates a new Joueur.
     *
     * @param nom the nom
     */
    public Joueur(String nom) {
        this.nom = nom;
        nbPartiesGagées = 0;
    }

    /**
     * Gets nom.
     *
     * @return the nom
     */
    public String getNom() {
        return nom;
    }

    /**
     * Sets nom.
     *
     * @param nom the nom
     */
    public void setNom(String nom) {
        this.nom = nom;
    }

    /**
     * Add parties gagnees.
     */
    public void addPartiesGagnees() {
        nbPartiesGagées++;
    }

    /**
     * Get nb parties gagées int.
     *
     * @return the int
     */
    public int getNbPartiesGagées() {
        return nbPartiesGagées;
    }
}
