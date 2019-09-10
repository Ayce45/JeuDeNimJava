package fr.ayce.tp1.controleur;

import fr.ayce.tp1.modele.Partie;
import fr.ayce.tp1.vue.Ihm;
import fr.ayce.tp1.modele.Joueur;

public class ControleurJeu {
    private Joueur joueur1;
    private Joueur joueur2;
    private Partie partie;
    private Ihm ihm = new Ihm();

    {
        joueur1 = new Joueur(ihm.nomJoueur("1"));
        joueur2 = new Joueur(ihm.nomJoueur("2"));
        partie = new Partie(ihm.nbLignes());

        System.out.println(joueur1.getNom());
        System.out.println(joueur2.getNom());
    }
}
