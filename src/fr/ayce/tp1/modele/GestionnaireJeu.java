package fr.ayce.tp1.modele;

import fr.ayce.tp1.vue.Ihm;

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
        while (i < 100) {
            if ( (i & 1) == 0 ) {
                partie.setJoueur(joueur1);
            }
            else {
                partie.setJoueur(joueur2);
            }
            affichePartie();
            ihm.joue(partie);
            i++;
        }

    }
}
