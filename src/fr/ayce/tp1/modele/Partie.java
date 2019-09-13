package fr.ayce.tp1.modele;

import fr.ayce.tp1.ConsoleColors;
import fr.ayce.tp1.MonException;

/**
 * The type Partie.
 */
class Partie {
    private final int[][] etat;
    private Joueur joueur;
    private boolean contrainte = false;

    /**
     * Instantiates a new Partie.
     *
     * @param nbLignes the nb lignes
     */
    Partie(int nbLignes) {
        etat = new int[nbLignes][];
        for (int i = 1; i < etat.length + 1; i++) {
            etat[i - 1] = new int[2 * i - 1];
        }
    }

    /**
     * Convert tab int [ ].
     *
     * @return the int [ ]
     */
    private int[] convertTab() {
        int c;
        int[] tab = new int[etat.length];
        int v = 0;
        for (int[] x : etat) {
            c = 0;
            for (int y : x) {
                if (y == 0) {
                    c++;
                }
            }
            tab[v] = c;
            v++;
        }
        return tab;
    }

    /**
     * Get etat int [ ] [ ].
     *
     * @return the int [ ] [ ]
     */
    int[][] getEtat() {
        return etat;
    }

    /**
     * Gets joueur.
     *
     * @return the joueur
     */
    Joueur getJoueur() {
        return joueur;
    }

    /**
     * Sets joueur.
     *
     * @param joueur the joueur
     */
    void setJoueur(Joueur joueur) {
        this.joueur = joueur;
    }

    /**
     * @return boolean
     */
    private boolean isExiste() {
        for (int[] ints : etat) {
            for (int anInt : ints) {
                if (0 == anInt)
                    return true;
            }
        }
        return false;
    }

    /**
     * Coup.
     *
     * @param c the c
     * @throws MonException the mon exception
     */
    void coup(Coup c) throws MonException {
        int y = 0;
        int i = 0;
        int nbLigne = c.getLigne() - 1;
        int nbAllumettes = c.getNbAllumettes();
        if (nbLigne < 0 || nbLigne > this.getEtat().length) {
            throw new MonException("Ligne invalide");
        }
        while (i < this.getEtat()[nbLigne].length && y < nbAllumettes) {
            if (this.getEtat()[nbLigne][i] != 1) {
                y++;
            }
            i++;
        }
        if (nbAllumettes != y) {
            throw new MonException("Pas assez d'allumettes sur la ligne");
        }
        if (contrainte && nbAllumettes > 3) {
            throw new MonException("La contrainte de 3 allumettes n'est pas respecté ");
        }
        y = 0;
        i = 0;
        while (i < this.getEtat()[nbLigne].length && y < nbAllumettes) {
            if (this.getEtat()[nbLigne][i] != 1) {
                this.getEtat()[nbLigne][i] = 1;
                y++;
            }
            i++;
        }
    }

    /**
     * Coup ia coup.
     *
     * @param s the s
     * @return the coup
     * @throws InterruptedException the interrupted exception
     */
    Coup coupIA(String s) throws InterruptedException {
        int nblignes = etat.length;
        int ouexcl = 0;
        Coup c = new Coup();
        for (int l = 0; l < nblignes; l++) {
            ouexcl ^= convertTab()[l];
        }
        if (ouexcl != 0) {
            for (int l = 0; l < nblignes; l++) {
                int nbAllumette = convertTab()[l];
                int res = ouexcl ^ nbAllumette;
                if (nbAllumette >= res) {
                    c.setLigne(l + 1);
                    c.setNbAllumettes(nbAllumette - res);
                    if (contrainte && nbAllumette > 3) {
                        for (int y = 0; y < nblignes; y++) {
                            if (convertTab()[y] > 0) {
                                c.setLigne(y + 1);
                                c.setNbAllumettes(1);
                                break;
                            }
                        }
                    } else {
                        break;
                    }

                }
            }
        } else {
            for (int l = 0; l < nblignes; l++) {
                if (convertTab()[l] > 0) {
                    c.setLigne(l + 1);
                    c.setNbAllumettes(1);
                    break;
                }
            }
        }
        System.out.println(ConsoleColors.YELLOW + s + " : à vous de jouer un coup" + ConsoleColors.RESET);
        Thread.sleep(1000);
        System.out.println(ConsoleColors.GREEN + c.toString());
        return c;
    }

    /**
     * Coup ia coup.
     *
     * @return the coup
     * @throws InterruptedException the interrupted exception
     */
    Coup coupIAn(String s) throws InterruptedException {
        Coup c = new Coup();
        int ligne;
        int nbAllu;
        boolean valide = false;
        while (!valide) {
            ligne = (int) Math.floor(Math.random() * (etat.length)) + 1;
            if (convertTab()[ligne - 1] != 0) {
                nbAllu = (int) Math.floor(Math.random() * (convertTab()[ligne - 1] - 1)) + 1;
                if (!contrainte || nbAllu <= 3) {
                    c.setNbAllumettes(nbAllu);
                    c.setLigne(ligne);
                    valide = true;
                }
            }
        }
        System.out.println(ConsoleColors.YELLOW + s + " : à vous de jouer un coup" + ConsoleColors.RESET);
        Thread.sleep(1000);
        System.out.println(ConsoleColors.GREEN + c.toString());
        return c;
    }

    /**
     * Is gagner boolean.
     *
     * @return the boolean
     */
    boolean isGagner() {
        return !isExiste();

    }


    /**
     * Sets contrainte.
     *
     * @param contrainte the contrainte
     */
    void setContrainte(boolean contrainte) {
        this.contrainte = contrainte;
    }

    /**
     * Gets contrainte.
     *
     * @return the contrainte
     */
    public boolean getContrainte() {
        return contrainte;
    }
}