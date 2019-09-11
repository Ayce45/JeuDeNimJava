package fr.ayce.tp1.modele;

import fr.ayce.tp1.vue.Ihm;

import java.util.Arrays;

public class GestionnaireJeu {
    private Joueur joueur1;
    private Joueur joueur2;
    private Partie partie;
    private Ihm ihm = new Ihm();

    public void setJ1(String s) {
        joueur1 = new Joueur(s);
    }

    public void setJ2(String s) {
        joueur2 = new Joueur(s);
    }

    public void setPartie(int i) {
        partie = new Partie(i);
    }

    public void affichePartie() {
        ihm.affiche(partie.getEtat());
    }

    public void jouer() {
        int i = 0;
        while (true) {
            if (partie.isGagner()) {
                ihm.gagner(partie.getJoueur().getNom());
                partie.getJoueur().addPartiesGagnees();
                if (ihm.rejouer()) {
                    partie = new Partie(ihm.nbLignes());
                    partie.setJoueur(joueur1);
                } else {
                    ihm.resultat(joueur1, joueur2);
                    System.exit(0);
                };

            }
            if ( (i & 1) == 0 ) {
                partie.setJoueur(joueur1);
                partie.coupIA();
            }
            else {
                if (true) {
                    partie.setJoueur(new Joueur("IA"));
                } else {
                    partie.setJoueur(joueur2);
                }
            }
            boolean isValide = true;
            while (isValide) {
                try {
                    affichePartie();
                    if (partie.getJoueur().getNom() == "IA") {
                        partie.coup(partie.coupIA());
                    } else {
                        partie.coup(ihm.coup(partie.getJoueur().getNom()));
                    }

                    isValide = false;
                } catch (Exception e) {
                    ihm.clearScreen();
                    ihm.invalideCoup();
                }
            }
            ihm.clearScreen();
            i++;
        }

    }
}
