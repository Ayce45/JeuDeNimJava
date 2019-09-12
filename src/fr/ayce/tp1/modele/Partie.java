package fr.ayce.tp1.modele;

import fr.ayce.tp1.ConsoleColors;
import fr.ayce.tp1.MonException;

import java.io.Console;
import java.security.InvalidParameterException;

/**
 * The type Partie.
 */
public class Partie {
    private int[][] etat;
    private Joueur joueur;

    /**
     * Instantiates a new Partie.
     *
     * @param nbLignes the nb lignes
     */
    public Partie(int nbLignes) {
        etat = new int[nbLignes][];
        for (int i = 1; i < etat.length + 1; i++) {
            etat[i - 1] = new int[2 * i - 1];
        }
    }

    /**
     * Convert tab int [ ].
     *
     * @return the int [ ]
     */
    public int[] convertTab() {
        int c = 0;
        int[] tab = new int[etat.length];
        int v = 0;
        for (int[] x : etat) {
            c = 0;
            for (int y : x) {
                if (y == 0) {
                    c++;
                }
            }
            tab[v] = c;
            v++;
        }
        return tab;
    }

    /**
     * Get etat int [ ] [ ].
     *
     * @return the int [ ] [ ]
     */
    public int[][] getEtat() {
        return etat;
    }

    /**
     * Gets joueur.
     *
     * @return the joueur
     */
    public Joueur getJoueur() {
        return joueur;
    }

    /**
     * Sets joueur.
     *
     * @param joueur the joueur
     */
    public void setJoueur(Joueur joueur) {
        this.joueur = joueur;
    }

    /**
     *
     * @param val
     * @return
     */
    private boolean isExiste(int val){
        for(int i = 0 ; i < etat.length;i++) {
            for (int y = 0; y < etat[i].length; y++) {
                if (val == etat[i][y])
                    return true;
            }
        }
        return false;
    }

    /**
     * Coup.
     *
     * @param c the c
     * @throws MonException the mon exception
     */
    public void coup(Coup c) throws MonException {
        int y = 0;
        int i = 0;
        int nbLigne = c.getLigne() - 1;
        int nbAllumettes = c.getNbAllumettes();
        while (i < this.getEtat()[nbLigne].length && y < nbAllumettes) {
            if (this.getEtat()[nbLigne][i] != 1) {
                //this.getEtat()[nbLigne][i] = 1;
                y++;
            }
            i++;
        }
        if (nbAllumettes != y) {
            throw new MonException("Houston, we have a problem.");
        }
        y = 0;
        i = 0;
        while (i < this.getEtat()[nbLigne].length && y < nbAllumettes) {
            if (this.getEtat()[nbLigne][i] != 1) {
                this.getEtat()[nbLigne][i] = -1;
                y++;
            }
            i++;
        }
    }

    /**
     * Coup ia coup.
     *
     * @return the coup
     */
    public Coup coupIA() {
        int nblignes = etat.length ;
        int ouexcl = 0;
        Coup c = new Coup();
        for (int l = 0;l < nblignes;l++) {
            ouexcl ^= convertTab()[l];
        }
        if (ouexcl != 0) {
            for (int l = 0;l < nblignes;l++) {
                int nbAllumette = convertTab()[l];
                int res = ouexcl^nbAllumette;
                if (nbAllumette >= res) {
                    c.setLigne(l + 1);
                    c.setNbAllumettes(nbAllumette-res);
                    break;
                }
            }
        } else {
            for (int l = 0;l < nblignes;l++) {
                if (convertTab()[l] > 0) {
                    c.setLigne(l + 1);
                    c.setNbAllumettes(1);
                    break;
                }
            }
        }
        System.out.println(ConsoleColors.WHITE_BRIGHT +c.toString());
        return c;
    }

    /**
     * Is gagner boolean.
     *
     * @return the boolean
     */
    public boolean isGagner() {
        if (isExiste(0)) {
            return false;
        } else {
            return true;
        }

    }


}