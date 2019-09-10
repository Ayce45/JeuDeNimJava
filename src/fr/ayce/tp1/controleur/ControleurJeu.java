package fr.ayce.tp1.controleur;

import fr.ayce.tp1.modele.GestionnaireJeu;
import fr.ayce.tp1.vue.Ihm;

public class ControleurJeu {
    private Ihm ihm = new Ihm();
    private GestionnaireJeu gestionnaireJeu = new GestionnaireJeu();

    {
        gestionnaireJeu.setJ1(ihm.nomJoueur("1"));
        gestionnaireJeu.setJ2(ihm.nomJoueur("2"));
        gestionnaireJeu.setPartie(ihm.nbLignes());
        gestionnaireJeu.jouer();
    }
}
