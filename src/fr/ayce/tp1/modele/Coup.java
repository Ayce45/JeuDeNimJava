package fr.ayce.tp1.modele;

/**
 * The type Coup.
 */
public class Coup {
    private int ligne;
    private int nbAllumettes;

    /**
     * Instantiates a new Coup.
     */
    public Coup() {
    }

    /**
     * Gets ligne.
     *
     * @return the ligne
     */
    int getLigne() {
        return ligne;
    }

    /**
     * Sets ligne.
     *
     * @param ligne the ligne
     */
    public void setLigne(int ligne) {
        this.ligne = ligne;
    }

    /**
     * Gets nb allumettes.
     *
     * @return the nb allumettes
     */
    int getNbAllumettes() {
        return nbAllumettes;
    }

    /**
     * Sets nb allumettes.
     *
     * @param nbAllumettes the nb allumettes
     */
    public void setNbAllumettes(int nbAllumettes) {
        this.nbAllumettes = nbAllumettes;
    }

    @Override
    public String toString() {
        return ligne + " " + nbAllumettes;
    }
}
