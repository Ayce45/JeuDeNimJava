package fr.ayce.tp1.controleur;

import fr.ayce.tp1.modele.GestionnaireJeu;
import fr.ayce.tp1.vue.Ihm;

/**
 * The type Controleur jeu.
 */
public class ControleurJeu {
    private final Ihm ihm = new Ihm();
    private final GestionnaireJeu gestionnaireJeu = new GestionnaireJeu();

    {
        gestionnaireJeu.setJ1(ihm.nomJoueur("1"));
        if (ihm.IA()) {
            gestionnaireJeu.setJ2(ihm.nomJoueur("2"));
            gestionnaireJeu.setType("JVJ");
        } else {
            gestionnaireJeu.setJ2("IA");
            gestionnaireJeu.setType("IA");
        }
        gestionnaireJeu.setPartie(ihm.nbLignes());
        gestionnaireJeu.setContrainte(ihm.contrainte());
        gestionnaireJeu.jouer();
    }
}