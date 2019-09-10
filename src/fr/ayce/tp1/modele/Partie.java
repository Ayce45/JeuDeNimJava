package fr.ayce.tp1.modele;

import java.util.Arrays;

public class Partie {
    private int[][] etat;
    private Joueur joueur;

    public Partie(int nbLignes) {
        etat = new int[nbLignes][];
        for (int i = 1; i < etat.length + 1; i++) {
            etat[i - 1] = new int[2 * i - 1];
        }
    }

    public int[][] getEtat() {
        return etat;
    }

    public Joueur getJoueur() {
        return joueur;
    }

    public void setJoueur(Joueur joueur) {
        this.joueur = joueur;
    }

    public void coup(Coup c) {
        for (int i = 0; i < c.getNbAllumettes();i++) {
            this.getEtat()[c.getLigne()][i] = 1;
        }

    }
}