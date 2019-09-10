package fr.ayce.tp1.modele;

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

    private boolean isExiste(int val){
        for(int i = 0 ; i < etat.length;i++) {
            for (int y = 0; y < etat[i].length; y++) {
                if (val == etat[i][y])
                    return true;
            }
        }
        return false;
    }

    public void coup(Coup c) {
        int y = 0;
        int i = 0;
        int nbLigne = c.getLigne() - 1;
        int nbAlumettes = c.getNbAllumettes();
        while (i < this.getEtat()[nbLigne].length && y < nbAlumettes) {
            if (this.getEtat()[nbLigne][i] != 1) {
                this.getEtat()[nbLigne][i] = 1;
                y++;
            }
            i++;
        }
    }

    public boolean isGagner() {
        if (isExiste(0)) {
            return false;
        } else {
            return true;
        }

    }
}