package fr.ayce.tp1.modele;

import fr.ayce.tp1.MonException;

import java.security.InvalidParameterException;

public class Partie {
    private int[][] etat;
    private Joueur joueur;

    public Partie(int nbLignes) {
        etat = new int[nbLignes][];
        for (int i = 1; i < etat.length + 1; i++) {
            etat[i - 1] = new int[2 * i - 1];
        }
    }

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

    public int[][] getEtat() {
        return etat;
    }

    public Joueur getJoueur() {
        return joueur;
    }

    public void setJoueur(Joueur joueur) {
        this.joueur = joueur;
    }

    private boolean isExiste(int val){
        for(int i = 0 ; i < etat.length;i++) {
            for (int y = 0; y < etat[i].length; y++) {
                if (val == etat[i][y])
                    return true;
            }
        }
        return false;
    }

    public void coup(Coup c) throws MonException {
        int y = 0;
        int i = 0;
        int nbLigne = c.getLigne() - 1;
        int nbAllumettes = c.getNbAllumettes();
        while (i < this.getEtat()[nbLigne].length && y < nbAllumettes) {
            if (this.getEtat()[nbLigne][i] != 1) {
                this.getEtat()[nbLigne][i] = 1;
                y++;
            }
            i++;
        }
        if (nbAllumettes != y) {
            throw new MonException("Houston, we have a problem.");
        }
    }
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
        System.out.println(c.toString());
        return c;
    }

    public boolean isGagner() {
        if (isExiste(0)) {
            return false;
        } else {
            return true;
        }

    }


}