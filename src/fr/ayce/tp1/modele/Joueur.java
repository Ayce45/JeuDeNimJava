package fr.ayce.tp1.modele;

/**
 * The type Joueur.
 */
public class Joueur {
    private String nom;
    private int nbPartiesGagees;

    /**
     * Instantiates a new Joueur.
     *
     * @param nom the nom
     */
    Joueur(String nom) {
        this.nom = nom;
        nbPartiesGagees = 0;
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
     * Add parties gagnees.
     */
    void addPartiesGagnees() {
        nbPartiesGagees++;
    }

    /**
     * Get nb parties gagées int.
     *
     * @return the int
     */
    public int getNbPartiesGagees() {
        return nbPartiesGagees;
    }
}
