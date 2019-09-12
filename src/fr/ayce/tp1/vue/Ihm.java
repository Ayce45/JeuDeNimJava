package fr.ayce.tp1.vue;

import com.jakewharton.fliptables.FlipTable;
import fr.ayce.tp1.ConsoleColors;
import fr.ayce.tp1.modele.Coup;
import fr.ayce.tp1.modele.Joueur;
import fr.ayce.tp1.modele.Partie;

import java.util.Arrays;
import java.util.Scanner;

/**
 * The type Ihm.
 */
public class Ihm {
    private String str;
    private int in;
    private String[] tabStr;

    /**
     * Instantiates a new Ihm.
     */
    public Ihm() {

    }

    /**
     * Nom joueur string.
     *
     * @param s the s
     * @return the string
     */
    public String nomJoueur(String s) {
        Scanner sc = new Scanner(System.in);
        System.out.println(ConsoleColors.BLUE + "Veuillez saisir un nom de "+ConsoleColors.PURPLE +"joueur "+ s + ConsoleColors.BLUE +":");
        while (!sc.hasNext()) {
            sc.next();
        }
        str = sc.nextLine();
        return str;
    }

    /**
     * Nb lignes int.
     *
     * @return the int
     */
    public int nbLignes() {
        Scanner sc = new Scanner(System.in);
        int nbl = 0;
        while (nbl <= 0) {
            System.out.println(ConsoleColors.BLUE + "Veuillez saisir nombre de ligne :");
            if (sc.hasNextInt()) {
                nbl = sc.nextInt();
                if (nbl <= 0) {
                    System.out.println(ConsoleColors.RED + "Il est nécessaire de saisir un nombre de ligne supérieur a 0:");
                }
            }
            else {
                sc.next();
                System.out.println(ConsoleColors.RED +"Il est nécessaire de saisir nombre de ligne valide:");
            }
        }
        return nbl;
    }

    /**
     * Affiche.
     *
     * @param tab the tab
     */
    public void affiche(int[][] tab) {
        System.out.println(ConsoleColors.RED + Arrays.deepToString(tab)
                .replace("], ", "\n")
                .replace("[[", "")
                .replace("]]", "")
                .replace("0","|")
                .replace("[","")
                .replace(",","")
                .replace(" -1", "")
                .replace("-1 ", "")
                .replace("-1", "")+ ConsoleColors.RESET);
        //System.out.println(Arrays.deepToString(tab));
    }

    /**
     * Gagner.
     *
     * @param s the s
     */
    public void gagner(String s) {
        System.out.println(ConsoleColors.YELLOW+s + " gagne ! \uD83C\uDF8A \uD83C\uDF89 "+ConsoleColors.RESET);
    }

    /**
     * Coup coup.
     *
     * @param nomJoueur the nom joueur
     * @return the coup
     */
    public Coup coup(String nomJoueur) {
        Coup c = new Coup();
        Scanner sc = new Scanner(System.in);
        System.out.println(ConsoleColors.YELLOW + nomJoueur + " : à vous de jouer un coup" + ConsoleColors.RESET);

        System.out.println(ConsoleColors.BLUE + "Veuillez saisir un coup sous la forme 'm n' où m est la ligne choisie et n le nombre d'allumettes à retirer sur cette ligne"+ ConsoleColors.RESET);
        str = sc.nextLine();
        tabStr = str.split(" ");
        while (!str.matches("\\d+ \\d+")) {
            System.out.println(ConsoleColors.RED +"Veuillez saisir un coup valide, Ex : 1 2:" + ConsoleColors.RESET);
            str = sc.nextLine();
            tabStr = str.split(" ");
            c.setLigne(Integer.parseInt(tabStr[0]));
            c.setNbAllumettes(Integer.parseInt(tabStr[1]));
        }
        c.setLigne(Integer.parseInt(tabStr[0]));
        c.setNbAllumettes(Integer.parseInt(tabStr[1]));
        return c;
    }

    /**
     * Invalide coup.
     */
    public void invalideCoup() {
        System.out.println(ConsoleColors.RED +"Veuillez saisir un coup valide, Ex : 1 2:" + ConsoleColors.RESET);
    }

    /**
     * Ia boolean.
     *
     * @return the boolean
     */
    public boolean IA() {
        Scanner sc = new Scanner(System.in);
        System.out.println(ConsoleColors.BLUE + "Veuillez saisir "+ConsoleColors.RED+"1 "+ConsoleColors.BLUE+"pour jouer en"+ConsoleColors.RED +" J vs J "+ ConsoleColors.BLUE +"ou "+ ConsoleColors.YELLOW +"0 "+ConsoleColors.BLUE +"pour"+ConsoleColors.YELLOW +" J vs IA" + ConsoleColors.RESET);
        while (!sc.hasNextInt()) {
            System.out.println(ConsoleColors.BLUE + "Veuillez saisir 1 pour rejouer ou 0 pour quitter");
            sc.next();
        }
        in = sc.nextInt();
        return in == 1;
    }

    /**
     * Clear screen.
     */
    public void clearScreen() {
        for (int i = 0; i < 100; ++i) System.out.println();
    }

    /**
     * Rejouer boolean.
     *
     * @return the boolean
     */
    public boolean rejouer() {
        Scanner sc = new Scanner(System.in);
        System.out.println(ConsoleColors.BLUE + "Veuillez saisir 1 pour rejouer ou 0 pour quitter");
        while (!sc.hasNextInt()) {
            System.out.println(ConsoleColors.BLUE + "Veuillez saisir 1 pour rejouer ou 0 pour quitter");
            sc.next();
        }
        in = sc.nextInt();
        return in == 1;
    }

/*    public String strategie() {
        Scanner sc = new Scanner(System.in);
        System.out.println(ConsoleColors.BLUE + "Veuillez saisir 1 pour utiliser ou 0 pour quitter");
        while (!sc.hasNextInt()) {
            System.out.println(ConsoleColors.BLUE + "Veuillez saisir 1 pour rejouer ou 0 pour quitter");
            sc.next();
        }
        in = sc.nextInt();
        return in == 1;
    }*/


    /**
     * Resultat.
     *
     * @param joueur1 the joueur 1
     * @param joueur2 the joueur 2
     */
    public void resultat(Joueur joueur1, Joueur joueur2) {
        clearScreen();
/*      System.out.println(ConsoleColors.BLUE + joueur1.getNom());
        System.out.println(ConsoleColors.PURPLE + joueur1.getNbPartiesGagées() + " Victoire(s)");
        System.out.println(ConsoleColors.BLUE + joueur2.getNom());
        System.out.println(ConsoleColors.PURPLE + joueur1.getNbPartiesGagées() + " Victoire(s)");*/

        String[] headers = { "Nom", "Victoire" };
        String[][] data = {
                { joueur1.getNom(), String.valueOf(joueur1.getNbPartiesGagées())},
                { joueur2.getNom(), String.valueOf(joueur2.getNbPartiesGagées())},
        };
        System.out.println(FlipTable.of(headers, data));

        if (joueur1.getNbPartiesGagées() > joueur2.getNbPartiesGagées()) {
            gagner(joueur1.getNom());
        } else {
            gagner(joueur2.getNom());
        }
    }
}
