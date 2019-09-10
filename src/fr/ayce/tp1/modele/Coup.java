package fr.ayce.tp1.modele;

public class Coup {
    private int ligne;
    private int nbAllumettes;

    public Coup() {
        this.ligne = ligne;
        this.nbAllumettes = nbAllumettes;
    }

    public int getLigne() {
        return ligne;
    }

    public void setLigne(int ligne) {
        this.ligne = ligne;
    }

    public int getNbAllumettes() {
        return nbAllumettes;
    }

    public void setNbAllumettes(int nbAllumettes) {
        this.nbAllumettes = nbAllumettes;
    }
    public boolean isValide(String s, Partie p) {
        return true;
    }
}
