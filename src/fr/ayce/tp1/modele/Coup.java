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
        this.ligne = ligne;
        this.nbAllumettes = nbAllumettes;
    }

    /**
     * Gets ligne.
     *
     * @return the ligne
     */
    public int getLigne() {
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
    public int getNbAllumettes() {
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

    /**
     * Is valide boolean.
     *
     * @param s the s
     * @param p the p
     * @return the boolean
     */
    public boolean isValide(String s, Partie p) {
        System.out.println(s);
        return false;
    }

    @Override
    public String toString() {
        return "Coup{" +
                "ligne=" + ligne +
                ", nbAllumettes=" + nbAllumettes +
                '}';
    }
}
