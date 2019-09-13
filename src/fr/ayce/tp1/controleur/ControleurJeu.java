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
        int type = ihm.IA();
        if (type == 1) {
            gestionnaireJeu.setJ1(ihm.nomJoueur("1"));
            gestionnaireJeu.setJ2(ihm.nomJoueur("2"));
            gestionnaireJeu.setType("JVJ");
        } else if (type == 0) {
            gestionnaireJeu.setJ1(ihm.nomJoueur("1"));
            gestionnaireJeu.setJ2("IA");
            gestionnaireJeu.setType("IA");
        } else if (type == 3) {
            gestionnaireJeu.setJ1("IA 1");
            gestionnaireJeu.setJ2("IA 2");
            gestionnaireJeu.setType("IA");
        }  else if (type == 4) {
            gestionnaireJeu.setJ1("IAN 1");
            gestionnaireJeu.setJ2("IAN 2");
            gestionnaireJeu.setType("IA");
        } else if (type == 5) {
            gestionnaireJeu.setJ1("IAN 1");
            gestionnaireJeu.setJ2("IA 2");
            gestionnaireJeu.setType("IA");
        }
        gestionnaireJeu.setPartie(ihm.nbLignes());
        gestionnaireJeu.setContrainte(ihm.contrainte());
        gestionnaireJeu.jouer();
    }
}