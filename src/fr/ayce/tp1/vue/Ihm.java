package fr.ayce.tp1.vue;

import fr.ayce.tp1.ConsoleColors;
import fr.ayce.tp1.modele.Coup;
import fr.ayce.tp1.modele.Joueur;
import fr.ayce.tp1.modele.Partie;

import java.util.Arrays;
import java.util.Scanner;

public class Ihm {
    private String str;
    private int in;
    private String[] tabStr;
    private Coup c = new Coup();

    public Ihm() {

    }
    public String nomJoueur(String s) {
        Scanner sc = new Scanner(System.in);
        System.out.println(ConsoleColors.BLUE + "Veuillez saisir un nom de joueur "+ s +":");
        while (!sc.hasNext()) {
            sc.next();
        }
        str = sc.nextLine();
        return str;
    }
    public int nbLignes() {
        Scanner sc = new Scanner(System.in);
        System.out.println(ConsoleColors.BLUE + "Veuillez saisir nombre de ligne :");
        while (!sc.hasNextInt() && sc.nextInt() > 0) {
            System.out.println(ConsoleColors.RED +"Veuillez saisir nombre de ligne valide:");
            sc.next();
        }
        in = sc.nextInt();
        return in;
    }
    public void affiche(int[][] tab) {
        System.out.println(ConsoleColors.RED + Arrays.deepToString(tab)
                .replace("], ", "\n")
                .replace("[[", "")
                .replace("]]", "")
                .replace("0","|")
                .replace("[","")
                .replace(",","")
                .replace(" 1", "")
                .replace("1 ", "")
                .replace("1", "")+ ConsoleColors.RESET);
        //System.out.println(Arrays.deepToString(tab));
    }
    public void gagner(String s) {
        clearScreen();
        System.out.println(s + " gagne ! \uD83C\uDF8A \uD83C\uDF89 ");
    }
    public void joue(Partie partie) {
        Coup c = new Coup();
        Scanner sc = new Scanner(System.in);
        System.out.println(ConsoleColors.YELLOW + partie.getJoueur().getNom() + " : à vous de jouer un coup" + ConsoleColors.RESET);

        System.out.println(ConsoleColors.BLUE + "Veuillez saisir un coup sous la forme 'm n' où m est la ligne choisie et n le nombre d'allumettes à retirer sur cette ligne"+ ConsoleColors.RESET);
        while (!sc.hasNext() && !c.isValide(sc.nextLine(),partie)) {
            System.out.println(ConsoleColors.RED +"Veuillez saisir un coup valide, Ex : 1 2:" + ConsoleColors.RESET);
            sc.next();
        }
        str = sc.nextLine();
        tabStr = str.split(" ");
        c.setLigne(Integer.parseInt(tabStr[0]));
        c.setNbAllumettes(Integer.parseInt(tabStr[1]));
        partie.coup(c);
        clearScreen();
    }

    public void clearScreen() {
        for (int i = 0; i < 100; ++i) System.out.println();
    }

    public boolean rejouer() {
        Scanner sc = new Scanner(System.in);
        System.out.println(ConsoleColors.BLUE + "Veuillez saisir 1 pour rejouer ou 0 pour quitter");
        while (!sc.hasNextInt() && sc.nextInt() > 0) {
            System.out.println(ConsoleColors.BLUE + "Veuillez saisir 1 pour rejouer ou 0 pour quitter");
            sc.next();
        }
        in = sc.nextInt();
        return in == 1;
    }

    public void resultat(Joueur joueur1, Joueur joueur2) {
        clearScreen();
        System.out.println(ConsoleColors.BLUE + joueur1.getNom());
        System.out.println(ConsoleColors.PURPLE + joueur1.getNbPartiesGagées() + " Victoire(s)");

        System.out.println(ConsoleColors.BLUE + joueur2.getNom());
        System.out.println(ConsoleColors.PURPLE + joueur1.getNbPartiesGagées() + " Victoire(s)");
    }
}
