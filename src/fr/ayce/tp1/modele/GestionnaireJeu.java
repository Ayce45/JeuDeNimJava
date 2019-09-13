package fr.ayce.tp1.modele;

import fr.ayce.tp1.MonException;
import fr.ayce.tp1.vue.Ihm;

/**
 * The type Gestionnaire jeu.
 */
public class GestionnaireJeu {
    private Joueur joueur1;
    private Joueur joueur2;
    private Partie partie;
    private final Ihm ihm = new Ihm();
    private String type;

    /**
     * Sets j 1.
     *
     * @param s the s
     */
    public void setJ1(String s) {
        joueur1 = new Joueur(s);
    }

    /**
     * Sets j 2.
     *
     * @param s the s
     */
    public void setJ2(String s) {
        joueur2 = new Joueur(s);
    }

    /**
     * Sets partie.
     *
     * @param i the
     */
    public void setPartie(int i) {
        partie = new Partie(i);
    }

    /**
     * Affiche partie.
     */
    private void affichePartie() {
        ihm.affiche(partie.getEtat());
    }

    /**
     * Sets type.
     *
     * @param type the type
     */
    public void setType(String type) {
        this.type = type;
    }

    /**
     * Jouer.
     */
    public void jouer() {
        int i = 0;
        while (true) {
            if (partie.isGagner()) {
                ihm.gagner(partie.getJoueur().getNom());
                partie.getJoueur().addPartiesGagnees();
                if (ihm.rejouer()) {
                    partie = new Partie(ihm.nbLignes());
                    i = 0;
                } else {
                    ihm.resultat(joueur1, joueur2);
                    System.exit(0);
                }

            }
            if ( (i & 1) == 0 ) {
                partie.setJoueur(joueur1);
            }
            else {
                partie.setJoueur(joueur2);
            }
            boolean isValide = true;
            while (isValide) {
                try {
                    affichePartie();
                    if (type.equals("IA") && partie.getJoueur().getNom().equals("IA")) {
                        partie.coup(partie.coupIA());
                        Thread.sleep(1000);
                    } else {
                        partie.coup(ihm.coup(partie.getJoueur().getNom()));
                    }

                    isValide = false;
                } catch (MonException | InterruptedException e) {
                    ihm.clearScreen();
                    ihm.invalideCoup(e.getMessage());
                }
            }
            ihm.clearScreen();
            i++;
        }

    }

    public void setContrainte(boolean contrainte) {
        partie.setContrainte(contrainte);
    }
}
