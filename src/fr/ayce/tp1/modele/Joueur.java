package fr.ayce.tp1.modele;

public class Joueur {
    private String nom;
    private int nbPartiesGagées;

    public Joueur(String nom) {
        this.nom = nom;
        nbPartiesGagées = 0;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public void addPartiesGagnees() {
        nbPartiesGagées++;
    }

    public int getNbPartiesGagées() {
        return nbPartiesGagées;
    }
}
