package fr.ayce.tp1.vue;

import com.jakewharton.fliptables.FlipTable;
import fr.ayce.tp1.ConsoleColors;
import fr.ayce.tp1.modele.Coup;
import fr.ayce.tp1.modele.Joueur;

import java.util.Scanner;

/**
 * The type Ihm.
 */
public class Ihm {
    private String str;
    private int in;

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
        while (nbl <= 0 || nbl > 5) {
            System.out.println(ConsoleColors.BLUE + "Veuillez saisir nombre de ligne :");
            if (sc.hasNextInt()) {
                nbl = sc.nextInt();
                if (nbl <= 0 || nbl > 5) {
                    System.out.println(ConsoleColors.RED + "Il est nécessaire de saisir un nombre de ligne supérieur à 0 et inférieure à 6:");
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
/*        System.out.println(ConsoleColors.RED + Arrays.deepToString(tab)
                .replace("], ", "\n")
                .replace("[[", "")
                .replace("]]", "")
                .replace("0","|")
                .replace("[","")
                .replace(",","")
                .replace(" 1", "")
                .replace("1 ", "")
                .replace("1", "")+ ConsoleColors.RESET);
        System.out.println();*/
        System.out.print("   ");
for (int i = 1;i <= tab.length*2-1;i++) {
    System.out.print(ConsoleColors.PURPLE + i + " ");
}
        System.out.println();
int i = 1;
        for (int[] ta: tab) {
            System.out.print(ConsoleColors.PURPLE + i + " ");
            for (int t : ta) {
                if (t == 0) {
                    System.out.print(ConsoleColors.RED + "| ");
                }
            }
            System.out.println();
            i++;
        }
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
        //str = sc.nextLine();
        //String[] tabStr = str.split(" ");
        /*
        while (!str.matches("\\d+ \\d+")) {
            System.out.println(ConsoleColors.RED +"Veuillez saisir un coup valide, Ex : 1 2:" + ConsoleColors.RESET);
            str = sc.nextLine();
            tabStr = str.split(" ");
            c.setLigne(Integer.parseInt(tabStr[0]));
            c.setNbAllumettes(Integer.parseInt(tabStr[1]));
        }
        c.setLigne(Integer.parseInt(tabStr[0]));
        c.setNbAllumettes(Integer.parseInt(tabStr[1]));*/
        boolean valide = false;
        int ligne = 0;
        int nbAllu = 0;
        while (!valide) {
            if (sc.hasNextInt()) {
              ligne = sc.nextInt();
              if (sc.hasNextInt()) {
                nbAllu = sc.nextInt();
                valide = true;
              } else {
                  System.out.println(ConsoleColors.RED +"Veuillez saisir un coup valide, Ex : 1 2:" + ConsoleColors.RESET);
                  sc.nextLine();
              }
            } else {
                System.out.println(ConsoleColors.RED +"Veuillez saisir un coup valide, Ex : 1 2:" + ConsoleColors.RESET);
                sc.nextLine();
            }
        }
        c.setLigne(ligne);
        c.setNbAllumettes(nbAllu);
        return c;
    }

    /**
     * Invalide coup.
     */
    public void invalideCoup(String s) {
        System.out.println(ConsoleColors.RED +"Veuillez saisir un coup valide, Ex : 1 2:" + ConsoleColors.RESET);
        System.out.println(s);
    }

    /**
     * Ia boolean.
     *
     * @return the boolean
     */
    public int IA() {
        Scanner sc = new Scanner(System.in);
        String x = ConsoleColors.BLUE + "Veuillez saisir "+ ConsoleColors.RED +"1 "+ConsoleColors.BLUE+"pour jouer en"+ConsoleColors.RED +" J vs J "
                + ConsoleColors.BLUE +"ou "+ ConsoleColors.YELLOW +"0 "+ConsoleColors.BLUE +"pour"+ConsoleColors.YELLOW +" J vs IA"
                + ConsoleColors.BLUE + " ou " +  ConsoleColors.PURPLE + "3 " + ConsoleColors.BLUE +"pour " + ConsoleColors.PURPLE +"IA vs IA "
                + ConsoleColors.BLUE + "ou " + ConsoleColors.GREEN + "4 "+ ConsoleColors.BLUE + "pour " + ConsoleColors.GREEN + "IAN vs IAN "
                + ConsoleColors.BLUE + "ou " + ConsoleColors.CYAN + "5 "+ ConsoleColors.BLUE + "pour " + ConsoleColors.CYAN + "IAN vs IA"
                + ConsoleColors.BLUE + "." + ConsoleColors.RESET;
        System.out.println(x);
        while (!sc.hasNextInt()) {
            System.out.println(x);
            sc.next();
        }
        in = sc.nextInt();
        return in;
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

        public boolean contrainte() {
        Scanner sc = new Scanner(System.in);
        String x = ConsoleColors.BLUE + "Veuillez saisir 1 pour utiliser la contrainte de 3 allumettes maximum ou 0 sinon";
        System.out.println(x);
        while (!sc.hasNextInt()) {
            System.out.println(x);
            sc.next();
        }
        in = sc.nextInt();
        return in == 1;
    }

/*    public boolean strategie() {
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
                { joueur1.getNom(), String.valueOf(joueur1.getNbPartiesGagees())},
                { joueur2.getNom(), String.valueOf(joueur2.getNbPartiesGagees())},
        };
        System.out.println(FlipTable.of(headers, data));

        if (joueur1.getNbPartiesGagees() > joueur2.getNbPartiesGagees()) {
            gagner(joueur1.getNom());
        } else {
            gagner(joueur2.getNom());
        }
    }
}
